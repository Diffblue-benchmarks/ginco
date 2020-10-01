package fr.mcc.ginco.dao.hibernate;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import fr.mcc.ginco.beans.Note;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
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
	public void factory() throws org.hibernate.HibernateException, javax.naming.NamingException {
		NoteDAO noteDAO = new NoteDAO();
		SessionFactory sessionFactory = mock(SessionFactory.class);
		noteDAO.setSessionFactory(sessionFactory);
		assertSame(sessionFactory, noteDAO.getSessionFactory());
	}

	@Test
	public void getConceptNoteCountReturnsOne() throws org.hibernate.HibernateException, org.hibernate.UnknownProfileException, javax.naming.NamingException {
		NoteDAO noteDAO = new NoteDAO();
		List list = new ArrayList();
		list.add(1L);
		Criteria criteria1 = mock(Criteria.class);
		when(criteria1.list())
			.thenReturn(list);
		Criteria criteria2 = mock(Criteria.class);
		when(criteria2.setProjection(Mockito.<org.hibernate.criterion.Projection>any()))
			.thenReturn(criteria1);
		Criteria criteria3 = mock(Criteria.class);
		when(criteria3.add(Mockito.<org.hibernate.criterion.Criterion>any()))
			.thenReturn(criteria2);
		Session session = mock(Session.class);
		when(session.createCriteria(Mockito.<Class>any()))
			.thenReturn(criteria3);
		SessionFactory sessionFactory = mock(SessionFactory.class);
		when(sessionFactory.getCurrentSession())
			.thenReturn(session);
		noteDAO.setSessionFactory(sessionFactory);
		assertEquals(1L, (long) noteDAO.getConceptNoteCount("1234"));
	}

	@Test
	public void getTermNoteCountReturnsOne() throws org.hibernate.HibernateException, org.hibernate.UnknownProfileException, javax.naming.NamingException {
		NoteDAO noteDAO = new NoteDAO();
		List list = new ArrayList();
		list.add(1L);
		Criteria criteria1 = mock(Criteria.class);
		when(criteria1.list())
			.thenReturn(list);
		Criteria criteria2 = mock(Criteria.class);
		when(criteria2.setProjection(Mockito.<org.hibernate.criterion.Projection>any()))
			.thenReturn(criteria1);
		Criteria criteria3 = mock(Criteria.class);
		when(criteria3.add(Mockito.<org.hibernate.criterion.Criterion>any()))
			.thenReturn(criteria2);
		Session session = mock(Session.class);
		when(session.createCriteria(Mockito.<Class>any()))
			.thenReturn(criteria3);
		SessionFactory sessionFactory = mock(SessionFactory.class);
		when(sessionFactory.getCurrentSession())
			.thenReturn(session);
		noteDAO.setSessionFactory(sessionFactory);
		assertEquals(1L, (long) noteDAO.getTermNoteCount("1234"));
	}

	@Test
	public void findNotesByThesaurusId() throws org.hibernate.HibernateException, org.hibernate.UnknownProfileException, javax.naming.NamingException {

		// arrange
		NoteDAO noteDAO = new NoteDAO();
		List list = new ArrayList();
		list.add(new Object());
		Criteria criteria1 = mock(Criteria.class);
		when(criteria1.list())
			.thenReturn(list);
		Criteria criteria2 = mock(Criteria.class);
		when(criteria2.add(Mockito.<org.hibernate.criterion.Criterion>any()))
			.thenReturn(criteria1);
		Session session = mock(Session.class);
		when(session.createCriteria(Mockito.<Class>any(), Mockito.<String>any()))
			.thenReturn(criteria2);
		SessionFactory sessionFactory = mock(SessionFactory.class);
		when(sessionFactory.getCurrentSession())
			.thenReturn(session);
		noteDAO.setSessionFactory(sessionFactory);

		// act
		List<Note> result = noteDAO.findNotesByThesaurusId("1234");

		// assert
		assertEquals(1, result.size());
		// pojo Object
	}
}
