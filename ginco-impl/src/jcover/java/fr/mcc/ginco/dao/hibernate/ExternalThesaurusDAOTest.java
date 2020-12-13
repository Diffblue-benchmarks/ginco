package fr.mcc.ginco.dao.hibernate;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import fr.mcc.ginco.beans.ExternalThesaurus;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;
import org.mockito.Mockito;

/**
 * Unit tests for fr.mcc.ginco.dao.hibernate.ExternalThesaurusDAO
 *
 * @author Diffblue Cover
 */

public class ExternalThesaurusDAOTest {

	@Test
	public void factory() {
		ExternalThesaurusDAO externalThesaurusDAO = new ExternalThesaurusDAO();
		SessionFactory sessionFactory = mock(SessionFactory.class);
		externalThesaurusDAO.setSessionFactory(sessionFactory);
		assertSame(sessionFactory, externalThesaurusDAO.getSessionFactory());
	}

	@Test
	public void findAllByExternalIdQueryQueryIsBar() throws org.hibernate.HibernateException {

		// arrange
		ExternalThesaurusDAO externalThesaurusDAO = new ExternalThesaurusDAO();
		ArrayList<String> arrayList = new ArrayList<String>();
		arrayList.add("Smith");
		Criteria criteria1 = mock(Criteria.class);
		Criteria criteria2 = mock(Criteria.class);
		when(criteria2.add(Mockito.<org.hibernate.criterion.Criterion>any()))
			.thenReturn(criteria1);
		when(criteria2.list())
			.thenReturn(arrayList);
		Session session = mock(Session.class);
		when(session.createCriteria(Mockito.<Class>any()))
			.thenReturn(criteria2);
		SessionFactory sessionFactory = mock(SessionFactory.class);
		when(sessionFactory.getCurrentSession())
			.thenReturn(session);
		externalThesaurusDAO.setSessionFactory(sessionFactory);

		// act
		List<ExternalThesaurus> result =
			 externalThesaurusDAO.findAllByExternalIdQuery("bar");

		// assert
		assertEquals(1, result.size());
		// pojo String (String) result.get(0)
	}

	@Test
	public void findAllByExternalIdQueryQueryIsEmpty() throws org.hibernate.HibernateException {

		// arrange
		ExternalThesaurusDAO externalThesaurusDAO = new ExternalThesaurusDAO();
		ArrayList<String> arrayList = new ArrayList<String>();
		arrayList.add("Smith");
		Criteria criteria1 = mock(Criteria.class);
		Criteria criteria2 = mock(Criteria.class);
		when(criteria2.list())
			.thenReturn(arrayList);
		Session session = mock(Session.class);
		when(session.createCriteria(Mockito.<Class>any()))
			.thenReturn(criteria2);
		SessionFactory sessionFactory = mock(SessionFactory.class);
		when(sessionFactory.getCurrentSession())
			.thenReturn(session);
		externalThesaurusDAO.setSessionFactory(sessionFactory);

		// act
		List<ExternalThesaurus> result =
			 externalThesaurusDAO.findAllByExternalIdQuery("");

		// assert
		assertEquals(1, result.size());
		// pojo String (String) result.get(0)
	}

	@Test
	public void findAllByExternalIdQueryQueryIsNull() throws org.hibernate.HibernateException {

		// arrange
		ExternalThesaurusDAO externalThesaurusDAO = new ExternalThesaurusDAO();
		ArrayList<String> arrayList = new ArrayList<String>();
		arrayList.add("Smith");
		Criteria criteria1 = mock(Criteria.class);
		Criteria criteria2 = mock(Criteria.class);
		when(criteria2.list())
			.thenReturn(arrayList);
		Session session = mock(Session.class);
		when(session.createCriteria(Mockito.<Class>any()))
			.thenReturn(criteria2);
		SessionFactory sessionFactory = mock(SessionFactory.class);
		when(sessionFactory.getCurrentSession())
			.thenReturn(session);
		externalThesaurusDAO.setSessionFactory(sessionFactory);

		// act
		List<ExternalThesaurus> result =
			 externalThesaurusDAO.findAllByExternalIdQuery(null);

		// assert
		assertEquals(1, result.size());
		// pojo String (String) result.get(0)
	}

	@Test
	public void findBySourceExternalIdReturnsNull() throws org.hibernate.HibernateException {
		ExternalThesaurusDAO externalThesaurusDAO = new ExternalThesaurusDAO();
		Criteria criteria1 = mock(Criteria.class);
		Criteria criteria2 = mock(Criteria.class);
		when(criteria2.add(Mockito.<org.hibernate.criterion.Criterion>any()))
			.thenReturn(criteria1);
		when(criteria2.list())
			.thenReturn(new ArrayList<String>());
		Session session = mock(Session.class);
		when(session.createCriteria(Mockito.<Class>any()))
			.thenReturn(criteria2);
		SessionFactory sessionFactory = mock(SessionFactory.class);
		when(sessionFactory.getCurrentSession())
			.thenReturn(session);
		externalThesaurusDAO.setSessionFactory(sessionFactory);
		assertNull(externalThesaurusDAO.findBySourceExternalId("1234"));
	}
}
