package fr.mcc.ginco.services;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import fr.mcc.ginco.beans.Thesaurus;
import fr.mcc.ginco.dao.IThesaurusDAO;
import fr.mcc.ginco.dao.IThesaurusVersionHistoryDAO;
import fr.mcc.ginco.exports.IGincoThesaurusExportService;
import fr.mcc.ginco.exports.ISKOSExportService;
import fr.mcc.ginco.helpers.ThesaurusHelper;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

/**
 * Unit tests for fr.mcc.ginco.services.ThesaurusServiceImpl
 *
 * @author Diffblue Cover
 */

public class ThesaurusServiceImplTest {

	@Mock(name = "gincoThesaurusExportService")
	private IGincoThesaurusExportService gincoThesaurusExportService;

	@Mock(name = "skosExportService")
	private ISKOSExportService skosExportService;

	@Mock(name = "thesaurusDAO")
	private IThesaurusDAO thesaurusDAO;

	@Mock(name = "thesaurusHelper")
	private ThesaurusHelper thesaurusHelper;

	@Mock(name = "thesaurusVersionHistoryDAO")
	private IThesaurusVersionHistoryDAO thesaurusVersionHistoryDAO;

	@InjectMocks
	private ThesaurusServiceImpl service;

	@Before public void initMocks() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void getDefaultThesaurus() throws fr.mcc.ginco.exceptions.TechnicalException {
		Thesaurus result = service.getDefaultThesaurus();
		assertEquals("default.thesaurus.creator.contributor", result.getContributor());
		assertEquals("default.thesaurus.coverage", result.getCoverage());
		assertNull(result.getCreated());
		assertEquals("default.thesaurus.creator.email", result.getCreator().getEmail());
		assertEquals("default.thesaurus.creator.homepage", result.getCreator().getHomepage());
		assertNull(result.getCreator().getIdentifier());
		assertEquals("default.thesaurus.creator.name", result.getCreator().getName());
		assertNull(result.getDate());
		assertEquals("default.thesaurus.description", result.getDescription());
		assertTrue((result.getFormat()).isEmpty());
		assertNull(result.getIdentifier());
		assertTrue((result.getLang()).isEmpty());
		assertEquals("default.thesaurus.publisher", result.getPublisher());
		assertNull(result.getRelation());
		assertEquals("default.thesaurus.rights", result.getRights());
		assertEquals("", result.getSource());
		assertEquals("default.thesaurus.subject", result.getSubject());
		assertNull(result.getThesaurusId());
		assertEquals("default.thesaurus.title", result.getTitle());
		assertNull(result.getType());
		assertNull(result.getVersions());
		assertNull(result.isArchived());
		assertNull(result.isDefaultTopConcept());
		assertNull(result.isPolyHierarchical());
	}
}
