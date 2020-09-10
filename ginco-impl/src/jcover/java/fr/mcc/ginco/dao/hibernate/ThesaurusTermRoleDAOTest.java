package fr.mcc.ginco.dao.hibernate;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import fr.mcc.ginco.beans.ThesaurusTermRole;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;
import org.mockito.Mockito;

/**
 * Unit tests for fr.mcc.ginco.dao.hibernate.ThesaurusTermRoleDAO
 *
 * @author Diffblue Cover
 */

public class ThesaurusTermRoleDAOTest {

	@Test
	public void factory() throws org.hibernate.HibernateException, javax.naming.NamingException {
		ThesaurusTermRoleDAO thesaurusTermRoleDAO = new ThesaurusTermRoleDAO();
		SessionFactory sessionFactory = mock(SessionFactory.class);
		thesaurusTermRoleDAO.setSessionFactory(sessionFactory);
		assertSame(sessionFactory, thesaurusTermRoleDAO.getSessionFactory());
	}

	@Test
	public void getDefaultThesaurusTermRole() throws org.hibernate.HibernateException, org.hibernate.UnknownProfileException, javax.naming.NamingException {

		// arrange
		ThesaurusTermRoleDAO thesaurusTermRoleDAO = new ThesaurusTermRoleDAO();
		List list = new ArrayList();
		ThesaurusTermRole thesaurusTermRole = new ThesaurusTermRole();
		thesaurusTermRole.setCode("DE");
		thesaurusTermRole.setLabel("label");
		list.add(thesaurusTermRole);
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
		thesaurusTermRoleDAO.setSessionFactory(sessionFactory);

		// act
		ThesaurusTermRole result =
			 thesaurusTermRoleDAO.getDefaultThesaurusTermRole();

		// assert
		assertEquals("DE", result.getCode());
		assertFalse(result.getDefaultRole());
		assertEquals("label", result.getLabel());
	}
}
