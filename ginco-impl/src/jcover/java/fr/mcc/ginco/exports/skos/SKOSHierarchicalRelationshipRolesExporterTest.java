package fr.mcc.ginco.exports.skos;

import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.hp.hpl.jena.ontology.ObjectProperty;
import com.hp.hpl.jena.ontology.OntModel;
import com.hp.hpl.jena.rdf.model.Literal;
import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.Resource;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

/**
 * Unit tests for fr.mcc.ginco.exports.skos.SKOSHierarchicalRelationshipRolesExporter
 *
 * @author Diffblue Cover
 */

public class SKOSHierarchicalRelationshipRolesExporterTest {

	@InjectMocks
	private SKOSHierarchicalRelationshipRolesExporter service;

	@Before public void initMocks() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void exportHierarchicalRelationshipRoles() {
		Model model1 = mock(Model.class);
		Model model2 = mock(Model.class);
		when(model2.add(Mockito.<Model>any()))
			.thenReturn(model1);
		Literal literal1 = mock(Literal.class);
		Resource resource1 = mock(Resource.class);
		Resource resource2 = mock(Resource.class);
		ObjectProperty objectProperty1 = mock(ObjectProperty.class);
		when(objectProperty1.addProperty(Mockito.<com.hp.hpl.jena.rdf.model.Property>any(), Mockito.<com.hp.hpl.jena.rdf.model.RDFNode>any()))
			.thenReturn(resource2)
			.thenReturn(resource1);
		Literal literal2 = mock(Literal.class);
		Resource resource3 = mock(Resource.class);
		Resource resource4 = mock(Resource.class);
		ObjectProperty objectProperty2 = mock(ObjectProperty.class);
		when(objectProperty2.addProperty(Mockito.<com.hp.hpl.jena.rdf.model.Property>any(), Mockito.<com.hp.hpl.jena.rdf.model.RDFNode>any()))
			.thenReturn(resource4)
			.thenReturn(resource3);
		Literal literal3 = mock(Literal.class);
		Resource resource5 = mock(Resource.class);
		Resource resource6 = mock(Resource.class);
		ObjectProperty objectProperty3 = mock(ObjectProperty.class);
		when(objectProperty3.addProperty(Mockito.<com.hp.hpl.jena.rdf.model.Property>any(), Mockito.<com.hp.hpl.jena.rdf.model.RDFNode>any()))
			.thenReturn(resource6)
			.thenReturn(resource5);
		Literal literal4 = mock(Literal.class);
		Resource resource7 = mock(Resource.class);
		Resource resource8 = mock(Resource.class);
		ObjectProperty objectProperty4 = mock(ObjectProperty.class);
		when(objectProperty4.addProperty(Mockito.<com.hp.hpl.jena.rdf.model.Property>any(), Mockito.<com.hp.hpl.jena.rdf.model.RDFNode>any()))
			.thenReturn(resource8)
			.thenReturn(resource7);
		Literal literal5 = mock(Literal.class);
		Resource resource9 = mock(Resource.class);
		Resource resource10 = mock(Resource.class);
		ObjectProperty objectProperty5 = mock(ObjectProperty.class);
		when(objectProperty5.addProperty(Mockito.<com.hp.hpl.jena.rdf.model.Property>any(), Mockito.<com.hp.hpl.jena.rdf.model.RDFNode>any()))
			.thenReturn(resource10)
			.thenReturn(resource9);
		Literal literal6 = mock(Literal.class);
		Resource resource11 = mock(Resource.class);
		Resource resource12 = mock(Resource.class);
		ObjectProperty objectProperty6 = mock(ObjectProperty.class);
		when(objectProperty6.addProperty(Mockito.<com.hp.hpl.jena.rdf.model.Property>any(), Mockito.<com.hp.hpl.jena.rdf.model.RDFNode>any()))
			.thenReturn(resource12)
			.thenReturn(resource11);
		OntModel ontModel = mock(OntModel.class);
		when(ontModel.createObjectProperty(Mockito.<String>any()))
			.thenReturn(objectProperty6)
			.thenReturn(objectProperty5)
			.thenReturn(objectProperty4)
			.thenReturn(objectProperty3)
			.thenReturn(objectProperty2)
			.thenReturn(objectProperty1);
		when(ontModel.createLiteral(Mockito.<String>any()))
			.thenReturn(literal6)
			.thenReturn(literal5)
			.thenReturn(literal4)
			.thenReturn(literal3)
			.thenReturn(literal2)
			.thenReturn(literal1);
		assertSame(model2, service.exportHierarchicalRelationshipRoles(model2, ontModel));
		Mockito.verify(objectProperty1).addLabel(Mockito.<Literal>any());
		Mockito.verify(objectProperty2).addLabel(Mockito.<Literal>any());
		Mockito.verify(objectProperty3).addLabel(Mockito.<Literal>any());
		Mockito.verify(objectProperty4).addLabel(Mockito.<Literal>any());
		Mockito.verify(objectProperty5).addLabel(Mockito.<Literal>any());
		Mockito.verify(objectProperty6).addLabel(Mockito.<Literal>any());
	}
}