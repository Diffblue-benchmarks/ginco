package fr.mcc.ginco.dao.hibernate;

import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.mock;

import org.hibernate.SessionFactory;
import org.junit.Test;
import org.mockito.Mockito;

/**
 * Unit tests for fr.mcc.ginco.dao.hibernate.ThesaurusOrganizationDAO
 *
 * @author Diffblue Cover
 */

public class ThesaurusOrganizationDAOTest {

	@Test
	public void factory() throws org.hibernate.HibernateException {
		ThesaurusOrganizationDAO thesaurusOrganizationDAO = new ThesaurusOrganizationDAO();
		SessionFactory sessionFactory = mock(SessionFactory.class);
		thesaurusOrganizationDAO.setSessionFactory(sessionFactory);
		assertSame(sessionFactory, thesaurusOrganizationDAO.getSessionFactory());
	}
}
