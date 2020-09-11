package fr.mcc.ginco.extjs.view.pojo;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsSame.sameInstance;

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
		SplitNonPreferredTermView splitNonPreferredTermView =
			 new SplitNonPreferredTermView();
		splitNonPreferredTermView.setCreated("foo");
		splitNonPreferredTermView.setIdentifier("data");
		splitNonPreferredTermView.setLanguage("foo");
		splitNonPreferredTermView.setLexicalValue("value");
		splitNonPreferredTermView.setModified("foo");
		ArrayList<ThesaurusTermView> preferredTerms =
			 new ArrayList<ThesaurusTermView>();
		ThesaurusTermView thesaurusTermView = new ThesaurusTermView();
		thesaurusTermView.setConceptId("1234");
		thesaurusTermView.setCreated("foo");
		thesaurusTermView.setHidden(false);
		thesaurusTermView.setIdentifier("data");
		thesaurusTermView.setLanguage("foo");
		thesaurusTermView.setLexicalValue("value");
		thesaurusTermView.setModified("foo");
		thesaurusTermView.setPrefered(false);
		thesaurusTermView.setRole("admin");
		thesaurusTermView.setSource("foo");
		thesaurusTermView.setStatus(1);
		thesaurusTermView.setThesaurusId("1234");
		thesaurusTermView.setTopistopterm(false);
		preferredTerms.add(thesaurusTermView);
		splitNonPreferredTermView.setPreferredTerms(preferredTerms);
		splitNonPreferredTermView.setSource("foo");
		splitNonPreferredTermView.setStatus(1);
		splitNonPreferredTermView.setThesaurusId("1234");
		assertThat(splitNonPreferredTermView.getCreated(), is("foo"));
		assertThat(splitNonPreferredTermView.getIdentifier(), is("data"));
		assertThat(splitNonPreferredTermView.getLanguage(), is("foo"));
		assertThat(splitNonPreferredTermView.getLexicalValue(), is("value"));
		assertThat(splitNonPreferredTermView.getModified(), is("foo"));
		assertThat(splitNonPreferredTermView.getPreferredTerms().size(), is(1));
		assertThat(splitNonPreferredTermView.getPreferredTerms().get(0), sameInstance(thesaurusTermView));
		assertThat(splitNonPreferredTermView.getSource(), is("foo"));
		assertThat(splitNonPreferredTermView.getStatus(), is(1));
		assertThat(splitNonPreferredTermView.getThesaurusId(), is("1234"));
	}
}