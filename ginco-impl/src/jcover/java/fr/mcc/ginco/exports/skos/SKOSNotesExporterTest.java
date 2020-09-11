package fr.mcc.ginco.exports.skos;

import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.when;

import com.hp.hpl.jena.rdf.model.Model;

import fr.mcc.ginco.beans.Language;
import fr.mcc.ginco.beans.Note;
import fr.mcc.ginco.beans.NoteType;
import fr.mcc.ginco.beans.ThesaurusConcept;
import fr.mcc.ginco.beans.ThesaurusTerm;
import fr.mcc.ginco.services.INoteService;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

/**
 * Unit tests for fr.mcc.ginco.exports.skos.SKOSNotesExporter
 *
 * @author Diffblue Cover
 */

public class SKOSNotesExporterTest {

	@Mock(name = "noteService")
	private INoteService noteService;

	@InjectMocks
	private SKOSNotesExporter service;

	@Before public void initMocks() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void exportNotes1() {
		List<Note> list = new ArrayList<Note>();
		Note note = new Note();
		note.setLanguage(new Language());
		note.setNoteType(new NoteType());
		list.add(note);
		when(noteService.getConceptNotePaginatedList(Mockito.<String>any(), Mockito.<Integer>any(), Mockito.<Integer>any()))
			.thenReturn(list);
		Model model = com.hp.hpl.jena.rdf.model.ModelFactory.createDefaultModel();
		assertSame(model, service.exportNotes(model, new ArrayList<ThesaurusTerm>(), new ThesaurusConcept()));
	}

	@Test
	public void exportNotes2() {
		when(noteService.getConceptNotePaginatedList(Mockito.<String>any(), Mockito.<Integer>any(), Mockito.<Integer>any()))
			.thenReturn(new ArrayList<Note>());
		Model model = com.hp.hpl.jena.rdf.model.ModelFactory.createDefaultModel();
		assertSame(model, service.exportNotes(model, new ArrayList<ThesaurusTerm>(), new ThesaurusConcept()));
	}
}
