package fr.mcc.ginco.imports;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import com.hp.hpl.jena.rdf.model.ModelFactory;

import fr.mcc.ginco.skos.namespaces.GINCO;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

/**
 * Unit tests for fr.mcc.ginco.imports.SKOSImportUtils
 *
 * @author Diffblue Cover
 */

public class SKOSImportUtilsTest {

	@InjectMocks
	private SKOSImportUtils service;

	@Before public void initMocks() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void getSkosDateSkosDateIsEmpty() {
		assertEquals(true, Math.abs(service.getSkosDate("").getTime()-new Date().getTime())<=10_000L);
	}

	@Test
	public void getSKOSRessourcesModelIsEmptyReturnsEmpty() {
		assertTrue((service.getSKOSRessources(ModelFactory.createDefaultModel(), GINCO.getResource("BASIC"))).isEmpty());
	}
}
