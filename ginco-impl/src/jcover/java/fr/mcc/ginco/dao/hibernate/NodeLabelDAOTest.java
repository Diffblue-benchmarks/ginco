package fr.mcc.ginco.dao.hibernate;

import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.mock;

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
	public void factory() throws org.hibernate.HibernateException {
		NodeLabelDAO nodeLabelDAO = new NodeLabelDAO();
		SessionFactory sessionFactory = mock(SessionFactory.class);
		nodeLabelDAO.setSessionFactory(sessionFactory);
		assertSame(sessionFactory, nodeLabelDAO.getSessionFactory());
	}
}
