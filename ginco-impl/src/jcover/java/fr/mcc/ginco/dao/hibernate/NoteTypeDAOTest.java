package fr.mcc.ginco.dao.hibernate;

import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.mock;

import org.hibernate.SessionFactory;
import org.junit.Test;
import org.mockito.Mockito;

/**
 * Unit tests for fr.mcc.ginco.dao.hibernate.NoteTypeDAO
 *
 * @author Diffblue Cover
 */

public class NoteTypeDAOTest {

	@Test
	public void factory() throws org.hibernate.HibernateException {
		NoteTypeDAO noteTypeDAO = new NoteTypeDAO();
		SessionFactory sessionFactory = mock(SessionFactory.class);
		noteTypeDAO.setSessionFactory(sessionFactory);
		assertSame(sessionFactory, noteTypeDAO.getSessionFactory());
	}
}
