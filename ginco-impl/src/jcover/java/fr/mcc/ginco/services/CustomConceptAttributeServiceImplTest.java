package fr.mcc.ginco.services;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.when;

import fr.mcc.ginco.beans.CustomConceptAttribute;
import fr.mcc.ginco.beans.CustomConceptAttributeType;
import fr.mcc.ginco.beans.Language;
import fr.mcc.ginco.beans.ThesaurusConcept;
import fr.mcc.ginco.dao.ICustomConceptAttributeDAO;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

/**
 * Unit tests for fr.mcc.ginco.services.CustomConceptAttributeServiceImpl
 *
 * @author Diffblue Cover
 */

public class CustomConceptAttributeServiceImplTest {

	@Mock(name = "customConceptAttributeDAO")
	private ICustomConceptAttributeDAO customConceptAttributeDAO;

	@InjectMocks
	private CustomConceptAttributeServiceImpl service;

	@Before public void initMocks() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void getAttributesByEntity() {

		// arrange
		List<CustomConceptAttribute> list = new ArrayList<CustomConceptAttribute>();
		CustomConceptAttribute customConceptAttribute = new CustomConceptAttribute();
		list.add(customConceptAttribute);
		when(customConceptAttributeDAO.getAttributesByEntity(Mockito.<ThesaurusConcept>any()))
			.thenReturn(list);

		// act
		List<CustomConceptAttribute> result =
			 service.getAttributesByEntity(new ThesaurusConcept());

		// assert
		assertEquals(1, result.size());
		assertSame(customConceptAttribute, result.get(0));
	}

	@Test
	public void deleteAttribute() {
		when(customConceptAttributeDAO.delete(Mockito.<CustomConceptAttribute>any()))
			.thenReturn(new CustomConceptAttribute());
		service.deleteAttribute(new CustomConceptAttribute());
	}

	@Test
	public void saveOrUpdate() {

		// arrange
		CustomConceptAttribute customConceptAttribute = new CustomConceptAttribute();
		ThesaurusConcept entity1 = new ThesaurusConcept();
		customConceptAttribute.setEntity(entity1);
		customConceptAttribute.setIdentifier("data");
		Language language1 = new Language();
		customConceptAttribute.setLanguage(language1);
		customConceptAttribute.setLexicalValue("value");
		CustomConceptAttributeType type2 = new CustomConceptAttributeType();
		customConceptAttribute.setType(type2);
		when(customConceptAttributeDAO.update(Mockito.<CustomConceptAttribute>any()))
			.thenReturn(customConceptAttribute);

		// act
		CustomConceptAttribute result =
			 service.saveOrUpdate(new CustomConceptAttribute());

		// assert
		assertSame(entity1, result.getEntity());
		assertEquals("data", result.getIdentifier());
		assertSame(language1, result.getLanguage());
		assertEquals("value", result.getLexicalValue());
		assertSame(type2, result.getType());
	}

	@Test
	public void getAttributeByType() {

		// arrange
		CustomConceptAttribute customConceptAttribute = new CustomConceptAttribute();
		ThesaurusConcept entity1 = new ThesaurusConcept();
		customConceptAttribute.setEntity(entity1);
		customConceptAttribute.setIdentifier("data");
		Language language = new Language();
		customConceptAttribute.setLanguage(language);
		customConceptAttribute.setLexicalValue("value");
		CustomConceptAttributeType type2 = new CustomConceptAttributeType();
		customConceptAttribute.setType(type2);
		when(customConceptAttributeDAO.getAttributeByType(Mockito.<ThesaurusConcept>any(), Mockito.<fr.mcc.ginco.beans.generic.GenericCustomAttributeType>any()))
			.thenReturn(customConceptAttribute);

		// act
		CustomConceptAttribute result =
			 service.getAttributeByType(new ThesaurusConcept(), new CustomConceptAttributeType());

		// assert
		assertSame(entity1, result.getEntity());
		assertEquals("data", result.getIdentifier());
		assertSame(language, result.getLanguage());
		assertEquals("value", result.getLexicalValue());
		assertSame(type2, result.getType());
	}
}
