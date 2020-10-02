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
 * Unit tests for fr.mcc.ginco.dao.hibernate.AssociativeRelationshipRoleDAO
 *
 * @author Diffblue Cover
 */

public class AssociativeRelationshipRoleDAOTest {

	@Test
	public void factory() {
		AssociativeRelationshipRoleDAO associativeRelationshipRoleDAO =
			 new AssociativeRelationshipRoleDAO();
		SessionFactory sessionFactory = mock(SessionFactory.class);
		associativeRelationshipRoleDAO.setSessionFactory(sessionFactory);
		assertSame(sessionFactory, associativeRelationshipRoleDAO.getSessionFactory());
	}

	@Test
	public void getBySkosLabelSkosLabelIsLabelReturnsNull() throws org.hibernate.HibernateException {
		AssociativeRelationshipRoleDAO associativeRelationshipRoleDAO =
			 new AssociativeRelationshipRoleDAO();
		Criteria criteria1 = mock(Criteria.class);
		Criteria criteria2 = mock(Criteria.class);
		when(criteria2.add(Mockito.<org.hibernate.criterion.Criterion>any()))
			.thenReturn(criteria1);
		when(criteria2.list())
			.thenReturn(new ArrayList<String>());
		Session session = mock(Session.class);
		when(session.createCriteria(Mockito.<Class>any()))
			.thenReturn(criteria2);
		SessionFactory sessionFactory = mock(SessionFactory.class);
		when(sessionFactory.getCurrentSession())
			.thenReturn(session);
		associativeRelationshipRoleDAO.setSessionFactory(sessionFactory);
		assertNull(associativeRelationshipRoleDAO.getBySkosLabel("label"));
	}
}
