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
import fr.mcc.ginco.beans.ThesaurusFormat;
import fr.mcc.ginco.beans.ThesaurusOrganization;
import fr.mcc.ginco.beans.ThesaurusTerm;
import fr.mcc.ginco.beans.ThesaurusTermRole;
import fr.mcc.ginco.beans.ThesaurusType;
import fr.mcc.ginco.beans.ThesaurusVersionHistory;
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
		Thesaurus thesaurus1 = new Thesaurus();
		thesaurus1.setArchived(false);
		thesaurus1.setContributor("foo");
		thesaurus1.setCoverage("foo");
		thesaurus1.setCreated(new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31"));
		thesaurus1.setCreator(new ThesaurusOrganization());
		thesaurus1.setDate(new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31"));
		thesaurus1.setDefaultTopConcept(false);
		thesaurus1.setDescription("some text");
		thesaurus1.setFormat(new HashSet<ThesaurusFormat>());
		thesaurus1.setIdentifier("data");
		thesaurus1.setLang(new HashSet<Language>());
		thesaurus1.setPolyHierarchical(false);
		thesaurus1.setPublisher("foo");
		thesaurus1.setRelation("DE");
		thesaurus1.setRights("foo");
		thesaurus1.setSource("foo");
		thesaurus1.setSubject("foo");
		thesaurus1.setTitle("Mr");
		thesaurus1.setType(new ThesaurusType());
		thesaurus1.setVersions(new HashSet<ThesaurusVersionHistory>());
		concept1.setThesaurus(thesaurus1);
		concept1.setTopConcept(false);
		note.setConcept(concept1);
		note.setCreated(new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31"));
		note.setIdentifier("data");
		Language lang2 = new Language();
		lang2.setId("1234");
		lang2.setPart1("foo");
		lang2.setPrincipalLanguage(false);
		lang2.setRefname("foo");
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
		termId.setConcept(concept2);
		termId.setCreated(new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31"));
		termId.setHidden(false);
		termId.setIdentifier("data");
		Language language = new Language();
		language.setId("1234");
		language.setPart1("foo");
		language.setPrincipalLanguage(false);
		language.setRefname("foo");
		language.setTopLanguage(false);
		termId.setLanguage(language);
		termId.setLexicalValue("value");
		termId.setModified(new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31"));
		termId.setPrefered(false);
		ThesaurusTermRole role = new ThesaurusTermRole();
		role.setCode("DE");
		role.setDefaultRole(false);
		role.setLabel("label");
		termId.setRole(role);
		termId.setSource("foo");
		termId.setStatus(1);
		Thesaurus thesaurus3 = new Thesaurus();
		thesaurus3.setArchived(false);
		thesaurus3.setContributor("foo");
		thesaurus3.setCoverage("foo");
		thesaurus3.setCreated(new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31"));
		thesaurus3.setCreator(new ThesaurusOrganization());
		thesaurus3.setDate(new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31"));
		thesaurus3.setDefaultTopConcept(false);
		thesaurus3.setDescription("some text");
		thesaurus3.setFormat(new HashSet<ThesaurusFormat>());
		thesaurus3.setIdentifier("data");
		thesaurus3.setLang(new HashSet<Language>());
		thesaurus3.setPolyHierarchical(false);
		thesaurus3.setPublisher("foo");
		thesaurus3.setRelation("DE");
		thesaurus3.setRights("foo");
		thesaurus3.setSource("foo");
		thesaurus3.setSubject("foo");
		thesaurus3.setTitle("Mr");
		thesaurus3.setType(new ThesaurusType());
		thesaurus3.setVersions(new HashSet<ThesaurusVersionHistory>());
		termId.setThesaurus(thesaurus3);
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
