package fr.mcc.ginco.dao.hibernate;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import fr.mcc.ginco.beans.ThesaurusConceptGroup;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;
import org.mockito.Mockito;

/**
 * Unit tests for fr.mcc.ginco.dao.hibernate.ThesaurusConceptGroupDAO
 *
 * @author Diffblue Cover
 */

public class ThesaurusConceptGroupDAOTest {

	@Test
	public void factory() {
		ThesaurusConceptGroupDAO thesaurusConceptGroupDAO =
			 new ThesaurusConceptGroupDAO();
		SessionFactory sessionFactory = mock(SessionFactory.class);
		thesaurusConceptGroupDAO.setSessionFactory(sessionFactory);
		assertSame(sessionFactory, thesaurusConceptGroupDAO.getSessionFactory());
	}

	@Test
	public void findThesaurusConceptGroupsByThesaurusIdExcludedConceptGroupIdIsBar() throws org.hibernate.HibernateException {

		// arrange
		ThesaurusConceptGroupDAO thesaurusConceptGroupDAO =
			 new ThesaurusConceptGroupDAO();
		List list = new ArrayList<String>();
		list.add("Smith");
		Criteria criteria1 = mock(Criteria.class);
		Criteria criteria2 = mock(Criteria.class);
		Criteria criteria3 = mock(Criteria.class);
		when(criteria3.add(Mockito.<org.hibernate.criterion.Criterion>any()))
			.thenReturn(criteria2)
			.thenReturn(criteria1);
		when(criteria3.list())
			.thenReturn(list);
		Session session = mock(Session.class);
		when(session.createCriteria(Mockito.<Class>any(), Mockito.<String>any()))
			.thenReturn(criteria3);
		SessionFactory sessionFactory = mock(SessionFactory.class);
		when(sessionFactory.getCurrentSession())
			.thenReturn(session);
		thesaurusConceptGroupDAO.setSessionFactory(sessionFactory);

		// act
		List<ThesaurusConceptGroup> result =
			 thesaurusConceptGroupDAO.findThesaurusConceptGroupsByThesaurusId("bar", "1234");

		// assert
		assertEquals(1, result.size());
		// pojo String (String) result.get(0)
	}

	@Test
	public void findThesaurusConceptGroupsByThesaurusIdExcludedConceptGroupIdIsNull() throws org.hibernate.HibernateException {

		// arrange
		ThesaurusConceptGroupDAO thesaurusConceptGroupDAO =
			 new ThesaurusConceptGroupDAO();
		List list = new ArrayList<String>();
		list.add("Smith");
		Criteria criteria1 = mock(Criteria.class);
		Criteria criteria2 = mock(Criteria.class);
		Criteria criteria3 = mock(Criteria.class);
		when(criteria3.add(Mockito.<org.hibernate.criterion.Criterion>any()))
			.thenReturn(criteria2);
		when(criteria3.list())
			.thenReturn(list);
		Session session = mock(Session.class);
		when(session.createCriteria(Mockito.<Class>any(), Mockito.<String>any()))
			.thenReturn(criteria3);
		SessionFactory sessionFactory = mock(SessionFactory.class);
		when(sessionFactory.getCurrentSession())
			.thenReturn(session);
		thesaurusConceptGroupDAO.setSessionFactory(sessionFactory);

		// act
		List<ThesaurusConceptGroup> result =
			 thesaurusConceptGroupDAO.findThesaurusConceptGroupsByThesaurusId(null, "1234");

		// assert
		assertEquals(1, result.size());
		// pojo String (String) result.get(0)
	}

	@Test
	public void getChildGroups() throws org.hibernate.HibernateException {

		// arrange
		ThesaurusConceptGroupDAO thesaurusConceptGroupDAO =
			 new ThesaurusConceptGroupDAO();
		List list = new ArrayList<String>();
		list.add("Smith");
		Criteria criteria1 = mock(Criteria.class);
		Criteria criteria2 = mock(Criteria.class);
		when(criteria2.add(Mockito.<org.hibernate.criterion.Criterion>any()))
			.thenReturn(criteria1);
		when(criteria2.list())
			.thenReturn(list);
		Session session = mock(Session.class);
		when(session.createCriteria(Mockito.<Class>any(), Mockito.<String>any()))
			.thenReturn(criteria2);
		SessionFactory sessionFactory = mock(SessionFactory.class);
		when(sessionFactory.getCurrentSession())
			.thenReturn(session);
		thesaurusConceptGroupDAO.setSessionFactory(sessionFactory);

		// act
		List<ThesaurusConceptGroup> result =
			 thesaurusConceptGroupDAO.getChildGroups("1234");

		// assert
		assertEquals(1, result.size());
		// pojo String (String) result.get(0)
	}
}
