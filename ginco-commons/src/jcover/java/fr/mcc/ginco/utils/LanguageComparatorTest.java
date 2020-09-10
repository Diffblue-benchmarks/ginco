package fr.mcc.ginco.utils;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

import fr.mcc.ginco.beans.Language;

import org.junit.jupiter.api.Test;

/**
 * Unit tests for fr.mcc.ginco.utils.LanguageComparator
 *
 * @author Diffblue Cover
 */

class LanguageComparatorTest {

	@Test
	void compareReturnsMinusOne() {
		Language o1 = new Language();
		o1.setId("1234");
		Language o2 = new Language();
		o2.setId("bar");
		assertThat(new LanguageComparator("bar").compare(o1, o2), is(-1));
	}

	@Test
	void compareReturnsOne() {
		Language o1 = new Language();
		o1.setId("bar");
		Language o2 = new Language();
		o2.setId("1234");
		assertThat(new LanguageComparator("bar").compare(o1, o2), is(1));
	}

	@Test
	void compareReturnsZero() {
		Language o1 = new Language();
		o1.setId("1234");
		o1.setRefname("foo");
		Language o2 = new Language();
		o2.setId("1234");
		o2.setRefname("foo");
		assertThat(new LanguageComparator("bar").compare(o1, o2), is(0));
	}
}
