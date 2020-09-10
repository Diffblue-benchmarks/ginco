package fr.mcc.ginco.solr;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.empty;
import static org.hamcrest.core.Is.is;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

/**
 * Unit tests for fr.mcc.ginco.solr.SearchResult
 *
 * @author Diffblue Cover
 */

class SearchResultTest {

	@Test
	void factory() {
		SearchResult searchResult = new SearchResult();
		searchResult.setConceptId("1234");
		searchResult.setCreated("foo");
		searchResult.setIdentifier("foo");
		searchResult.setLanguages(new ArrayList<String>());
		searchResult.setLexicalValue("value");
		searchResult.setModified("foo");
		searchResult.setStatus(1);
		searchResult.setThesaurusId("1234");
		searchResult.setThesaurusTitle("Mr");
		searchResult.setType("BASIC");
		searchResult.setTypeExt("html");
		assertThat(searchResult.getConceptId(), is("1234"));
		assertThat(searchResult.getCreated(), is("foo"));
		assertThat(searchResult.getIdentifier(), is("foo"));
		assertThat(searchResult.getLanguages(), empty());
		assertThat(searchResult.getLexicalValue(), is("value"));
		assertThat(searchResult.getModified(), is("foo"));
		assertThat(searchResult.getStatus(), is(1));
		assertThat(searchResult.getThesaurusId(), is("1234"));
		assertThat(searchResult.getThesaurusTitle(), is("Mr"));
		assertThat(searchResult.getType(), is("BASIC"));
		assertThat(searchResult.getTypeExt(), is("html"));
	}
}
