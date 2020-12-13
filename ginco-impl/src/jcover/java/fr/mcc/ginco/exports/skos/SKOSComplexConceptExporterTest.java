package fr.mcc.ginco.exports.skos;

import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.Resource;

import fr.mcc.ginco.beans.Language;
import fr.mcc.ginco.beans.SplitNonPreferredTerm;
import fr.mcc.ginco.beans.Thesaurus;
import fr.mcc.ginco.services.ISplitNonPreferredTermService;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

/**
 * Unit tests for fr.mcc.ginco.exports.skos.SKOSComplexConceptExporter
 *
 * @author Diffblue Cover
 */

public class SKOSComplexConceptExporterTest {

	@Mock(name = "splitNonPreferredTermService")
	private ISplitNonPreferredTermService splitNonPreferredTermService;

	@InjectMocks
	private SKOSComplexConceptExporter service;

	@Before public void initMocks() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void exportComplexConcept1() {
		when(splitNonPreferredTermService.getSplitNonPreferredTermList(Mockito.<Integer>any(), Mockito.<Integer>any(), Mockito.<String>any()))
			.thenReturn(new ArrayList<SplitNonPreferredTerm>());
		Model model1 = mock(Model.class);
		Model model2 = mock(Model.class);
		Resource resource1 = mock(Resource.class);
		Model model3 = mock(Model.class);
		Model model4 = mock(Model.class);
		Model model5 = mock(Model.class);
		Model model6 = mock(Model.class);
		Model model7 = mock(Model.class);
		Model model8 = mock(Model.class);
		Resource resource2 = mock(Resource.class);
		Resource resource3 = mock(Resource.class);
		Model model9 = mock(Model.class);
		assertSame(model9, service.exportComplexConcept(new Thesaurus(), model9));
	}

	@Test
	public void exportComplexConcept2() {
		ArrayList<SplitNonPreferredTerm> arrayList =
			 new ArrayList<SplitNonPreferredTerm>();
		SplitNonPreferredTerm splitNonPreferredTerm = new SplitNonPreferredTerm();
		splitNonPreferredTerm.setLanguage(new Language());
		splitNonPreferredTerm.setStatus(1);
		splitNonPreferredTerm.setThesaurus(new Thesaurus());
		arrayList.add(splitNonPreferredTerm);
		when(splitNonPreferredTermService.getSplitNonPreferredTermList(Mockito.<Integer>any(), Mockito.<Integer>any(), Mockito.<String>any()))
			.thenReturn(arrayList);
		Model model1 = mock(Model.class);
		Model model2 = mock(Model.class);
		Resource resource1 = mock(Resource.class);
		Model model3 = mock(Model.class);
		Model model4 = mock(Model.class);
		Model model5 = mock(Model.class);
		Model model6 = mock(Model.class);
		Model model7 = mock(Model.class);
		Model model8 = mock(Model.class);
		Resource resource2 = mock(Resource.class);
		Resource resource3 = mock(Resource.class);
		Model model9 = mock(Model.class);
		when(model9.createResource(Mockito.<String>any()))
			.thenReturn(resource3);
		when(model9.add(Mockito.<Resource>any(), Mockito.<com.hp.hpl.jena.rdf.model.Property>any(), Mockito.<com.hp.hpl.jena.rdf.model.RDFNode>any()))
			.thenReturn(model8)
			.thenReturn(model2);
		when(model9.add(Mockito.<Resource>any(), Mockito.<com.hp.hpl.jena.rdf.model.Property>any(), Mockito.<String>any()))
			.thenReturn(model6)
			.thenReturn(model5)
			.thenReturn(model4)
			.thenReturn(model3);
		when(model9.add(Mockito.<Resource>any(), Mockito.<com.hp.hpl.jena.rdf.model.Property>any(), Mockito.<String>any(), Mockito.<String>any()))
			.thenReturn(model7);
		when(model9.createResource(Mockito.<Resource>any()))
			.thenReturn(resource1);
		when(model9.createResource(Mockito.<String>any(), Mockito.<Resource>any()))
			.thenReturn(resource2);
		assertSame(model9, service.exportComplexConcept(new Thesaurus(), model9));
	}

	@Test
	public void exportComplexConcept3() {
		ArrayList<SplitNonPreferredTerm> arrayList =
			 new ArrayList<SplitNonPreferredTerm>();
		SplitNonPreferredTerm splitNonPreferredTerm = new SplitNonPreferredTerm();
		splitNonPreferredTerm.setLanguage(new Language());
		splitNonPreferredTerm.setSource("foo");
		splitNonPreferredTerm.setStatus(1);
		splitNonPreferredTerm.setThesaurus(new Thesaurus());
		arrayList.add(splitNonPreferredTerm);
		when(splitNonPreferredTermService.getSplitNonPreferredTermList(Mockito.<Integer>any(), Mockito.<Integer>any(), Mockito.<String>any()))
			.thenReturn(arrayList);
		Model model1 = mock(Model.class);
		Model model2 = mock(Model.class);
		Resource resource1 = mock(Resource.class);
		Model model3 = mock(Model.class);
		Model model4 = mock(Model.class);
		Model model5 = mock(Model.class);
		Model model6 = mock(Model.class);
		Model model7 = mock(Model.class);
		Model model8 = mock(Model.class);
		Resource resource2 = mock(Resource.class);
		Resource resource3 = mock(Resource.class);
		Model model9 = mock(Model.class);
		when(model9.createResource(Mockito.<String>any()))
			.thenReturn(resource3);
		when(model9.add(Mockito.<Resource>any(), Mockito.<com.hp.hpl.jena.rdf.model.Property>any(), Mockito.<com.hp.hpl.jena.rdf.model.RDFNode>any()))
			.thenReturn(model8)
			.thenReturn(model2);
		when(model9.add(Mockito.<Resource>any(), Mockito.<com.hp.hpl.jena.rdf.model.Property>any(), Mockito.<String>any()))
			.thenReturn(model6)
			.thenReturn(model5)
			.thenReturn(model4)
			.thenReturn(model3)
			.thenReturn(model1);
		when(model9.add(Mockito.<Resource>any(), Mockito.<com.hp.hpl.jena.rdf.model.Property>any(), Mockito.<String>any(), Mockito.<String>any()))
			.thenReturn(model7);
		when(model9.createResource(Mockito.<Resource>any()))
			.thenReturn(resource1);
		when(model9.createResource(Mockito.<String>any(), Mockito.<Resource>any()))
			.thenReturn(resource2);
		assertSame(model9, service.exportComplexConcept(new Thesaurus(), model9));
	}
}
