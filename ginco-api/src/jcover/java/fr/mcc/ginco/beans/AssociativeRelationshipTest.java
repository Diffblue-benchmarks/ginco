package fr.mcc.ginco.beans;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsSame.sameInstance;

import java.text.SimpleDateFormat;
import java.util.HashSet;

import org.junit.jupiter.api.Test;

/**
 * Unit tests for fr.mcc.ginco.beans.AssociativeRelationship
 *
 * @author Diffblue Cover
 */

class AssociativeRelationshipTest {

	@Test
	void factory() throws java.text.ParseException {
		AssociativeRelationship associativeRelationship =
			 new AssociativeRelationship();
		ThesaurusConcept conceptLeft = new ThesaurusConcept();
		conceptLeft.setAssociativeRelationshipLeft(new HashSet<AssociativeRelationship>());
		conceptLeft.setAssociativeRelationshipRight(new HashSet<AssociativeRelationship>());
		conceptLeft.setConceptArrays(new HashSet<ThesaurusArray>());
		conceptLeft.setCreated(new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31"));
		conceptLeft.setIdentifier("data");
		conceptLeft.setModified(new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31"));
		conceptLeft.setNotation("DE");
		conceptLeft.setParentConcepts(new HashSet<ThesaurusConcept>());
		conceptLeft.setRootConcepts(new HashSet<ThesaurusConcept>());
		conceptLeft.setStatus(1);
		Thesaurus thesaurus1 = new Thesaurus();
		thesaurus1.setArchived(false);
		thesaurus1.setContributor("foo");
		thesaurus1.setCoverage("foo");
		thesaurus1.setCreated(new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31"));
		ThesaurusOrganization creator1 = new ThesaurusOrganization();
		creator1.setEmail("info@diffblue.com");
		creator1.setHomepage("foo");
		creator1.setIdentifier(1);
		creator1.setName("Acme");
		thesaurus1.setCreator(creator1);
		thesaurus1.setDate(new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31"));
		thesaurus1.setDefaultTopConcept(false);
		thesaurus1.setDescription("some text");
		thesaurus1.setFormat(new HashSet<ThesaurusFormat>());
		thesaurus1.setIdentifier("data");
		thesaurus1.setLang(new HashSet<Language>());
		thesaurus1.setPolyHierarchical(false);
		thesaurus1.setPublisher("foo");
		thesaurus1.setRelation("DE");
		thesaurus1.setRights("foo");
		thesaurus1.setSource("foo");
		thesaurus1.setSubject("foo");
		thesaurus1.setTitle("Mr");
		ThesaurusType type1 = new ThesaurusType();
		type1.setIdentifier(1);
		type1.setLabel("label");
		thesaurus1.setType(type1);
		thesaurus1.setVersions(new HashSet<ThesaurusVersionHistory>());
		conceptLeft.setThesaurus(thesaurus1);
		conceptLeft.setTopConcept(false);
		associativeRelationship.setConceptLeft(conceptLeft);
		ThesaurusConcept conceptRight = new ThesaurusConcept();
		conceptRight.setAssociativeRelationshipLeft(new HashSet<AssociativeRelationship>());
		conceptRight.setAssociativeRelationshipRight(new HashSet<AssociativeRelationship>());
		conceptRight.setConceptArrays(new HashSet<ThesaurusArray>());
		conceptRight.setCreated(new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31"));
		conceptRight.setIdentifier("data");
		conceptRight.setModified(new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31"));
		conceptRight.setNotation("DE");
		conceptRight.setParentConcepts(new HashSet<ThesaurusConcept>());
		conceptRight.setRootConcepts(new HashSet<ThesaurusConcept>());
		conceptRight.setStatus(1);
		Thesaurus thesaurus2 = new Thesaurus();
		thesaurus2.setArchived(false);
		thesaurus2.setContributor("foo");
		thesaurus2.setCoverage("foo");
		thesaurus2.setCreated(new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31"));
		ThesaurusOrganization creator2 = new ThesaurusOrganization();
		creator2.setEmail("info@diffblue.com");
		creator2.setHomepage("foo");
		creator2.setIdentifier(1);
		creator2.setName("Acme");
		thesaurus2.setCreator(creator2);
		thesaurus2.setDate(new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31"));
		thesaurus2.setDefaultTopConcept(false);
		thesaurus2.setDescription("some text");
		thesaurus2.setFormat(new HashSet<ThesaurusFormat>());
		thesaurus2.setIdentifier("data");
		thesaurus2.setLang(new HashSet<Language>());
		thesaurus2.setPolyHierarchical(false);
		thesaurus2.setPublisher("foo");
		thesaurus2.setRelation("DE");
		thesaurus2.setRights("foo");
		thesaurus2.setSource("foo");
		thesaurus2.setSubject("foo");
		thesaurus2.setTitle("Mr");
		ThesaurusType type2 = new ThesaurusType();
		type2.setIdentifier(1);
		type2.setLabel("label");
		thesaurus2.setType(type2);
		thesaurus2.setVersions(new HashSet<ThesaurusVersionHistory>());
		conceptRight.setThesaurus(thesaurus2);
		conceptRight.setTopConcept(false);
		associativeRelationship.setConceptRight(conceptRight);
		AssociativeRelationship.Id identifier11 = new AssociativeRelationship.Id();
		identifier11.setConcept1("hello");
		identifier11.setConcept2("hello");
		associativeRelationship.setIdentifier(identifier11);
		AssociativeRelationshipRole relationshipRole =
			 new AssociativeRelationshipRole();
		relationshipRole.setCode("DE");
		relationshipRole.setDefaultRole(false);
		relationshipRole.setLabel("label");
		relationshipRole.setSkosLabel("label");
		associativeRelationship.setRelationshipRole(relationshipRole);
		assertThat(associativeRelationship.getConceptLeft(), sameInstance(conceptLeft));
		assertThat(associativeRelationship.getConceptRight(), sameInstance(conceptRight));
		assertThat(associativeRelationship.getIdentifier(), sameInstance(identifier11));
		assertThat(associativeRelationship.getRelationshipRole(), sameInstance(relationshipRole));
	}
}
