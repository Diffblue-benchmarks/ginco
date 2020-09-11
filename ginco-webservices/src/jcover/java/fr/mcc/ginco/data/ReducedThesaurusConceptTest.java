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
		ArrayList<ReducedThesaurusConcept> associates1 =
			 new ArrayList<ReducedThesaurusConcept>();
		ReducedThesaurusConcept reducedThesaurusConcept2 =
			 new ReducedThesaurusConcept();
		ArrayList<ReducedThesaurusConcept> associates2 =
			 new ArrayList<ReducedThesaurusConcept>();
		ReducedThesaurusConcept reducedThesaurusConcept3 =
			 new ReducedThesaurusConcept();
		ArrayList<ReducedThesaurusConcept> associates3 =
			 new ArrayList<ReducedThesaurusConcept>();
		ReducedThesaurusConcept reducedThesaurusConcept4 =
			 new ReducedThesaurusConcept();
		ArrayList<ReducedThesaurusConcept> associates4 =
			 new ArrayList<ReducedThesaurusConcept>();
		associates4.add(new ReducedThesaurusConcept());
		reducedThesaurusConcept4.setAssociates(associates4);
		reducedThesaurusConcept4.setIdentifier("data");
		ArrayList<Note> notes1 = new ArrayList<Note>();
		notes1.add(new Note());
		reducedThesaurusConcept4.setNotes(notes1);
		ArrayList<ReducedThesaurusConcept> parents1 =
			 new ArrayList<ReducedThesaurusConcept>();
		parents1.add(new ReducedThesaurusConcept());
		reducedThesaurusConcept4.setParents(parents1);
		reducedThesaurusConcept4.setStatus(ConceptStatusEnum.CANDIDATE);
		associates3.add(reducedThesaurusConcept4);
		reducedThesaurusConcept3.setAssociates(associates3);
		reducedThesaurusConcept3.setIdentifier("data");
		ArrayList<Note> notes2 = new ArrayList<Note>();
		Note note2 = new Note();
		note2.setConcept(new ThesaurusConcept());
		note2.setCreated(new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31"));
		note2.setIdentifier("data");
		note2.setLanguage(new Language());
		note2.setLexicalValue("value");
		note2.setModified(new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31"));
		note2.setNoteType(new NoteType());
		note2.setSource("foo");
		note2.setTerm(new ThesaurusTerm());
		notes2.add(note2);
		reducedThesaurusConcept3.setNotes(notes2);
		ArrayList<ReducedThesaurusConcept> parents2 =
			 new ArrayList<ReducedThesaurusConcept>();
		ReducedThesaurusConcept reducedThesaurusConcept7 =
			 new ReducedThesaurusConcept();
		ArrayList<ReducedThesaurusConcept> associates5 =
			 new ArrayList<ReducedThesaurusConcept>();
		associates5.add(new ReducedThesaurusConcept());
		reducedThesaurusConcept7.setAssociates(associates5);
		reducedThesaurusConcept7.setIdentifier("data");
		ArrayList<Note> notes3 = new ArrayList<Note>();
		notes3.add(new Note());
		reducedThesaurusConcept7.setNotes(notes3);
		ArrayList<ReducedThesaurusConcept> parents3 =
			 new ArrayList<ReducedThesaurusConcept>();
		parents3.add(new ReducedThesaurusConcept());
		reducedThesaurusConcept7.setParents(parents3);
		reducedThesaurusConcept7.setStatus(ConceptStatusEnum.CANDIDATE);
		parents2.add(reducedThesaurusConcept7);
		reducedThesaurusConcept3.setParents(parents2);
		reducedThesaurusConcept3.setStatus(ConceptStatusEnum.CANDIDATE);
		associates2.add(reducedThesaurusConcept3);
		reducedThesaurusConcept2.setAssociates(associates2);
		reducedThesaurusConcept2.setIdentifier("data");
		ArrayList<Note> notes4 = new ArrayList<Note>();
		Note note4 = new Note();
		ThesaurusConcept concept6 = new ThesaurusConcept();
		concept6.setAssociativeRelationshipLeft(new HashSet<AssociativeRelationship>());
		concept6.setAssociativeRelationshipRight(new HashSet<AssociativeRelationship>());
		concept6.setConceptArrays(new HashSet<ThesaurusArray>());
		concept6.setCreated(new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31"));
		concept6.setIdentifier("data");
		concept6.setModified(new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31"));
		concept6.setNotation("DE");
		concept6.setParentConcepts(new HashSet<ThesaurusConcept>());
		concept6.setRootConcepts(new HashSet<ThesaurusConcept>());
		concept6.setStatus(1);
		concept6.setThesaurus(new Thesaurus());
		concept6.setTopConcept(false);
		note4.setConcept(concept6);
		note4.setCreated(new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31"));
		note4.setIdentifier("data");
		Language lang3 = new Language();
		lang3.setId("1234");
		lang3.setPart1("foo");
		lang3.setPrincipalLanguage(false);
		lang3.setRefname("root");
		lang3.setTopLanguage(false);
		note4.setLanguage(lang3);
		note4.setLexicalValue("value");
		note4.setModified(new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31"));
		NoteType noteType2 = new NoteType();
		noteType2.setCode("DE");
		noteType2.setIsConcept(false);
		noteType2.setIsTerm(false);
		noteType2.setLabel("label");
		note4.setNoteType(noteType2);
		note4.setSource("foo");
		ThesaurusTerm termId2 = new ThesaurusTerm();
		termId2.setConcept(new ThesaurusConcept());
		termId2.setCreated(new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31"));
		termId2.setHidden(false);
		termId2.setIdentifier("data");
		termId2.setLanguage(new Language());
		termId2.setLexicalValue("value");
		termId2.setModified(new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31"));
		termId2.setPrefered(false);
		termId2.setRole(new ThesaurusTermRole());
		termId2.setSource("foo");
		termId2.setStatus(1);
		termId2.setThesaurus(new Thesaurus());
		note4.setTerm(termId2);
		notes4.add(note4);
		reducedThesaurusConcept2.setNotes(notes4);
		ArrayList<ReducedThesaurusConcept> parents4 =
			 new ArrayList<ReducedThesaurusConcept>();
		ReducedThesaurusConcept reducedThesaurusConcept10 =
			 new ReducedThesaurusConcept();
		ArrayList<ReducedThesaurusConcept> associates6 =
			 new ArrayList<ReducedThesaurusConcept>();
		ReducedThesaurusConcept reducedThesaurusConcept11 =
			 new ReducedThesaurusConcept();
		ArrayList<ReducedThesaurusConcept> associates7 =
			 new ArrayList<ReducedThesaurusConcept>();
		associates7.add(new ReducedThesaurusConcept());
		reducedThesaurusConcept11.setAssociates(associates7);
		reducedThesaurusConcept11.setIdentifier("data");
		ArrayList<Note> notes5 = new ArrayList<Note>();
		notes5.add(new Note());
		reducedThesaurusConcept11.setNotes(notes5);
		ArrayList<ReducedThesaurusConcept> parents5 =
			 new ArrayList<ReducedThesaurusConcept>();
		parents5.add(new ReducedThesaurusConcept());
		reducedThesaurusConcept11.setParents(parents5);
		reducedThesaurusConcept11.setStatus(ConceptStatusEnum.CANDIDATE);
		associates6.add(reducedThesaurusConcept11);
		reducedThesaurusConcept10.setAssociates(associates6);
		reducedThesaurusConcept10.setIdentifier("data");
		ArrayList<Note> notes6 = new ArrayList<Note>();
		Note note6 = new Note();
		note6.setConcept(new ThesaurusConcept());
		note6.setCreated(new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31"));
		note6.setIdentifier("data");
		note6.setLanguage(new Language());
		note6.setLexicalValue("value");
		note6.setModified(new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31"));
		note6.setNoteType(new NoteType());
		note6.setSource("foo");
		note6.setTerm(new ThesaurusTerm());
		notes6.add(note6);
		reducedThesaurusConcept10.setNotes(notes6);
		ArrayList<ReducedThesaurusConcept> parents6 =
			 new ArrayList<ReducedThesaurusConcept>();
		ReducedThesaurusConcept reducedThesaurusConcept14 =
			 new ReducedThesaurusConcept();
		ArrayList<ReducedThesaurusConcept> associates8 =
			 new ArrayList<ReducedThesaurusConcept>();
		associates8.add(new ReducedThesaurusConcept());
		reducedThesaurusConcept14.setAssociates(associates8);
		reducedThesaurusConcept14.setIdentifier("data");
		ArrayList<Note> notes7 = new ArrayList<Note>();
		notes7.add(new Note());
		reducedThesaurusConcept14.setNotes(notes7);
		ArrayList<ReducedThesaurusConcept> parents7 =
			 new ArrayList<ReducedThesaurusConcept>();
		parents7.add(new ReducedThesaurusConcept());
		reducedThesaurusConcept14.setParents(parents7);
		reducedThesaurusConcept14.setStatus(ConceptStatusEnum.CANDIDATE);
		parents6.add(reducedThesaurusConcept14);
		reducedThesaurusConcept10.setParents(parents6);
		reducedThesaurusConcept10.setStatus(ConceptStatusEnum.CANDIDATE);
		parents4.add(reducedThesaurusConcept10);
		reducedThesaurusConcept2.setParents(parents4);
		reducedThesaurusConcept2.setStatus(ConceptStatusEnum.CANDIDATE);
		associates1.add(reducedThesaurusConcept2);
		reducedThesaurusConcept1.setAssociates(associates1);
		reducedThesaurusConcept1.setIdentifier("data");
		ArrayList<Note> notes8 = new ArrayList<Note>();
		Note note8 = new Note();
		ThesaurusConcept concept12 = new ThesaurusConcept();
		concept12.setAssociativeRelationshipLeft(new HashSet<AssociativeRelationship>());
		concept12.setAssociativeRelationshipRight(new HashSet<AssociativeRelationship>());
		concept12.setConceptArrays(new HashSet<ThesaurusArray>());
		concept12.setCreated(new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31"));
		concept12.setIdentifier("data");
		concept12.setModified(new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31"));
		concept12.setNotation("DE");
		concept12.setParentConcepts(new HashSet<ThesaurusConcept>());
		concept12.setRootConcepts(new HashSet<ThesaurusConcept>());
		concept12.setStatus(1);
		Thesaurus thesaurus6 = new Thesaurus();
		thesaurus6.setArchived(false);
		thesaurus6.setContributor("foo");
		thesaurus6.setCoverage("foo");
		thesaurus6.setCreated(new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31"));
		thesaurus6.setCreator(new ThesaurusOrganization());
		thesaurus6.setDate(new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31"));
		thesaurus6.setDefaultTopConcept(false);
		thesaurus6.setDescription("some text");
		thesaurus6.setFormat(new HashSet<ThesaurusFormat>());
		thesaurus6.setIdentifier("data");
		thesaurus6.setLang(new HashSet<Language>());
		thesaurus6.setPolyHierarchical(false);
		thesaurus6.setPublisher("foo");
		thesaurus6.setRelation("DE");
		thesaurus6.setRights("foo");
		thesaurus6.setSource("foo");
		thesaurus6.setSubject("foo");
		thesaurus6.setTitle("Mr");
		thesaurus6.setType(new ThesaurusType());
		thesaurus6.setVersions(new HashSet<ThesaurusVersionHistory>());
		concept12.setThesaurus(thesaurus6);
		concept12.setTopConcept(false);
		note8.setConcept(concept12);
		note8.setCreated(new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31"));
		note8.setIdentifier("data");
		Language lang6 = new Language();
		lang6.setId("1234");
		lang6.setPart1("foo");
		lang6.setPrincipalLanguage(false);
		lang6.setRefname("root");
		lang6.setTopLanguage(false);
		note8.setLanguage(lang6);
		note8.setLexicalValue("value");
		note8.setModified(new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31"));
		NoteType noteType4 = new NoteType();
		noteType4.setCode("DE");
		noteType4.setIsConcept(false);
		noteType4.setIsTerm(false);
		noteType4.setLabel("label");
		note8.setNoteType(noteType4);
		note8.setSource("foo");
		ThesaurusTerm termId4 = new ThesaurusTerm();
		ThesaurusConcept concept13 = new ThesaurusConcept();
		concept13.setAssociativeRelationshipLeft(new HashSet<AssociativeRelationship>());
		concept13.setAssociativeRelationshipRight(new HashSet<AssociativeRelationship>());
		concept13.setConceptArrays(new HashSet<ThesaurusArray>());
		concept13.setCreated(new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31"));
		concept13.setIdentifier("data");
		concept13.setModified(new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31"));
		concept13.setNotation("DE");
		concept13.setParentConcepts(new HashSet<ThesaurusConcept>());
		concept13.setRootConcepts(new HashSet<ThesaurusConcept>());
		concept13.setStatus(1);
		concept13.setThesaurus(new Thesaurus());
		concept13.setTopConcept(false);
		termId4.setConcept(concept13);
		termId4.setCreated(new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31"));
		termId4.setHidden(false);
		termId4.setIdentifier("data");
		Language language2 = new Language();
		language2.setId("1234");
		language2.setPart1("foo");
		language2.setPrincipalLanguage(false);
		language2.setRefname("root");
		language2.setTopLanguage(false);
		termId4.setLanguage(language2);
		termId4.setLexicalValue("value");
		termId4.setModified(new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31"));
		termId4.setPrefered(false);
		ThesaurusTermRole role2 = new ThesaurusTermRole();
		role2.setCode("DE");
		role2.setDefaultRole(false);
		role2.setLabel("label");
		termId4.setRole(role2);
		termId4.setSource("foo");
		termId4.setStatus(1);
		Thesaurus thesaurus8 = new Thesaurus();
		thesaurus8.setArchived(false);
		thesaurus8.setContributor("foo");
		thesaurus8.setCoverage("foo");
		thesaurus8.setCreated(new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31"));
		thesaurus8.setCreator(new ThesaurusOrganization());
		thesaurus8.setDate(new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31"));
		thesaurus8.setDefaultTopConcept(false);
		thesaurus8.setDescription("some text");
		thesaurus8.setFormat(new HashSet<ThesaurusFormat>());
		thesaurus8.setIdentifier("data");
		thesaurus8.setLang(new HashSet<Language>());
		thesaurus8.setPolyHierarchical(false);
		thesaurus8.setPublisher("foo");
		thesaurus8.setRelation("DE");
		thesaurus8.setRights("foo");
		thesaurus8.setSource("foo");
		thesaurus8.setSubject("foo");
		thesaurus8.setTitle("Mr");
		thesaurus8.setType(new ThesaurusType());
		thesaurus8.setVersions(new HashSet<ThesaurusVersionHistory>());
		termId4.setThesaurus(thesaurus8);
		note8.setTerm(termId4);
		notes8.add(note8);
		reducedThesaurusConcept1.setNotes(notes8);
		ArrayList<ReducedThesaurusConcept> parents8 =
			 new ArrayList<ReducedThesaurusConcept>();
		ReducedThesaurusConcept reducedThesaurusConcept17 =
			 new ReducedThesaurusConcept();
		ArrayList<ReducedThesaurusConcept> associates9 =
			 new ArrayList<ReducedThesaurusConcept>();
		ReducedThesaurusConcept reducedThesaurusConcept18 =
			 new ReducedThesaurusConcept();
		ArrayList<ReducedThesaurusConcept> associates10 =
			 new ArrayList<ReducedThesaurusConcept>();
		ReducedThesaurusConcept reducedThesaurusConcept19 =
			 new ReducedThesaurusConcept();
		ArrayList<ReducedThesaurusConcept> associates11 =
			 new ArrayList<ReducedThesaurusConcept>();
		associates11.add(new ReducedThesaurusConcept());
		reducedThesaurusConcept19.setAssociates(associates11);
		reducedThesaurusConcept19.setIdentifier("data");
		ArrayList<Note> notes9 = new ArrayList<Note>();
		notes9.add(new Note());
		reducedThesaurusConcept19.setNotes(notes9);
		ArrayList<ReducedThesaurusConcept> parents9 =
			 new ArrayList<ReducedThesaurusConcept>();
		parents9.add(new ReducedThesaurusConcept());
		reducedThesaurusConcept19.setParents(parents9);
		reducedThesaurusConcept19.setStatus(ConceptStatusEnum.CANDIDATE);
		associates10.add(reducedThesaurusConcept19);
		reducedThesaurusConcept18.setAssociates(associates10);
		reducedThesaurusConcept18.setIdentifier("data");
		ArrayList<Note> notes10 = new ArrayList<Note>();
		Note note10 = new Note();
		note10.setConcept(new ThesaurusConcept());
		note10.setCreated(new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31"));
		note10.setIdentifier("data");
		note10.setLanguage(new Language());
		note10.setLexicalValue("value");
		note10.setModified(new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31"));
		note10.setNoteType(new NoteType());
		note10.setSource("foo");
		note10.setTerm(new ThesaurusTerm());
		notes10.add(note10);
		reducedThesaurusConcept18.setNotes(notes10);
		ArrayList<ReducedThesaurusConcept> parents10 =
			 new ArrayList<ReducedThesaurusConcept>();
		ReducedThesaurusConcept reducedThesaurusConcept22 =
			 new ReducedThesaurusConcept();
		ArrayList<ReducedThesaurusConcept> associates12 =
			 new ArrayList<ReducedThesaurusConcept>();
		associates12.add(new ReducedThesaurusConcept());
		reducedThesaurusConcept22.setAssociates(associates12);
		reducedThesaurusConcept22.setIdentifier("data");
		ArrayList<Note> notes11 = new ArrayList<Note>();
		notes11.add(new Note());
		reducedThesaurusConcept22.setNotes(notes11);
		ArrayList<ReducedThesaurusConcept> parents11 =
			 new ArrayList<ReducedThesaurusConcept>();
		parents11.add(new ReducedThesaurusConcept());
		reducedThesaurusConcept22.setParents(parents11);
		reducedThesaurusConcept22.setStatus(ConceptStatusEnum.CANDIDATE);
		parents10.add(reducedThesaurusConcept22);
		reducedThesaurusConcept18.setParents(parents10);
		reducedThesaurusConcept18.setStatus(ConceptStatusEnum.CANDIDATE);
		associates9.add(reducedThesaurusConcept18);
		reducedThesaurusConcept17.setAssociates(associates9);
		reducedThesaurusConcept17.setIdentifier("data");
		ArrayList<Note> notes12 = new ArrayList<Note>();
		Note note12 = new Note();
		ThesaurusConcept concept19 = new ThesaurusConcept();
		concept19.setAssociativeRelationshipLeft(new HashSet<AssociativeRelationship>());
		concept19.setAssociativeRelationshipRight(new HashSet<AssociativeRelationship>());
		concept19.setConceptArrays(new HashSet<ThesaurusArray>());
		concept19.setCreated(new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31"));
		concept19.setIdentifier("data");
		concept19.setModified(new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31"));
		concept19.setNotation("DE");
		concept19.setParentConcepts(new HashSet<ThesaurusConcept>());
		concept19.setRootConcepts(new HashSet<ThesaurusConcept>());
		concept19.setStatus(1);
		concept19.setThesaurus(new Thesaurus());
		concept19.setTopConcept(false);
		note12.setConcept(concept19);
		note12.setCreated(new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31"));
		note12.setIdentifier("data");
		Language lang10 = new Language();
		lang10.setId("1234");
		lang10.setPart1("foo");
		lang10.setPrincipalLanguage(false);
		lang10.setRefname("root");
		lang10.setTopLanguage(false);
		note12.setLanguage(lang10);
		note12.setLexicalValue("value");
		note12.setModified(new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31"));
		NoteType noteType6 = new NoteType();
		noteType6.setCode("DE");
		noteType6.setIsConcept(false);
		noteType6.setIsTerm(false);
		noteType6.setLabel("label");
		note12.setNoteType(noteType6);
		note12.setSource("foo");
		ThesaurusTerm termId6 = new ThesaurusTerm();
		termId6.setConcept(new ThesaurusConcept());
		termId6.setCreated(new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31"));
		termId6.setHidden(false);
		termId6.setIdentifier("data");
		termId6.setLanguage(new Language());
		termId6.setLexicalValue("value");
		termId6.setModified(new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31"));
		termId6.setPrefered(false);
		termId6.setRole(new ThesaurusTermRole());
		termId6.setSource("foo");
		termId6.setStatus(1);
		termId6.setThesaurus(new Thesaurus());
		note12.setTerm(termId6);
		notes12.add(note12);
		reducedThesaurusConcept17.setNotes(notes12);
		ArrayList<ReducedThesaurusConcept> parents12 =
			 new ArrayList<ReducedThesaurusConcept>();
		ReducedThesaurusConcept reducedThesaurusConcept25 =
			 new ReducedThesaurusConcept();
		ArrayList<ReducedThesaurusConcept> associates13 =
			 new ArrayList<ReducedThesaurusConcept>();
		ReducedThesaurusConcept reducedThesaurusConcept26 =
			 new ReducedThesaurusConcept();
		ArrayList<ReducedThesaurusConcept> associates14 =
			 new ArrayList<ReducedThesaurusConcept>();
		associates14.add(new ReducedThesaurusConcept());
		reducedThesaurusConcept26.setAssociates(associates14);
		reducedThesaurusConcept26.setIdentifier("data");
		ArrayList<Note> notes13 = new ArrayList<Note>();
		notes13.add(new Note());
		reducedThesaurusConcept26.setNotes(notes13);
		ArrayList<ReducedThesaurusConcept> parents13 =
			 new ArrayList<ReducedThesaurusConcept>();
		parents13.add(new ReducedThesaurusConcept());
		reducedThesaurusConcept26.setParents(parents13);
		reducedThesaurusConcept26.setStatus(ConceptStatusEnum.CANDIDATE);
		associates13.add(reducedThesaurusConcept26);
		reducedThesaurusConcept25.setAssociates(associates13);
		reducedThesaurusConcept25.setIdentifier("data");
		ArrayList<Note> notes14 = new ArrayList<Note>();
		Note note14 = new Note();
		note14.setConcept(new ThesaurusConcept());
		note14.setCreated(new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31"));
		note14.setIdentifier("data");
		note14.setLanguage(new Language());
		note14.setLexicalValue("value");
		note14.setModified(new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31"));
		note14.setNoteType(new NoteType());
		note14.setSource("foo");
		note14.setTerm(new ThesaurusTerm());
		notes14.add(note14);
		reducedThesaurusConcept25.setNotes(notes14);
		ArrayList<ReducedThesaurusConcept> parents14 =
			 new ArrayList<ReducedThesaurusConcept>();
		ReducedThesaurusConcept reducedThesaurusConcept29 =
			 new ReducedThesaurusConcept();
		ArrayList<ReducedThesaurusConcept> associates15 =
			 new ArrayList<ReducedThesaurusConcept>();
		associates15.add(new ReducedThesaurusConcept());
		reducedThesaurusConcept29.setAssociates(associates15);
		reducedThesaurusConcept29.setIdentifier("data");
		ArrayList<Note> notes15 = new ArrayList<Note>();
		notes15.add(new Note());
		reducedThesaurusConcept29.setNotes(notes15);
		ArrayList<ReducedThesaurusConcept> parents15 =
			 new ArrayList<ReducedThesaurusConcept>();
		parents15.add(new ReducedThesaurusConcept());
		reducedThesaurusConcept29.setParents(parents15);
		reducedThesaurusConcept29.setStatus(ConceptStatusEnum.CANDIDATE);
		parents14.add(reducedThesaurusConcept29);
		reducedThesaurusConcept25.setParents(parents14);
		reducedThesaurusConcept25.setStatus(ConceptStatusEnum.CANDIDATE);
		parents12.add(reducedThesaurusConcept25);
		reducedThesaurusConcept17.setParents(parents12);
		reducedThesaurusConcept17.setStatus(ConceptStatusEnum.CANDIDATE);
		parents8.add(reducedThesaurusConcept17);
		reducedThesaurusConcept1.setParents(parents8);
		reducedThesaurusConcept1.setStatus(ConceptStatusEnum.CANDIDATE);
		assertThat(reducedThesaurusConcept1.getAssociates().size(), is(1));
		assertThat(reducedThesaurusConcept1.getAssociates().get(0), sameInstance(reducedThesaurusConcept2));
		assertThat(reducedThesaurusConcept1.getIdentifier(), is("data"));
		assertThat(reducedThesaurusConcept1.getNotes().size(), is(1));
		assertThat(reducedThesaurusConcept1.getNotes().get(0), sameInstance(note8));
		assertThat(reducedThesaurusConcept1.getParents().size(), is(1));
		assertThat(reducedThesaurusConcept1.getParents().get(0), sameInstance(reducedThesaurusConcept17));
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
