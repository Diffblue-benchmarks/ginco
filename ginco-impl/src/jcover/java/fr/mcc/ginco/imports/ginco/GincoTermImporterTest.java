package fr.mcc.ginco.imports.ginco;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import fr.mcc.ginco.beans.CustomTermAttribute;
import fr.mcc.ginco.beans.CustomTermAttributeType;
import fr.mcc.ginco.beans.Note;
import fr.mcc.ginco.beans.Thesaurus;
import fr.mcc.ginco.beans.ThesaurusTerm;
import fr.mcc.ginco.dao.INoteDAO;
import fr.mcc.ginco.dao.IThesaurusTermDAO;
import fr.mcc.ginco.exports.result.bean.GincoExportedEntity;
import fr.mcc.ginco.exports.result.bean.JaxbList;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

/**
 * Unit tests for fr.mcc.ginco.imports.ginco.GincoTermImporter
 *
 * @author Diffblue Cover
 */

public class GincoTermImporterTest {

	@Mock(name = "gincoCustomAttributeImporter")
	private GincoCustomAttributeImporter gincoCustomAttributeImporter;

	@Mock(name = "noteDAO")
	private INoteDAO noteDAO;

	@Mock(name = "thesaurusTermDAO")
	private IThesaurusTermDAO thesaurusTermDAO;

	@InjectMocks
	private GincoTermImporter service;

	@Before public void initMocks() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void storeTerms() {

		// arrange
		ThesaurusTerm thesaurusTerm1 = new ThesaurusTerm();
		when(thesaurusTermDAO.update(Mockito.<ThesaurusTerm>any()))
			.thenReturn(thesaurusTerm1);
		GincoExportedEntity exportedThesaurus = new GincoExportedEntity();
		HashMap<String, JaxbList<CustomTermAttribute>> termAttributes =
			 new HashMap<String, JaxbList<CustomTermAttribute>>();
		termAttributes.put("data", new JaxbList<CustomTermAttribute>());
		exportedThesaurus.setTermAttributes(termAttributes);
		ArrayList<ThesaurusTerm> terms = new ArrayList<ThesaurusTerm>();
		ThesaurusTerm thesaurusTerm2 = new ThesaurusTerm();
		thesaurusTerm2.setIdentifier("data");
		terms.add(thesaurusTerm2);
		exportedThesaurus.setTerms(terms);
		HashMap<String, CustomTermAttributeType> savedTypes =
			 new HashMap<String, CustomTermAttributeType>();
		savedTypes.put("", new CustomTermAttributeType());

		// act
		List<ThesaurusTerm> result =
			 service.storeTerms(exportedThesaurus, new Thesaurus(), savedTypes);

		// assert
		assertEquals(1, result.size());
		assertSame(thesaurusTerm1, result.get(0));
		Mockito.verify(gincoCustomAttributeImporter).storeCustomTermAttribute(Mockito.<List<CustomTermAttribute>>any(), Mockito.<ThesaurusTerm>any(), Mockito.<Map<String, CustomTermAttributeType>>any());
	}

	@Test
	public void storeTermsSavedTypesIsEmpty() {

		// arrange
		ThesaurusTerm thesaurusTerm1 = new ThesaurusTerm();
		when(thesaurusTermDAO.update(Mockito.<ThesaurusTerm>any()))
			.thenReturn(thesaurusTerm1);
		GincoExportedEntity exportedThesaurus = new GincoExportedEntity();
		ArrayList<ThesaurusTerm> terms = new ArrayList<ThesaurusTerm>();
		ThesaurusTerm thesaurusTerm2 = new ThesaurusTerm();
		thesaurusTerm2.setIdentifier("data");
		terms.add(thesaurusTerm2);
		exportedThesaurus.setTerms(terms);

		// act
		List<ThesaurusTerm> result =
			 service.storeTerms(exportedThesaurus, new Thesaurus(), new HashMap<String, CustomTermAttributeType>());

		// assert
		assertEquals(1, result.size());
		assertSame(thesaurusTerm1, result.get(0));
	}

	@Test
	public void storeTermNotes() {

		// arrange
		when(thesaurusTermDAO.getById(Mockito.<String>any()))
			.thenReturn(new ThesaurusTerm());
		Note note1 = new Note();
		when(noteDAO.update(Mockito.<Note>any()))
			.thenReturn(note1);
		HashMap<String, JaxbList<Note>> termNotesToImport =
			 new HashMap<String, JaxbList<Note>>();
		ArrayList<Note> list = new ArrayList<Note>();
		list.add(new Note());
		termNotesToImport.put("", new JaxbList<Note>(list));

		// act
		List<Note> result = service.storeTermNotes(termNotesToImport);

		// assert
		assertEquals(1, result.size());
		assertSame(note1, result.get(0));
	}

	@Test
	public void storeTermNotesTermNotesToImportIsEmpty() {
		assertTrue((service.storeTermNotes(new HashMap<String, JaxbList<Note>>())).isEmpty());
	}

	@Test
	public void storeTermNotesTermNotesToImportIsNull() {
		assertTrue((service.storeTermNotes(null)).isEmpty());
	}
}
