package fr.mcc.ginco.imports.ginco;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

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

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
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
	public void getBranchCustomConceptAttributeTypes() {
		ArrayList<CustomConceptAttributeType> customAttributeTypesToImport = new ArrayList<CustomConceptAttributeType>();
		customAttributeTypesToImport.add(new CustomConceptAttributeType());
		assertTrue(service.getBranchCustomConceptAttributeTypes(customAttributeTypesToImport, new Thesaurus()).isEmpty());
	}

	@Test
	public void getBranchCustomConceptAttributeTypesCustomAttributeTypesToImportIsEmpty() {
		assertTrue(service.getBranchCustomConceptAttributeTypes(new ArrayList<CustomConceptAttributeType>(), new Thesaurus()).isEmpty());
	}

	@Test
	public void getBranchCustomTermAttributeTypes() {
		ArrayList<CustomTermAttributeType> customAttributeTypesToImport = new ArrayList<CustomTermAttributeType>();
		customAttributeTypesToImport.add(new CustomTermAttributeType());
		assertTrue(service.getBranchCustomTermAttributeTypes(customAttributeTypesToImport, new Thesaurus()).isEmpty());
	}

	@Test
	public void getBranchCustomTermAttributeTypesCustomAttributeTypesToImportIsEmpty() {
		assertTrue(service.getBranchCustomTermAttributeTypes(new ArrayList<CustomTermAttributeType>(), new Thesaurus()).isEmpty());
	}

	@Test
	public void storeCustomConceptAttribute() {
		ArrayList<CustomConceptAttribute> customAttributeToImport = new ArrayList<CustomConceptAttribute>();
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
	public void storeCustomConceptAttributeTypesCustomAttributeTypesToImportIsEmptyReturnsEmpty() {
		assertTrue(service.storeCustomConceptAttributeTypes(new ArrayList<CustomConceptAttributeType>(), new Thesaurus()).isEmpty());
	}

	@Test
	public void storeCustomConceptAttributeTypesReturnsNull() {
		ArrayList<CustomConceptAttributeType> customAttributeTypesToImport = new ArrayList<CustomConceptAttributeType>();
		customAttributeTypesToImport.add(new CustomConceptAttributeType());
		assertNull(service.storeCustomConceptAttributeTypes(customAttributeTypesToImport, new Thesaurus()).get("DE"));
	}

	@Test
	public void storeCustomTermAttributeCustomAttributeToImportIsEmptyAndSavedTypesIsEmpty() {
		service.storeCustomTermAttribute(new ArrayList<CustomTermAttribute>(), new ThesaurusTerm(), new HashMap<String, CustomTermAttributeType>());
	}

	@Test
	public void storeCustomTermAttributeTypesCustomAttributeTypesToImportIsEmptyReturnsEmpty() {
		assertTrue(service.storeCustomTermAttributeTypes(new ArrayList<CustomTermAttributeType>(), new Thesaurus()).isEmpty());
	}
}
