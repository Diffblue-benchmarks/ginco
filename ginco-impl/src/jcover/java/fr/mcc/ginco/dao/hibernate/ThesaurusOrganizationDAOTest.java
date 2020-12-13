package fr.mcc.ginco.dao.hibernate;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import fr.mcc.ginco.beans.ThesaurusOrganization;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;
import org.mockito.Mockito;

/**
 * Unit tests for fr.mcc.ginco.dao.hibernate.ThesaurusOrganizationDAO
 *
 * @author Diffblue Cover
 */

public class ThesaurusOrganizationDAOTest {

	@Test
	public void factory() {
		ThesaurusOrganizationDAO thesaurusOrganizationDAO =
			 new ThesaurusOrganizationDAO();
		SessionFactory sessionFactory = mock(SessionFactory.class);
		thesaurusOrganizationDAO.setSessionFactory(sessionFactory);
		assertSame(sessionFactory, thesaurusOrganizationDAO.getSessionFactory());
	}

	@Test
	public void getFilteredOrganizationNames() throws org.hibernate.HibernateException {

		// arrange
		ThesaurusOrganizationDAO thesaurusOrganizationDAO =
			 new ThesaurusOrganizationDAO();
		ArrayList<String> arrayList = new ArrayList<String>();
		arrayList.add("Smith");
		Criteria criteria1 = mock(Criteria.class);
		when(criteria1.list())
			.thenReturn(arrayList);
		Criteria criteria2 = mock(Criteria.class);
		when(criteria2.addOrder(Mockito.<org.hibernate.criterion.Order>any()))
			.thenReturn(criteria1);
		Criteria criteria3 = mock(Criteria.class);
		when(criteria3.setResultTransformer(Mockito.<org.hibernate.transform.ResultTransformer>any()))
			.thenReturn(criteria2);
		Criteria criteria4 = mock(Criteria.class);
		when(criteria4.setProjection(Mockito.<org.hibernate.criterion.Projection>any()))
			.thenReturn(criteria3);
		Criteria criteria5 = mock(Criteria.class);
		when(criteria5.createCriteria(Mockito.<String>any(), Mockito.<String>any(), Mockito.<org.hibernate.sql.JoinType>any()))
			.thenReturn(criteria4);
		Criteria criteria6 = mock(Criteria.class);
		when(criteria6.add(Mockito.<org.hibernate.criterion.Criterion>any()))
			.thenReturn(criteria5);
		Session session = mock(Session.class);
		when(session.createCriteria(Mockito.<Class>any(), Mockito.<String>any()))
			.thenReturn(criteria6);
		SessionFactory sessionFactory = mock(SessionFactory.class);
		when(sessionFactory.getCurrentSession())
			.thenReturn(session);
		thesaurusOrganizationDAO.setSessionFactory(sessionFactory);

		// act
		List<ThesaurusOrganization> result =
			 thesaurusOrganizationDAO.getFilteredOrganizationNames();

		// assert
		assertEquals(1, result.size());
		// pojo String (String) result.get(0)
	}
}
