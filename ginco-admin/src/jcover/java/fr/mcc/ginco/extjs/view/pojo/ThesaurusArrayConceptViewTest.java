package fr.mcc.ginco.extjs.view.pojo;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

import org.junit.jupiter.api.Test;

/**
 * Unit tests for fr.mcc.ginco.extjs.view.pojo.ThesaurusArrayConceptView
 *
 * @author Diffblue Cover
 */

class ThesaurusArrayConceptViewTest {

	@Test
	void factory() {
		ThesaurusArrayConceptView thesaurusArrayConceptView = new ThesaurusArrayConceptView();
		thesaurusArrayConceptView.setIdentifier("hello");
		thesaurusArrayConceptView.setLabel("label");
		thesaurusArrayConceptView.setOrder(1);
		assertThat(thesaurusArrayConceptView.getIdentifier(), is("hello"));
		assertThat(thesaurusArrayConceptView.getLabel(), is("label"));
		assertThat(thesaurusArrayConceptView.getOrder(), is(1));
	}
}
