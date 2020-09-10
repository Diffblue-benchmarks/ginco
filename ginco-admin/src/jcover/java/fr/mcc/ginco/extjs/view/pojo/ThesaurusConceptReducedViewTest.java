package fr.mcc.ginco.extjs.view.pojo;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

import org.junit.jupiter.api.Test;

/**
 * Unit tests for fr.mcc.ginco.extjs.view.pojo.ThesaurusConceptReducedView
 *
 * @author Diffblue Cover
 */

class ThesaurusConceptReducedViewTest {

	@Test
	void factory() {
		ThesaurusConceptReducedView thesaurusConceptReducedView =
			 new ThesaurusConceptReducedView();
		thesaurusConceptReducedView.setIdentifier("data");
		thesaurusConceptReducedView.setLabel("label");
		thesaurusConceptReducedView.setLang("hello");
		assertThat(thesaurusConceptReducedView.getIdentifier(), is("data"));
		assertThat(thesaurusConceptReducedView.getLabel(), is("label"));
		assertThat(thesaurusConceptReducedView.getLang(), is("hello"));
	}
}
