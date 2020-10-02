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
	public void buildDeletedTermsLinesCurrentTermsIsEmpty() {

		// arrange
		when(mistralStructuresBuilder.getTermVersionsView(Mockito.<List<ThesaurusTerm>>any()))
			.thenReturn(new HashMap<String, ThesaurusTerm>());
		ArrayList<ThesaurusTerm> previousTerms = new ArrayList<ThesaurusTerm>();
		ThesaurusTerm thesaurusTerm3 = new ThesaurusTerm();
		thesaurusTerm3.setLexicalValue("value");
		previousTerms.add(thesaurusTerm3);

		// act
		List<CommandLine> result =
			 service.buildDeletedTermsLines(previousTerms, new ArrayList<ThesaurusTerm>());

		// assert
		assertEquals(1, result.size());
		assertEquals("R, value", result.get(0).getValue());
	}

	@Test
	public void buildChangedTermsLinesCurrentTermsIsEmptyReturnsEmpty() {
		when(mistralStructuresBuilder.getNotPreferredTermsByTerm(Mockito.<List<ThesaurusTerm>>any()))
			.thenReturn(new HashMap<String, List<ThesaurusTerm>>());
		when(mistralStructuresBuilder.getTermVersionsView(Mockito.<List<ThesaurusTerm>>any()))
			.thenReturn(new HashMap<String, ThesaurusTerm>());
		ArrayList<ThesaurusTerm> previousTerms = new ArrayList<ThesaurusTerm>();
		previousTerms.add(new ThesaurusTerm());
		assertTrue((service.buildChangedTermsLines(previousTerms, new ArrayList<ThesaurusTerm>())).isEmpty());
	}

	@Test
	public void buildAddedPrefTermsLinesPreviousTermsIsEmptyReturnsEmpty() {
		when(mistralStructuresBuilder.getNotPreferredTermsByTerm(Mockito.<List<ThesaurusTerm>>any()))
			.thenReturn(new HashMap<String, List<ThesaurusTerm>>());
		when(mistralStructuresBuilder.getTermVersionsView(Mockito.<List<ThesaurusTerm>>any()))
			.thenReturn(new HashMap<String, ThesaurusTerm>());
		ArrayList<ThesaurusTerm> currentTerms = new ArrayList<ThesaurusTerm>();
		ThesaurusTerm thesaurusTerm5 = new ThesaurusTerm();
		thesaurusTerm5.setPrefered(false);
		currentTerms.add(thesaurusTerm5);
		assertTrue((service.buildAddedPrefTermsLines(new ArrayList<ThesaurusTerm>(), currentTerms)).isEmpty());
	}
}
