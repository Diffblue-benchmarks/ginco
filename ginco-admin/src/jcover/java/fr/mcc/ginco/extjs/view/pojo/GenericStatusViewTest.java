package fr.mcc.ginco.extjs.view.pojo;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

import org.junit.jupiter.api.Test;

/**
 * Unit tests for fr.mcc.ginco.extjs.view.pojo.GenericStatusView
 *
 * @author Diffblue Cover
 */

class GenericStatusViewTest {

	@Test
	void factory() {
		GenericStatusView genericStatusView = new GenericStatusView();
		genericStatusView.setStatus(1);
		genericStatusView.setStatusLabel("label");
		assertThat(genericStatusView.getStatus(), is(1));
		assertThat(genericStatusView.getStatusLabel(), is("label"));
	}
}
