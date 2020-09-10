package fr.mcc.ginco.dao.hibernate;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import fr.mcc.ginco.beans.AssociativeRelationshipRole;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;
import org.mockito.Mockito;

/**
 * Unit tests for fr.mcc.ginco.dao.hibernate.AssociativeRelationshipRoleDAO
 *
 * @author Diffblue Cover
 */

public class AssociativeRelationshipRoleDAOTest {

	@Test
	public void factory() throws org.hibernate.HibernateException, javax.naming.NamingException {
		AssociativeRelationshipRoleDAO associativeRelationshipRoleDAO =
			 new AssociativeRelationshipRoleDAO();
		SessionFactory sessionFactory = mock(SessionFactory.class);
		associativeRelationshipRoleDAO.setSessionFactory(sessionFactory);
		assertSame(sessionFactory, associativeRelationshipRoleDAO.getSessionFactory());
	}

	@Test
	public void getDefaultAssociativeRelationshipRole() throws org.hibernate.HibernateException, org.hibernate.UnknownProfileException, javax.naming.NamingException {

		// arrange
		AssociativeRelationshipRoleDAO associativeRelationshipRoleDAO =
			 new AssociativeRelationshipRoleDAO();
		List list = new ArrayList();
		AssociativeRelationshipRole associativeRelationshipRole =
			 new AssociativeRelationshipRole();
		associativeRelationshipRole.setCode("DE");
		associativeRelationshipRole.setLabel("bar");
		associativeRelationshipRole.setSkosLabel("label");
		list.add(associativeRelationshipRole);
		Criteria criteria1 = mock(Criteria.class);
		when(criteria1.list())
			.thenReturn(list);
		Criteria criteria2 = mock(Criteria.class);
		when(criteria2.add(Mockito.<org.hibernate.criterion.Criterion>any()))
			.thenReturn(criteria1);
		Criteria criteria3 = mock(Criteria.class);
		when(criteria3.setMaxResults(anyInt()))
			.thenReturn(criteria2);
		Session session = mock(Session.class);
		when(session.createCriteria(Mockito.<Class>any()))
			.thenReturn(criteria3);
		SessionFactory sessionFactory = mock(SessionFactory.class);
		when(sessionFactory.getCurrentSession())
			.thenReturn(session);
		associativeRelationshipRoleDAO.setSessionFactory(sessionFactory);

		// act
		AssociativeRelationshipRole result =
			 associativeRelationshipRoleDAO.getDefaultAssociativeRelationshipRole();

		// assert
		assertEquals("DE", result.getCode());
		assertFalse(result.getDefaultRole());
		assertEquals("bar", result.getLabel());
		assertEquals("label", result.getSkosLabel());
	}

	@Test
	public void getBySkosLabelSkosLabelIsBar() throws org.hibernate.HibernateException, org.hibernate.UnknownProfileException, javax.naming.NamingException {

		// arrange
		AssociativeRelationshipRoleDAO associativeRelationshipRoleDAO =
			 new AssociativeRelationshipRoleDAO();
		List list = new ArrayList();
		AssociativeRelationshipRole associativeRelationshipRole =
			 new AssociativeRelationshipRole();
		associativeRelationshipRole.setCode("DE");
		associativeRelationshipRole.setLabel("label");
		associativeRelationshipRole.setSkosLabel("label");
		list.add(associativeRelationshipRole);
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
		associativeRelationshipRoleDAO.setSessionFactory(sessionFactory);

		// act
		AssociativeRelationshipRole result =
			 associativeRelationshipRoleDAO.getBySkosLabel("bar");

		// assert
		assertEquals("DE", result.getCode());
		assertFalse(result.getDefaultRole());
		assertEquals("label", result.getLabel());
		assertEquals("label", result.getSkosLabel());
	}

	@Test
	public void getBySkosLabelSkosLabelIsLabelReturnsNull() throws org.hibernate.HibernateException, org.hibernate.UnknownProfileException, javax.naming.NamingException {
		AssociativeRelationshipRoleDAO associativeRelationshipRoleDAO =
			 new AssociativeRelationshipRoleDAO();
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
		associativeRelationshipRoleDAO.setSessionFactory(sessionFactory);
		assertNull(associativeRelationshipRoleDAO.getBySkosLabel("label"));
	}
}
