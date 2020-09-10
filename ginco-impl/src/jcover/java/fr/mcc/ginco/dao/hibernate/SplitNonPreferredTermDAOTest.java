package fr.mcc.ginco.dao.hibernate;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
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
 * Unit tests for fr.mcc.ginco.dao.hibernate.SplitNonPreferredTermDAO
 *
 * @author Diffblue Cover
 */

public class SplitNonPreferredTermDAOTest {

	@Test
	public void factory() throws org.hibernate.HibernateException, javax.naming.NamingException {
		SplitNonPreferredTermDAO splitNonPreferredTermDAO =
			 new SplitNonPreferredTermDAO();
		SessionFactory sessionFactory = mock(SessionFactory.class);
		splitNonPreferredTermDAO.setSessionFactory(sessionFactory);
		assertSame(sessionFactory, splitNonPreferredTermDAO.getSessionFactory());
	}

	@Test
	public void countItemsReturnsOne() throws org.hibernate.HibernateException, org.hibernate.UnknownProfileException, javax.naming.NamingException {
		SplitNonPreferredTermDAO splitNonPreferredTermDAO =
			 new SplitNonPreferredTermDAO();
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
		splitNonPreferredTermDAO.setSessionFactory(sessionFactory);
		assertEquals(1L, (long) splitNonPreferredTermDAO.countItems("1234"));
	}
}
