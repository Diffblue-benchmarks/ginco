package fr.mcc.ginco.dao.hibernate;

import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.mock;

import org.hibernate.SessionFactory;
import org.junit.Test;
import org.mockito.Mockito;

/**
 * Unit tests for fr.mcc.ginco.dao.hibernate.ThesaurusDAO
 *
 * @author Diffblue Cover
 */

public class ThesaurusDAOTest {

	@Test
	public void factory() {
		ThesaurusDAO thesaurusDAO = new ThesaurusDAO();
		SessionFactory sessionFactory = mock(SessionFactory.class);
		thesaurusDAO.setSessionFactory(sessionFactory);
		assertSame(sessionFactory, thesaurusDAO.getSessionFactory());
	}
}
