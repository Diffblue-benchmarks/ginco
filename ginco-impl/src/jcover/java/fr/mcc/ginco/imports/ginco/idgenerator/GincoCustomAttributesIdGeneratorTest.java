package fr.mcc.ginco.imports.ginco.idgenerator;

import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import fr.mcc.ginco.beans.CustomConceptAttribute;
import fr.mcc.ginco.beans.CustomTermAttribute;
import fr.mcc.ginco.beans.ThesaurusConcept;
import fr.mcc.ginco.beans.ThesaurusTerm;
import fr.mcc.ginco.exports.result.bean.JaxbList;

import java.util.ArrayList;
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

	@Before
	public void initMocks() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void getIdsForCustomConceptAttributes() {
		when(gincoIdMapParser.getNewId(Mockito.<String>any(), Mockito.<java.util.Map<String, String>>any()))
			.thenReturn("1234");
		HashMap<String, JaxbList<CustomConceptAttribute>> customConceptAttributes =
			 new HashMap<String, JaxbList<CustomConceptAttribute>>();
		JaxbList<CustomConceptAttribute> jaxbList =
			 new JaxbList<CustomConceptAttribute>();
		customConceptAttributes.put("", jaxbList);
		assertSame(jaxbList, service.getIdsForCustomConceptAttributes(customConceptAttributes, new HashMap<String, String>()).get("1234"));
	}

	@Test
	public void getIdsForCustomConceptAttributesCustomConceptAttributesIsEmptyReturnsEmpty() {
		assertTrue(service.getIdsForCustomConceptAttributes(new HashMap<String, JaxbList<CustomConceptAttribute>>(), new HashMap<String, String>()).isEmpty());
	}

	@Test
	public void getIdsForCustomConceptAttributesIdMappingIsFoo() {
		when(gincoIdMapParser.getNewId(Mockito.<String>any(), Mockito.<java.util.Map<String, String>>any()))
			.thenReturn("1234");
		HashMap<String, JaxbList<CustomConceptAttribute>> customConceptAttributes =
			 new HashMap<String, JaxbList<CustomConceptAttribute>>();
		ArrayList<CustomConceptAttribute> list =
			 new ArrayList<CustomConceptAttribute>();
		CustomConceptAttribute customConceptAttribute = new CustomConceptAttribute();
		customConceptAttribute.setEntity(new ThesaurusConcept());
		list.add(customConceptAttribute);
		JaxbList<CustomConceptAttribute> jaxbList =
			 new JaxbList<CustomConceptAttribute>(list);
		customConceptAttributes.put("", jaxbList);
		HashMap<String, String> idMapping = new HashMap<String, String>();
		idMapping.put("", "foo");
		assertSame(jaxbList, service.getIdsForCustomConceptAttributes(customConceptAttributes, idMapping).get("1234"));
	}

	@Test
	public void getIdsForCustomTermAttributes() {
		when(gincoIdMapParser.getNewId(Mockito.<String>any(), Mockito.<java.util.Map<String, String>>any()))
			.thenReturn("1234");
		HashMap<String, JaxbList<CustomTermAttribute>> customTermAttributes =
			 new HashMap<String, JaxbList<CustomTermAttribute>>();
		JaxbList<CustomTermAttribute> jaxbList = new JaxbList<CustomTermAttribute>();
		customTermAttributes.put("", jaxbList);
		assertSame(jaxbList, service.getIdsForCustomTermAttributes(customTermAttributes, new HashMap<String, String>()).get("1234"));
	}

	@Test
	public void getIdsForCustomTermAttributesCustomTermAttributesIsEmptyReturnsEmpty() {
		assertTrue(service.getIdsForCustomTermAttributes(new HashMap<String, JaxbList<CustomTermAttribute>>(), new HashMap<String, String>()).isEmpty());
	}

	@Test
	public void getIdsForCustomTermAttributesIdMappingIsFoo() {
		when(gincoIdMapParser.getNewId(Mockito.<String>any(), Mockito.<java.util.Map<String, String>>any()))
			.thenReturn("1234");
		HashMap<String, JaxbList<CustomTermAttribute>> customTermAttributes =
			 new HashMap<String, JaxbList<CustomTermAttribute>>();
		ArrayList<CustomTermAttribute> list = new ArrayList<CustomTermAttribute>();
		CustomTermAttribute customTermAttribute = new CustomTermAttribute();
		customTermAttribute.setEntity(new ThesaurusTerm());
		list.add(customTermAttribute);
		JaxbList<CustomTermAttribute> jaxbList =
			 new JaxbList<CustomTermAttribute>(list);
		customTermAttributes.put("", jaxbList);
		HashMap<String, String> idMapping = new HashMap<String, String>();
		idMapping.put("", "foo");
		assertSame(jaxbList, service.getIdsForCustomTermAttributes(customTermAttributes, idMapping).get("1234"));
	}
}
