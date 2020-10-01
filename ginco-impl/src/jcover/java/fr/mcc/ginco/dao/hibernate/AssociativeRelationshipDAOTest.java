package fr.mcc.ginco.dao.hibernate;

import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.mock;

import org.hibernate.SessionFactory;
import org.junit.Test;
import org.mockito.Mockito;

/**
 * Unit tests for fr.mcc.ginco.dao.hibernate.AssociativeRelationshipDAO
 *
 * @author Diffblue Cover
 */

public class AssociativeRelationshipDAOTest {

	@Test
	public void factory() throws org.hibernate.HibernateException, javax.naming.NamingException {
		AssociativeRelationshipDAO associativeRelationshipDAO =
			 new AssociativeRelationshipDAO();
		SessionFactory sessionFactory = mock(SessionFactory.class);
		associativeRelationshipDAO.setSessionFactory(sessionFactory);
		assertSame(sessionFactory, associativeRelationshipDAO.getSessionFactory());
	}
}
