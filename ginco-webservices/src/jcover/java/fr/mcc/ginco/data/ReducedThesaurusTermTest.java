package fr.mcc.ginco.data;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.nullValue;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsSame.sameInstance;

import fr.mcc.ginco.beans.AssociativeRelationship;
import fr.mcc.ginco.beans.Language;
import fr.mcc.ginco.beans.Note;
import fr.mcc.ginco.beans.NoteType;
import fr.mcc.ginco.beans.Thesaurus;
import fr.mcc.ginco.beans.ThesaurusArray;
import fr.mcc.ginco.beans.ThesaurusConcept;
import fr.mcc.ginco.beans.ThesaurusTerm;
import fr.mcc.ginco.beans.ThesaurusTermRole;
import fr.mcc.ginco.enums.TermStatusEnum;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashSet;

import org.junit.jupiter.api.Test;

/**
 * Unit tests for fr.mcc.ginco.data.ReducedThesaurusTerm
 *
 * @author Diffblue Cover
 */

class ReducedThesaurusTermTest {

	@Test
	void factory() throws java.text.ParseException {
		ReducedThesaurusTerm reducedThesaurusTerm = new ReducedThesaurusTerm();
		reducedThesaurusTerm.setConceptId("1234");
		reducedThesaurusTerm.setIdentifier("data");
		reducedThesaurusTerm.setLanguageId("1234");
		reducedThesaurusTerm.setLexicalValue("value");
		ArrayList<Note> notes = new ArrayList<Note>();
		Note note = new Note();
		ThesaurusConcept concept1 = new ThesaurusConcept();
		concept1.setAssociativeRelationshipLeft(new HashSet<AssociativeRelationship>());
		concept1.setAssociativeRelationshipRight(new HashSet<AssociativeRelationship>());
		concept1.setConceptArrays(new HashSet<ThesaurusArray>());
		concept1.setCreated(new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31"));
		concept1.setIdentifier("data");
		concept1.setModified(new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31"));
		concept1.setNotation("DE");
		concept1.setParentConcepts(new HashSet<ThesaurusConcept>());
		concept1.setRootConcepts(new HashSet<ThesaurusConcept>());
		concept1.setStatus(1);
		concept1.setThesaurus(new Thesaurus());
		concept1.setTopConcept(false);
		note.setConcept(concept1);
		note.setCreated(new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31"));
		note.setIdentifier("data");
		Language lang = new Language();
		lang.setId("1234");
		lang.setPart1("foo");
		lang.setPrincipalLanguage(false);
		lang.setRefname("root");
		lang.setTopLanguage(false);
		note.setLanguage(lang);
		note.setLexicalValue("value");
		note.setModified(new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31"));
		NoteType noteType = new NoteType();
		noteType.setCode("DE");
		noteType.setIsConcept(false);
		noteType.setIsTerm(false);
		noteType.setLabel("label");
		note.setNoteType(noteType);
		note.setSource("foo");
		ThesaurusTerm termId = new ThesaurusTerm();
		termId.setConcept(new ThesaurusConcept());
		termId.setCreated(new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31"));
		termId.setHidden(false);
		termId.setIdentifier("data");
		termId.setLanguage(new Language());
		termId.setLexicalValue("value");
		termId.setModified(new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31"));
		termId.setPrefered(false);
		termId.setRole(new ThesaurusTermRole());
		termId.setSource("foo");
		termId.setStatus(1);
		termId.setThesaurus(new Thesaurus());
		note.setTerm(termId);
		notes.add(note);
		reducedThesaurusTerm.setNotes(notes);
		reducedThesaurusTerm.setStatus(TermStatusEnum.CANDIDATE);
		assertThat(reducedThesaurusTerm.getConceptId(), is("1234"));
		assertThat(reducedThesaurusTerm.getIdentifier(), is("data"));
		assertThat(reducedThesaurusTerm.getLanguageId(), is("1234"));
		assertThat(reducedThesaurusTerm.getLexicalValue(), is("value"));
		assertThat(reducedThesaurusTerm.getNotes().size(), is(1));
		assertThat(reducedThesaurusTerm.getNotes().get(0), sameInstance(note));
		assertThat(reducedThesaurusTerm.getStatus(), is(TermStatusEnum.CANDIDATE));
	}

	@Test
	void getReducedThesaurusTerm() {

		// arrange
		ThesaurusTerm term = new ThesaurusTerm();
		ThesaurusConcept concept = new ThesaurusConcept();
		concept.setIdentifier("data");
		term.setConcept(concept);
		Language language = new Language();
		language.setId("1234");
		term.setLanguage(language);
		term.setLexicalValue("value");
		term.setStatus(1);

		// act
		ReducedThesaurusTerm result =
			 ReducedThesaurusTerm.getReducedThesaurusTerm(term);

		// assert
		assertThat(result.getConceptId(), is("data"));
		assertThat(result.getIdentifier(), is(nullValue()));
		assertThat(result.getLanguageId(), is("1234"));
		assertThat(result.getLexicalValue(), is("value"));
		assertThat(result.getNotes(), is(nullValue()));
		assertThat(result.getStatus(), is(TermStatusEnum.VALIDATED));
	}
}
