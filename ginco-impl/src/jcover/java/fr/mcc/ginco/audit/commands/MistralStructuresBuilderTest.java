package fr.mcc.ginco.audit.commands;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import fr.mcc.ginco.audit.utils.AuditHelper;
import fr.mcc.ginco.beans.ThesaurusConcept;
import fr.mcc.ginco.beans.ThesaurusTerm;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
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
	public void buildHierarchyStructureLangIsMpegAndRevisionIsOneReturnsValue() {
		ThesaurusTerm thesaurusTerm1 = new ThesaurusTerm();
		thesaurusTerm1.setLexicalValue("value");
		List<ThesaurusConcept> list = new ArrayList<ThesaurusConcept>();
		list.add(new ThesaurusConcept());
		ThesaurusTerm thesaurusTerm2 = new ThesaurusTerm();
		thesaurusTerm2.setLexicalValue("value");
		when(auditHelper.getConceptChildrenAtRevision(Mockito.<Number>any(), Mockito.<ThesaurusConcept>any(), Mockito.<List<ThesaurusConcept>>any()))
			.thenReturn(list);
		when(auditHelper.getPreferredTermAtRevision(Mockito.<Number>any(), Mockito.<String>any(), Mockito.<String>any()))
			.thenReturn(thesaurusTerm2)
			.thenReturn(thesaurusTerm1);
		ArrayList<ThesaurusConcept> conceptsAtRevision =
			 new ArrayList<ThesaurusConcept>();
		conceptsAtRevision.add(new ThesaurusConcept());
		assertEquals(1, service.buildHierarchyStructure(conceptsAtRevision, 1, "mpeg").get("value").size());
		assertEquals("value", service.buildHierarchyStructure(conceptsAtRevision, 1, "mpeg").get("value").get(0));
	}

	@Test
	public void buildSynonymsStructure1() {
		ThesaurusTerm thesaurusTerm = new ThesaurusTerm();
		thesaurusTerm.setLexicalValue("value");
		when(auditHelper.getConceptTermsAtRevision(Mockito.<ThesaurusConcept>any(), Mockito.<Number>any(), Mockito.<String>any()))
			.thenReturn(new ArrayList<ThesaurusTerm>());
		when(auditHelper.getPreferredTermAtRevision(Mockito.<Number>any(), Mockito.<String>any(), Mockito.<String>any()))
			.thenReturn(thesaurusTerm);
		ArrayList<ThesaurusConcept> conceptsAtRevision =
			 new ArrayList<ThesaurusConcept>();
		conceptsAtRevision.add(new ThesaurusConcept());
		assertTrue((service.buildSynonymsStructure(conceptsAtRevision, 1, "mpeg").get("value")).isEmpty());
	}

	@Test
	public void buildSynonymsStructure2() {
		List<ThesaurusTerm> list = new ArrayList<ThesaurusTerm>();
		ThesaurusTerm thesaurusTerm1 = new ThesaurusTerm();
		thesaurusTerm1.setLexicalValue("value");
		list.add(thesaurusTerm1);
		ThesaurusTerm thesaurusTerm2 = new ThesaurusTerm();
		thesaurusTerm2.setLexicalValue("value");
		when(auditHelper.getConceptTermsAtRevision(Mockito.<ThesaurusConcept>any(), Mockito.<Number>any(), Mockito.<String>any()))
			.thenReturn(list);
		when(auditHelper.getPreferredTermAtRevision(Mockito.<Number>any(), Mockito.<String>any(), Mockito.<String>any()))
			.thenReturn(thesaurusTerm2);
		ArrayList<ThesaurusConcept> conceptsAtRevision =
			 new ArrayList<ThesaurusConcept>();
		conceptsAtRevision.add(new ThesaurusConcept());
		assertTrue((service.buildSynonymsStructure(conceptsAtRevision, 1, "mpeg").get("value")).isEmpty());
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
