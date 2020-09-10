package fr.mcc.ginco.extjs.view.pojo;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.empty;
import static org.hamcrest.core.Is.is;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

/**
 * Unit tests for fr.mcc.ginco.extjs.view.pojo.ThesaurusView
 *
 * @author Diffblue Cover
 */

class ThesaurusViewTest {

	@Test
	void factory() {
		ThesaurusView thesaurusView = new ThesaurusView();
		thesaurusView.setArchived(false);
		thesaurusView.setCanBeDeleted(false);
		thesaurusView.setContributor("foo");
		thesaurusView.setCoverage("foo");
		thesaurusView.setCreated("foo");
		thesaurusView.setCreatorEmail("info@diffblue.com");
		thesaurusView.setCreatorHomepage("+");
		thesaurusView.setCreatorName("Acme");
		thesaurusView.setDate("1999-12-31");
		thesaurusView.setDefaultTopConcept(false);
		thesaurusView.setDescription("some text");
		thesaurusView.setFormats(new ArrayList<Integer>());
		thesaurusView.setId("1234");
		thesaurusView.setLanguages(new ArrayList<String>());
		thesaurusView.setPolyHierarchical(false);
		thesaurusView.setPublisher("foo");
		thesaurusView.setRelation("DE");
		thesaurusView.setRights("foo");
		thesaurusView.setSource("foo");
		thesaurusView.setSubject("foo");
		thesaurusView.setTitle("Mr");
		thesaurusView.setType(1);
		assertThat(thesaurusView.getArchived(), is(false));
		assertThat(thesaurusView.getCanBeDeleted(), is(false));
		assertThat(thesaurusView.getContributor(), is("foo"));
		assertThat(thesaurusView.getCoverage(), is("foo"));
		assertThat(thesaurusView.getCreated(), is("foo"));
		assertThat(thesaurusView.getCreatorEmail(), is("info@diffblue.com"));
		assertThat(thesaurusView.getCreatorHomepage(), is("+"));
		assertThat(thesaurusView.getCreatorName(), is("Acme"));
		assertThat(thesaurusView.getDate(), is("1999-12-31"));
		assertThat(thesaurusView.getDefaultTopConcept(), is(false));
		assertThat(thesaurusView.getDescription(), is("some text"));
		assertThat(thesaurusView.getFormats(), empty());
		assertThat(thesaurusView.getId(), is("1234"));
		assertThat(thesaurusView.getLanguages(), empty());
		assertThat(thesaurusView.getPolyHierarchical(), is(false));
		assertThat(thesaurusView.getPublisher(), is("foo"));
		assertThat(thesaurusView.getRelation(), is("DE"));
		assertThat(thesaurusView.getRights(), is("foo"));
		assertThat(thesaurusView.getSource(), is("foo"));
		assertThat(thesaurusView.getSubject(), is("foo"));
		assertThat(thesaurusView.getThesaurusId(), is("1234"));
		assertThat(thesaurusView.getTitle(), is("Mr"));
		assertThat(thesaurusView.getType(), is(1));
	}
}
