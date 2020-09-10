package fr.mcc.ginco.imports.ginco.idgenerator;

import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.when;

import fr.mcc.ginco.beans.CustomConceptAttribute;
import fr.mcc.ginco.beans.CustomTermAttribute;
import fr.mcc.ginco.exports.result.bean.JaxbList;

import java.util.HashMap;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

/**
 * Unit tests for fr.mcc.ginco.imports.ginco.idgenerator.GincoCustomAttributesIdGenerator
 *
 * @author Diffblue Cover
 */

public class GincoCustomAttributesIdGeneratorTest {

	@Mock(name = "gincoIdMapParser")
	private GincoIdMapParser gincoIdMapParser;

	@InjectMocks
	private GincoCustomAttributesIdGenerator service;

	@Before public void initMocks() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void getIdsForCustomConceptAttributesIdMappingIsEmpty() {
		when(gincoIdMapParser.getNewId(Mockito.<String>any(), Mockito.<java.util.Map<String, String>>any()))
			.thenReturn("bar");
		HashMap<String, JaxbList<CustomConceptAttribute>> customConceptAttributes = new HashMap<String, JaxbList<CustomConceptAttribute>>();
		JaxbList<CustomConceptAttribute> x5 = new JaxbList<CustomConceptAttribute>();
		customConceptAttributes.put("foo", x5);
		assertSame(x5, service.getIdsForCustomConceptAttributes(customConceptAttributes, new HashMap<String, String>()).get("bar"));
	}

	@Test
	public void getIdsForCustomTermAttributesIdMappingIsEmpty() {
		when(gincoIdMapParser.getNewId(Mockito.<String>any(), Mockito.<java.util.Map<String, String>>any()))
			.thenReturn("bar");
		HashMap<String, JaxbList<CustomTermAttribute>> customTermAttributes = new HashMap<String, JaxbList<CustomTermAttribute>>();
		JaxbList<CustomTermAttribute> x30 = new JaxbList<CustomTermAttribute>();
		customTermAttributes.put("foo", x30);
		assertSame(x30, service.getIdsForCustomTermAttributes(customTermAttributes, new HashMap<String, String>()).get("bar"));
	}
}
