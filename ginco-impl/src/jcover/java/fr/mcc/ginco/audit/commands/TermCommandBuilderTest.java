package fr.mcc.ginco.audit.commands;

import static org.junit.Assert.assertEquals;
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
}
