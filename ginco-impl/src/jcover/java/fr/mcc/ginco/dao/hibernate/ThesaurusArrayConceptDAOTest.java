package fr.mcc.ginco.dao.hibernate;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import fr.mcc.ginco.beans.AssociativeRelationship;
import fr.mcc.ginco.beans.Language;
import fr.mcc.ginco.beans.Thesaurus;
import fr.mcc.ginco.beans.ThesaurusArray;
import fr.mcc.ginco.beans.ThesaurusArrayConcept;
import fr.mcc.ginco.beans.ThesaurusConcept;
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
 * Unit tests for fr.mcc.ginco.dao.hibernate.ThesaurusArrayConceptDAO
 *
 * @author Diffblue Cover
 */

public class ThesaurusArrayConceptDAOTest {

	@Test
	public void factory() {
		ThesaurusArrayConceptDAO thesaurusArrayConceptDAO =
			 new ThesaurusArrayConceptDAO();
		SessionFactory sessionFactory = mock(SessionFactory.class);
		thesaurusArrayConceptDAO.setSessionFactory(sessionFactory);
		assertSame(sessionFactory, thesaurusArrayConceptDAO.getSessionFactory());
	}

	@Test
	public void getAssociatedConceptsReturnsSmith() throws org.hibernate.HibernateException {
		ThesaurusArrayConceptDAO thesaurusArrayConceptDAO =
			 new ThesaurusArrayConceptDAO();
		ArrayList<String> arrayList = new ArrayList<String>();
		arrayList.add("Smith");
		Criteria criteria1 = mock(Criteria.class);
		when(criteria1.list())
			.thenReturn(arrayList);
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
		thesaurusArrayConceptDAO.setSessionFactory(sessionFactory);
		assertEquals(1, thesaurusArrayConceptDAO.getAssociatedConcepts("1234").size());
		assertEquals("Smith", thesaurusArrayConceptDAO.getAssociatedConcepts("1234").get(0));
	}

