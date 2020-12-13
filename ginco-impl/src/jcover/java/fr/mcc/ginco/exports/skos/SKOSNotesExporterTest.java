package fr.mcc.ginco.exports.skos;

import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.Resource;

import fr.mcc.ginco.beans.Language;
import fr.mcc.ginco.beans.Note;
import fr.mcc.ginco.beans.NoteType;
import fr.mcc.ginco.beans.ThesaurusConcept;
import fr.mcc.ginco.beans.ThesaurusTerm;
import fr.mcc.ginco.services.INoteService;

import java.util.ArrayList;

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
	public void exportNotes() {
		ArrayList<Note> arrayList2 = new ArrayList<Note>();
		Note note = new Note();
		note.setLanguage(new Language());
		note.setNoteType(new NoteType());
		arrayList2.add(note);
		when(noteService.getConceptNotePaginatedList(Mockito.<String>any(), Mockito.<Integer>any(), Mockito.<Integer>any()))
			.thenReturn(arrayList2);
		when(noteService.getTermNotePaginatedList(Mockito.<String>any(), Mockito.<Integer>any(), Mockito.<Integer>any()))
			.thenReturn(new ArrayList<Note>());
		Resource resource = mock(Resource.class);
		Model model = mock(Model.class);
		when(model.createResource(Mockito.<String>any()))
			.thenReturn(resource);
		ArrayList<ThesaurusTerm> prefTerms = new ArrayList<ThesaurusTerm>();
		prefTerms.add(new ThesaurusTerm());
		assertSame(model, service.exportNotes(model, prefTerms, new ThesaurusConcept()));
	}
}
