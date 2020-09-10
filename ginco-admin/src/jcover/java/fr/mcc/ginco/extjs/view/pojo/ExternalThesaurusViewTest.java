package fr.mcc.ginco.extjs.view.pojo;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

import org.junit.jupiter.api.Test;

/**
 * Unit tests for fr.mcc.ginco.extjs.view.pojo.ExternalThesaurusView
 *
 * @author Diffblue Cover
 */

class ExternalThesaurusViewTest {

	@Test
	void factory() {
		ExternalThesaurusView externalThesaurusView = new ExternalThesaurusView();
		externalThesaurusView.setExternalId("1234");
		externalThesaurusView.setExternalThesaurusType(1);
		externalThesaurusView.setIdentifier(1);
		assertThat(externalThesaurusView.getExternalId(), is("1234"));
		assertThat(externalThesaurusView.getExternalThesaurusType(), is(1));
		assertThat(externalThesaurusView.getIdentifier(), is(1));
	}
}
