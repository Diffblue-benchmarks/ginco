package fr.mcc.ginco.exports.skos;

import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.Property;
import com.hp.hpl.jena.rdf.model.Resource;

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
		Model model1 = mock(Model.class);
		Property property1 = mock(Property.class);
		Model model2 = mock(Model.class);
		Model model3 = mock(Model.class);
		Property property2 = mock(Property.class);
		Model model4 = mock(Model.class);
		Resource resource1 = mock(Resource.class);
		when(resource1.getURI())
			.thenReturn("/some/path.html")
			.thenReturn("/some/path.html");
		Resource resource2 = mock(Resource.class);
		when(resource2.getURI())
			.thenReturn("/some/path.html")
			.thenReturn("/some/path.html");
		Model model5 = mock(Model.class);
		when(model5.createResource(Mockito.<String>any()))
			.thenReturn(resource2)
			.thenReturn(resource1);
		when(model5.add(Mockito.<Resource>any(), Mockito.<Property>any(), Mockito.<com.hp.hpl.jena.rdf.model.RDFNode>any()))
			.thenReturn(model4)
			.thenReturn(model3);
		assertSame(model5, service.exportHierarchicalRelationships(model5, new ThesaurusConcept(), new ThesaurusConcept()));
	}

	@Test
	public void exportHierarchicalRelationships2() {
		ConceptHierarchicalRelationship conceptHierarchicalRelationship =
			 new ConceptHierarchicalRelationship();
		conceptHierarchicalRelationship.setRole(1);
		when(conceptHierarchicalRelationshipService.getByChildAndParentIds(Mockito.<String>any(), Mockito.<String>any()))
			.thenReturn(conceptHierarchicalRelationship);
		Model model1 = mock(Model.class);
		Property property1 = mock(Property.class);
		Model model2 = mock(Model.class);
		Model model3 = mock(Model.class);
		Property property2 = mock(Property.class);
		Model model4 = mock(Model.class);
		Resource resource1 = mock(Resource.class);
		when(resource1.getURI())
			.thenReturn("/some/path.html")
			.thenReturn("/some/path.html");
		Resource resource2 = mock(Resource.class);
		when(resource2.getURI())
			.thenReturn("/some/path.html")
			.thenReturn("/some/path.html");
		Model model5 = mock(Model.class);
		when(model5.createResource(Mockito.<String>any()))
			.thenReturn(resource2)
			.thenReturn(resource1);
		when(model5.add(Mockito.<Resource>any(), Mockito.<Property>any(), Mockito.<com.hp.hpl.jena.rdf.model.RDFNode>any()))
			.thenReturn(model4)
			.thenReturn(model3)
			.thenReturn(model2)
			.thenReturn(model1);
		when(model5.createProperty(Mockito.<String>any()))
			.thenReturn(property2)
			.thenReturn(property1);
		assertSame(model5, service.exportHierarchicalRelationships(model5, new ThesaurusConcept(), new ThesaurusConcept()));
	}

	@Test
	public void exportHierarchicalRelationshipsParentConceptIsNull() {
		Model model1 = mock(Model.class);
		Property property1 = mock(Property.class);
		Model model2 = mock(Model.class);
		Model model3 = mock(Model.class);
		Property property2 = mock(Property.class);
		Model model4 = mock(Model.class);
		Resource resource1 = mock(Resource.class);
		Resource resource2 = mock(Resource.class);
		Model model5 = mock(Model.class);
		when(model5.createResource(Mockito.<String>any()))
			.thenReturn(resource2)
			.thenReturn(resource1);
		when(model5.add(Mockito.<Resource>any(), Mockito.<Property>any(), Mockito.<com.hp.hpl.jena.rdf.model.RDFNode>any()))
			.thenReturn(model4);
		ThesaurusConcept childConcept = new ThesaurusConcept();
		childConcept.setThesaurus(new Thesaurus());
		assertSame(model5, service.exportHierarchicalRelationships(model5, null, childConcept));
	}
}
