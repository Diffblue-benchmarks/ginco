package fr.mcc.ginco.extjs.view.pojo;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.empty;
import static org.hamcrest.core.Is.is;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

/**
 * Unit tests for fr.mcc.ginco.extjs.view.pojo.ThesaurusArrayView
 *
 * @author Diffblue Cover
 */

class ThesaurusArrayViewTest {

	@Test
	void factory() {
		ThesaurusArrayView thesaurusArrayView = new ThesaurusArrayView();
		thesaurusArrayView.setConcepts(new ArrayList<ThesaurusArrayConceptView>());
		thesaurusArrayView.setCreated("foo");
		thesaurusArrayView.setIdentifier("foo");
		thesaurusArrayView.setLabel("label");
		thesaurusArrayView.setLanguage("foo");
		thesaurusArrayView.setModified("foo");
		thesaurusArrayView.setNodeLabelId(1);
		thesaurusArrayView.setOrder(false);
		thesaurusArrayView.setParentArrayId("1234");
		thesaurusArrayView.setParentArrayLabel("label");
		thesaurusArrayView.setSuperOrdinateId("1234");
		thesaurusArrayView.setSuperOrdinateLabel("label");
		thesaurusArrayView.setThesaurusId("1234");
		assertThat(thesaurusArrayView.getConcepts(), empty());
		assertThat(thesaurusArrayView.getCreated(), is("foo"));
		assertThat(thesaurusArrayView.getIdentifier(), is("foo"));
		assertThat(thesaurusArrayView.getLabel(), is("label"));
		assertThat(thesaurusArrayView.getLanguage(), is("foo"));
		assertThat(thesaurusArrayView.getModified(), is("foo"));
		assertThat(thesaurusArrayView.getNodeLabelId(), is(1));
		assertThat(thesaurusArrayView.getOrder(), is(false));
		assertThat(thesaurusArrayView.getParentArrayId(), is("1234"));
		assertThat(thesaurusArrayView.getParentArrayLabel(), is("label"));
		assertThat(thesaurusArrayView.getSuperOrdinateId(), is("1234"));
		assertThat(thesaurusArrayView.getSuperOrdinateLabel(), is("label"));
		assertThat(thesaurusArrayView.getThesaurusId(), is("1234"));
	}
}
