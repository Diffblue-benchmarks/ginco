package fr.mcc.ginco.solr;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import fr.mcc.ginco.beans.AssociativeRelationship;
import fr.mcc.ginco.beans.Language;
import fr.mcc.ginco.beans.Note;
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
	public void convertSolrTerm() throws java.text.ParseException {

		// arrange
		when(noteService.getTermNotePaginatedList(Mockito.<String>any(), Mockito.<Integer>any(), Mockito.<Integer>any()))
			.thenReturn(new ArrayList<Note>());
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
		Thesaurus thesaurus4 = new Thesaurus();
		thesaurus4.setArchived(false);
		thesaurus4.setContributor("foo");
		thesaurus4.setCoverage("foo");
		thesaurus4.setCreated(new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31"));
		thesaurus4.setDate(new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31"));
		thesaurus4.setDefaultTopConcept(false);
		thesaurus4.setDescription("some text");
		thesaurus4.setIdentifier("data");
		thesaurus4.setPolyHierarchical(false);
		thesaurus4.setPublisher("foo");
		thesaurus4.setRelation("DE");
		thesaurus4.setRights("foo");
		thesaurus4.setSource("foo");
		thesaurus4.setSubject("foo");
		thesaurus4.setTitle("Mr");
		concept3.setThesaurus(thesaurus4);
		concept3.setTopConcept(false);
		thesaurusTerm.setConcept(concept3);
		thesaurusTerm.setCreated(new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31"));
		thesaurusTerm.setHidden(false);
		thesaurusTerm.setIdentifier("data");
		Language language2 = new Language();
		language2.setId("1234");
		language2.setPart1("foo");
		language2.setPrincipalLanguage(false);
		language2.setRefname("foo");
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
		Thesaurus thesaurus5 = new Thesaurus();
		thesaurus5.setArchived(false);
		thesaurus5.setContributor("foo");
		thesaurus5.setCoverage("foo");
		thesaurus5.setCreated(new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31"));
		ThesaurusOrganization creator3 = new ThesaurusOrganization();
		creator3.setEmail("info@diffblue.com");
		creator3.setHomepage("foo");
		creator3.setIdentifier(1);
		creator3.setName("Acme");
		thesaurus5.setCreator(creator3);
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
		ThesaurusType type3 = new ThesaurusType();
		type3.setIdentifier(1);
		type3.setLabel("label");
		thesaurus5.setType(type3);
		thesaurus5.setVersions(new HashSet<ThesaurusVersionHistory>());
		thesaurusTerm.setThesaurus(thesaurus5);

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
}
