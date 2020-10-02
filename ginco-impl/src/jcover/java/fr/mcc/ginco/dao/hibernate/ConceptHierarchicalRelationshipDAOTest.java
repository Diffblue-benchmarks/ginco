package fr.mcc.ginco.dao.hibernate;

import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.mock;

import org.hibernate.SessionFactory;
import org.junit.Test;
import org.mockito.Mockito;

/**
 * Unit tests for fr.mcc.ginco.dao.hibernate.ConceptHierarchicalRelationshipDAO
 *
 * @author Diffblue Cover
 */

public class ConceptHierarchicalRelationshipDAOTest {

	@Test
	public void factory() {
		ConceptHierarchicalRelationshipDAO conceptHierarchicalRelationshipDAO =
			 new ConceptHierarchicalRelationshipDAO();
		SessionFactory sessionFactory = mock(SessionFactory.class);
		conceptHierarchicalRelationshipDAO.setSessionFactory(sessionFactory);
		assertSame(sessionFactory, conceptHierarchicalRelationshipDAO.getSessionFactory());
	}
}
