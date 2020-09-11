package fr.mcc.ginco.audit.commands;

import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import fr.mcc.ginco.audit.utils.AuditHelper;
import fr.mcc.ginco.beans.ThesaurusConcept;
import fr.mcc.ginco.beans.ThesaurusTerm;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

/**
 * Unit tests for fr.mcc.ginco.audit.commands.MistralStructuresBuilder
 *
 * @author Diffblue Cover
 */

public class MistralStructuresBuilderTest {

	@Mock(name = "auditHelper")
	private AuditHelper auditHelper;

	@InjectMocks
	private MistralStructuresBuilder service;

	@Before public void initMocks() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void buildHierarchyStructureConceptsAtRevisionIsEmptyAndLangIsMpegAndRevisionIsOneReturnsEmpty() {
		assertTrue(service.buildHierarchyStructure(new ArrayList<ThesaurusConcept>(), 1, "mpeg").isEmpty());
	}

	@Test
	public void buildSynonymsStructureConceptsAtRevisionIsEmptyAndLangIsMpegAndRevisionIsOneReturnsEmpty() {
		assertTrue(service.buildSynonymsStructure(new ArrayList<ThesaurusConcept>(), 1, "mpeg").isEmpty());
	}

	@Test
	public void getTermVersionsView() {
		ArrayList<ThesaurusTerm> currentTerms = new ArrayList<ThesaurusTerm>();
		ThesaurusTerm thesaurusTerm = new ThesaurusTerm();
		thesaurusTerm.setLexicalValue("value");
		currentTerms.add(thesaurusTerm);
		assertSame(thesaurusTerm, service.getTermVersionsView(currentTerms).get("value"));
	}

	@Test
	public void getNotPreferredTermsByTerm1() {
		ArrayList<ThesaurusTerm> currentTerms = new ArrayList<ThesaurusTerm>();
		ThesaurusTerm thesaurusTerm = new ThesaurusTerm();
		thesaurusTerm.setPrefered(false);
		currentTerms.add(thesaurusTerm);
		assertTrue(service.getNotPreferredTermsByTerm(currentTerms).isEmpty());
	}

	@Test
	public void getNotPreferredTermsByTerm2() {
		ArrayList<ThesaurusTerm> currentTerms = new ArrayList<ThesaurusTerm>();
		ThesaurusTerm thesaurusTerm = new ThesaurusTerm();
		ThesaurusConcept concept = new ThesaurusConcept();
		concept.setIdentifier("data");
		thesaurusTerm.setConcept(concept);
		thesaurusTerm.setLexicalValue("value");
		thesaurusTerm.setPrefered(true);
		currentTerms.add(thesaurusTerm);
		assertTrue((service.getNotPreferredTermsByTerm(currentTerms).get("value")).isEmpty());
	}

	@Test
	public void getNotPreferredTermsByTermCurrentTermsIsEmpty() {
		assertTrue(service.getNotPreferredTermsByTerm(new ArrayList<ThesaurusTerm>()).isEmpty());
	}
}
