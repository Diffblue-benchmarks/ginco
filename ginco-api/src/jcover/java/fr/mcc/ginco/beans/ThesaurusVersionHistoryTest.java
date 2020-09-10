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
	void factory() throws java.text.ParseException {
		ThesaurusVersionHistory thesaurusVersionHistory = new ThesaurusVersionHistory();
		Date date3 = new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31");
		thesaurusVersionHistory.setDate(date3);
		thesaurusVersionHistory.setIdentifier("1.0");
		thesaurusVersionHistory.setStatus(1);
		Thesaurus thesaurus = new Thesaurus();
		thesaurus.setArchived(false);
		thesaurus.setContributor("foo");
		thesaurus.setCoverage("foo");
		thesaurus.setCreated(new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31"));
		thesaurus.setCreator(new ThesaurusOrganization());
		thesaurus.setDate(new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31"));
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
		thesaurus.setType(new ThesaurusType());
		thesaurus.setVersions(new HashSet<ThesaurusVersionHistory>());
		thesaurusVersionHistory.setThesaurus(thesaurus);
		thesaurusVersionHistory.setThisVersion(false);
		thesaurusVersionHistory.setUserId("root");
		thesaurusVersionHistory.setVersionNote("1.0");
		assertThat(thesaurusVersionHistory.getDate(), sameInstance(date3));
		assertThat(thesaurusVersionHistory.getIdentifier(), is("1.0"));
		assertThat(thesaurusVersionHistory.getStatus(), is(1));
		assertThat(thesaurusVersionHistory.getThesaurus(), sameInstance(thesaurus));
		assertThat(thesaurusVersionHistory.getThisVersion(), is(false));
		assertThat(thesaurusVersionHistory.getUserId(), is("root"));
		assertThat(thesaurusVersionHistory.getVersionNote(), is("1.0"));
	}
}
