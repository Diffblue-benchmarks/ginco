package fr.mcc.ginco.dao.hibernate;

import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.mock;

import org.hibernate.SessionFactory;
import org.junit.Test;
import org.mockito.Mockito;

/**
 * Unit tests for fr.mcc.ginco.dao.hibernate.NoteDAO
 *
 * @author Diffblue Cover
 */

public class NoteDAOTest {

	@Test
	public void factory() throws org.hibernate.HibernateException {
		NoteDAO noteDAO = new NoteDAO();
		SessionFactory sessionFactory = mock(SessionFactory.class);
		noteDAO.setSessionFactory(sessionFactory);
		assertSame(sessionFactory, noteDAO.getSessionFactory());
	}
}
