package fr.mcc.ginco.exports.skos;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.when;

import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.ModelFactory;

import fr.mcc.ginco.beans.Language;
import fr.mcc.ginco.beans.ThesaurusTerm;
import fr.mcc.ginco.services.IThesaurusTermService;
import fr.mcc.ginco.skos.namespaces.GINCO;

import java.util.ArrayList;
import java.util.List;

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

	@Before public void initMocks() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void exportConceptPreferredTerms() {
		when(skosModelTermsExporter.exportConceptPreferredTerm(Mockito.<ThesaurusTerm>any(), Mockito.<Model>any()))
			.thenReturn(ModelFactory.createDefaultModel());
		ArrayList<ThesaurusTerm> prefTerms = new ArrayList<ThesaurusTerm>();
		ThesaurusTerm thesaurusTerm = new ThesaurusTerm();
		thesaurusTerm.setLanguage(new Language());
		thesaurusTerm.setLexicalValue("value");
		prefTerms.add(thesaurusTerm);
		Model model2 = ModelFactory.createDefaultModel();
		assertSame(model2, service.exportConceptPreferredTerms(prefTerms, model2, GINCO.getResource("BASIC")));
		assertFalse(model2.isEmpty());
	}

	@Test
	public void exportConceptPreferredTermsPrefTermsIsEmpty() {
		Model model = ModelFactory.createDefaultModel();
		assertSame(model, service.exportConceptPreferredTerms(new ArrayList<ThesaurusTerm>(), model, GINCO.getResource("BASIC")));
	}

	@Test
	public void exportConceptNotPreferredTerms1() {
		when(thesaurusTermService.getTermsByConceptId(Mockito.<String>any()))
			.thenReturn(new ArrayList<ThesaurusTerm>());
		Model model = ModelFactory.createDefaultModel();
		assertSame(model, service.exportConceptNotPreferredTerms("1234", model, GINCO.getResource("BASIC")));
	}

	@Test
	public void exportConceptNotPreferredTerms2() {
		List<ThesaurusTerm> list = new ArrayList<ThesaurusTerm>();
		ThesaurusTerm thesaurusTerm = new ThesaurusTerm();
		thesaurusTerm.setPrefered(true);
		list.add(thesaurusTerm);
		when(thesaurusTermService.getTermsByConceptId(Mockito.<String>any()))
			.thenReturn(list);
		Model model = ModelFactory.createDefaultModel();
		assertSame(model, service.exportConceptNotPreferredTerms("1234", model, GINCO.getResource("BASIC")));
	}
}
