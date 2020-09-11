package fr.mcc.ginco.exports.ginco;

import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import fr.mcc.ginco.beans.Alignment;
import fr.mcc.ginco.beans.AssociativeRelationship;
import fr.mcc.ginco.beans.ThesaurusConcept;
import fr.mcc.ginco.dao.IConceptHierarchicalRelationshipDAO;
import fr.mcc.ginco.services.IAlignmentService;
import fr.mcc.ginco.services.IAssociativeRelationshipService;
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
	public void getExportAlignments() {
		List<Alignment> list = new ArrayList<Alignment>();
		when(alignmentService.getAlignmentsBySourceConceptId(Mockito.<String>any()))
			.thenReturn(list);
		assertSame(list, service.getExportAlignments(new ThesaurusConcept()).getList());
	}

	@Test
	public void getExportAssociativeRelationShip() {
		List<AssociativeRelationship> list =
			 new ArrayList<AssociativeRelationship>();
		when(associativeRelationshipService.getAssociatedConceptsRelationships(Mockito.<ThesaurusConcept>any()))
			.thenReturn(list);
		assertSame(list, service.getExportAssociativeRelationShip(new ThesaurusConcept()).getList());
	}

	@Test
	public void getExportHierarchicalConcepts() {
		assertTrue((service.getExportHierarchicalConcepts(new ThesaurusConcept()).getList()).isEmpty());
	}
}