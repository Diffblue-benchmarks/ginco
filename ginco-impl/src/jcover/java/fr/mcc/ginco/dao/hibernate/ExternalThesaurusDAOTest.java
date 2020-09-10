package fr.mcc.ginco.dao.hibernate;

import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.mock;

import org.hibernate.SessionFactory;
import org.junit.Test;
import org.mockito.Mockito;

/**
 * Unit tests for fr.mcc.ginco.dao.hibernate.ExternalThesaurusDAO
 *
 * @author Diffblue Cover
 */

public class ExternalThesaurusDAOTest {

	@Test
	public void factory() throws org.hibernate.HibernateException {
		ExternalThesaurusDAO externalThesaurusDAO = new ExternalThesaurusDAO();
		SessionFactory sessionFactory = mock(SessionFactory.class);
		externalThesaurusDAO.setSessionFactory(sessionFactory);
		assertSame(sessionFactory, externalThesaurusDAO.getSessionFactory());
	}
}
