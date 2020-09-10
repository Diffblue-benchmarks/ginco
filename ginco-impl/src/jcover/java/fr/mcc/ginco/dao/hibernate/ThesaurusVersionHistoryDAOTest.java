package fr.mcc.ginco.dao.hibernate;

import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.mock;

import org.hibernate.SessionFactory;
import org.junit.Test;
import org.mockito.Mockito;

/**
 * Unit tests for fr.mcc.ginco.dao.hibernate.ThesaurusVersionHistoryDAO
 *
 * @author Diffblue Cover
 */

public class ThesaurusVersionHistoryDAOTest {

	@Test
	public void factory() throws org.hibernate.HibernateException {
		ThesaurusVersionHistoryDAO thesaurusVersionHistoryDAO = new ThesaurusVersionHistoryDAO();
		SessionFactory sessionFactory = mock(SessionFactory.class);
		thesaurusVersionHistoryDAO.setSessionFactory(sessionFactory);
		assertSame(sessionFactory, thesaurusVersionHistoryDAO.getSessionFactory());
	}
}
