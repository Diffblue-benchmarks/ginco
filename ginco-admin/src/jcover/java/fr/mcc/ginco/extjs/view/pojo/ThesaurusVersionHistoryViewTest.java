package fr.mcc.ginco.extjs.view.pojo;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

import java.util.regex.Pattern;

import org.junit.jupiter.api.Test;

/**
 * Unit tests for fr.mcc.ginco.extjs.view.pojo.ThesaurusVersionHistoryView
 *
 * @author Diffblue Cover
 */

class ThesaurusVersionHistoryViewTest {

	@Test
	void factory() {
		ThesaurusVersionHistoryView thesaurusVersionHistoryView =
			 new ThesaurusVersionHistoryView();
		thesaurusVersionHistoryView.setDate("1999-12-31");
		thesaurusVersionHistoryView.setIdentifier("data");
		thesaurusVersionHistoryView.setStatus(1);
		thesaurusVersionHistoryView.setThesaurusId("1234");
		thesaurusVersionHistoryView.setThisVersion(false);
		thesaurusVersionHistoryView.setVersionNote("1.0");
		assertThat(Pattern.matches("\\d{2,4}-\\d{1,2}-\\d{1,2}", thesaurusVersionHistoryView.getDate()), is(true));
		assertThat(thesaurusVersionHistoryView.getIdentifier(), is("data"));
		assertThat(thesaurusVersionHistoryView.getStatus(), is(1));
		assertThat(thesaurusVersionHistoryView.getThesaurusId(), is("1234"));
		assertThat(thesaurusVersionHistoryView.getThisVersion(), is(false));
		assertThat(thesaurusVersionHistoryView.getVersionNote(), is("1.0"));
	}
}
