package fr.mcc.ginco.dao.hibernate;

import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.mock;

import org.hibernate.SessionFactory;
import org.junit.Test;

/**
 * Unit tests for fr.mcc.ginco.dao.hibernate.ThesaurusArrayConceptDAO
 *
 * @author Diffblue Cover
 */

public class ThesaurusArrayConceptDAOTest {

	@Test
	public void factory() throws org.hibernate.HibernateException, javax.naming.NamingException {
		ThesaurusArrayConceptDAO thesaurusArrayConceptDAO =
			 new ThesaurusArrayConceptDAO();
		SessionFactory sessionFactory = mock(SessionFactory.class);
		thesaurusArrayConceptDAO.setSessionFactory(sessionFactory);
		assertSame(sessionFactory, thesaurusArrayConceptDAO.getSessionFactory());
	}
}
