package fr.mcc.ginco.services;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import fr.mcc.ginco.beans.Suggestion;
import fr.mcc.ginco.dao.ISuggestionDAO;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

/**
 * Unit tests for fr.mcc.ginco.services.SuggestionServiceImpl
 *
 * @author Diffblue Cover
 */

public class SuggestionServiceImplTest {

	@Mock(name = "suggestionDAO")
	private ISuggestionDAO suggestionDAO;

	@InjectMocks
	private SuggestionServiceImpl service;

	@Before public void initMocks() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void getConceptSuggestionCountReturnsOne() {
		when(suggestionDAO.getConceptSuggestionCount(Mockito.<String>any()))
			.thenReturn(1L);
		assertEquals(1L, (long) service.getConceptSuggestionCount("1234"));
	}

	@Test
	public void getConceptSuggestionPaginatedListLimitIsOneAndStartIndexIsOneReturnsEmpty() {
		when(suggestionDAO.findConceptPaginatedSuggestions(Mockito.<String>any(), Mockito.<Integer>any(), Mockito.<Integer>any()))
			.thenReturn(new ArrayList<Suggestion>());
		assertTrue((service.getConceptSuggestionPaginatedList("1234", 1, 1)).isEmpty());
	}

	@Test
	public void getSuggestionByRecipientCountReturnsOne() {
		when(suggestionDAO.getSuggestionsByRecipientCount(Mockito.<String>any()))
			.thenReturn(1L);
		assertEquals(1L, (long) service.getSuggestionByRecipientCount("1234"));
	}

	@Test
	public void getSuggestionPaginatedListByRecipientLimitIsOneAndStartIndexIsOneReturnsEmpty() {
		when(suggestionDAO.findPaginatedSuggestionsByRecipient(Mockito.<String>any(), Mockito.<Integer>any(), Mockito.<Integer>any()))
			.thenReturn(new ArrayList<Suggestion>());
		assertTrue((service.getSuggestionPaginatedListByRecipient("1234", 1, 1)).isEmpty());
	}

	@Test
	public void getTermSuggestionCountReturnsOne() {
		when(suggestionDAO.getTermSuggestionCount(Mockito.<String>any()))
			.thenReturn(1L);
		assertEquals(1L, (long) service.getTermSuggestionCount("1234"));
	}

	@Test
	public void getTermSuggestionPaginatedListLimitIsOneAndStartIndexIsOneReturnsEmpty() {
		when(suggestionDAO.findTermPaginatedSuggestions(Mockito.<String>any(), Mockito.<Integer>any(), Mockito.<Integer>any()))
			.thenReturn(new ArrayList<Suggestion>());
		assertTrue((service.getTermSuggestionPaginatedList("1234", 1, 1)).isEmpty());
	}
}
