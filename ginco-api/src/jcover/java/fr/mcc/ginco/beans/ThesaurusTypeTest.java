package fr.mcc.ginco.beans;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

import org.junit.jupiter.api.Test;

/**
 * Unit tests for fr.mcc.ginco.beans.ThesaurusType
 *
 * @author Diffblue Cover
 */

class ThesaurusTypeTest {

	@Test
	void factory1() {
		ThesaurusType thesaurusType = new ThesaurusType();
		thesaurusType.setIdentifier(1);
		thesaurusType.setLabel("label");
		assertThat(thesaurusType.getIdentifier(), is(1));
		assertThat(thesaurusType.getLabel(), is("label"));
	}

	@Test
	void factory2() {
		ThesaurusType thesaurusType = new ThesaurusType(1, "label");
		thesaurusType.setIdentifier(1);
		thesaurusType.setLabel("label");
		assertThat(thesaurusType.getIdentifier(), is(1));
		assertThat(thesaurusType.getLabel(), is("label"));
	}
}
