package fr.mcc.ginco.exports.skos;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.when;

import com.hp.hpl.jena.rdf.model.Model;

import fr.mcc.ginco.beans.ConceptHierarchicalRelationship;
import fr.mcc.ginco.beans.Thesaurus;
import fr.mcc.ginco.beans.ThesaurusConcept;
import fr.mcc.ginco.services.IConceptHierarchicalRelationshipService;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

/**
 * Unit tests for fr.mcc.ginco.exports.skos.SKOSHierarchicalRelationshipExporter
 *
 * @author Diffblue Cover
 */

public class SKOSHierarchicalRelationshipExporterTest {

	@Mock(name = "conceptHierarchicalRelationshipService")
	private IConceptHierarchicalRelationshipService conceptHierarchicalRelationshipService;

	@InjectMocks
	private SKOSHierarchicalRelationshipExporter service;

	@Before public void initMocks() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void exportHierarchicalRelationships1() {
		ConceptHierarchicalRelationship conceptHierarchicalRelationship =
			 new ConceptHierarchicalRelationship();
		conceptHierarchicalRelationship.setRole(0);
		when(conceptHierarchicalRelationshipService.getByChildAndParentIds(Mockito.<String>any(), Mockito.<String>any()))
			.thenReturn(conceptHierarchicalRelationship);
		Model model = com.hp.hpl.jena.rdf.model.ModelFactory.createDefaultModel();
		assertSame(model, service.exportHierarchicalRelationships(model, new ThesaurusConcept(), new ThesaurusConcept()));
		assertFalse(model.isEmpty());
	}

	@Test
	public void exportHierarchicalRelationships2() {
		ConceptHierarchicalRelationship conceptHierarchicalRelationship =
			 new ConceptHierarchicalRelationship();
		conceptHierarchicalRelationship.setRole(1);
		when(conceptHierarchicalRelationshipService.getByChildAndParentIds(Mockito.<String>any(), Mockito.<String>any()))
			.thenReturn(conceptHierarchicalRelationship);
		Model model = com.hp.hpl.jena.rdf.model.ModelFactory.createDefaultModel();
		assertSame(model, service.exportHierarchicalRelationships(model, new ThesaurusConcept(), new ThesaurusConcept()));
		assertFalse(model.isEmpty());
	}

	@Test
	public void exportHierarchicalRelationshipsParentConceptIsNull() {
		Model model = com.hp.hpl.jena.rdf.model.ModelFactory.createDefaultModel();
		ThesaurusConcept childConcept = new ThesaurusConcept();
		childConcept.setThesaurus(new Thesaurus());
		assertSame(model, service.exportHierarchicalRelationships(model, null, childConcept));
		assertFalse(model.isEmpty());
	}
}
