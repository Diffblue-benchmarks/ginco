package fr.mcc.ginco.imports.ginco;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import fr.mcc.ginco.beans.CustomConceptAttribute;
import fr.mcc.ginco.beans.CustomConceptAttributeType;
import fr.mcc.ginco.beans.CustomTermAttribute;
import fr.mcc.ginco.beans.CustomTermAttributeType;
import fr.mcc.ginco.beans.Thesaurus;
import fr.mcc.ginco.beans.ThesaurusConcept;
import fr.mcc.ginco.beans.ThesaurusTerm;
import fr.mcc.ginco.dao.ICustomConceptAttributeDAO;
import fr.mcc.ginco.dao.ICustomConceptAttributeTypeDAO;
import fr.mcc.ginco.dao.ICustomTermAttributeDAO;
import fr.mcc.ginco.dao.ICustomTermAttributeTypeDAO;
import fr.mcc.ginco.services.ICustomConceptAttributeTypeService;
import fr.mcc.ginco.services.ICustomTermAttributeTypeService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

/**
 * Unit tests for fr.mcc.ginco.imports.ginco.GincoCustomAttributeImporter
 *
 * @author Diffblue Cover
 */

public class GincoCustomAttributeImporterTest {

	@Mock(name = "customConceptAttributeDAO")
	private ICustomConceptAttributeDAO customConceptAttributeDAO;

	@Mock(name = "customConceptAttributeTypeDAO")
	private ICustomConceptAttributeTypeDAO customConceptAttributeTypeDAO;

	@Mock(name = "customConceptAttributeTypeService")
	private ICustomConceptAttributeTypeService customConceptAttributeTypeService;

	@Mock(name = "customTermAttributeDAO")
	private ICustomTermAttributeDAO customTermAttributeDAO;

	@Mock(name = "customTermAttributeTypeDAO")
	private ICustomTermAttributeTypeDAO customTermAttributeTypeDAO;

	@Mock(name = "customTermAttributeTypeService")
	private ICustomTermAttributeTypeService customTermAttributeTypeService;

	@InjectMocks
	private GincoCustomAttributeImporter service;

	@Before public void initMocks() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void getBranchCustomTermAttributeTypesCustomAttributeTypesToImportIsEmptyReturnsEmpty() {
		assertTrue(service.getBranchCustomTermAttributeTypes(new ArrayList<CustomTermAttributeType>(), new Thesaurus()).isEmpty());
	}

	@Test
	public void getBranchCustomConceptAttributeTypes() {

		// arrange
		CustomConceptAttributeType customConceptAttributeType1 =
			 new CustomConceptAttributeType();
		customConceptAttributeType1.setExportable(false);
		customConceptAttributeType1.setCode("DE");
		customConceptAttributeType1.setIdentifier(1);
		Thesaurus thesaurus1 = new Thesaurus();
		customConceptAttributeType1.setThesaurus(thesaurus1);
		customConceptAttributeType1.setValue("value");
		when(customConceptAttributeTypeDAO.getAttributeByCode(Mockito.<Thesaurus>any(), Mockito.<String>any()))
			.thenReturn(customConceptAttributeType1);
		ArrayList<CustomConceptAttributeType> customAttributeTypesToImport =
			 new ArrayList<CustomConceptAttributeType>();
		CustomConceptAttributeType customConceptAttributeType2 =
			 new CustomConceptAttributeType();
		customConceptAttributeType2.setValue("value");
		customAttributeTypesToImport.add(customConceptAttributeType2);

		// act
		Map<String, CustomConceptAttributeType> result =
			 service.getBranchCustomConceptAttributeTypes(customAttributeTypesToImport, new Thesaurus());

		// assert
		assertFalse(result.get("DE").getExportable());
		assertEquals("DE", result.get("DE").getCode());
		assertEquals(1, result.get("DE").getIdentifier());
		assertSame(thesaurus1, result.get("DE").getThesaurus());
		assertEquals("value", result.get("DE").getValue());
	}

	@Test
	public void getBranchCustomConceptAttributeTypesCustomAttributeTypesToImportIsEmptyReturnsEmpty() {
		assertTrue(service.getBranchCustomConceptAttributeTypes(new ArrayList<CustomConceptAttributeType>(), new Thesaurus()).isEmpty());
	}

	@Test
	public void storeCustomConceptAttribute() {
		ArrayList<CustomConceptAttribute> customAttributeToImport =
			 new ArrayList<CustomConceptAttribute>();
		CustomConceptAttribute customConceptAttribute = new CustomConceptAttribute();
		customConceptAttribute.setType(new CustomConceptAttributeType());
		customAttributeToImport.add(customConceptAttribute);
		service.storeCustomConceptAttribute(customAttributeToImport, new ThesaurusConcept(), new HashMap<String, CustomConceptAttributeType>());
	}

	@Test
	public void storeCustomConceptAttributeCustomAttributeToImportIsEmpty() {
		service.storeCustomConceptAttribute(new ArrayList<CustomConceptAttribute>(), new ThesaurusConcept(), new HashMap<String, CustomConceptAttributeType>());
	}

	@Test
	public void storeCustomTermAttributeSavedTypesIsEmpty() {
		ArrayList<CustomTermAttribute> customAttributeToImport =
			 new ArrayList<CustomTermAttribute>();
		CustomTermAttribute customTermAttribute = new CustomTermAttribute();
		customTermAttribute.setType(new CustomTermAttributeType());
		customAttributeToImport.add(customTermAttribute);
		service.storeCustomTermAttribute(customAttributeToImport, new ThesaurusTerm(), new HashMap<String, CustomTermAttributeType>());
	}
}