	@Test
	public void getThesaurusArrayConceptsByArray() throws org.hibernate.HibernateException, java.text.ParseException {

		// arrange
		ThesaurusArrayConceptDAO thesaurusArrayConceptDAO =
			 new ThesaurusArrayConceptDAO();
		ArrayList<String> arrayList = new ArrayList<String>();
		arrayList.add("Smith");
		Criteria criteria1 = mock(Criteria.class);
		when(criteria1.list())
			.thenReturn(arrayList);
		Criteria criteria2 = mock(Criteria.class);
		when(criteria2.add(Mockito.<org.hibernate.criterion.Criterion>any()))
			.thenReturn(criteria1);
		Session session = mock(Session.class);
		when(session.createCriteria(Mockito.<Class>any(), Mockito.<String>any()))
			.thenReturn(criteria2);
		SessionFactory sessionFactory = mock(SessionFactory.class);
		when(sessionFactory.getCurrentSession())
			.thenReturn(session);
		thesaurusArrayConceptDAO.setSessionFactory(sessionFactory);
		ThesaurusArray array = new ThesaurusArray();
		array.setConcepts(new HashSet<ThesaurusArrayConcept>());
		array.setIdentifier("data");
		array.setNotation("DE");
		array.setOrdered(false);
		ThesaurusArray parent1 = new ThesaurusArray();
		parent1.setConcepts(new HashSet<ThesaurusArrayConcept>());
		parent1.setIdentifier("data");
		parent1.setNotation("DE");
		parent1.setOrdered(false);
		ThesaurusArray parent2 = new ThesaurusArray();
		parent2.setConcepts(new HashSet<ThesaurusArrayConcept>());
		parent2.setIdentifier("data");
		parent2.setNotation("DE");
		parent2.setOrdered(false);
		parent2.setParent(new ThesaurusArray());
		parent2.setSuperOrdinateConcept(new ThesaurusConcept());
		parent2.setThesaurus(new Thesaurus());
		parent1.setParent(parent2);
		ThesaurusConcept superOrdinateConcept2 = new ThesaurusConcept();
		superOrdinateConcept2.setAssociativeRelationshipLeft(new HashSet<AssociativeRelationship>());
		superOrdinateConcept2.setAssociativeRelationshipRight(new HashSet<AssociativeRelationship>());
		superOrdinateConcept2.setConceptArrays(new HashSet<ThesaurusArray>());
		superOrdinateConcept2.setCreated(new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31"));
		superOrdinateConcept2.setIdentifier("data");
		superOrdinateConcept2.setModified(new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31"));
		superOrdinateConcept2.setNotation("DE");
		superOrdinateConcept2.setParentConcepts(new HashSet<ThesaurusConcept>());
		superOrdinateConcept2.setRootConcepts(new HashSet<ThesaurusConcept>());
		superOrdinateConcept2.setStatus(1);
		superOrdinateConcept2.setThesaurus(new Thesaurus());
		superOrdinateConcept2.setTopConcept(false);
		parent1.setSuperOrdinateConcept(superOrdinateConcept2);
		Thesaurus thesaurus3 = new Thesaurus();
		thesaurus3.setArchived(false);
		thesaurus3.setContributor("foo");
		thesaurus3.setCoverage("foo");
		thesaurus3.setCreated(new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31"));
		thesaurus3.setCreator(new ThesaurusOrganization());
		thesaurus3.setDate(new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31"));
		thesaurus3.setDefaultTopConcept(false);
		thesaurus3.setDescription("some text");
		thesaurus3.setFormat(new HashSet<ThesaurusFormat>());
		thesaurus3.setIdentifier("data");
		thesaurus3.setLang(new HashSet<Language>());
		thesaurus3.setPolyHierarchical(false);
		thesaurus3.setPublisher("foo");
		thesaurus3.setRelation("DE");
		thesaurus3.setRights("foo");
		thesaurus3.setSource("foo");
		thesaurus3.setSubject("foo");
		thesaurus3.setTitle("Mr");
		thesaurus3.setType(new ThesaurusType());
		thesaurus3.setVersions(new HashSet<ThesaurusVersionHistory>());
		parent1.setThesaurus(thesaurus3);
		array.setParent(parent1);
		ThesaurusConcept superOrdinateConcept3 = new ThesaurusConcept();
		superOrdinateConcept3.setAssociativeRelationshipLeft(new HashSet<AssociativeRelationship>());
		superOrdinateConcept3.setAssociativeRelationshipRight(new HashSet<AssociativeRelationship>());
		superOrdinateConcept3.setConceptArrays(new HashSet<ThesaurusArray>());
		superOrdinateConcept3.setCreated(new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31"));
		superOrdinateConcept3.setIdentifier("data");
		superOrdinateConcept3.setModified(new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31"));
		superOrdinateConcept3.setNotation("DE");
		superOrdinateConcept3.setParentConcepts(new HashSet<ThesaurusConcept>());
		superOrdinateConcept3.setRootConcepts(new HashSet<ThesaurusConcept>());
		superOrdinateConcept3.setStatus(1);
		Thesaurus thesaurus4 = new Thesaurus();
		thesaurus4.setArchived(false);
		thesaurus4.setContributor("foo");
		thesaurus4.setCoverage("foo");
		thesaurus4.setCreated(new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31"));
		thesaurus4.setCreator(new ThesaurusOrganization());
		thesaurus4.setDate(new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31"));
		thesaurus4.setDefaultTopConcept(false);
		thesaurus4.setDescription("some text");
		thesaurus4.setFormat(new HashSet<ThesaurusFormat>());
		thesaurus4.setIdentifier("data");
		thesaurus4.setLang(new HashSet<Language>());
		thesaurus4.setPolyHierarchical(false);
		thesaurus4.setPublisher("foo");
		thesaurus4.setRelation("DE");
		thesaurus4.setRights("foo");
		thesaurus4.setSource("foo");
		thesaurus4.setSubject("foo");
		thesaurus4.setTitle("Mr");
		thesaurus4.setType(new ThesaurusType());
		thesaurus4.setVersions(new HashSet<ThesaurusVersionHistory>());
		superOrdinateConcept3.setThesaurus(thesaurus4);
		superOrdinateConcept3.setTopConcept(false);
		array.setSuperOrdinateConcept(superOrdinateConcept3);
		Thesaurus thesaurus5 = new Thesaurus();
		thesaurus5.setArchived(false);
		thesaurus5.setContributor("foo");
		thesaurus5.setCoverage("foo");
		thesaurus5.setCreated(new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31"));
		ThesaurusOrganization creator3 = new ThesaurusOrganization();
		creator3.setEmail("info@diffblue.com");
		creator3.setHomepage("foo");
		creator3.setIdentifier(1);
		creator3.setName("Acme");
		thesaurus5.setCreator(creator3);
		thesaurus5.setDate(new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31"));
		thesaurus5.setDefaultTopConcept(false);
		thesaurus5.setDescription("some text");
		thesaurus5.setFormat(new HashSet<ThesaurusFormat>());
		thesaurus5.setIdentifier("data");
		thesaurus5.setLang(new HashSet<Language>());
		thesaurus5.setPolyHierarchical(false);
		thesaurus5.setPublisher("foo");
		thesaurus5.setRelation("DE");
		thesaurus5.setRights("foo");
		thesaurus5.setSource("foo");
		thesaurus5.setSubject("foo");
		thesaurus5.setTitle("Mr");
		ThesaurusType type3 = new ThesaurusType();
		type3.setIdentifier(1);
		type3.setLabel("label");
		thesaurus5.setType(type3);
		thesaurus5.setVersions(new HashSet<ThesaurusVersionHistory>());
		array.setThesaurus(thesaurus5);

		// act
		List<ThesaurusArrayConcept> result =
			 thesaurusArrayConceptDAO.getThesaurusArrayConceptsByArray(array);

		// assert
		assertEquals(1, result.size());
		// pojo String (String) result.get(0)
	}

	@Test
	public void getArraysOfConcept() throws org.hibernate.HibernateException, java.text.ParseException {

		// arrange
		ThesaurusArrayConceptDAO thesaurusArrayConceptDAO =
			 new ThesaurusArrayConceptDAO();
		ArrayList<String> arrayList = new ArrayList<String>();
		arrayList.add("Smith");
		Criteria criteria1 = mock(Criteria.class);
		Criteria criteria2 = mock(Criteria.class);
		when(criteria2.add(Mockito.<org.hibernate.criterion.Criterion>any()))
			.thenReturn(criteria1);
		when(criteria2.list())
			.thenReturn(arrayList);
		Session session = mock(Session.class);
		when(session.createCriteria(Mockito.<Class>any(), Mockito.<String>any()))
			.thenReturn(criteria2);
		SessionFactory sessionFactory = mock(SessionFactory.class);
		when(sessionFactory.getCurrentSession())
			.thenReturn(session);
		thesaurusArrayConceptDAO.setSessionFactory(sessionFactory);
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
		List<ThesaurusArrayConcept> result =
			 thesaurusArrayConceptDAO.getArraysOfConcept(concept);

		// assert
		assertEquals(1, result.size());
		// pojo String (String) result.get(0)
	}
}
