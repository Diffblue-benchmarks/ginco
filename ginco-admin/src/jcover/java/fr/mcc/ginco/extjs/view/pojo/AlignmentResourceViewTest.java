package fr.mcc.ginco.extjs.view.pojo;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

import org.junit.jupiter.api.Test;

/**
 * Unit tests for fr.mcc.ginco.extjs.view.pojo.AlignmentResourceView
 *
 * @author Diffblue Cover
 */

class AlignmentResourceViewTest {

	@Test
	void factory() {
		AlignmentResourceView alignmentResourceView = new AlignmentResourceView();
		alignmentResourceView.setExternalTargetResource("foo");
		alignmentResourceView.setIdentifier(1);
		assertThat(alignmentResourceView.getExternalTargetResource(), is("foo"));
		assertThat(alignmentResourceView.getIdentifier(), is(1));
	}
}
