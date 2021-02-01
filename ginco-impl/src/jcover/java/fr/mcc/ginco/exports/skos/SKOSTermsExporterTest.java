package fr.mcc.ginco.exports.skos;

import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.Resource;

import fr.mcc.ginco.beans.Language;
import fr.mcc.ginco.beans.ThesaurusTerm;
import fr.mcc.ginco.services.IThesaurusTermService;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

/**
 * Unit tests for fr.mcc.ginco.exports.skos.SKOSTermsExporter
 *
 * @author Diffblue Cover
 */

public class SKOSTermsExporterTest {

	@Mock(name = "skosModelTermsExporter")
	private SKOSModelTermsExporter skosModelTermsExporter;

	@Mock(name = "thesaurusTermService")
	private IThesaurusTermService thesaurusTermService;

	@InjectMocks
	private SKOSTermsExporter service;

	@Before
	public void initMocks() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void exportConceptPreferredTerms() {
		Model model1 = mock(Model.class);
		when(skosModelTermsExporter.exportConceptPreferredTerm(Mockito.<ThesaurusTerm>any(), Mockito.<Model>any()))
			.thenReturn(model1);
		ArrayList<ThesaurusTerm> prefTerms = new ArrayList<ThesaurusTerm>();
		ThesaurusTerm thesaurusTerm = new ThesaurusTerm();
		thesaurusTerm.setLanguage(new Language());
		prefTerms.add(thesaurusTerm);
		Model model2 = mock(Model.class);
		Resource resource = mock(Resource.class);
		Model model3 = mock(Model.class);
		Model model4 = mock(Model.class);
		when(model4.createResource(Mockito.<String>any()))
			.thenReturn(resource);
		when(model4.add(Mockito.<Resource>any(), Mockito.<com.hp.hpl.jena.rdf.model.Property>any(), Mockito.<com.hp.hpl.jena.rdf.model.RDFNode>any()))
			.thenReturn(model2);
		when(model4.add(Mockito.<Resource>any(), Mockito.<com.hp.hpl.jena.rdf.model.Property>any(), Mockito.<String>any(), Mockito.<String>any()))
			.thenReturn(model3);
		Resource conceptResource = mock(Resource.class);
		assertSame(model4, service.exportConceptPreferredTerms(prefTerms, model4, conceptResource));
	}

	@Test
	public void exportConceptNotPreferredTerms1() {
		when(thesaurusTermService.getTermsByConceptId(Mockito.<String>any()))
			.thenReturn(new ArrayList<ThesaurusTerm>());
		Model model1 = mock(Model.class);
		Model model2 = mock(Model.class);
		Model model3 = mock(Model.class);
		Resource conceptResource = mock(Resource.class);
		assertSame(model3, service.exportConceptNotPreferredTerms("1234", model3, conceptResource));
	}

	@Test
	public void exportConceptNotPreferredTerms2() {
		ArrayList<ThesaurusTerm> thesaurusTermList = new ArrayList<ThesaurusTerm>();
		ThesaurusTerm thesaurusTerm = new ThesaurusTerm();
		thesaurusTerm.setHidden(false);
		thesaurusTerm.setLanguage(new Language());
		thesaurusTerm.setPrefered(false);
		thesaurusTermList.add(thesaurusTerm);
		when(thesaurusTermService.getTermsByConceptId(Mockito.<String>any()))
			.thenReturn(thesaurusTermList);
		Model model1 = mock(Model.class);
		when(skosModelTermsExporter.exportConceptNotPreferredTerm(Mockito.<ThesaurusTerm>any(), Mockito.<Model>any(), Mockito.<Resource>any(), anyBoolean()))
			.thenReturn(model1);
		Model model2 = mock(Model.class);
		Model model3 = mock(Model.class);
		when(model3.add(Mockito.<Resource>any(), Mockito.<com.hp.hpl.jena.rdf.model.Property>any(), Mockito.<String>any(), Mockito.<String>any()))
			.thenReturn(model2);
		Resource conceptResource = mock(Resource.class);
		assertSame(model3, service.exportConceptNotPreferredTerms("1234", model3, conceptResource));
	}

	@Test
	public void exportConceptNotPreferredTerms3() {
		ArrayList<ThesaurusTerm> thesaurusTermList = new ArrayList<ThesaurusTerm>();
		ThesaurusTerm thesaurusTerm = new ThesaurusTerm();
		thesaurusTerm.setHidden(true);
		thesaurusTerm.setLanguage(new Language());
		thesaurusTerm.setPrefered(false);
		thesaurusTermList.add(thesaurusTerm);
		when(thesaurusTermService.getTermsByConceptId(Mockito.<String>any()))
			.thenReturn(thesaurusTermList);
		Model model1 = mock(Model.class);
		when(skosModelTermsExporter.exportConceptNotPreferredTerm(Mockito.<ThesaurusTerm>any(), Mockito.<Model>any(), Mockito.<Resource>any(), anyBoolean()))
			.thenReturn(model1);
		Model model2 = mock(Model.class);
		Model model3 = mock(Model.class);
		when(model3.add(Mockito.<Resource>any(), Mockito.<com.hp.hpl.jena.rdf.model.Property>any(), Mockito.<String>any(), Mockito.<String>any()))
			.thenReturn(model2);
		Resource conceptResource = mock(Resource.class);
		assertSame(model3, service.exportConceptNotPreferredTerms("1234", model3, conceptResource));
	}

	@Test
	public void exportConceptNotPreferredTerms4() {
		ArrayList<ThesaurusTerm> thesaurusTermList = new ArrayList<ThesaurusTerm>();
		ThesaurusTerm thesaurusTerm = new ThesaurusTerm();
		thesaurusTerm.setPrefered(true);
		thesaurusTermList.add(thesaurusTerm);
		when(thesaurusTermService.getTermsByConceptId(Mockito.<String>any()))
			.thenReturn(thesaurusTermList);
		Model model1 = mock(Model.class);
		Model model2 = mock(Model.class);
		Model model3 = mock(Model.class);
		Resource conceptResource = mock(Resource.class);
		assertSame(model3, service.exportConceptNotPreferredTerms("1234", model3, conceptResource));
	}
}
