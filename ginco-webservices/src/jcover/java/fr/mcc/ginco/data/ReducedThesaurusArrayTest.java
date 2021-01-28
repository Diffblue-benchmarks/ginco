package fr.mcc.ginco.data;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsSame.sameInstance;

import fr.mcc.ginco.beans.Note;
import fr.mcc.ginco.enums.TermStatusEnum;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

/**
 * Unit tests for fr.mcc.ginco.data.ReducedThesaurusArray
 *
 * @author Diffblue Cover
 */

class ReducedThesaurusArrayTest {

	@Test
	void factory() {
		ReducedThesaurusArray reducedThesaurusArray = new ReducedThesaurusArray();
		reducedThesaurusArray.setIdentifier("data");
		reducedThesaurusArray.setOrdered(false);
		ArrayList<ReducedThesaurusTerm> terms =
			 new ArrayList<ReducedThesaurusTerm>();
		ReducedThesaurusTerm reducedThesaurusTerm = new ReducedThesaurusTerm();
		reducedThesaurusTerm.setConceptId("1234");
		reducedThesaurusTerm.setIdentifier("data");
		reducedThesaurusTerm.setLanguageId("1234");
		reducedThesaurusTerm.setLexicalValue("value");
		ArrayList<Note> notes = new ArrayList<Note>();
		notes.add(new Note());
		reducedThesaurusTerm.setNotes(notes);
		reducedThesaurusTerm.setStatus(TermStatusEnum.CANDIDATE);
		terms.add(reducedThesaurusTerm);
		reducedThesaurusArray.setTerms(terms);
		reducedThesaurusArray.setTitle("Mr");
		assertThat(reducedThesaurusArray.getIdentifier(), is("data"));
		assertThat(reducedThesaurusArray.getOrdered(), is(false));
		assertThat(reducedThesaurusArray.getTerms(), hasSize(1));
		assertThat(reducedThesaurusArray.getTerms().get(0), sameInstance(reducedThesaurusTerm));
		assertThat(reducedThesaurusArray.getTitle(), is("Mr"));
	}
}
