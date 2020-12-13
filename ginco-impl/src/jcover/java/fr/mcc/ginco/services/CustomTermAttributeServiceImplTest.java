package fr.mcc.ginco.services;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.when;

import fr.mcc.ginco.beans.CustomTermAttribute;
import fr.mcc.ginco.beans.CustomTermAttributeType;
import fr.mcc.ginco.beans.Language;
import fr.mcc.ginco.beans.ThesaurusTerm;
import fr.mcc.ginco.dao.ICustomTermAttributeDAO;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

/**
 * Unit tests for fr.mcc.ginco.services.CustomTermAttributeServiceImpl
 *
 * @author Diffblue Cover
 */

public class CustomTermAttributeServiceImplTest {

	@Mock(name = "customTermAttributeDAO")
	private ICustomTermAttributeDAO customTermAttributeDAO;

	@InjectMocks
	private CustomTermAttributeServiceImpl service;

	@Before public void initMocks() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void getAttributesByEntity() {

		// arrange
		ArrayList<CustomTermAttribute> arrayList =
			 new ArrayList<CustomTermAttribute>();
		CustomTermAttribute customTermAttribute = new CustomTermAttribute();
		arrayList.add(customTermAttribute);
		when(customTermAttributeDAO.getAttributesByEntity(Mockito.<ThesaurusTerm>any()))
			.thenReturn(arrayList);

		// act
		List<CustomTermAttribute> result =
			 service.getAttributesByEntity(new ThesaurusTerm());

		// assert
		assertEquals(1, result.size());
		assertSame(customTermAttribute, result.get(0));
	}

	@Test
	public void deleteAttribute() {
		when(customTermAttributeDAO.delete(Mockito.<CustomTermAttribute>any()))
			.thenReturn(new CustomTermAttribute());
		service.deleteAttribute(new CustomTermAttribute());
	}

	@Test
	public void saveOrUpdate() {

		// arrange
		CustomTermAttribute customTermAttribute = new CustomTermAttribute();
		ThesaurusTerm entity1 = new ThesaurusTerm();
		customTermAttribute.setEntity(entity1);
		customTermAttribute.setIdentifier("data");
		Language language2 = new Language();
		customTermAttribute.setLanguage(language2);
		customTermAttribute.setLexicalValue("value");
		CustomTermAttributeType type3 = new CustomTermAttributeType();
		customTermAttribute.setType(type3);
		when(customTermAttributeDAO.update(Mockito.<CustomTermAttribute>any()))
			.thenReturn(customTermAttribute);

		// act
		CustomTermAttribute result = service.saveOrUpdate(new CustomTermAttribute());

		// assert
		assertSame(entity1, result.getEntity());
		assertEquals("data", result.getIdentifier());
		assertSame(language2, result.getLanguage());
		assertEquals("value", result.getLexicalValue());
		assertSame(type3, result.getType());
	}

	@Test
	public void getAttributeByType() {

		// arrange
		CustomTermAttribute customTermAttribute = new CustomTermAttribute();
		ThesaurusTerm entity1 = new ThesaurusTerm();
		customTermAttribute.setEntity(entity1);
		customTermAttribute.setIdentifier("data");
		Language language2 = new Language();
		customTermAttribute.setLanguage(language2);
		customTermAttribute.setLexicalValue("value");
		CustomTermAttributeType type3 = new CustomTermAttributeType();
		customTermAttribute.setType(type3);
		when(customTermAttributeDAO.getAttributeByType(Mockito.<ThesaurusTerm>any(), Mockito.<fr.mcc.ginco.beans.generic.GenericCustomAttributeType>any()))
			.thenReturn(customTermAttribute);

		// act
		CustomTermAttribute result =
			 service.getAttributeByType(new ThesaurusTerm(), new CustomTermAttributeType());

		// assert
		assertSame(entity1, result.getEntity());
		assertEquals("data", result.getIdentifier());
		assertSame(language2, result.getLanguage());
		assertEquals("value", result.getLexicalValue());
		assertSame(type3, result.getType());
	}
}
