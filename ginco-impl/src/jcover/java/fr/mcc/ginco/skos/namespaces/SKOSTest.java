package fr.mcc.ginco.skos.namespaces;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Unit tests for fr.mcc.ginco.skos.namespaces.SKOS
 *
 * @author Diffblue Cover
 */

public class SKOSTest {

	@Test
	public void getURI() {
		assertEquals("http://www.w3.org/2004/02/skos/core#", SKOS.getURI());
	}
}
