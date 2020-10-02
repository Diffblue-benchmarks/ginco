package fr.mcc.ginco.dao.hibernate;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import fr.mcc.ginco.beans.CustomConceptAttributeType;
import fr.mcc.ginco.beans.Language;
import fr.mcc.ginco.beans.Thesaurus;
import fr.mcc.ginco.beans.ThesaurusFormat;
import fr.mcc.ginco.beans.ThesaurusOrganization;
import fr.mcc.ginco.beans.ThesaurusType;
import fr.mcc.ginco.beans.ThesaurusVersionHistory;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;
import org.mockito.Mockito;

/**
 * Unit tests for fr.mcc.ginco.dao.hibernate.CustomConceptAttributeTypeDAO
 *
 * @author Diffblue Cover
 */

public class CustomConceptAttributeTypeDAOTest {

	@Test
	public void factory() throws org.hibernate.HibernateException, javax.naming.NamingException {
		CustomConceptAttributeTypeDAO customConceptAttributeTypeDAO =
			 new CustomConceptAttributeTypeDAO();
		SessionFactory sessionFactory = mock(SessionFactory.class);
		customConceptAttributeTypeDAO.setSessionFactory(sessionFactory);
		assertSame(sessionFactory, customConceptAttributeTypeDAO.getSessionFactory());
	}

