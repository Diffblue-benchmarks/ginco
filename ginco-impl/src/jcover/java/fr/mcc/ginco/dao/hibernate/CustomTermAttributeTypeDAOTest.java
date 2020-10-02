package fr.mcc.ginco.dao.hibernate;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import fr.mcc.ginco.beans.CustomTermAttributeType;
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
 * Unit tests for fr.mcc.ginco.dao.hibernate.CustomTermAttributeTypeDAO
 *
 * @author Diffblue Cover
 */

public class CustomTermAttributeTypeDAOTest {

	@Test
	public void factory() throws org.hibernate.HibernateException, javax.naming.NamingException {
		CustomTermAttributeTypeDAO customTermAttributeTypeDAO =
			 new CustomTermAttributeTypeDAO();
		SessionFactory sessionFactory = mock(SessionFactory.class);
		customTermAttributeTypeDAO.setSessionFactory(sessionFactory);
		assertSame(sessionFactory, customTermAttributeTypeDAO.getSessionFactory());
	}

	@Test
	public void getAttributesByThesaurus() throws org.hibernate.HibernateException, org.hibernate.UnknownProfileException, javax.naming.NamingException, java.text.ParseException {

		// arrange
		CustomTermAttributeTypeDAO customTermAttributeTypeDAO =
			 new CustomTermAttributeTypeDAO();
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
		customTermAttributeTypeDAO.setSessionFactory(sessionFactory);
		Thesaurus thesaurus = new Thesaurus();
		thesaurus.setArchived(false);
		thesaurus.setContributor("foo");
		thesaurus.setCoverage("foo");
		thesaurus.setCreated(new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31"));
		ThesaurusOrganization creator = new ThesaurusOrganization();
		creator.setEmail("info@diffblue.com");
		creator.setHomepage("foo");
		creator.setIdentifier(1);
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
		List<CustomTermAttributeType> result =
			 customTermAttributeTypeDAO.getAttributesByThesaurus(thesaurus);

		// assert
		assertEquals(1, result.size());
		// pojo Object
	}

	@Test
	public void getAttributeByValue() throws org.hibernate.HibernateException, org.hibernate.UnknownProfileException, javax.naming.NamingException {

		// arrange
		CustomTermAttributeTypeDAO customTermAttributeTypeDAO =
			 new CustomTermAttributeTypeDAO();
		List list = new ArrayList();
		CustomTermAttributeType customTermAttributeType =
			 new CustomTermAttributeType();
		customTermAttributeType.setCode("DE");
		customTermAttributeType.setIdentifier(1);
		Thesaurus thesaurus1 = new Thesaurus();
		customTermAttributeType.setThesaurus(thesaurus1);
		customTermAttributeType.setValue("value");
		list.add(customTermAttributeType);
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
		customTermAttributeTypeDAO.setSessionFactory(sessionFactory);

		// act
		CustomTermAttributeType result =
			 customTermAttributeTypeDAO.getAttributeByValue(new Thesaurus(), "value");

		// assert
		assertEquals("DE", result.getCode());
		assertEquals(1, result.getIdentifier());
		assertSame(thesaurus1, result.getThesaurus());
		assertEquals("value", result.getValue());
	}

	@Test
	public void getAttributeByValueReturnsNull() throws org.hibernate.HibernateException, org.hibernate.UnknownProfileException, javax.naming.NamingException {
		CustomTermAttributeTypeDAO customTermAttributeTypeDAO =
			 new CustomTermAttributeTypeDAO();
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
		customTermAttributeTypeDAO.setSessionFactory(sessionFactory);
		assertNull(customTermAttributeTypeDAO.getAttributeByValue(new Thesaurus(), "value"));
	}

	@Test
	public void getAttributeByCode() throws org.hibernate.HibernateException, org.hibernate.UnknownProfileException, javax.naming.NamingException {

		// arrange
		CustomTermAttributeTypeDAO customTermAttributeTypeDAO =
			 new CustomTermAttributeTypeDAO();
		List list = new ArrayList();
		CustomTermAttributeType customTermAttributeType =
			 new CustomTermAttributeType();
		customTermAttributeType.setCode("DE");
		customTermAttributeType.setIdentifier(1);
		Thesaurus thesaurus1 = new Thesaurus();
		customTermAttributeType.setThesaurus(thesaurus1);
		customTermAttributeType.setValue("value");
		list.add(customTermAttributeType);
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
		customTermAttributeTypeDAO.setSessionFactory(sessionFactory);

		// act
		CustomTermAttributeType result =
			 customTermAttributeTypeDAO.getAttributeByCode(new Thesaurus(), "DE");

		// assert
		assertEquals("DE", result.getCode());
		assertEquals(1, result.getIdentifier());
		assertSame(thesaurus1, result.getThesaurus());
		assertEquals("value", result.getValue());
	}

	@Test
	public void getAttributeByCodeReturnsNull() throws org.hibernate.HibernateException, org.hibernate.UnknownProfileException, javax.naming.NamingException {
		CustomTermAttributeTypeDAO customTermAttributeTypeDAO =
			 new CustomTermAttributeTypeDAO();
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
		customTermAttributeTypeDAO.setSessionFactory(sessionFactory);
		assertNull(customTermAttributeTypeDAO.getAttributeByCode(new Thesaurus(), "DE"));
	}
}
