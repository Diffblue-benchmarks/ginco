package fr.mcc.ginco.imports.ginco;

import static org.junit.Assert.assertTrue;

import fr.mcc.ginco.dao.IAssociativeRelationshipDAO;
import fr.mcc.ginco.dao.IAssociativeRelationshipRoleDAO;
import fr.mcc.ginco.dao.IConceptHierarchicalRelationshipDAO;
import fr.mcc.ginco.dao.IThesaurusConceptDAO;
import fr.mcc.ginco.exports.result.bean.GincoExportedThesaurus;
import fr.mcc.ginco.services.IConceptHierarchicalRelationshipServiceUtil;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

/**
 * Unit tests for fr.mcc.ginco.imports.ginco.GincoRelationshipImporter
 *
 * @author Diffblue Cover
 */

public class GincoRelationshipImporterTest {

	@Mock(name = "associativeRelationshipDAO")
	private IAssociativeRelationshipDAO associativeRelationshipDAO;

	@Mock(name = "associativeRelationshipRoleDAO")
	private IAssociativeRelationshipRoleDAO associativeRelationshipRoleDAO;

	@Mock(name = "conceptHierarchicalRelationshipDAO")
	private IConceptHierarchicalRelationshipDAO conceptHierarchicalRelationshipDAO;

	@Mock(name = "conceptHierarchicalRelationshipServiceUtil")
	private IConceptHierarchicalRelationshipServiceUtil conceptHierarchicalRelationshipServiceUtil;

	@Mock(name = "thesaurusConceptDAO")
	private IThesaurusConceptDAO thesaurusConceptDAO;

	@InjectMocks
	private GincoRelationshipImporter service;

	@Before public void initMocks() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void storeAssociativeRelationshipReturnsEmpty() {
		assertTrue((service.storeAssociativeRelationship(new GincoExportedThesaurus())).isEmpty());
	}

	@Test
	public void storeHierarchicalRelationshipRelationsToImportIsNullReturnsEmpty() {
		assertTrue((service.storeHierarchicalRelationship(null)).isEmpty());
	}
}
