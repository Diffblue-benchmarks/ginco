package fr.mcc.ginco.audit.csv;

import java.io.BufferedWriter;
import java.io.StringWriter;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

/**
 * Unit tests for fr.mcc.ginco.audit.csv.AuditCSVWriter
 *
 * @author Diffblue Cover
 */

public class AuditCSVWriterTest {

	@InjectMocks
	private AuditCSVWriter service;

	@Before public void initMocks() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void writeJournalLine() throws java.io.IOException {
		JournalLine line = new JournalLine();
		line.setEventType(JournalEventsEnum.THESAURUS_CREATED);
		service.writeJournalLine(line, new BufferedWriter(new StringWriter()));
	}

	@Test
	public void writeHeader() throws java.io.IOException {
		service.writeHeader(new BufferedWriter(new StringWriter()));
	}
}
