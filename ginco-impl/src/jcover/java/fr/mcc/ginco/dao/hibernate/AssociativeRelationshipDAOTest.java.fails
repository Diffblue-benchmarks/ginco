package fr.mcc.ginco.dao.hibernate;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
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
import fr.mcc.ginco.enums.ConceptStatusEnum;

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
 * Unit tests for fr.mcc.ginco.dao.hibernate.AssociativeRelationshipDAO
 *
 * @author Diffblue Cover
 */

public class AssociativeRelationshipDAOTest {

	@Test
	public void factory() {
		AssociativeRelationshipDAO associativeRelationshipDAO =
			 new AssociativeRelationshipDAO();
		SessionFactory sessionFactory = mock(SessionFactory.class);
		associativeRelationshipDAO.setSessionFactory(sessionFactory);
		assertSame(sessionFactory, associativeRelationshipDAO.getSessionFactory());
	}

	@Test
	public void getAssociatedConceptsStatusIsCandidate() throws org.hibernate.HibernateException {
		AssociativeRelationshipDAO associativeRelationshipDAO =
			 new AssociativeRelationshipDAO();
		List list = new ArrayList<String>();
		list.add("foo");
		Criteria criteria1 = mock(Criteria.class);
		Criteria criteria2 = mock(Criteria.class);
		when(criteria2.add(Mockito.<org.hibernate.criterion.Criterion>any()))
			.thenReturn(criteria1);
		when(criteria2.list())
			.thenReturn(list);
		Criteria criteria3 = mock(Criteria.class);
		when(criteria3.setProjection(Mockito.<org.hibernate.criterion.Projection>any()))
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
		associativeRelationshipDAO.setSessionFactory(sessionFactory);
		assertEquals(1, associativeRelationshipDAO.getAssociatedConcepts(new ThesaurusConcept(), ConceptStatusEnum.CANDIDATE).size());
		assertEquals("foo", associativeRelationshipDAO.getAssociatedConcepts(new ThesaurusConcept(), ConceptStatusEnum.CANDIDATE).get(0));
	}

	@Test
	public void getAssociatedConcepts() throws org.hibernate.HibernateException {
		AssociativeRelationshipDAO associativeRelationshipDAO =
			 new AssociativeRelationshipDAO();
		List list = new ArrayList<String>();
		list.add("foo");
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
		associativeRelationshipDAO.setSessionFactory(sessionFactory);
		assertEquals(1, associativeRelationshipDAO.getAssociatedConcepts(new ThesaurusConcept()).size());
		assertEquals("foo", associativeRelationshipDAO.getAssociatedConcepts(new ThesaurusConcept()).get(0));
	}

	@Test
	public void getAssociationsForConcept() throws org.hibernate.HibernateException, java.text.ParseException {

		// arrange
		AssociativeRelationshipDAO associativeRelationshipDAO =
			 new AssociativeRelationshipDAO();
		List list = new ArrayList<String>();
		list.add("foo");
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
		associativeRelationshipDAO.setSessionFactory(sessionFactory);
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
		List<AssociativeRelationship> result =
			 associativeRelationshipDAO.getAssociationsForConcept(concept);

		// assert
		assertEquals(1, result.size());
		// pojo String (String) result.get(0)
	}

	@Test
	public void getAssociativeRelationshipId1IsArReturnsNull() throws org.hibernate.HibernateException {
		AssociativeRelationshipDAO associativeRelationshipDAO =
			 new AssociativeRelationshipDAO();
		Criteria criteria1 = mock(Criteria.class);
		when(criteria1.list())
			.thenReturn(new ArrayList<String>());
		Criteria criteria2 = mock(Criteria.class);
		when(criteria2.add(Mockito.<org.hibernate.criterion.Criterion>any()))
			.thenReturn(criteria1);
		Session session = mock(Session.class);
		when(session.createCriteria(Mockito.<Class>any(), Mockito.<String>any()))
			.thenReturn(criteria2);
		SessionFactory sessionFactory = mock(SessionFactory.class);
		when(sessionFactory.getCurrentSession())
			.thenReturn(session);
		associativeRelationshipDAO.setSessionFactory(sessionFactory);
		assertNull(associativeRelationshipDAO.getAssociativeRelationship("ar", "1234"));
	}
}
