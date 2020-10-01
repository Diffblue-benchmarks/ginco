package fr.mcc.ginco.dao.hibernate;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import fr.mcc.ginco.beans.ExternalThesaurus;
import fr.mcc.ginco.beans.ExternalThesaurusType;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;
import org.mockito.Mockito;

/**
 * Unit tests for fr.mcc.ginco.dao.hibernate.ExternalThesaurusDAO
 *
 * @author Diffblue Cover
 */

public class ExternalThesaurusDAOTest {

	@Test
	public void factory() throws org.hibernate.HibernateException, javax.naming.NamingException {
		ExternalThesaurusDAO externalThesaurusDAO = new ExternalThesaurusDAO();
		SessionFactory sessionFactory = mock(SessionFactory.class);
		externalThesaurusDAO.setSessionFactory(sessionFactory);
		assertSame(sessionFactory, externalThesaurusDAO.getSessionFactory());
	}

	@Test
	public void findAllByExternalIdQueryQueryIsBar() throws org.hibernate.HibernateException, org.hibernate.UnknownProfileException, javax.naming.NamingException {

		// arrange
		ExternalThesaurusDAO externalThesaurusDAO = new ExternalThesaurusDAO();
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
		externalThesaurusDAO.setSessionFactory(sessionFactory);

		// act
		List<ExternalThesaurus> result =
			 externalThesaurusDAO.findAllByExternalIdQuery("bar");

		// assert
		assertEquals(1, result.size());
		// pojo Object
	}

	@Test
	public void findAllByExternalIdQueryQueryIsEmpty() throws org.hibernate.HibernateException, org.hibernate.UnknownProfileException, javax.naming.NamingException {

		// arrange
		ExternalThesaurusDAO externalThesaurusDAO = new ExternalThesaurusDAO();
		List list = new ArrayList();
		list.add(new Object());
		Criteria criteria = mock(Criteria.class);
		when(criteria.list())
			.thenReturn(list);
		Session session = mock(Session.class);
		when(session.createCriteria(Mockito.<Class>any()))
			.thenReturn(criteria);
		SessionFactory sessionFactory = mock(SessionFactory.class);
		when(sessionFactory.getCurrentSession())
			.thenReturn(session);
		externalThesaurusDAO.setSessionFactory(sessionFactory);

		// act
		List<ExternalThesaurus> result =
			 externalThesaurusDAO.findAllByExternalIdQuery("");

		// assert
		assertEquals(1, result.size());
		// pojo Object
	}

	@Test
	public void findAllByExternalIdQueryQueryIsNull() throws org.hibernate.HibernateException, org.hibernate.UnknownProfileException, javax.naming.NamingException {

		// arrange
		ExternalThesaurusDAO externalThesaurusDAO = new ExternalThesaurusDAO();
		List list = new ArrayList();
		list.add(new Object());
		Criteria criteria = mock(Criteria.class);
		when(criteria.list())
			.thenReturn(list);
		Session session = mock(Session.class);
		when(session.createCriteria(Mockito.<Class>any()))
			.thenReturn(criteria);
		SessionFactory sessionFactory = mock(SessionFactory.class);
		when(sessionFactory.getCurrentSession())
			.thenReturn(session);
		externalThesaurusDAO.setSessionFactory(sessionFactory);

		// act
		List<ExternalThesaurus> result =
			 externalThesaurusDAO.findAllByExternalIdQuery(null);

		// assert
		assertEquals(1, result.size());
		// pojo Object
	}

	@Test
	public void findBySourceExternalId() throws org.hibernate.HibernateException, org.hibernate.UnknownProfileException, javax.naming.NamingException {

		// arrange
		ExternalThesaurusDAO externalThesaurusDAO = new ExternalThesaurusDAO();
		List list = new ArrayList();
		ExternalThesaurus externalThesaurus = new ExternalThesaurus();
		externalThesaurus.setExternalId("bar");
		ExternalThesaurusType externalThesaurusType = new ExternalThesaurusType();
		externalThesaurus.setExternalThesaurusType(externalThesaurusType);
		externalThesaurus.setIdentifier(1);
		list.add(externalThesaurus);
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
		externalThesaurusDAO.setSessionFactory(sessionFactory);

		// act
		ExternalThesaurus result =
			 externalThesaurusDAO.findBySourceExternalId("1234");

		// assert
		assertEquals("bar", result.getExternalId());
		assertSame(externalThesaurusType, result.getExternalThesaurusType());
		assertEquals(1, (int) result.getIdentifier());
	}

	@Test
	public void findBySourceExternalIdReturnsNull() throws org.hibernate.HibernateException, org.hibernate.UnknownProfileException, javax.naming.NamingException {
		ExternalThesaurusDAO externalThesaurusDAO = new ExternalThesaurusDAO();
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
		externalThesaurusDAO.setSessionFactory(sessionFactory);
		assertNull(externalThesaurusDAO.findBySourceExternalId("1234"));
	}
}
