package fr.mcc.ginco.dao.hibernate;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import fr.mcc.ginco.beans.AssociativeRelationship;
import fr.mcc.ginco.beans.Language;
import fr.mcc.ginco.beans.Thesaurus;
import fr.mcc.ginco.beans.ThesaurusArray;
import fr.mcc.ginco.beans.ThesaurusConcept;
import fr.mcc.ginco.beans.ThesaurusFormat;
import fr.mcc.ginco.beans.ThesaurusOrganization;
import fr.mcc.ginco.beans.ThesaurusType;
import fr.mcc.ginco.beans.ThesaurusVersionHistory;

import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;
import org.mockito.Mockito;

/**
 * Unit tests for fr.mcc.ginco.dao.hibernate.ThesaurusConceptDAO
 *
 * @author Diffblue Cover
 */

public class ThesaurusConceptDAOTest {

	@Test
	public void factory() throws org.hibernate.HibernateException, javax.naming.NamingException {
		ThesaurusConceptDAO thesaurusConceptDAO = new ThesaurusConceptDAO();
		SessionFactory sessionFactory = mock(SessionFactory.class);
		thesaurusConceptDAO.setSessionFactory(sessionFactory);
		assertSame(sessionFactory, thesaurusConceptDAO.getSessionFactory());
	}

	@Test
	public void getRootConceptsSearchOrphansIsFalse() throws org.hibernate.HibernateException, org.hibernate.UnknownProfileException, javax.naming.NamingException {

		// arrange
		ThesaurusConceptDAO thesaurusConceptDAO = new ThesaurusConceptDAO();
		List list = new ArrayList();
		list.add(new Object());
		Criteria criteria1 = mock(Criteria.class);
		Criteria criteria2 = mock(Criteria.class);
		Criteria criteria3 = mock(Criteria.class);
		Criteria criteria4 = mock(Criteria.class);
		when(criteria4.add(Mockito.<org.hibernate.criterion.Criterion>any()))
			.thenReturn(criteria3)
			.thenReturn(criteria2)
			.thenReturn(criteria1);
		when(criteria4.list())
			.thenReturn(list);
		Session session = mock(Session.class);
		when(session.createCriteria(Mockito.<Class>any(), Mockito.<String>any()))
			.thenReturn(criteria4);
		SessionFactory sessionFactory = mock(SessionFactory.class);
		when(sessionFactory.getCurrentSession())
			.thenReturn(session);
		thesaurusConceptDAO.setSessionFactory(sessionFactory);

		// act
		List<ThesaurusConcept> result =
			 thesaurusConceptDAO.getRootConcepts("1234", false);

		// assert
		assertEquals(1, result.size());
		// pojo Object
	}

	@Test
	public void getIdentifiersOfConceptsWithChildren() throws org.hibernate.HibernateException, org.hibernate.MappingException, org.hibernate.UnknownProfileException, javax.naming.NamingException {
		ThesaurusConceptDAO thesaurusConceptDAO = new ThesaurusConceptDAO();
		List list = new ArrayList();
		list.add(new Object());
		Query query = mock(Query.class);
		SQLQuery obj = mock(SQLQuery.class);
		when(obj.list())
			.thenReturn(list);
		when(obj.setParameter(Mockito.<String>any(), Mockito.<Object>any()))
			.thenReturn(query);
		Session session = mock(Session.class);
		when(session.createSQLQuery(Mockito.<String>any()))
			.thenReturn(obj);
		SessionFactory sessionFactory = mock(SessionFactory.class);
		when(sessionFactory.getCurrentSession())
			.thenReturn(session);
		thesaurusConceptDAO.setSessionFactory(sessionFactory);
		assertEquals(1, thesaurusConceptDAO.getIdentifiersOfConceptsWithChildren("1234").size());
		assertTrue(thesaurusConceptDAO.getIdentifiersOfConceptsWithChildren("1234").get(0) instanceof Object);
		// pojo Object
	}

	@Test
	public void getConceptsByThesaurusIdOnlyValidatedConceptsIsFalseAndSearchOrphansIsFalse() throws org.hibernate.HibernateException, org.hibernate.UnknownProfileException, javax.naming.NamingException {

		// arrange
		ThesaurusConceptDAO thesaurusConceptDAO = new ThesaurusConceptDAO();
		List list = new ArrayList();
		list.add(new Object());
		Criteria criteria1 = mock(Criteria.class);
		Criteria criteria2 = mock(Criteria.class);
		Criteria criteria3 = mock(Criteria.class);
		Criteria criteria4 = mock(Criteria.class);
		when(criteria4.add(Mockito.<org.hibernate.criterion.Criterion>any()))
			.thenReturn(criteria3)
			.thenReturn(criteria2)
			.thenReturn(criteria1);
		when(criteria4.list())
			.thenReturn(list);
		Session session = mock(Session.class);
		when(session.createCriteria(Mockito.<Class>any(), Mockito.<String>any()))
			.thenReturn(criteria4);
		SessionFactory sessionFactory = mock(SessionFactory.class);
		when(sessionFactory.getCurrentSession())
			.thenReturn(session);
		thesaurusConceptDAO.setSessionFactory(sessionFactory);

		// act
		List<ThesaurusConcept> result =
			 thesaurusConceptDAO.getConceptsByThesaurusId("1234", "1234", false, false);

		// assert
		assertEquals(1, result.size());
		// pojo Object
	}

