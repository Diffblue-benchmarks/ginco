package fr.mcc.ginco.dao.hibernate;

import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.mock;

import org.hibernate.SessionFactory;
import org.junit.Test;
import org.mockito.Mockito;

/**
 * Unit tests for fr.mcc.ginco.dao.hibernate.CustomConceptAttributeTypeDAO
 *
 * @author Diffblue Cover
 */

public class CustomConceptAttributeTypeDAOTest {

	@Test
	public void factory() throws org.hibernate.HibernateException, javax.naming.NamingException {
		CustomConceptAttributeTypeDAO customConceptAttributeTypeDAO =
			 new CustomConceptAttributeTypeDAO();
		SessionFactory sessionFactory = mock(SessionFactory.class);
		customConceptAttributeTypeDAO.setSessionFactory(sessionFactory);
		assertSame(sessionFactory, customConceptAttributeTypeDAO.getSessionFactory());
	}
}
