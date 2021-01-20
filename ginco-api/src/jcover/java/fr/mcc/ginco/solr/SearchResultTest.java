package fr.mcc.ginco.solr;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
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
		searchResult.setCreated("someone");
		searchResult.setIdentifier("data");
		ArrayList<String> languages = new ArrayList<String>();
		languages.add("foo");
		searchResult.setLanguages(languages);
		searchResult.setLexicalValue("value");
		searchResult.setModified("someone");
		searchResult.setStatus(1);
		searchResult.setThesaurusId("1234");
		searchResult.setThesaurusTitle("Mr");
		searchResult.setType("BASIC");
		searchResult.setTypeExt("html");
		assertThat(searchResult.getConceptId(), is("1234"));
		assertThat(searchResult.getCreated(), is("someone"));
		assertThat(searchResult.getIdentifier(), is("data"));
		assertThat(searchResult.getLanguages(), hasSize(1));
		assertThat(searchResult.getLanguages().get(0), is("foo"));
		assertThat(searchResult.getLexicalValue(), is("value"));
		assertThat(searchResult.getModified(), is("someone"));
		assertThat(searchResult.getStatus(), is(1));
		assertThat(searchResult.getThesaurusId(), is("1234"));
		assertThat(searchResult.getThesaurusTitle(), is("Mr"));
		assertThat(searchResult.getType(), is("BASIC"));
		assertThat(searchResult.getTypeExt(), is("html"));
	}
}
