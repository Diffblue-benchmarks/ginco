package fr.mcc.ginco.imports.ginco;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;

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
	public void getBranchCustomTermAttributeTypesCustomAttributeTypesToImportIsEmptyReturnsEmpty() {
		assertTrue(service.getBranchCustomTermAttributeTypes(new ArrayList<CustomTermAttributeType>(), new Thesaurus()).isEmpty());
	}

	@Test
	public void storeCustomConceptAttributeTypesCustomAttributeTypesToImportIsEmptyReturnsEmpty() {
		assertTrue(service.storeCustomConceptAttributeTypes(new ArrayList<CustomConceptAttributeType>(), new Thesaurus()).isEmpty());
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
		ThesaurusConcept concept = mock(ThesaurusConcept.class);
		service.storeCustomConceptAttribute(customAttributeToImport, concept, new HashMap<String, CustomConceptAttributeType>());
	}

	@Test
	public void storeCustomConceptAttributeCustomAttributeToImportIsEmpty() {
		service.storeCustomConceptAttribute(new ArrayList<CustomConceptAttribute>(), new ThesaurusConcept(), new HashMap<String, CustomConceptAttributeType>());
	}

	@Test
	public void storeCustomTermAttribute() {
		ArrayList<CustomTermAttribute> customAttributeToImport =
			 new ArrayList<CustomTermAttribute>();
		CustomTermAttribute customTermAttribute = new CustomTermAttribute();
		customTermAttribute.setType(new CustomTermAttributeType());
		customAttributeToImport.add(customTermAttribute);
		ThesaurusTerm term = mock(ThesaurusTerm.class);
		service.storeCustomTermAttribute(customAttributeToImport, term, new HashMap<String, CustomTermAttributeType>());
	}

	@Test
	public void storeCustomTermAttributeCustomAttributeToImportIsEmpty() {
		service.storeCustomTermAttribute(new ArrayList<CustomTermAttribute>(), new ThesaurusTerm(), new HashMap<String, CustomTermAttributeType>());
	}
}
