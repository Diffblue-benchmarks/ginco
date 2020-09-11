package fr.mcc.ginco.dao.hibernate;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import fr.mcc.ginco.beans.Alignment;

import java.util.ArrayList;
import java.util.List;

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
	public void findBySourceConceptId() throws org.hibernate.HibernateException, org.hibernate.UnknownProfileException, javax.naming.NamingException {

		// arrange
		AlignmentDAO alignmentDAO = new AlignmentDAO();
		List list = new ArrayList();
		list.add(new Object());
		Criteria criteria1 = mock(Criteria.class);
		Criteria criteria2 = mock(Criteria.class);
		when(criteria2.add(Mockito.<org.hibernate.criterion.Criterion>any()))
			.thenReturn(criteria1);
		when(criteria2.list())
			.thenReturn(list);
		Session session = mock(Session.class);
		when(session.createCriteria(Mockito.<Class>any()))
			.thenReturn(criteria2);
		SessionFactory sessionFactory = mock(SessionFactory.class);
		when(sessionFactory.getCurrentSession())
			.thenReturn(session);
		alignmentDAO.setSessionFactory(sessionFactory);

		// act
		List<Alignment> result = alignmentDAO.findBySourceConceptId("1234");

		// assert
		assertEquals(1, result.size());
		// pojo Object
	}

	@Test
	public void findByTargetConceptId() throws org.hibernate.HibernateException, org.hibernate.UnknownProfileException, javax.naming.NamingException {

		// arrange
		AlignmentDAO alignmentDAO = new AlignmentDAO();
		List list = new ArrayList();
		list.add(new Object());
		Criteria criteria1 = mock(Criteria.class);
		Criteria criteria2 = mock(Criteria.class);
		Criteria criteria3 = mock(Criteria.class);
		when(criteria3.add(Mockito.<org.hibernate.criterion.Criterion>any()))
			.thenReturn(criteria1);
		when(criteria3.createAlias(Mockito.<String>any(), Mockito.<String>any()))
			.thenReturn(criteria2);
		when(criteria3.list())
			.thenReturn(list);
		Session session = mock(Session.class);
		when(session.createCriteria(Mockito.<Class>any()))
			.thenReturn(criteria3);
		SessionFactory sessionFactory = mock(SessionFactory.class);
		when(sessionFactory.getCurrentSession())
			.thenReturn(session);
		alignmentDAO.setSessionFactory(sessionFactory);

		// act
		List<Alignment> result = alignmentDAO.findByTargetConceptId("1234");

		// assert
		assertEquals(1, result.size());
		// pojo Object
	}

	@Test
	public void findByExternalThesaurusExternalThesaurusIdIsOne() throws org.hibernate.HibernateException, org.hibernate.UnknownProfileException, javax.naming.NamingException {

		// arrange
		AlignmentDAO alignmentDAO = new AlignmentDAO();
		List list = new ArrayList();
		list.add(new Object());
		Criteria criteria1 = mock(Criteria.class);
		Criteria criteria2 = mock(Criteria.class);
		when(criteria2.add(Mockito.<org.hibernate.criterion.Criterion>any()))
			.thenReturn(criteria1);
		when(criteria2.list())
			.thenReturn(list);
		Session session = mock(Session.class);
		when(session.createCriteria(Mockito.<Class>any()))
			.thenReturn(criteria2);
		SessionFactory sessionFactory = mock(SessionFactory.class);
		when(sessionFactory.getCurrentSession())
			.thenReturn(session);
		alignmentDAO.setSessionFactory(sessionFactory);

		// act
		List<Alignment> result = alignmentDAO.findByExternalThesaurus(1);

		// assert
		assertEquals(1, result.size());
		// pojo Object
	}
}
