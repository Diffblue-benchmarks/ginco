package fr.mcc.ginco.utils;

import static org.junit.Assert.assertTrue;

import fr.mcc.ginco.beans.ThesaurusTerm;

import java.util.ArrayList;

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

	@Before public void initMocks() {
		MockitoAnnotations.initMocks(this);
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
	public void getPreferedTerms() {
		ArrayList<ThesaurusTerm> listOfTerms = new ArrayList<ThesaurusTerm>();
		ThesaurusTerm thesaurusTerm = new ThesaurusTerm();
		thesaurusTerm.setPrefered(false);
		listOfTerms.add(thesaurusTerm);
		assertTrue((service.getPreferedTerms(listOfTerms)).isEmpty());
	}

	@Test
	public void getPreferedTermsByLang() {
		ArrayList<ThesaurusTerm> listOfTerms = new ArrayList<ThesaurusTerm>();
		ThesaurusTerm thesaurusTerm = new ThesaurusTerm();
		thesaurusTerm.setPrefered(false);
		listOfTerms.add(thesaurusTerm);
		assertTrue((service.getPreferedTermsByLang(listOfTerms, "1234")).isEmpty());
	}

	@Test
	public void getPreferedTermsByLangListOfTermsIsEmpty() {
		assertTrue((service.getPreferedTermsByLang(new ArrayList<ThesaurusTerm>(), "1234")).isEmpty());
	}

	@Test
	public void getPreferedTermsListOfTermsIsEmpty() {
		assertTrue((service.getPreferedTerms(new ArrayList<ThesaurusTerm>())).isEmpty());
	}
}
