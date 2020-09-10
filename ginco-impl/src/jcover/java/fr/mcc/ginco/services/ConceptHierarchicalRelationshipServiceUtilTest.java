package fr.mcc.ginco.services;

import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.when;

import fr.mcc.ginco.beans.ConceptHierarchicalRelationship;
import fr.mcc.ginco.beans.ThesaurusConcept;
import fr.mcc.ginco.dao.IConceptHierarchicalRelationshipDAO;
import fr.mcc.ginco.dao.IThesaurusArrayConceptDAO;
import fr.mcc.ginco.dao.IThesaurusConceptDAO;
import fr.mcc.ginco.dao.IThesaurusTermDAO;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

/**
 * Unit tests for fr.mcc.ginco.services.ConceptHierarchicalRelationshipServiceUtil
 *
 * @author Diffblue Cover
 */

public class ConceptHierarchicalRelationshipServiceUtilTest {

	@Mock(name = "conceptHierarchicalRelationshipDAO")
	private IConceptHierarchicalRelationshipDAO conceptHierarchicalRelationshipDAO;

	@Mock(name = "thesaurusArrayConceptDAO")
	private IThesaurusArrayConceptDAO thesaurusArrayConceptDAO;

	@Mock(name = "thesaurusConceptDAO")
	private IThesaurusConceptDAO thesaurusConceptDAO;

	@Mock(name = "thesaurusTermDAO")
	private IThesaurusTermDAO thesaurusTermDAO;

	@InjectMocks
	private ConceptHierarchicalRelationshipServiceUtil service;

	@Before public void initMocks() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void getRootConceptsReturnsEmpty() {
		assertTrue((service.getRootConcepts(new ThesaurusConcept())).isEmpty());
	}

	@Test
	public void saveHierarchicalRelationship1() {
		when(thesaurusConceptDAO.getChildrenConcepts(Mockito.<String>any(), anyInt(), Mockito.<String>any()))
			.thenReturn(new ArrayList<ThesaurusConcept>());
		ThesaurusConcept conceptToUpdate = new ThesaurusConcept();
		assertSame(conceptToUpdate, service.saveHierarchicalRelationship(conceptToUpdate, new ArrayList<ConceptHierarchicalRelationship>(), new ArrayList<ThesaurusConcept>(), new ArrayList<ThesaurusConcept>(), new ArrayList<ThesaurusConcept>(), new ArrayList<ThesaurusConcept>()));
		Mockito.verify(thesaurusConceptDAO).flush();
	}

	@Test
	public void saveHierarchicalRelationship2() {
		when(thesaurusConceptDAO.getChildrenConcepts(Mockito.<String>any(), anyInt(), Mockito.<String>any()))
			.thenReturn(new ArrayList<ThesaurusConcept>());
		ThesaurusConcept conceptToUpdate = new ThesaurusConcept();
		ArrayList<ThesaurusConcept> allRecursiveParents = new ArrayList<ThesaurusConcept>();
		allRecursiveParents.add(new ThesaurusConcept());
		assertSame(conceptToUpdate, service.saveHierarchicalRelationship(conceptToUpdate, new ArrayList<ConceptHierarchicalRelationship>(), allRecursiveParents, new ArrayList<ThesaurusConcept>(), new ArrayList<ThesaurusConcept>(), new ArrayList<ThesaurusConcept>()));
		Mockito.verify(thesaurusConceptDAO).flush();
	}

	@Test
	public void saveHierarchicalRelationship3() {
		when(thesaurusConceptDAO.getChildrenConcepts(Mockito.<String>any(), anyInt(), Mockito.<String>any()))
			.thenReturn(new ArrayList<ThesaurusConcept>());
		ThesaurusConcept conceptToUpdate = new ThesaurusConcept();
		ArrayList<ThesaurusConcept> allRecursiveChilds = new ArrayList<ThesaurusConcept>();
		allRecursiveChilds.add(new ThesaurusConcept());
		assertSame(conceptToUpdate, service.saveHierarchicalRelationship(conceptToUpdate, new ArrayList<ConceptHierarchicalRelationship>(), new ArrayList<ThesaurusConcept>(), allRecursiveChilds, new ArrayList<ThesaurusConcept>(), new ArrayList<ThesaurusConcept>()));
		Mockito.verify(thesaurusConceptDAO).flush();
	}
}
