package fr.mcc.ginco.dao.hibernate;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;
import org.mockito.Mockito;

/**
 * Unit tests for fr.mcc.ginco.dao.hibernate.NodeLabelDAO
 *
 * @author Diffblue Cover
 */

public class NodeLabelDAOTest {

	@Test
	public void factory() throws org.hibernate.HibernateException, javax.naming.NamingException {
		NodeLabelDAO nodeLabelDAO = new NodeLabelDAO();
		SessionFactory sessionFactory = mock(SessionFactory.class);
		nodeLabelDAO.setSessionFactory(sessionFactory);
		assertSame(sessionFactory, nodeLabelDAO.getSessionFactory());
	}

	@Test
	public void getByThesaurusArrayReturnsNull() throws org.hibernate.HibernateException, org.hibernate.UnknownProfileException, javax.naming.NamingException {
		NodeLabelDAO nodeLabelDAO = new NodeLabelDAO();
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
		nodeLabelDAO.setSessionFactory(sessionFactory);
		assertNull(nodeLabelDAO.getByThesaurusArray("1234"));
	}
}
