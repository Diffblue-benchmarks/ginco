package fr.mcc.ginco.dao.hibernate;

import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.mock;

import org.hibernate.SessionFactory;
import org.junit.Test;
import org.mockito.Mockito;

/**
 * Unit tests for fr.mcc.ginco.dao.hibernate.ThesaurusTermRoleDAO
 *
 * @author Diffblue Cover
 */

public class ThesaurusTermRoleDAOTest {

	@Test
	public void factory() {
		ThesaurusTermRoleDAO thesaurusTermRoleDAO = new ThesaurusTermRoleDAO();
		SessionFactory sessionFactory = mock(SessionFactory.class);
		thesaurusTermRoleDAO.setSessionFactory(sessionFactory);
		assertSame(sessionFactory, thesaurusTermRoleDAO.getSessionFactory());
	}
}
