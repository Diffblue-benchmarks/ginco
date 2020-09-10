package fr.mcc.ginco.exports.skos;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.when;

import com.hp.hpl.jena.rdf.model.Model;

import fr.mcc.ginco.beans.ThesaurusConcept;
import fr.mcc.ginco.services.IAssociativeRelationshipService;
import fr.mcc.ginco.services.IThesaurusConceptService;

import java.util.ArrayList;
import java.util.HashSet;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

/**
 * Unit tests for fr.mcc.ginco.exports.skos.SKOSAssociativeRelationshipExporter
 *
 * @author Diffblue Cover
 */

public class SKOSAssociativeRelationshipExporterTest {

	@Mock(name = "associativeRelationshipService")
	private IAssociativeRelationshipService associativeRelationshipService;

	@Mock(name = "thesaurusConceptService")
	private IThesaurusConceptService thesaurusConceptService;

	@InjectMocks
	private SKOSAssociativeRelationshipExporter service;

	@Before public void initMocks() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void exportAssociativeRelationshipsDefaultModelIsEmpty() {
		when(thesaurusConceptService.getThesaurusConceptList(Mockito.<java.util.List<String>>any()))
			.thenReturn(new HashSet<ThesaurusConcept>());
		when(associativeRelationshipService.getAssociatedConceptsId(Mockito.<ThesaurusConcept>any()))
			.thenReturn(new ArrayList<String>());
		Model defaultModel = com.hp.hpl.jena.rdf.model.ModelFactory.createDefaultModel();
		assertSame(defaultModel, service.exportAssociativeRelationships(new ThesaurusConcept(), defaultModel));
		assertFalse(defaultModel.isEmpty());
	}
}
