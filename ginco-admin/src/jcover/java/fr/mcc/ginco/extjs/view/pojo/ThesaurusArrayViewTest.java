package fr.mcc.ginco.extjs.view.pojo;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsSame.sameInstance;

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
		ArrayList<ThesaurusArrayConceptView> concepts =
			 new ArrayList<ThesaurusArrayConceptView>();
		ThesaurusArrayConceptView thesaurusArrayConceptView =
			 new ThesaurusArrayConceptView();
		thesaurusArrayConceptView.setIdentifier("data");
		thesaurusArrayConceptView.setLabel("label");
		thesaurusArrayConceptView.setOrder(1);
		concepts.add(thesaurusArrayConceptView);
		thesaurusArrayView.setConcepts(concepts);
		thesaurusArrayView.setCreated("someone");
		thesaurusArrayView.setIdentifier("data");
		thesaurusArrayView.setLabel("label");
		thesaurusArrayView.setLanguage("foo");
		thesaurusArrayView.setModified("someone");
		thesaurusArrayView.setNodeLabelId(1);
		thesaurusArrayView.setOrder(false);
		thesaurusArrayView.setParentArrayId("1234");
		thesaurusArrayView.setParentArrayLabel("label");
		thesaurusArrayView.setSuperOrdinateId("1234");
		thesaurusArrayView.setSuperOrdinateLabel("label");
		thesaurusArrayView.setThesaurusId("1234");
		assertThat(thesaurusArrayView.getConcepts(), hasSize(1));
		assertThat(thesaurusArrayView.getConcepts().get(0), sameInstance(thesaurusArrayConceptView));
		assertThat(thesaurusArrayView.getCreated(), is("someone"));
		assertThat(thesaurusArrayView.getIdentifier(), is("data"));
		assertThat(thesaurusArrayView.getLabel(), is("label"));
		assertThat(thesaurusArrayView.getLanguage(), is("foo"));
		assertThat(thesaurusArrayView.getModified(), is("someone"));
		assertThat(thesaurusArrayView.getNodeLabelId(), is(1));
		assertThat(thesaurusArrayView.getOrder(), is(false));
		assertThat(thesaurusArrayView.getParentArrayId(), is("1234"));
		assertThat(thesaurusArrayView.getParentArrayLabel(), is("label"));
		assertThat(thesaurusArrayView.getSuperOrdinateId(), is("1234"));
		assertThat(thesaurusArrayView.getSuperOrdinateLabel(), is("label"));
		assertThat(thesaurusArrayView.getThesaurusId(), is("1234"));
	}
}
