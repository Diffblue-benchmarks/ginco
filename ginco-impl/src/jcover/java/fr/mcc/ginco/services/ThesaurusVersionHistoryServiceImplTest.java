package fr.mcc.ginco.services;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.when;

import fr.mcc.ginco.ark.IIDGeneratorService;
import fr.mcc.ginco.beans.Thesaurus;
import fr.mcc.ginco.beans.ThesaurusVersionHistory;
import fr.mcc.ginco.dao.IThesaurusVersionHistoryDAO;

import java.util.ArrayList;
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
	public void hasPublishedVersionReturnsFalse() {
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
}
