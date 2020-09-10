package fr.mcc.ginco.dao.hibernate;

import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import org.hibernate.Criteria;
import org.hibernate.Session;
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
	public void factory() throws org.hibernate.HibernateException, javax.naming.NamingException {
		NoteTypeDAO noteTypeDAO = new NoteTypeDAO();
		SessionFactory sessionFactory = mock(SessionFactory.class);
		noteTypeDAO.setSessionFactory(sessionFactory);
		assertSame(sessionFactory, noteTypeDAO.getSessionFactory());
	}

	@Test
	public void findConceptNoteTypesReturnsEmpty() throws org.hibernate.HibernateException, org.hibernate.UnknownProfileException, javax.naming.NamingException {
		NoteTypeDAO noteTypeDAO = new NoteTypeDAO();
		Criteria criteria1 = mock(Criteria.class);
		when(criteria1.list())
			.thenReturn(new ArrayList());
		Criteria criteria2 = mock(Criteria.class);
		when(criteria2.add(Mockito.<org.hibernate.criterion.Criterion>any()))
			.thenReturn(criteria1);
		Session session = mock(Session.class);
		when(session.createCriteria(Mockito.<Class>any()))
			.thenReturn(criteria2);
		SessionFactory sessionFactory = mock(SessionFactory.class);
		when(sessionFactory.getCurrentSession())
			.thenReturn(session);
		noteTypeDAO.setSessionFactory(sessionFactory);
		assertTrue((noteTypeDAO.findConceptNoteTypes()).isEmpty());
	}

	@Test
	public void findTermNoteTypesReturnsEmpty() throws org.hibernate.HibernateException, org.hibernate.UnknownProfileException, javax.naming.NamingException {
		NoteTypeDAO noteTypeDAO = new NoteTypeDAO();
		Criteria criteria1 = mock(Criteria.class);
		when(criteria1.list())
			.thenReturn(new ArrayList());
		Criteria criteria2 = mock(Criteria.class);
		when(criteria2.add(Mockito.<org.hibernate.criterion.Criterion>any()))
			.thenReturn(criteria1);
		Session session = mock(Session.class);
		when(session.createCriteria(Mockito.<Class>any()))
			.thenReturn(criteria2);
		SessionFactory sessionFactory = mock(SessionFactory.class);
		when(sessionFactory.getCurrentSession())
			.thenReturn(session);
		noteTypeDAO.setSessionFactory(sessionFactory);
		assertTrue((noteTypeDAO.findTermNoteTypes()).isEmpty());
	}
}
