package fr.mcc.ginco.services;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import fr.mcc.ginco.beans.Language;
import fr.mcc.ginco.dao.ILanguageDAO;

import java.util.ArrayList;

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
	public void getLanguageByPart1Part1IsBar() {

		// arrange
		Language language = new Language();
		language.setId("1234");
		language.setPart1("foo");
		language.setRefname("foo");
		when(languagesDAO.getByPart1(Mockito.<String>any()))
			.thenReturn(language);

		// act
		Language result = service.getLanguageByPart1("bar");

		// assert
		assertEquals("1234", result.getId());
		assertEquals("foo", result.getPart1());
		assertEquals("foo", result.getRefname());
		assertFalse(result.isPrincipalLanguage());
		assertFalse(result.isTopLanguage());
	}

	@Test
	public void getLanguageCountReturnsOne() {
		when(languagesDAO.count())
			.thenReturn(1L);
		assertEquals(1L, (long) service.getLanguageCount());
	}

	@Test
	public void getLanguagesListLimitIsOneAndStartIndexIsZeroReturnsEmpty() {
		when(languagesDAO.findPaginatedItems(Mockito.<Integer>any(), Mockito.<Integer>any()))
			.thenReturn(new ArrayList<Language>());
		assertTrue((service.getLanguagesList(0, 1)).isEmpty());
	}

	@Test
	public void getTopLanguagesListReturnsEmpty() {
		when(languagesDAO.findTopLanguages())
			.thenReturn(new ArrayList<Language>());
		assertTrue((service.getTopLanguagesList()).isEmpty());
	}
}
