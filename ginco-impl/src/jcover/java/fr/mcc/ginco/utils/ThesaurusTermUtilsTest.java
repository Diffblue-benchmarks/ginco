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
	public void getPreferedTermsReturnsEmpty() {
		ArrayList<ThesaurusTerm> listOfTerms = new ArrayList<ThesaurusTerm>();
		ThesaurusTerm thesaurusTerm = new ThesaurusTerm();
		thesaurusTerm.setPrefered(false);
		listOfTerms.add(thesaurusTerm);
		assertTrue((service.getPreferedTerms(listOfTerms)).isEmpty());
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
	public void getPreferedTermsByLangReturnsEmpty() {
		ArrayList<ThesaurusTerm> listOfTerms = new ArrayList<ThesaurusTerm>();
		ThesaurusTerm thesaurusTerm = new ThesaurusTerm();
		thesaurusTerm.setPrefered(false);
		listOfTerms.add(thesaurusTerm);
		assertTrue((service.getPreferedTermsByLang(listOfTerms, "1234")).isEmpty());
	}
}
