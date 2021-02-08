package fr.mcc.ginco.services;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import fr.mcc.ginco.ark.IIDGeneratorService;
import fr.mcc.ginco.beans.Language;
import fr.mcc.ginco.beans.Thesaurus;
import fr.mcc.ginco.beans.ThesaurusConcept;
import fr.mcc.ginco.beans.ThesaurusTerm;
import fr.mcc.ginco.dao.IThesaurusDAO;
import fr.mcc.ginco.dao.IThesaurusTermDAO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

/**
 * Unit tests for fr.mcc.ginco.services.ThesaurusTermServiceImpl
 *
 * @author Diffblue Cover
 */

public class ThesaurusTermServiceImplTest {

	@Mock(name = "generatorService")
	private IIDGeneratorService generatorService;

	@Mock(name = "thesaurusDAO")
	private IThesaurusDAO thesaurusDAO;

	@Mock(name = "thesaurusTermDAO")
	private IThesaurusTermDAO thesaurusTermDAO;

	@InjectMocks
	private ThesaurusTermServiceImpl service;

	@Before
	public void initMocks() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void getThesaurusTermById() {
		ThesaurusTerm thesaurusTerm = mock(ThesaurusTerm.class);
		when(thesaurusTermDAO.getById(Mockito.<String>any()))
			.thenReturn(thesaurusTerm);
		assertNotNull(service.getThesaurusTermById("1234"));
	}

	@Test
	public void getPaginatedThesaurusSandoxedTermsListLimitIsOneAndStartIndexIsOne() {

		// arrange
		ArrayList<ThesaurusTerm> thesaurusTermList = new ArrayList<ThesaurusTerm>();
		ThesaurusTerm thesaurusTerm = new ThesaurusTerm();
		thesaurusTermList.add(thesaurusTerm);
		when(thesaurusTermDAO.findPaginatedSandboxedItems(Mockito.<Integer>any(), Mockito.<Integer>any(), Mockito.<String>any()))
			.thenReturn(thesaurusTermList);

		// act
		List<ThesaurusTerm> result =
			 service.getPaginatedThesaurusSandoxedTermsList(1, 1, "1234");

		// assert
		assertEquals(1, result.size());
		assertSame(thesaurusTerm, result.get(0));
	}

	@Test
	public void getTermsByConceptId() {

		// arrange
		ArrayList<ThesaurusTerm> thesaurusTermList = new ArrayList<ThesaurusTerm>();
		ThesaurusTerm thesaurusTerm = new ThesaurusTerm();
		thesaurusTermList.add(thesaurusTerm);
		when(thesaurusTermDAO.findTermsByConceptId(Mockito.<String>any()))
			.thenReturn(thesaurusTermList);

		// act
		List<ThesaurusTerm> result = service.getTermsByConceptId("1234");

		// assert
		assertEquals(1, result.size());
		assertSame(thesaurusTerm, result.get(0));
	}

	@Test
	public void getSandboxedTermsCountReturnsOne() {
		when(thesaurusTermDAO.countSandboxedTerms(Mockito.<String>any()))
			.thenReturn(1L);
		assertEquals(1L, (long) service.getSandboxedTermsCount("1234"));
	}

	@Test
	public void getSandboxedValidatedTermsCountReturnsOne() {
		when(thesaurusTermDAO.countSandboxedValidatedTerms(Mockito.<String>any()))
			.thenReturn(1L);
		assertEquals(1L, (long) service.getSandboxedValidatedTermsCount("1234"));
	}

	@Test
	public void updateThesaurusTerm() {
		ThesaurusTerm thesaurusTerm = mock(ThesaurusTerm.class);
		when(thesaurusTermDAO.update(Mockito.<ThesaurusTerm>any()))
			.thenReturn(thesaurusTerm);
		ThesaurusTerm object = new ThesaurusTerm();
		object.setStatus(1);
		assertNotNull(service.updateThesaurusTerm(object));
	}

