package fr.mcc.ginco.solr;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import fr.mcc.ginco.beans.Language;
import fr.mcc.ginco.beans.SplitNonPreferredTerm;
import fr.mcc.ginco.beans.Thesaurus;
import fr.mcc.ginco.beans.ThesaurusTerm;

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
		complexConcept.setIdentifier("foo");
		complexConcept.setLanguage(new Language());
		complexConcept.setLexicalValue("value");
		complexConcept.setModified(new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31"));
		complexConcept.setPreferredTerms(new HashSet<ThesaurusTerm>());
		complexConcept.setSource("foo");
		complexConcept.setStatus(1);
		complexConcept.setThesaurus(new Thesaurus());

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
		assertEquals("foo", (String) result.get("identifier").getValue());
		assertEquals(1.0f, result.get("language").getBoost(), 0);
		assertEquals("language", result.get("language").getName());
		assertNull(result.get("language").getValue());
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
		assertNull(result.get("thesaurusId").getValue());
		assertEquals(1.0f, result.get("thesaurusTitle").getBoost(), 0);
		assertEquals("thesaurusTitle", result.get("thesaurusTitle").getName());
		assertNull(result.get("thesaurusTitle").getValue());
		assertEquals(1.0f, result.get("type").getBoost(), 0);
		assertEquals("type", result.get("type").getName());
		assertEquals("SplitNonPreferredTerm", (String) result.get("type").getValue());
	}
}
