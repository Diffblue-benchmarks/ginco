package fr.mcc.ginco.beans;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

import org.junit.jupiter.api.Test;

/**
 * Unit tests for fr.mcc.ginco.beans.Language
 *
 * @author Diffblue Cover
 */

class LanguageTest {

	@Test
	void factory() {
		Language language = new Language();
		language.setId("1234");
		language.setPart1("bar");
		language.setPrincipalLanguage(true);
		language.setRefname("foo");
		language.setTopLanguage(false);
		assertThat(language.getId(), is("1234"));
		assertThat(language.getPart1(), is("bar"));
		assertThat(language.getRefname(), is("foo"));
		assertThat(language.isPrincipalLanguage(), is(true));
		assertThat(language.isTopLanguage(), is(false));
	}
}
