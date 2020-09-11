package fr.mcc.ginco.beans;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.empty;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsSame.sameInstance;
import static org.mockito.Mockito.mock;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;

import org.junit.jupiter.api.Test;

/**
 * Unit tests for fr.mcc.ginco.beans.Alignment
 *
 * @author Diffblue Cover
 */

class AlignmentTest {

	@Test
	void factory() throws java.text.ParseException {
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
		Date created1 = new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31");
		alignment.setCreated(created1);
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
		ThesaurusOrganization creator = new ThesaurusOrganization();
		creator.setEmail("info@diffblue.com");
		creator.setHomepage("foo");
		creator.setIdentifier(1);
		creator.setName("Acme");
		internalTargetThesaurus.setCreator(creator);
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
		ThesaurusType type = new ThesaurusType();
		type.setIdentifier(1);
		type.setLabel("label");
		internalTargetThesaurus.setType(type);
		internalTargetThesaurus.setVersions(new HashSet<ThesaurusVersionHistory>());
		alignment.setInternalTargetThesaurus(internalTargetThesaurus);
		Date modified = new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31");
		alignment.setModified(modified);
		ThesaurusConcept sourceConcept = mock(ThesaurusConcept.class);
		alignment.setSourceConcept(sourceConcept);
		alignment.setTargetConcepts(new HashSet<AlignmentConcept>());
		alignment.setTargetResources(new HashSet<AlignmentResource>());
		assertThat(alignment.getAlignmentType(), sameInstance(alignmentType));
		assertThat(alignment.getAuthor(), is("Ernest Hemingway"));
		assertThat(alignment.getCreated(), sameInstance(created1));
		assertThat(alignment.getExternalTargetThesaurus(), sameInstance(externalTargetThesaurus));
		assertThat(alignment.getIdentifier(), is("data"));
		assertThat(alignment.getInternalTargetThesaurus(), sameInstance(internalTargetThesaurus));
		assertThat(alignment.getModified(), sameInstance(modified));
		assertThat(alignment.getSourceConcept(), sameInstance(sourceConcept));
		assertThat(alignment.getTargetConcepts(), empty());
		assertThat(alignment.getTargetResources(), empty());
		assertThat(alignment.isAndRelation(), is(false));
	}

	@Test
	void equalsReturnsFalse() {
		assertThat(new Alignment().equals(new Object()), is(false));
	}
}
