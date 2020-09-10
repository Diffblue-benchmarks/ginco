package fr.mcc.ginco.dao.hibernate;

import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.mock;

import org.hibernate.SessionFactory;
import org.junit.Test;
import org.mockito.Mockito;

/**
 * Unit tests for fr.mcc.ginco.dao.hibernate.ThesaurusConceptGroupLabelDAO
 *
 * @author Diffblue Cover
 */

public class ThesaurusConceptGroupLabelDAOTest {

	@Test
	public void factory() throws org.hibernate.HibernateException {
		ThesaurusConceptGroupLabelDAO thesaurusConceptGroupLabelDAO = new ThesaurusConceptGroupLabelDAO();
		SessionFactory sessionFactory = mock(SessionFactory.class);
		thesaurusConceptGroupLabelDAO.setSessionFactory(sessionFactory);
		assertSame(sessionFactory, thesaurusConceptGroupLabelDAO.getSessionFactory());
	}
}
