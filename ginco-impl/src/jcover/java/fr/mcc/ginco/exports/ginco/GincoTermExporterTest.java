package fr.mcc.ginco.exports.ginco;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.when;

import fr.mcc.ginco.beans.CustomTermAttribute;
import fr.mcc.ginco.beans.Note;
import fr.mcc.ginco.beans.ThesaurusTerm;
import fr.mcc.ginco.exports.result.bean.GincoExportedEntity;
import fr.mcc.ginco.exports.result.bean.JaxbList;
import fr.mcc.ginco.services.INoteService;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

/**
 * Unit tests for fr.mcc.ginco.exports.ginco.GincoTermExporter
 *
 * @author Diffblue Cover
 */

public class GincoTermExporterTest {

	@Mock(name = "gincoAttributesExporter")
	private GincoAttributesExporter gincoAttributesExporter;

	@Mock(name = "noteService")
	private INoteService noteService;

	@InjectMocks
	private GincoTermExporter service;

	@Before public void initMocks() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void getExportTermNotes() {

		// arrange
		ArrayList<Note> noteList = new ArrayList<Note>();
		Note note = new Note();
		noteList.add(note);
		when(noteService.getTermNoteCount(Mockito.<String>any()))
			.thenReturn(1L);
		when(noteService.getTermNotePaginatedList(Mockito.<String>any(), Mockito.<Integer>any(), Mockito.<Integer>any()))
			.thenReturn(noteList);

		// act
		JaxbList<Note> result = service.getExportTermNotes(new ThesaurusTerm());

		// assert
		assertEquals(1, result.getList().size());
		assertSame(note, result.getList().get(0));
	}

	@Test
	public void addExportedTerms1() {
		ArrayList<CustomTermAttribute> list1 = new ArrayList<CustomTermAttribute>();
		list1.add(new CustomTermAttribute());
		JaxbList<CustomTermAttribute> jaxbList1 =
			 new JaxbList<CustomTermAttribute>(list1);
		when(gincoAttributesExporter.getExportedTermAttributes(Mockito.<ThesaurusTerm>any()))
			.thenReturn(jaxbList1);
		GincoExportedEntity thesaurusToExport = new GincoExportedEntity();
		ArrayList<ThesaurusTerm> terms = new ArrayList<ThesaurusTerm>();
		terms.add(new ThesaurusTerm());
		thesaurusToExport.setTerms(terms);
		ThesaurusTerm term = new ThesaurusTerm();
		term.setIdentifier("data");
		assertSame(thesaurusToExport, service.addExportedTerms(thesaurusToExport, term));
		assertSame(jaxbList1, thesaurusToExport.getTermAttributes().get("data"));
		assertEquals(2, thesaurusToExport.getTerms().size());
		assertSame(term, thesaurusToExport.getTerms().get(1));
	}

	@Test
	public void addExportedTerms2() {
		when(gincoAttributesExporter.getExportedTermAttributes(Mockito.<ThesaurusTerm>any()))
			.thenReturn(new JaxbList<CustomTermAttribute>());
		GincoExportedEntity thesaurusToExport = new GincoExportedEntity();
		ArrayList<ThesaurusTerm> terms = new ArrayList<ThesaurusTerm>();
		terms.add(new ThesaurusTerm());
		thesaurusToExport.setTerms(terms);
		ThesaurusTerm term = new ThesaurusTerm();
		assertSame(thesaurusToExport, service.addExportedTerms(thesaurusToExport, term));
		assertEquals(2, thesaurusToExport.getTerms().size());
		assertSame(term, thesaurusToExport.getTerms().get(1));
	}
}
