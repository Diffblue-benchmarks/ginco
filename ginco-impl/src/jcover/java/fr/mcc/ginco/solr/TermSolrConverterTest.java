package fr.mcc.ginco.solr;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

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
import fr.mcc.ginco.services.INoteService;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashSet;

import org.apache.solr.common.SolrInputDocument;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

/**
 * Unit tests for fr.mcc.ginco.solr.TermSolrConverter
 *
 * @author Diffblue Cover
 */

public class TermSolrConverterTest {

	@Mock(name = "noteService")
	private INoteService noteService;

	@InjectMocks
	private TermSolrConverter service;

	@Before public void initMocks() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void convertSolrTerm1() throws java.text.ParseException {

		// arrange
		when(noteService.getTermNotePaginatedList(Mockito.<String>any(), Mockito.<Integer>any(), Mockito.<Integer>any()))
			.thenReturn(new ArrayList<Note>());
		ThesaurusTerm thesaurusTerm = new ThesaurusTerm();
		ThesaurusConcept concept = new ThesaurusConcept();
		concept.setAssociativeRelationshipLeft(new HashSet<AssociativeRelationship>());
		concept.setAssociativeRelationshipRight(new HashSet<AssociativeRelationship>());
		concept.setConceptArrays(new HashSet<ThesaurusArray>());
		concept.setCreated(new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31"));
		concept.setIdentifier("data");
		concept.setModified(new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31"));
		concept.setNotation("DE");
		concept.setParentConcepts(new HashSet<ThesaurusConcept>());
		concept.setRootConcepts(new HashSet<ThesaurusConcept>());
		concept.setStatus(1);
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
		concept.setThesaurus(thesaurus1);
		concept.setTopConcept(false);
		thesaurusTerm.setConcept(concept);
		thesaurusTerm.setCreated(new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31"));
		thesaurusTerm.setHidden(false);
		thesaurusTerm.setIdentifier("data");
		Language language = new Language();
		language.setId("1234");
		language.setPart1("foo");
		language.setPrincipalLanguage(false);
		language.setRefname("root");
		language.setTopLanguage(false);
		thesaurusTerm.setLanguage(language);
		thesaurusTerm.setLexicalValue("value");
		thesaurusTerm.setModified(new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31"));
		thesaurusTerm.setPrefered(false);
		ThesaurusTermRole role = new ThesaurusTermRole();
		role.setCode("DE");
		role.setDefaultRole(false);
		role.setLabel("label");
		thesaurusTerm.setRole(role);
		thesaurusTerm.setSource("foo");
		thesaurusTerm.setStatus(1);
		Thesaurus thesaurus2 = new Thesaurus();
		thesaurus2.setArchived(false);
		thesaurus2.setContributor("foo");
		thesaurus2.setCoverage("foo");
		thesaurus2.setCreated(new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31"));
		ThesaurusOrganization creator2 = new ThesaurusOrganization();
		creator2.setEmail("info@diffblue.com");
		creator2.setHomepage("foo");
		creator2.setIdentifier(1);
		creator2.setName("Acme");
		thesaurus2.setCreator(creator2);
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
		ThesaurusType type2 = new ThesaurusType();
		type2.setIdentifier(1);
		type2.setLabel("label");
		thesaurus2.setType(type2);
		thesaurus2.setVersions(new HashSet<ThesaurusVersionHistory>());
		thesaurusTerm.setThesaurus(thesaurus2);

		// act
		SolrInputDocument result = service.convertSolrTerm(thesaurusTerm);

		// assert
		assertEquals(1.0f, result.get("conceptId").getBoost(), 0);
		assertEquals("conceptId", result.get("conceptId").getName());
		assertEquals("data", (String) result.get("conceptId").getValue());
		assertEquals(1.0f, result.get("created").getBoost(), 0);
		assertEquals("created", result.get("created").getName());
		assertEquals(Timestamp.valueOf("2010-12-31 00:00:00.0"), (Timestamp) result.get("created").getValue());
		assertEquals(1.0f, result.get("ext_type").getBoost(), 0);
		assertEquals("ext_type", result.get("ext_type").getName());
		assertEquals(3, (int) (Integer) result.get("ext_type").getValue());
		assertEquals(1.0f, result.get("identifier").getBoost(), 0);
		assertEquals("identifier", result.get("identifier").getName());
		assertEquals("data", (String) result.get("identifier").getValue());
		assertEquals(1.0f, result.get("language").getBoost(), 0);
		assertEquals("language", result.get("language").getName());
		assertEquals("1234", (String) result.get("language").getValue());
		assertEquals(1.0f, result.get("lexicalValue").getBoost(), 0);
		assertEquals("lexicalValue", result.get("lexicalValue").getName());
		assertEquals("value", (String) result.get("lexicalValue").getValue());
		assertEquals(1.0f, result.get("modified").getBoost(), 0);
		assertEquals("modified", result.get("modified").getName());
		assertEquals(Timestamp.valueOf("2010-12-31 00:00:00.0"), (Timestamp) result.get("modified").getValue());
		assertEquals(1.0f, result.get("status").getBoost(), 0);
		assertEquals("status", result.get("status").getName());
		assertEquals(1, (int) (Integer) result.get("status").getValue());
		assertEquals(1.0f, result.get("thesaurusId").getBoost(), 0);
		assertEquals("thesaurusId", result.get("thesaurusId").getName());
		assertEquals("data", (String) result.get("thesaurusId").getValue());
		assertEquals(1.0f, result.get("thesaurusTitle").getBoost(), 0);
		assertEquals("thesaurusTitle", result.get("thesaurusTitle").getName());
		assertEquals("Mr", (String) result.get("thesaurusTitle").getValue());
		assertEquals(1.0f, result.get("type").getBoost(), 0);
		assertEquals("type", result.get("type").getName());
		assertEquals("ThesaurusTerm", (String) result.get("type").getValue());
	}

	@Test
	public void convertSolrTerm2() throws java.text.ParseException {

		// arrange
		ArrayList<Note> noteList = new ArrayList<Note>();
		Note note = new Note();
		ThesaurusConcept concept1 = mock(ThesaurusConcept.class);
		note.setConcept(concept1);
		note.setCreated(new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31"));
		note.setIdentifier("data");
		Language lang1 = new Language();
		lang1.setId("1234");
		lang1.setPart1("foo");
		lang1.setPrincipalLanguage(false);
		lang1.setRefname("root");
		lang1.setTopLanguage(false);
		note.setLanguage(lang1);
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
		Language language1 = new Language();
		language1.setId("1234");
		language1.setPart1("foo");
		language1.setPrincipalLanguage(false);
		language1.setRefname("root");
		language1.setTopLanguage(false);
		termId.setLanguage(language1);
		termId.setLexicalValue("value");
		termId.setModified(new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31"));
		termId.setPrefered(false);
		ThesaurusTermRole role1 = new ThesaurusTermRole();
		role1.setCode("DE");
		role1.setDefaultRole(false);
		role1.setLabel("label");
		termId.setRole(role1);
		termId.setSource("foo");
		termId.setStatus(1);
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
		termId.setThesaurus(thesaurus2);
		note.setTerm(termId);
		noteList.add(note);
		when(noteService.getTermNotePaginatedList(Mockito.<String>any(), Mockito.<Integer>any(), Mockito.<Integer>any()))
			.thenReturn(noteList);
		ThesaurusTerm thesaurusTerm = new ThesaurusTerm();
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
		concept3.setThesaurus(thesaurus3);
		concept3.setTopConcept(false);
		thesaurusTerm.setConcept(concept3);
		thesaurusTerm.setCreated(new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31"));
		thesaurusTerm.setHidden(false);
		thesaurusTerm.setIdentifier("data");
		Language language2 = new Language();
		language2.setId("1234");
		language2.setPart1("foo");
		language2.setPrincipalLanguage(false);
		language2.setRefname("root");
		language2.setTopLanguage(false);
		thesaurusTerm.setLanguage(language2);
		thesaurusTerm.setLexicalValue("value");
		thesaurusTerm.setModified(new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31"));
		thesaurusTerm.setPrefered(false);
		ThesaurusTermRole role2 = new ThesaurusTermRole();
		role2.setCode("DE");
		role2.setDefaultRole(false);
		role2.setLabel("label");
		thesaurusTerm.setRole(role2);
		thesaurusTerm.setSource("foo");
		thesaurusTerm.setStatus(1);
		Thesaurus thesaurus4 = new Thesaurus();
		thesaurus4.setArchived(false);
		thesaurus4.setContributor("foo");
		thesaurus4.setCoverage("foo");
		thesaurus4.setCreated(new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31"));
		ThesaurusOrganization creator3 = new ThesaurusOrganization();
		creator3.setEmail("info@diffblue.com");
		creator3.setHomepage("foo");
		creator3.setIdentifier(1);
		creator3.setName("Acme");
		thesaurus4.setCreator(creator3);
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
		ThesaurusType type3 = new ThesaurusType();
		type3.setIdentifier(1);
		type3.setLabel("label");
		thesaurus4.setType(type3);
		thesaurus4.setVersions(new HashSet<ThesaurusVersionHistory>());
		thesaurusTerm.setThesaurus(thesaurus4);

		// act
		SolrInputDocument result = service.convertSolrTerm(thesaurusTerm);

		// assert
		assertEquals(1.0f, result.get("conceptId").getBoost(), 0);
		assertEquals("conceptId", result.get("conceptId").getName());
		assertEquals("data", (String) result.get("conceptId").getValue());
		assertEquals(1.0f, result.get("created").getBoost(), 0);
		assertEquals("created", result.get("created").getName());
		assertEquals(Timestamp.valueOf("2010-12-31 00:00:00.0"), (Timestamp) result.get("created").getValue());
		assertEquals(1.0f, result.get("ext_type").getBoost(), 0);
		assertEquals("ext_type", result.get("ext_type").getName());
		assertEquals(3, (int) (Integer) result.get("ext_type").getValue());
		assertEquals(1.0f, result.get("identifier").getBoost(), 0);
		assertEquals("identifier", result.get("identifier").getName());
		assertEquals("data", (String) result.get("identifier").getValue());
		assertEquals(1.0f, result.get("language").getBoost(), 0);
		assertEquals("language", result.get("language").getName());
		assertEquals("1234", (String) result.get("language").getValue());
		assertEquals(1.0f, result.get("lexicalValue").getBoost(), 0);
		assertEquals("lexicalValue", result.get("lexicalValue").getName());
		assertEquals("value", (String) result.get("lexicalValue").getValue());
		assertEquals(1.0f, result.get("modified").getBoost(), 0);
		assertEquals("modified", result.get("modified").getName());
		assertEquals(Timestamp.valueOf("2010-12-31 00:00:00.0"), (Timestamp) result.get("modified").getValue());
		assertEquals(1.0f, result.get("notes").getBoost(), 0);
		assertEquals("notes", result.get("notes").getName());
		assertEquals("value", (String) result.get("notes").getValue());
		assertEquals(1.0f, result.get("status").getBoost(), 0);
		assertEquals("status", result.get("status").getName());
		assertEquals(1, (int) (Integer) result.get("status").getValue());
		assertEquals(1.0f, result.get("thesaurusId").getBoost(), 0);
		assertEquals("thesaurusId", result.get("thesaurusId").getName());
		assertEquals("data", (String) result.get("thesaurusId").getValue());
		assertEquals(1.0f, result.get("thesaurusTitle").getBoost(), 0);
		assertEquals("thesaurusTitle", result.get("thesaurusTitle").getName());
		assertEquals("Mr", (String) result.get("thesaurusTitle").getValue());
		assertEquals(1.0f, result.get("type").getBoost(), 0);
		assertEquals("type", result.get("type").getName());
		assertEquals("ThesaurusTerm", (String) result.get("type").getValue());
	}
}
