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
		ReducedThesaurus reducedThesaurus = new ReducedThesaurus();
		reducedThesaurus.setIdentifier("data");
		reducedThesaurus.setTitle("Mr");
		assertThat(reducedThesaurus.getIdentifier(), is("data"));
		assertThat(reducedThesaurus.getTitle(), is("Mr"));
	}
}
