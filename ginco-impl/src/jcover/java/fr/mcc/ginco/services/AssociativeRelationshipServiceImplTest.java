package fr.mcc.ginco.services;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.when;

import fr.mcc.ginco.beans.AssociativeRelationship;
import fr.mcc.ginco.beans.AssociativeRelationshipRole;
import fr.mcc.ginco.beans.Language;
import fr.mcc.ginco.beans.Thesaurus;
import fr.mcc.ginco.beans.ThesaurusArray;
import fr.mcc.ginco.beans.ThesaurusConcept;
import fr.mcc.ginco.beans.ThesaurusFormat;
import fr.mcc.ginco.beans.ThesaurusOrganization;
import fr.mcc.ginco.beans.ThesaurusType;
import fr.mcc.ginco.beans.ThesaurusVersionHistory;
import fr.mcc.ginco.dao.IAssociativeRelationshipDAO;
import fr.mcc.ginco.enums.ConceptStatusEnum;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

/**
 * Unit tests for fr.mcc.ginco.services.AssociativeRelationshipServiceImpl
 *
 * @author Diffblue Cover
 */

public class AssociativeRelationshipServiceImplTest {

	@Mock(name = "associativeRelationshipDAO")
	private IAssociativeRelationshipDAO associativeRelationshipDAO;

	@InjectMocks
	private AssociativeRelationshipServiceImpl service;

	@Before public void initMocks() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void getAssociativeRelationshipById() {

		// arrange
		AssociativeRelationship associativeRelationship =
			 new AssociativeRelationship();
		ThesaurusConcept conceptLeft = new ThesaurusConcept();
		associativeRelationship.setConceptLeft(conceptLeft);
		ThesaurusConcept conceptRight = new ThesaurusConcept();
		associativeRelationship.setConceptRight(conceptRight);
		AssociativeRelationship.Id identifier11 = new AssociativeRelationship.Id();
		associativeRelationship.setIdentifier(identifier11);
		AssociativeRelationshipRole relationshipRole =
			 new AssociativeRelationshipRole();
		associativeRelationship.setRelationshipRole(relationshipRole);
		when(associativeRelationshipDAO.getAssociativeRelationship(Mockito.<String>any(), Mockito.<String>any()))
			.thenReturn(associativeRelationship);

		// act
		AssociativeRelationship result =
			 service.getAssociativeRelationshipById("1234", "1234");

		// assert
		assertSame(conceptLeft, result.getConceptLeft());
		assertSame(conceptRight, result.getConceptRight());
		assertSame(identifier11, result.getIdentifier());
		assertSame(relationshipRole, result.getRelationshipRole());
	}

	@Test
	public void getAssociatedConceptsIdStatusIsCandidate() throws java.text.ParseException {
		ArrayList<String> stringList = new ArrayList<String>();
		stringList.add("hello");
		when(associativeRelationshipDAO.getAssociatedConcepts(Mockito.<ThesaurusConcept>any(), Mockito.<ConceptStatusEnum>any()))
			.thenReturn(stringList);
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
		assertEquals(Arrays.asList("hello"), service.getAssociatedConceptsId(concept, ConceptStatusEnum.CANDIDATE));
	}

	@Test
	public void getAssociatedConceptsId() throws java.text.ParseException {
		ArrayList<String> stringList = new ArrayList<String>();
		stringList.add("hello");
		when(associativeRelationshipDAO.getAssociatedConcepts(Mockito.<ThesaurusConcept>any()))
			.thenReturn(stringList);
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
		assertEquals(Arrays.asList("hello"), service.getAssociatedConceptsId(concept));
	}

	@Test
	public void getAssociatedConceptsRelationships() {

		// arrange
		ArrayList<AssociativeRelationship> associativeRelationshipList =
			 new ArrayList<AssociativeRelationship>();
		AssociativeRelationship associativeRelationship =
			 new AssociativeRelationship();
		associativeRelationshipList.add(associativeRelationship);
		when(associativeRelationshipDAO.getAssociationsForConcept(Mockito.<ThesaurusConcept>any()))
			.thenReturn(associativeRelationshipList);

		// act
		List<AssociativeRelationship> result =
			 service.getAssociatedConceptsRelationships(new ThesaurusConcept());

		// assert
		assertEquals(1, result.size());
		assertSame(associativeRelationship, result.get(0));
	}
}
