package fr.mcc.ginco.skos.namespaces;

import static org.junit.Assert.assertEquals;

import com.hp.hpl.jena.rdf.model.Resource;

import org.junit.Test;

/**
 * Unit tests for fr.mcc.ginco.skos.namespaces.GINCO
 *
 * @author Diffblue Cover
 */

public class GINCOTest {

	@Test
	public void getURI() {
		assertEquals("http://data.culture.fr/thesaurus/ginco/ns/", GINCO.getURI());
	}

	@Test
	public void getResourceURITypeIsBASIC() {
		assertEquals("http://data.culture.fr/thesaurus/ginco/ns/BASIC", GINCO.getResourceURI("BASIC"));
	}

	@Test
	public void getResourceTypeIsBASIC() {
		Resource result = GINCO.getResource("BASIC");
		assertEquals("BASIC", result.getLocalName());
		assertEquals("http://data.culture.fr/thesaurus/ginco/ns/", result.getNameSpace());
		assertEquals("http://data.culture.fr/thesaurus/ginco/ns/BASIC", result.getURI());
	}
}
