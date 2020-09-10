package fr.mcc.ginco.data;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.empty;
import static org.hamcrest.Matchers.nullValue;
import static org.hamcrest.core.Is.is;

import fr.mcc.ginco.beans.Language;
import fr.mcc.ginco.beans.Note;
import fr.mcc.ginco.beans.ThesaurusConcept;
import fr.mcc.ginco.beans.ThesaurusTerm;
import fr.mcc.ginco.enums.TermStatusEnum;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

/**
 * Unit tests for fr.mcc.ginco.data.ReducedThesaurusTerm
 *
 * @author Diffblue Cover
 */

class ReducedThesaurusTermTest {

	@Test
	void factory() {
		ReducedThesaurusTerm reducedThesaurusTerm = new ReducedThesaurusTerm();
		reducedThesaurusTerm.setConceptId("1234");
		reducedThesaurusTerm.setIdentifier("data");
		reducedThesaurusTerm.setLanguageId("1234");
		reducedThesaurusTerm.setLexicalValue("value");
		reducedThesaurusTerm.setNotes(new ArrayList<Note>());
		reducedThesaurusTerm.setStatus(TermStatusEnum.CANDIDATE);
		assertThat(reducedThesaurusTerm.getConceptId(), is("1234"));
		assertThat(reducedThesaurusTerm.getIdentifier(), is("data"));
		assertThat(reducedThesaurusTerm.getLanguageId(), is("1234"));
		assertThat(reducedThesaurusTerm.getLexicalValue(), is("value"));
		assertThat(reducedThesaurusTerm.getNotes(), empty());
		assertThat(reducedThesaurusTerm.getStatus(), is(TermStatusEnum.CANDIDATE));
	}

	@Test
	void getReducedThesaurusTerm() {

		// arrange
		ThesaurusTerm term = new ThesaurusTerm();
		term.setConcept(new ThesaurusConcept());
		term.setLanguage(new Language());
		term.setLexicalValue("value");
		term.setStatus(1);

		// act
		ReducedThesaurusTerm result =
			 ReducedThesaurusTerm.getReducedThesaurusTerm(term);

		// assert
		assertThat(result.getConceptId(), is(nullValue()));
		assertThat(result.getIdentifier(), is(nullValue()));
		assertThat(result.getLanguageId(), is(nullValue()));
		assertThat(result.getLexicalValue(), is("value"));
		assertThat(result.getNotes(), is(nullValue()));
		assertThat(result.getStatus(), is(TermStatusEnum.VALIDATED));
	}
}
