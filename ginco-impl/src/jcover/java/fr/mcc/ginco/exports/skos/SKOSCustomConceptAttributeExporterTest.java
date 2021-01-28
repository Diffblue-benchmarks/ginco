package fr.mcc.ginco.exports.skos;

import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.hp.hpl.jena.ontology.DatatypeProperty;
import com.hp.hpl.jena.ontology.OntModel;
import com.hp.hpl.jena.rdf.model.Literal;
import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.Resource;

import fr.mcc.ginco.beans.CustomConceptAttribute;
import fr.mcc.ginco.beans.CustomConceptAttributeType;
import fr.mcc.ginco.beans.ThesaurusConcept;
import fr.mcc.ginco.services.ICustomConceptAttributeService;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

/**
 * Unit tests for fr.mcc.ginco.exports.skos.SKOSCustomConceptAttributeExporter
 *
 * @author Diffblue Cover
 */

public class SKOSCustomConceptAttributeExporterTest {

	@Mock(name = "customConceptAttributeService")
	private ICustomConceptAttributeService customConceptAttributeService;

	@InjectMocks
	private SKOSCustomConceptAttributeExporter service;

	@Before public void initMocks() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void exportCustomConceptAttributes1() {
		when(customConceptAttributeService.getAttributesByEntity(Mockito.<ThesaurusConcept>any()))
			.thenReturn(new ArrayList<CustomConceptAttribute>());
		Model model = mock(Model.class);
		Resource conceptResource = mock(Resource.class);
		Literal literal = mock(Literal.class);
		DatatypeProperty datatypeProperty = mock(DatatypeProperty.class);
		OntModel ontModel = mock(OntModel.class);
		when(ontModel.createDatatypeProperty(Mockito.<String>any()))
			.thenReturn(datatypeProperty);
		when(ontModel.createLiteral(Mockito.<String>any()))
			.thenReturn(literal);
		assertSame(model, service.exportCustomConceptAttributes(new ThesaurusConcept(), model, conceptResource, ontModel));
		Mockito.verify(datatypeProperty).addLabel(Mockito.<Literal>any());
	}

	@Test
	public void exportCustomConceptAttributes2() {
		ArrayList<CustomConceptAttribute> customConceptAttributeList =
			 new ArrayList<CustomConceptAttribute>();
		CustomConceptAttribute customConceptAttribute = new CustomConceptAttribute();
		CustomConceptAttributeType type1 = new CustomConceptAttributeType();
		type1.setExportable(false);
		customConceptAttribute.setType(type1);
		customConceptAttributeList.add(customConceptAttribute);
		when(customConceptAttributeService.getAttributesByEntity(Mockito.<ThesaurusConcept>any()))
			.thenReturn(customConceptAttributeList);
		Model model = mock(Model.class);
		Resource conceptResource = mock(Resource.class);
		Literal literal = mock(Literal.class);
		DatatypeProperty datatypeProperty = mock(DatatypeProperty.class);
		OntModel ontModel = mock(OntModel.class);
		when(ontModel.createDatatypeProperty(Mockito.<String>any()))
			.thenReturn(datatypeProperty);
		when(ontModel.createLiteral(Mockito.<String>any()))
			.thenReturn(literal);
		assertSame(model, service.exportCustomConceptAttributes(new ThesaurusConcept(), model, conceptResource, ontModel));
		Mockito.verify(datatypeProperty).addLabel(Mockito.<Literal>any());
	}
}
