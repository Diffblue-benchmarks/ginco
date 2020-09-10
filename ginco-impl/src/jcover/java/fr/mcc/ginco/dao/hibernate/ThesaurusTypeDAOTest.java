package fr.mcc.ginco.dao.hibernate;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import fr.mcc.ginco.beans.ThesaurusType;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;
import org.mockito.Mockito;

/**
 * Unit tests for fr.mcc.ginco.dao.hibernate.ThesaurusTypeDAO
 *
 * @author Diffblue Cover
 */

public class ThesaurusTypeDAOTest {

	@Test
	public void factory() throws org.hibernate.HibernateException, javax.naming.NamingException {
		ThesaurusTypeDAO thesaurusTypeDAO = new ThesaurusTypeDAO();
		SessionFactory sessionFactory = mock(SessionFactory.class);
		thesaurusTypeDAO.setSessionFactory(sessionFactory);
		assertSame(sessionFactory, thesaurusTypeDAO.getSessionFactory());
	}

	@Test
	public void getByLabelLabelIsBar() throws org.hibernate.HibernateException, org.hibernate.UnknownProfileException, javax.naming.NamingException {

		// arrange
		ThesaurusTypeDAO thesaurusTypeDAO = new ThesaurusTypeDAO();
		List list = new ArrayList();
		ThesaurusType thesaurusType = new ThesaurusType();
		thesaurusType.setIdentifier(1);
		thesaurusType.setLabel("label");
		list.add(thesaurusType);
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
		thesaurusTypeDAO.setSessionFactory(sessionFactory);

		// act
		ThesaurusType result = thesaurusTypeDAO.getByLabel("bar");

		// assert
		assertEquals(1, (int) result.getIdentifier());
		assertEquals("label", result.getLabel());
	}

	@Test
	public void getByLabelLabelIsLabelReturnsNull() throws org.hibernate.HibernateException, org.hibernate.UnknownProfileException, javax.naming.NamingException {
		ThesaurusTypeDAO thesaurusTypeDAO = new ThesaurusTypeDAO();
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
		thesaurusTypeDAO.setSessionFactory(sessionFactory);
		assertNull(thesaurusTypeDAO.getByLabel("label"));
	}
}
