package fr.mcc.ginco.exports.skos;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;

import com.hp.hpl.jena.rdf.model.Model;

import fr.mcc.ginco.beans.Language;
import fr.mcc.ginco.beans.ThesaurusTerm;
import fr.mcc.ginco.skos.namespaces.GINCO;

import java.text.SimpleDateFormat;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

/**
 * Unit tests for fr.mcc.ginco.exports.skos.SKOSModelTermsExporter
 *
 * @author Diffblue Cover
 */

public class SKOSModelTermsExporterTest {

	@InjectMocks
	private SKOSModelTermsExporter service;

	@Before public void initMocks() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void exportConceptPreferredTermModelIsEmpty() throws java.text.ParseException {
		ThesaurusTerm term = new ThesaurusTerm();
		term.setCreated(new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31"));
		term.setLanguage(new Language());
		term.setLexicalValue("value");
		term.setModified(new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31"));
		term.setSource("foo");
		term.setStatus(1);
		Model model = com.hp.hpl.jena.rdf.model.ModelFactory.createDefaultModel();
		assertSame(model, service.exportConceptPreferredTerm(term, model));
		assertFalse(model.isEmpty());
	}

	@Test
	public void exportConceptNotPreferredTermHiddenIsFalseAndModelIsEmpty() throws java.text.ParseException {
		ThesaurusTerm term = new ThesaurusTerm();
		term.setCreated(new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31"));
		term.setLanguage(new Language());
		term.setLexicalValue("value");
		term.setModified(new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31"));
		term.setSource("foo");
		term.setStatus(1);
		Model model = com.hp.hpl.jena.rdf.model.ModelFactory.createDefaultModel();
		assertSame(model, service.exportConceptNotPreferredTerm(term, model, GINCO.getResource("BASIC"), false));
		assertFalse(model.isEmpty());
	}
}
