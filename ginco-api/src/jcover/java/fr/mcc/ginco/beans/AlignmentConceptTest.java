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
		alignment.setAlignmentType(new AlignmentType());
		alignment.setAndRelation(false);
		alignment.setAuthor("Ernest Hemingway");
		alignment.setCreated(new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31"));
		alignment.setExternalTargetThesaurus(new ExternalThesaurus());
		alignment.setIdentifier("data");
		alignment.setInternalTargetThesaurus(new Thesaurus());
		alignment.setModified(new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31"));
		alignment.setSourceConcept(new ThesaurusConcept());
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
		internalTargetConcept.setThesaurus(new Thesaurus());
		internalTargetConcept.setTopConcept(false);
		alignmentConcept.setInternalTargetConcept(internalTargetConcept);
		assertThat(alignmentConcept.getAlignment(), sameInstance(alignment));
		assertThat(alignmentConcept.getExternalTargetConcept(), is("hello"));
		assertThat(alignmentConcept.getIdentifier(), is(1));
		assertThat(alignmentConcept.getInternalTargetConcept(), sameInstance(internalTargetConcept));
	}

	@Test
	void testEquals() {
		assertThat(new AlignmentConcept().equals(new Object()), is(false));
		assertThat(new AlignmentConcept().equals(null), is(false));
	}
}
