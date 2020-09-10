package fr.mcc.ginco.audit.commands;

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
	public void buildAddedPrefTermsLinesCurrentTermsIsEmptyAndPreviousTermsIsEmptyReturnsEmpty() {
		when(mistralStructuresBuilder.getNotPreferredTermsByTerm(Mockito.<List<ThesaurusTerm>>any()))
			.thenReturn(new HashMap<String, List<ThesaurusTerm>>());
		when(mistralStructuresBuilder.getTermVersionsView(Mockito.<List<ThesaurusTerm>>any()))
			.thenReturn(new HashMap<String, ThesaurusTerm>());
		assertTrue((service.buildAddedPrefTermsLines(new ArrayList<ThesaurusTerm>(), new ArrayList<ThesaurusTerm>())).isEmpty());
	}

	@Test
	public void buildChangedTermsLinesCurrentTermsIsEmptyAndPreviousTermsIsEmptyReturnsEmpty() {
		when(mistralStructuresBuilder.getNotPreferredTermsByTerm(Mockito.<List<ThesaurusTerm>>any()))
			.thenReturn(new HashMap<String, List<ThesaurusTerm>>());
		when(mistralStructuresBuilder.getTermVersionsView(Mockito.<List<ThesaurusTerm>>any()))
			.thenReturn(new HashMap<String, ThesaurusTerm>());
		assertTrue((service.buildChangedTermsLines(new ArrayList<ThesaurusTerm>(), new ArrayList<ThesaurusTerm>())).isEmpty());
	}

	@Test
	public void buildDeletedTermsLinesCurrentTermsIsEmptyAndPreviousTermsIsEmptyReturnsEmpty() {
		when(mistralStructuresBuilder.getTermVersionsView(Mockito.<List<ThesaurusTerm>>any()))
			.thenReturn(new HashMap<String, ThesaurusTerm>());
		assertTrue((service.buildDeletedTermsLines(new ArrayList<ThesaurusTerm>(), new ArrayList<ThesaurusTerm>())).isEmpty());
	}
}
