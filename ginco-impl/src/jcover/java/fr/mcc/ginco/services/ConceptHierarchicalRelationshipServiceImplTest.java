package fr.mcc.ginco.services;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.when;

import fr.mcc.ginco.beans.ConceptHierarchicalRelationship;
import fr.mcc.ginco.dao.IConceptHierarchicalRelationshipDAO;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

/**
 * Unit tests for fr.mcc.ginco.services.ConceptHierarchicalRelationshipServiceImpl
 *
 * @author Diffblue Cover
 */

public class ConceptHierarchicalRelationshipServiceImplTest {

	@Mock(name = "conceptHierarchicalRelationshipDAO")
	private IConceptHierarchicalRelationshipDAO conceptHierarchicalRelationshipDAO;

	@InjectMocks
	private ConceptHierarchicalRelationshipServiceImpl service;

	@Before public void initMocks() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void getByChildAndParentIds() {

		// arrange
		ConceptHierarchicalRelationship conceptHierarchicalRelationship =
			 new ConceptHierarchicalRelationship();
		ConceptHierarchicalRelationship.Id identifier =
			 new ConceptHierarchicalRelationship.Id();
		conceptHierarchicalRelationship.setIdentifier(identifier);
		conceptHierarchicalRelationship.setRole(1);
		when(conceptHierarchicalRelationshipDAO.getById(Mockito.<ConceptHierarchicalRelationship.Id>any()))
			.thenReturn(conceptHierarchicalRelationship);

		// act
		ConceptHierarchicalRelationship result =
			 service.getByChildAndParentIds("1234", "1234");

		// assert
		assertSame(identifier, result.getIdentifier());
		assertEquals(1, (int) result.getRole());
	}
}
