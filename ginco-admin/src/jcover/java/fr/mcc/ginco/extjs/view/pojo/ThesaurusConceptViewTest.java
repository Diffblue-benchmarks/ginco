package fr.mcc.ginco.extjs.view.pojo;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.empty;
import static org.hamcrest.core.Is.is;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

/**
 * Unit tests for fr.mcc.ginco.extjs.view.pojo.ThesaurusConceptView
 *
 * @author Diffblue Cover
 */

class ThesaurusConceptViewTest {

	@Test
	void factory() {
		ThesaurusConceptView thesaurusConceptView = new ThesaurusConceptView();
		thesaurusConceptView.setAlignments(new ArrayList<AlignmentView>());
		thesaurusConceptView.setAssociatedConcepts(new ArrayList<AssociativeRelationshipView>());
		thesaurusConceptView.setChildConcepts(new ArrayList<HierarchicalRelationshipView>());
		thesaurusConceptView.setConceptsPath(new ArrayList<String>());
		thesaurusConceptView.setCreated("hello");
		thesaurusConceptView.setIdentifier("data");
		thesaurusConceptView.setModified("hello");
		thesaurusConceptView.setNotation("DE");
		thesaurusConceptView.setParentConcepts(new ArrayList<HierarchicalRelationshipView>());
		thesaurusConceptView.setRootConcepts(new ArrayList<String>());
		thesaurusConceptView.setStatus(1);
		thesaurusConceptView.setTerms(new ArrayList<ThesaurusTermView>());
		thesaurusConceptView.setThesaurusId("1234");
		thesaurusConceptView.setTopconcept(false);
		thesaurusConceptView.setTopistopterm(false);
		assertThat(thesaurusConceptView.getAlignments(), empty());
		assertThat(thesaurusConceptView.getAssociatedConcepts(), empty());
		assertThat(thesaurusConceptView.getChildConcepts(), empty());
		assertThat(thesaurusConceptView.getConceptsPath(), empty());
		assertThat(thesaurusConceptView.getCreated(), is("hello"));
		assertThat(thesaurusConceptView.getIdentifier(), is("data"));
		assertThat(thesaurusConceptView.getModified(), is("hello"));
		assertThat(thesaurusConceptView.getNotation(), is("DE"));
		assertThat(thesaurusConceptView.getParentConcepts(), empty());
		assertThat(thesaurusConceptView.getRootConcepts(), empty());
		assertThat(thesaurusConceptView.getStatus(), is(1));
		assertThat(thesaurusConceptView.getTerms(), empty());
		assertThat(thesaurusConceptView.getThesaurusId(), is("1234"));
		assertThat(thesaurusConceptView.getTopconcept(), is(false));
		assertThat(thesaurusConceptView.getTopistopterm(), is(false));
	}
}
