package fr.mcc.ginco.services;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import fr.mcc.ginco.beans.Note;
import fr.mcc.ginco.dao.INoteDAO;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

/**
 * Unit tests for fr.mcc.ginco.services.NoteServiceImpl
 *
 * @author Diffblue Cover
 */

public class NoteServiceImplTest {

	@Mock(name = "noteDAO")
	private INoteDAO noteDAO;

	@InjectMocks
	private NoteServiceImpl service;

	@Before public void initMocks() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void createOrUpdateNoteReturnsNull() {
		assertNull(service.createOrUpdateNote(new Note()));
	}

	@Test
	public void deleteNoteReturnsNull() {
		assertNull(service.deleteNote(new Note()));
	}

	@Test
	public void getAllNotesReturnsEmpty() {
		assertTrue((service.getAllNotes()).isEmpty());
	}

	@Test
	public void getConceptNoteCountReturnsOne() {
		when(noteDAO.getConceptNoteCount(Mockito.<String>any()))
			.thenReturn(1L);
		assertEquals(1L, (long) service.getConceptNoteCount("1234"));
	}

	@Test
	public void getConceptNotePaginatedListLimitIsOneAndStartIndexIsZeroReturnsEmpty() {
		when(noteDAO.findConceptPaginatedNotes(Mockito.<String>any(), Mockito.<Integer>any(), Mockito.<Integer>any()))
			.thenReturn(new ArrayList<Note>());
		assertTrue((service.getConceptNotePaginatedList("1234", 0, 1)).isEmpty());
	}

	@Test
	public void getNoteByIdReturnsNull() {
		assertNull(service.getNoteById("1234"));
	}

	@Test
	public void getNotesByThesaurusIdReturnsEmpty() {
		when(noteDAO.findNotesByThesaurusId(Mockito.<String>any()))
			.thenReturn(new ArrayList<Note>());
		assertTrue((service.getNotesByThesaurusId("1234")).isEmpty());
	}

	@Test
	public void getTermNoteCountReturnsOne() {
		when(noteDAO.getTermNoteCount(Mockito.<String>any()))
			.thenReturn(1L);
		assertEquals(1L, (long) service.getTermNoteCount("1234"));
	}

	@Test
	public void getTermNotePaginatedListLimitIsOneAndStartIndexIsZeroReturnsEmpty() {
		when(noteDAO.findTermPaginatedNotes(Mockito.<String>any(), Mockito.<Integer>any(), Mockito.<Integer>any()))
			.thenReturn(new ArrayList<Note>());
		assertTrue((service.getTermNotePaginatedList("1234", 0, 1)).isEmpty());
	}
}
