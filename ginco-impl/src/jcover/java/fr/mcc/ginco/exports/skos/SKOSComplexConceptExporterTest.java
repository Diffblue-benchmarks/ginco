package fr.mcc.ginco.exports.skos;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.when;

import com.hp.hpl.jena.rdf.model.Model;

import fr.mcc.ginco.beans.Language;
import fr.mcc.ginco.beans.SplitNonPreferredTerm;
import fr.mcc.ginco.beans.Thesaurus;
import fr.mcc.ginco.services.ISplitNonPreferredTermService;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

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
	public void exportComplexConcept1() throws java.text.ParseException {
		List<SplitNonPreferredTerm> list = new ArrayList<SplitNonPreferredTerm>();
		SplitNonPreferredTerm splitNonPreferredTerm = new SplitNonPreferredTerm();
		splitNonPreferredTerm.setCreated(new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31"));
		splitNonPreferredTerm.setIdentifier("foo");
		splitNonPreferredTerm.setLanguage(new Language());
		splitNonPreferredTerm.setLexicalValue("value");
		splitNonPreferredTerm.setModified(new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31"));
		splitNonPreferredTerm.setSource("foo");
		splitNonPreferredTerm.setStatus(1);
		splitNonPreferredTerm.setThesaurus(new Thesaurus());
		list.add(splitNonPreferredTerm);
		when(splitNonPreferredTermService.getSplitNonPreferredTermList(Mockito.<Integer>any(), Mockito.<Integer>any(), Mockito.<String>any()))
			.thenReturn(list);
		Model model = com.hp.hpl.jena.rdf.model.ModelFactory.createDefaultModel();
		assertSame(model, service.exportComplexConcept(new Thesaurus(), model));
		assertFalse(model.isEmpty());
	}

	@Test
	public void exportComplexConcept2() {
		when(splitNonPreferredTermService.getSplitNonPreferredTermList(Mockito.<Integer>any(), Mockito.<Integer>any(), Mockito.<String>any()))
			.thenReturn(new ArrayList<SplitNonPreferredTerm>());
		Model model = com.hp.hpl.jena.rdf.model.ModelFactory.createDefaultModel();
		assertSame(model, service.exportComplexConcept(new Thesaurus(), model));
	}
}