	@Test
	public void getAllRootChildren() throws org.hibernate.HibernateException, org.hibernate.UnknownProfileException, javax.naming.NamingException, java.text.ParseException {

		// arrange
		ThesaurusConceptDAO thesaurusConceptDAO = new ThesaurusConceptDAO();
		List list = new ArrayList();
		list.add(new Object());
		Criteria criteria1 = mock(Criteria.class);
		Criteria criteria2 = mock(Criteria.class);
		when(criteria2.add(Mockito.<org.hibernate.criterion.Criterion>any()))
			.thenReturn(criteria1);
		Criteria criteria3 = mock(Criteria.class);
		when(criteria3.createCriteria(Mockito.<String>any(), Mockito.<String>any()))
			.thenReturn(criteria2);
		when(criteria3.list())
			.thenReturn(list);
		Session session = mock(Session.class);
		when(session.createCriteria(Mockito.<Class>any(), Mockito.<String>any()))
			.thenReturn(criteria3);
		SessionFactory sessionFactory = mock(SessionFactory.class);
		when(sessionFactory.getCurrentSession())
			.thenReturn(session);
		thesaurusConceptDAO.setSessionFactory(sessionFactory);
		ThesaurusConcept concept = new ThesaurusConcept();
		concept.setAssociativeRelationshipLeft(new HashSet<AssociativeRelationship>());
		concept.setAssociativeRelationshipRight(new HashSet<AssociativeRelationship>());
		concept.setConceptArrays(new HashSet<ThesaurusArray>());
		concept.setCreated(new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31"));
		concept.setIdentifier("data");
		concept.setModified(new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31"));
		concept.setNotation("DE");
		concept.setParentConcepts(new HashSet<ThesaurusConcept>());
		concept.setRootConcepts(new HashSet<ThesaurusConcept>());
		concept.setStatus(1);
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
		concept.setThesaurus(thesaurus);
		concept.setTopConcept(false);

		// act
		List<ThesaurusConcept> result =
			 thesaurusConceptDAO.getAllRootChildren(concept);

		// assert
		assertEquals(1, result.size());
		// pojo Object
	}

	@Test
	public void countConceptsReturnsOne() throws org.hibernate.HibernateException, org.hibernate.UnknownProfileException, javax.naming.NamingException {
		ThesaurusConceptDAO thesaurusConceptDAO = new ThesaurusConceptDAO();
		List list = new ArrayList();
		list.add(1L);
		Criteria criteria1 = mock(Criteria.class);
		Criteria criteria2 = mock(Criteria.class);
		when(criteria2.setProjection(Mockito.<org.hibernate.criterion.Projection>any()))
			.thenReturn(criteria1);
		Criteria criteria3 = mock(Criteria.class);
		when(criteria3.add(Mockito.<org.hibernate.criterion.Criterion>any()))
			.thenReturn(criteria2);
		when(criteria3.list())
			.thenReturn(list);
		Session session = mock(Session.class);
		when(session.createCriteria(Mockito.<Class>any()))
			.thenReturn(criteria3);
		SessionFactory sessionFactory = mock(SessionFactory.class);
		when(sessionFactory.getCurrentSession())
			.thenReturn(session);
		thesaurusConceptDAO.setSessionFactory(sessionFactory);
		assertEquals(1L, (long) thesaurusConceptDAO.countConcepts("1234"));
	}

	@Test
	public void countConceptsWoNotesReturnsOne() throws org.hibernate.HibernateException, org.hibernate.MappingException, org.hibernate.UnknownProfileException, javax.naming.NamingException {
		ThesaurusConceptDAO thesaurusConceptDAO = new ThesaurusConceptDAO();
		List list = new ArrayList();
		list.add(BigInteger.valueOf(1L));
		Query query = mock(Query.class);
		SQLQuery obj = mock(SQLQuery.class);
		when(obj.list())
			.thenReturn(list);
		when(obj.setParameter(Mockito.<String>any(), Mockito.<Object>any()))
			.thenReturn(query);
		Session session = mock(Session.class);
		when(session.createSQLQuery(Mockito.<String>any()))
			.thenReturn(obj);
		SessionFactory sessionFactory = mock(SessionFactory.class);
		when(sessionFactory.getCurrentSession())
			.thenReturn(session);
		thesaurusConceptDAO.setSessionFactory(sessionFactory);
		assertEquals(1L, (long) thesaurusConceptDAO.countConceptsWoNotes("1234"));
	}

	@Test
	public void countConceptsAlignedToIntThesReturnsOne() throws org.hibernate.HibernateException, org.hibernate.UnknownProfileException, javax.naming.NamingException {
		ThesaurusConceptDAO thesaurusConceptDAO = new ThesaurusConceptDAO();
		List list = new ArrayList();
		list.add(1L);
		Criteria criteria1 = mock(Criteria.class);
		when(criteria1.list())
			.thenReturn(list);
		Criteria criteria2 = mock(Criteria.class);
		when(criteria2.setProjection(Mockito.<org.hibernate.criterion.Projection>any()))
			.thenReturn(criteria1);
		Criteria criteria3 = mock(Criteria.class);
		when(criteria3.add(Mockito.<org.hibernate.criterion.Criterion>any()))
			.thenReturn(criteria2);
		Session session = mock(Session.class);
		when(session.createCriteria(Mockito.<Class>any(), Mockito.<String>any()))
			.thenReturn(criteria3);
		SessionFactory sessionFactory = mock(SessionFactory.class);
		when(sessionFactory.getCurrentSession())
			.thenReturn(session);
		thesaurusConceptDAO.setSessionFactory(sessionFactory);
		assertEquals(1L, (long) thesaurusConceptDAO.countConceptsAlignedToIntThes("1234"));
	}

	@Test
	public void countConceptsAlignedToExtThesIdThesaurusIsHelloReturnsOne() throws org.hibernate.HibernateException, org.hibernate.UnknownProfileException, javax.naming.NamingException {
		ThesaurusConceptDAO thesaurusConceptDAO = new ThesaurusConceptDAO();
		List list = new ArrayList();
		list.add(1L);
		Criteria criteria1 = mock(Criteria.class);
		when(criteria1.list())
			.thenReturn(list);
		Criteria criteria2 = mock(Criteria.class);
		when(criteria2.setProjection(Mockito.<org.hibernate.criterion.Projection>any()))
			.thenReturn(criteria1);
		Criteria criteria3 = mock(Criteria.class);
		when(criteria3.add(Mockito.<org.hibernate.criterion.Criterion>any()))
			.thenReturn(criteria2);
		Session session = mock(Session.class);
		when(session.createCriteria(Mockito.<Class>any(), Mockito.<String>any()))
			.thenReturn(criteria3);
		SessionFactory sessionFactory = mock(SessionFactory.class);
		when(sessionFactory.getCurrentSession())
			.thenReturn(session);
		thesaurusConceptDAO.setSessionFactory(sessionFactory);
		assertEquals(1L, (long) thesaurusConceptDAO.countConceptsAlignedToExtThes("hello"));
	}

	@Test
	public void countConceptsAlignedToMyThesReturnsOne() throws org.hibernate.HibernateException, org.hibernate.UnknownProfileException, javax.naming.NamingException {
		ThesaurusConceptDAO thesaurusConceptDAO = new ThesaurusConceptDAO();
		List list = new ArrayList();
		list.add(1L);
		Criteria criteria1 = mock(Criteria.class);
		when(criteria1.list())
			.thenReturn(list);
		Criteria criteria2 = mock(Criteria.class);
		when(criteria2.setProjection(Mockito.<org.hibernate.criterion.Projection>any()))
			.thenReturn(criteria1);
		Criteria criteria3 = mock(Criteria.class);
		when(criteria3.add(Mockito.<org.hibernate.criterion.Criterion>any()))
			.thenReturn(criteria2);
		Session session = mock(Session.class);
		when(session.createCriteria(Mockito.<Class>any(), Mockito.<String>any()))
			.thenReturn(criteria3);
		SessionFactory sessionFactory = mock(SessionFactory.class);
		when(sessionFactory.getCurrentSession())
			.thenReturn(session);
		thesaurusConceptDAO.setSessionFactory(sessionFactory);
		assertEquals(1L, (long) thesaurusConceptDAO.countConceptsAlignedToMyThes("1234"));
	}

	@Test
	public void getConceptsAlignedToMyThesLimitIsOneAndStartIndexIsOne() throws org.hibernate.HibernateException, org.hibernate.UnknownProfileException, javax.naming.NamingException {

		// arrange
		ThesaurusConceptDAO thesaurusConceptDAO = new ThesaurusConceptDAO();
		List list = new ArrayList();
		list.add(new Object());
		Criteria criteria1 = mock(Criteria.class);
		when(criteria1.list())
			.thenReturn(list);
		Criteria criteria2 = mock(Criteria.class);
		when(criteria2.setMaxResults(anyInt()))
			.thenReturn(criteria1);
		Criteria criteria3 = mock(Criteria.class);
		when(criteria3.setFirstResult(anyInt()))
			.thenReturn(criteria2);
		Criteria criteria4 = mock(Criteria.class);
		when(criteria4.add(Mockito.<org.hibernate.criterion.Criterion>any()))
			.thenReturn(criteria3);
		Session session = mock(Session.class);
		when(session.createCriteria(Mockito.<Class>any(), Mockito.<String>any()))
			.thenReturn(criteria4);
		SessionFactory sessionFactory = mock(SessionFactory.class);
		when(sessionFactory.getCurrentSession())
			.thenReturn(session);
		thesaurusConceptDAO.setSessionFactory(sessionFactory);

		// act
		List<ThesaurusConcept> result =
			 thesaurusConceptDAO.getConceptsAlignedToMyThes("1234", 1, 1);

		// assert
		assertEquals(1, result.size());
		// pojo Object
	}
}
