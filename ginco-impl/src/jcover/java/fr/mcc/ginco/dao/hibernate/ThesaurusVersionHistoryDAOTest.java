package fr.mcc.ginco.dao.hibernate;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import fr.mcc.ginco.beans.Thesaurus;
import fr.mcc.ginco.beans.ThesaurusVersionHistory;

import java.util.ArrayList;
import java.util.Date;
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
	public void factory() throws org.hibernate.HibernateException, javax.naming.NamingException {
		ThesaurusVersionHistoryDAO thesaurusVersionHistoryDAO =
			 new ThesaurusVersionHistoryDAO();
		SessionFactory sessionFactory = mock(SessionFactory.class);
		thesaurusVersionHistoryDAO.setSessionFactory(sessionFactory);
		assertSame(sessionFactory, thesaurusVersionHistoryDAO.getSessionFactory());
	}

	@Test
	public void findVersionsByThesaurusId() throws org.hibernate.HibernateException, org.hibernate.UnknownProfileException, javax.naming.NamingException {

		// arrange
		ThesaurusVersionHistoryDAO thesaurusVersionHistoryDAO =
			 new ThesaurusVersionHistoryDAO();
		List list = new ArrayList();
		list.add(new Object());
		Criteria criteria1 = mock(Criteria.class);
		Criteria criteria2 = mock(Criteria.class);
		Criteria criteria3 = mock(Criteria.class);
		when(criteria3.add(Mockito.<org.hibernate.criterion.Criterion>any()))
			.thenReturn(criteria2);
		when(criteria3.addOrder(Mockito.<org.hibernate.criterion.Order>any()))
			.thenReturn(criteria1);
		when(criteria3.list())
			.thenReturn(list);
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
		// pojo Object
	}

	@Test
	public void findAllOtherThisVersionTrueByThesaurusId() throws org.hibernate.HibernateException, org.hibernate.UnknownProfileException, javax.naming.NamingException {

		// arrange
		ThesaurusVersionHistoryDAO thesaurusVersionHistoryDAO =
			 new ThesaurusVersionHistoryDAO();
		List list = new ArrayList();
		list.add(new Object());
		Criteria criteria1 = mock(Criteria.class);
		Criteria criteria2 = mock(Criteria.class);
		Criteria criteria3 = mock(Criteria.class);
		Criteria criteria4 = mock(Criteria.class);
		when(criteria4.add(Mockito.<org.hibernate.criterion.Criterion>any()))
			.thenReturn(criteria3)
			.thenReturn(criteria2)
			.thenReturn(criteria1);
		when(criteria4.list())
			.thenReturn(list);
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
		// pojo Object
	}

	@Test
	public void findThisVersionByThesaurusId() throws java.text.ParseException, org.hibernate.HibernateException, org.hibernate.UnknownProfileException, javax.naming.NamingException {

		// arrange
		ThesaurusVersionHistoryDAO thesaurusVersionHistoryDAO =
			 new ThesaurusVersionHistoryDAO();
		List list1 = new ArrayList();
		ThesaurusVersionHistory thesaurusVersionHistory =
			 new ThesaurusVersionHistory();
		Date date3 =
			 new java.text.SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31");
		thesaurusVersionHistory.setDate(date3);
		thesaurusVersionHistory.setIdentifier("data");
		thesaurusVersionHistory.setStatus(1);
		Thesaurus thesaurus = new Thesaurus();
		thesaurusVersionHistory.setThesaurus(thesaurus);
		thesaurusVersionHistory.setThisVersion(false);
		thesaurusVersionHistory.setUserId("root");
		thesaurusVersionHistory.setVersionNote("1.0");
		list1.add(thesaurusVersionHistory);
		List list2 = new ArrayList();
		list2.add(new Object());
		Criteria criteria1 = mock(Criteria.class);
		Criteria criteria2 = mock(Criteria.class);
		Criteria criteria3 = mock(Criteria.class);
		when(criteria3.add(Mockito.<org.hibernate.criterion.Criterion>any()))
			.thenReturn(criteria2)
			.thenReturn(criteria1);
		when(criteria3.list())
			.thenReturn(list2)
			.thenReturn(list1);
		Session session = mock(Session.class);
		when(session.createCriteria(Mockito.<Class>any(), Mockito.<String>any()))
			.thenReturn(criteria3);
		SessionFactory sessionFactory = mock(SessionFactory.class);
		when(sessionFactory.getCurrentSession())
			.thenReturn(session);
		thesaurusVersionHistoryDAO.setSessionFactory(sessionFactory);

		// act
		ThesaurusVersionHistory result =
			 thesaurusVersionHistoryDAO.findThisVersionByThesaurusId("1234");

		// assert
		assertSame(date3, result.getDate());
		assertEquals("data", result.getIdentifier());
		assertEquals(1, (int) result.getStatus());
		assertSame(thesaurus, result.getThesaurus());
		assertFalse(result.getThisVersion());
		assertEquals("root", result.getUserId());
		assertEquals("1.0", result.getVersionNote());
	}

	@Test
	public void findThisVersionByThesaurusIdReturnsNull() throws org.hibernate.HibernateException, org.hibernate.UnknownProfileException, javax.naming.NamingException {
		ThesaurusVersionHistoryDAO thesaurusVersionHistoryDAO =
			 new ThesaurusVersionHistoryDAO();
		Criteria criteria1 = mock(Criteria.class);
		Criteria criteria2 = mock(Criteria.class);
		Criteria criteria3 = mock(Criteria.class);
		when(criteria3.add(Mockito.<org.hibernate.criterion.Criterion>any()))
			.thenReturn(criteria2)
			.thenReturn(criteria1);
		when(criteria3.list())
			.thenReturn(new ArrayList());
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
	public void getLastPublishedVersionByThesaurusId() throws java.text.ParseException, org.hibernate.HibernateException, org.hibernate.UnknownProfileException, javax.naming.NamingException {

		// arrange
		ThesaurusVersionHistoryDAO thesaurusVersionHistoryDAO =
			 new ThesaurusVersionHistoryDAO();
		List list1 = new ArrayList();
		ThesaurusVersionHistory thesaurusVersionHistory =
			 new ThesaurusVersionHistory();
		Date date3 =
			 new java.text.SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31");
		thesaurusVersionHistory.setDate(date3);
		thesaurusVersionHistory.setIdentifier("data");
		thesaurusVersionHistory.setStatus(1);
		Thesaurus thesaurus = new Thesaurus();
		thesaurusVersionHistory.setThesaurus(thesaurus);
		thesaurusVersionHistory.setThisVersion(false);
		thesaurusVersionHistory.setUserId("root");
		thesaurusVersionHistory.setVersionNote("1.0");
		list1.add(thesaurusVersionHistory);
		List list2 = new ArrayList();
		list2.add(new Object());
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
			.thenReturn(list2)
			.thenReturn(list1);
		Session session = mock(Session.class);
		when(session.createCriteria(Mockito.<Class>any(), Mockito.<String>any()))
			.thenReturn(criteria4);
		SessionFactory sessionFactory = mock(SessionFactory.class);
		when(sessionFactory.getCurrentSession())
			.thenReturn(session);
		thesaurusVersionHistoryDAO.setSessionFactory(sessionFactory);

		// act
		ThesaurusVersionHistory result =
			 thesaurusVersionHistoryDAO.getLastPublishedVersionByThesaurusId("1234");

		// assert
		assertSame(date3, result.getDate());
		assertEquals("data", result.getIdentifier());
		assertEquals(1, (int) result.getStatus());
		assertSame(thesaurus, result.getThesaurus());
		assertFalse(result.getThisVersion());
		assertEquals("root", result.getUserId());
		assertEquals("1.0", result.getVersionNote());
	}

	@Test
	public void getLastPublishedVersionByThesaurusIdReturnsNull() throws org.hibernate.HibernateException, org.hibernate.UnknownProfileException, javax.naming.NamingException {
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
			.thenReturn(new ArrayList());
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