	@Test
	public void getAttributesByThesaurus() throws org.hibernate.HibernateException, org.hibernate.UnknownProfileException, javax.naming.NamingException, java.text.ParseException {

		// arrange
		CustomConceptAttributeTypeDAO customConceptAttributeTypeDAO =
			 new CustomConceptAttributeTypeDAO();
		List list = new ArrayList();
		list.add(new Object());
		Criteria criteria1 = mock(Criteria.class);
		when(criteria1.list())
			.thenReturn(list);
		Criteria criteria2 = mock(Criteria.class);
		when(criteria2.add(Mockito.<org.hibernate.criterion.Criterion>any()))
			.thenReturn(criteria1);
		Session session = mock(Session.class);
		when(session.createCriteria(Mockito.<Class>any()))
			.thenReturn(criteria2);
		SessionFactory sessionFactory = mock(SessionFactory.class);
		when(sessionFactory.getCurrentSession())
			.thenReturn(session);
		customConceptAttributeTypeDAO.setSessionFactory(sessionFactory);
		Thesaurus thesaurus = new Thesaurus();
		thesaurus.setArchived(false);
		thesaurus.setContributor("foo");
		thesaurus.setCoverage("foo");
		thesaurus.setCreated(new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31"));
		ThesaurusOrganization creator = new ThesaurusOrganization();
		creator.setEmail("info@diffblue.com");
		creator.setHomepage("foo");
		creator.setName("Acme");
		thesaurus.setCreator(creator);
		thesaurus.setDate(new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31"));
		thesaurus.setDefaultTopConcept(false);
		thesaurus.setDescription("some text");
		thesaurus.setFormat(new HashSet<ThesaurusFormat>());
		thesaurus.setIdentifier("data");
		thesaurus.setLang(new HashSet<Language>());
		thesaurus.setPolyHierarchical(false);
		thesaurus.setPublisher("foo");
		thesaurus.setRelation("DE");
		thesaurus.setRights("foo");
		thesaurus.setSource("foo");
		thesaurus.setSubject("foo");
		thesaurus.setTitle("Mr");
		ThesaurusType type = new ThesaurusType();
		type.setIdentifier(1);
		type.setLabel("label");
		thesaurus.setType(type);
		thesaurus.setVersions(new HashSet<ThesaurusVersionHistory>());

		// act
		List<CustomConceptAttributeType> result =
			 customConceptAttributeTypeDAO.getAttributesByThesaurus(thesaurus);

		// assert
		assertEquals(1, result.size());
		// pojo Object
	}

	@Test
	public void getAttributeByCode() throws org.hibernate.HibernateException, org.hibernate.UnknownProfileException, javax.naming.NamingException {

		// arrange
		CustomConceptAttributeTypeDAO customConceptAttributeTypeDAO =
			 new CustomConceptAttributeTypeDAO();
		List list = new ArrayList();
		CustomConceptAttributeType customConceptAttributeType =
			 new CustomConceptAttributeType();
		customConceptAttributeType.setExportable(false);
		customConceptAttributeType.setCode("DE");
		customConceptAttributeType.setIdentifier(1);
		Thesaurus thesaurus1 = new Thesaurus();
		customConceptAttributeType.setThesaurus(thesaurus1);
		customConceptAttributeType.setValue("value");
		list.add(customConceptAttributeType);
		Criteria criteria1 = mock(Criteria.class);
		when(criteria1.list())
			.thenReturn(list);
		Criteria criteria2 = mock(Criteria.class);
		when(criteria2.add(Mockito.<org.hibernate.criterion.Criterion>any()))
			.thenReturn(criteria1);
		Criteria criteria3 = mock(Criteria.class);
		when(criteria3.add(Mockito.<org.hibernate.criterion.Criterion>any()))
			.thenReturn(criteria2);
		Session session = mock(Session.class);
		when(session.createCriteria(Mockito.<Class>any()))
			.thenReturn(criteria3);
		SessionFactory sessionFactory = mock(SessionFactory.class);
		when(sessionFactory.getCurrentSession())
			.thenReturn(session);
		customConceptAttributeTypeDAO.setSessionFactory(sessionFactory);

		// act
		CustomConceptAttributeType result =
			 customConceptAttributeTypeDAO.getAttributeByCode(new Thesaurus(), "DE");

		// assert
		assertFalse(result.getExportable());
		assertEquals("DE", result.getCode());
		assertEquals(1, result.getIdentifier());
		assertSame(thesaurus1, result.getThesaurus());
		assertEquals("value", result.getValue());
	}

	@Test
	public void getAttributeByCodeReturnsNull() throws org.hibernate.HibernateException, org.hibernate.UnknownProfileException, javax.naming.NamingException {
		CustomConceptAttributeTypeDAO customConceptAttributeTypeDAO =
			 new CustomConceptAttributeTypeDAO();
		Criteria criteria1 = mock(Criteria.class);
		when(criteria1.list())
			.thenReturn(new ArrayList());
		Criteria criteria2 = mock(Criteria.class);
		when(criteria2.add(Mockito.<org.hibernate.criterion.Criterion>any()))
			.thenReturn(criteria1);
		Criteria criteria3 = mock(Criteria.class);
		when(criteria3.add(Mockito.<org.hibernate.criterion.Criterion>any()))
			.thenReturn(criteria2);
		Session session = mock(Session.class);
		when(session.createCriteria(Mockito.<Class>any()))
			.thenReturn(criteria3);
		SessionFactory sessionFactory = mock(SessionFactory.class);
		when(sessionFactory.getCurrentSession())
			.thenReturn(session);
		customConceptAttributeTypeDAO.setSessionFactory(sessionFactory);
		assertNull(customConceptAttributeTypeDAO.getAttributeByCode(new Thesaurus(), "DE"));
	}

	@Test
	public void getAttributeByValue() throws org.hibernate.HibernateException, org.hibernate.UnknownProfileException, javax.naming.NamingException {

		// arrange
		CustomConceptAttributeTypeDAO customConceptAttributeTypeDAO =
			 new CustomConceptAttributeTypeDAO();
		List list = new ArrayList();
		CustomConceptAttributeType customConceptAttributeType =
			 new CustomConceptAttributeType();
		customConceptAttributeType.setExportable(false);
		customConceptAttributeType.setCode("DE");
		customConceptAttributeType.setIdentifier(1);
		Thesaurus thesaurus1 = new Thesaurus();
		customConceptAttributeType.setThesaurus(thesaurus1);
		customConceptAttributeType.setValue("value");
		list.add(customConceptAttributeType);
		Criteria criteria1 = mock(Criteria.class);
		when(criteria1.list())
			.thenReturn(list);
		Criteria criteria2 = mock(Criteria.class);
		when(criteria2.add(Mockito.<org.hibernate.criterion.Criterion>any()))
			.thenReturn(criteria1);
		Criteria criteria3 = mock(Criteria.class);
		when(criteria3.add(Mockito.<org.hibernate.criterion.Criterion>any()))
			.thenReturn(criteria2);
		Session session = mock(Session.class);
		when(session.createCriteria(Mockito.<Class>any()))
			.thenReturn(criteria3);
		SessionFactory sessionFactory = mock(SessionFactory.class);
		when(sessionFactory.getCurrentSession())
			.thenReturn(session);
		customConceptAttributeTypeDAO.setSessionFactory(sessionFactory);

		// act
		CustomConceptAttributeType result =
			 customConceptAttributeTypeDAO.getAttributeByValue(new Thesaurus(), "value");

		// assert
		assertFalse(result.getExportable());
		assertEquals("DE", result.getCode());
		assertEquals(1, result.getIdentifier());
		assertSame(thesaurus1, result.getThesaurus());
		assertEquals("value", result.getValue());
	}

	@Test
	public void getAttributeByValueReturnsNull() throws org.hibernate.HibernateException, org.hibernate.UnknownProfileException, javax.naming.NamingException {
		CustomConceptAttributeTypeDAO customConceptAttributeTypeDAO =
			 new CustomConceptAttributeTypeDAO();
		Criteria criteria1 = mock(Criteria.class);
		when(criteria1.list())
			.thenReturn(new ArrayList());
		Criteria criteria2 = mock(Criteria.class);
		when(criteria2.add(Mockito.<org.hibernate.criterion.Criterion>any()))
			.thenReturn(criteria1);
		Criteria criteria3 = mock(Criteria.class);
		when(criteria3.add(Mockito.<org.hibernate.criterion.Criterion>any()))
			.thenReturn(criteria2);
		Session session = mock(Session.class);
		when(session.createCriteria(Mockito.<Class>any()))
			.thenReturn(criteria3);
		SessionFactory sessionFactory = mock(SessionFactory.class);
		when(sessionFactory.getCurrentSession())
			.thenReturn(session);
		customConceptAttributeTypeDAO.setSessionFactory(sessionFactory);
		assertNull(customConceptAttributeTypeDAO.getAttributeByValue(new Thesaurus(), "value"));
	}
}
