package fr.mcc.ginco.imports.ginco.idgenerator;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

/**
 * Unit tests for fr.mcc.ginco.imports.ginco.idgenerator.GincoIdMapParser
 *
 * @author Diffblue Cover
 */

public class GincoIdMapParserTest {

	@InjectMocks
	private GincoIdMapParser service;

	@Before public void initMocks() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void getNewId1() throws java.io.IOException, CloneNotSupportedException {
		assertEquals("1234", service.getNewId("1234", new HashMap<String, String>()));
	}

	@Test
	public void getNewId2() throws java.io.IOException, CloneNotSupportedException {
		HashMap<String, String> idMapping = new HashMap<String, String>();
		idMapping.put("1234", "");
		assertEquals("1234", service.getNewId("1234", idMapping));
	}

	@Test
	public void getNewIdReturnsFoo() throws java.io.IOException, CloneNotSupportedException {
		HashMap<String, String> idMapping = new HashMap<String, String>();
		idMapping.put("1234", "foo");
		assertEquals("foo", service.getNewId("1234", idMapping));
	}
}
