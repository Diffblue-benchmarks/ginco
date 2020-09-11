package fr.mcc.ginco.dao.hibernate;

import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.mock;

import org.hibernate.SessionFactory;
import org.junit.Test;

/**
 * Unit tests for fr.mcc.ginco.dao.hibernate.CustomConceptAttributeDAO
 *
 * @author Diffblue Cover
 */

public class CustomConceptAttributeDAOTest {

	@Test
	public void factory() throws org.hibernate.HibernateException, javax.naming.NamingException {
		CustomConceptAttributeDAO customConceptAttributeDAO =
			 new CustomConceptAttributeDAO();
		SessionFactory sessionFactory = mock(SessionFactory.class);
		customConceptAttributeDAO.setSessionFactory(sessionFactory);
		assertSame(sessionFactory, customConceptAttributeDAO.getSessionFactory());
	}
}
