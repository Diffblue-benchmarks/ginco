package fr.mcc.ginco.beans;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.empty;
import static org.hamcrest.Matchers.nullValue;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsSame.sameInstance;

import java.text.SimpleDateFormat;
import java.util.HashSet;

import org.junit.jupiter.api.Test;

/**
 * Unit tests for fr.mcc.ginco.beans.ThesaurusConceptGroup
 *
 * @author Diffblue Cover
 */

class ThesaurusConceptGroupTest {

	@Test
	void factory() throws java.text.ParseException {
		ThesaurusConceptGroup thesaurusConceptGroup = new ThesaurusConceptGroup();
		ThesaurusConceptGroupType conceptGroupType = new ThesaurusConceptGroupType();
		conceptGroupType.setCode("DE");
		conceptGroupType.setLabel("label");
		conceptGroupType.setSkosLabel("label");
		thesaurusConceptGroup.setConceptGroupType(conceptGroupType);
		thesaurusConceptGroup.setConcepts(new HashSet<ThesaurusConcept>());
		thesaurusConceptGroup.setIdentifier("hello");
		thesaurusConceptGroup.setIsDynamic(false);
		thesaurusConceptGroup.setNotation("DE");
		ThesaurusConcept parentConcept = new ThesaurusConcept();
		parentConcept.setAssociativeRelationshipLeft(new HashSet<AssociativeRelationship>());
		parentConcept.setAssociativeRelationshipRight(new HashSet<AssociativeRelationship>());
		parentConcept.setConceptArrays(new HashSet<ThesaurusArray>());
		parentConcept.setCreated(new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31"));
		parentConcept.setIdentifier("hello");
		parentConcept.setModified(new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31"));
		parentConcept.setNotation("DE");
		parentConcept.setParentConcepts(new HashSet<ThesaurusConcept>());
		parentConcept.setRootConcepts(new HashSet<ThesaurusConcept>());
		parentConcept.setStatus(1);
		parentConcept.setThesaurus(new Thesaurus());
		parentConcept.setTopConcept(false);
		thesaurusConceptGroup.setParentConcept(parentConcept);
		Thesaurus thesaurus2 = new Thesaurus();
		thesaurus2.setArchived(false);
		thesaurus2.setContributor("foo");
		thesaurus2.setCoverage("foo");
		thesaurus2.setCreated(new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31"));
		thesaurus2.setCreator(new ThesaurusOrganization());
		thesaurus2.setDate(new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31"));
		thesaurus2.setDefaultTopConcept(false);
		thesaurus2.setDescription("some text");
		thesaurus2.setFormat(new HashSet<ThesaurusFormat>());
		thesaurus2.setIdentifier("foo");
		thesaurus2.setLang(new HashSet<Language>());
		thesaurus2.setPolyHierarchical(false);
		thesaurus2.setPublisher("foo");
		thesaurus2.setRelation("DE");
		thesaurus2.setRights("foo");
		thesaurus2.setSource("foo");
		thesaurus2.setSubject("foo");
		thesaurus2.setTitle("Mr");
		thesaurus2.setType(new ThesaurusType());
		thesaurus2.setVersions(new HashSet<ThesaurusVersionHistory>());
		thesaurusConceptGroup.setThesaurus(thesaurus2);
		assertThat(thesaurusConceptGroup.getConceptGroupType(), sameInstance(conceptGroupType));
		assertThat(thesaurusConceptGroup.getConcepts(), empty());
		assertThat(thesaurusConceptGroup.getIdentifier(), is("hello"));
		assertThat(thesaurusConceptGroup.getIsDynamic(), is(false));
		assertThat(thesaurusConceptGroup.getNotation(), is("DE"));
		assertThat(thesaurusConceptGroup.getParent(), is(nullValue()));
		assertThat(thesaurusConceptGroup.getParentConcept(), sameInstance(parentConcept));
		assertThat(thesaurusConceptGroup.getThesaurus(), sameInstance(thesaurus2));
	}
}
