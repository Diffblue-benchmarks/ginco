package fr.mcc.ginco.utils;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

import fr.mcc.ginco.beans.Language;

import org.junit.jupiter.api.Test;

/**
 * Unit tests for fr.mcc.ginco.utils.LabelUtil
 *
 * @author Diffblue Cover
 */

class LabelUtilTest {

	@Test
	void getLocalizedLabelDefaultLangIsLabelAndLexicalValueIsBar() {
		Language language = new Language();
		language.setId("1234");
		assertThat(LabelUtil.getLocalizedLabel("bar", language, "label"), is("bar@1234"));
	}

	@Test
	void getResourceLabelKeyIsKeyReturnsKey() {
		assertThat(LabelUtil.getResourceLabel("key"), is("key"));
	}

	@Test
	void getDefaultLabelKeyIsKeyReturnsKey() {
		assertThat(LabelUtil.getDefaultLabel("key"), is("key"));
	}
}
