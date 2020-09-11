package fr.mcc.ginco.services;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import fr.mcc.ginco.beans.ThesaurusConcept;
import fr.mcc.ginco.dao.IAssociativeRelationshipDAO;
import fr.mcc.ginco.enums.ConceptStatusEnum;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

/**
 * Unit tests for fr.mcc.ginco.services.AssociativeRelationshipServiceImpl
 *
 * @author Diffblue Cover
 */

public class AssociativeRelationshipServiceImplTest {

	@Mock(name = "associativeRelationshipDAO")
	private IAssociativeRelationshipDAO associativeRelationshipDAO;

	@InjectMocks
	private AssociativeRelationshipServiceImpl service;

	@Before public void initMocks() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void getAssociatedConceptsId() {
		when(associativeRelationshipDAO.getAssociatedConcepts(Mockito.<ThesaurusConcept>any()))
			.thenReturn(new ArrayList<String>());
		assertTrue((service.getAssociatedConceptsId(new ThesaurusConcept())).isEmpty());
	}

	@Test
	public void getAssociatedConceptsIdStatusIsCandidate() {
		when(associativeRelationshipDAO.getAssociatedConcepts(Mockito.<ThesaurusConcept>any(), Mockito.<ConceptStatusEnum>any()))
			.thenReturn(new ArrayList<String>());
		assertTrue((service.getAssociatedConceptsId(new ThesaurusConcept(), ConceptStatusEnum.CANDIDATE)).isEmpty());
	}
}
