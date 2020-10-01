package fr.mcc.ginco.dao.hibernate;

import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.mock;

import org.hibernate.SessionFactory;
import org.junit.Test;
import org.mockito.Mockito;

/**
 * Unit tests for fr.mcc.ginco.dao.hibernate.CustomTermAttributeDAO
 *
 * @author Diffblue Cover
 */

public class CustomTermAttributeDAOTest {

	@Test
	public void factory() throws org.hibernate.HibernateException, javax.naming.NamingException {
		CustomTermAttributeDAO customTermAttributeDAO = new CustomTermAttributeDAO();
		SessionFactory sessionFactory = mock(SessionFactory.class);
		customTermAttributeDAO.setSessionFactory(sessionFactory);
		assertSame(sessionFactory, customTermAttributeDAO.getSessionFactory());
	}
}
