package fr.mcc.ginco.solr;

import static org.junit.Assert.assertEquals;

import fr.mcc.ginco.beans.Language;
import fr.mcc.ginco.beans.SplitNonPreferredTerm;
import fr.mcc.ginco.beans.Thesaurus;
import fr.mcc.ginco.beans.ThesaurusFormat;
import fr.mcc.ginco.beans.ThesaurusOrganization;
import fr.mcc.ginco.beans.ThesaurusTerm;
import fr.mcc.ginco.beans.ThesaurusType;
import fr.mcc.ginco.beans.ThesaurusVersionHistory;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.HashSet;

import org.apache.solr.common.SolrInputDocument;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

/**
 * Unit tests for fr.mcc.ginco.solr.ComplexConceptSolrConverter
 *
 * @author Diffblue Cover
 */

public class ComplexConceptSolrConverterTest {

	@InjectMocks
	private ComplexConceptSolrConverter service;

	@Before public void initMocks() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void convertSolrComplexConcept() throws java.text.ParseException {

		// arrange
		SplitNonPreferredTerm complexConcept = new SplitNonPreferredTerm();
		complexConcept.setCreated(new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31"));
		complexConcept.setIdentifier("data");
		Language language = new Language();
		language.setId("1234");
		language.setPart1("foo");
		language.setPrincipalLanguage(false);
		language.setRefname("foo");
		language.setTopLanguage(false);
		complexConcept.setLanguage(language);
		complexConcept.setLexicalValue("value");
		complexConcept.setModified(new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31"));
		complexConcept.setPreferredTerms(new HashSet<ThesaurusTerm>());
		complexConcept.setSource("foo");
		complexConcept.setStatus(1);
		Thesaurus thesaurus = new Thesaurus();
		thesaurus.setArchived(false);
		thesaurus.setContributor("foo");
		thesaurus.setCoverage("foo");
		thesaurus.setCreated(new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31"));
		ThesaurusOrganization creator = new ThesaurusOrganization();
		creator.setEmail("info@diffblue.com");
		creator.setHomepage("foo");
		creator.setIdentifier(1);
		creator.setName("Acme");
		thesaurus.setCreator(creator);
		thesaurus.setDate(new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31"));
		thesaurus.setDefaultTopConcept(false);
		thesaurus.setDescription("some text");
		thesaurus.setFormat(new HashSet<ThesaurusFormat>());
		thesaurus.setIdentifier("data");
		thesaurus.setLang(new HashSet<Language>());
		thesaurus.setPolyHierarchical(false);
		thesaurus.setPublisher("foo");
		thesaurus.setRelation("DE");
		thesaurus.setRights("foo");
		thesaurus.setSource("foo");
		thesaurus.setSubject("foo");
		thesaurus.setTitle("Mr");
		ThesaurusType type = new ThesaurusType();
		type.setIdentifier(1);
		type.setLabel("label");
		thesaurus.setType(type);
		thesaurus.setVersions(new HashSet<ThesaurusVersionHistory>());
		complexConcept.setThesaurus(thesaurus);

		// act
		SolrInputDocument result = service.convertSolrComplexConcept(complexConcept);

		// assert
		assertEquals(1.0f, result.get("created").getBoost(), 0);
		assertEquals("created", result.get("created").getName());
		assertEquals(Timestamp.valueOf("2010-12-31 00:00:00.0"), (Timestamp) result.get("created").getValue());
		assertEquals(1.0f, result.get("ext_type").getBoost(), 0);
		assertEquals("ext_type", result.get("ext_type").getName());
		assertEquals(10, (int) (Integer) result.get("ext_type").getValue());
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
		assertEquals("SplitNonPreferredTerm", (String) result.get("type").getValue());
	}
}
