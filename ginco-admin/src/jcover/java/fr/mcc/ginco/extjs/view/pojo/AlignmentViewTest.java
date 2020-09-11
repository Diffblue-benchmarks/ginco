package fr.mcc.ginco.extjs.view.pojo;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsSame.sameInstance;

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
		ArrayList<ExternalThesaurusView> externalThesaurus =
			 new ArrayList<ExternalThesaurusView>();
		ExternalThesaurusView externalThesaurusView = new ExternalThesaurusView();
		externalThesaurusView.setExternalId("1234");
		externalThesaurusView.setExternalThesaurusType(1);
		externalThesaurusView.setIdentifier(1);
		externalThesaurus.add(externalThesaurusView);
		alignmentView.setExternalThesaurus(externalThesaurus);
		alignmentView.setIdentifier("data");
		alignmentView.setInternalThesaurusId("1234");
		alignmentView.setModified("foo");
		ArrayList<AlignmentConceptView> targetConcepts =
			 new ArrayList<AlignmentConceptView>();
		AlignmentConceptView alignmentConceptView = new AlignmentConceptView();
		alignmentConceptView.setExternalTargetConcept("hello");
		alignmentConceptView.setIdentifier(1);
		alignmentConceptView.setInternalTargetConcept("hello");
		targetConcepts.add(alignmentConceptView);
		alignmentView.setTargetConcepts(targetConcepts);
		ArrayList<AlignmentResourceView> targetResources =
			 new ArrayList<AlignmentResourceView>();
		AlignmentResourceView alignmentResourceView = new AlignmentResourceView();
		alignmentResourceView.setExternalTargetResource("foo");
		alignmentResourceView.setIdentifier(1);
		targetResources.add(alignmentResourceView);
		alignmentView.setTargetResources(targetResources);
		assertThat(alignmentView.getAlignmentType(), is(1));
		assertThat(alignmentView.getAndRelation(), is(false));
		assertThat(alignmentView.getCreated(), is("foo"));
		assertThat(alignmentView.getExternalThesaurus().size(), is(1));
		assertThat(alignmentView.getExternalThesaurus().get(0), sameInstance(externalThesaurusView));
		assertThat(alignmentView.getIdentifier(), is("data"));
		assertThat(alignmentView.getInternalThesaurusId(), is("1234"));
		assertThat(alignmentView.getModified(), is("foo"));
		assertThat(alignmentView.getTargetConcepts().size(), is(1));
		assertThat(alignmentView.getTargetConcepts().get(0), sameInstance(alignmentConceptView));
		assertThat(alignmentView.getTargetResources().size(), is(1));
		assertThat(alignmentView.getTargetResources().get(0), sameInstance(alignmentResourceView));
	}
}
