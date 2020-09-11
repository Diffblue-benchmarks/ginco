package fr.mcc.ginco.data;

import static org.hamcrest.MatcherAssert.assertThat;
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
 * Unit tests for fr.mcc.ginco.data.ReducedThesaurusArray
 *
 * @author Diffblue Cover
 */

class ReducedThesaurusArrayTest {

	@Test
	void factory() throws java.text.ParseException {
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
		Note note = new Note();
		ThesaurusConcept concept2 = new ThesaurusConcept();
		concept2.setAssociativeRelationshipLeft(new HashSet<AssociativeRelationship>());
		concept2.setAssociativeRelationshipRight(new HashSet<AssociativeRelationship>());
		concept2.setConceptArrays(new HashSet<ThesaurusArray>());
		concept2.setCreated(new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31"));
		concept2.setIdentifier("data");
		concept2.setModified(new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31"));
		concept2.setNotation("DE");
		concept2.setParentConcepts(new HashSet<ThesaurusConcept>());
		concept2.setRootConcepts(new HashSet<ThesaurusConcept>());
		concept2.setStatus(1);
		concept2.setThesaurus(new Thesaurus());
		concept2.setTopConcept(false);
		note.setConcept(concept2);
		note.setCreated(new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31"));
		note.setIdentifier("data");
		Language lang2 = new Language();
		lang2.setId("1234");
		lang2.setPart1("foo");
		lang2.setPrincipalLanguage(false);
		lang2.setRefname("root");
		lang2.setTopLanguage(false);
		note.setLanguage(lang2);
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
		terms.add(reducedThesaurusTerm);
		reducedThesaurusArray.setTerms(terms);
		reducedThesaurusArray.setTitle("Mr");
		assertThat(reducedThesaurusArray.getIdentifier(), is("data"));
		assertThat(reducedThesaurusArray.getOrdered(), is(false));
		assertThat(reducedThesaurusArray.getTerms().size(), is(1));
		assertThat(reducedThesaurusArray.getTerms().get(0), sameInstance(reducedThesaurusTerm));
		assertThat(reducedThesaurusArray.getTitle(), is("Mr"));
	}
}
