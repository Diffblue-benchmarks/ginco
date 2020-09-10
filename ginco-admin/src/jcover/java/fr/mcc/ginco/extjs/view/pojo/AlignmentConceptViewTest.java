package fr.mcc.ginco.extjs.view.pojo;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

import org.junit.jupiter.api.Test;

/**
 * Unit tests for fr.mcc.ginco.extjs.view.pojo.AlignmentConceptView
 *
 * @author Diffblue Cover
 */

class AlignmentConceptViewTest {

	@Test
	void factory() {
		AlignmentConceptView alignmentConceptView = new AlignmentConceptView();
		alignmentConceptView.setExternalTargetConcept("hello");
		alignmentConceptView.setIdentifier(1);
		alignmentConceptView.setInternalTargetConcept("hello");
		assertThat(alignmentConceptView.getExternalTargetConcept(), is("hello"));
		assertThat(alignmentConceptView.getIdentifier(), is(1));
		assertThat(alignmentConceptView.getInternalTargetConcept(), is("hello"));
	}
}
