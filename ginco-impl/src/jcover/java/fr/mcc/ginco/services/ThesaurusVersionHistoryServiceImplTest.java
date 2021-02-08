package fr.mcc.ginco.services;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import fr.mcc.ginco.ark.IIDGeneratorService;
import fr.mcc.ginco.beans.Thesaurus;
import fr.mcc.ginco.beans.ThesaurusVersionHistory;
import fr.mcc.ginco.dao.IThesaurusVersionHistoryDAO;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

/**
 * Unit tests for fr.mcc.ginco.services.ThesaurusVersionHistoryServiceImpl
 *
 * @author Diffblue Cover
 */

public class ThesaurusVersionHistoryServiceImplTest {

	@Mock(name = "generatorService")
	private IIDGeneratorService generatorService;

	@Mock(name = "thesaurusVersionHistoryDAO")
	private IThesaurusVersionHistoryDAO thesaurusVersionHistoryDAO;

	@InjectMocks
	private ThesaurusVersionHistoryServiceImpl service;

	@Before
	public void initMocks() throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		MockitoAnnotations.initMocks(this);
		ThesaurusVersionHistoryServiceImpl bean = service;
		java.lang.reflect.Field field =
			 ThesaurusVersionHistoryServiceImpl.class.getDeclaredField("publishNote");
		field.setAccessible(true);
		field.set(bean, "${publish.version.note}");
	}

	@Test
	public void getVersionsByThesaurusId() {

		// arrange
		ArrayList<ThesaurusVersionHistory> thesaurusVersionHistoryList =
			 new ArrayList<ThesaurusVersionHistory>();
		ThesaurusVersionHistory thesaurusVersionHistory =
			 new ThesaurusVersionHistory();
		thesaurusVersionHistoryList.add(thesaurusVersionHistory);
		when(thesaurusVersionHistoryDAO.findVersionsByThesaurusId(Mockito.<String>any()))
			.thenReturn(thesaurusVersionHistoryList);

		// act
		List<ThesaurusVersionHistory> result =
			 service.getVersionsByThesaurusId("1234");

		// assert
		assertEquals(1, result.size());
		assertSame(thesaurusVersionHistory, result.get(0));
	}

	@Test
	public void getThesaurusVersionHistoryById() throws java.text.ParseException {

		// arrange
		ThesaurusVersionHistory thesaurusVersionHistory =
			 new ThesaurusVersionHistory();
		Date date3 = new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31");
		thesaurusVersionHistory.setDate(date3);
		thesaurusVersionHistory.setIdentifier("data");
		thesaurusVersionHistory.setStatus(1);
		Thesaurus thesaurus = new Thesaurus();
		thesaurusVersionHistory.setThesaurus(thesaurus);
		thesaurusVersionHistory.setThisVersion(false);
		thesaurusVersionHistory.setUserId("root");
		thesaurusVersionHistory.setVersionNote("1.0");
		when(thesaurusVersionHistoryDAO.getById(Mockito.<String>any()))
			.thenReturn(thesaurusVersionHistory);

		// act
		ThesaurusVersionHistory result =
			 service.getThesaurusVersionHistoryById("1234");

		// assert
		assertSame(date3, result.getDate());
		assertEquals("data", result.getIdentifier());
		assertEquals(1, (int) result.getStatus());
		assertSame(thesaurus, result.getThesaurus());
		assertFalse(result.getThisVersion());
		assertEquals("root", result.getUserId());
		assertEquals("1.0", result.getVersionNote());
	}

	@Test
	public void hasPublishedVersion1() {
		when(thesaurusVersionHistoryDAO.findVersionsByThesaurusId(Mockito.<String>any()))
			.thenReturn(new ArrayList<ThesaurusVersionHistory>());
		assertFalse(service.hasPublishedVersion(new Thesaurus()));
	}

	@Test
	public void hasPublishedVersion2() {
		ArrayList<ThesaurusVersionHistory> thesaurusVersionHistoryList =
			 new ArrayList<ThesaurusVersionHistory>();
		ThesaurusVersionHistory thesaurusVersionHistory =
			 mock(ThesaurusVersionHistory.class);
		when(thesaurusVersionHistory.getStatus())
			.thenReturn(1);
		thesaurusVersionHistoryList.add(thesaurusVersionHistory);
		when(thesaurusVersionHistoryDAO.findVersionsByThesaurusId(Mockito.<String>any()))
			.thenReturn(thesaurusVersionHistoryList);
		assertFalse(service.hasPublishedVersion(new Thesaurus()));
	}

	@Test
	public void publishThesaurusUserIdIsRoot() {
		ThesaurusVersionHistory thesaurusVersionHistory1 =
			 mock(ThesaurusVersionHistory.class);
		ArrayList<ThesaurusVersionHistory> thesaurusVersionHistoryList =
			 new ArrayList<ThesaurusVersionHistory>();
		thesaurusVersionHistoryList.add(new ThesaurusVersionHistory());
		when(thesaurusVersionHistoryDAO.findAllOtherThisVersionTrueByThesaurusId(Mockito.<String>any(), Mockito.<String>any()))
			.thenReturn(thesaurusVersionHistoryList);
		when(thesaurusVersionHistoryDAO.update(Mockito.<ThesaurusVersionHistory>any()))
			.thenReturn(thesaurusVersionHistory1);
		when(generatorService.generate(Mockito.<Class>any()))
			.thenReturn("foo");
		assertNotNull(service.publishThesaurus(new Thesaurus(), "root"));
	}

	@Test
	public void createOrUpdateVersion() {
		ThesaurusVersionHistory thesaurusVersionHistory1 =
			 mock(ThesaurusVersionHistory.class);
		when(thesaurusVersionHistoryDAO.findThisVersionByThesaurusId(Mockito.<String>any()))
			.thenReturn(new ThesaurusVersionHistory());
		when(thesaurusVersionHistoryDAO.update(Mockito.<ThesaurusVersionHistory>any()))
			.thenReturn(thesaurusVersionHistory1);
		ThesaurusVersionHistory version = new ThesaurusVersionHistory();
		version.setThesaurus(new Thesaurus());
		version.setThisVersion(false);
		assertNotNull(service.createOrUpdateVersion(version));
	}
}
