package fr.mcc.ginco.imports.ginco.idgenerator;

import static org.junit.Assert.assertTrue;

import fr.mcc.ginco.beans.Note;
import fr.mcc.ginco.exports.result.bean.JaxbList;

import java.util.HashMap;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

/**
 * Unit tests for fr.mcc.ginco.imports.ginco.idgenerator.GincoNoteIdGenerator
 *
 * @author Diffblue Cover
 */

public class GincoNoteIdGeneratorTest {

	@Mock(name = "gincoIdMapParser")
	private GincoIdMapParser gincoIdMapParser;

	@InjectMocks
	private GincoNoteIdGenerator service;

	@Before public void initMocks() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void getNotesWithNewIdsReturnsEmpty() throws java.io.IOException, CloneNotSupportedException {
		assertTrue(service.getNotesWithNewIds(new HashMap<String, JaxbList<Note>>(), new HashMap<String, String>()).isEmpty());
	}
}
