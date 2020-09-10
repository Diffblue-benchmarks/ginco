package fr.mcc.ginco.dao.hibernate;

import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.mock;

import org.hibernate.SessionFactory;
import org.junit.Test;
import org.mockito.Mockito;

/**
 * Unit tests for fr.mcc.ginco.dao.hibernate.ThesaurusArrayDAO
 *
 * @author Diffblue Cover
 */

public class ThesaurusArrayDAOTest {

	@Test
	public void factory() throws org.hibernate.HibernateException {
		ThesaurusArrayDAO thesaurusArrayDAO = new ThesaurusArrayDAO();
		SessionFactory sessionFactory = mock(SessionFactory.class);
		thesaurusArrayDAO.setSessionFactory(sessionFactory);
		assertSame(sessionFactory, thesaurusArrayDAO.getSessionFactory());
	}
}
