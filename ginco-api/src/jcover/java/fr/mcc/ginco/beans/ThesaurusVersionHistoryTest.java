package fr.mcc.ginco.beans;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsSame.sameInstance;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;

import org.junit.jupiter.api.Test;

/**
 * Unit tests for fr.mcc.ginco.beans.ThesaurusVersionHistory
 *
 * @author Diffblue Cover
 */

class ThesaurusVersionHistoryTest {

	@Test
	void factory1() throws java.text.ParseException {
		ThesaurusVersionHistory thesaurusVersionHistory =
			 new ThesaurusVersionHistory();
		Date date1 = new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31");
		thesaurusVersionHistory.setDate(date1);
		thesaurusVersionHistory.setIdentifier("data");
		thesaurusVersionHistory.setStatus(1);
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
		thesaurusVersionHistory.setThesaurus(thesaurus);
		thesaurusVersionHistory.setThisVersion(false);
		thesaurusVersionHistory.setUserId("root");
		thesaurusVersionHistory.setVersionNote("1.0");
		assertThat(thesaurusVersionHistory.getDate(), sameInstance(date1));
		assertThat(thesaurusVersionHistory.getIdentifier(), is("data"));
		assertThat(thesaurusVersionHistory.getStatus(), is(1));
		assertThat(thesaurusVersionHistory.getThesaurus(), sameInstance(thesaurus));
		assertThat(thesaurusVersionHistory.getThisVersion(), is(false));
		assertThat(thesaurusVersionHistory.getUserId(), is("root"));
		assertThat(thesaurusVersionHistory.getVersionNote(), is("1.0"));
	}

	@Test
	void factory2() throws java.text.ParseException {
		Thesaurus thesaurusIdentifier = new Thesaurus();
		thesaurusIdentifier.setArchived(false);
		thesaurusIdentifier.setContributor("foo");
		thesaurusIdentifier.setCoverage("foo");
		thesaurusIdentifier.setCreated(new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31"));
		ThesaurusOrganization creator1 = new ThesaurusOrganization();
		creator1.setEmail("info@diffblue.com");
		creator1.setHomepage("foo");
		creator1.setIdentifier(1);
		creator1.setName("Acme");
		thesaurusIdentifier.setCreator(creator1);
		thesaurusIdentifier.setDate(new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31"));
		thesaurusIdentifier.setDefaultTopConcept(false);
		thesaurusIdentifier.setDescription("some text");
		thesaurusIdentifier.setFormat(new HashSet<ThesaurusFormat>());
		thesaurusIdentifier.setIdentifier("data");
		thesaurusIdentifier.setLang(new HashSet<Language>());
		thesaurusIdentifier.setPolyHierarchical(false);
		thesaurusIdentifier.setPublisher("foo");
		thesaurusIdentifier.setRelation("DE");
		thesaurusIdentifier.setRights("foo");
		thesaurusIdentifier.setSource("foo");
		thesaurusIdentifier.setSubject("foo");
		thesaurusIdentifier.setTitle("Mr");
		ThesaurusType type1 = new ThesaurusType();
		type1.setIdentifier(1);
		type1.setLabel("label");
		thesaurusIdentifier.setType(type1);
		thesaurusIdentifier.setVersions(new HashSet<ThesaurusVersionHistory>());
		ThesaurusVersionHistory thesaurusVersionHistory =
			 new ThesaurusVersionHistory("data", new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31"), "1.0", 1, false, thesaurusIdentifier);
		Date date3 = new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31");
		thesaurusVersionHistory.setDate(date3);
		thesaurusVersionHistory.setIdentifier("data");
		thesaurusVersionHistory.setStatus(1);
		Thesaurus thesaurus = new Thesaurus();
		thesaurus.setArchived(false);
		thesaurus.setContributor("foo");
		thesaurus.setCoverage("foo");
		thesaurus.setCreated(new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31"));
		ThesaurusOrganization creator2 = new ThesaurusOrganization();
		creator2.setEmail("info@diffblue.com");
		creator2.setHomepage("foo");
		creator2.setIdentifier(1);
		creator2.setName("Acme");
		thesaurus.setCreator(creator2);
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
		ThesaurusType type2 = new ThesaurusType();
		type2.setIdentifier(1);
		type2.setLabel("label");
		thesaurus.setType(type2);
		thesaurus.setVersions(new HashSet<ThesaurusVersionHistory>());
		thesaurusVersionHistory.setThesaurus(thesaurus);
		thesaurusVersionHistory.setThisVersion(false);
		thesaurusVersionHistory.setUserId("root");
		thesaurusVersionHistory.setVersionNote("1.0");
		assertThat(thesaurusVersionHistory.getDate(), sameInstance(date3));
		assertThat(thesaurusVersionHistory.getIdentifier(), is("data"));
		assertThat(thesaurusVersionHistory.getStatus(), is(1));
		assertThat(thesaurusVersionHistory.getThesaurus(), sameInstance(thesaurus));
		assertThat(thesaurusVersionHistory.getThisVersion(), is(false));
		assertThat(thesaurusVersionHistory.getUserId(), is("root"));
		assertThat(thesaurusVersionHistory.getVersionNote(), is("1.0"));
	}
}
