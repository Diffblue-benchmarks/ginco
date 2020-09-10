package fr.mcc.ginco.dao.hibernate;

import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.mock;

import org.hibernate.SessionFactory;
import org.junit.Test;
import org.mockito.Mockito;

/**
 * Unit tests for fr.mcc.ginco.dao.hibernate.CustomTermAttributeTypeDAO
 *
 * @author Diffblue Cover
 */

public class CustomTermAttributeTypeDAOTest {

	@Test
	public void factory() throws org.hibernate.HibernateException {
		CustomTermAttributeTypeDAO customTermAttributeTypeDAO = new CustomTermAttributeTypeDAO();
		SessionFactory sessionFactory = mock(SessionFactory.class);
		customTermAttributeTypeDAO.setSessionFactory(sessionFactory);
		assertSame(sessionFactory, customTermAttributeTypeDAO.getSessionFactory());
	}
}
