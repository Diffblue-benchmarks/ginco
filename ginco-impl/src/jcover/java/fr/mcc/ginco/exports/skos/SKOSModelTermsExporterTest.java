package fr.mcc.ginco.exports.skos;

import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.Resource;

import fr.mcc.ginco.beans.Language;
import fr.mcc.ginco.beans.ThesaurusTerm;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

/**
 * Unit tests for fr.mcc.ginco.exports.skos.SKOSModelTermsExporter
 *
 * @author Diffblue Cover
 */

public class SKOSModelTermsExporterTest {

	@InjectMocks
	private SKOSModelTermsExporter service;

	@Before
	public void initMocks() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void exportConceptPreferredTerm1() {
		ThesaurusTerm term = new ThesaurusTerm();
		term.setLanguage(new Language());
		term.setSource("foo");
		term.setStatus(1);
		Model model1 = mock(Model.class);
		Model model2 = mock(Model.class);
		Model model3 = mock(Model.class);
		Model model4 = mock(Model.class);
		Model model5 = mock(Model.class);
		Resource resource = mock(Resource.class);
		Model model6 = mock(Model.class);
		when(model6.add(Mockito.<Resource>any(), Mockito.<com.hp.hpl.jena.rdf.model.Property>any(), Mockito.<String>any()))
			.thenReturn(model5)
			.thenReturn(model4)
			.thenReturn(model2)
			.thenReturn(model1);
		when(model6.add(Mockito.<Resource>any(), Mockito.<com.hp.hpl.jena.rdf.model.Property>any(), Mockito.<String>any(), Mockito.<String>any()))
			.thenReturn(model3);
		when(model6.createResource(Mockito.<String>any(), Mockito.<Resource>any()))
			.thenReturn(resource);
		assertSame(model6, service.exportConceptPreferredTerm(term, model6));
	}

	@Test
	public void exportConceptPreferredTerm2() {
		ThesaurusTerm term = new ThesaurusTerm();
		term.setLanguage(new Language());
		term.setStatus(1);
		Model model1 = mock(Model.class);
		Model model2 = mock(Model.class);
		Model model3 = mock(Model.class);
		Model model4 = mock(Model.class);
		Model model5 = mock(Model.class);
		Resource resource = mock(Resource.class);
		Model model6 = mock(Model.class);
		when(model6.add(Mockito.<Resource>any(), Mockito.<com.hp.hpl.jena.rdf.model.Property>any(), Mockito.<String>any()))
			.thenReturn(model5)
			.thenReturn(model4)
			.thenReturn(model2);
		when(model6.add(Mockito.<Resource>any(), Mockito.<com.hp.hpl.jena.rdf.model.Property>any(), Mockito.<String>any(), Mockito.<String>any()))
			.thenReturn(model3);
		when(model6.createResource(Mockito.<String>any(), Mockito.<Resource>any()))
			.thenReturn(resource);
		assertSame(model6, service.exportConceptPreferredTerm(term, model6));
	}

	@Test
	public void exportConceptNotPreferredTermHiddenIsFalse() {
		ThesaurusTerm term = new ThesaurusTerm();
		term.setLanguage(new Language());
		term.setSource("foo");
		term.setStatus(1);
		Model model1 = mock(Model.class);
		Model model2 = mock(Model.class);
		Model model3 = mock(Model.class);
		Model model4 = mock(Model.class);
		Model model5 = mock(Model.class);
		Resource resource1 = mock(Resource.class);
		Model model6 = mock(Model.class);
		when(model6.add(Mockito.<Resource>any(), Mockito.<com.hp.hpl.jena.rdf.model.Property>any(), Mockito.<String>any()))
			.thenReturn(model5)
			.thenReturn(model4)
			.thenReturn(model2)
			.thenReturn(model1);
		when(model6.add(Mockito.<Resource>any(), Mockito.<com.hp.hpl.jena.rdf.model.Property>any(), Mockito.<String>any(), Mockito.<String>any()))
			.thenReturn(model3);
		when(model6.createResource(Mockito.<String>any(), Mockito.<Resource>any()))
			.thenReturn(resource1);
		Resource resource2 = mock(Resource.class);
		Resource conceptResource = mock(Resource.class);
		when(conceptResource.addProperty(Mockito.<com.hp.hpl.jena.rdf.model.Property>any(), Mockito.<com.hp.hpl.jena.rdf.model.RDFNode>any()))
			.thenReturn(resource2);
		assertSame(model6, service.exportConceptNotPreferredTerm(term, model6, conceptResource, false));
	}
}
