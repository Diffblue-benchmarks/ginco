package fr.mcc.ginco.dao.hibernate;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import fr.mcc.ginco.beans.SplitNonPreferredTerm;

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
	public void factory() {
		SplitNonPreferredTermDAO splitNonPreferredTermDAO =
			 new SplitNonPreferredTermDAO();
		SessionFactory sessionFactory = mock(SessionFactory.class);
		splitNonPreferredTermDAO.setSessionFactory(sessionFactory);
		assertSame(sessionFactory, splitNonPreferredTermDAO.getSessionFactory());
	}

	@Test
	public void findItemsLimitIsOneAndStartIsOne() throws org.hibernate.HibernateException {

		// arrange
		SplitNonPreferredTermDAO splitNonPreferredTermDAO =
			 new SplitNonPreferredTermDAO();
		List list = new ArrayList<String>();
		list.add("Smith");
		Criteria criteria1 = mock(Criteria.class);
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
		when(criteria5.list())
			.thenReturn(list);
		when(criteria5.setMaxResults(anyInt()))
			.thenReturn(criteria4);
		Session session = mock(Session.class);
		when(session.createCriteria(Mockito.<Class>any()))
			.thenReturn(criteria5);
		SessionFactory sessionFactory = mock(SessionFactory.class);
		when(sessionFactory.getCurrentSession())
			.thenReturn(session);
		splitNonPreferredTermDAO.setSessionFactory(sessionFactory);

		// act
		List<SplitNonPreferredTerm> result =
			 splitNonPreferredTermDAO.findItems(1, 1, "1234");

		// assert
		assertEquals(1, result.size());
		// pojo String (String) result.get(0)
	}
}
