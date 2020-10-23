package fr.mcc.ginco.services;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.when;

import fr.mcc.ginco.beans.AssociativeRelationship;
import fr.mcc.ginco.beans.AssociativeRelationshipRole;
import fr.mcc.ginco.beans.ThesaurusConcept;
import fr.mcc.ginco.dao.IAssociativeRelationshipDAO;
import fr.mcc.ginco.enums.ConceptStatusEnum;

import java.util.ArrayList;
import java.util.List;

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
	public void getAssociativeRelationshipById() {

		// arrange
		AssociativeRelationship associativeRelationship =
			 new AssociativeRelationship();
		ThesaurusConcept conceptLeft = new ThesaurusConcept();
		associativeRelationship.setConceptLeft(conceptLeft);
		ThesaurusConcept conceptRight = new ThesaurusConcept();
		associativeRelationship.setConceptRight(conceptRight);
		AssociativeRelationship.Id identifier11 = new AssociativeRelationship.Id();
		associativeRelationship.setIdentifier(identifier11);
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
		assertSame(identifier11, result.getIdentifier());
		assertSame(relationshipRole, result.getRelationshipRole());
	}

	@Test
	public void getAssociatedConceptsIdStatusIsCandidate() {
		List<String> list = new ArrayList<String>();
		list.add("foo");
		when(associativeRelationshipDAO.getAssociatedConcepts(Mockito.<ThesaurusConcept>any(), Mockito.<ConceptStatusEnum>any()))
			.thenReturn(list);
		assertEquals(1, service.getAssociatedConceptsId(new ThesaurusConcept(), ConceptStatusEnum.CANDIDATE).size());
		assertEquals("foo", service.getAssociatedConceptsId(new ThesaurusConcept(), ConceptStatusEnum.CANDIDATE).get(0));
	}

	@Test
	public void getAssociatedConceptsId() {
		List<String> list = new ArrayList<String>();
		list.add("foo");
		when(associativeRelationshipDAO.getAssociatedConcepts(Mockito.<ThesaurusConcept>any()))
			.thenReturn(list);
		assertEquals(1, service.getAssociatedConceptsId(new ThesaurusConcept()).size());
		assertEquals("foo", service.getAssociatedConceptsId(new ThesaurusConcept()).get(0));
	}

	@Test
	public void getAssociatedConceptsRelationships() {

		// arrange
		List<AssociativeRelationship> list =
			 new ArrayList<AssociativeRelationship>();
		AssociativeRelationship associativeRelationship =
			 new AssociativeRelationship();
		list.add(associativeRelationship);
		when(associativeRelationshipDAO.getAssociationsForConcept(Mockito.<ThesaurusConcept>any()))
			.thenReturn(list);

		// act
		List<AssociativeRelationship> result =
			 service.getAssociatedConceptsRelationships(new ThesaurusConcept());

		// assert
		assertEquals(1, result.size());
		assertSame(associativeRelationship, result.get(0));
	}
}
