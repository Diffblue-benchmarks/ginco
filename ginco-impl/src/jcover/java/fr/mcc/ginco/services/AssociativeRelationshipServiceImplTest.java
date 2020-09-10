package fr.mcc.ginco.services;

import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import fr.mcc.ginco.beans.AssociativeRelationship;
import fr.mcc.ginco.beans.AssociativeRelationshipRole;
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
	public void getAssociatedConceptsIdStatusIsCANDIDATE() {
		when(associativeRelationshipDAO.getAssociatedConcepts(Mockito.<ThesaurusConcept>any(), Mockito.<ConceptStatusEnum>any()))
			.thenReturn(new ArrayList<String>());
		assertTrue((service.getAssociatedConceptsId(new ThesaurusConcept(), ConceptStatusEnum.CANDIDATE)).isEmpty());
	}

	@Test
	public void getAssociatedConceptsRelationshipsReturnsEmpty() {
		when(associativeRelationshipDAO.getAssociationsForConcept(Mockito.<ThesaurusConcept>any()))
			.thenReturn(new ArrayList<AssociativeRelationship>());
		assertTrue((service.getAssociatedConceptsRelationships(new ThesaurusConcept())).isEmpty());
	}

	@Test
	public void getAssociativeRelationshipById() {

		// arrange
		AssociativeRelationship associativeRelationship =
			 new AssociativeRelationship();
		ThesaurusConcept conceptLeft = new ThesaurusConcept();
		associativeRelationship.setConceptLeft(conceptLeft);
		ThesaurusConcept conceptRight = new ThesaurusConcept();
		associativeRelationship.setConceptRight(conceptRight);
		AssociativeRelationship.Id identifier3 = new AssociativeRelationship.Id();
		associativeRelationship.setIdentifier(identifier3);
		AssociativeRelationshipRole relationshipRole =
			 new AssociativeRelationshipRole();
		associativeRelationship.setRelationshipRole(relationshipRole);
		when(associativeRelationshipDAO.getAssociativeRelationship(Mockito.<String>any(), Mockito.<String>any()))
			.thenReturn(associativeRelationship);

		// act
		AssociativeRelationship result =
			 service.getAssociativeRelationshipById("1234", "1234");

		// assert
		assertSame(conceptLeft, result.getConceptLeft());
		assertSame(conceptRight, result.getConceptRight());
		assertSame(identifier3, result.getIdentifier());
		assertSame(relationshipRole, result.getRelationshipRole());
	}
}
