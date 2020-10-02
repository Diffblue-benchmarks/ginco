package fr.mcc.ginco.dao.hibernate;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import fr.mcc.ginco.beans.Suggestion;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;
import org.mockito.Mockito;

/**
 * Unit tests for fr.mcc.ginco.dao.hibernate.SuggestionDAO
 *
 * @author Diffblue Cover
 */

public class SuggestionDAOTest {

	@Test
	public void factory() {
		SuggestionDAO suggestionDAO = new SuggestionDAO();
		SessionFactory sessionFactory = mock(SessionFactory.class);
		suggestionDAO.setSessionFactory(sessionFactory);
		assertSame(sessionFactory, suggestionDAO.getSessionFactory());
	}

	@Test
	public void findConceptPaginatedSuggestionsLimitIsOneAndStartIndexIsOne() throws org.hibernate.HibernateException {

		// arrange
		SuggestionDAO suggestionDAO = new SuggestionDAO();
		List list = new ArrayList<String>();
		list.add("foo");
		Criteria criteria1 = mock(Criteria.class);
		when(criteria1.list())
			.thenReturn(list);
		Criteria criteria2 = mock(Criteria.class);
		when(criteria2.addOrder(Mockito.<org.hibernate.criterion.Order>any()))
			.thenReturn(criteria1);
		Criteria criteria3 = mock(Criteria.class);
		when(criteria3.setFirstResult(anyInt()))
			.thenReturn(criteria2);
		Criteria criteria4 = mock(Criteria.class);
		when(criteria4.add(Mockito.<org.hibernate.criterion.Criterion>any()))
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
		suggestionDAO.setSessionFactory(sessionFactory);

		// act
		List<Suggestion> result =
			 suggestionDAO.findConceptPaginatedSuggestions("1234", 1, 1);

		// assert
		assertEquals(1, result.size());
		// pojo String (String) result.get(0)
	}

	@Test
	public void findTermPaginatedSuggestionsLimitIsOneAndStartIndexIsOne() throws org.hibernate.HibernateException {

		// arrange
		SuggestionDAO suggestionDAO = new SuggestionDAO();
		List list = new ArrayList<String>();
		list.add("foo");
		Criteria criteria1 = mock(Criteria.class);
		when(criteria1.list())
			.thenReturn(list);
		Criteria criteria2 = mock(Criteria.class);
		when(criteria2.addOrder(Mockito.<org.hibernate.criterion.Order>any()))
			.thenReturn(criteria1);
		Criteria criteria3 = mock(Criteria.class);
		when(criteria3.setFirstResult(anyInt()))
			.thenReturn(criteria2);
		Criteria criteria4 = mock(Criteria.class);
		when(criteria4.add(Mockito.<org.hibernate.criterion.Criterion>any()))
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
		suggestionDAO.setSessionFactory(sessionFactory);

		// act
		List<Suggestion> result =
			 suggestionDAO.findTermPaginatedSuggestions("1234", 1, 1);

		// assert
		assertEquals(1, result.size());
		// pojo String (String) result.get(0)
	}

	@Test
	public void findPaginatedSuggestionsByRecipientLimitIsOneAndStartIndexIsOne() throws org.hibernate.HibernateException {

		// arrange
		SuggestionDAO suggestionDAO = new SuggestionDAO();
		List list = new ArrayList<String>();
		list.add("foo");
		Criteria criteria1 = mock(Criteria.class);
		when(criteria1.list())
			.thenReturn(list);
		Criteria criteria2 = mock(Criteria.class);
		when(criteria2.addOrder(Mockito.<org.hibernate.criterion.Order>any()))
			.thenReturn(criteria1);
		Criteria criteria3 = mock(Criteria.class);
		when(criteria3.setFirstResult(anyInt()))
			.thenReturn(criteria2);
		Criteria criteria4 = mock(Criteria.class);
		when(criteria4.add(Mockito.<org.hibernate.criterion.Criterion>any()))
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
		suggestionDAO.setSessionFactory(sessionFactory);

		// act
		List<Suggestion> result =
			 suggestionDAO.findPaginatedSuggestionsByRecipient("1234", 1, 1);

		// assert
		assertEquals(1, result.size());
		// pojo String (String) result.get(0)
	}
}
