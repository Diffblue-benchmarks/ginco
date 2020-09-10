package fr.mcc.ginco.beans;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.empty;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsSame.sameInstance;

import java.util.Date;
import java.util.HashSet;

import org.junit.jupiter.api.Test;

/**
 * Unit tests for fr.mcc.ginco.beans.Thesaurus
 *
 * @author Diffblue Cover
 */

class ThesaurusTest {

	@Test
	void factory() throws java.text.ParseException {
		Thesaurus thesaurus = new Thesaurus();
		thesaurus.setArchived(false);
		thesaurus.setContributor("foo");
		thesaurus.setCoverage("foo");
		Date created = new java.text.SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31");
		thesaurus.setCreated(created);
		ThesaurusOrganization creator = new ThesaurusOrganization();
		creator.setEmail("info@diffblue.com");
		creator.setHomepage("foo");
		creator.setIdentifier(1);
		creator.setName("Acme");
		thesaurus.setCreator(creator);
		Date date = new java.text.SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31");
		thesaurus.setDate(date);
		thesaurus.setDefaultTopConcept(false);
		thesaurus.setDescription("some text");
		thesaurus.setFormat(new HashSet<ThesaurusFormat>());
		thesaurus.setIdentifier("foo");
		thesaurus.setLang(new HashSet<Language>());
		thesaurus.setPolyHierarchical(false);
		thesaurus.setPublisher("foo");
		thesaurus.setRelation("DE");
		thesaurus.setRights("foo");
		thesaurus.setSource("foo");
		thesaurus.setSubject("foo");
		thesaurus.setTitle("Mr");
		ThesaurusType type = new ThesaurusType();
		type.setIdentifier(1);
		type.setLabel("label");
		thesaurus.setType(type);
		thesaurus.setVersions(new HashSet<ThesaurusVersionHistory>());
		assertThat(thesaurus.getContributor(), is("foo"));
		assertThat(thesaurus.getCoverage(), is("foo"));
		assertThat(thesaurus.getCreated(), sameInstance(created));
		assertThat(thesaurus.getCreator(), sameInstance(creator));
		assertThat(thesaurus.getDate(), sameInstance(date));
		assertThat(thesaurus.getDescription(), is("some text"));
		assertThat(thesaurus.getFormat(), empty());
		assertThat(thesaurus.getIdentifier(), is("foo"));
		assertThat(thesaurus.getLang(), empty());
		assertThat(thesaurus.getPublisher(), is("foo"));
		assertThat(thesaurus.getRelation(), is("DE"));
		assertThat(thesaurus.getRights(), is("foo"));
		assertThat(thesaurus.getSource(), is("foo"));
		assertThat(thesaurus.getSubject(), is("foo"));
		assertThat(thesaurus.getThesaurusId(), is("foo"));
		assertThat(thesaurus.getTitle(), is("Mr"));
		assertThat(thesaurus.getType(), sameInstance(type));
		assertThat(thesaurus.getVersions(), empty());
		assertThat(thesaurus.isArchived(), is(false));
		assertThat(thesaurus.isDefaultTopConcept(), is(false));
		assertThat(thesaurus.isPolyHierarchical(), is(false));
	}

	@Test
	void addLang() {

		// arrange
		Thesaurus thesaurus = new Thesaurus();
		Language item = new Language();

		// act
		thesaurus.addLang(item);

		// assert
		assertThat(thesaurus.getLang(), hasSize(1));
		assertThat(thesaurus.getLang(), hasItem(item));
	}

	@Test
	void addFormat() {

		// arrange
		Thesaurus thesaurus = new Thesaurus();
		ThesaurusFormat item = new ThesaurusFormat();

		// act
		thesaurus.addFormat(item);

		// assert
		assertThat(thesaurus.getFormat(), hasSize(1));
		assertThat(thesaurus.getFormat(), hasItem(item));
	}
}
