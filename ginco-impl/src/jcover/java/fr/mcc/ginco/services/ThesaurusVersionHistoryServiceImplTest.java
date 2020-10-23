package fr.mcc.ginco.services;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
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

	@Before public void initMocks() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void getVersionsByThesaurusId() {

		// arrange
		List<ThesaurusVersionHistory> list =
			 new ArrayList<ThesaurusVersionHistory>();
		ThesaurusVersionHistory thesaurusVersionHistory =
			 new ThesaurusVersionHistory();
		list.add(thesaurusVersionHistory);
		when(thesaurusVersionHistoryDAO.findVersionsByThesaurusId(Mockito.<String>any()))
			.thenReturn(list);

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
		List<ThesaurusVersionHistory> list =
			 new ArrayList<ThesaurusVersionHistory>();
		ThesaurusVersionHistory thesaurusVersionHistory =
			 new ThesaurusVersionHistory();
		thesaurusVersionHistory.setStatus(1);
		list.add(thesaurusVersionHistory);
		when(thesaurusVersionHistoryDAO.findVersionsByThesaurusId(Mockito.<String>any()))
			.thenReturn(list);
		assertFalse(service.hasPublishedVersion(new Thesaurus()));
	}

	@Test
	public void publishThesaurus1() throws java.text.ParseException {

		// arrange
		ThesaurusVersionHistory thesaurusVersionHistory1 =
			 new ThesaurusVersionHistory();
		Date date3 = new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31");
		thesaurusVersionHistory1.setDate(date3);
		thesaurusVersionHistory1.setIdentifier("data");
		thesaurusVersionHistory1.setStatus(1);
		Thesaurus thesaurus1 = mock(Thesaurus.class);
		thesaurusVersionHistory1.setThesaurus(thesaurus1);
		thesaurusVersionHistory1.setThisVersion(false);
		thesaurusVersionHistory1.setUserId("root");
		thesaurusVersionHistory1.setVersionNote("1.0");
		List<ThesaurusVersionHistory> list =
			 new ArrayList<ThesaurusVersionHistory>();
		list.add(new ThesaurusVersionHistory());
		when(thesaurusVersionHistoryDAO.findAllOtherThisVersionTrueByThesaurusId(Mockito.<String>any(), Mockito.<String>any()))
			.thenReturn(list);
		when(thesaurusVersionHistoryDAO.update(Mockito.<ThesaurusVersionHistory>any()))
			.thenReturn(thesaurusVersionHistory1);
		when(generatorService.generate(Mockito.<Class>any()))
			.thenReturn("foo");

		// act
		ThesaurusVersionHistory result =
			 service.publishThesaurus(new Thesaurus(), "root");

		// assert
		assertSame(date3, result.getDate());
		assertEquals("data", result.getIdentifier());
		assertEquals(1, (int) result.getStatus());
		assertSame(thesaurus1, result.getThesaurus());
		assertFalse(result.getThisVersion());
		assertEquals("root", result.getUserId());
		assertEquals("1.0", result.getVersionNote());
	}

	@Test
	public void publishThesaurus2() throws java.text.ParseException {

		// arrange
		ThesaurusVersionHistory thesaurusVersionHistory =
			 new ThesaurusVersionHistory();
		Date date3 = new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31");
		thesaurusVersionHistory.setDate(date3);
		thesaurusVersionHistory.setIdentifier("data");
		thesaurusVersionHistory.setStatus(1);
		Thesaurus thesaurus1 = new Thesaurus();
		thesaurusVersionHistory.setThesaurus(thesaurus1);
		thesaurusVersionHistory.setThisVersion(false);
		thesaurusVersionHistory.setUserId("root");
		thesaurusVersionHistory.setVersionNote("1.0");
		when(thesaurusVersionHistoryDAO.findAllOtherThisVersionTrueByThesaurusId(Mockito.<String>any(), Mockito.<String>any()))
			.thenReturn(new ArrayList<ThesaurusVersionHistory>());
		when(thesaurusVersionHistoryDAO.update(Mockito.<ThesaurusVersionHistory>any()))
			.thenReturn(thesaurusVersionHistory);
		when(generatorService.generate(Mockito.<Class>any()))
			.thenReturn("foo");

		// act
		ThesaurusVersionHistory result =
			 service.publishThesaurus(new Thesaurus(), "root");

		// assert
		assertSame(date3, result.getDate());
		assertEquals("data", result.getIdentifier());
		assertEquals(1, (int) result.getStatus());
		assertSame(thesaurus1, result.getThesaurus());
		assertFalse(result.getThisVersion());
		assertEquals("root", result.getUserId());
		assertEquals("1.0", result.getVersionNote());
	}

	@Test
	public void createOrUpdateVersion() throws java.text.ParseException {

		// arrange
		ThesaurusVersionHistory thesaurusVersionHistory1 =
			 new ThesaurusVersionHistory();
		Date date3 = new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31");
		thesaurusVersionHistory1.setDate(date3);
		thesaurusVersionHistory1.setIdentifier("data");
		thesaurusVersionHistory1.setStatus(1);
		Thesaurus thesaurus1 = mock(Thesaurus.class);
		thesaurusVersionHistory1.setThesaurus(thesaurus1);
		thesaurusVersionHistory1.setThisVersion(false);
		thesaurusVersionHistory1.setUserId("root");
		thesaurusVersionHistory1.setVersionNote("1.0");
		when(thesaurusVersionHistoryDAO.findThisVersionByThesaurusId(Mockito.<String>any()))
			.thenReturn(new ThesaurusVersionHistory());
		when(thesaurusVersionHistoryDAO.update(Mockito.<ThesaurusVersionHistory>any()))
			.thenReturn(thesaurusVersionHistory1);
		ThesaurusVersionHistory version = new ThesaurusVersionHistory();
		version.setThesaurus(new Thesaurus());
		version.setThisVersion(false);

		// act
		ThesaurusVersionHistory result = service.createOrUpdateVersion(version);

		// assert
		assertSame(date3, result.getDate());
		assertEquals("data", result.getIdentifier());
		assertEquals(1, (int) result.getStatus());
		assertSame(thesaurus1, result.getThesaurus());
		assertFalse(result.getThisVersion());
		assertEquals("root", result.getUserId());
		assertEquals("1.0", result.getVersionNote());
	}
}
