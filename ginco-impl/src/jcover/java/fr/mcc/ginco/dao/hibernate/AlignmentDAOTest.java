package fr.mcc.ginco.dao.hibernate;

import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.mock;

import org.hibernate.SessionFactory;
import org.junit.Test;
import org.mockito.Mockito;

/**
 * Unit tests for fr.mcc.ginco.dao.hibernate.AlignmentDAO
 *
 * @author Diffblue Cover
 */

public class AlignmentDAOTest {

	@Test
	public void factory() throws org.hibernate.HibernateException {
		AlignmentDAO alignmentDAO = new AlignmentDAO();
		SessionFactory sessionFactory = mock(SessionFactory.class);
		alignmentDAO.setSessionFactory(sessionFactory);
		assertSame(sessionFactory, alignmentDAO.getSessionFactory());
	}
}
