package fr.mcc.ginco.data;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.hamcrest.core.Is.is;

import java.util.ArrayList;

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
		fullThesaurus.setCreated("something");
		fullThesaurus.setCreatorEmail("info@diffblue.com");
		fullThesaurus.setCreatorHomepage("+");
		fullThesaurus.setCreatorName("Acme");
		fullThesaurus.setDescription("some text");
		ArrayList<String> formats = new ArrayList<String>();
		formats.add("yyyy-MM-dd");
		fullThesaurus.setFormats(formats);
		ArrayList<String> languages = new ArrayList<String>();
		languages.add("something");
		fullThesaurus.setLanguages(languages);
		fullThesaurus.setModified("something");
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
		assertThat(fullThesaurus.getCreated(), is("something"));
		assertThat(fullThesaurus.getCreatorEmail(), is("info@diffblue.com"));
		assertThat(fullThesaurus.getCreatorHomepage(), is("+"));
		assertThat(fullThesaurus.getCreatorName(), is("Acme"));
		assertThat(fullThesaurus.getDescription(), is("some text"));
		assertThat(fullThesaurus.getFormats(), hasSize(1));
		assertThat(fullThesaurus.getFormats().get(0), is("yyyy-MM-dd"));
		assertThat(fullThesaurus.getLanguages(), hasSize(1));
		assertThat(fullThesaurus.getLanguages().get(0), is("something"));
		assertThat(fullThesaurus.getModified(), is("something"));
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
