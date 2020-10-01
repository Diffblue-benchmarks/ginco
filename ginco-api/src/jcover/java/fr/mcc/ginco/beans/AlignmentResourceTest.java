package fr.mcc.ginco.beans;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsSame.sameInstance;

import java.text.SimpleDateFormat;
import java.util.HashSet;

import org.junit.jupiter.api.Test;

/**
 * Unit tests for fr.mcc.ginco.beans.AlignmentResource
 *
 * @author Diffblue Cover
 */

class AlignmentResourceTest {

	@Test
	void factory() throws java.text.ParseException {
		AlignmentResource alignmentResource = new AlignmentResource();
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
		Thesaurus thesaurus = new Thesaurus();
		thesaurus.setArchived(false);
		thesaurus.setContributor("foo");
		thesaurus.setCoverage("foo");
		thesaurus.setCreated(new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31"));
		thesaurus.setCreator(new ThesaurusOrganization());
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
		thesaurus.setType(new ThesaurusType());
		thesaurus.setVersions(new HashSet<ThesaurusVersionHistory>());
		sourceConcept.setThesaurus(thesaurus);
		sourceConcept.setTopConcept(false);
		alignment.setSourceConcept(sourceConcept);
		alignment.setTargetConcepts(new HashSet<AlignmentConcept>());
		alignment.setTargetResources(new HashSet<AlignmentResource>());
		alignmentResource.setAlignment(alignment);
		alignmentResource.setExternalTargetResource("foo");
		alignmentResource.setIdentifier(1);
		assertThat(alignmentResource.getAlignment(), sameInstance(alignment));
		assertThat(alignmentResource.getExternalTargetResource(), is("foo"));
		assertThat(alignmentResource.getIdentifier(), is(1));
	}

	@Test
	void testEquals() {
		assertThat(new AlignmentResource().equals(new Object()), is(false));
		assertThat(new AlignmentResource().equals(null), is(false));
	}
}
