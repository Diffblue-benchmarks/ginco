package fr.mcc.ginco.solr;

import static org.junit.jupiter.api.Assertions.assertTrue;

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
		assertTrue((searchResultList).isEmpty());
	}
}