	@Test
	public void getAllTerms2() {

		// arrange
		ArrayList<ThesaurusTerm> thesaurusTermList = new ArrayList<ThesaurusTerm>();
		ThesaurusTerm thesaurusTerm = new ThesaurusTerm();
		thesaurusTermList.add(thesaurusTerm);
		when(thesaurusTermDAO.findAll())
			.thenReturn(thesaurusTermList);

		// act
		List<ThesaurusTerm> result = service.getAllTerms();

		// assert
		assertEquals(1, result.size());
		assertSame(thesaurusTerm, result.get(0));
	}

	@Test
	public void getPaginatedThesaurusSandoxedValidatedTermsListLimitIsOneAndStartIndexIsOne() {

		// arrange
		ArrayList<ThesaurusTerm> thesaurusTermList = new ArrayList<ThesaurusTerm>();
		ThesaurusTerm thesaurusTerm = new ThesaurusTerm();
		thesaurusTermList.add(thesaurusTerm);
		when(thesaurusTermDAO.findPaginatedSandboxedValidatedItems(Mockito.<Integer>any(), Mockito.<Integer>any(), Mockito.<String>any()))
			.thenReturn(thesaurusTermList);

		// act
		List<ThesaurusTerm> result =
			 service.getPaginatedThesaurusSandoxedValidatedTermsList(1, 1, "1234");

		// assert
		assertEquals(1, result.size());
		assertSame(thesaurusTerm, result.get(0));
	}

	@Test
	public void getPreferredTermsCountReturnsOne() {
		when(thesaurusTermDAO.countPreferredTerms(Mockito.<String>any()))
			.thenReturn(1L);
		assertEquals(1L, (long) service.getPreferredTermsCount("1234"));
	}

	@Test
	public void getConceptIdByTermLexicalValueIsValueReturnsData() {
		ThesaurusTerm thesaurusTerm = new ThesaurusTerm();
		ThesaurusConcept concept = new ThesaurusConcept();
		concept.setIdentifier("data");
		thesaurusTerm.setConcept(concept);
		when(thesaurusTermDAO.getTermByLexicalValueThesaurusIdLanguageId(Mockito.<String>any(), Mockito.<String>any(), Mockito.<String>any()))
			.thenReturn(thesaurusTerm);
		assertEquals("data", service.getConceptIdByTerm("value", "1234", "1234"));
	}

	@Test
	public void getPreferredTermByTermLexicalValueIsValueReturnsNull() {
		ThesaurusTerm thesaurusTerm1 = new ThesaurusTerm();
		thesaurusTerm1.setLanguage(new Language());
		ThesaurusTerm thesaurusTerm2 = new ThesaurusTerm();
		thesaurusTerm2.setConcept(new ThesaurusConcept());
		Language language2 = new Language();
		language2.setId("1234");
		thesaurusTerm2.setLanguage(language2);
		thesaurusTerm2.setPrefered(false);
		when(thesaurusTermDAO.getConceptPreferredTerm(Mockito.<String>any()))
			.thenReturn(thesaurusTerm1);
		when(thesaurusTermDAO.getTermByLexicalValueThesaurusIdLanguageId(Mockito.<String>any(), Mockito.<String>any(), Mockito.<String>any()))
			.thenReturn(thesaurusTerm2);
		assertNull(service.getPreferredTermByTerm("value", "1234", "1234"));
	}

	@Test
	public void isTermExistReturnsFalse() {
		when(thesaurusTermDAO.countSimilarTermsByLexicalValueAndLanguage(Mockito.<ThesaurusTerm>any()))
			.thenReturn(0L);
		assertFalse(service.isTermExist(new ThesaurusTerm()));
	}

	@Test
	public void isTermExistReturnsTrue() {
		when(thesaurusTermDAO.countSimilarTermsByLexicalValueAndLanguage(Mockito.<ThesaurusTerm>any()))
			.thenReturn(1L);
		ThesaurusTerm term = mock(ThesaurusTerm.class);
		assertTrue(service.isTermExist(term));
	}

	@Test
	public void isPreferredLexicalValueIsValueReturnsFalse() {
		ThesaurusTerm thesaurusTerm = new ThesaurusTerm();
		thesaurusTerm.setPrefered(false);
		when(thesaurusTermDAO.getTermByLexicalValueThesaurusIdLanguageId(Mockito.<String>any(), Mockito.<String>any(), Mockito.<String>any()))
			.thenReturn(thesaurusTerm);
		assertFalse(service.isPreferred("value", "1234", "1234"));
	}

