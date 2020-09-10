package fr.mcc.ginco.dao.hibernate;

import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.mock;

import org.hibernate.SessionFactory;
import org.junit.Test;
import org.mockito.Mockito;

/**
 * Unit tests for fr.mcc.ginco.dao.hibernate.AssociativeRelationshipRoleDAO
 *
 * @author Diffblue Cover
 */

public class AssociativeRelationshipRoleDAOTest {

	@Test
	public void factory() throws org.hibernate.HibernateException {
		AssociativeRelationshipRoleDAO associativeRelationshipRoleDAO = new AssociativeRelationshipRoleDAO();
		SessionFactory sessionFactory = mock(SessionFactory.class);
		associativeRelationshipRoleDAO.setSessionFactory(sessionFactory);
		assertSame(sessionFactory, associativeRelationshipRoleDAO.getSessionFactory());
	}
}
