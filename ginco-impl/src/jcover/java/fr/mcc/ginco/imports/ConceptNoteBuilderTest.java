package fr.mcc.ginco.imports;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.hp.hpl.jena.rdf.model.Resource;
import com.hp.hpl.jena.rdf.model.StmtIterator;

import fr.mcc.ginco.ark.IIDGeneratorService;
import fr.mcc.ginco.beans.NoteType;
import fr.mcc.ginco.beans.Thesaurus;
import fr.mcc.ginco.beans.ThesaurusConcept;
import fr.mcc.ginco.beans.ThesaurusTerm;
import fr.mcc.ginco.dao.ILanguageDAO;
import fr.mcc.ginco.services.INoteTypeService;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
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
	public void buildConceptNotesReturnsEmpty() throws java.util.NoSuchElementException {
		List<NoteType> list = new ArrayList<NoteType>();
		list.add(new NoteType());
		when(noteTypeService.getConceptNoteTypeList())
			.thenReturn(list);
		StmtIterator stmtIterator = mock(StmtIterator.class);
		when(stmtIterator.hasNext())
			.thenReturn(false);
		Resource skosConcept = mock(Resource.class);
		when(skosConcept.getURI())
			.thenReturn("/some/path.html");
		when(skosConcept.listProperties(Mockito.<com.hp.hpl.jena.rdf.model.Property>any()))
			.thenReturn(stmtIterator);
		ThesaurusConcept concept1 = mock(ThesaurusConcept.class);
		assertTrue((service.buildConceptNotes(skosConcept, concept1, new ThesaurusTerm(), new Thesaurus())).isEmpty());
	}
}
