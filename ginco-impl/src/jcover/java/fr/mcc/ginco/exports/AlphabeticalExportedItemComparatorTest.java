package fr.mcc.ginco.exports;

import static org.junit.Assert.assertEquals;

import fr.mcc.ginco.exports.result.bean.AlphabeticalExportedItem;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

/**
 * Unit tests for fr.mcc.ginco.exports.AlphabeticalExportedItemComparator
 *
 * @author Diffblue Cover
 */

public class AlphabeticalExportedItemComparatorTest {

	@InjectMocks
	private AlphabeticalExportedItemComparator service;

	@Before
	public void initMocks() throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		MockitoAnnotations.initMocks(this);
		AlphabeticalExportedItemComparator bean = service;
		java.lang.reflect.Field field =
			 AlphabeticalExportedItemComparator.class.getDeclaredField("defaultLang");
		field.setAccessible(true);
		field.set(bean, "${ginco.default.language}");
	}

	@Test
	public void compareReturnsOne() {
		AlphabeticalExportedItem o1 = new AlphabeticalExportedItem();
		o1.setLexicalValue("value");
		AlphabeticalExportedItem o2 = new AlphabeticalExportedItem();
		o2.setLexicalValue("bar");
		assertEquals(1, service.compare(o1, o2));
	}

	@Test
	public void compareReturnsZero() {
		AlphabeticalExportedItem o1 = new AlphabeticalExportedItem();
		o1.setLexicalValue("value");
		AlphabeticalExportedItem o2 = new AlphabeticalExportedItem();
		o2.setLexicalValue("value");
		assertEquals(0, service.compare(o1, o2));
	}
}