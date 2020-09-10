package fr.mcc.ginco.solr;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import fr.mcc.ginco.beans.Language;
import fr.mcc.ginco.beans.Note;
import fr.mcc.ginco.beans.NoteType;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

import org.apache.solr.common.SolrInputDocument;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

/**
 * Unit tests for fr.mcc.ginco.solr.NoteSolrConverter
 *
 * @author Diffblue Cover
 */

public class NoteSolrConverterTest {

	@InjectMocks
	private NoteSolrConverter service;

	@Before public void initMocks() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void convertSolrNote() throws java.text.ParseException {

		// arrange
		Note thesaurusNote = new Note();
		thesaurusNote.setConcept(null);
		thesaurusNote.setCreated(new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31"));
		thesaurusNote.setIdentifier("foo");
		thesaurusNote.setLanguage(new Language());
		thesaurusNote.setLexicalValue("value");
		thesaurusNote.setModified(new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31"));
		thesaurusNote.setNoteType(new NoteType());
		thesaurusNote.setSource("foo");
		thesaurusNote.setTerm(null);

		// act
		SolrInputDocument result = service.convertSolrNote(thesaurusNote);

		// assert
		assertEquals(1.0f, result.get("created").getBoost(), 0);
		assertEquals("created", result.get("created").getName());
		assertEquals(Timestamp.valueOf("2010-12-31 00:00:00.0"), (Timestamp) result.get("created").getValue());
		assertEquals(1.0f, result.get("ext_type").getBoost(), 0);
		assertEquals("ext_type", result.get("ext_type").getName());
		assertEquals(4, (int) (Integer) result.get("ext_type").getValue());
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
		assertEquals(1.0f, result.get("type").getBoost(), 0);
		assertEquals("type", result.get("type").getName());
		assertEquals("Note", (String) result.get("type").getValue());
	}
}
