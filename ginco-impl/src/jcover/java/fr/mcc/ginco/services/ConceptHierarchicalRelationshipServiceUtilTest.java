package fr.mcc.ginco.services;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.when;

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
	public void calculateChildrenRoots() {
		when(thesaurusConceptDAO.getChildrenConcepts(Mockito.<String>any(), anyInt(), Mockito.<String>any()))
			.thenReturn(new ArrayList<ThesaurusConcept>());
		service.calculateChildrenRoots("1234", "1234");
	}

	@Test
	public void getRootConceptsReturnsEmpty() {
		assertTrue((service.getRootConcepts(new ThesaurusConcept())).isEmpty());
	}
}
