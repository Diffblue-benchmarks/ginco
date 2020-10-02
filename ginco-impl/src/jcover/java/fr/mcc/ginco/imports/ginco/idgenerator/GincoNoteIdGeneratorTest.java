package fr.mcc.ginco.imports.ginco.idgenerator;

import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.when;

import fr.mcc.ginco.beans.Note;
import fr.mcc.ginco.exports.result.bean.JaxbList;

import java.util.HashMap;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
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
	public void getNotesWithNewIdsIdMappingIsEmpty() {
		when(gincoIdMapParser.getNewId(Mockito.<String>any(), Mockito.<java.util.Map<String, String>>any()))
			.thenReturn("1234");
		HashMap<String, JaxbList<Note>> notes =
			 new HashMap<String, JaxbList<Note>>();
		JaxbList<Note> jaxbList1 = new JaxbList<Note>();
		notes.put("foo", jaxbList1);
		assertSame(jaxbList1, service.getNotesWithNewIds(notes, new HashMap<String, String>()).get("1234"));
	}
}
