package fr.mcc.ginco.audit.commands;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import fr.mcc.ginco.beans.ThesaurusConcept;

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
 * Unit tests for fr.mcc.ginco.audit.commands.SynonymsCommandBuilder
 *
 * @author Diffblue Cover
 */

public class SynonymsCommandBuilderTest {

	@Mock(name = "mistralStructuresBuilder")
	private MistralStructuresBuilder mistralStructuresBuilder;

	@InjectMocks
	private SynonymsCommandBuilder service;

	@Before public void initMocks() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void buildSynonymsCurrentConceptsIsEmptyAndCurrentRevisionIsOneAndLangIsDiffblueAndOldRevisionIsOneAndPreviousConceptsIsEmptyReturnsEmpty() {
		when(mistralStructuresBuilder.buildSynonymsStructure(Mockito.<List<ThesaurusConcept>>any(), Mockito.<Number>any(), Mockito.<String>any()))
			.thenReturn(new HashMap<String, List<String>>())
			.thenReturn(new HashMap<String, List<String>>());
		assertTrue((service.buildSynonyms(new ArrayList<ThesaurusConcept>(), new ArrayList<ThesaurusConcept>(), 1, 1, "Diffblue")).isEmpty());
	}
}
