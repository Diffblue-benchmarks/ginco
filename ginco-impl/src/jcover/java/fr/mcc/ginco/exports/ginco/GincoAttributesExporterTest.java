package fr.mcc.ginco.exports.ginco;

import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.when;

import fr.mcc.ginco.beans.CustomConceptAttribute;
import fr.mcc.ginco.beans.CustomTermAttribute;
import fr.mcc.ginco.beans.ThesaurusConcept;
import fr.mcc.ginco.beans.ThesaurusTerm;
import fr.mcc.ginco.services.ICustomConceptAttributeService;
import fr.mcc.ginco.services.ICustomTermAttributeService;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
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
		List<CustomConceptAttribute> list = new ArrayList<CustomConceptAttribute>();
		when(conceptAttributeService.getAttributesByEntity(Mockito.<ThesaurusConcept>any()))
			.thenReturn(list);
		assertSame(list, service.getExportedConceptAttributes(new ThesaurusConcept()).getList());
	}

	@Test
	public void getExportedTermAttributes() {
		List<CustomTermAttribute> list = new ArrayList<CustomTermAttribute>();
		when(termAttributeService.getAttributesByEntity(Mockito.<ThesaurusTerm>any()))
			.thenReturn(list);
		assertSame(list, service.getExportedTermAttributes(new ThesaurusTerm()).getList());
	}
}