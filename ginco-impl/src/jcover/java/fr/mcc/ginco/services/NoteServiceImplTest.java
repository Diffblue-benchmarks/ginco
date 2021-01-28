package fr.mcc.ginco.services;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.when;

import fr.mcc.ginco.beans.Language;
import fr.mcc.ginco.beans.Note;
import fr.mcc.ginco.beans.NoteType;
import fr.mcc.ginco.beans.ThesaurusConcept;
import fr.mcc.ginco.beans.ThesaurusTerm;
import fr.mcc.ginco.dao.INoteDAO;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
	public void getConceptNotePaginatedListLimitIsOneAndStartIndexIsOne() {

		// arrange
		ArrayList<Note> noteList = new ArrayList<Note>();
		Note note = new Note();
		noteList.add(note);
		when(noteDAO.findConceptPaginatedNotes(Mockito.<String>any(), Mockito.<Integer>any(), Mockito.<Integer>any()))
			.thenReturn(noteList);

		// act
		List<Note> result = service.getConceptNotePaginatedList("1234", 1, 1);

		// assert
		assertEquals(1, result.size());
		assertSame(note, result.get(0));
	}

	@Test
	public void getTermNotePaginatedListLimitIsOneAndStartIndexIsOne() {

		// arrange
		ArrayList<Note> noteList = new ArrayList<Note>();
		Note note = new Note();
		noteList.add(note);
		when(noteDAO.findTermPaginatedNotes(Mockito.<String>any(), Mockito.<Integer>any(), Mockito.<Integer>any()))
			.thenReturn(noteList);

		// act
		List<Note> result = service.getTermNotePaginatedList("1234", 1, 1);

		// assert
		assertEquals(1, result.size());
		assertSame(note, result.get(0));
	}

	@Test
	public void getNoteById() throws java.text.ParseException {

		// arrange
		Note note = new Note();
		ThesaurusConcept concept1 = new ThesaurusConcept();
		note.setConcept(concept1);
		Date created3 = new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31");
		note.setCreated(created3);
		note.setIdentifier("data");
		Language lang2 = new Language();
		note.setLanguage(lang2);
		note.setLexicalValue("value");
		Date modified2 = new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31");
		note.setModified(modified2);
		NoteType noteType = new NoteType();
		note.setNoteType(noteType);
		note.setSource("foo");
		ThesaurusTerm termId = new ThesaurusTerm();
		note.setTerm(termId);
		when(noteDAO.getById(Mockito.<String>any()))
			.thenReturn(note);

		// act
		Note result = service.getNoteById("1234");

		// assert
		assertSame(concept1, result.getConcept());
		assertSame(created3, result.getCreated());
		assertEquals("data", result.getIdentifier());
		assertSame(lang2, result.getLanguage());
		assertEquals("value", result.getLexicalValue());
		assertSame(modified2, result.getModified());
		assertSame(noteType, result.getNoteType());
		assertEquals("foo", result.getSource());
		assertSame(termId, result.getTerm());
	}

	@Test
	public void createOrUpdateNote() throws java.text.ParseException {

		// arrange
		Note note1 = new Note();
		ThesaurusConcept concept1 = new ThesaurusConcept();
		note1.setConcept(concept1);
		Date created3 = new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31");
		note1.setCreated(created3);
		note1.setIdentifier("data");
		Language lang2 = new Language();
		note1.setLanguage(lang2);
		note1.setLexicalValue("value");
		Date modified2 = new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31");
		note1.setModified(modified2);
		NoteType noteType1 = new NoteType();
		note1.setNoteType(noteType1);
		note1.setSource("foo");
		ThesaurusTerm termId1 = new ThesaurusTerm();
		note1.setTerm(termId1);
		when(noteDAO.update(Mockito.<Note>any()))
			.thenReturn(note1);

		// act
		Note result = service.createOrUpdateNote(new Note());

		// assert
		assertSame(concept1, result.getConcept());
		assertSame(created3, result.getCreated());
		assertEquals("data", result.getIdentifier());
		assertSame(lang2, result.getLanguage());
		assertEquals("value", result.getLexicalValue());
		assertSame(modified2, result.getModified());
		assertSame(noteType1, result.getNoteType());
		assertEquals("foo", result.getSource());
		assertSame(termId1, result.getTerm());
	}

	@Test
	public void deleteNote() throws java.text.ParseException {

		// arrange
		Note note1 = new Note();
		ThesaurusConcept concept1 = new ThesaurusConcept();
		note1.setConcept(concept1);
		Date created3 = new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31");
		note1.setCreated(created3);
		note1.setIdentifier("data");
		Language lang2 = new Language();
		note1.setLanguage(lang2);
		note1.setLexicalValue("value");
		Date modified2 = new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31");
		note1.setModified(modified2);
		NoteType noteType1 = new NoteType();
		note1.setNoteType(noteType1);
		note1.setSource("foo");
		ThesaurusTerm termId1 = new ThesaurusTerm();
		note1.setTerm(termId1);
		when(noteDAO.delete(Mockito.<Note>any()))
			.thenReturn(note1);

		// act
		Note result = service.deleteNote(new Note());

		// assert
		assertSame(concept1, result.getConcept());
		assertSame(created3, result.getCreated());
		assertEquals("data", result.getIdentifier());
		assertSame(lang2, result.getLanguage());
		assertEquals("value", result.getLexicalValue());
		assertSame(modified2, result.getModified());
		assertSame(noteType1, result.getNoteType());
		assertEquals("foo", result.getSource());
		assertSame(termId1, result.getTerm());
	}

	@Test
	public void getConceptNoteCountReturnsOne() {
		when(noteDAO.getConceptNoteCount(Mockito.<String>any()))
			.thenReturn(1L);
		assertEquals(1L, (long) service.getConceptNoteCount("1234"));
	}

	@Test
	public void getTermNoteCountReturnsOne() {
		when(noteDAO.getTermNoteCount(Mockito.<String>any()))
			.thenReturn(1L);
		assertEquals(1L, (long) service.getTermNoteCount("1234"));
	}

	@Test
	public void getAllNotes() {

		// arrange
		ArrayList<Note> noteList = new ArrayList<Note>();
		Note note = new Note();
		noteList.add(note);
		when(noteDAO.findAll())
			.thenReturn(noteList);

		// act
		List<Note> result = service.getAllNotes();

		// assert
		assertEquals(1, result.size());
		assertSame(note, result.get(0));
	}

	@Test
	public void getNotesByThesaurusId() {

		// arrange
		ArrayList<Note> noteList = new ArrayList<Note>();
		Note note = new Note();
		noteList.add(note);
		when(noteDAO.findNotesByThesaurusId(Mockito.<String>any()))
			.thenReturn(noteList);

		// act
		List<Note> result = service.getNotesByThesaurusId("1234");

		// assert
		assertEquals(1, result.size());
		assertSame(note, result.get(0));
	}
}
