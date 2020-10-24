package fr.mcc.ginco.dao.hibernate;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.anyInt;
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
	public void factory() {
		NoteDAO noteDAO = new NoteDAO();
		SessionFactory sessionFactory = mock(SessionFactory.class);
		noteDAO.setSessionFactory(sessionFactory);
		assertSame(sessionFactory, noteDAO.getSessionFactory());
	}

	@Test
	public void findConceptPaginatedNotesLimitIsOneAndStartIndexIsOne() throws org.hibernate.HibernateException {

		// arrange
		NoteDAO noteDAO = new NoteDAO();
		List list = new ArrayList<String>();
		list.add("Smith");
		Criteria criteria1 = mock(Criteria.class);
		when(criteria1.list())
			.thenReturn(list);
		Criteria criteria2 = mock(Criteria.class);
		when(criteria2.addOrder(Mockito.<org.hibernate.criterion.Order>any()))
			.thenReturn(criteria1);
		Criteria criteria3 = mock(Criteria.class);
		when(criteria3.setFirstResult(anyInt()))
			.thenReturn(criteria2);
		Criteria criteria4 = mock(Criteria.class);
		when(criteria4.add(Mockito.<org.hibernate.criterion.Criterion>any()))
			.thenReturn(criteria3);
		Criteria criteria5 = mock(Criteria.class);
		when(criteria5.setMaxResults(anyInt()))
			.thenReturn(criteria4);
		Session session = mock(Session.class);
		when(session.createCriteria(Mockito.<Class>any()))
			.thenReturn(criteria5);
		SessionFactory sessionFactory = mock(SessionFactory.class);
		when(sessionFactory.getCurrentSession())
			.thenReturn(session);
		noteDAO.setSessionFactory(sessionFactory);

		// act
		List<Note> result = noteDAO.findConceptPaginatedNotes("1234", 1, 1);

		// assert
		assertEquals(1, result.size());
		// pojo String (String) result.get(0)
	}

	@Test
	public void findTermPaginatedNotesLimitIsOneAndStartIndexIsOne() throws org.hibernate.HibernateException {

		// arrange
		NoteDAO noteDAO = new NoteDAO();
		List list = new ArrayList<String>();
		list.add("Smith");
		Criteria criteria1 = mock(Criteria.class);
		when(criteria1.list())
			.thenReturn(list);
		Criteria criteria2 = mock(Criteria.class);
		when(criteria2.addOrder(Mockito.<org.hibernate.criterion.Order>any()))
			.thenReturn(criteria1);
		Criteria criteria3 = mock(Criteria.class);
		when(criteria3.setFirstResult(anyInt()))
			.thenReturn(criteria2);
		Criteria criteria4 = mock(Criteria.class);
		when(criteria4.add(Mockito.<org.hibernate.criterion.Criterion>any()))
			.thenReturn(criteria3);
		Criteria criteria5 = mock(Criteria.class);
		when(criteria5.setMaxResults(anyInt()))
			.thenReturn(criteria4);
		Session session = mock(Session.class);
		when(session.createCriteria(Mockito.<Class>any()))
			.thenReturn(criteria5);
		SessionFactory sessionFactory = mock(SessionFactory.class);
		when(sessionFactory.getCurrentSession())
			.thenReturn(session);
		noteDAO.setSessionFactory(sessionFactory);

		// act
		List<Note> result = noteDAO.findTermPaginatedNotes("1234", 1, 1);

		// assert
		assertEquals(1, result.size());
		// pojo String (String) result.get(0)
	}

	@Test
	public void findNotesByThesaurusId() throws org.hibernate.HibernateException {

		// arrange
		NoteDAO noteDAO = new NoteDAO();
		List list = new ArrayList<String>();
		list.add("Smith");
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
		// pojo String (String) result.get(0)
	}
}
