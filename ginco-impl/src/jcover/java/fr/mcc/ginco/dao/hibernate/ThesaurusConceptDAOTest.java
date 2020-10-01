package fr.mcc.ginco.dao.hibernate;

import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.mock;

import org.hibernate.SessionFactory;
import org.junit.Test;
import org.mockito.Mockito;

/**
 * Unit tests for fr.mcc.ginco.dao.hibernate.ThesaurusConceptDAO
 *
 * @author Diffblue Cover
 */

public class ThesaurusConceptDAOTest {

	@Test
	public void factory() throws org.hibernate.HibernateException, javax.naming.NamingException {
		ThesaurusConceptDAO thesaurusConceptDAO = new ThesaurusConceptDAO();
		SessionFactory sessionFactory = mock(SessionFactory.class);
		thesaurusConceptDAO.setSessionFactory(sessionFactory);
		assertSame(sessionFactory, thesaurusConceptDAO.getSessionFactory());
	}
}
