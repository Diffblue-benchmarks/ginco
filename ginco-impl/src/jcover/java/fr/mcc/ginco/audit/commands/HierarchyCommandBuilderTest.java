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
 * Unit tests for fr.mcc.ginco.audit.commands.HierarchyCommandBuilder
 *
 * @author Diffblue Cover
 */

public class HierarchyCommandBuilderTest {

	@Mock(name = "mistralStructuresBuilder")
	private MistralStructuresBuilder mistralStructuresBuilder;

	@InjectMocks
	private HierarchyCommandBuilder service;

	@Before public void initMocks() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void buildHierarchyChangesCurrentConceptsIsEmptyAndCurrentRevisionIsOneAndLangIsDiffblueAndOldRevisionIsOneAndPreviousConceptsIsEmptyReturnsEmpty() {
		when(mistralStructuresBuilder.buildHierarchyStructure(Mockito.<List<ThesaurusConcept>>any(), Mockito.<Number>any(), Mockito.<String>any()))
			.thenReturn(new HashMap<String, List<String>>())
			.thenReturn(new HashMap<String, List<String>>());
		assertTrue(service.buildHierarchyChanges(new ArrayList<ThesaurusConcept>(), new ArrayList<ThesaurusConcept>(), 1, 1, "Diffblue").isEmpty());
	}
}
