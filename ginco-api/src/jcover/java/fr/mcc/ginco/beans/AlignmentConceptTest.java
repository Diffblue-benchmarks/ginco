package fr.mcc.ginco.beans;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsSame.sameInstance;

import java.text.SimpleDateFormat;
import java.util.HashSet;

import org.junit.jupiter.api.Test;

/**
 * Unit tests for fr.mcc.ginco.beans.AlignmentConcept
 *
 * @author Diffblue Cover
 */

class AlignmentConceptTest {

	@Test
	void factory() throws java.text.ParseException {
		AlignmentConcept alignmentConcept = new AlignmentConcept();
		Alignment alignment = new Alignment();
		AlignmentType alignmentType = new AlignmentType();
		alignmentType.setDefaultType(false);
		alignmentType.setIdentifier(1);
		alignmentType.setIsoCode("DE");
		alignmentType.setLabel("label");
		alignmentType.setMultiConcept(false);
		alignmentType.setResource(false);
		alignment.setAlignmentType(alignmentType);
		alignment.setAndRelation(false);
		alignment.setAuthor("Ernest Hemingway");
		alignment.setCreated(new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31"));
		ExternalThesaurus externalTargetThesaurus = new ExternalThesaurus();
		externalTargetThesaurus.setExternalId("1234");
		ExternalThesaurusType externalThesaurusType = new ExternalThesaurusType();
		externalThesaurusType.setIdentifier(1);
		externalThesaurusType.setLabel("label");
		externalTargetThesaurus.setExternalThesaurusType(externalThesaurusType);
		externalTargetThesaurus.setIdentifier(1);
		alignment.setExternalTargetThesaurus(externalTargetThesaurus);
		alignment.setIdentifier("data");
		Thesaurus internalTargetThesaurus = new Thesaurus();
		internalTargetThesaurus.setArchived(false);
		internalTargetThesaurus.setContributor("foo");
		internalTargetThesaurus.setCoverage("foo");
		internalTargetThesaurus.setCreated(new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31"));
		ThesaurusOrganization creator1 = new ThesaurusOrganization();
		creator1.setEmail("info@diffblue.com");
		creator1.setHomepage("foo");
		creator1.setIdentifier(1);
		creator1.setName("Acme");
		internalTargetThesaurus.setCreator(creator1);
		internalTargetThesaurus.setDate(new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31"));
		internalTargetThesaurus.setDefaultTopConcept(false);
		internalTargetThesaurus.setDescription("some text");
		internalTargetThesaurus.setFormat(new HashSet<ThesaurusFormat>());
		internalTargetThesaurus.setIdentifier("data");
		internalTargetThesaurus.setLang(new HashSet<Language>());
		internalTargetThesaurus.setPolyHierarchical(false);
		internalTargetThesaurus.setPublisher("foo");
		internalTargetThesaurus.setRelation("DE");
		internalTargetThesaurus.setRights("foo");
		internalTargetThesaurus.setSource("foo");
		internalTargetThesaurus.setSubject("foo");
		internalTargetThesaurus.setTitle("Mr");
		ThesaurusType type1 = new ThesaurusType();
		type1.setIdentifier(1);
		type1.setLabel("label");
		internalTargetThesaurus.setType(type1);
		internalTargetThesaurus.setVersions(new HashSet<ThesaurusVersionHistory>());
		alignment.setInternalTargetThesaurus(internalTargetThesaurus);
		alignment.setModified(new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31"));
		ThesaurusConcept sourceConcept = new ThesaurusConcept();
		sourceConcept.setAssociativeRelationshipLeft(new HashSet<AssociativeRelationship>());
		sourceConcept.setAssociativeRelationshipRight(new HashSet<AssociativeRelationship>());
		sourceConcept.setConceptArrays(new HashSet<ThesaurusArray>());
		sourceConcept.setCreated(new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31"));
		sourceConcept.setIdentifier("data");
		sourceConcept.setModified(new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31"));
		sourceConcept.setNotation("DE");
		sourceConcept.setParentConcepts(new HashSet<ThesaurusConcept>());
		sourceConcept.setRootConcepts(new HashSet<ThesaurusConcept>());
		sourceConcept.setStatus(1);
		Thesaurus thesaurus1 = new Thesaurus();
		thesaurus1.setArchived(false);
		thesaurus1.setContributor("foo");
		thesaurus1.setCoverage("foo");
		thesaurus1.setCreated(new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31"));
		thesaurus1.setDate(new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31"));
		thesaurus1.setDefaultTopConcept(false);
		thesaurus1.setDescription("some text");
		thesaurus1.setIdentifier("data");
		thesaurus1.setPolyHierarchical(false);
		thesaurus1.setPublisher("foo");
		thesaurus1.setRelation("DE");
		thesaurus1.setRights("foo");
		thesaurus1.setSource("foo");
		thesaurus1.setSubject("foo");
		thesaurus1.setTitle("Mr");
		sourceConcept.setThesaurus(thesaurus1);
		sourceConcept.setTopConcept(false);
		alignment.setSourceConcept(sourceConcept);
		alignment.setTargetConcepts(new HashSet<AlignmentConcept>());
		alignment.setTargetResources(new HashSet<AlignmentResource>());
		alignmentConcept.setAlignment(alignment);
		alignmentConcept.setExternalTargetConcept("hello");
		alignmentConcept.setIdentifier(1);
		ThesaurusConcept internalTargetConcept = new ThesaurusConcept();
		internalTargetConcept.setAssociativeRelationshipLeft(new HashSet<AssociativeRelationship>());
		internalTargetConcept.setAssociativeRelationshipRight(new HashSet<AssociativeRelationship>());
		internalTargetConcept.setConceptArrays(new HashSet<ThesaurusArray>());
		internalTargetConcept.setCreated(new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31"));
		internalTargetConcept.setIdentifier("data");
		internalTargetConcept.setModified(new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31"));
		internalTargetConcept.setNotation("DE");
		internalTargetConcept.setParentConcepts(new HashSet<ThesaurusConcept>());
		internalTargetConcept.setRootConcepts(new HashSet<ThesaurusConcept>());
		internalTargetConcept.setStatus(1);
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
		internalTargetConcept.setThesaurus(thesaurus2);
		internalTargetConcept.setTopConcept(false);
		alignmentConcept.setInternalTargetConcept(internalTargetConcept);
		assertThat(alignmentConcept.getAlignment(), sameInstance(alignment));
		assertThat(alignmentConcept.getExternalTargetConcept(), is("hello"));
		assertThat(alignmentConcept.getIdentifier(), is(1));
		assertThat(alignmentConcept.getInternalTargetConcept(), sameInstance(internalTargetConcept));
	}

	@Test
	void equalsReturnsFalse() {
		assertThat(new AlignmentConcept().equals(new Object()), is(false));
	}
}
