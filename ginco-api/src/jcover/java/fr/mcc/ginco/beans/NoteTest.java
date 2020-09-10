package fr.mcc.ginco.beans;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsSame.sameInstance;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;

import org.junit.jupiter.api.Test;

/**
 * Unit tests for fr.mcc.ginco.beans.Note
 *
 * @author Diffblue Cover
 */

class NoteTest {

	@Test
	void factory() throws java.text.ParseException {
		Note note = new Note();
		ThesaurusConcept concept1 = new ThesaurusConcept();
		concept1.setAssociativeRelationshipLeft(new HashSet<AssociativeRelationship>());
		concept1.setAssociativeRelationshipRight(new HashSet<AssociativeRelationship>());
		concept1.setConceptArrays(new HashSet<ThesaurusArray>());
		concept1.setCreated(new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31"));
		concept1.setIdentifier("hello");
		concept1.setModified(new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31"));
		concept1.setNotation("DE");
		concept1.setParentConcepts(new HashSet<ThesaurusConcept>());
		concept1.setRootConcepts(new HashSet<ThesaurusConcept>());
		concept1.setStatus(1);
		concept1.setThesaurus(new Thesaurus());
		concept1.setTopConcept(false);
		note.setConcept(concept1);
		Date created2 = new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31");
		note.setCreated(created2);
		note.setIdentifier("foo");
		Language lang = new Language();
		lang.setId("1234");
		lang.setPart1("foo");
		lang.setPrincipalLanguage(false);
		lang.setRefname("foo");
		lang.setTopLanguage(false);
		note.setLanguage(lang);
		note.setLexicalValue("value");
		Date modified2 = new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31");
		note.setModified(modified2);
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
		termId.setIdentifier("foo");
		termId.setLanguage(new Language());
		termId.setLexicalValue("value");
		termId.setModified(new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31"));
		termId.setPrefered(false);
		termId.setRole(new ThesaurusTermRole());
		termId.setSource("foo");
		termId.setStatus(1);
		termId.setThesaurus(new Thesaurus());
		note.setTerm(termId);
		assertThat(note.getConcept(), sameInstance(concept1));
		assertThat(note.getCreated(), sameInstance(created2));
		assertThat(note.getIdentifier(), is("foo"));
		assertThat(note.getLanguage(), sameInstance(lang));
		assertThat(note.getLexicalValue(), is("value"));
		assertThat(note.getModified(), sameInstance(modified2));
		assertThat(note.getNoteType(), sameInstance(noteType));
		assertThat(note.getSource(), is("foo"));
		assertThat(note.getTerm(), sameInstance(termId));
	}
}
