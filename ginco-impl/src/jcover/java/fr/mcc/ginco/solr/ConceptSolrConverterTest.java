package fr.mcc.ginco.solr;

import static org.junit.Assert.assertEquals;
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
import fr.mcc.ginco.services.IThesaurusConceptService;

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
 * Unit tests for fr.mcc.ginco.solr.ConceptSolrConverter
 *
 * @author Diffblue Cover
 */

public class ConceptSolrConverterTest {

	@Mock(name = "noteService")
	private INoteService noteService;

	@Mock(name = "thesaurusConceptService")
	private IThesaurusConceptService thesaurusConceptService;

	@InjectMocks
	private ConceptSolrConverter service;

	@Before
	public void initMocks() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void convertSolrConcept() throws java.text.ParseException {

		// arrange
		ThesaurusTerm thesaurusTerm1 = new ThesaurusTerm();
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
		thesaurusTerm1.setConcept(concept1);
		thesaurusTerm1.setCreated(new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31"));
		thesaurusTerm1.setHidden(false);
		thesaurusTerm1.setIdentifier("data");
		Language language1 = new Language();
		language1.setId("1234");
		language1.setPart1("foo");
		language1.setPrincipalLanguage(false);
		language1.setRefname("root");
		language1.setTopLanguage(false);
		thesaurusTerm1.setLanguage(language1);
		thesaurusTerm1.setLexicalValue("value");
		thesaurusTerm1.setModified(new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31"));
		thesaurusTerm1.setPrefered(false);
		ThesaurusTermRole role1 = new ThesaurusTermRole();
		role1.setCode("DE");
		role1.setDefaultRole(false);
		role1.setLabel("label");
		thesaurusTerm1.setRole(role1);
		thesaurusTerm1.setSource("foo");
		thesaurusTerm1.setStatus(1);
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
		thesaurusTerm1.setThesaurus(thesaurus2);
		ArrayList<ThesaurusTerm> thesaurusTermList = new ArrayList<ThesaurusTerm>();
		ThesaurusTerm thesaurusTerm2 = new ThesaurusTerm();
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
		thesaurusTerm2.setConcept(concept2);
		thesaurusTerm2.setCreated(new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31"));
		thesaurusTerm2.setHidden(false);
		thesaurusTerm2.setIdentifier("data");
		Language language2 = new Language();
		language2.setId("1234");
		language2.setPart1("foo");
		language2.setPrincipalLanguage(false);
		language2.setRefname("root");
		language2.setTopLanguage(false);
		thesaurusTerm2.setLanguage(language2);
		thesaurusTerm2.setLexicalValue("value");
		thesaurusTerm2.setModified(new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31"));
		thesaurusTerm2.setPrefered(false);
		ThesaurusTermRole role2 = new ThesaurusTermRole();
		role2.setCode("DE");
		role2.setDefaultRole(false);
		role2.setLabel("label");
		thesaurusTerm2.setRole(role2);
		thesaurusTerm2.setSource("foo");
		thesaurusTerm2.setStatus(1);
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
		thesaurusTerm2.setThesaurus(thesaurus4);
		thesaurusTermList.add(thesaurusTerm2);
		when(thesaurusConceptService.getConceptPreferredTerm(Mockito.<String>any()))
			.thenReturn(thesaurusTerm1);
		when(thesaurusConceptService.getConceptPreferredTerms(Mockito.<String>any()))
			.thenReturn(thesaurusTermList);
		ArrayList<Note> noteList = new ArrayList<Note>();
		Note note = new Note();
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
		note.setConcept(concept3);
		note.setCreated(new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31"));
		note.setIdentifier("data");
		Language lang4 = new Language();
		lang4.setId("1234");
		lang4.setPart1("foo");
		lang4.setPrincipalLanguage(false);
		lang4.setRefname("root");
		lang4.setTopLanguage(false);
		note.setLanguage(lang4);
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
		noteList.add(note);
		when(noteService.getConceptNotePaginatedList(Mockito.<String>any(), Mockito.<Integer>any(), Mockito.<Integer>any()))
			.thenReturn(noteList);
		ThesaurusConcept thesaurusConcept = new ThesaurusConcept();
		thesaurusConcept.setAssociativeRelationshipLeft(new HashSet<AssociativeRelationship>());
		thesaurusConcept.setAssociativeRelationshipRight(new HashSet<AssociativeRelationship>());
		thesaurusConcept.setConceptArrays(new HashSet<ThesaurusArray>());
		thesaurusConcept.setCreated(new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31"));
		thesaurusConcept.setIdentifier("data");
		thesaurusConcept.setModified(new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31"));
		thesaurusConcept.setNotation("DE");
		thesaurusConcept.setParentConcepts(new HashSet<ThesaurusConcept>());
		thesaurusConcept.setRootConcepts(new HashSet<ThesaurusConcept>());
		thesaurusConcept.setStatus(1);
		Thesaurus thesaurus7 = new Thesaurus();
		thesaurus7.setArchived(false);
		thesaurus7.setContributor("foo");
		thesaurus7.setCoverage("foo");
		thesaurus7.setCreated(new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31"));
		ThesaurusOrganization creator4 = new ThesaurusOrganization();
		creator4.setEmail("info@diffblue.com");
		creator4.setHomepage("foo");
		creator4.setIdentifier(1);
		creator4.setName("Acme");
		thesaurus7.setCreator(creator4);
		thesaurus7.setDate(new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31"));
		thesaurus7.setDefaultTopConcept(false);
		thesaurus7.setDescription("some text");
		thesaurus7.setFormat(new HashSet<ThesaurusFormat>());
		thesaurus7.setIdentifier("data");
		thesaurus7.setLang(new HashSet<Language>());
		thesaurus7.setPolyHierarchical(false);
		thesaurus7.setPublisher("foo");
		thesaurus7.setRelation("DE");
		thesaurus7.setRights("foo");
		thesaurus7.setSource("foo");
		thesaurus7.setSubject("foo");
		thesaurus7.setTitle("Mr");
		ThesaurusType type4 = new ThesaurusType();
		type4.setIdentifier(1);
		type4.setLabel("label");
		thesaurus7.setType(type4);
		thesaurus7.setVersions(new HashSet<ThesaurusVersionHistory>());
		thesaurusConcept.setThesaurus(thesaurus7);
		thesaurusConcept.setTopConcept(false);

		// act
		SolrInputDocument result = service.convertSolrConcept(thesaurusConcept);

		// assert
		assertEquals(1.0f, result.get("created").getBoost(), 0);
		assertEquals("created", result.get("created").getName());
		assertEquals(Timestamp.valueOf("2010-12-31 00:00:00.0"), (Timestamp) result.get("created").getValue());
		assertEquals(1.0f, result.get("ext_type").getBoost(), 0);
		assertEquals("ext_type", result.get("ext_type").getName());
		assertEquals(1, (int) (Integer) result.get("ext_type").getValue());
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
		assertEquals("ThesaurusConcept", (String) result.get("type").getValue());
	}
}
