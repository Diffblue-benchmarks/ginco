package fr.mcc.ginco.imports.ginco;

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

	@Before
	public void initMocks() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void storeCustomTermAttributeTypes() {
		CustomTermAttributeType customTermAttributeType1 =
			 new CustomTermAttributeType();
		when(customTermAttributeTypeDAO.update(Mockito.<CustomTermAttributeType>any()))
			.thenReturn(customTermAttributeType1);
		ArrayList<CustomTermAttributeType> customAttributeTypesToImport =
			 new ArrayList<CustomTermAttributeType>();
		CustomTermAttributeType customTermAttributeType2 =
			 new CustomTermAttributeType();
		customTermAttributeType2.setCode("DE");
		customAttributeTypesToImport.add(customTermAttributeType2);
		assertSame(customTermAttributeType1, service.storeCustomTermAttributeTypes(customAttributeTypesToImport, new Thesaurus()).get("DE"));
	}

	@Test
	public void getBranchCustomTermAttributeTypes1() {
		CustomTermAttributeType customTermAttributeType1 =
			 new CustomTermAttributeType();
		customTermAttributeType1.setCode("DE");
		customTermAttributeType1.setValue("value");
		when(customTermAttributeTypeDAO.getAttributeByCode(Mockito.<Thesaurus>any(), Mockito.<String>any()))
			.thenReturn(customTermAttributeType1);
		ArrayList<CustomTermAttributeType> customAttributeTypesToImport =
			 new ArrayList<CustomTermAttributeType>();
		CustomTermAttributeType customTermAttributeType2 =
			 new CustomTermAttributeType();
		customTermAttributeType2.setValue("value");
		customAttributeTypesToImport.add(customTermAttributeType2);
		assertSame(customTermAttributeType1, service.getBranchCustomTermAttributeTypes(customAttributeTypesToImport, new Thesaurus()).get("DE"));
	}

	@Test
	public void getBranchCustomTermAttributeTypes2() {
		CustomTermAttributeType customTermAttributeType1 =
			 new CustomTermAttributeType();
		customTermAttributeType1.setValue("bar");
		when(customTermAttributeTypeDAO.getAttributeByCode(Mockito.<Thesaurus>any(), Mockito.<String>any()))
			.thenReturn(customTermAttributeType1);
		ArrayList<CustomTermAttributeType> customAttributeTypesToImport =
			 new ArrayList<CustomTermAttributeType>();
		customAttributeTypesToImport.add(new CustomTermAttributeType());
		assertTrue(service.getBranchCustomTermAttributeTypes(customAttributeTypesToImport, new Thesaurus()).isEmpty());
	}

	@Test
	public void getBranchCustomTermAttributeTypesCustomAttributeTypesToImportIsEmpty() {
		assertTrue(service.getBranchCustomTermAttributeTypes(new ArrayList<CustomTermAttributeType>(), new Thesaurus()).isEmpty());
	}

	@Test
	public void storeCustomConceptAttributeTypes() {
		CustomConceptAttributeType customConceptAttributeType1 =
			 new CustomConceptAttributeType();
		when(customConceptAttributeTypeDAO.update(Mockito.<CustomConceptAttributeType>any()))
			.thenReturn(customConceptAttributeType1);
		ArrayList<CustomConceptAttributeType> customAttributeTypesToImport =
			 new ArrayList<CustomConceptAttributeType>();
		CustomConceptAttributeType customConceptAttributeType2 =
			 new CustomConceptAttributeType();
		customConceptAttributeType2.setCode("DE");
		customAttributeTypesToImport.add(customConceptAttributeType2);
		assertSame(customConceptAttributeType1, service.storeCustomConceptAttributeTypes(customAttributeTypesToImport, new Thesaurus()).get("DE"));
	}

	@Test
	public void getBranchCustomConceptAttributeTypes1() {
		CustomConceptAttributeType customConceptAttributeType1 =
			 new CustomConceptAttributeType();
		customConceptAttributeType1.setCode("DE");
		customConceptAttributeType1.setValue("value");
		when(customConceptAttributeTypeDAO.getAttributeByCode(Mockito.<Thesaurus>any(), Mockito.<String>any()))
			.thenReturn(customConceptAttributeType1);
		ArrayList<CustomConceptAttributeType> customAttributeTypesToImport =
			 new ArrayList<CustomConceptAttributeType>();
		CustomConceptAttributeType customConceptAttributeType2 =
			 new CustomConceptAttributeType();
		customConceptAttributeType2.setValue("value");
		customAttributeTypesToImport.add(customConceptAttributeType2);
		assertSame(customConceptAttributeType1, service.getBranchCustomConceptAttributeTypes(customAttributeTypesToImport, new Thesaurus()).get("DE"));
	}

	@Test
	public void getBranchCustomConceptAttributeTypes2() {
		CustomConceptAttributeType customConceptAttributeType1 =
			 new CustomConceptAttributeType();
		customConceptAttributeType1.setValue("bar");
		when(customConceptAttributeTypeDAO.getAttributeByCode(Mockito.<Thesaurus>any(), Mockito.<String>any()))
			.thenReturn(customConceptAttributeType1);
		ArrayList<CustomConceptAttributeType> customAttributeTypesToImport =
			 new ArrayList<CustomConceptAttributeType>();
		customAttributeTypesToImport.add(new CustomConceptAttributeType());
		assertTrue(service.getBranchCustomConceptAttributeTypes(customAttributeTypesToImport, new Thesaurus()).isEmpty());
	}

	@Test
	public void getBranchCustomConceptAttributeTypesCustomAttributeTypesToImportIsEmpty() {
		assertTrue(service.getBranchCustomConceptAttributeTypes(new ArrayList<CustomConceptAttributeType>(), new Thesaurus()).isEmpty());
	}

	@Test
	public void storeCustomConceptAttribute() {
		when(customConceptAttributeDAO.update(Mockito.<CustomConceptAttribute>any()))
			.thenReturn(new CustomConceptAttribute());
		ArrayList<CustomConceptAttribute> customAttributeToImport =
			 new ArrayList<CustomConceptAttribute>();
		CustomConceptAttribute customConceptAttribute2 =
			 new CustomConceptAttribute();
		CustomConceptAttributeType type4 = new CustomConceptAttributeType();
		type4.setCode("DE");
		customConceptAttribute2.setType(type4);
		customAttributeToImport.add(customConceptAttribute2);
		HashMap<String, CustomConceptAttributeType> savedTypes =
			 new HashMap<String, CustomConceptAttributeType>();
		savedTypes.put("DE", new CustomConceptAttributeType());
		service.storeCustomConceptAttribute(customAttributeToImport, new ThesaurusConcept(), savedTypes);
	}

	@Test
	public void storeCustomConceptAttributeSavedTypesIsEmpty() {
		ArrayList<CustomConceptAttribute> customAttributeToImport =
			 new ArrayList<CustomConceptAttribute>();
		CustomConceptAttribute customConceptAttribute = new CustomConceptAttribute();
		customConceptAttribute.setType(new CustomConceptAttributeType());
		customAttributeToImport.add(customConceptAttribute);
		service.storeCustomConceptAttribute(customAttributeToImport, new ThesaurusConcept(), new HashMap<String, CustomConceptAttributeType>());
	}

	@Test
	public void storeCustomTermAttribute() {
		when(customTermAttributeDAO.update(Mockito.<CustomTermAttribute>any()))
			.thenReturn(new CustomTermAttribute());
		ArrayList<CustomTermAttribute> customAttributeToImport =
			 new ArrayList<CustomTermAttribute>();
		CustomTermAttribute customTermAttribute2 = new CustomTermAttribute();
		CustomTermAttributeType type5 = new CustomTermAttributeType();
		type5.setCode("DE");
		customTermAttribute2.setType(type5);
		customAttributeToImport.add(customTermAttribute2);
		HashMap<String, CustomTermAttributeType> savedTypes =
			 new HashMap<String, CustomTermAttributeType>();
		savedTypes.put("DE", new CustomTermAttributeType());
		service.storeCustomTermAttribute(customAttributeToImport, new ThesaurusTerm(), savedTypes);
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
