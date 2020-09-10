package fr.mcc.ginco.dao.hibernate;

import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.mock;

import org.hibernate.SessionFactory;
import org.junit.Test;
import org.mockito.Mockito;

/**
 * Unit tests for fr.mcc.ginco.dao.hibernate.LanguageDAO
 *
 * @author Diffblue Cover
 */

public class LanguageDAOTest {

	@Test
	public void factory() throws org.hibernate.HibernateException {
		LanguageDAO languageDAO = new LanguageDAO();
		SessionFactory sessionFactory = mock(SessionFactory.class);
		languageDAO.setSessionFactory(sessionFactory);
		assertSame(sessionFactory, languageDAO.getSessionFactory());
	}
}
