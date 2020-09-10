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
		alignment.setAlignmentType(new AlignmentType());
		alignment.setAndRelation(false);
		alignment.setAuthor("Ernest Hemingway");
		alignment.setCreated(new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31"));
		alignment.setExternalTargetThesaurus(new ExternalThesaurus());
		alignment.setIdentifier("foo");
		alignment.setInternalTargetThesaurus(new Thesaurus());
		alignment.setModified(new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31"));
		alignment.setSourceConcept(new ThesaurusConcept());
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
