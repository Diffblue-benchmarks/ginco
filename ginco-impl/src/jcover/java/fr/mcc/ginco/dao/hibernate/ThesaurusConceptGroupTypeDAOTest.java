package fr.mcc.ginco.dao.hibernate;

import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.mock;

import org.hibernate.SessionFactory;
import org.junit.Test;
import org.mockito.Mockito;

/**
 * Unit tests for fr.mcc.ginco.dao.hibernate.ThesaurusConceptGroupTypeDAO
 *
 * @author Diffblue Cover
 */

public class ThesaurusConceptGroupTypeDAOTest {

	@Test
	public void factory() {
		ThesaurusConceptGroupTypeDAO thesaurusConceptGroupTypeDAO =
			 new ThesaurusConceptGroupTypeDAO();
		SessionFactory sessionFactory = mock(SessionFactory.class);
		thesaurusConceptGroupTypeDAO.setSessionFactory(sessionFactory);
		assertSame(sessionFactory, thesaurusConceptGroupTypeDAO.getSessionFactory());
	}
}
