package fr.mcc.ginco.beans;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

import org.junit.jupiter.api.Test;

/**
 * Unit tests for fr.mcc.ginco.beans.ExternalThesaurusType
 *
 * @author Diffblue Cover
 */

class ExternalThesaurusTypeTest {

	@Test
	void factory() {
		ExternalThesaurusType externalThesaurusType = new ExternalThesaurusType();
		externalThesaurusType.setIdentifier(1);
		externalThesaurusType.setLabel("label");
		assertThat(externalThesaurusType.getIdentifier(), is(1));
		assertThat(externalThesaurusType.getLabel(), is("label"));
	}
}
