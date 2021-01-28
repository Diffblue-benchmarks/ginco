package fr.mcc.ginco.services;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.when;

import fr.mcc.ginco.beans.Suggestion;
import fr.mcc.ginco.beans.ThesaurusConcept;
import fr.mcc.ginco.beans.ThesaurusTerm;
import fr.mcc.ginco.dao.ISuggestionDAO;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
	public void getConceptSuggestionPaginatedListLimitIsOneAndStartIndexIsOne() {

		// arrange
		ArrayList<Suggestion> suggestionList = new ArrayList<Suggestion>();
		Suggestion suggestion = new Suggestion();
		suggestionList.add(suggestion);
		when(suggestionDAO.findConceptPaginatedSuggestions(Mockito.<String>any(), Mockito.<Integer>any(), Mockito.<Integer>any()))
			.thenReturn(suggestionList);

		// act
		List<Suggestion> result =
			 service.getConceptSuggestionPaginatedList("1234", 1, 1);

		// assert
		assertEquals(1, result.size());
		assertSame(suggestion, result.get(0));
	}

	@Test
	public void getTermSuggestionPaginatedListLimitIsOneAndStartIndexIsOne() {

		// arrange
		ArrayList<Suggestion> suggestionList = new ArrayList<Suggestion>();
		Suggestion suggestion = new Suggestion();
		suggestionList.add(suggestion);
		when(suggestionDAO.findTermPaginatedSuggestions(Mockito.<String>any(), Mockito.<Integer>any(), Mockito.<Integer>any()))
			.thenReturn(suggestionList);

		// act
		List<Suggestion> result =
			 service.getTermSuggestionPaginatedList("1234", 1, 1);

		// assert
		assertEquals(1, result.size());
		assertSame(suggestion, result.get(0));
	}

	@Test
	public void getSuggestionByIdIdIsOne() throws java.text.ParseException {

		// arrange
		Suggestion suggestion = new Suggestion();
		ThesaurusConcept concept1 = new ThesaurusConcept();
		suggestion.setConcept(concept1);
		suggestion.setContent("hello");
		Date created3 = new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31");
		suggestion.setCreated(created3);
		suggestion.setCreator("someone");
		suggestion.setIdentifier(1);
		suggestion.setRecipient("1234");
		ThesaurusTerm term = new ThesaurusTerm();
		suggestion.setTerm(term);
		when(suggestionDAO.getById(Mockito.<Integer>any()))
			.thenReturn(suggestion);

		// act
		Suggestion result = service.getSuggestionById(1);

		// assert
		assertSame(concept1, result.getConcept());
		assertEquals("hello", result.getContent());
		assertSame(created3, result.getCreated());
		assertEquals("someone", result.getCreator());
		assertEquals(1, (int) result.getIdentifier());
		assertEquals("1234", result.getRecipient());
		assertSame(term, result.getTerm());
	}

	@Test
	public void createOrUpdateSuggestion() throws java.text.ParseException {

		// arrange
		Suggestion suggestion1 = new Suggestion();
		ThesaurusConcept concept1 = new ThesaurusConcept();
		suggestion1.setConcept(concept1);
		suggestion1.setContent("hello");
		Date created3 = new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31");
		suggestion1.setCreated(created3);
		suggestion1.setCreator("someone");
		suggestion1.setIdentifier(1);
		suggestion1.setRecipient("1234");
		ThesaurusTerm term1 = new ThesaurusTerm();
		suggestion1.setTerm(term1);
		when(suggestionDAO.update(Mockito.<Suggestion>any()))
			.thenReturn(suggestion1);

		// act
		Suggestion result = service.createOrUpdateSuggestion(new Suggestion());

		// assert
		assertSame(concept1, result.getConcept());
		assertEquals("hello", result.getContent());
		assertSame(created3, result.getCreated());
		assertEquals("someone", result.getCreator());
		assertEquals(1, (int) result.getIdentifier());
		assertEquals("1234", result.getRecipient());
		assertSame(term1, result.getTerm());
	}

	@Test
	public void deleteSuggestion() throws java.text.ParseException {

		// arrange
		Suggestion suggestion1 = new Suggestion();
		ThesaurusConcept concept1 = new ThesaurusConcept();
		suggestion1.setConcept(concept1);
		suggestion1.setContent("hello");
		Date created3 = new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31");
		suggestion1.setCreated(created3);
		suggestion1.setCreator("someone");
		suggestion1.setIdentifier(1);
		suggestion1.setRecipient("1234");
		ThesaurusTerm term1 = new ThesaurusTerm();
		suggestion1.setTerm(term1);
		when(suggestionDAO.delete(Mockito.<Suggestion>any()))
			.thenReturn(suggestion1);

		// act
		Suggestion result = service.deleteSuggestion(new Suggestion());

		// assert
		assertSame(concept1, result.getConcept());
		assertEquals("hello", result.getContent());
		assertSame(created3, result.getCreated());
		assertEquals("someone", result.getCreator());
		assertEquals(1, (int) result.getIdentifier());
		assertEquals("1234", result.getRecipient());
		assertSame(term1, result.getTerm());
	}

	@Test
	public void getConceptSuggestionCountReturnsOne() {
		when(suggestionDAO.getConceptSuggestionCount(Mockito.<String>any()))
			.thenReturn(1L);
		assertEquals(1L, (long) service.getConceptSuggestionCount("1234"));
	}

	@Test
	public void getTermSuggestionCountReturnsOne() {
		when(suggestionDAO.getTermSuggestionCount(Mockito.<String>any()))
			.thenReturn(1L);
		assertEquals(1L, (long) service.getTermSuggestionCount("1234"));
	}

	@Test
	public void getSuggestionPaginatedListByRecipientLimitIsOneAndStartIndexIsOne() {

		// arrange
		ArrayList<Suggestion> suggestionList = new ArrayList<Suggestion>();
		Suggestion suggestion = new Suggestion();
		suggestionList.add(suggestion);
		when(suggestionDAO.findPaginatedSuggestionsByRecipient(Mockito.<String>any(), Mockito.<Integer>any(), Mockito.<Integer>any()))
			.thenReturn(suggestionList);

		// act
		List<Suggestion> result =
			 service.getSuggestionPaginatedListByRecipient("1234", 1, 1);

		// assert
		assertEquals(1, result.size());
		assertSame(suggestion, result.get(0));
	}

	@Test
	public void getSuggestionByRecipientCountReturnsOne() {
		when(suggestionDAO.getSuggestionsByRecipientCount(Mockito.<String>any()))
			.thenReturn(1L);
		assertEquals(1L, (long) service.getSuggestionByRecipientCount("1234"));
	}
}
