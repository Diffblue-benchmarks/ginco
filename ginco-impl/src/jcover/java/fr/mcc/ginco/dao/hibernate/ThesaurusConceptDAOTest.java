package fr.mcc.ginco.dao.hibernate;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;
import org.mockito.Mockito;

/**
 * Unit tests for fr.mcc.ginco.dao.hibernate.ThesaurusConceptDAO
 *
 * @author Diffblue Cover
 */

public class ThesaurusConceptDAOTest {

	@Test
	public void factory() throws org.hibernate.HibernateException, javax.naming.NamingException {
		ThesaurusConceptDAO thesaurusConceptDAO = new ThesaurusConceptDAO();
		SessionFactory sessionFactory = mock(SessionFactory.class);
		thesaurusConceptDAO.setSessionFactory(sessionFactory);
		assertSame(sessionFactory, thesaurusConceptDAO.getSessionFactory());
	}

	@Test
	public void countConceptsReturnsOne() throws org.hibernate.HibernateException, org.hibernate.UnknownProfileException, javax.naming.NamingException {
		ThesaurusConceptDAO thesaurusConceptDAO = new ThesaurusConceptDAO();
		List list = new ArrayList();
		list.add(1L);
		Criteria criteria1 = mock(Criteria.class);
		Criteria criteria2 = mock(Criteria.class);
		when(criteria2.setProjection(Mockito.<org.hibernate.criterion.Projection>any()))
			.thenReturn(criteria1);
		Criteria criteria3 = mock(Criteria.class);
		when(criteria3.add(Mockito.<org.hibernate.criterion.Criterion>any()))
			.thenReturn(criteria2);
		when(criteria3.list())
			.thenReturn(list);
		Session session = mock(Session.class);
		when(session.createCriteria(Mockito.<Class>any()))
			.thenReturn(criteria3);
		SessionFactory sessionFactory = mock(SessionFactory.class);
		when(sessionFactory.getCurrentSession())
			.thenReturn(session);
		thesaurusConceptDAO.setSessionFactory(sessionFactory);
		assertEquals(1L, (long) thesaurusConceptDAO.countConcepts("1234"));
	}

	@Test
	public void countConceptsWoNotesReturnsOne() throws org.hibernate.HibernateException, org.hibernate.MappingException, org.hibernate.UnknownProfileException, javax.naming.NamingException {
		ThesaurusConceptDAO thesaurusConceptDAO = new ThesaurusConceptDAO();
		List list = new ArrayList();
		list.add(BigInteger.valueOf(1L));
		Query query = mock(Query.class);
		SQLQuery obj = mock(SQLQuery.class);
		when(obj.list())
			.thenReturn(list);
		when(obj.setParameter(Mockito.<String>any(), Mockito.<Object>any()))
			.thenReturn(query);
		Session session = mock(Session.class);
		when(session.createSQLQuery(Mockito.<String>any()))
			.thenReturn(obj);
		SessionFactory sessionFactory = mock(SessionFactory.class);
		when(sessionFactory.getCurrentSession())
			.thenReturn(session);
		thesaurusConceptDAO.setSessionFactory(sessionFactory);
		assertEquals(1L, (long) thesaurusConceptDAO.countConceptsWoNotes("1234"));
	}

	@Test
	public void countConceptsAlignedToExtThesIdThesaurusIsHelloReturnsOne() throws org.hibernate.HibernateException, org.hibernate.UnknownProfileException, javax.naming.NamingException {
		ThesaurusConceptDAO thesaurusConceptDAO = new ThesaurusConceptDAO();
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
		when(session.createCriteria(Mockito.<Class>any(), Mockito.<String>any()))
			.thenReturn(criteria3);
		SessionFactory sessionFactory = mock(SessionFactory.class);
		when(sessionFactory.getCurrentSession())
			.thenReturn(session);
		thesaurusConceptDAO.setSessionFactory(sessionFactory);
		assertEquals(1L, (long) thesaurusConceptDAO.countConceptsAlignedToExtThes("hello"));
	}
}
