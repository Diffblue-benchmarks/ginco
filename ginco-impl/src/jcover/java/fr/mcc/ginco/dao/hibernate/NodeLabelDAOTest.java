package fr.mcc.ginco.dao.hibernate;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import fr.mcc.ginco.beans.Language;
import fr.mcc.ginco.beans.NodeLabel;
import fr.mcc.ginco.beans.ThesaurusArray;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
	public void getByThesaurusArray() throws java.text.ParseException, org.hibernate.HibernateException, org.hibernate.UnknownProfileException, javax.naming.NamingException {

		// arrange
		NodeLabelDAO nodeLabelDAO = new NodeLabelDAO();
		List list1 = new ArrayList();
		NodeLabel nodeLabel = new NodeLabel();
		Date created1 =
			 new java.text.SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31");
		nodeLabel.setCreated(created1);
		nodeLabel.setIdentifier(1);
		Language language = new Language();
		nodeLabel.setLanguage(language);
		nodeLabel.setLexicalValue("value");
		Date modified1 =
			 new java.text.SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31");
		nodeLabel.setModified(modified1);
		ThesaurusArray thesaurusArray = new ThesaurusArray();
		nodeLabel.setThesaurusArray(thesaurusArray);
		list1.add(nodeLabel);
		List list2 = new ArrayList();
		list2.add(new Object());
		Criteria criteria1 = mock(Criteria.class);
		Criteria criteria2 = mock(Criteria.class);
		when(criteria2.add(Mockito.<org.hibernate.criterion.Criterion>any()))
			.thenReturn(criteria1);
		when(criteria2.list())
			.thenReturn(list2)
			.thenReturn(list1);
		Session session = mock(Session.class);
		when(session.createCriteria(Mockito.<Class>any()))
			.thenReturn(criteria2);
		SessionFactory sessionFactory = mock(SessionFactory.class);
		when(sessionFactory.getCurrentSession())
			.thenReturn(session);
		nodeLabelDAO.setSessionFactory(sessionFactory);

		// act
		NodeLabel result = nodeLabelDAO.getByThesaurusArray("1234");

		// assert
		assertSame(created1, result.getCreated());
		assertEquals(1, (int) result.getIdentifier());
		assertSame(language, result.getLanguage());
		assertEquals("value", result.getLexicalValue());
		assertSame(modified1, result.getModified());
		assertSame(thesaurusArray, result.getThesaurusArray());
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
