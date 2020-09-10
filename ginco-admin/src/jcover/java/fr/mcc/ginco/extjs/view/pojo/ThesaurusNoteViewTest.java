package fr.mcc.ginco.extjs.view.pojo;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

import org.junit.jupiter.api.Test;

/**
 * Unit tests for fr.mcc.ginco.extjs.view.pojo.ThesaurusNoteView
 *
 * @author Diffblue Cover
 */

class ThesaurusNoteViewTest {

	@Test
	void factory() {
		ThesaurusNoteView thesaurusNoteView = new ThesaurusNoteView();
		thesaurusNoteView.setConceptId("1234");
		thesaurusNoteView.setCreated("foo");
		thesaurusNoteView.setIdentifier("data");
		thesaurusNoteView.setLanguage("foo");
		thesaurusNoteView.setLexicalValue("value");
		thesaurusNoteView.setModified("foo");
		thesaurusNoteView.setSource("foo");
		thesaurusNoteView.setTermId("1234");
		thesaurusNoteView.setThesaurusId("1234");
		thesaurusNoteView.setType("BASIC");
		assertThat(thesaurusNoteView.getConceptId(), is("1234"));
		assertThat(thesaurusNoteView.getCreated(), is("foo"));
		assertThat(thesaurusNoteView.getIdentifier(), is("data"));
		assertThat(thesaurusNoteView.getLanguage(), is("foo"));
		assertThat(thesaurusNoteView.getLexicalValue(), is("value"));
		assertThat(thesaurusNoteView.getModified(), is("foo"));
		assertThat(thesaurusNoteView.getSource(), is("foo"));
		assertThat(thesaurusNoteView.getTermId(), is("1234"));
		assertThat(thesaurusNoteView.getThesaurusId(), is("1234"));
		assertThat(thesaurusNoteView.getType(), is("BASIC"));
	}
}