	@Test
	public void getAllTerms1() {

		// arrange
		ArrayList<ThesaurusTerm> thesaurusTermList = new ArrayList<ThesaurusTerm>();
		ThesaurusTerm thesaurusTerm = new ThesaurusTerm();
		thesaurusTermList.add(thesaurusTerm);
		when(thesaurusTermDAO.findTermsByThesaurusId(Mockito.<String>any()))
			.thenReturn(thesaurusTermList);

		// act
		List<ThesaurusTerm> result = service.getAllTerms("1234");

		// assert
		assertEquals(1, result.size());
		assertSame(thesaurusTerm, result.get(0));
	}

	@Test
	public void getPaginatedThesaurusPreferredTermsListLimitIsOneAndOnlyNotOrphanConceptsIsFalseAndStartIndexIsOne() {

		// arrange
		ArrayList<ThesaurusTerm> thesaurusTermList = new ArrayList<ThesaurusTerm>();
		ThesaurusTerm thesaurusTerm = new ThesaurusTerm();
		thesaurusTermList.add(thesaurusTerm);
		when(thesaurusTermDAO.findPaginatedPreferredItems(Mockito.<Integer>any(), Mockito.<Integer>any(), Mockito.<String>any(), Mockito.<Boolean>any()))
			.thenReturn(thesaurusTermList);

		// act
		List<ThesaurusTerm> result =
			 service.getPaginatedThesaurusPreferredTermsList(1, 1, "1234", false);

		// assert
		assertEquals(1, result.size());
		assertSame(thesaurusTerm, result.get(0));
	}

	@Test
	public void importSandBoxTerms() {

		// arrange
		ThesaurusTerm thesaurusTerm = mock(ThesaurusTerm.class);
		when(thesaurusTermDAO.update(Mockito.<ThesaurusTerm>any()))
			.thenReturn(thesaurusTerm);
		when(thesaurusDAO.getById(Mockito.<String>any()))
			.thenReturn(new Thesaurus());
		when(generatorService.generate(Mockito.<Class>any()))
			.thenReturn("foo");
		HashMap<String, Language> termLexicalValues =
			 new HashMap<String, Language>();
		termLexicalValues.put("", new Language());

		// act
		List<ThesaurusTerm> result =
			 service.importSandBoxTerms(termLexicalValues, "1234", 1);

		// assert
		assertEquals(1, result.size());
		assertSame(thesaurusTerm, result.get(0));
	}

	@Test
	public void importSandBoxTermsTermLexicalValuesIsEmptyReturnsEmpty() {
		when(thesaurusDAO.getById(Mockito.<String>any()))
			.thenReturn(new Thesaurus());
		assertTrue(service.importSandBoxTerms(new HashMap<String, Language>(), "1234", 1).isEmpty());
	}

	@Test
	public void isTermAlreadyUsedInConceptReturnsFalse() {
		when(thesaurusTermDAO.getTermByLexicalValueThesaurusIdLanguageId(Mockito.<String>any(), Mockito.<String>any(), Mockito.<String>any()))
			.thenReturn(new ThesaurusTerm());
		ThesaurusTerm term = new ThesaurusTerm();
		term.setLanguage(new Language());
		term.setThesaurus(new Thesaurus());
		assertFalse(service.isTermAlreadyUsedInConcept(term));
	}

	@Test
	public void isTermAlreadyUsedInConceptReturnsTrue() {
		ThesaurusTerm thesaurusTerm = new ThesaurusTerm();
		ThesaurusConcept concept1 = mock(ThesaurusConcept.class);
		thesaurusTerm.setConcept(concept1);
		when(thesaurusTermDAO.getTermByLexicalValueThesaurusIdLanguageId(Mockito.<String>any(), Mockito.<String>any(), Mockito.<String>any()))
			.thenReturn(thesaurusTerm);
		ThesaurusTerm term = new ThesaurusTerm();
		term.setLanguage(new Language());
		term.setThesaurus(new Thesaurus());
		assertTrue(service.isTermAlreadyUsedInConcept(term));
	}
}
