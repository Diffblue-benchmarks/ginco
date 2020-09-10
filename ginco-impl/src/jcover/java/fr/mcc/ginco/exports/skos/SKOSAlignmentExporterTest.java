package fr.mcc.ginco.exports.skos;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.when;

import com.hp.hpl.jena.rdf.model.Model;

import fr.mcc.ginco.beans.Alignment;
import fr.mcc.ginco.services.IAlignmentService;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

/**
 * Unit tests for fr.mcc.ginco.exports.skos.SKOSAlignmentExporter
 *
 * @author Diffblue Cover
 */

public class SKOSAlignmentExporterTest {

	@Mock(name = "alignmentService")
	private IAlignmentService alignmentService;

	@InjectMocks
	private SKOSAlignmentExporter service;

	@Before public void initMocks() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void exportAlignmentsDefaultModelIsEmpty() {
		when(alignmentService.getAlignmentsBySourceConceptId(Mockito.<String>any()))
			.thenReturn(new ArrayList<Alignment>());
		Model defaultModel = com.hp.hpl.jena.rdf.model.ModelFactory.createDefaultModel();
		assertSame(defaultModel, service.exportAlignments("1234", defaultModel));
		assertFalse(defaultModel.isEmpty());
	}
}
