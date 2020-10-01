package fr.mcc.ginco.beans;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsSame.sameInstance;

import org.junit.jupiter.api.Test;

/**
 * Unit tests for fr.mcc.ginco.beans.ExternalThesaurus
 *
 * @author Diffblue Cover
 */

class ExternalThesaurusTest {

	@Test
	void factory() {
		ExternalThesaurus externalThesaurus = new ExternalThesaurus();
		externalThesaurus.setExternalId("1234");
		ExternalThesaurusType externalThesaurusType = new ExternalThesaurusType();
		externalThesaurusType.setIdentifier(1);
		externalThesaurusType.setLabel("label");
		externalThesaurus.setExternalThesaurusType(externalThesaurusType);
		externalThesaurus.setIdentifier(1);
		assertThat(externalThesaurus.getExternalId(), is("1234"));
		assertThat(externalThesaurus.getExternalThesaurusType(), sameInstance(externalThesaurusType));
		assertThat(externalThesaurus.getIdentifier(), is(1));
	}

	@Test
	void testEquals() {
		assertThat(new ExternalThesaurus().equals("foo"), is(false));
		assertThat(new ExternalThesaurus().equals(null), is(false));
	}
}
