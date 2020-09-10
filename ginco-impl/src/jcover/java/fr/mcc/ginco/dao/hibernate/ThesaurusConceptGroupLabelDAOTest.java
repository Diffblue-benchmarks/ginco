package fr.mcc.ginco.dao.hibernate;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import fr.mcc.ginco.beans.Language;
import fr.mcc.ginco.beans.ThesaurusConceptGroup;
import fr.mcc.ginco.beans.ThesaurusConceptGroupLabel;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;
import org.mockito.Mockito;

/**
 * Unit tests for fr.mcc.ginco.dao.hibernate.ThesaurusConceptGroupLabelDAO
 *
 * @author Diffblue Cover
 */

public class ThesaurusConceptGroupLabelDAOTest {

	@Test
	public void factory() throws org.hibernate.HibernateException, javax.naming.NamingException {
		ThesaurusConceptGroupLabelDAO thesaurusConceptGroupLabelDAO =
			 new ThesaurusConceptGroupLabelDAO();
		SessionFactory sessionFactory = mock(SessionFactory.class);
		thesaurusConceptGroupLabelDAO.setSessionFactory(sessionFactory);
		assertSame(sessionFactory, thesaurusConceptGroupLabelDAO.getSessionFactory());
	}

	@Test
	public void findByThesaurusConceptGroupAndLanguageIdentifierIsBar() throws java.text.ParseException, org.hibernate.HibernateException, org.hibernate.UnknownProfileException, javax.naming.NamingException {

		// arrange
		ThesaurusConceptGroupLabelDAO thesaurusConceptGroupLabelDAO =
			 new ThesaurusConceptGroupLabelDAO();
		List list = new ArrayList();
		ThesaurusConceptGroupLabel thesaurusConceptGroupLabel =
			 new ThesaurusConceptGroupLabel();
		ThesaurusConceptGroup conceptGroup = new ThesaurusConceptGroup();
		thesaurusConceptGroupLabel.setConceptGroup(conceptGroup);
		Date created =
			 new java.text.SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31");
		thesaurusConceptGroupLabel.setCreated(created);
		thesaurusConceptGroupLabel.setIdentifier(1);
		Language language = new Language();
		thesaurusConceptGroupLabel.setLanguage(language);
		thesaurusConceptGroupLabel.setLexicalValue("value");
		Date modified =
			 new java.text.SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31");
		thesaurusConceptGroupLabel.setModified(modified);
		list.add(thesaurusConceptGroupLabel);
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
		thesaurusConceptGroupLabelDAO.setSessionFactory(sessionFactory);

		// act
		ThesaurusConceptGroupLabel result =
			 thesaurusConceptGroupLabelDAO.findByThesaurusConceptGroupAndLanguage("bar");

		// assert
		assertSame(conceptGroup, result.getConceptGroup());
		assertSame(created, result.getCreated());
		assertEquals(1, (int) result.getIdentifier());
		assertSame(language, result.getLanguage());
		assertEquals("value", result.getLexicalValue());
		assertSame(modified, result.getModified());
	}

	@Test
	public void findByThesaurusConceptGroupThesaurusConceptGroupIdIsHello() throws java.text.ParseException, org.hibernate.HibernateException, org.hibernate.UnknownProfileException, javax.naming.NamingException {

		// arrange
		ThesaurusConceptGroupLabelDAO thesaurusConceptGroupLabelDAO =
			 new ThesaurusConceptGroupLabelDAO();
		ThesaurusConceptGroupLabel thesaurusConceptGroupLabel =
			 new ThesaurusConceptGroupLabel();
		ThesaurusConceptGroup conceptGroup = new ThesaurusConceptGroup();
		thesaurusConceptGroupLabel.setConceptGroup(conceptGroup);
		Date created =
			 new java.text.SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31");
		thesaurusConceptGroupLabel.setCreated(created);
		thesaurusConceptGroupLabel.setIdentifier(1);
		Language language = new Language();
		thesaurusConceptGroupLabel.setLanguage(language);
		thesaurusConceptGroupLabel.setLexicalValue("value");
		Date modified =
			 new java.text.SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31");
		thesaurusConceptGroupLabel.setModified(modified);
		Criteria criteria1 = mock(Criteria.class);
		Criteria criteria2 = mock(Criteria.class);
		when(criteria2.add(Mockito.<org.hibernate.criterion.Criterion>any()))
			.thenReturn(criteria1);
		when(criteria2.uniqueResult())
			.thenReturn(thesaurusConceptGroupLabel);
		Session session = mock(Session.class);
		when(session.createCriteria(Mockito.<Class>any()))
			.thenReturn(criteria2);
		SessionFactory sessionFactory = mock(SessionFactory.class);
		when(sessionFactory.getCurrentSession())
			.thenReturn(session);
		thesaurusConceptGroupLabelDAO.setSessionFactory(sessionFactory);

		// act
		ThesaurusConceptGroupLabel result =
			 thesaurusConceptGroupLabelDAO.findByThesaurusConceptGroup("hello");

		// assert
		assertSame(conceptGroup, result.getConceptGroup());
		assertSame(created, result.getCreated());
		assertEquals(1, (int) result.getIdentifier());
		assertSame(language, result.getLanguage());
		assertEquals("value", result.getLexicalValue());
		assertSame(modified, result.getModified());
	}
}
