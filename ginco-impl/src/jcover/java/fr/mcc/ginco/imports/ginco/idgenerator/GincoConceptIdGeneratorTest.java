package fr.mcc.ginco.imports.ginco.idgenerator;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import fr.mcc.ginco.ark.IIDGeneratorService;

import java.util.HashMap;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

/**
 * Unit tests for fr.mcc.ginco.imports.ginco.idgenerator.GincoConceptIdGenerator
 *
 * @author Diffblue Cover
 */

public class GincoConceptIdGeneratorTest {

	@Mock(name = "generatorService")
	private IIDGeneratorService generatorService;

	@Mock(name = "gincoIdMapParser")
	private GincoIdMapParser gincoIdMapParser;

	@InjectMocks
	private GincoConceptIdGenerator service;

	@Before public void initMocks() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void getIdForConcept1() {
		when(gincoIdMapParser.getNewId(Mockito.<String>any(), Mockito.<java.util.Map<String, String>>any()))
			.thenReturn("");
		when(generatorService.generate(Mockito.<Class>any()))
			.thenReturn(" with new id ");
		HashMap<String, String> idMapping = new HashMap<String, String>();
		assertEquals(" with new id ", service.getIdForConcept("1234", idMapping));
		assertEquals(" with new id ", idMapping.get("1234"));
	}

	@Test
	public void getIdForConcept2() {
		when(gincoIdMapParser.getNewId(Mockito.<String>any(), Mockito.<java.util.Map<String, String>>any()))
			.thenReturn(" with new id ");
		assertEquals(" with new id ", service.getIdForConcept("1234", new HashMap<String, String>()));
	}

	@Test
	public void getIdForConcept3() {
		when(gincoIdMapParser.getNewId(Mockito.<String>any(), Mockito.<java.util.Map<String, String>>any()))
			.thenReturn("1234");
		when(generatorService.generate(Mockito.<Class>any()))
			.thenReturn(" with new id ");
		HashMap<String, String> idMapping = new HashMap<String, String>();
		assertEquals(" with new id ", service.getIdForConcept("1234", idMapping));
		assertEquals(" with new id ", idMapping.get("1234"));
	}
}
