package fr.mcc.ginco.utils;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.nullValue;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
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
	void getFormats() {
		assertThat(new EncodedControl("foo").getFormats("foo"), hasSize(2));
		assertThat(new EncodedControl("foo").getFormats("foo").get(0), is("java.class"));
		assertThat(new EncodedControl("foo").getFormats("foo").get(1), is("java.properties"));
	}
}
