package fr.mcc.ginco.dao.hibernate;

import static org.junit.Assert.assertNull;
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
 * Unit tests for fr.mcc.ginco.dao.hibernate.UserRoleDAO
 *
 * @author Diffblue Cover
 */

public class UserRoleDAOTest {

	@Test
	public void factory() throws org.hibernate.HibernateException, javax.naming.NamingException {
		UserRoleDAO userRoleDAO = new UserRoleDAO();
		SessionFactory sessionFactory = mock(SessionFactory.class);
		userRoleDAO.setSessionFactory(sessionFactory);
		assertSame(sessionFactory, userRoleDAO.getSessionFactory());
	}

	@Test
	public void getUserRoleOnThesaurusThesaurusIdIsRootReturnsNull() throws org.hibernate.HibernateException, org.hibernate.UnknownProfileException, javax.naming.NamingException {
		UserRoleDAO userRoleDAO = new UserRoleDAO();
		Criteria criteria1 = mock(Criteria.class);
		Criteria criteria2 = mock(Criteria.class);
		Criteria criteria3 = mock(Criteria.class);
		when(criteria3.add(Mockito.<org.hibernate.criterion.Criterion>any()))
			.thenReturn(criteria2)
			.thenReturn(criteria1);
		when(criteria3.list())
			.thenReturn(new ArrayList());
		Session session = mock(Session.class);
		when(session.createCriteria(Mockito.<Class>any()))
			.thenReturn(criteria3);
		SessionFactory sessionFactory = mock(SessionFactory.class);
		when(sessionFactory.getCurrentSession())
			.thenReturn(session);
		userRoleDAO.setSessionFactory(sessionFactory);
		assertNull(userRoleDAO.getUserRoleOnThesaurus("John Smith", "root"));
	}

	@Test
	public void getUserRolesOnThesaurusThesaurusIdIsRootReturnsEmpty() throws org.hibernate.HibernateException, org.hibernate.UnknownProfileException, javax.naming.NamingException {
		UserRoleDAO userRoleDAO = new UserRoleDAO();
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
		userRoleDAO.setSessionFactory(sessionFactory);
		assertTrue((userRoleDAO.getUserRolesOnThesaurus("root")).isEmpty());
	}

	@Test
	public void getUserRolesReturnsEmpty() throws org.hibernate.HibernateException, org.hibernate.UnknownProfileException, javax.naming.NamingException {
		UserRoleDAO userRoleDAO = new UserRoleDAO();
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
		userRoleDAO.setSessionFactory(sessionFactory);
		assertTrue((userRoleDAO.getUserRoles("John Smith")).isEmpty());
	}
}
