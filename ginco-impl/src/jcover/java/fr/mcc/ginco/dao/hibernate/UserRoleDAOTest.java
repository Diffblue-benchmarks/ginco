package fr.mcc.ginco.dao.hibernate;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import fr.mcc.ginco.beans.UserRole;

import java.util.ArrayList;
import java.util.List;

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
	public void factory() {
		UserRoleDAO userRoleDAO = new UserRoleDAO();
		SessionFactory sessionFactory = mock(SessionFactory.class);
		userRoleDAO.setSessionFactory(sessionFactory);
		assertSame(sessionFactory, userRoleDAO.getSessionFactory());
	}

	@Test
	public void getUserRoleOnThesaurusThesaurusIdIsAdminAndUsernameIsBarReturnsNull() throws org.hibernate.HibernateException {
		UserRoleDAO userRoleDAO = new UserRoleDAO();
		Criteria criteria1 = mock(Criteria.class);
		Criteria criteria2 = mock(Criteria.class);
		Criteria criteria3 = mock(Criteria.class);
		when(criteria3.add(Mockito.<org.hibernate.criterion.Criterion>any()))
			.thenReturn(criteria2)
			.thenReturn(criteria1);
		when(criteria3.list())
			.thenReturn(new ArrayList<String>());
		Session session = mock(Session.class);
		when(session.createCriteria(Mockito.<Class>any()))
			.thenReturn(criteria3);
		SessionFactory sessionFactory = mock(SessionFactory.class);
		when(sessionFactory.getCurrentSession())
			.thenReturn(session);
		userRoleDAO.setSessionFactory(sessionFactory);
		assertNull(userRoleDAO.getUserRoleOnThesaurus("bar", "admin"));
	}

	@Test
	public void getUserRolesOnThesaurusThesaurusIdIsRoot() throws org.hibernate.HibernateException {

		// arrange
		UserRoleDAO userRoleDAO = new UserRoleDAO();
		List list = new ArrayList<String>();
		list.add("foo");
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
		userRoleDAO.setSessionFactory(sessionFactory);

		// act
		List<UserRole> result = userRoleDAO.getUserRolesOnThesaurus("root");

		// assert
		assertEquals(1, result.size());
		// pojo String (String) result.get(0)
	}

	@Test
	public void getUserRolesUsernameIsRoot() throws org.hibernate.HibernateException {

		// arrange
		UserRoleDAO userRoleDAO = new UserRoleDAO();
		List list = new ArrayList<String>();
		list.add("foo");
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
		userRoleDAO.setSessionFactory(sessionFactory);

		// act
		List<UserRole> result = userRoleDAO.getUserRoles("root");

		// assert
		assertEquals(1, result.size());
		// pojo String (String) result.get(0)
	}
}
