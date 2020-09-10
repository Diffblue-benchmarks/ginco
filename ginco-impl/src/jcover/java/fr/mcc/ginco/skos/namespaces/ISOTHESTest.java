package fr.mcc.ginco.skos.namespaces;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Unit tests for fr.mcc.ginco.skos.namespaces.ISOTHES
 *
 * @author Diffblue Cover
 */

public class ISOTHESTest {

	@Test
	public void getURI() {
		assertEquals("http://purl.org/iso25964/skos-thes#", ISOTHES.getURI());
	}
}
