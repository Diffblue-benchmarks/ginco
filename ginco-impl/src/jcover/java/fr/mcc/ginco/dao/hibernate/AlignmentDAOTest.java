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
 * Unit tests for fr.mcc.ginco.dao.hibernate.AlignmentDAO
 *
 * @author Diffblue Cover
 */

public class AlignmentDAOTest {

	@Test
	public void factory() throws org.hibernate.HibernateException, javax.naming.NamingException {
		AlignmentDAO alignmentDAO = new AlignmentDAO();
		SessionFactory sessionFactory = mock(SessionFactory.class);
		alignmentDAO.setSessionFactory(sessionFactory);
		assertSame(sessionFactory, alignmentDAO.getSessionFactory());
	}

	@Test
	public void findBySourceConceptIdReturnsEmpty() throws org.hibernate.HibernateException, org.hibernate.UnknownProfileException, javax.naming.NamingException {
		AlignmentDAO alignmentDAO = new AlignmentDAO();
		Criteria criteria1 = mock(Criteria.class);
		Criteria criteria2 = mock(Criteria.class);
		when(criteria2.add(Mockito.<org.hibernate.criterion.Criterion>any()))
			.thenReturn(criteria1);
		when(criteria2.list())
			.thenReturn(new ArrayList());
		Session session = mock(Session.class);
		when(session.createCriteria(Mockito.<Class>any()))
			.thenReturn(criteria2);
		SessionFactory sessionFactory = mock(SessionFactory.class);
		when(sessionFactory.getCurrentSession())
			.thenReturn(session);
		alignmentDAO.setSessionFactory(sessionFactory);
		assertTrue((alignmentDAO.findBySourceConceptId("1234")).isEmpty());
	}

	@Test
	public void findByTargetConceptIdReturnsEmpty() throws org.hibernate.HibernateException, org.hibernate.UnknownProfileException, javax.naming.NamingException {
		AlignmentDAO alignmentDAO = new AlignmentDAO();
		Criteria criteria1 = mock(Criteria.class);
		Criteria criteria2 = mock(Criteria.class);
		Criteria criteria3 = mock(Criteria.class);
		when(criteria3.add(Mockito.<org.hibernate.criterion.Criterion>any()))
			.thenReturn(criteria1);
		when(criteria3.createAlias(Mockito.<String>any(), Mockito.<String>any()))
			.thenReturn(criteria2);
		when(criteria3.list())
			.thenReturn(new ArrayList());
		Session session = mock(Session.class);
		when(session.createCriteria(Mockito.<Class>any()))
			.thenReturn(criteria3);
		SessionFactory sessionFactory = mock(SessionFactory.class);
		when(sessionFactory.getCurrentSession())
			.thenReturn(session);
		alignmentDAO.setSessionFactory(sessionFactory);
		assertTrue((alignmentDAO.findByTargetConceptId("1234")).isEmpty());
	}

	@Test
	public void findByExternalThesaurusExternalThesaurusIdIsOneReturnsEmpty() throws org.hibernate.HibernateException, org.hibernate.UnknownProfileException, javax.naming.NamingException {
		AlignmentDAO alignmentDAO = new AlignmentDAO();
		Criteria criteria1 = mock(Criteria.class);
		Criteria criteria2 = mock(Criteria.class);
		when(criteria2.add(Mockito.<org.hibernate.criterion.Criterion>any()))
			.thenReturn(criteria1);
		when(criteria2.list())
			.thenReturn(new ArrayList());
		Session session = mock(Session.class);
		when(session.createCriteria(Mockito.<Class>any()))
			.thenReturn(criteria2);
		SessionFactory sessionFactory = mock(SessionFactory.class);
		when(sessionFactory.getCurrentSession())
			.thenReturn(session);
		alignmentDAO.setSessionFactory(sessionFactory);
		assertTrue((alignmentDAO.findByExternalThesaurus(1)).isEmpty());
	}
}
