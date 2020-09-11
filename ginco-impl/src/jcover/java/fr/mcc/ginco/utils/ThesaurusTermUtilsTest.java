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
	public void getPreferedTermsByLangListOfTermsIsEmptyReturnsEmpty() {
		assertTrue((service.getPreferedTermsByLang(new ArrayList<ThesaurusTerm>(), "1234")).isEmpty());
	}

	@Test
	public void getPreferedTermsListOfTermsIsEmptyReturnsEmpty() {
		assertTrue((service.getPreferedTerms(new ArrayList<ThesaurusTerm>())).isEmpty());
	}
}
