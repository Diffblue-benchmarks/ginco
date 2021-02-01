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
		ThesaurusOrganization creator1 = new ThesaurusOrganization();
		creator1.setEmail("info@diffblue.com");
		creator1.setHomepage("foo");
		creator1.setIdentifier(1);
		creator1.setName("Acme");
		thesaurus1.setCreator(creator1);
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
		ThesaurusType type1 = new ThesaurusType();
		type1.setIdentifier(1);
		type1.setLabel("label");
		thesaurus1.setType(type1);
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
		concept2.setThesaurus(thesaurus3);
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
		ThesaurusOrganization creator4 = new ThesaurusOrganization();
		creator4.setEmail("info@diffblue.com");
		creator4.setHomepage("foo");
		creator4.setIdentifier(1);
		creator4.setName("Acme");
		thesaurus4.setCreator(creator4);
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
		ThesaurusType type4 = new ThesaurusType();
		type4.setIdentifier(1);
		type4.setLabel("label");
		thesaurus4.setType(type4);
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
		Thesaurus thesaurus5 = new Thesaurus();
		thesaurus5.setArchived(false);
		thesaurus5.setContributor("foo");
		thesaurus5.setCoverage("foo");
		thesaurus5.setCreated(new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31"));
		thesaurus5.setCreator(new ThesaurusOrganization());
		thesaurus5.setDate(new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31"));
		thesaurus5.setDefaultTopConcept(false);
		thesaurus5.setDescription("some text");
		thesaurus5.setFormat(new HashSet<ThesaurusFormat>());
		thesaurus5.setIdentifier("data");
		thesaurus5.setLang(new HashSet<Language>());
		thesaurus5.setPolyHierarchical(false);
		thesaurus5.setPublisher("foo");
		thesaurus5.setRelation("DE");
		thesaurus5.setRights("foo");
		thesaurus5.setSource("foo");
		thesaurus5.setSubject("foo");
		thesaurus5.setTitle("Mr");
		thesaurus5.setType(new ThesaurusType());
		thesaurus5.setVersions(new HashSet<ThesaurusVersionHistory>());
		concept3.setThesaurus(thesaurus5);
		concept3.setTopConcept(false);
		note.setConcept(concept3);
		note.setCreated(new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31"));
		note.setIdentifier("data");
		Language lang6 = new Language();
		lang6.setId("1234");
		lang6.setPart1("foo");
		lang6.setPrincipalLanguage(false);
		lang6.setRefname("root");
		lang6.setTopLanguage(false);
		note.setLanguage(lang6);
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
		ThesaurusConcept concept4 = new ThesaurusConcept();
		concept4.setAssociativeRelationshipLeft(new HashSet<AssociativeRelationship>());
		concept4.setAssociativeRelationshipRight(new HashSet<AssociativeRelationship>());
		concept4.setConceptArrays(new HashSet<ThesaurusArray>());
		concept4.setCreated(new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31"));
		concept4.setIdentifier("data");
		concept4.setModified(new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31"));
		concept4.setNotation("DE");
		concept4.setParentConcepts(new HashSet<ThesaurusConcept>());
		concept4.setRootConcepts(new HashSet<ThesaurusConcept>());
		concept4.setStatus(1);
		concept4.setThesaurus(new Thesaurus());
		concept4.setTopConcept(false);
		termId.setConcept(concept4);
		termId.setCreated(new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31"));
		termId.setHidden(false);
		termId.setIdentifier("data");
		Language language3 = new Language();
		language3.setId("1234");
		language3.setPart1("foo");
		language3.setPrincipalLanguage(false);
		language3.setRefname("root");
		language3.setTopLanguage(false);
		termId.setLanguage(language3);
		termId.setLexicalValue("value");
		termId.setModified(new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31"));
		termId.setPrefered(false);
		ThesaurusTermRole role3 = new ThesaurusTermRole();
		role3.setCode("DE");
		role3.setDefaultRole(false);
		role3.setLabel("label");
		termId.setRole(role3);
		termId.setSource("foo");
		termId.setStatus(1);
		Thesaurus thesaurus7 = new Thesaurus();
		thesaurus7.setArchived(false);
		thesaurus7.setContributor("foo");
		thesaurus7.setCoverage("foo");
		thesaurus7.setCreated(new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31"));
		thesaurus7.setCreator(new ThesaurusOrganization());
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
		thesaurus7.setType(new ThesaurusType());
		thesaurus7.setVersions(new HashSet<ThesaurusVersionHistory>());
		termId.setThesaurus(thesaurus7);
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
		Thesaurus thesaurus8 = new Thesaurus();
		thesaurus8.setArchived(false);
		thesaurus8.setContributor("foo");
		thesaurus8.setCoverage("foo");
		thesaurus8.setCreated(new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31"));
		ThesaurusOrganization creator7 = new ThesaurusOrganization();
		creator7.setEmail("info@diffblue.com");
		creator7.setHomepage("foo");
		creator7.setIdentifier(1);
		creator7.setName("Acme");
		thesaurus8.setCreator(creator7);
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
		ThesaurusType type7 = new ThesaurusType();
		type7.setIdentifier(1);
		type7.setLabel("label");
		thesaurus8.setType(type7);
		thesaurus8.setVersions(new HashSet<ThesaurusVersionHistory>());
		thesaurusConcept.setThesaurus(thesaurus8);
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
