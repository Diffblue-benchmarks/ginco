package fr.mcc.ginco.audit.commands;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import fr.mcc.ginco.beans.ThesaurusTerm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

/**
 * Unit tests for fr.mcc.ginco.audit.commands.TermCommandBuilder
 *
 * @author Diffblue Cover
 */

public class TermCommandBuilderTest {

	@Mock(name = "mistralStructuresBuilder")
	private MistralStructuresBuilder mistralStructuresBuilder;

	@InjectMocks
	private TermCommandBuilder service;

	@Before public void initMocks() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void buildDeletedTermsLines() {

		// arrange
		when(mistralStructuresBuilder.getTermVersionsView(Mockito.<List<ThesaurusTerm>>any()))
			.thenReturn(new HashMap<String, ThesaurusTerm>());
		ArrayList<ThesaurusTerm> previousTerms = new ArrayList<ThesaurusTerm>();
		ThesaurusTerm thesaurusTerm1 = new ThesaurusTerm();
		thesaurusTerm1.setLexicalValue("value");
		previousTerms.add(thesaurusTerm1);

		// act
		List<CommandLine> result =
			 service.buildDeletedTermsLines(previousTerms, new ArrayList<ThesaurusTerm>());

		// assert
		assertEquals(1, result.size());
		assertEquals("R, value", result.get(0).getValue());
	}

	@Test
	public void buildDeletedTermsLinesReturnsEmpty() {
		HashMap<String, ThesaurusTerm> thesaurusTermMap =
			 new HashMap<String, ThesaurusTerm>();
		thesaurusTermMap.put("value", new ThesaurusTerm());
		when(mistralStructuresBuilder.getTermVersionsView(Mockito.<List<ThesaurusTerm>>any()))
			.thenReturn(thesaurusTermMap);
		ArrayList<ThesaurusTerm> previousTerms = new ArrayList<ThesaurusTerm>();
		ThesaurusTerm thesaurusTerm2 = new ThesaurusTerm();
		thesaurusTerm2.setLexicalValue("value");
		previousTerms.add(thesaurusTerm2);
		assertTrue(service.buildDeletedTermsLines(previousTerms, new ArrayList<ThesaurusTerm>()).isEmpty());
	}

	@Test
	public void buildChangedTermsLines1() {
		when(mistralStructuresBuilder.getNotPreferredTermsByTerm(Mockito.<List<ThesaurusTerm>>any()))
			.thenReturn(new HashMap<String, List<ThesaurusTerm>>());
		when(mistralStructuresBuilder.getTermVersionsView(Mockito.<List<ThesaurusTerm>>any()))
			.thenReturn(new HashMap<String, ThesaurusTerm>());
		ArrayList<ThesaurusTerm> previousTerms = new ArrayList<ThesaurusTerm>();
		previousTerms.add(new ThesaurusTerm());
		assertTrue(service.buildChangedTermsLines(previousTerms, new ArrayList<ThesaurusTerm>()).isEmpty());
	}

	@Test
	public void buildChangedTermsLines2() {
		HashMap<String, ThesaurusTerm> thesaurusTermMap =
			 new HashMap<String, ThesaurusTerm>();
		ThesaurusTerm thesaurusTerm1 = new ThesaurusTerm();
		thesaurusTerm1.setPrefered(false);
		thesaurusTermMap.put("value", thesaurusTerm1);
		when(mistralStructuresBuilder.getNotPreferredTermsByTerm(Mockito.<List<ThesaurusTerm>>any()))
			.thenReturn(new HashMap<String, List<ThesaurusTerm>>());
		when(mistralStructuresBuilder.getTermVersionsView(Mockito.<List<ThesaurusTerm>>any()))
			.thenReturn(thesaurusTermMap);
		ArrayList<ThesaurusTerm> previousTerms = new ArrayList<ThesaurusTerm>();
		ThesaurusTerm thesaurusTerm2 = new ThesaurusTerm();
		thesaurusTerm2.setLexicalValue("value");
		thesaurusTerm2.setPrefered(false);
		previousTerms.add(thesaurusTerm2);
		assertTrue(service.buildChangedTermsLines(previousTerms, new ArrayList<ThesaurusTerm>()).isEmpty());
	}

	@Test
	public void buildAddedPrefTermsLines1() {
		when(mistralStructuresBuilder.getNotPreferredTermsByTerm(Mockito.<List<ThesaurusTerm>>any()))
			.thenReturn(new HashMap<String, List<ThesaurusTerm>>());
		when(mistralStructuresBuilder.getTermVersionsView(Mockito.<List<ThesaurusTerm>>any()))
			.thenReturn(new HashMap<String, ThesaurusTerm>());
		ArrayList<ThesaurusTerm> currentTerms = new ArrayList<ThesaurusTerm>();
		ThesaurusTerm thesaurusTerm2 = new ThesaurusTerm();
		thesaurusTerm2.setPrefered(false);
		currentTerms.add(thesaurusTerm2);
		assertTrue(service.buildAddedPrefTermsLines(new ArrayList<ThesaurusTerm>(), currentTerms).isEmpty());
	}

	@Test
	public void buildAddedPrefTermsLines2() {
		HashMap<String, ThesaurusTerm> thesaurusTermMap =
			 new HashMap<String, ThesaurusTerm>();
		thesaurusTermMap.put("value", new ThesaurusTerm());
		when(mistralStructuresBuilder.getNotPreferredTermsByTerm(Mockito.<List<ThesaurusTerm>>any()))
			.thenReturn(new HashMap<String, List<ThesaurusTerm>>());
		when(mistralStructuresBuilder.getTermVersionsView(Mockito.<List<ThesaurusTerm>>any()))
			.thenReturn(thesaurusTermMap);
		ArrayList<ThesaurusTerm> currentTerms = new ArrayList<ThesaurusTerm>();
		ThesaurusTerm thesaurusTerm3 = new ThesaurusTerm();
		thesaurusTerm3.setPrefered(false);
		currentTerms.add(thesaurusTerm3);
		assertTrue(service.buildAddedPrefTermsLines(new ArrayList<ThesaurusTerm>(), currentTerms).isEmpty());
	}
}
