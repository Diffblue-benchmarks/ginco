package fr.mcc.ginco.dao.hibernate;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import fr.mcc.ginco.beans.ThesaurusArray;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;
import org.mockito.Mockito;

/**
 * Unit tests for fr.mcc.ginco.dao.hibernate.ThesaurusArrayDAO
 *
 * @author Diffblue Cover
 */

public class ThesaurusArrayDAOTest {

	@Test
	public void factory() {
		ThesaurusArrayDAO thesaurusArrayDAO = new ThesaurusArrayDAO();
		SessionFactory sessionFactory = mock(SessionFactory.class);
		thesaurusArrayDAO.setSessionFactory(sessionFactory);
		assertSame(sessionFactory, thesaurusArrayDAO.getSessionFactory());
	}

	@Test
	public void getThesaurusArrayListByThesaurusIdExcludedConceptArrayIdIsBar() throws org.hibernate.HibernateException {

		// arrange
		ThesaurusArrayDAO thesaurusArrayDAO = new ThesaurusArrayDAO();
		List list = new ArrayList<String>();
		list.add("Smith");
		Criteria criteria1 = mock(Criteria.class);
		Criteria criteria2 = mock(Criteria.class);
		Criteria criteria3 = mock(Criteria.class);
		when(criteria3.add(Mockito.<org.hibernate.criterion.Criterion>any()))
			.thenReturn(criteria2)
			.thenReturn(criteria1);
		when(criteria3.list())
			.thenReturn(list);
		Session session = mock(Session.class);
		when(session.createCriteria(Mockito.<Class>any(), Mockito.<String>any()))
			.thenReturn(criteria3);
		SessionFactory sessionFactory = mock(SessionFactory.class);
		when(sessionFactory.getCurrentSession())
			.thenReturn(session);
		thesaurusArrayDAO.setSessionFactory(sessionFactory);

		// act
		List<ThesaurusArray> result =
			 thesaurusArrayDAO.getThesaurusArrayListByThesaurusId("bar", "1234");

		// assert
		assertEquals(1, result.size());
		// pojo String (String) result.get(0)
	}

	@Test
	public void getThesaurusArrayListByThesaurusIdExcludedConceptArrayIdIsNull() throws org.hibernate.HibernateException {

		// arrange
		ThesaurusArrayDAO thesaurusArrayDAO = new ThesaurusArrayDAO();
		List list = new ArrayList<String>();
		list.add("Smith");
		Criteria criteria1 = mock(Criteria.class);
		Criteria criteria2 = mock(Criteria.class);
		Criteria criteria3 = mock(Criteria.class);
		when(criteria3.add(Mockito.<org.hibernate.criterion.Criterion>any()))
			.thenReturn(criteria2);
		when(criteria3.list())
			.thenReturn(list);
		Session session = mock(Session.class);
		when(session.createCriteria(Mockito.<Class>any(), Mockito.<String>any()))
			.thenReturn(criteria3);
		SessionFactory sessionFactory = mock(SessionFactory.class);
		when(sessionFactory.getCurrentSession())
			.thenReturn(session);
		thesaurusArrayDAO.setSessionFactory(sessionFactory);

		// act
		List<ThesaurusArray> result =
			 thesaurusArrayDAO.getThesaurusArrayListByThesaurusId(null, "1234");

		// assert
		assertEquals(1, result.size());
		// pojo String (String) result.get(0)
	}

	@Test
	public void getConceptSuperOrdinateArrays1() throws org.hibernate.HibernateException {

		// arrange
		ThesaurusArrayDAO thesaurusArrayDAO = new ThesaurusArrayDAO();
		List list = new ArrayList<String>();
		list.add("Smith");
		Criteria criteria1 = mock(Criteria.class);
		Criteria criteria2 = mock(Criteria.class);
		when(criteria2.add(Mockito.<org.hibernate.criterion.Criterion>any()))
			.thenReturn(criteria1);
		when(criteria2.list())
			.thenReturn(list);
		Session session = mock(Session.class);
		when(session.createCriteria(Mockito.<Class>any(), Mockito.<String>any()))
			.thenReturn(criteria2);
		SessionFactory sessionFactory = mock(SessionFactory.class);
		when(sessionFactory.getCurrentSession())
			.thenReturn(session);
		thesaurusArrayDAO.setSessionFactory(sessionFactory);

		// act
		List<ThesaurusArray> result =
			 thesaurusArrayDAO.getConceptSuperOrdinateArrays("1234");

		// assert
		assertEquals(1, result.size());
		// pojo String (String) result.get(0)
	}

