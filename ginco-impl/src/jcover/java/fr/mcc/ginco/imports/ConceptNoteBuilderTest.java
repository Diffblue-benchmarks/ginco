package fr.mcc.ginco.imports;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import fr.mcc.ginco.ark.IIDGeneratorService;
import fr.mcc.ginco.beans.NoteType;
import fr.mcc.ginco.beans.Thesaurus;
import fr.mcc.ginco.beans.ThesaurusConcept;
import fr.mcc.ginco.beans.ThesaurusTerm;
import fr.mcc.ginco.dao.ILanguageDAO;
import fr.mcc.ginco.services.INoteTypeService;
import fr.mcc.ginco.skos.namespaces.GINCO;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

/**
 * Unit tests for fr.mcc.ginco.imports.ConceptNoteBuilder
 *
 * @author Diffblue Cover
 */

public class ConceptNoteBuilderTest {

	@Mock(name = "generatorService")
	private IIDGeneratorService generatorService;

	@Mock(name = "languagesDAO")
	private ILanguageDAO languagesDAO;

	@Mock(name = "noteTypeService")
	private INoteTypeService noteTypeService;

	@InjectMocks
	private ConceptNoteBuilder service;

	@Before public void initMocks() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void buildConceptNotes1() {
		List<NoteType> list = new ArrayList<NoteType>();
		list.add(new NoteType());
		when(noteTypeService.getConceptNoteTypeList())
			.thenReturn(list);
		assertTrue((service.buildConceptNotes(GINCO.getResource("BASIC"), new ThesaurusConcept(), new ThesaurusTerm(), new Thesaurus())).isEmpty());
	}

	@Test
	public void buildConceptNotes2() {
		when(noteTypeService.getConceptNoteTypeList())
			.thenReturn(new ArrayList<NoteType>());
		assertTrue((service.buildConceptNotes(GINCO.getResource("BASIC"), new ThesaurusConcept(), new ThesaurusTerm(), new Thesaurus())).isEmpty());
	}
}
