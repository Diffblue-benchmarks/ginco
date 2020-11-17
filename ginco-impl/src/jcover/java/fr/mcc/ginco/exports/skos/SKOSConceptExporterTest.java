package fr.mcc.ginco.exports.skos;

import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.hp.hpl.jena.ontology.DatatypeProperty;
import com.hp.hpl.jena.ontology.OntModel;
import com.hp.hpl.jena.rdf.model.Literal;
import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.Resource;

import fr.mcc.ginco.beans.Thesaurus;
import fr.mcc.ginco.beans.ThesaurusConcept;
import fr.mcc.ginco.beans.ThesaurusTerm;
import fr.mcc.ginco.services.IThesaurusConceptService;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

/**
 * Unit tests for fr.mcc.ginco.exports.skos.SKOSConceptExporter
 *
 * @author Diffblue Cover
 */

public class SKOSConceptExporterTest {

	@Mock(name = "skosAlignmentExporter")
	private SKOSAlignmentExporter skosAlignmentExporter;

	@Mock(name = "skosAssociativeRelationshipExporter")
	private SKOSAssociativeRelationshipExporter skosAssociativeRelationshipExporter;

	@Mock(name = "skosCustomConceptAttributeExporter")
	private SKOSCustomConceptAttributeExporter skosCustomConceptAttributeExporter;

	@Mock(name = "skosHierarchicalRelationshipExporter")
	private SKOSHierarchicalRelationshipExporter skosHierarchicalRelationshipExporter;

	@Mock(name = "skosNotesExporter")
	private SKOSNotesExporter skosNotesExporter;

	@Mock(name = "skosTermsExporter")
	private SKOSTermsExporter skosTermsExporter;

	@Mock(name = "thesaurusConceptService")
	private IThesaurusConceptService thesaurusConceptService;

	@InjectMocks
	private SKOSConceptExporter service;

	@Before public void initMocks() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void exportConceptSKOS() {
		when(thesaurusConceptService.getConceptPreferredTerms(Mockito.<String>any()))
			.thenReturn(new ArrayList<ThesaurusTerm>());
		when(thesaurusConceptService.hasChildren(Mockito.<String>any()))
			.thenReturn(false)
			.thenReturn(false);
		Model model1 = mock(Model.class);
		Model model2 = mock(Model.class);
		when(skosTermsExporter.exportConceptNotPreferredTerms(Mockito.<String>any(), Mockito.<Model>any(), Mockito.<Resource>any()))
			.thenReturn(model1);
		when(skosTermsExporter.exportConceptPreferredTerms(Mockito.<java.util.List<ThesaurusTerm>>any(), Mockito.<Model>any(), Mockito.<Resource>any()))
			.thenReturn(model2);
		Model model3 = mock(Model.class);
		when(skosNotesExporter.exportNotes(Mockito.<Model>any(), Mockito.<java.util.List<ThesaurusTerm>>any(), Mockito.<ThesaurusConcept>any()))
			.thenReturn(model3);
		Model model4 = mock(Model.class);
		when(skosHierarchicalRelationshipExporter.exportHierarchicalRelationships(Mockito.<Model>any(), Mockito.<ThesaurusConcept>any(), Mockito.<ThesaurusConcept>any()))
			.thenReturn(model4);
		Model model5 = mock(Model.class);
		when(skosCustomConceptAttributeExporter.exportCustomConceptAttributes(Mockito.<ThesaurusConcept>any(), Mockito.<Model>any(), Mockito.<Resource>any(), Mockito.<OntModel>any()))
			.thenReturn(model5);
		Model model6 = mock(Model.class);
		when(skosAssociativeRelationshipExporter.exportAssociativeRelationships(Mockito.<ThesaurusConcept>any(), Mockito.<Model>any()))
			.thenReturn(model6);
		Model model7 = mock(Model.class);
		when(skosAlignmentExporter.exportAlignments(Mockito.<String>any(), Mockito.<Model>any()))
			.thenReturn(model7);
		ThesaurusConcept concept = new ThesaurusConcept();
		concept.setNotation("DE");
		concept.setStatus(1);
		concept.setThesaurus(new Thesaurus());
		Model model8 = mock(Model.class);
		Model model9 = mock(Model.class);
		Model model10 = mock(Model.class);
		Model model11 = mock(Model.class);
		Model model12 = mock(Model.class);
		Resource resource1 = mock(Resource.class);
		Resource resource2 = mock(Resource.class);
		Model model13 = mock(Model.class);
		when(model13.createResource(Mockito.<String>any()))
			.thenReturn(resource1);
		when(model13.add(Mockito.<Resource>any(), Mockito.<com.hp.hpl.jena.rdf.model.Property>any(), Mockito.<com.hp.hpl.jena.rdf.model.RDFNode>any()))
			.thenReturn(model12);
		when(model13.add(Mockito.<Resource>any(), Mockito.<com.hp.hpl.jena.rdf.model.Property>any(), Mockito.<String>any()))
			.thenReturn(model11)
			.thenReturn(model10)
			.thenReturn(model9)
			.thenReturn(model8);
		when(model13.createResource(Mockito.<String>any(), Mockito.<Resource>any()))
			.thenReturn(resource2);
		Literal literal = mock(Literal.class);
		DatatypeProperty datatypeProperty = mock(DatatypeProperty.class);
		OntModel ontModel = mock(OntModel.class);
		when(ontModel.createDatatypeProperty(Mockito.<String>any()))
			.thenReturn(datatypeProperty);
		when(ontModel.createLiteral(Mockito.<String>any()))
			.thenReturn(literal);
		assertSame(model13, service.exportConceptSKOS(concept, new ThesaurusConcept(), model13, ontModel));
		Mockito.verify(datatypeProperty).addLabel(Mockito.<Literal>any());
	}
}