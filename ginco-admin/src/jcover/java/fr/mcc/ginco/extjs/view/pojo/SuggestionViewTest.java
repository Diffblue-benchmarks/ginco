package fr.mcc.ginco.extjs.view.pojo;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

import org.junit.jupiter.api.Test;

/**
 * Unit tests for fr.mcc.ginco.extjs.view.pojo.SuggestionView
 *
 * @author Diffblue Cover
 */

class SuggestionViewTest {

	@Test
	void factory() {
		SuggestionView suggestionView = new SuggestionView();
		suggestionView.setConceptId("1234");
		suggestionView.setContent("hello");
		suggestionView.setCreated("1234");
		suggestionView.setCreator("+");
		suggestionView.setIdentifier(1);
		suggestionView.setRecipient("1234");
		suggestionView.setTermId("1234");
		suggestionView.setThesaurusId("1234");
		assertThat(suggestionView.getConceptId(), is("1234"));
		assertThat(suggestionView.getContent(), is("hello"));
		assertThat(suggestionView.getCreated(), is("1234"));
		assertThat(suggestionView.getCreator(), is("+"));
		assertThat(suggestionView.getIdentifier(), is(1));
		assertThat(suggestionView.getRecipient(), is("1234"));
		assertThat(suggestionView.getTermId(), is("1234"));
		assertThat(suggestionView.getThesaurusId(), is("1234"));
	}
}
