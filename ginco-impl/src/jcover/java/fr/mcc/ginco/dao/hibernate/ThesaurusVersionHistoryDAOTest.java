package fr.mcc.ginco.dao.hibernate;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import fr.mcc.ginco.beans.ThesaurusVersionHistory;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;
import org.mockito.Mockito;

/**
 * Unit tests for fr.mcc.ginco.dao.hibernate.ThesaurusVersionHistoryDAO
 *
 * @author Diffblue Cover
 */

public class ThesaurusVersionHistoryDAOTest {

	@Test
	public void factory() {
		ThesaurusVersionHistoryDAO thesaurusVersionHistoryDAO =
			 new ThesaurusVersionHistoryDAO();
		SessionFactory sessionFactory = mock(SessionFactory.class);
		thesaurusVersionHistoryDAO.setSessionFactory(sessionFactory);
		assertSame(sessionFactory, thesaurusVersionHistoryDAO.getSessionFactory());
	}

	@Test
	public void findVersionsByThesaurusId() throws org.hibernate.HibernateException {

		// arrange
		ThesaurusVersionHistoryDAO thesaurusVersionHistoryDAO =
			 new ThesaurusVersionHistoryDAO();
		ArrayList<String> arrayList = new ArrayList<String>();
		arrayList.add("Smith");
		Criteria criteria1 = mock(Criteria.class);
		Criteria criteria2 = mock(Criteria.class);
		Criteria criteria3 = mock(Criteria.class);
		when(criteria3.add(Mockito.<org.hibernate.criterion.Criterion>any()))
			.thenReturn(criteria2);
		when(criteria3.addOrder(Mockito.<org.hibernate.criterion.Order>any()))
			.thenReturn(criteria1);
		when(criteria3.list())
			.thenReturn(arrayList);
		Session session = mock(Session.class);
		when(session.createCriteria(Mockito.<Class>any(), Mockito.<String>any()))
			.thenReturn(criteria3);
		SessionFactory sessionFactory = mock(SessionFactory.class);
		when(sessionFactory.getCurrentSession())
			.thenReturn(session);
		thesaurusVersionHistoryDAO.setSessionFactory(sessionFactory);

		// act
		List<ThesaurusVersionHistory> result =
			 thesaurusVersionHistoryDAO.findVersionsByThesaurusId("1234");

		// assert
		assertEquals(1, result.size());
		// pojo String (String) result.get(0)
	}

	@Test
	public void findAllOtherThisVersionTrueByThesaurusId() throws org.hibernate.HibernateException {

		// arrange
		ThesaurusVersionHistoryDAO thesaurusVersionHistoryDAO =
			 new ThesaurusVersionHistoryDAO();
		ArrayList<String> arrayList = new ArrayList<String>();
		arrayList.add("Smith");
		Criteria criteria1 = mock(Criteria.class);
		Criteria criteria2 = mock(Criteria.class);
		Criteria criteria3 = mock(Criteria.class);
		Criteria criteria4 = mock(Criteria.class);
		when(criteria4.add(Mockito.<org.hibernate.criterion.Criterion>any()))
			.thenReturn(criteria3)
			.thenReturn(criteria2)
			.thenReturn(criteria1);
		when(criteria4.list())
			.thenReturn(arrayList);
		Session session = mock(Session.class);
		when(session.createCriteria(Mockito.<Class>any(), Mockito.<String>any()))
			.thenReturn(criteria4);
		SessionFactory sessionFactory = mock(SessionFactory.class);
		when(sessionFactory.getCurrentSession())
			.thenReturn(session);
		thesaurusVersionHistoryDAO.setSessionFactory(sessionFactory);

		// act
		List<ThesaurusVersionHistory> result =
			 thesaurusVersionHistoryDAO.findAllOtherThisVersionTrueByThesaurusId("1234", "1234");

		// assert
		assertEquals(1, result.size());
		// pojo String (String) result.get(0)
	}

	@Test
	public void findThisVersionByThesaurusIdReturnsNull() throws org.hibernate.HibernateException {
		ThesaurusVersionHistoryDAO thesaurusVersionHistoryDAO =
			 new ThesaurusVersionHistoryDAO();
		Criteria criteria1 = mock(Criteria.class);
		Criteria criteria2 = mock(Criteria.class);
		Criteria criteria3 = mock(Criteria.class);
		when(criteria3.add(Mockito.<org.hibernate.criterion.Criterion>any()))
			.thenReturn(criteria2)
			.thenReturn(criteria1);
		when(criteria3.list())
			.thenReturn(new ArrayList<String>());
		Session session = mock(Session.class);
		when(session.createCriteria(Mockito.<Class>any(), Mockito.<String>any()))
			.thenReturn(criteria3);
		SessionFactory sessionFactory = mock(SessionFactory.class);
		when(sessionFactory.getCurrentSession())
			.thenReturn(session);
		thesaurusVersionHistoryDAO.setSessionFactory(sessionFactory);
		assertNull(thesaurusVersionHistoryDAO.findThisVersionByThesaurusId("1234"));
	}

	@Test
	public void getLastPublishedVersionByThesaurusIdReturnsNull() throws org.hibernate.HibernateException {
		ThesaurusVersionHistoryDAO thesaurusVersionHistoryDAO =
			 new ThesaurusVersionHistoryDAO();
		Criteria criteria1 = mock(Criteria.class);
		Criteria criteria2 = mock(Criteria.class);
		Criteria criteria3 = mock(Criteria.class);
		Criteria criteria4 = mock(Criteria.class);
		when(criteria4.add(Mockito.<org.hibernate.criterion.Criterion>any()))
			.thenReturn(criteria3)
			.thenReturn(criteria2);
		when(criteria4.addOrder(Mockito.<org.hibernate.criterion.Order>any()))
			.thenReturn(criteria1);
		when(criteria4.list())
			.thenReturn(new ArrayList<String>());
		Session session = mock(Session.class);
		when(session.createCriteria(Mockito.<Class>any(), Mockito.<String>any()))
			.thenReturn(criteria4);
		SessionFactory sessionFactory = mock(SessionFactory.class);
		when(sessionFactory.getCurrentSession())
			.thenReturn(session);
		thesaurusVersionHistoryDAO.setSessionFactory(sessionFactory);
		assertNull(thesaurusVersionHistoryDAO.getLastPublishedVersionByThesaurusId("1234"));
	}
}
