package fr.mcc.ginco.extjs.view.pojo;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.empty;
import static org.hamcrest.core.Is.is;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

/**
 * Unit tests for fr.mcc.ginco.extjs.view.pojo.SplitNonPreferredTermView
 *
 * @author Diffblue Cover
 */

class SplitNonPreferredTermViewTest {

	@Test
	void factory() {
		SplitNonPreferredTermView splitNonPreferredTermView = new SplitNonPreferredTermView();
		splitNonPreferredTermView.setCreated("foo");
		splitNonPreferredTermView.setIdentifier("foo");
		splitNonPreferredTermView.setLanguage("foo");
		splitNonPreferredTermView.setLexicalValue("value");
		splitNonPreferredTermView.setModified("foo");
		splitNonPreferredTermView.setPreferredTerms(new ArrayList<ThesaurusTermView>());
		splitNonPreferredTermView.setSource("foo");
		splitNonPreferredTermView.setStatus(1);
		splitNonPreferredTermView.setThesaurusId("1234");
		assertThat(splitNonPreferredTermView.getCreated(), is("foo"));
		assertThat(splitNonPreferredTermView.getIdentifier(), is("foo"));
		assertThat(splitNonPreferredTermView.getLanguage(), is("foo"));
		assertThat(splitNonPreferredTermView.getLexicalValue(), is("value"));
		assertThat(splitNonPreferredTermView.getModified(), is("foo"));
		assertThat(splitNonPreferredTermView.getPreferredTerms(), empty());
		assertThat(splitNonPreferredTermView.getSource(), is("foo"));
		assertThat(splitNonPreferredTermView.getStatus(), is(1));
		assertThat(splitNonPreferredTermView.getThesaurusId(), is("1234"));
	}
}
