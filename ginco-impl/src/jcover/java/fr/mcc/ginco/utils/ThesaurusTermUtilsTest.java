package fr.mcc.ginco.utils;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import fr.mcc.ginco.beans.Language;
import fr.mcc.ginco.beans.ThesaurusTerm;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

/**
 * Unit tests for fr.mcc.ginco.utils.ThesaurusTermUtils
 *
 * @author Diffblue Cover
 */

public class ThesaurusTermUtilsTest {

	@InjectMocks
	private ThesaurusTermUtils service;

	@Before
	public void initMocks() throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		MockitoAnnotations.initMocks(this);
		ThesaurusTermUtils bean = service;
		java.lang.reflect.Field field =
			 ThesaurusTermUtils.class.getDeclaredField("defaultLang");
		field.setAccessible(true);
		field.set(bean, "${ginco.default.language}");
	}

	@Test
	public void getPreferedTerms() {
		ArrayList<ThesaurusTerm> listOfTerms = new ArrayList<ThesaurusTerm>();
		ThesaurusTerm thesaurusTerm = mock(ThesaurusTerm.class);
		when(thesaurusTerm.getPrefered())
			.thenReturn(false);
		listOfTerms.add(thesaurusTerm);
		assertTrue(service.getPreferedTerms(listOfTerms).isEmpty());
	}

	@Test
	public void checkTermsReturnsTrue() {
		ArrayList<ThesaurusTerm> terms = new ArrayList<ThesaurusTerm>();
		ThesaurusTerm thesaurusTerm = new ThesaurusTerm();
		thesaurusTerm.setPrefered(true);
		terms.add(thesaurusTerm);
		assertTrue(service.checkTerms(terms));
	}

	@Test
	public void generatePrefTermsText() {
		ArrayList<ThesaurusTerm> terms = new ArrayList<ThesaurusTerm>();
		Language language = new Language();
		language.setId("1234");
		ThesaurusTerm thesaurusTerm = mock(ThesaurusTerm.class);
		when(thesaurusTerm.getLanguage())
			.thenReturn(language);
		when(thesaurusTerm.getLexicalValue())
			.thenReturn("foo");
		terms.add(thesaurusTerm);
		assertEquals("foo@1234", service.generatePrefTermsText(terms));
	}

	@Test
	public void getPreferedTermsByLang1() {
		ArrayList<ThesaurusTerm> listOfTerms = new ArrayList<ThesaurusTerm>();
		ThesaurusTerm thesaurusTerm = mock(ThesaurusTerm.class);
		when(thesaurusTerm.getPrefered())
			.thenReturn(false);
		listOfTerms.add(thesaurusTerm);
		assertTrue(service.getPreferedTermsByLang(listOfTerms, "1234").isEmpty());
	}

	@Test
	public void getPreferedTermsByLang2() {

		// arrange
		ArrayList<ThesaurusTerm> listOfTerms = new ArrayList<ThesaurusTerm>();
		ThesaurusTerm thesaurusTerm = new ThesaurusTerm();
		Language language = new Language();
		language.setId("1234");
		thesaurusTerm.setLanguage(language);
		thesaurusTerm.setPrefered(true);
		listOfTerms.add(thesaurusTerm);

		// act
		List<ThesaurusTerm> result =
			 service.getPreferedTermsByLang(listOfTerms, "1234");

		// assert
		assertEquals(1, result.size());
		assertSame(thesaurusTerm, result.get(0));
	}

	@Test
	public void getPreferedTermsByLang3() {
		ArrayList<ThesaurusTerm> listOfTerms = new ArrayList<ThesaurusTerm>();
		ThesaurusTerm thesaurusTerm = new ThesaurusTerm();
		Language language = new Language();
		language.setId("bar");
		thesaurusTerm.setLanguage(language);
		thesaurusTerm.setPrefered(true);
		listOfTerms.add(thesaurusTerm);
		assertTrue(service.getPreferedTermsByLang(listOfTerms, "1234").isEmpty());
	}

	@Test
	public void getters() {
		assertTrue(service.getPreferedTermsByLang(new ArrayList<ThesaurusTerm>(), "1234").isEmpty());
		assertTrue(service.getPreferedTerms(new ArrayList<ThesaurusTerm>()).isEmpty());
	}
}
