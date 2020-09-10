package fr.mcc.ginco.dao.hibernate;

import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.mock;

import org.hibernate.SessionFactory;
import org.junit.Test;
import org.mockito.Mockito;

/**
 * Unit tests for fr.mcc.ginco.dao.hibernate.SuggestionDAO
 *
 * @author Diffblue Cover
 */

public class SuggestionDAOTest {

	@Test
	public void factory() throws org.hibernate.HibernateException, javax.naming.NamingException {
		SuggestionDAO suggestionDAO = new SuggestionDAO();
		SessionFactory sessionFactory = mock(SessionFactory.class);
		suggestionDAO.setSessionFactory(sessionFactory);
		assertSame(sessionFactory, suggestionDAO.getSessionFactory());
	}
}
