package fr.mcc.ginco.data;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.Test;

/**
 * Unit tests for fr.mcc.ginco.data.FullThesaurus
 *
 * @author Diffblue Cover
 */

class FullThesaurusTest {

	@Test
	void factory() {
		FullThesaurus fullThesaurus = new FullThesaurus();
		fullThesaurus.setContributor("something");
		fullThesaurus.setCoverage("something");
		fullThesaurus.setCreated("someone");
		fullThesaurus.setCreatorEmail("info@diffblue.com");
		fullThesaurus.setCreatorHomepage("someone");
		fullThesaurus.setCreatorName("Acme");
		fullThesaurus.setDescription("some text");
		ArrayList<String> formats = new ArrayList<String>();
		formats.add("yyyy-MM-dd");
		fullThesaurus.setFormats(formats);
		ArrayList<String> languages = new ArrayList<String>();
		languages.add("something");
		fullThesaurus.setLanguages(languages);
		fullThesaurus.setModified("someone");
		fullThesaurus.setPublisher("something");
		fullThesaurus.setRelation("DE");
		fullThesaurus.setRights("something");
		fullThesaurus.setSource("something");
		fullThesaurus.setSubject("something");
		fullThesaurus.setType("BASIC");
		fullThesaurus.setIdentifier("data");
		fullThesaurus.setTitle("Mr");
		assertThat(fullThesaurus.getContributor(), is("something"));
		assertThat(fullThesaurus.getCoverage(), is("something"));
		assertThat(fullThesaurus.getCreated(), is("someone"));
		assertThat(fullThesaurus.getCreatorEmail(), is("info@diffblue.com"));
		assertThat(fullThesaurus.getCreatorHomepage(), is("someone"));
		assertThat(fullThesaurus.getCreatorName(), is("Acme"));
		assertThat(fullThesaurus.getDescription(), is("some text"));
		assertThat(fullThesaurus.getFormats(), equalTo(Arrays.asList("yyyy-MM-dd")));
		assertThat(fullThesaurus.getLanguages(), equalTo(Arrays.asList("something")));
		assertThat(fullThesaurus.getModified(), is("someone"));
		assertThat(fullThesaurus.getPublisher(), is("something"));
		assertThat(fullThesaurus.getRelation(), is("DE"));
		assertThat(fullThesaurus.getRights(), is("something"));
		assertThat(fullThesaurus.getSource(), is("something"));
		assertThat(fullThesaurus.getSubject(), is("something"));
		assertThat(fullThesaurus.getType(), is("BASIC"));
		assertThat(fullThesaurus.getIdentifier(), is("data"));
		assertThat(fullThesaurus.getTitle(), is("Mr"));
	}
}
