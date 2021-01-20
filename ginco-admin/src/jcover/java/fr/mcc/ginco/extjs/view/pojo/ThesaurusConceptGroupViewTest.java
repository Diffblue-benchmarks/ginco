package fr.mcc.ginco.extjs.view.pojo;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.hamcrest.core.Is.is;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

/**
 * Unit tests for fr.mcc.ginco.extjs.view.pojo.ThesaurusConceptGroupView
 *
 * @author Diffblue Cover
 */

class ThesaurusConceptGroupViewTest {

	@Test
	void factory() {
		ThesaurusConceptGroupView thesaurusConceptGroupView =
			 new ThesaurusConceptGroupView();
		ArrayList<String> concepts = new ArrayList<String>();
		concepts.add("hello");
		thesaurusConceptGroupView.setConcepts(concepts);
		thesaurusConceptGroupView.setCreated("someone");
		thesaurusConceptGroupView.setGroupConceptLabelId(1);
		thesaurusConceptGroupView.setIdentifier("data");
		thesaurusConceptGroupView.setIsDynamic(false);
		thesaurusConceptGroupView.setLabel("label");
		thesaurusConceptGroupView.setLanguage("hello");
		thesaurusConceptGroupView.setModified("someone");
		thesaurusConceptGroupView.setNotation("DE");
		thesaurusConceptGroupView.setParentConceptId("1234");
		thesaurusConceptGroupView.setParentConceptLabel("label");
		thesaurusConceptGroupView.setParentGroupId("1234");
		thesaurusConceptGroupView.setParentGroupLabel("label");
		thesaurusConceptGroupView.setThesaurusId("1234");
		thesaurusConceptGroupView.setType("text/plain");
		assertThat(thesaurusConceptGroupView.getConcepts(), hasSize(1));
		assertThat(thesaurusConceptGroupView.getConcepts().get(0), is("hello"));
		assertThat(thesaurusConceptGroupView.getCreated(), is("someone"));
		assertThat(thesaurusConceptGroupView.getGroupConceptLabelId(), is(1));
		assertThat(thesaurusConceptGroupView.getIdentifier(), is("data"));
		assertThat(thesaurusConceptGroupView.getIsDynamic(), is(false));
		assertThat(thesaurusConceptGroupView.getLabel(), is("label"));
		assertThat(thesaurusConceptGroupView.getLanguage(), is("hello"));
		assertThat(thesaurusConceptGroupView.getModified(), is("someone"));
		assertThat(thesaurusConceptGroupView.getNotation(), is("DE"));
		assertThat(thesaurusConceptGroupView.getParentConceptId(), is("1234"));
		assertThat(thesaurusConceptGroupView.getParentConceptLabel(), is("label"));
		assertThat(thesaurusConceptGroupView.getParentGroupId(), is("1234"));
		assertThat(thesaurusConceptGroupView.getParentGroupLabel(), is("label"));
		assertThat(thesaurusConceptGroupView.getThesaurusId(), is("1234"));
		assertThat(thesaurusConceptGroupView.getType(), is("text/plain"));
	}
}
