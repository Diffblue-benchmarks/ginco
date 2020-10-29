package fr.mcc.ginco.exports.skos;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.hp.hpl.jena.ontology.ObjectProperty;
import com.hp.hpl.jena.ontology.OntClass;
import com.hp.hpl.jena.ontology.OntModel;
import com.hp.hpl.jena.rdf.model.Literal;
import com.hp.hpl.jena.rdf.model.Resource;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

/**
 * Unit tests for fr.mcc.ginco.exports.skos.SKOSGroupOntologyExporter
 *
 * @author Diffblue Cover
 */

public class SKOSGroupOntologyExporterTest {

	@InjectMocks
	private SKOSGroupOntologyExporter service;

	@Before public void initMocks() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void buildGroupOntologyModel() {
		Literal literal1 = mock(Literal.class);
		ObjectProperty objectProperty1 = mock(ObjectProperty.class);
		Literal literal2 = mock(Literal.class);
		ObjectProperty objectProperty2 = mock(ObjectProperty.class);
		Literal literal3 = mock(Literal.class);
		Resource resource1 = mock(Resource.class);
		Resource resource2 = mock(Resource.class);
		OntClass ontClass = mock(OntClass.class);
		when(ontClass.asResource())
			.thenReturn(resource2)
			.thenReturn(resource1);
		OntModel ontModel = mock(OntModel.class);
		when(ontModel.createClass(Mockito.<String>any()))
			.thenReturn(ontClass);
		when(ontModel.createObjectProperty(Mockito.<String>any()))
			.thenReturn(objectProperty2)
			.thenReturn(objectProperty1);
		when(ontModel.createLiteral(Mockito.<String>any()))
			.thenReturn(literal3)
			.thenReturn(literal2)
			.thenReturn(literal1);
		assertSame(ontModel, service.buildGroupOntologyModel(ontModel));
		Mockito.verify(objectProperty1).addDomain(Mockito.<Resource>any());
		Mockito.verify(objectProperty1).addRange(Mockito.<Resource>any());
		Mockito.verify(objectProperty1).addLabel(Mockito.<Literal>any());
		Mockito.verify(objectProperty2).addDomain(Mockito.<Resource>any());
		Mockito.verify(objectProperty2).addRange(Mockito.<Resource>any());
		Mockito.verify(objectProperty2).addLabel(Mockito.<Literal>any());
		Mockito.verify(ontClass).addSuperClass(Mockito.<Resource>any());
		Mockito.verify(ontClass).addLabel(Mockito.<Literal>any());
	}

	@Test
	public void addGroupTypeToOntModel() {
		Resource resource = mock(Resource.class);
		Literal literal = mock(Literal.class);
		OntClass ontClass = mock(OntClass.class);
		OntModel ontmodel = mock(OntModel.class);
		when(ontmodel.createClass(Mockito.<String>any()))
			.thenReturn(ontClass);
		when(ontmodel.getResource(Mockito.<String>any()))
			.thenReturn(resource);
		when(ontmodel.createLiteral(Mockito.<String>any()))
			.thenReturn(literal);
		assertNotNull(service.addGroupTypeToOntModel(ontmodel, "BASIC"));
		Mockito.verify(ontClass).addSuperClass(Mockito.<Resource>any());
		Mockito.verify(ontClass).addLabel(Mockito.<Literal>any());
	}
}
