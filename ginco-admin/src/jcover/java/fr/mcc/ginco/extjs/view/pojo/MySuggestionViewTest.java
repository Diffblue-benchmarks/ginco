package fr.mcc.ginco.extjs.view.pojo;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

import org.junit.jupiter.api.Test;

/**
 * Unit tests for fr.mcc.ginco.extjs.view.pojo.MySuggestionView
 *
 * @author Diffblue Cover
 */

class MySuggestionViewTest {

	@Test
	void factory() {
		SuggestionView view = new SuggestionView();
		view.setConceptId("1234");
		view.setContent("hello");
		view.setCreated("1234");
		view.setCreator("+");
		view.setIdentifier(1);
		view.setRecipient("1234");
		view.setTermId("1234");
		view.setThesaurusId("1234");
		MySuggestionView mySuggestionView = new MySuggestionView(view);
		mySuggestionView.setObjectIdentifier("data");
		mySuggestionView.setObjectValue("value");
		mySuggestionView.setThesaurusTitle("Mr");
		mySuggestionView.setConceptId("1234");
		mySuggestionView.setContent("hello");
		mySuggestionView.setCreated("1234");
		mySuggestionView.setCreator("+");
		mySuggestionView.setIdentifier(1);
		mySuggestionView.setRecipient("1234");
		mySuggestionView.setTermId("1234");
		mySuggestionView.setThesaurusId("1234");
		assertThat(mySuggestionView.getObjectIdentifier(), is("data"));
		assertThat(mySuggestionView.getObjectValue(), is("value"));
		assertThat(mySuggestionView.getThesaurusTitle(), is("Mr"));
		assertThat(mySuggestionView.getConceptId(), is("1234"));
		assertThat(mySuggestionView.getContent(), is("hello"));
		assertThat(mySuggestionView.getCreated(), is("1234"));
		assertThat(mySuggestionView.getCreator(), is("+"));
		assertThat(mySuggestionView.getIdentifier(), is(1));
		assertThat(mySuggestionView.getRecipient(), is("1234"));
		assertThat(mySuggestionView.getTermId(), is("1234"));
		assertThat(mySuggestionView.getThesaurusId(), is("1234"));
	}
}
