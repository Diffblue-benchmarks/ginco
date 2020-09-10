package fr.mcc.ginco.utils;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.nullValue;
import static org.hamcrest.core.Is.is;

import java.util.Locale;

import org.junit.jupiter.api.Test;

/**
 * Unit tests for fr.mcc.ginco.utils.EncodedControl
 *
 * @author Diffblue Cover
 */

class EncodedControlTest {

	@Test
	void newBundleBaseNameIsAcmeAndReloadIsFalseReturnsNull() throws IllegalAccessException, InstantiationException, java.io.IOException {
		assertThat(new EncodedControl("foo").newBundle("Acme", new Locale("en"), "java.properties", ClassLoader.getSystemClassLoader(), false), is(nullValue()));
	}

	@Test
	void toResourceName() {
		assertThat(new EncodedControl("foo").toResourceName("Acme", "Acme"), is("Acme.Acme"));
	}
}
