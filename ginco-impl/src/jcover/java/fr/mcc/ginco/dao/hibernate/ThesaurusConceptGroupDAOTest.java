package fr.mcc.ginco.dao.hibernate;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;
import org.mockito.Mockito;

/**
 * Unit tests for fr.mcc.ginco.dao.hibernate.ThesaurusConceptGroupDAO
 *
 * @author Diffblue Cover
 */

public class ThesaurusConceptGroupDAOTest {

	@Test
	public void factory() throws org.hibernate.HibernateException, javax.naming.NamingException {
		ThesaurusConceptGroupDAO thesaurusConceptGroupDAO =
			 new ThesaurusConceptGroupDAO();
		SessionFactory sessionFactory = mock(SessionFactory.class);
		thesaurusConceptGroupDAO.setSessionFactory(sessionFactory);
		assertSame(sessionFactory, thesaurusConceptGroupDAO.getSessionFactory());
	}

	@Test
	public void findThesaurusConceptGroupsByThesaurusIdReturnsEmpty() throws org.hibernate.HibernateException, org.hibernate.UnknownProfileException, javax.naming.NamingException {
		ThesaurusConceptGroupDAO thesaurusConceptGroupDAO =
			 new ThesaurusConceptGroupDAO();
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
		thesaurusConceptGroupDAO.setSessionFactory(sessionFactory);
		assertTrue((thesaurusConceptGroupDAO.findThesaurusConceptGroupsByThesaurusId("1234", "1234")).isEmpty());
	}

	@Test
	public void countItemsReturnsOne() throws org.hibernate.HibernateException, org.hibernate.UnknownProfileException, javax.naming.NamingException {
		ThesaurusConceptGroupDAO thesaurusConceptGroupDAO =
			 new ThesaurusConceptGroupDAO();
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
		thesaurusConceptGroupDAO.setSessionFactory(sessionFactory);
		assertEquals(1L, (long) thesaurusConceptGroupDAO.countItems("1234"));
	}

	@Test
	public void getChildGroupsReturnsEmpty() throws org.hibernate.HibernateException, org.hibernate.UnknownProfileException, javax.naming.NamingException {
		ThesaurusConceptGroupDAO thesaurusConceptGroupDAO =
			 new ThesaurusConceptGroupDAO();
		Criteria criteria1 = mock(Criteria.class);
		Criteria criteria2 = mock(Criteria.class);
		when(criteria2.add(Mockito.<org.hibernate.criterion.Criterion>any()))
			.thenReturn(criteria1);
		when(criteria2.list())
			.thenReturn(new ArrayList());
		Session session = mock(Session.class);
		when(session.createCriteria(Mockito.<Class>any(), Mockito.<String>any()))
			.thenReturn(criteria2);
		SessionFactory sessionFactory = mock(SessionFactory.class);
		when(sessionFactory.getCurrentSession())
			.thenReturn(session);
		thesaurusConceptGroupDAO.setSessionFactory(sessionFactory);
		assertTrue((thesaurusConceptGroupDAO.getChildGroups("1234")).isEmpty());
	}
}
