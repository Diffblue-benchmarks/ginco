package fr.mcc.ginco.imports.ginco.idgenerator;

import static org.junit.Assert.assertSame;
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

	@Before public void initMocks() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void getIdsForCustomConceptAttributes1() {
		when(gincoIdMapParser.getNewId(Mockito.<String>any(), Mockito.<java.util.Map<String, String>>any()))
			.thenReturn("1234");
		HashMap<String, JaxbList<CustomConceptAttribute>> customConceptAttributes =
			 new HashMap<String, JaxbList<CustomConceptAttribute>>();
		ArrayList<CustomConceptAttribute> list1 =
			 new ArrayList<CustomConceptAttribute>();
		CustomConceptAttribute customConceptAttribute1 =
			 new CustomConceptAttribute();
		customConceptAttribute1.setEntity(new ThesaurusConcept());
		list1.add(customConceptAttribute1);
		JaxbList<CustomConceptAttribute> x5 =
			 new JaxbList<CustomConceptAttribute>(list1);
		customConceptAttributes.put("HmacMD5", x5);
		assertSame(x5, service.getIdsForCustomConceptAttributes(customConceptAttributes, new HashMap<String, String>()).get("1234"));
	}

	@Test
	public void getIdsForCustomConceptAttributes2() {
		when(gincoIdMapParser.getNewId(Mockito.<String>any(), Mockito.<java.util.Map<String, String>>any()))
			.thenReturn("1234");
		HashMap<String, JaxbList<CustomConceptAttribute>> customConceptAttributes =
			 new HashMap<String, JaxbList<CustomConceptAttribute>>();
		JaxbList<CustomConceptAttribute> x5 = new JaxbList<CustomConceptAttribute>();
		customConceptAttributes.put("HmacMD5", x5);
		assertSame(x5, service.getIdsForCustomConceptAttributes(customConceptAttributes, new HashMap<String, String>()).get("1234"));
	}

	@Test
	public void getIdsForCustomTermAttributes1() {
		when(gincoIdMapParser.getNewId(Mockito.<String>any(), Mockito.<java.util.Map<String, String>>any()))
			.thenReturn("1234");
		HashMap<String, JaxbList<CustomTermAttribute>> customTermAttributes =
			 new HashMap<String, JaxbList<CustomTermAttribute>>();
		ArrayList<CustomTermAttribute> list1 = new ArrayList<CustomTermAttribute>();
		CustomTermAttribute customTermAttribute1 = new CustomTermAttribute();
		customTermAttribute1.setEntity(new ThesaurusTerm());
		list1.add(customTermAttribute1);
		JaxbList<CustomTermAttribute> x30 = new JaxbList<CustomTermAttribute>(list1);
		customTermAttributes.put("HmacMD5", x30);
		assertSame(x30, service.getIdsForCustomTermAttributes(customTermAttributes, new HashMap<String, String>()).get("1234"));
	}

	@Test
	public void getIdsForCustomTermAttributes2() {
		when(gincoIdMapParser.getNewId(Mockito.<String>any(), Mockito.<java.util.Map<String, String>>any()))
			.thenReturn("1234");
		HashMap<String, JaxbList<CustomTermAttribute>> customTermAttributes =
			 new HashMap<String, JaxbList<CustomTermAttribute>>();
		JaxbList<CustomTermAttribute> x30 = new JaxbList<CustomTermAttribute>();
		customTermAttributes.put("HmacMD5", x30);
		assertSame(x30, service.getIdsForCustomTermAttributes(customTermAttributes, new HashMap<String, String>()).get("1234"));
	}
}
