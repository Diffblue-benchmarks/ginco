package fr.mcc.ginco.dao.hibernate;

import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.mock;

import org.hibernate.SessionFactory;
import org.junit.Test;
import org.mockito.Mockito;

/**
 * Unit tests for fr.mcc.ginco.dao.hibernate.UserRoleDAO
 *
 * @author Diffblue Cover
 */

public class UserRoleDAOTest {

	@Test
	public void factory() throws org.hibernate.HibernateException {
		UserRoleDAO userRoleDAO = new UserRoleDAO();
		SessionFactory sessionFactory = mock(SessionFactory.class);
		userRoleDAO.setSessionFactory(sessionFactory);
		assertSame(sessionFactory, userRoleDAO.getSessionFactory());
	}
}