	@Test
	public void getConceptSuperOrdinateArrays2() throws org.hibernate.HibernateException {

		// arrange
		ThesaurusArrayDAO thesaurusArrayDAO = new ThesaurusArrayDAO();
		List list = new ArrayList<String>();
		list.add("Smith");
		Criteria criteria1 = mock(Criteria.class);
		Criteria criteria2 = mock(Criteria.class);
		Criteria criteria3 = mock(Criteria.class);
		when(criteria3.add(Mockito.<org.hibernate.criterion.Criterion>any()))
			.thenReturn(criteria2)
			.thenReturn(criteria1);
		when(criteria3.list())
			.thenReturn(list);
		Session session = mock(Session.class);
		when(session.createCriteria(Mockito.<Class>any(), Mockito.<String>any()))
			.thenReturn(criteria3);
		SessionFactory sessionFactory = mock(SessionFactory.class);
		when(sessionFactory.getCurrentSession())
			.thenReturn(session);
		thesaurusArrayDAO.setSessionFactory(sessionFactory);

		// act
		List<ThesaurusArray> result =
			 thesaurusArrayDAO.getConceptSuperOrdinateArrays("1234", "1234");

		// assert
		assertEquals(1, result.size());
		// pojo String (String) result.get(0)
	}

	@Test
	public void getArraysWithoutSuperordinatedConcept() throws org.hibernate.HibernateException {

		// arrange
		ThesaurusArrayDAO thesaurusArrayDAO = new ThesaurusArrayDAO();
		List list = new ArrayList<String>();
		list.add("Smith");
		Criteria criteria1 = mock(Criteria.class);
		Criteria criteria2 = mock(Criteria.class);
		Criteria criteria3 = mock(Criteria.class);
		when(criteria3.add(Mockito.<org.hibernate.criterion.Criterion>any()))
			.thenReturn(criteria2)
			.thenReturn(criteria1);
		when(criteria3.list())
			.thenReturn(list);
		Session session = mock(Session.class);
		when(session.createCriteria(Mockito.<Class>any(), Mockito.<String>any()))
			.thenReturn(criteria3);
		SessionFactory sessionFactory = mock(SessionFactory.class);
		when(sessionFactory.getCurrentSession())
			.thenReturn(session);
		thesaurusArrayDAO.setSessionFactory(sessionFactory);

		// act
		List<ThesaurusArray> result =
			 thesaurusArrayDAO.getArraysWithoutSuperordinatedConcept("1234");

		// assert
		assertEquals(1, result.size());
		// pojo String (String) result.get(0)
	}

	@Test
	public void getArraysWithoutParentArray() throws org.hibernate.HibernateException {

		// arrange
		ThesaurusArrayDAO thesaurusArrayDAO = new ThesaurusArrayDAO();
		List list = new ArrayList<String>();
		list.add("Smith");
		Criteria criteria1 = mock(Criteria.class);
		Criteria criteria2 = mock(Criteria.class);
		Criteria criteria3 = mock(Criteria.class);
		when(criteria3.add(Mockito.<org.hibernate.criterion.Criterion>any()))
			.thenReturn(criteria2)
			.thenReturn(criteria1);
		when(criteria3.list())
			.thenReturn(list);
		Session session = mock(Session.class);
		when(session.createCriteria(Mockito.<Class>any(), Mockito.<String>any()))
			.thenReturn(criteria3);
		SessionFactory sessionFactory = mock(SessionFactory.class);
		when(sessionFactory.getCurrentSession())
			.thenReturn(session);
		thesaurusArrayDAO.setSessionFactory(sessionFactory);

		// act
		List<ThesaurusArray> result =
			 thesaurusArrayDAO.getArraysWithoutParentArray("1234");

		// assert
		assertEquals(1, result.size());
		// pojo String (String) result.get(0)
	}

	@Test
	public void getChildrenArrays() throws org.hibernate.HibernateException {

		// arrange
		ThesaurusArrayDAO thesaurusArrayDAO = new ThesaurusArrayDAO();
		List list = new ArrayList<String>();
		list.add("Smith");
		Criteria criteria1 = mock(Criteria.class);
		Criteria criteria2 = mock(Criteria.class);
		when(criteria2.add(Mockito.<org.hibernate.criterion.Criterion>any()))
			.thenReturn(criteria1);
		when(criteria2.list())
			.thenReturn(list);
		Session session = mock(Session.class);
		when(session.createCriteria(Mockito.<Class>any(), Mockito.<String>any()))
			.thenReturn(criteria2);
		SessionFactory sessionFactory = mock(SessionFactory.class);
		when(sessionFactory.getCurrentSession())
			.thenReturn(session);
		thesaurusArrayDAO.setSessionFactory(sessionFactory);

		// act
		List<ThesaurusArray> result = thesaurusArrayDAO.getChildrenArrays("1234");

		// assert
		assertEquals(1, result.size());
		// pojo String (String) result.get(0)
	}
}
