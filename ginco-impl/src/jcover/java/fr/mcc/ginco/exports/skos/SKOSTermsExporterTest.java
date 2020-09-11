package fr.mcc.ginco.exports.skos;

import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.Resource;

import fr.mcc.ginco.beans.ThesaurusTerm;
import fr.mcc.ginco.services.IThesaurusTermService;

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
	public void exportConceptPreferredTermsPrefTermsIsEmpty() {
		Model model = mock(Model.class);
		Resource conceptResource = mock(Resource.class);
		assertSame(model, service.exportConceptPreferredTerms(new ArrayList<ThesaurusTerm>(), model, conceptResource));
	}

	@Test
	public void exportConceptNotPreferredTerms1() {
		when(thesaurusTermService.getTermsByConceptId(Mockito.<String>any()))
			.thenReturn(new ArrayList<ThesaurusTerm>());
		Model model = mock(Model.class);
		Resource conceptResource = mock(Resource.class);
		assertSame(model, service.exportConceptNotPreferredTerms("1234", model, conceptResource));
	}

	@Test
	public void exportConceptNotPreferredTerms2() {
		List<ThesaurusTerm> list = new ArrayList<ThesaurusTerm>();
		ThesaurusTerm thesaurusTerm = new ThesaurusTerm();
		thesaurusTerm.setPrefered(true);
		list.add(thesaurusTerm);
		when(thesaurusTermService.getTermsByConceptId(Mockito.<String>any()))
			.thenReturn(list);
		Model model = mock(Model.class);
		Resource conceptResource = mock(Resource.class);
		assertSame(model, service.exportConceptNotPreferredTerms("1234", model, conceptResource));
	}
}
