package fr.mcc.ginco.data;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.empty;
import static org.hamcrest.core.Is.is;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

/**
 * Unit tests for fr.mcc.ginco.data.ReducedThesaurusArray
 *
 * @author Diffblue Cover
 */

class ReducedThesaurusArrayTest {

	@Test
	void factory() {
		ReducedThesaurusArray reducedThesaurusArray = new ReducedThesaurusArray();
		reducedThesaurusArray.setIdentifier("something");
		reducedThesaurusArray.setOrdered(false);
		reducedThesaurusArray.setTerms(new ArrayList<ReducedThesaurusTerm>());
		reducedThesaurusArray.setTitle("Mr");
		assertThat(reducedThesaurusArray.getIdentifier(), is("something"));
		assertThat(reducedThesaurusArray.getOrdered(), is(false));
		assertThat(reducedThesaurusArray.getTerms(), empty());
		assertThat(reducedThesaurusArray.getTitle(), is("Mr"));
	}
}
