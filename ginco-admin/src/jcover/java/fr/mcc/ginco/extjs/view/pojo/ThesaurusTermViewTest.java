package fr.mcc.ginco.extjs.view.pojo;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
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
		ArrayList<String> conceptsPath = new ArrayList<String>();
		conceptsPath.add("/bin/bash");
		thesaurusTermView.setConceptsPath(conceptsPath);
		thesaurusTermView.setCreated("someone");
		thesaurusTermView.setHidden(false);
		thesaurusTermView.setIdentifier("data");
		thesaurusTermView.setLanguage("foo");
		thesaurusTermView.setLexicalValue("value");
		thesaurusTermView.setModified("someone");
		thesaurusTermView.setPrefered(false);
		thesaurusTermView.setRole("admin");
		thesaurusTermView.setSource("foo");
		thesaurusTermView.setStatus(1);
		thesaurusTermView.setThesaurusId("1234");
		thesaurusTermView.setTopistopterm(false);
		assertThat(thesaurusTermView.getConceptId(), is("1234"));
		assertThat(thesaurusTermView.getConceptsPath(), hasSize(1));
		assertThat(thesaurusTermView.getConceptsPath().get(0), is("/bin/bash"));
		assertThat(thesaurusTermView.getCreated(), is("someone"));
		assertThat(thesaurusTermView.getHidden(), is(false));
		assertThat(thesaurusTermView.getIdentifier(), is("data"));
		assertThat(thesaurusTermView.getLanguage(), is("foo"));
		assertThat(thesaurusTermView.getLexicalValue(), is("value"));
		assertThat(thesaurusTermView.getModified(), is("someone"));
		assertThat(thesaurusTermView.getPrefered(), is(false));
		assertThat(thesaurusTermView.getRole(), is("admin"));
		assertThat(thesaurusTermView.getSource(), is("foo"));
		assertThat(thesaurusTermView.getStatus(), is(1));
		assertThat(thesaurusTermView.getThesaurusId(), is("1234"));
		assertThat(thesaurusTermView.getTopistopterm(), is(false));
	}
}
