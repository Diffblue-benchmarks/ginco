package fr.mcc.ginco.audit.commands;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import fr.mcc.ginco.beans.ThesaurusConcept;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	public void buildSynonyms1() {

		// arrange
		Map<String, List<String>> map1 = new HashMap<String, List<String>>();
		ArrayList<String> x104 = new ArrayList<String>();
		x104.add("foo");
		map1.put("foo", x104);
		Map<String, List<String>> map2 = new HashMap<String, List<String>>();
		map2.put("foo", new ArrayList<String>());
		when(mistralStructuresBuilder.buildSynonymsStructure(Mockito.<List<ThesaurusConcept>>any(), Mockito.<Number>any(), Mockito.<String>any()))
			.thenReturn(map2)
			.thenReturn(map1);

		// act
		List<CommandLine> result =
			 service.buildSynonyms(new ArrayList<ThesaurusConcept>(), new ArrayList<ThesaurusConcept>(), 1, 1, "Diffblue");

		// assert
		assertEquals(1, result.size());
		assertEquals("foo = foo", result.get(0).getValue());
	}

	@Test
	public void buildSynonyms2() {

		// arrange
		Map<String, List<String>> map1 = new HashMap<String, List<String>>();
		map1.put("foo", new ArrayList<String>());
		Map<String, List<String>> map2 = new HashMap<String, List<String>>();
		ArrayList<String> x46 = new ArrayList<String>();
		x46.add("foo");
		map2.put("foo", x46);
		when(mistralStructuresBuilder.buildSynonymsStructure(Mockito.<List<ThesaurusConcept>>any(), Mockito.<Number>any(), Mockito.<String>any()))
			.thenReturn(map2)
			.thenReturn(map1);

		// act
		List<CommandLine> result =
			 service.buildSynonyms(new ArrayList<ThesaurusConcept>(), new ArrayList<ThesaurusConcept>(), 1, 1, "Diffblue");

		// assert
		assertEquals(1, result.size());
		assertEquals("S, foo", result.get(0).getValue());
	}

	@Test
	public void buildSynonymsOldRevisionIsZeroReturnsEmpty() {
		Map<String, List<String>> map1 = new HashMap<String, List<String>>();
		map1.put("foo", new ArrayList<String>());
		Map<String, List<String>> map2 = new HashMap<String, List<String>>();
		map2.put("foo", new ArrayList<String>());
		when(mistralStructuresBuilder.buildSynonymsStructure(Mockito.<List<ThesaurusConcept>>any(), Mockito.<Number>any(), Mockito.<String>any()))
			.thenReturn(map2)
			.thenReturn(map1);
		assertTrue((service.buildSynonyms(new ArrayList<ThesaurusConcept>(), new ArrayList<ThesaurusConcept>(), 0, 1, "Diffblue")).isEmpty());
	}

	@Test
	public void buildSynonymsReturnsEmpty() {
		Map<String, List<String>> map1 = new HashMap<String, List<String>>();
		map1.put("bar", new ArrayList<String>());
		Map<String, List<String>> map2 = new HashMap<String, List<String>>();
		map2.put("foo", new ArrayList<String>());
		when(mistralStructuresBuilder.buildSynonymsStructure(Mockito.<List<ThesaurusConcept>>any(), Mockito.<Number>any(), Mockito.<String>any()))
			.thenReturn(map2)
			.thenReturn(map1);
		assertTrue((service.buildSynonyms(new ArrayList<ThesaurusConcept>(), new ArrayList<ThesaurusConcept>(), 1, 1, "Diffblue")).isEmpty());
	}
}
