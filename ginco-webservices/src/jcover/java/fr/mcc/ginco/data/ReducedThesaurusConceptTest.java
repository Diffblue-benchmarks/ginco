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
import fr.mcc.ginco.enums.ConceptStatusEnum;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashSet;

import org.junit.jupiter.api.Test;

/**
 * Unit tests for fr.mcc.ginco.data.ReducedThesaurusConcept
 *
 * @author Diffblue Cover
 */

class ReducedThesaurusConceptTest {

	@Test
	void factory() throws java.text.ParseException {
		ReducedThesaurusConcept reducedThesaurusConcept1 =
			 new ReducedThesaurusConcept();
		ArrayList<ReducedThesaurusConcept> associates1 =
			 new ArrayList<ReducedThesaurusConcept>();
		ReducedThesaurusConcept reducedThesaurusConcept2 =
			 new ReducedThesaurusConcept();
		ArrayList<ReducedThesaurusConcept> associates2 =
			 new ArrayList<ReducedThesaurusConcept>();
		associates2.add(new ReducedThesaurusConcept());
		reducedThesaurusConcept2.setAssociates(associates2);
		reducedThesaurusConcept2.setIdentifier("data");
		ArrayList<Note> notes1 = new ArrayList<Note>();
		notes1.add(new Note());
		reducedThesaurusConcept2.setNotes(notes1);
		ArrayList<ReducedThesaurusConcept> parents1 =
			 new ArrayList<ReducedThesaurusConcept>();
		parents1.add(new ReducedThesaurusConcept());
		reducedThesaurusConcept2.setParents(parents1);
		reducedThesaurusConcept2.setStatus(ConceptStatusEnum.CANDIDATE);
		associates1.add(reducedThesaurusConcept2);
		reducedThesaurusConcept1.setAssociates(associates1);
		reducedThesaurusConcept1.setIdentifier("data");
		ArrayList<Note> notes2 = new ArrayList<Note>();
		Note note2 = new Note();
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
		note2.setConcept(concept1);
		note2.setCreated(new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31"));
		note2.setIdentifier("data");
		Language lang = new Language();
		lang.setId("1234");
		lang.setPart1("foo");
		lang.setPrincipalLanguage(false);
		lang.setRefname("root");
		lang.setTopLanguage(false);
		note2.setLanguage(lang);
		note2.setLexicalValue("value");
		note2.setModified(new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31"));
		NoteType noteType = new NoteType();
		noteType.setCode("DE");
		noteType.setIsConcept(false);
		noteType.setIsTerm(false);
		noteType.setLabel("label");
		note2.setNoteType(noteType);
		note2.setSource("foo");
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
		note2.setTerm(termId);
		notes2.add(note2);
		reducedThesaurusConcept1.setNotes(notes2);
		ArrayList<ReducedThesaurusConcept> parents2 =
			 new ArrayList<ReducedThesaurusConcept>();
		ReducedThesaurusConcept reducedThesaurusConcept5 =
			 new ReducedThesaurusConcept();
		ArrayList<ReducedThesaurusConcept> associates3 =
			 new ArrayList<ReducedThesaurusConcept>();
		associates3.add(new ReducedThesaurusConcept());
		reducedThesaurusConcept5.setAssociates(associates3);
		reducedThesaurusConcept5.setIdentifier("data");
		ArrayList<Note> notes3 = new ArrayList<Note>();
		notes3.add(new Note());
		reducedThesaurusConcept5.setNotes(notes3);
		ArrayList<ReducedThesaurusConcept> parents3 =
			 new ArrayList<ReducedThesaurusConcept>();
		parents3.add(new ReducedThesaurusConcept());
		reducedThesaurusConcept5.setParents(parents3);
		reducedThesaurusConcept5.setStatus(ConceptStatusEnum.CANDIDATE);
		parents2.add(reducedThesaurusConcept5);
		reducedThesaurusConcept1.setParents(parents2);
		reducedThesaurusConcept1.setStatus(ConceptStatusEnum.CANDIDATE);
		assertThat(reducedThesaurusConcept1.getAssociates().size(), is(1));
		assertThat(reducedThesaurusConcept1.getAssociates().get(0), sameInstance(reducedThesaurusConcept2));
		assertThat(reducedThesaurusConcept1.getIdentifier(), is("data"));
		assertThat(reducedThesaurusConcept1.getNotes().size(), is(1));
		assertThat(reducedThesaurusConcept1.getNotes().get(0), sameInstance(note2));
		assertThat(reducedThesaurusConcept1.getParents().size(), is(1));
		assertThat(reducedThesaurusConcept1.getParents().get(0), sameInstance(reducedThesaurusConcept5));
		assertThat(reducedThesaurusConcept1.getStatus(), is(ConceptStatusEnum.CANDIDATE));
	}

	@Test
	void getReducedThesaurusConcept() {

		// arrange
		ThesaurusConcept concept = new ThesaurusConcept();
		concept.setIdentifier("data");
		concept.setStatus(1);

		// act
		ReducedThesaurusConcept result =
			 ReducedThesaurusConcept.getReducedThesaurusConcept(concept);

		// assert
		assertThat(result.getAssociates(), is(nullValue()));
		assertThat(result.getIdentifier(), is("data"));
		assertThat(result.getNotes(), is(nullValue()));
		assertThat(result.getParents(), is(nullValue()));
		assertThat(result.getStatus(), is(ConceptStatusEnum.VALIDATED));
	}
}
