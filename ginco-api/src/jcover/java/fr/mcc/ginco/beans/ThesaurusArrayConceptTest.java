package fr.mcc.ginco.beans;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsSame.sameInstance;

import java.text.SimpleDateFormat;
import java.util.HashSet;

import org.junit.jupiter.api.Test;

/**
 * Unit tests for fr.mcc.ginco.beans.ThesaurusArrayConcept
 *
 * @author Diffblue Cover
 */

class ThesaurusArrayConceptTest {

	@Test
	void factory() throws java.text.ParseException {
		ThesaurusArrayConcept thesaurusArrayConcept = new ThesaurusArrayConcept();
		thesaurusArrayConcept.setArrayOrder(1);
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
		thesaurusArrayConcept.setConcepts(concept);
		ThesaurusArrayConcept.Id identifier6 = new ThesaurusArrayConcept.Id();
		identifier6.setConceptId("1234");
		identifier6.setThesaurusArrayId("1234");
		thesaurusArrayConcept.setIdentifier(identifier6);
		assertThat(thesaurusArrayConcept.getArrayOrder(), is(1));
		assertThat(thesaurusArrayConcept.getConcepts(), sameInstance(concept));
		assertThat(thesaurusArrayConcept.getIdentifier(), sameInstance(identifier6));
	}
}
