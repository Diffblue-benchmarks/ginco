package fr.mcc.ginco.utils;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.nullValue;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;

import java.util.Arrays;
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
		assertThat(new EncodedControl("bar").newBundle("Acme", new Locale("en"), "java.properties", ClassLoader.getSystemClassLoader(), false), is(nullValue()));
	}

	@Test
	void getFormats() {
		assertThat(new EncodedControl("UTF-8").getFormats("foo"), equalTo(Arrays.asList("java.class", "java.properties")));
	}
}
