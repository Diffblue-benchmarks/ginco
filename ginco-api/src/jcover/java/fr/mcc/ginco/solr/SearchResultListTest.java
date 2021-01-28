package fr.mcc.ginco.solr;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

import org.junit.jupiter.api.Test;

/**
 * Unit tests for fr.mcc.ginco.solr.SearchResultList
 *
 * @author Diffblue Cover
 */

class SearchResultListTest {

	@Test
	void factory() {
		SearchResultList searchResultList = new SearchResultList();
		searchResultList.setNumFound(1L);
		assertThat(searchResultList.isEmpty(), is(true));
	}
}
