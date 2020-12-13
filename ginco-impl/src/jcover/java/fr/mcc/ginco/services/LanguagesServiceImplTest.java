package fr.mcc.ginco.services;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.when;

import fr.mcc.ginco.beans.Language;
import fr.mcc.ginco.dao.ILanguageDAO;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

/**
 * Unit tests for fr.mcc.ginco.services.LanguagesServiceImpl
 *
 * @author Diffblue Cover
 */

public class LanguagesServiceImplTest {

	@Mock(name = "languagesDAO")
	private ILanguageDAO languagesDAO;

	@InjectMocks
	private LanguagesServiceImpl service;

	@Before public void initMocks() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void getLanguagesListLimitIsOneAndStartIndexIsOne() {

		// arrange
		ArrayList<Language> arrayList = new ArrayList<Language>();
		Language language = new Language();
		arrayList.add(language);
		when(languagesDAO.findPaginatedItems(Mockito.<Integer>any(), Mockito.<Integer>any()))
			.thenReturn(arrayList);

		// act
		List<Language> result = service.getLanguagesList(1, 1);

		// assert
		assertEquals(1, result.size());
		assertSame(language, result.get(0));
	}

	@Test
	public void getTopLanguagesList() {

		// arrange
		ArrayList<Language> arrayList = new ArrayList<Language>();
		Language language = new Language();
		arrayList.add(language);
		when(languagesDAO.findTopLanguages())
			.thenReturn(arrayList);

		// act
		List<Language> result = service.getTopLanguagesList();

		// assert
		assertEquals(1, result.size());
		assertSame(language, result.get(0));
	}

	@Test
	public void getLanguageCountReturnsOne() {
		when(languagesDAO.count())
			.thenReturn(1L);
		assertEquals(1L, (long) service.getLanguageCount());
	}

	@Test
	public void getLanguageById() {

		// arrange
		Language language = new Language();
		language.setId("1234");
		language.setPart1("foo");
		language.setRefname("root");
		when(languagesDAO.getById(Mockito.<String>any()))
			.thenReturn(language);

		// act
		Language result = service.getLanguageById("1234");

		// assert
		assertEquals("1234", result.getId());
		assertEquals("foo", result.getPart1());
		assertEquals("root", result.getRefname());
		assertFalse(result.isPrincipalLanguage());
		assertFalse(result.isTopLanguage());
	}

	@Test
	public void getLanguageByPart1() {

		// arrange
		Language language = new Language();
		language.setId("1234");
		language.setPart1("foo");
		language.setRefname("root");
		when(languagesDAO.getByPart1(Mockito.<String>any()))
			.thenReturn(language);

		// act
		Language result = service.getLanguageByPart1("/some/path.html");

		// assert
		assertEquals("1234", result.getId());
		assertEquals("foo", result.getPart1());
		assertEquals("root", result.getRefname());
		assertFalse(result.isPrincipalLanguage());
		assertFalse(result.isTopLanguage());
	}
}
