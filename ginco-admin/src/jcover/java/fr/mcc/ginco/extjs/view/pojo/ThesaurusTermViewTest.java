package fr.mcc.ginco.extjs.view.pojo;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.empty;
import static org.hamcrest.core.Is.is;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

/**
 * Unit tests for fr.mcc.ginco.extjs.view.pojo.ThesaurusTermView
 *
 * @author Diffblue Cover
 */

class ThesaurusTermViewTest {

	@Test
	void factory() {
		ThesaurusTermView thesaurusTermView = new ThesaurusTermView();
		thesaurusTermView.setConceptId("1234");
		thesaurusTermView.setConceptsPath(new ArrayList<String>());
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
		assertThat(thesaurusTermView.getConceptId(), is("1234"));
		assertThat(thesaurusTermView.getConceptsPath(), empty());
		assertThat(thesaurusTermView.getCreated(), is("foo"));
		assertThat(thesaurusTermView.getHidden(), is(false));
		assertThat(thesaurusTermView.getIdentifier(), is("data"));
		assertThat(thesaurusTermView.getLanguage(), is("foo"));
		assertThat(thesaurusTermView.getLexicalValue(), is("value"));
		assertThat(thesaurusTermView.getModified(), is("foo"));
		assertThat(thesaurusTermView.getPrefered(), is(false));
		assertThat(thesaurusTermView.getRole(), is("admin"));
		assertThat(thesaurusTermView.getSource(), is("foo"));
		assertThat(thesaurusTermView.getStatus(), is(1));
		assertThat(thesaurusTermView.getThesaurusId(), is("1234"));
		assertThat(thesaurusTermView.getTopistopterm(), is(false));
	}
}
