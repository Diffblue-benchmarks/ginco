package fr.mcc.ginco.dao.hibernate;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import fr.mcc.ginco.dao.IGenericDAO;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;
import org.mockito.Mockito;

/**
 * Unit tests for fr.mcc.ginco.dao.hibernate.GenericHibernateDAO
 *
 * @author Diffblue Cover
 */

public class GenericHibernateDAOTest {

	@Test
	public void factory() {
		GenericHibernateDAO<String, String> genericHibernateDAO =
			 new GenericHibernateDAO<String, String>(String.class);
		SessionFactory sessionFactory = mock(SessionFactory.class);
		genericHibernateDAO.setSessionFactory(sessionFactory);
		assertSame(sessionFactory, genericHibernateDAO.getSessionFactory());
	}

	@Test
	public void loadById() throws org.hibernate.HibernateException {
		GenericHibernateDAO<String, String> genericHibernateDAO =
			 new GenericHibernateDAO<String, String>(String.class);
		Session session = mock(Session.class);
		when(session.load(Mockito.<Class>any(), Mockito.<java.io.Serializable>any()))
			.thenReturn(new Object());
		SessionFactory sessionFactory = mock(SessionFactory.class);
		when(sessionFactory.getCurrentSession())
			.thenReturn(session);
		genericHibernateDAO.setSessionFactory(sessionFactory);
		assertTrue(genericHibernateDAO.loadById("1234") instanceof Object);
		// pojo Object (Object) genericHibernateDAO.loadById("1234")
	}

	@Test
	public void getById() throws org.hibernate.HibernateException {
		GenericHibernateDAO<String, String> genericHibernateDAO =
			 new GenericHibernateDAO<String, String>(String.class);
		Session session = mock(Session.class);
		when(session.get(Mockito.<Class>any(), Mockito.<java.io.Serializable>any()))
			.thenReturn(new Object());
		SessionFactory sessionFactory = mock(SessionFactory.class);
		when(sessionFactory.getCurrentSession())
			.thenReturn(session);
		genericHibernateDAO.setSessionFactory(sessionFactory);
		assertTrue(genericHibernateDAO.getById("1234") instanceof Object);
		// pojo Object (Object) genericHibernateDAO.getById("1234")
	}

	@Test
	public void getByExternalIdReturnsSmith() throws org.hibernate.HibernateException {
		GenericHibernateDAO<String, String> genericHibernateDAO =
			 new GenericHibernateDAO<String, String>(String.class);
		List list = new ArrayList<String>();
		list.add("Smith");
		Criteria criteria1 = mock(Criteria.class);
		when(criteria1.list())
			.thenReturn(list);
		Criteria criteria2 = mock(Criteria.class);
		when(criteria2.add(Mockito.<org.hibernate.criterion.Criterion>any()))
			.thenReturn(criteria1);
		Session session = mock(Session.class);
		when(session.createCriteria(Mockito.<Class>any(), Mockito.<String>any()))
			.thenReturn(criteria2);
		SessionFactory sessionFactory = mock(SessionFactory.class);
		when(sessionFactory.getCurrentSession())
			.thenReturn(session);
		genericHibernateDAO.setSessionFactory(sessionFactory);
		assertEquals(1, genericHibernateDAO.getByExternalId("1234").size());
		assertEquals("Smith", genericHibernateDAO.getByExternalId("1234").get(0));
	}

	@Test
	public void findAll() throws org.hibernate.HibernateException {
		GenericHibernateDAO<String, String> genericHibernateDAO =
			 new GenericHibernateDAO<String, String>(String.class);
		List list = new ArrayList<String>();
		list.add("Smith");
		Criteria criteria = mock(Criteria.class);
		when(criteria.list())
			.thenReturn(list);
		Session session = mock(Session.class);
		when(session.createCriteria(Mockito.<Class>any()))
			.thenReturn(criteria);
		SessionFactory sessionFactory = mock(SessionFactory.class);
		when(sessionFactory.getCurrentSession())
			.thenReturn(session);
		genericHibernateDAO.setSessionFactory(sessionFactory);
		assertEquals(1, genericHibernateDAO.findAll().size());
		assertEquals("Smith", genericHibernateDAO.findAll().get(0));
	}

