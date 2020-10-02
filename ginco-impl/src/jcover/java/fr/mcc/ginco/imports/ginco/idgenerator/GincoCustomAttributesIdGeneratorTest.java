package fr.mcc.ginco.imports.ginco.idgenerator;

import static org.junit.Assert.assertTrue;

import fr.mcc.ginco.beans.CustomConceptAttribute;
import fr.mcc.ginco.beans.CustomTermAttribute;
import fr.mcc.ginco.exports.result.bean.JaxbList;

import java.util.HashMap;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
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
	public void getIdsForCustomConceptAttributesReturnsEmpty() throws java.io.IOException, CloneNotSupportedException {
		assertTrue(service.getIdsForCustomConceptAttributes(new HashMap<String, JaxbList<CustomConceptAttribute>>(), new HashMap<String, String>()).isEmpty());
	}

	@Test
	public void getIdsForCustomTermAttributesReturnsEmpty() throws java.io.IOException, CloneNotSupportedException {
		assertTrue(service.getIdsForCustomTermAttributes(new HashMap<String, JaxbList<CustomTermAttribute>>(), new HashMap<String, String>()).isEmpty());
	}
}
