package fr.mcc.ginco.dao.hibernate;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import fr.mcc.ginco.beans.Language;
import fr.mcc.ginco.beans.Thesaurus;
import fr.mcc.ginco.beans.ThesaurusConcept;
import fr.mcc.ginco.beans.ThesaurusFormat;
import fr.mcc.ginco.beans.ThesaurusOrganization;
import fr.mcc.ginco.beans.ThesaurusType;
import fr.mcc.ginco.beans.ThesaurusVersionHistory;
import fr.mcc.ginco.enums.ConceptStatusEnum;

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
	public void getOrphansThesaurusConceptMaxResultsIsOne() throws org.hibernate.HibernateException, org.hibernate.UnknownProfileException, javax.naming.NamingException, java.text.ParseException {

		// arrange
		ThesaurusConceptDAO thesaurusConceptDAO = new ThesaurusConceptDAO();
		List list = new ArrayList();
		list.add(new Object());
		Criteria criteria1 = mock(Criteria.class);
		Criteria criteria2 = mock(Criteria.class);
		Criteria criteria3 = mock(Criteria.class);
		Criteria criteria4 = mock(Criteria.class);
		Criteria criteria5 = mock(Criteria.class);
		when(criteria5.add(Mockito.<org.hibernate.criterion.Criterion>any()))
			.thenReturn(criteria4)
			.thenReturn(criteria3)
			.thenReturn(criteria2);
		when(criteria5.list())
			.thenReturn(list);
		when(criteria5.setMaxResults(anyInt()))
			.thenReturn(criteria1);
		Session session = mock(Session.class);
		when(session.createCriteria(Mockito.<Class>any(), Mockito.<String>any()))
			.thenReturn(criteria5);
		SessionFactory sessionFactory = mock(SessionFactory.class);
		when(sessionFactory.getCurrentSession())
			.thenReturn(session);
		thesaurusConceptDAO.setSessionFactory(sessionFactory);
		Thesaurus thesaurus = new Thesaurus();
		thesaurus.setArchived(false);
		thesaurus.setContributor("foo");
		thesaurus.setCoverage("foo");
		thesaurus.setCreated(new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31"));
		ThesaurusOrganization creator = mock(ThesaurusOrganization.class);
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
		List<ThesaurusConcept> result =
			 thesaurusConceptDAO.getOrphansThesaurusConcept(thesaurus, 1);

		// assert
		assertEquals(1, result.size());
		// pojo Object
	}

	@Test
	public void getOrphansThesaurusConceptCountReturnsOne() throws org.hibernate.HibernateException, org.hibernate.UnknownProfileException, javax.naming.NamingException {
		ThesaurusConceptDAO thesaurusConceptDAO = new ThesaurusConceptDAO();
		List list = new ArrayList();
		list.add(1L);
		Criteria criteria1 = mock(Criteria.class);
		when(criteria1.list())
			.thenReturn(list);
		Criteria criteria2 = mock(Criteria.class);
		Criteria criteria3 = mock(Criteria.class);
		Criteria criteria4 = mock(Criteria.class);
		Criteria criteria5 = mock(Criteria.class);
		when(criteria5.add(Mockito.<org.hibernate.criterion.Criterion>any()))
			.thenReturn(criteria4)
			.thenReturn(criteria3)
			.thenReturn(criteria2);
		when(criteria5.setProjection(Mockito.<org.hibernate.criterion.Projection>any()))
			.thenReturn(criteria1);
		Session session = mock(Session.class);
		when(session.createCriteria(Mockito.<Class>any(), Mockito.<String>any()))
			.thenReturn(criteria5);
		SessionFactory sessionFactory = mock(SessionFactory.class);
		when(sessionFactory.getCurrentSession())
			.thenReturn(session);
		thesaurusConceptDAO.setSessionFactory(sessionFactory);
		assertEquals(1L, thesaurusConceptDAO.getOrphansThesaurusConceptCount(new Thesaurus()));
	}

	@Test
	public void getTopTermThesaurusConceptLikeIsHelloAndMaxResultsIsOne() throws org.hibernate.HibernateException, org.hibernate.UnknownProfileException, javax.naming.NamingException, java.text.ParseException {

		// arrange
		ThesaurusConceptDAO thesaurusConceptDAO = new ThesaurusConceptDAO();
		List list = new ArrayList();
		list.add(new Object());
		Criteria criteria1 = mock(Criteria.class);
		Criteria criteria2 = mock(Criteria.class);
		Criteria criteria3 = mock(Criteria.class);
		Criteria criteria4 = mock(Criteria.class);
		Criteria criteria5 = mock(Criteria.class);
		Criteria criteria6 = mock(Criteria.class);
		Criteria criteria7 = mock(Criteria.class);
		when(criteria7.setResultTransformer(Mockito.<org.hibernate.transform.ResultTransformer>any()))
			.thenReturn(criteria6);
		Criteria criteria8 = mock(Criteria.class);
		when(criteria8.add(Mockito.<org.hibernate.criterion.Criterion>any()))
			.thenReturn(criteria5)
			.thenReturn(criteria4)
			.thenReturn(criteria3)
			.thenReturn(criteria2);
		when(criteria8.list())
			.thenReturn(list);
		when(criteria8.setMaxResults(anyInt()))
			.thenReturn(criteria1);
		when(criteria8.setProjection(Mockito.<org.hibernate.criterion.Projection>any()))
			.thenReturn(criteria7);
		Criteria criteria9 = mock(Criteria.class);
		when(criteria9.createCriteria(Mockito.<String>any(), Mockito.<String>any(), Mockito.<org.hibernate.sql.JoinType>any()))
			.thenReturn(criteria8);
		Criteria criteria10 = mock(Criteria.class);
		when(criteria10.add(Mockito.<org.hibernate.criterion.Criterion>any()))
			.thenReturn(criteria9);
		Session session1 = mock(Session.class);
		when(session1.createCriteria(Mockito.<Class>any(), Mockito.<String>any()))
			.thenReturn(criteria10);
		Criteria criteria11 = mock(Criteria.class);
		Session session2 = mock(Session.class);
		when(session2.createCriteria(Mockito.<Class>any(), Mockito.<String>any()))
			.thenReturn(criteria11);
		SessionFactory sessionFactory = mock(SessionFactory.class);
		when(sessionFactory.getCurrentSession())
			.thenReturn(session2)
			.thenReturn(session1);
		thesaurusConceptDAO.setSessionFactory(sessionFactory);
		Thesaurus thesaurus = new Thesaurus();
		thesaurus.setArchived(false);
		thesaurus.setContributor("foo");
		thesaurus.setCoverage("foo");
		thesaurus.setCreated(new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31"));
		ThesaurusOrganization creator = mock(ThesaurusOrganization.class);
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
		List<ThesaurusConcept> result =
			 thesaurusConceptDAO.getTopTermThesaurusConcept(thesaurus, 1, "hello");

		// assert
		assertEquals(1, result.size());
		// pojo Object
	}

	@Test
	public void getTopTermThesaurusConceptCountReturnsOne() throws org.hibernate.HibernateException, org.hibernate.UnknownProfileException, javax.naming.NamingException {
		ThesaurusConceptDAO thesaurusConceptDAO = new ThesaurusConceptDAO();
		List list = new ArrayList();
		list.add(1L);
		Criteria criteria1 = mock(Criteria.class);
		when(criteria1.list())
			.thenReturn(list);
		Criteria criteria2 = mock(Criteria.class);
		Criteria criteria3 = mock(Criteria.class);
		Criteria criteria4 = mock(Criteria.class);
		Criteria criteria5 = mock(Criteria.class);
		when(criteria5.add(Mockito.<org.hibernate.criterion.Criterion>any()))
			.thenReturn(criteria4)
			.thenReturn(criteria3)
			.thenReturn(criteria2);
		when(criteria5.setProjection(Mockito.<org.hibernate.criterion.Projection>any()))
			.thenReturn(criteria1);
		Session session = mock(Session.class);
		when(session.createCriteria(Mockito.<Class>any(), Mockito.<String>any()))
			.thenReturn(criteria5);
		SessionFactory sessionFactory = mock(SessionFactory.class);
		when(sessionFactory.getCurrentSession())
			.thenReturn(session);
		thesaurusConceptDAO.setSessionFactory(sessionFactory);
		assertEquals(1L, thesaurusConceptDAO.getTopTermThesaurusConceptCount(new Thesaurus()));
	}

	@Test
	public void getRootConceptsSearchOrphansIsFalse() throws org.hibernate.HibernateException, org.hibernate.UnknownProfileException, javax.naming.NamingException {
		ThesaurusConceptDAO thesaurusConceptDAO = new ThesaurusConceptDAO();
		Criteria criteria1 = mock(Criteria.class);
		Criteria criteria2 = mock(Criteria.class);
		Criteria criteria3 = mock(Criteria.class);
		Criteria criteria4 = mock(Criteria.class);
		when(criteria4.add(Mockito.<org.hibernate.criterion.Criterion>any()))
			.thenReturn(criteria3)
			.thenReturn(criteria2)
			.thenReturn(criteria1);
		when(criteria4.list())
			.thenReturn(new ArrayList());
		Session session = mock(Session.class);
		when(session.createCriteria(Mockito.<Class>any(), Mockito.<String>any()))
			.thenReturn(criteria4);
		SessionFactory sessionFactory = mock(SessionFactory.class);
		when(sessionFactory.getCurrentSession())
			.thenReturn(session);
		thesaurusConceptDAO.setSessionFactory(sessionFactory);
		assertTrue((thesaurusConceptDAO.getRootConcepts("1234", false)).isEmpty());
	}

	@Test
	public void getRootConceptsSearchOrphansIsTrue() throws org.hibernate.HibernateException, org.hibernate.UnknownProfileException, javax.naming.NamingException {
		ThesaurusConceptDAO thesaurusConceptDAO = new ThesaurusConceptDAO();
		Criteria criteria1 = mock(Criteria.class);
		Criteria criteria2 = mock(Criteria.class);
		Criteria criteria3 = mock(Criteria.class);
		Criteria criteria4 = mock(Criteria.class);
		when(criteria4.add(Mockito.<org.hibernate.criterion.Criterion>any()))
			.thenReturn(criteria3)
			.thenReturn(criteria2)
			.thenReturn(criteria1);
		when(criteria4.list())
			.thenReturn(new ArrayList());
		Session session = mock(Session.class);
		when(session.createCriteria(Mockito.<Class>any(), Mockito.<String>any()))
			.thenReturn(criteria4);
		SessionFactory sessionFactory = mock(SessionFactory.class);
		when(sessionFactory.getCurrentSession())
			.thenReturn(session);
		thesaurusConceptDAO.setSessionFactory(sessionFactory);
		assertTrue((thesaurusConceptDAO.getRootConcepts("1234", true)).isEmpty());
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
	public void getChildrenConceptsStatusIsCandidate() throws org.hibernate.HibernateException, org.hibernate.UnknownProfileException, javax.naming.NamingException {
		ThesaurusConceptDAO thesaurusConceptDAO = new ThesaurusConceptDAO();
		Criteria criteria1 = mock(Criteria.class);
		Criteria criteria2 = mock(Criteria.class);
		Criteria criteria3 = mock(Criteria.class);
		Criteria criteria4 = mock(Criteria.class);
		when(criteria4.add(Mockito.<org.hibernate.criterion.Criterion>any()))
			.thenReturn(criteria3);
		Criteria criteria5 = mock(Criteria.class);
		Criteria criteria6 = mock(Criteria.class);
		Criteria criteria7 = mock(Criteria.class);
		when(criteria7.setResultTransformer(Mockito.<org.hibernate.transform.ResultTransformer>any()))
			.thenReturn(criteria6);
		Criteria criteria8 = mock(Criteria.class);
		when(criteria8.add(Mockito.<org.hibernate.criterion.Criterion>any()))
			.thenReturn(criteria5)
			.thenReturn(criteria2);
		when(criteria8.createCriteria(Mockito.<String>any(), Mockito.<String>any()))
			.thenReturn(criteria4);
		when(criteria8.list())
			.thenReturn(new ArrayList());
		when(criteria8.setMaxResults(anyInt()))
			.thenReturn(criteria1);
		when(criteria8.setProjection(Mockito.<org.hibernate.criterion.Projection>any()))
			.thenReturn(criteria7);
		Criteria criteria9 = mock(Criteria.class);
		when(criteria9.createCriteria(Mockito.<String>any(), Mockito.<String>any(), Mockito.<org.hibernate.sql.JoinType>any()))
			.thenReturn(criteria8);
		Criteria criteria10 = mock(Criteria.class);
		when(criteria10.add(Mockito.<org.hibernate.criterion.Criterion>any()))
			.thenReturn(criteria9);
		Session session1 = mock(Session.class);
		when(session1.createCriteria(Mockito.<Class>any(), Mockito.<String>any()))
			.thenReturn(criteria10);
		Criteria criteria11 = mock(Criteria.class);
		Session session2 = mock(Session.class);
		when(session2.createCriteria(Mockito.<Class>any(), Mockito.<String>any()))
			.thenReturn(criteria11);
		SessionFactory sessionFactory = mock(SessionFactory.class);
		when(sessionFactory.getCurrentSession())
			.thenReturn(session2)
			.thenReturn(session1);
		thesaurusConceptDAO.setSessionFactory(sessionFactory);
		assertTrue((thesaurusConceptDAO.getChildrenConcepts("bar", 1, "hello", ConceptStatusEnum.CANDIDATE)).isEmpty());
	}

	@Test
	public void getChildrenConcepts() throws org.hibernate.HibernateException, org.hibernate.UnknownProfileException, javax.naming.NamingException {
		ThesaurusConceptDAO thesaurusConceptDAO = new ThesaurusConceptDAO();
		Criteria criteria1 = mock(Criteria.class);
		Criteria criteria2 = mock(Criteria.class);
		Criteria criteria3 = mock(Criteria.class);
		when(criteria3.add(Mockito.<org.hibernate.criterion.Criterion>any()))
			.thenReturn(criteria2);
		Criteria criteria4 = mock(Criteria.class);
		Criteria criteria5 = mock(Criteria.class);
		Criteria criteria6 = mock(Criteria.class);
		when(criteria6.setResultTransformer(Mockito.<org.hibernate.transform.ResultTransformer>any()))
			.thenReturn(criteria5);
		Criteria criteria7 = mock(Criteria.class);
		when(criteria7.add(Mockito.<org.hibernate.criterion.Criterion>any()))
			.thenReturn(criteria4);
		when(criteria7.createCriteria(Mockito.<String>any(), Mockito.<String>any()))
			.thenReturn(criteria3);
		when(criteria7.list())
			.thenReturn(new ArrayList());
		when(criteria7.setMaxResults(anyInt()))
			.thenReturn(criteria1);
		when(criteria7.setProjection(Mockito.<org.hibernate.criterion.Projection>any()))
			.thenReturn(criteria6);
		Criteria criteria8 = mock(Criteria.class);
		when(criteria8.createCriteria(Mockito.<String>any(), Mockito.<String>any(), Mockito.<org.hibernate.sql.JoinType>any()))
			.thenReturn(criteria7);
		Criteria criteria9 = mock(Criteria.class);
		when(criteria9.add(Mockito.<org.hibernate.criterion.Criterion>any()))
			.thenReturn(criteria8);
		Session session1 = mock(Session.class);
		when(session1.createCriteria(Mockito.<Class>any(), Mockito.<String>any()))
			.thenReturn(criteria9);
		Criteria criteria10 = mock(Criteria.class);
		Session session2 = mock(Session.class);
		when(session2.createCriteria(Mockito.<Class>any(), Mockito.<String>any()))
			.thenReturn(criteria10);
		SessionFactory sessionFactory = mock(SessionFactory.class);
		when(sessionFactory.getCurrentSession())
			.thenReturn(session2)
			.thenReturn(session1);
		thesaurusConceptDAO.setSessionFactory(sessionFactory);
		assertTrue((thesaurusConceptDAO.getChildrenConcepts("bar", 1, "hello")).isEmpty());
	}

	@Test
	public void getConceptsByThesaurusIdExcludeConceptIdIsEmptyAndOnlyValidatedConceptsIsFalse() throws org.hibernate.HibernateException, org.hibernate.UnknownProfileException, javax.naming.NamingException {

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
			.thenReturn(criteria2);
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
			 thesaurusConceptDAO.getConceptsByThesaurusId("", "1234", false, false);

		// assert
		assertEquals(1, result.size());
		// pojo Object
	}

	@Test
	public void getConceptsByThesaurusIdOnlyValidatedConceptsIsFalseAndSearchOrphansIsTrue() throws org.hibernate.HibernateException, org.hibernate.UnknownProfileException, javax.naming.NamingException {

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
			 thesaurusConceptDAO.getConceptsByThesaurusId("1234", "1234", true, false);

		// assert
		assertEquals(1, result.size());
		// pojo Object
	}

	@Test
	public void getConceptsByThesaurusIdOnlyValidatedConceptsIsNull() throws org.hibernate.HibernateException, org.hibernate.UnknownProfileException, javax.naming.NamingException {

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
			 thesaurusConceptDAO.getConceptsByThesaurusId("1234", "1234", false, null);

		// assert
		assertEquals(1, result.size());
		// pojo Object
	}

	@Test
	public void getConceptsByThesaurusIdOnlyValidatedConceptsIsTrue() throws org.hibernate.HibernateException, org.hibernate.UnknownProfileException, javax.naming.NamingException {

		// arrange
		ThesaurusConceptDAO thesaurusConceptDAO = new ThesaurusConceptDAO();
		Criteria criteria1 = mock(Criteria.class);
		List list = new ArrayList();
		list.add(new Object());
		Criteria criteria2 = mock(Criteria.class);
		Criteria criteria3 = mock(Criteria.class);
		Criteria criteria4 = mock(Criteria.class);
		Criteria criteria5 = mock(Criteria.class);
		when(criteria5.add(Mockito.<org.hibernate.criterion.Criterion>any()))
			.thenReturn(criteria4)
			.thenReturn(criteria3)
			.thenReturn(criteria2)
			.thenReturn(criteria1);
		when(criteria5.list())
			.thenReturn(list);
		Session session = mock(Session.class);
		when(session.createCriteria(Mockito.<Class>any(), Mockito.<String>any()))
			.thenReturn(criteria5);
		SessionFactory sessionFactory = mock(SessionFactory.class);
		when(sessionFactory.getCurrentSession())
			.thenReturn(session);
		thesaurusConceptDAO.setSessionFactory(sessionFactory);

		// act
		List<ThesaurusConcept> result =
			 thesaurusConceptDAO.getConceptsByThesaurusId("1234", "1234", false, true);

		// assert
		assertEquals(1, result.size());
		// pojo Object
	}

	@Test
	public void getPaginatedAvailableConceptsOfGroupLimitIsOneAndStartIndexIsZero() throws org.hibernate.HibernateException, org.hibernate.UnknownProfileException, javax.naming.NamingException {

		// arrange
		ThesaurusConceptDAO thesaurusConceptDAO = new ThesaurusConceptDAO();
		List list = new ArrayList();
		list.add(new Object());
		Criteria criteria1 = mock(Criteria.class);
		Criteria criteria2 = mock(Criteria.class);
		Criteria criteria3 = mock(Criteria.class);
		Criteria criteria4 = mock(Criteria.class);
		Criteria criteria5 = mock(Criteria.class);
		Criteria criteria6 = mock(Criteria.class);
		Criteria criteria7 = mock(Criteria.class);
		Criteria criteria8 = mock(Criteria.class);
		Criteria criteria9 = mock(Criteria.class);
		when(criteria9.setResultTransformer(Mockito.<org.hibernate.transform.ResultTransformer>any()))
			.thenReturn(criteria8);
		Criteria criteria10 = mock(Criteria.class);
		Criteria criteria11 = mock(Criteria.class);
		when(criteria11.add(Mockito.<org.hibernate.criterion.Criterion>any()))
			.thenReturn(criteria10)
			.thenReturn(criteria4)
			.thenReturn(criteria3)
			.thenReturn(criteria2)
			.thenReturn(criteria1);
		when(criteria11.addOrder(Mockito.<org.hibernate.criterion.Order>any()))
			.thenReturn(criteria5);
		when(criteria11.list())
			.thenReturn(list);
		when(criteria11.setFirstResult(anyInt()))
			.thenReturn(criteria6);
		when(criteria11.setMaxResults(anyInt()))
			.thenReturn(criteria7);
		when(criteria11.setProjection(Mockito.<org.hibernate.criterion.Projection>any()))
			.thenReturn(criteria9);
		Criteria criteria12 = mock(Criteria.class);
		when(criteria12.createCriteria(Mockito.<String>any(), Mockito.<String>any(), Mockito.<org.hibernate.sql.JoinType>any()))
			.thenReturn(criteria11);
		Criteria criteria13 = mock(Criteria.class);
		when(criteria13.add(Mockito.<org.hibernate.criterion.Criterion>any()))
			.thenReturn(criteria12);
		Session session = mock(Session.class);
		when(session.createCriteria(Mockito.<Class>any(), Mockito.<String>any()))
			.thenReturn(criteria13);
		SessionFactory sessionFactory = mock(SessionFactory.class);
		when(sessionFactory.getCurrentSession())
			.thenReturn(session);
		thesaurusConceptDAO.setSessionFactory(sessionFactory);

		// act
		List<ThesaurusConcept> result =
			 thesaurusConceptDAO.getPaginatedAvailableConceptsOfGroup(0, 1, "1234", "1234", false, "hello");

		// assert
		assertEquals(1, result.size());
		// pojo Object
	}

	@Test
	public void getPaginatedAvailableConceptsOfGroupLimitIsZeroAndStartIndexIsOne() throws org.hibernate.HibernateException, org.hibernate.UnknownProfileException, javax.naming.NamingException {

		// arrange
		ThesaurusConceptDAO thesaurusConceptDAO = new ThesaurusConceptDAO();
		List list = new ArrayList();
		list.add(new Object());
		Criteria criteria1 = mock(Criteria.class);
		Criteria criteria2 = mock(Criteria.class);
		Criteria criteria3 = mock(Criteria.class);
		Criteria criteria4 = mock(Criteria.class);
		Criteria criteria5 = mock(Criteria.class);
		Criteria criteria6 = mock(Criteria.class);
		Criteria criteria7 = mock(Criteria.class);
		Criteria criteria8 = mock(Criteria.class);
		Criteria criteria9 = mock(Criteria.class);
		when(criteria9.setResultTransformer(Mockito.<org.hibernate.transform.ResultTransformer>any()))
			.thenReturn(criteria8);
		Criteria criteria10 = mock(Criteria.class);
		Criteria criteria11 = mock(Criteria.class);
		when(criteria11.add(Mockito.<org.hibernate.criterion.Criterion>any()))
			.thenReturn(criteria10)
			.thenReturn(criteria4)
			.thenReturn(criteria3)
			.thenReturn(criteria2)
			.thenReturn(criteria1);
		when(criteria11.addOrder(Mockito.<org.hibernate.criterion.Order>any()))
			.thenReturn(criteria5);
		when(criteria11.list())
			.thenReturn(list);
		when(criteria11.setFirstResult(anyInt()))
			.thenReturn(criteria6);
		when(criteria11.setProjection(Mockito.<org.hibernate.criterion.Projection>any()))
			.thenReturn(criteria9);
		Criteria criteria12 = mock(Criteria.class);
		when(criteria12.createCriteria(Mockito.<String>any(), Mockito.<String>any(), Mockito.<org.hibernate.sql.JoinType>any()))
			.thenReturn(criteria11);
		Criteria criteria13 = mock(Criteria.class);
		when(criteria13.add(Mockito.<org.hibernate.criterion.Criterion>any()))
			.thenReturn(criteria12);
		Session session = mock(Session.class);
		when(session.createCriteria(Mockito.<Class>any(), Mockito.<String>any()))
			.thenReturn(criteria13);
		SessionFactory sessionFactory = mock(SessionFactory.class);
		when(sessionFactory.getCurrentSession())
			.thenReturn(session);
		thesaurusConceptDAO.setSessionFactory(sessionFactory);

		// act
		List<ThesaurusConcept> result =
			 thesaurusConceptDAO.getPaginatedAvailableConceptsOfGroup(1, 0, "1234", "1234", false, "hello");

		// assert
		assertEquals(1, result.size());
		// pojo Object
	}
}
