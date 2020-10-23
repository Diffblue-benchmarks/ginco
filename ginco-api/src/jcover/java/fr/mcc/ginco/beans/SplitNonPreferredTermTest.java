package fr.mcc.ginco.beans;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.notNullValue;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsSame.sameInstance;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;

import org.junit.jupiter.api.Test;

/**
 * Unit tests for fr.mcc.ginco.beans.SplitNonPreferredTerm
 *
 * @author Diffblue Cover
 */

class SplitNonPreferredTermTest {

	@Test
	void factory() throws java.text.ParseException {
		SplitNonPreferredTerm splitNonPreferredTerm = new SplitNonPreferredTerm();
		Date created1 = new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31");
		splitNonPreferredTerm.setCreated(created1);
		splitNonPreferredTerm.setIdentifier("data");
		Language language = new Language();
		language.setId("1234");
		language.setPart1("foo");
		language.setPrincipalLanguage(false);
		language.setRefname("root");
		language.setTopLanguage(false);
		splitNonPreferredTerm.setLanguage(language);
		splitNonPreferredTerm.setLexicalValue("value");
		Date modified = new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31");
		splitNonPreferredTerm.setModified(modified);
		splitNonPreferredTerm.setPreferredTerms(new HashSet<ThesaurusTerm>());
		splitNonPreferredTerm.setSource("foo");
		splitNonPreferredTerm.setStatus(1);
		Thesaurus thesaurus = new Thesaurus();
		thesaurus.setArchived(false);
		thesaurus.setContributor("foo");
		thesaurus.setCoverage("foo");
		thesaurus.setCreated(new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31"));
		ThesaurusOrganization creator = new ThesaurusOrganization();
		creator.setEmail("info@diffblue.com");
		creator.setHomepage("foo");
		creator.setIdentifier(1);
		creator.setName("Acme");
		thesaurus.setCreator(creator);
		thesaurus.setDate(new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31"));
		thesaurus.setDefaultTopConcept(false);
		thesaurus.setDescription("some text");
		thesaurus.setFormat(new HashSet<ThesaurusFormat>());
		thesaurus.setIdentifier("data");
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
		splitNonPreferredTerm.setThesaurus(thesaurus);
		assertThat(splitNonPreferredTerm.getCreated(), sameInstance(created1));
		assertThat(splitNonPreferredTerm.getIdentifier(), is("data"));
		assertThat(splitNonPreferredTerm.getLanguage(), sameInstance(language));
		assertThat(splitNonPreferredTerm.getLexicalValue(), is("value"));
		assertThat(splitNonPreferredTerm.getModified(), sameInstance(modified));
		assertThat(splitNonPreferredTerm.getPreferredTerms(), is(notNullValue()));
		assertThat(splitNonPreferredTerm.getSource(), is("foo"));
		assertThat(splitNonPreferredTerm.getStatus(), is(1));
		assertThat(splitNonPreferredTerm.getThesaurus(), sameInstance(thesaurus));
	}

	@Test
	void getThesaurusIdReturnsData() {
		SplitNonPreferredTerm splitNonPreferredTerm = new SplitNonPreferredTerm();
		Thesaurus thesaurus = new Thesaurus();
		thesaurus.setIdentifier("data");
		splitNonPreferredTerm.setThesaurus(thesaurus);
		assertThat(splitNonPreferredTerm.getThesaurusId(), is("data"));
	}
}
