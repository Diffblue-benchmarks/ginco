package fr.mcc.ginco.dao.hibernate;

import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.mock;

import org.hibernate.SessionFactory;
import org.junit.Test;
import org.mockito.Mockito;

/**
 * Unit tests for fr.mcc.ginco.dao.hibernate.ThesaurusTypeDAO
 *
 * @author Diffblue Cover
 */

public class ThesaurusTypeDAOTest {

	@Test
	public void factory() throws org.hibernate.HibernateException {
		ThesaurusTypeDAO thesaurusTypeDAO = new ThesaurusTypeDAO();
		SessionFactory sessionFactory = mock(SessionFactory.class);
		thesaurusTypeDAO.setSessionFactory(sessionFactory);
		assertSame(sessionFactory, thesaurusTypeDAO.getSessionFactory());
	}
}
