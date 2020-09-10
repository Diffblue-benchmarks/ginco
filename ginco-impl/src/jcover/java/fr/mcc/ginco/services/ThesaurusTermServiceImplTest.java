package fr.mcc.ginco.services;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import fr.mcc.ginco.ark.IIDGeneratorService;
import fr.mcc.ginco.beans.ThesaurusConcept;
import fr.mcc.ginco.beans.ThesaurusTerm;
import fr.mcc.ginco.dao.IThesaurusDAO;
import fr.mcc.ginco.dao.IThesaurusTermDAO;

import java.util.ArrayList;

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

	@Before public void initMocks() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void getAllTerms1() {
		assertTrue((service.getAllTerms()).isEmpty());
	}

	@Test
	public void getAllTerms2() {
		when(thesaurusTermDAO.findTermsByThesaurusId(Mockito.<String>any()))
			.thenReturn(new ArrayList<ThesaurusTerm>());
		assertTrue((service.getAllTerms("1234")).isEmpty());
	}

	@Test
	public void getConceptIdByTermLexicalValueIsValueReturnsHello() {
		ThesaurusTerm thesaurusTerm = new ThesaurusTerm();
		ThesaurusConcept concept = new ThesaurusConcept();
		concept.setIdentifier("hello");
		thesaurusTerm.setConcept(concept);
		when(thesaurusTermDAO.getTermByLexicalValueThesaurusIdLanguageId(Mockito.<String>any(), Mockito.<String>any(), Mockito.<String>any()))
			.thenReturn(thesaurusTerm);
		assertEquals("hello", service.getConceptIdByTerm("value", "1234", "1234"));
	}

	@Test
	public void getPaginatedThesaurusPreferredTermsListLimitIsOneAndOnlyNotOrphanConceptsIsFalseAndStartIndexIsOneReturnsEmpty() {
		when(thesaurusTermDAO.findPaginatedPreferredItems(Mockito.<Integer>any(), Mockito.<Integer>any(), Mockito.<String>any(), Mockito.<Boolean>any()))
			.thenReturn(new ArrayList<ThesaurusTerm>());
		assertTrue((service.getPaginatedThesaurusPreferredTermsList(1, 1, "1234", false)).isEmpty());
	}

	@Test
	public void getPaginatedThesaurusSandoxedTermsListLimitIsOneAndStartIndexIsOneReturnsEmpty() {
		when(thesaurusTermDAO.findPaginatedSandboxedItems(Mockito.<Integer>any(), Mockito.<Integer>any(), Mockito.<String>any()))
			.thenReturn(new ArrayList<ThesaurusTerm>());
		assertTrue((service.getPaginatedThesaurusSandoxedTermsList(1, 1, "1234")).isEmpty());
	}

	@Test
	public void getPaginatedThesaurusSandoxedValidatedTermsListLimitIsOneAndStartIndexIsOneReturnsEmpty() {
		when(thesaurusTermDAO.findPaginatedSandboxedValidatedItems(Mockito.<Integer>any(), Mockito.<Integer>any(), Mockito.<String>any()))
			.thenReturn(new ArrayList<ThesaurusTerm>());
		assertTrue((service.getPaginatedThesaurusSandoxedValidatedTermsList(1, 1, "1234")).isEmpty());
	}

	@Test
	public void getPreferredTermsCountReturnsOne() {
		when(thesaurusTermDAO.countPreferredTerms(Mockito.<String>any()))
			.thenReturn(1L);
		assertEquals(1L, (long) service.getPreferredTermsCount("1234"));
	}

	@Test
	public void updateThesaurusTermReturnsNull() {
		ThesaurusTerm object = new ThesaurusTerm();
		object.setStatus(1);
		assertNull(service.updateThesaurusTerm(object));
	}
}
