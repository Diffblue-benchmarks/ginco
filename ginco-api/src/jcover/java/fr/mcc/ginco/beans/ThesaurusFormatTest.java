package fr.mcc.ginco.beans;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

import org.junit.jupiter.api.Test;

/**
 * Unit tests for fr.mcc.ginco.beans.ThesaurusFormat
 *
 * @author Diffblue Cover
 */

class ThesaurusFormatTest {

	@Test
	void factory() {
		ThesaurusFormat thesaurusFormat = new ThesaurusFormat();
		thesaurusFormat.setIdentifier(1);
		thesaurusFormat.setLabel("label");
		assertThat(thesaurusFormat.getIdentifier(), is(1));
		assertThat(thesaurusFormat.getLabel(), is("label"));
	}
}
