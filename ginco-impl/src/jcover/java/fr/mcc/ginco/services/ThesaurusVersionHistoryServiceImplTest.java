package fr.mcc.ginco.services;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import fr.mcc.ginco.ark.IIDGeneratorService;
import fr.mcc.ginco.beans.Thesaurus;
import fr.mcc.ginco.beans.ThesaurusVersionHistory;
import fr.mcc.ginco.dao.IThesaurusVersionHistoryDAO;

import java.util.ArrayList;

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
	public void createOrUpdateVersionReturnsNull() {
		when(thesaurusVersionHistoryDAO.findThisVersionByThesaurusId(Mockito.<String>any()))
			.thenReturn(new ThesaurusVersionHistory());
		ThesaurusVersionHistory version = new ThesaurusVersionHistory();
		version.setThesaurus(new Thesaurus());
		version.setThisVersion(false);
		assertNull(service.createOrUpdateVersion(version));
	}

	@Test
	public void getThesaurusVersionHistoryByIdReturnsNull() {
		assertNull(service.getThesaurusVersionHistoryById("1234"));
	}

	@Test
	public void getVersionsByThesaurusIdReturnsEmpty() {
		when(thesaurusVersionHistoryDAO.findVersionsByThesaurusId(Mockito.<String>any()))
			.thenReturn(new ArrayList<ThesaurusVersionHistory>());
		assertTrue((service.getVersionsByThesaurusId("1234")).isEmpty());
	}

	@Test
	public void hasPublishedVersionReturnsFalse() {
		when(thesaurusVersionHistoryDAO.findVersionsByThesaurusId(Mockito.<String>any()))
			.thenReturn(new ArrayList<ThesaurusVersionHistory>());
		assertFalse(service.hasPublishedVersion(new Thesaurus()));
	}
}
