package fr.mcc.ginco.dao.hibernate;

import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.mock;

import org.hibernate.SessionFactory;
import org.junit.Test;
import org.mockito.Mockito;

/**
 * Unit tests for fr.mcc.ginco.dao.hibernate.ThesaurusConceptGroupDAO
 *
 * @author Diffblue Cover
 */

public class ThesaurusConceptGroupDAOTest {

	@Test
	public void factory() throws org.hibernate.HibernateException {
		ThesaurusConceptGroupDAO thesaurusConceptGroupDAO = new ThesaurusConceptGroupDAO();
		SessionFactory sessionFactory = mock(SessionFactory.class);
		thesaurusConceptGroupDAO.setSessionFactory(sessionFactory);
		assertSame(sessionFactory, thesaurusConceptGroupDAO.getSessionFactory());
	}
}
