package fr.mcc.ginco.services;

import static org.junit.Assert.assertNull;

import fr.mcc.ginco.dao.IConceptHierarchicalRelationshipDAO;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
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
	public void getByChildAndParentIdsReturnsNull() {
		assertNull(service.getByChildAndParentIds("1234", "1234"));
	}
}
