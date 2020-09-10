package fr.mcc.ginco.exports.ginco;

import static org.junit.Assert.assertTrue;

import fr.mcc.ginco.beans.ThesaurusConcept;
import fr.mcc.ginco.beans.ThesaurusTerm;
import fr.mcc.ginco.services.ICustomConceptAttributeService;
import fr.mcc.ginco.services.ICustomTermAttributeService;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

/**
 * Unit tests for fr.mcc.ginco.exports.ginco.GincoAttributesExporter
 *
 * @author Diffblue Cover
 */

public class GincoAttributesExporterTest {

	@Mock(name = "conceptAttributeService")
	private ICustomConceptAttributeService conceptAttributeService;

	@Mock(name = "termAttributeService")
	private ICustomTermAttributeService termAttributeService;

	@InjectMocks
	private GincoAttributesExporter service;

	@Before public void initMocks() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void getExportedConceptAttributes() {
		assertTrue((service.getExportedConceptAttributes(new ThesaurusConcept()).getList()).isEmpty());
	}

	@Test
	public void getExportedTermAttributes() {
		assertTrue((service.getExportedTermAttributes(new ThesaurusTerm()).getList()).isEmpty());
	}
}
