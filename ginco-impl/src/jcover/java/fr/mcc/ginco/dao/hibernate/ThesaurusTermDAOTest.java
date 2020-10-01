package fr.mcc.ginco.dao.hibernate;

import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.mock;

import org.hibernate.SessionFactory;
import org.junit.Test;
import org.mockito.Mockito;

/**
 * Unit tests for fr.mcc.ginco.dao.hibernate.ThesaurusTermDAO
 *
 * @author Diffblue Cover
 */

public class ThesaurusTermDAOTest {

	@Test
	public void factory() throws org.hibernate.HibernateException, javax.naming.NamingException {
		ThesaurusTermDAO thesaurusTermDAO = new ThesaurusTermDAO();
		SessionFactory sessionFactory = mock(SessionFactory.class);
		thesaurusTermDAO.setSessionFactory(sessionFactory);
		assertSame(sessionFactory, thesaurusTermDAO.getSessionFactory());
	}
}
