package fr.mcc.ginco.audit.csv;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;

import org.junit.Test;

/**
 * Unit tests for fr.mcc.ginco.audit.csv.JournalLine
 *
 * @author Diffblue Cover
 */

public class JournalLineTest {

	@Test
	public void factory() throws java.text.ParseException {
		JournalLine journalLine = new JournalLine();
		journalLine.setAuthorId("1234");
		journalLine.setConceptId("1234");
		Date eventDate = new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31");
		journalLine.setEventDate(eventDate);
		journalLine.setEventType(JournalEventsEnum.THESAURUS_CREATED);
		journalLine.setNewGenericTerm(new HashSet<String>());
		journalLine.setNewLexicalValue("value");
		journalLine.setOldGenericTerm(new HashSet<String>());
		journalLine.setOldLexicalValue("value");
		journalLine.setRevisionNumber(1);
		journalLine.setStatus(1);
		journalLine.setTermId("1234");
		journalLine.setTermRole("admin");
		assertEquals("1234", journalLine.getAuthorId());
		assertEquals("1234", journalLine.getConceptId());
		assertSame(eventDate, journalLine.getEventDate());
		assertTrue(JournalEventsEnum.THESAURUS_CREATED == journalLine.getEventType());
		assertTrue(journalLine.getNewGenericTerm().isEmpty());
		assertEquals("value", journalLine.getNewLexicalValue());
		assertTrue(journalLine.getOldGenericTerm().isEmpty());
		assertEquals("value", journalLine.getOldLexicalValue());
		assertEquals(1, (int) journalLine.getRevisionNumber());
		assertEquals(1, (int) journalLine.getStatus());
		assertEquals("1234", journalLine.getTermId());
		assertEquals("admin", journalLine.getTermRole());
	}

	@Test
	public void compareToReturnsOne() {
		JournalLine journalLine = new JournalLine();
		journalLine.setRevisionNumber(1);
		JournalLine o = new JournalLine();
		o.setRevisionNumber(0);
		assertEquals(1, journalLine.compareTo(o));
	}

	@Test
	public void compareToReturnsZero() throws java.text.ParseException {
		JournalLine journalLine = new JournalLine();
		journalLine.setEventDate(new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31"));
		journalLine.setEventType(JournalEventsEnum.THESAURUS_CREATED);
		journalLine.setRevisionNumber(1);
		JournalLine o = new JournalLine();
		o.setEventDate(new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31"));
		o.setEventType(JournalEventsEnum.THESAURUS_CREATED);
		o.setRevisionNumber(1);
		assertEquals(0, journalLine.compareTo(o));
	}
}
