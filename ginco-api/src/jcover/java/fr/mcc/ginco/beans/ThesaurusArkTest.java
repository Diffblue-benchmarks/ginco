package fr.mcc.ginco.beans;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsSame.sameInstance;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.jupiter.api.Test;

/**
 * Unit tests for fr.mcc.ginco.beans.ThesaurusArk
 *
 * @author Diffblue Cover
 */

class ThesaurusArkTest {

	@Test
	void factory() throws java.text.ParseException {
		ThesaurusArk thesaurusArk = new ThesaurusArk();
		Date created = new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31");
		thesaurusArk.setCreated(created);
		thesaurusArk.setEntity("entity");
		thesaurusArk.setIdentifier("data");
		assertThat(thesaurusArk.getCreated(), sameInstance(created));
		assertThat(thesaurusArk.getEntity(), is("entity"));
		assertThat(thesaurusArk.getIdentifier(), is("data"));
	}
}
