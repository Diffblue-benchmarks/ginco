package fr.mcc.ginco.exports.ginco;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.when;

import fr.mcc.ginco.beans.CustomConceptAttribute;
import fr.mcc.ginco.beans.CustomTermAttribute;
import fr.mcc.ginco.beans.ThesaurusConcept;
import fr.mcc.ginco.beans.ThesaurusTerm;
import fr.mcc.ginco.exports.result.bean.JaxbList;
import fr.mcc.ginco.services.ICustomConceptAttributeService;
import fr.mcc.ginco.services.ICustomTermAttributeService;

import java.util.ArrayList;

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

		// arrange
		ArrayList<CustomConceptAttribute> customConceptAttributeList =
			 new ArrayList<CustomConceptAttribute>();
		CustomConceptAttribute customConceptAttribute = new CustomConceptAttribute();
		customConceptAttributeList.add(customConceptAttribute);
		when(conceptAttributeService.getAttributesByEntity(Mockito.<ThesaurusConcept>any()))
			.thenReturn(customConceptAttributeList);

		// act
		JaxbList<CustomConceptAttribute> result =
			 service.getExportedConceptAttributes(new ThesaurusConcept());

		// assert
		assertEquals(1, result.getList().size());
		assertSame(customConceptAttribute, result.getList().get(0));
	}

	@Test
	public void getExportedTermAttributes() {

		// arrange
		ArrayList<CustomTermAttribute> customTermAttributeList =
			 new ArrayList<CustomTermAttribute>();
		CustomTermAttribute customTermAttribute = new CustomTermAttribute();
		customTermAttributeList.add(customTermAttribute);
		when(termAttributeService.getAttributesByEntity(Mockito.<ThesaurusTerm>any()))
			.thenReturn(customTermAttributeList);

		// act
		JaxbList<CustomTermAttribute> result =
			 service.getExportedTermAttributes(new ThesaurusTerm());

		// assert
		assertEquals(1, result.getList().size());
		assertSame(customTermAttribute, result.getList().get(0));
	}
}
