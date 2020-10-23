package fr.mcc.ginco.dao.hibernate;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import fr.mcc.ginco.beans.AssociativeRelationship;
import fr.mcc.ginco.beans.CustomConceptAttribute;
import fr.mcc.ginco.beans.Language;
import fr.mcc.ginco.beans.Thesaurus;
import fr.mcc.ginco.beans.ThesaurusArray;
import fr.mcc.ginco.beans.ThesaurusConcept;
import fr.mcc.ginco.beans.ThesaurusFormat;
import fr.mcc.ginco.beans.ThesaurusOrganization;
import fr.mcc.ginco.beans.ThesaurusType;
import fr.mcc.ginco.beans.ThesaurusVersionHistory;
import fr.mcc.ginco.beans.generic.GenericCustomAttributeType;

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
 * Unit tests for fr.mcc.ginco.dao.hibernate.CustomConceptAttributeDAO
 *
 * @author Diffblue Cover
 */

public class CustomConceptAttributeDAOTest {

	@Test
	public void factory() {
		CustomConceptAttributeDAO customConceptAttributeDAO =
			 new CustomConceptAttributeDAO();
		SessionFactory sessionFactory = mock(SessionFactory.class);
		customConceptAttributeDAO.setSessionFactory(sessionFactory);
		assertSame(sessionFactory, customConceptAttributeDAO.getSessionFactory());
	}

	@Test
	public void getAttributesByEntity() throws org.hibernate.HibernateException, java.text.ParseException {

		// arrange
		CustomConceptAttributeDAO customConceptAttributeDAO =
			 new CustomConceptAttributeDAO();
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
		customConceptAttributeDAO.setSessionFactory(sessionFactory);
		ThesaurusConcept entity = new ThesaurusConcept();
		entity.setAssociativeRelationshipLeft(new HashSet<AssociativeRelationship>());
		entity.setAssociativeRelationshipRight(new HashSet<AssociativeRelationship>());
		entity.setConceptArrays(new HashSet<ThesaurusArray>());
		entity.setCreated(new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31"));
		entity.setIdentifier("data");
		entity.setModified(new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31"));
		entity.setNotation("DE");
		entity.setParentConcepts(new HashSet<ThesaurusConcept>());
		entity.setRootConcepts(new HashSet<ThesaurusConcept>());
		entity.setStatus(1);
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
		entity.setThesaurus(thesaurus);
		entity.setTopConcept(false);

		// act
		List<CustomConceptAttribute> result =
			 customConceptAttributeDAO.getAttributesByEntity(entity);

		// assert
		assertEquals(1, result.size());
		// pojo String (String) result.get(0)
	}

	@Test
	public void getAttributeByTypeReturnsNull() throws org.hibernate.HibernateException {
		CustomConceptAttributeDAO customConceptAttributeDAO =
			 new CustomConceptAttributeDAO();
		Criteria criteria1 = mock(Criteria.class);
		when(criteria1.list())
			.thenReturn(new ArrayList<String>());
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
		customConceptAttributeDAO.setSessionFactory(sessionFactory);
		assertNull(customConceptAttributeDAO.getAttributeByType(new ThesaurusConcept(), new GenericCustomAttributeType()));
	}
}
