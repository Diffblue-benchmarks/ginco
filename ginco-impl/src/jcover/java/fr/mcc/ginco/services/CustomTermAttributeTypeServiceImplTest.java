package fr.mcc.ginco.services;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import fr.mcc.ginco.beans.CustomTermAttributeType;
import fr.mcc.ginco.beans.Thesaurus;
import fr.mcc.ginco.dao.ICustomTermAttributeTypeDAO;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

/**
 * Unit tests for fr.mcc.ginco.services.CustomTermAttributeTypeServiceImpl
 *
 * @author Diffblue Cover
 */

public class CustomTermAttributeTypeServiceImplTest {

	@Mock(name = "customTermAttributeTypeDAO")
	private ICustomTermAttributeTypeDAO customTermAttributeTypeDAO;

	@InjectMocks
	private CustomTermAttributeTypeServiceImpl service;

	@Before public void initMocks() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void getAttributeTypesByThesaurus() {

		// arrange
		List<CustomTermAttributeType> list =
			 new ArrayList<CustomTermAttributeType>();
		CustomTermAttributeType customTermAttributeType =
			 new CustomTermAttributeType();
		list.add(customTermAttributeType);
		when(customTermAttributeTypeDAO.getAttributesByThesaurus(Mockito.<Thesaurus>any()))
			.thenReturn(list);

		// act
		List<CustomTermAttributeType> result =
			 service.getAttributeTypesByThesaurus(new Thesaurus());

		// assert
		assertEquals(1, result.size());
		assertSame(customTermAttributeType, result.get(0));
	}

	@Test
	public void deleteAttribute() {
		when(customTermAttributeTypeDAO.delete(Mockito.<CustomTermAttributeType>any()))
			.thenReturn(new CustomTermAttributeType());
		CustomTermAttributeType attribute = mock(CustomTermAttributeType.class);
		service.deleteAttribute(attribute);
	}

	@Test
	public void getAttributeTypeByIdIdIsOne() {

		// arrange
		CustomTermAttributeType customTermAttributeType =
			 new CustomTermAttributeType();
		customTermAttributeType.setCode("DE");
		customTermAttributeType.setIdentifier(1);
		Thesaurus thesaurus = new Thesaurus();
		customTermAttributeType.setThesaurus(thesaurus);
		customTermAttributeType.setValue("value");
		when(customTermAttributeTypeDAO.getById(Mockito.<Integer>any()))
			.thenReturn(customTermAttributeType);

		// act
		CustomTermAttributeType result = service.getAttributeTypeById(1);

		// assert
		assertEquals("DE", result.getCode());
		assertEquals(1, result.getIdentifier());
		assertSame(thesaurus, result.getThesaurus());
		assertEquals("value", result.getValue());
	}

	@Test
	public void saveOrUpdate() {

		// arrange
		CustomTermAttributeType customTermAttributeType =
			 new CustomTermAttributeType();
		customTermAttributeType.setCode("DE");
		customTermAttributeType.setIdentifier(1);
		Thesaurus thesaurus1 = new Thesaurus();
		customTermAttributeType.setThesaurus(thesaurus1);
		customTermAttributeType.setValue("value");
		when(customTermAttributeTypeDAO.update(Mockito.<CustomTermAttributeType>any()))
			.thenReturn(customTermAttributeType);

		// act
		CustomTermAttributeType result =
			 service.saveOrUpdate(new CustomTermAttributeType());

		// assert
		assertEquals("DE", result.getCode());
		assertEquals(1, result.getIdentifier());
		assertSame(thesaurus1, result.getThesaurus());
		assertEquals("value", result.getValue());
	}
}
