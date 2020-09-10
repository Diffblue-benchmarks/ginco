package fr.mcc.ginco.solr;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

import org.junit.jupiter.api.Test;

/**
 * Unit tests for fr.mcc.ginco.solr.SortCriteria
 *
 * @author Diffblue Cover
 */

class SortCriteriaTest {

	@Test
	void getSolrSortString() {
		assertThat(new SortCriteria(null, "foo").getSolrSortString(), is("score desc"));
		assertThat(new SortCriteria("lexicalValue", "foo").getSolrSortString(), is("lexicalValue_sort desc ,score desc"));
		assertThat(new SortCriteria("foo", null).getSolrSortString(), is("score desc"));
		assertThat(new SortCriteria("lexicalValue", "asc").getSolrSortString(), is("lexicalValue_sort asc ,score desc"));
		assertThat(new SortCriteria("lexicalValue", "desc").getSolrSortString(), is("lexicalValue_sort desc ,score desc"));
	}
}
