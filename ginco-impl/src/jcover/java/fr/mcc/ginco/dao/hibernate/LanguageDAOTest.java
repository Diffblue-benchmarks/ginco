package fr.mcc.ginco.dao.hibernate;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import fr.mcc.ginco.beans.Language;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;
import org.mockito.Mockito;

/**
 * Unit tests for fr.mcc.ginco.dao.hibernate.LanguageDAO
 *
 * @author Diffblue Cover
 */

public class LanguageDAOTest {

	@Test
	public void factory() {
		LanguageDAO languageDAO = new LanguageDAO();
		SessionFactory sessionFactory = mock(SessionFactory.class);
		languageDAO.setSessionFactory(sessionFactory);
		assertSame(sessionFactory, languageDAO.getSessionFactory());
	}

	@Test
	public void findPaginatedItemsLimitIsOneAndStartIsOne() throws org.hibernate.HibernateException {

		// arrange
		LanguageDAO languageDAO = new LanguageDAO();
		List list = new ArrayList<String>();
		list.add("foo");
		Criteria criteria1 = mock(Criteria.class);
		when(criteria1.list())
			.thenReturn(list);
		Criteria criteria2 = mock(Criteria.class);
		when(criteria2.addOrder(Mockito.<org.hibernate.criterion.Order>any()))
			.thenReturn(criteria1);
		Criteria criteria3 = mock(Criteria.class);
		when(criteria3.addOrder(Mockito.<org.hibernate.criterion.Order>any()))
			.thenReturn(criteria2);
		Criteria criteria4 = mock(Criteria.class);
		when(criteria4.setFirstResult(anyInt()))
			.thenReturn(criteria3);
		Criteria criteria5 = mock(Criteria.class);
		when(criteria5.setMaxResults(anyInt()))
			.thenReturn(criteria4);
		Session session = mock(Session.class);
		when(session.createCriteria(Mockito.<Class>any()))
			.thenReturn(criteria5);
		SessionFactory sessionFactory = mock(SessionFactory.class);
		when(sessionFactory.getCurrentSession())
			.thenReturn(session);
		languageDAO.setSessionFactory(sessionFactory);

		// act
		List<Language> result = languageDAO.findPaginatedItems(1, 1);

		// assert
		assertEquals(1, result.size());
		// pojo String (String) result.get(0)
	}

	@Test
	public void findTopLanguages() throws org.hibernate.HibernateException {

		// arrange
		LanguageDAO languageDAO = new LanguageDAO();
		List list = new ArrayList<String>();
		list.add("foo");
		Criteria criteria1 = mock(Criteria.class);
		when(criteria1.list())
			.thenReturn(list);
		Criteria criteria2 = mock(Criteria.class);
		when(criteria2.addOrder(Mockito.<org.hibernate.criterion.Order>any()))
			.thenReturn(criteria1);
		Criteria criteria3 = mock(Criteria.class);
		when(criteria3.add(Mockito.<org.hibernate.criterion.Criterion>any()))
			.thenReturn(criteria2);
		Session session = mock(Session.class);
		when(session.createCriteria(Mockito.<Class>any()))
			.thenReturn(criteria3);
		SessionFactory sessionFactory = mock(SessionFactory.class);
		when(sessionFactory.getCurrentSession())
			.thenReturn(session);
		languageDAO.setSessionFactory(sessionFactory);

		// act
		List<Language> result = languageDAO.findTopLanguages();

		// assert
		assertEquals(1, result.size());
		// pojo String (String) result.get(0)
	}

	@Test
	public void getByPart1Part1IsFooReturnsNull() throws org.hibernate.HibernateException {
		LanguageDAO languageDAO = new LanguageDAO();
		Criteria criteria1 = mock(Criteria.class);
		when(criteria1.list())
			.thenReturn(new ArrayList<String>());
		Criteria criteria2 = mock(Criteria.class);
		when(criteria2.add(Mockito.<org.hibernate.criterion.Criterion>any()))
			.thenReturn(criteria1);
		Criteria criteria3 = mock(Criteria.class);
		when(criteria3.add(Mockito.<org.hibernate.criterion.Criterion>any()))
			.thenReturn(criteria2);
		Session session = mock(Session.class);
		when(session.createCriteria(Mockito.<Class>any()))
			.thenReturn(criteria3);
		SessionFactory sessionFactory = mock(SessionFactory.class);
		when(sessionFactory.getCurrentSession())
			.thenReturn(session);
		languageDAO.setSessionFactory(sessionFactory);
		assertNull(languageDAO.getByPart1("foo"));
	}
}
