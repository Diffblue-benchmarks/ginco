package fr.mcc.ginco.exports.ginco;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import fr.mcc.ginco.beans.Alignment;
import fr.mcc.ginco.beans.AssociativeRelationship;
import fr.mcc.ginco.beans.Note;
import fr.mcc.ginco.beans.ThesaurusConcept;
import fr.mcc.ginco.dao.IConceptHierarchicalRelationshipDAO;
import fr.mcc.ginco.exports.result.bean.JaxbList;
import fr.mcc.ginco.services.IAlignmentService;
import fr.mcc.ginco.services.IAssociativeRelationshipService;
import fr.mcc.ginco.services.INoteService;

import java.util.ArrayList;
import java.util.HashSet;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

/**
 * Unit tests for fr.mcc.ginco.exports.ginco.GincoConceptExporter
 *
 * @author Diffblue Cover
 */

public class GincoConceptExporterTest {

	@Mock(name = "alignmentService")
	private IAlignmentService alignmentService;

	@Mock(name = "associativeRelationshipService")
	private IAssociativeRelationshipService associativeRelationshipService;

	@Mock(name = "conceptHierarchicalRelationshipDAO")
	private IConceptHierarchicalRelationshipDAO conceptHierarchicalRelationshipDAO;

	@Mock(name = "noteService")
	private INoteService noteService;

	@InjectMocks
	private GincoConceptExporter service;

	@Before public void initMocks() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void getExportConceptNotes() {

		// arrange
		ArrayList<Note> arrayList = new ArrayList<Note>();
		Note note = new Note();
		arrayList.add(note);
		when(noteService.getConceptNoteCount(Mockito.<String>any()))
			.thenReturn(1L);
		when(noteService.getConceptNotePaginatedList(Mockito.<String>any(), Mockito.<Integer>any(), Mockito.<Integer>any()))
			.thenReturn(arrayList);

		// act
		JaxbList<Note> result =
			 service.getExportConceptNotes(new ThesaurusConcept());

		// assert
		assertEquals(1, result.getList().size());
		assertSame(note, result.getList().get(0));
	}

	@Test
	public void getExportHierarchicalConcepts() {
		ThesaurusConcept thesaurusConcept = mock(ThesaurusConcept.class);
		when(thesaurusConcept.getParentConcepts())
			.thenReturn(new HashSet<ThesaurusConcept>());
		assertTrue((service.getExportHierarchicalConcepts(thesaurusConcept).getList()).isEmpty());
	}

	@Test
	public void getExportAssociativeRelationShip() {

		// arrange
		ArrayList<AssociativeRelationship> arrayList =
			 new ArrayList<AssociativeRelationship>();
		AssociativeRelationship associativeRelationship =
			 new AssociativeRelationship();
		arrayList.add(associativeRelationship);
		when(associativeRelationshipService.getAssociatedConceptsRelationships(Mockito.<ThesaurusConcept>any()))
			.thenReturn(arrayList);

		// act
		JaxbList<AssociativeRelationship> result =
			 service.getExportAssociativeRelationShip(new ThesaurusConcept());

		// assert
		assertEquals(1, result.getList().size());
		assertSame(associativeRelationship, result.getList().get(0));
	}

	@Test
	public void getExportAlignments() {

		// arrange
		ArrayList<Alignment> arrayList = new ArrayList<Alignment>();
		Alignment alignment = new Alignment();
		arrayList.add(alignment);
		when(alignmentService.getAlignmentsBySourceConceptId(Mockito.<String>any()))
			.thenReturn(arrayList);

		// act
		JaxbList<Alignment> result =
			 service.getExportAlignments(new ThesaurusConcept());

		// assert
		assertEquals(1, result.getList().size());
		assertSame(alignment, result.getList().get(0));
	}
}
