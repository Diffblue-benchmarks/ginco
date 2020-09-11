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
		ArrayList<ReducedThesaurusConcept> associates =
			 new ArrayList<ReducedThesaurusConcept>();
		ReducedThesaurusConcept reducedThesaurusConcept2 =
			 new ReducedThesaurusConcept();
		reducedThesaurusConcept2.setIdentifier("data");
		reducedThesaurusConcept2.setStatus(ConceptStatusEnum.CANDIDATE);
		associates.add(reducedThesaurusConcept2);
		reducedThesaurusConcept1.setAssociates(associates);
		reducedThesaurusConcept1.setIdentifier("data");
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
		Thesaurus thesaurus2 = new Thesaurus();
		thesaurus2.setArchived(false);
		thesaurus2.setContributor("foo");
		thesaurus2.setCoverage("foo");
		thesaurus2.setCreated(new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31"));
		thesaurus2.setCreator(new ThesaurusOrganization());
		thesaurus2.setDate(new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31"));
		thesaurus2.setDefaultTopConcept(false);
		thesaurus2.setDescription("some text");
		thesaurus2.setFormat(new HashSet<ThesaurusFormat>());
		thesaurus2.setIdentifier("data");
		thesaurus2.setLang(new HashSet<Language>());
		thesaurus2.setPolyHierarchical(false);
		thesaurus2.setPublisher("foo");
		thesaurus2.setRelation("DE");
		thesaurus2.setRights("foo");
		thesaurus2.setSource("foo");
		thesaurus2.setSubject("foo");
		thesaurus2.setTitle("Mr");
		thesaurus2.setType(new ThesaurusType());
		thesaurus2.setVersions(new HashSet<ThesaurusVersionHistory>());
		concept2.setThesaurus(thesaurus2);
		concept2.setTopConcept(false);
		note.setConcept(concept2);
		note.setCreated(new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31"));
		note.setIdentifier("data");
		Language lang3 = new Language();
		lang3.setId("1234");
		lang3.setPart1("foo");
		lang3.setPrincipalLanguage(false);
		lang3.setRefname("foo");
		lang3.setTopLanguage(false);
		note.setLanguage(lang3);
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
		ThesaurusConcept concept3 = new ThesaurusConcept();
		concept3.setAssociativeRelationshipLeft(new HashSet<AssociativeRelationship>());
		concept3.setAssociativeRelationshipRight(new HashSet<AssociativeRelationship>());
		concept3.setConceptArrays(new HashSet<ThesaurusArray>());
		concept3.setCreated(new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31"));
		concept3.setIdentifier("data");
		concept3.setModified(new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31"));
		concept3.setNotation("DE");
		concept3.setParentConcepts(new HashSet<ThesaurusConcept>());
		concept3.setRootConcepts(new HashSet<ThesaurusConcept>());
		concept3.setStatus(1);
		concept3.setThesaurus(new Thesaurus());
		concept3.setTopConcept(false);
		termId.setConcept(concept3);
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
		Thesaurus thesaurus4 = new Thesaurus();
		thesaurus4.setArchived(false);
		thesaurus4.setContributor("foo");
		thesaurus4.setCoverage("foo");
		thesaurus4.setCreated(new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31"));
		thesaurus4.setCreator(new ThesaurusOrganization());
		thesaurus4.setDate(new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31"));
		thesaurus4.setDefaultTopConcept(false);
		thesaurus4.setDescription("some text");
		thesaurus4.setFormat(new HashSet<ThesaurusFormat>());
		thesaurus4.setIdentifier("data");
		thesaurus4.setLang(new HashSet<Language>());
		thesaurus4.setPolyHierarchical(false);
		thesaurus4.setPublisher("foo");
		thesaurus4.setRelation("DE");
		thesaurus4.setRights("foo");
		thesaurus4.setSource("foo");
		thesaurus4.setSubject("foo");
		thesaurus4.setTitle("Mr");
		thesaurus4.setType(new ThesaurusType());
		thesaurus4.setVersions(new HashSet<ThesaurusVersionHistory>());
		termId.setThesaurus(thesaurus4);
		note.setTerm(termId);
		notes.add(note);
		reducedThesaurusConcept1.setNotes(notes);
		ArrayList<ReducedThesaurusConcept> parents =
			 new ArrayList<ReducedThesaurusConcept>();
		ReducedThesaurusConcept reducedThesaurusConcept3 =
			 new ReducedThesaurusConcept();
		reducedThesaurusConcept3.setIdentifier("data");
		reducedThesaurusConcept3.setStatus(ConceptStatusEnum.CANDIDATE);
		parents.add(reducedThesaurusConcept3);
		reducedThesaurusConcept1.setParents(parents);
		reducedThesaurusConcept1.setStatus(ConceptStatusEnum.CANDIDATE);
		assertThat(reducedThesaurusConcept1.getAssociates().size(), is(1));
		assertThat(reducedThesaurusConcept1.getAssociates().get(0), sameInstance(reducedThesaurusConcept2));
		assertThat(reducedThesaurusConcept1.getIdentifier(), is("data"));
		assertThat(reducedThesaurusConcept1.getNotes().size(), is(1));
		assertThat(reducedThesaurusConcept1.getNotes().get(0), sameInstance(note));
		assertThat(reducedThesaurusConcept1.getParents().size(), is(1));
		assertThat(reducedThesaurusConcept1.getParents().get(0), sameInstance(reducedThesaurusConcept3));
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
