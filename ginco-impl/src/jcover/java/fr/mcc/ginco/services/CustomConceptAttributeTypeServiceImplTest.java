package fr.mcc.ginco.services;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.when;

import fr.mcc.ginco.beans.CustomConceptAttributeType;
import fr.mcc.ginco.beans.Thesaurus;
import fr.mcc.ginco.dao.ICustomConceptAttributeTypeDAO;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

/**
 * Unit tests for fr.mcc.ginco.services.CustomConceptAttributeTypeServiceImpl
 *
 * @author Diffblue Cover
 */

public class CustomConceptAttributeTypeServiceImplTest {

	@Mock(name = "customConceptAttributeTypeDAO")
	private ICustomConceptAttributeTypeDAO customConceptAttributeTypeDAO;

	@InjectMocks
	private CustomConceptAttributeTypeServiceImpl service;

	@Before public void initMocks() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void getAttributeTypesByThesaurus() {

		// arrange
		ArrayList<CustomConceptAttributeType> arrayList =
			 new ArrayList<CustomConceptAttributeType>();
		CustomConceptAttributeType customConceptAttributeType =
			 new CustomConceptAttributeType();
		arrayList.add(customConceptAttributeType);
		when(customConceptAttributeTypeDAO.getAttributesByThesaurus(Mockito.<Thesaurus>any()))
			.thenReturn(arrayList);

		// act
		List<CustomConceptAttributeType> result =
			 service.getAttributeTypesByThesaurus(new Thesaurus());

		// assert
		assertEquals(1, result.size());
		assertSame(customConceptAttributeType, result.get(0));
	}

	@Test
	public void saveOrUpdate() {

		// arrange
		CustomConceptAttributeType customConceptAttributeType =
			 new CustomConceptAttributeType();
		customConceptAttributeType.setExportable(false);
		customConceptAttributeType.setCode("DE");
		customConceptAttributeType.setIdentifier(1);
		Thesaurus thesaurus1 = new Thesaurus();
		customConceptAttributeType.setThesaurus(thesaurus1);
		customConceptAttributeType.setValue("value");
		when(customConceptAttributeTypeDAO.update(Mockito.<CustomConceptAttributeType>any()))
			.thenReturn(customConceptAttributeType);

		// act
		CustomConceptAttributeType result =
			 service.saveOrUpdate(new CustomConceptAttributeType());

		// assert
		assertFalse(result.getExportable());
		assertEquals("DE", result.getCode());
		assertEquals(1, result.getIdentifier());
		assertSame(thesaurus1, result.getThesaurus());
		assertEquals("value", result.getValue());
	}

	@Test
	public void deleteAttribute() {
		when(customConceptAttributeTypeDAO.delete(Mockito.<CustomConceptAttributeType>any()))
			.thenReturn(new CustomConceptAttributeType());
		service.deleteAttribute(new CustomConceptAttributeType());
	}

	@Test
	public void getAttributeTypeByIdIdIsOne() {

		// arrange
		CustomConceptAttributeType customConceptAttributeType =
			 new CustomConceptAttributeType();
		customConceptAttributeType.setExportable(false);
		customConceptAttributeType.setCode("DE");
		customConceptAttributeType.setIdentifier(1);
		Thesaurus thesaurus = new Thesaurus();
		customConceptAttributeType.setThesaurus(thesaurus);
		customConceptAttributeType.setValue("value");
		when(customConceptAttributeTypeDAO.getById(Mockito.<Integer>any()))
			.thenReturn(customConceptAttributeType);

		// act
		CustomConceptAttributeType result = service.getAttributeTypeById(1);

		// assert
		assertFalse(result.getExportable());
		assertEquals("DE", result.getCode());
		assertEquals(1, result.getIdentifier());
		assertSame(thesaurus, result.getThesaurus());
		assertEquals("value", result.getValue());
	}
}
