package fr.mcc.ginco.dao.hibernate;

import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.mock;

import org.hibernate.SessionFactory;
import org.junit.Test;
import org.mockito.Mockito;

/**
 * Unit tests for fr.mcc.ginco.dao.hibernate.SplitNonPreferredTermDAO
 *
 * @author Diffblue Cover
 */

public class SplitNonPreferredTermDAOTest {

	@Test
	public void factory() throws org.hibernate.HibernateException {
		SplitNonPreferredTermDAO splitNonPreferredTermDAO = new SplitNonPreferredTermDAO();
		SessionFactory sessionFactory = mock(SessionFactory.class);
		splitNonPreferredTermDAO.setSessionFactory(sessionFactory);
		assertSame(sessionFactory, splitNonPreferredTermDAO.getSessionFactory());
	}
}
