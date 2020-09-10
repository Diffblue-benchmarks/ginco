package fr.mcc.ginco.extjs.view.pojo;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.empty;
import static org.hamcrest.core.Is.is;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

/**
 * Unit tests for fr.mcc.ginco.extjs.view.pojo.AlignmentView
 *
 * @author Diffblue Cover
 */

class AlignmentViewTest {

	@Test
	void factory() {
		AlignmentView alignmentView = new AlignmentView();
		alignmentView.setAlignmentType(1);
		alignmentView.setAndRelation(false);
		alignmentView.setCreated("foo");
		alignmentView.setExternalThesaurus(new ArrayList<ExternalThesaurusView>());
		alignmentView.setIdentifier("foo");
		alignmentView.setInternalThesaurusId("1234");
		alignmentView.setModified("foo");
		alignmentView.setTargetConcepts(new ArrayList<AlignmentConceptView>());
		alignmentView.setTargetResources(new ArrayList<AlignmentResourceView>());
		assertThat(alignmentView.getAlignmentType(), is(1));
		assertThat(alignmentView.getAndRelation(), is(false));
		assertThat(alignmentView.getCreated(), is("foo"));
		assertThat(alignmentView.getExternalThesaurus(), empty());
		assertThat(alignmentView.getIdentifier(), is("foo"));
		assertThat(alignmentView.getInternalThesaurusId(), is("1234"));
		assertThat(alignmentView.getModified(), is("foo"));
		assertThat(alignmentView.getTargetConcepts(), empty());
		assertThat(alignmentView.getTargetResources(), empty());
	}
}
