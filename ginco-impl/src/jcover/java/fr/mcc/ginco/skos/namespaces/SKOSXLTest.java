package fr.mcc.ginco.skos.namespaces;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Unit tests for fr.mcc.ginco.skos.namespaces.SKOSXL
 *
 * @author Diffblue Cover
 */

public class SKOSXLTest {

	@Test
	public void getURI() {
		assertEquals("http://www.w3.org/2008/05/skos-xl#", SKOSXL.getURI());
	}
}
