package fr.mcc.ginco.imports.ginco;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import fr.mcc.ginco.beans.ConceptHierarchicalRelationship;
import fr.mcc.ginco.beans.ThesaurusConcept;
import fr.mcc.ginco.dao.IAssociativeRelationshipDAO;
import fr.mcc.ginco.dao.IAssociativeRelationshipRoleDAO;
import fr.mcc.ginco.dao.IConceptHierarchicalRelationshipDAO;
import fr.mcc.ginco.dao.IThesaurusConceptDAO;
import fr.mcc.ginco.exports.result.bean.GincoExportedThesaurus;
import fr.mcc.ginco.exports.result.bean.JaxbList;
import fr.mcc.ginco.services.IConceptHierarchicalRelationshipServiceUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
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
	public void storeHierarchicalRelationship() {

		// arrange
		ThesaurusConcept thesaurusConcept3 = new ThesaurusConcept();
		when(thesaurusConceptDAO.getById(Mockito.<String>any()))
			.thenReturn(thesaurusConcept3)
			.thenReturn(new ThesaurusConcept());
		when(thesaurusConceptDAO.update(Mockito.<ThesaurusConcept>any()))
			.thenReturn(new ThesaurusConcept());
		when(conceptHierarchicalRelationshipServiceUtil.getRootConcepts(Mockito.<ThesaurusConcept>any()))
			.thenReturn(new ArrayList<ThesaurusConcept>());
		when(conceptHierarchicalRelationshipDAO.update(Mockito.<ConceptHierarchicalRelationship>any()))
			.thenReturn(new ConceptHierarchicalRelationship());
		HashMap<String, JaxbList<ConceptHierarchicalRelationship>> relationsToImport =
			 new HashMap<String, JaxbList<ConceptHierarchicalRelationship>>();
		ArrayList<ConceptHierarchicalRelationship> list =
			 new ArrayList<ConceptHierarchicalRelationship>();
		ConceptHierarchicalRelationship conceptHierarchicalRelationship2 =
			 new ConceptHierarchicalRelationship();
		conceptHierarchicalRelationship2.setIdentifier(new ConceptHierarchicalRelationship.Id());
		list.add(conceptHierarchicalRelationship2);
		relationsToImport.put("", new JaxbList<ConceptHierarchicalRelationship>(list));

		// act
		List<ThesaurusConcept> result =
			 service.storeHierarchicalRelationship(relationsToImport);

		// assert
		assertEquals(1, result.size());
		assertSame(thesaurusConcept3, result.get(0));
	}

	@Test
	public void storeHierarchicalRelationshipRelationsToImportIsEmpty() {
		assertTrue(service.storeHierarchicalRelationship(new HashMap<String, JaxbList<ConceptHierarchicalRelationship>>()).isEmpty());
	}

	@Test
	public void storeHierarchicalRelationshipRelationsToImportIsNull() {
		assertTrue(service.storeHierarchicalRelationship(null).isEmpty());
	}

	@Test
	public void storeAssociativeRelationshipReturnsEmpty() {
		assertTrue(service.storeAssociativeRelationship(new GincoExportedThesaurus()).isEmpty());
	}
}
