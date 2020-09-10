package fr.mcc.ginco.data;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

import org.junit.jupiter.api.Test;

/**
 * Unit tests for fr.mcc.ginco.data.ReducedThesaurus
 *
 * @author Diffblue Cover
 */

class ReducedThesaurusTest {

	@Test
	void factory() {
		ReducedThesaurus reducedThesaurus = new FullThesaurus();
		reducedThesaurus.setIdentifier("something");
		reducedThesaurus.setTitle("Mr");
		assertThat(reducedThesaurus.getIdentifier(), is("something"));
		assertThat(reducedThesaurus.getTitle(), is("Mr"));
	}
}
