package fr.mcc.ginco.dao.hibernate;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import fr.mcc.ginco.beans.Role;
import fr.mcc.ginco.beans.Thesaurus;
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
	public void factory() throws org.hibernate.HibernateException, javax.naming.NamingException {
		UserRoleDAO userRoleDAO = new UserRoleDAO();
		SessionFactory sessionFactory = mock(SessionFactory.class);
		userRoleDAO.setSessionFactory(sessionFactory);
		assertSame(sessionFactory, userRoleDAO.getSessionFactory());
	}

	@Test
	public void getUserRoleOnThesaurusUsernameIsAdmin() throws org.hibernate.HibernateException, org.hibernate.UnknownProfileException, javax.naming.NamingException {

		// arrange
		UserRoleDAO userRoleDAO = new UserRoleDAO();
		List list = new ArrayList();
		UserRole userRole = new UserRole();
		userRole.setIdentifier(1);
		userRole.setRole(Role.MANAGER);
		Thesaurus thesaurus = mock(Thesaurus.class);
		userRole.setThesaurus(thesaurus);
		userRole.setUsername("root");
		list.add(userRole);
		Criteria criteria1 = mock(Criteria.class);
		Criteria criteria2 = mock(Criteria.class);
		Criteria criteria3 = mock(Criteria.class);
		when(criteria3.add(Mockito.<org.hibernate.criterion.Criterion>any()))
			.thenReturn(criteria2)
			.thenReturn(criteria1);
		when(criteria3.list())
			.thenReturn(list);
		Session session = mock(Session.class);
		when(session.createCriteria(Mockito.<Class>any()))
			.thenReturn(criteria3);
		SessionFactory sessionFactory = mock(SessionFactory.class);
		when(sessionFactory.getCurrentSession())
			.thenReturn(session);
		userRoleDAO.setSessionFactory(sessionFactory);

		// act
		UserRole result = userRoleDAO.getUserRoleOnThesaurus("admin", "admin");

		// assert
		assertEquals(1, (int) result.getIdentifier());
		assertTrue(Role.MANAGER == result.getRole());
		assertSame(thesaurus, result.getThesaurus());
		assertEquals("root", result.getUsername());
	}

	@Test
	public void getUserRoleOnThesaurusUsernameIsBarReturnsNull() throws org.hibernate.HibernateException, org.hibernate.UnknownProfileException, javax.naming.NamingException {
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
		assertNull(userRoleDAO.getUserRoleOnThesaurus("bar", "admin"));
	}

	@Test
	public void getUserRolesOnThesaurusThesaurusIdIsRoot() throws org.hibernate.HibernateException, org.hibernate.UnknownProfileException, javax.naming.NamingException {

		// arrange
		UserRoleDAO userRoleDAO = new UserRoleDAO();
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
		userRoleDAO.setSessionFactory(sessionFactory);

		// act
		List<UserRole> result = userRoleDAO.getUserRolesOnThesaurus("root");

		// assert
		assertEquals(1, result.size());
		// pojo Object
	}

	@Test
	public void getUserRolesUsernameIsRoot() throws org.hibernate.HibernateException, org.hibernate.UnknownProfileException, javax.naming.NamingException {

		// arrange
		UserRoleDAO userRoleDAO = new UserRoleDAO();
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
		userRoleDAO.setSessionFactory(sessionFactory);

		// act
		List<UserRole> result = userRoleDAO.getUserRoles("root");

		// assert
		assertEquals(1, result.size());
		// pojo Object
	}
}