	@Test
	public void findAllOrderIsAsc() throws org.hibernate.HibernateException {
		GenericHibernateDAO<String, String> genericHibernateDAO =
			 new GenericHibernateDAO<String, String>(String.class);
		List list = new ArrayList<String>();
		list.add("Smith");
		Criteria criteria1 = mock(Criteria.class);
		when(criteria1.list())
			.thenReturn(list);
		Criteria criteria2 = mock(Criteria.class);
		when(criteria2.addOrder(Mockito.<org.hibernate.criterion.Order>any()))
			.thenReturn(criteria1);
		Session session = mock(Session.class);
		when(session.createCriteria(Mockito.<Class>any()))
			.thenReturn(criteria2);
		SessionFactory sessionFactory = mock(SessionFactory.class);
		when(sessionFactory.getCurrentSession())
			.thenReturn(session);
		genericHibernateDAO.setSessionFactory(sessionFactory);
		assertEquals(1, genericHibernateDAO.findAll("foo", IGenericDAO.SortingTypes.asc).size());
		assertEquals("Smith", genericHibernateDAO.findAll("foo", IGenericDAO.SortingTypes.asc).get(0));
	}

	@Test
	public void findAllOrderIsDesc() throws org.hibernate.HibernateException {
		GenericHibernateDAO<String, String> genericHibernateDAO =
			 new GenericHibernateDAO<String, String>(String.class);
		List list = new ArrayList<String>();
		list.add("Smith");
		Criteria criteria1 = mock(Criteria.class);
		when(criteria1.list())
			.thenReturn(list);
		Criteria criteria2 = mock(Criteria.class);
		when(criteria2.addOrder(Mockito.<org.hibernate.criterion.Order>any()))
			.thenReturn(criteria1);
		Session session = mock(Session.class);
		when(session.createCriteria(Mockito.<Class>any()))
			.thenReturn(criteria2);
		SessionFactory sessionFactory = mock(SessionFactory.class);
		when(sessionFactory.getCurrentSession())
			.thenReturn(session);
		genericHibernateDAO.setSessionFactory(sessionFactory);
		assertEquals(1, genericHibernateDAO.findAll("foo", IGenericDAO.SortingTypes.desc).size());
		assertEquals("Smith", genericHibernateDAO.findAll("foo", IGenericDAO.SortingTypes.desc).get(0));
	}

	@Test
	public void makePersistent() throws org.hibernate.HibernateException {
		GenericHibernateDAO<String, String> genericHibernateDAO =
			 new GenericHibernateDAO<String, String>(String.class);
		Session session = mock(Session.class);
		SessionFactory sessionFactory = mock(SessionFactory.class);
		when(sessionFactory.getCurrentSession())
			.thenReturn(session);
		genericHibernateDAO.setSessionFactory(sessionFactory);
		assertEquals("entity", genericHibernateDAO.makePersistent("entity"));
		Mockito.verify(session).saveOrUpdate(Mockito.eq("entity"));
	}

	@Test
	public void update() throws org.hibernate.HibernateException {
		GenericHibernateDAO<String, String> genericHibernateDAO =
			 new GenericHibernateDAO<String, String>(String.class);
		Session session = mock(Session.class);
		SessionFactory sessionFactory = mock(SessionFactory.class);
		when(sessionFactory.getCurrentSession())
			.thenReturn(session);
		genericHibernateDAO.setSessionFactory(sessionFactory);
		assertEquals("entity", genericHibernateDAO.update("entity"));
		Mockito.verify(session).saveOrUpdate(Mockito.eq("entity"));
	}

	@Test
	public void delete() throws org.hibernate.HibernateException {
		GenericHibernateDAO<String, String> genericHibernateDAO =
			 new GenericHibernateDAO<String, String>(String.class);
		Session session = mock(Session.class);
		SessionFactory sessionFactory = mock(SessionFactory.class);
		when(sessionFactory.getCurrentSession())
			.thenReturn(session);
		genericHibernateDAO.setSessionFactory(sessionFactory);
		assertEquals("entity", genericHibernateDAO.delete("entity"));
		Mockito.verify(session).delete(Mockito.eq("entity"));
	}

	@Test
	public void flush() throws org.hibernate.HibernateException {

		// arrange
		GenericHibernateDAO<String, String> genericHibernateDAO =
			 new GenericHibernateDAO<String, String>(String.class);
		Session session = mock(Session.class);
		SessionFactory sessionFactory = mock(SessionFactory.class);
		when(sessionFactory.getCurrentSession())
			.thenReturn(session);
		genericHibernateDAO.setSessionFactory(sessionFactory);

		// act
		genericHibernateDAO.flush();

		// assert
		Mockito.verify(session).flush();
	}

	@Test
	public void getCurrentSession() throws org.hibernate.HibernateException {
		GenericHibernateDAO<String, String> genericHibernateDAO =
			 new GenericHibernateDAO<String, String>(String.class);
		Session session = mock(Session.class);
		SessionFactory sessionFactory = mock(SessionFactory.class);
		when(sessionFactory.getCurrentSession())
			.thenReturn(session);
		genericHibernateDAO.setSessionFactory(sessionFactory);
		assertNotNull(genericHibernateDAO.getCurrentSession());
	}
}
