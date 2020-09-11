package fr.mcc.ginco.extjs.view.pojo;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsSame.sameInstance;

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
		ArrayList<AlignmentView> alignments = new ArrayList<AlignmentView>();
		AlignmentView alignmentView = new AlignmentView();
		alignmentView.setAlignmentType(1);
		alignmentView.setAndRelation(false);
		alignmentView.setCreated("foo");
		ArrayList<ExternalThesaurusView> externalThesaurus =
			 new ArrayList<ExternalThesaurusView>();
		ExternalThesaurusView externalThesaurusView = new ExternalThesaurusView();
		externalThesaurusView.setExternalId("1234");
		externalThesaurusView.setExternalThesaurusType(1);
		externalThesaurusView.setIdentifier(1);
		externalThesaurus.add(externalThesaurusView);
		alignmentView.setExternalThesaurus(externalThesaurus);
		alignmentView.setIdentifier("data");
		alignmentView.setInternalThesaurusId("1234");
		alignmentView.setModified("foo");
		ArrayList<AlignmentConceptView> targetConcepts =
			 new ArrayList<AlignmentConceptView>();
		AlignmentConceptView alignmentConceptView = new AlignmentConceptView();
		alignmentConceptView.setExternalTargetConcept("hello");
		alignmentConceptView.setIdentifier(1);
		alignmentConceptView.setInternalTargetConcept("hello");
		targetConcepts.add(alignmentConceptView);
		alignmentView.setTargetConcepts(targetConcepts);
		ArrayList<AlignmentResourceView> targetResources =
			 new ArrayList<AlignmentResourceView>();
		AlignmentResourceView alignmentResourceView = new AlignmentResourceView();
		alignmentResourceView.setExternalTargetResource("foo");
		alignmentResourceView.setIdentifier(1);
		targetResources.add(alignmentResourceView);
		alignmentView.setTargetResources(targetResources);
		alignments.add(alignmentView);
		thesaurusConceptView.setAlignments(alignments);
		ArrayList<AssociativeRelationshipView> associatedConcepts =
			 new ArrayList<AssociativeRelationshipView>();
		AssociativeRelationshipView associativeRelationshipView =
			 new AssociativeRelationshipView();
		associativeRelationshipView.setIdentifier("data");
		associativeRelationshipView.setLabel("label");
		associativeRelationshipView.setRoleCode("DE");
		associatedConcepts.add(associativeRelationshipView);
		thesaurusConceptView.setAssociatedConcepts(associatedConcepts);
		ArrayList<HierarchicalRelationshipView> childConcepts =
			 new ArrayList<HierarchicalRelationshipView>();
		HierarchicalRelationshipView hierarchicalRelationshipView1 =
			 new HierarchicalRelationshipView();
		hierarchicalRelationshipView1.setIdentifier("data");
		hierarchicalRelationshipView1.setLabel("label");
		hierarchicalRelationshipView1.setRole(1);
		childConcepts.add(hierarchicalRelationshipView1);
		thesaurusConceptView.setChildConcepts(childConcepts);
		ArrayList<String> conceptsPath1 = new ArrayList<String>();
		conceptsPath1.add("/bin/bash");
		thesaurusConceptView.setConceptsPath(conceptsPath1);
		thesaurusConceptView.setCreated("hello");
		thesaurusConceptView.setIdentifier("data");
		thesaurusConceptView.setModified("hello");
		thesaurusConceptView.setNotation("DE");
		ArrayList<HierarchicalRelationshipView> parentConcepts =
			 new ArrayList<HierarchicalRelationshipView>();
		HierarchicalRelationshipView hierarchicalRelationshipView2 =
			 new HierarchicalRelationshipView();
		hierarchicalRelationshipView2.setIdentifier("data");
		hierarchicalRelationshipView2.setLabel("label");
		hierarchicalRelationshipView2.setRole(1);
		parentConcepts.add(hierarchicalRelationshipView2);
		thesaurusConceptView.setParentConcepts(parentConcepts);
		ArrayList<String> rootConcepts = new ArrayList<String>();
		rootConcepts.add("hello");
		thesaurusConceptView.setRootConcepts(rootConcepts);
		thesaurusConceptView.setStatus(1);
		ArrayList<ThesaurusTermView> terms = new ArrayList<ThesaurusTermView>();
		ThesaurusTermView thesaurusTermView = new ThesaurusTermView();
		thesaurusTermView.setConceptId("1234");
		ArrayList<String> conceptsPath2 = new ArrayList<String>();
		conceptsPath2.add("/bin/bash");
		thesaurusTermView.setConceptsPath(conceptsPath2);
		thesaurusTermView.setCreated("foo");
		thesaurusTermView.setHidden(false);
		thesaurusTermView.setIdentifier("data");
		thesaurusTermView.setLanguage("foo");
		thesaurusTermView.setLexicalValue("value");
		thesaurusTermView.setModified("foo");
		thesaurusTermView.setPrefered(false);
		thesaurusTermView.setRole("admin");
		thesaurusTermView.setSource("foo");
		thesaurusTermView.setStatus(1);
		thesaurusTermView.setThesaurusId("1234");
		thesaurusTermView.setTopistopterm(false);
		terms.add(thesaurusTermView);
		thesaurusConceptView.setTerms(terms);
		thesaurusConceptView.setThesaurusId("1234");
		thesaurusConceptView.setTopconcept(false);
		thesaurusConceptView.setTopistopterm(false);
		assertThat(thesaurusConceptView.getAlignments().size(), is(1));
		assertThat(thesaurusConceptView.getAlignments().get(0), sameInstance(alignmentView));
		assertThat(thesaurusConceptView.getAssociatedConcepts().size(), is(1));
		assertThat(thesaurusConceptView.getAssociatedConcepts().get(0), sameInstance(associativeRelationshipView));
		assertThat(thesaurusConceptView.getChildConcepts().size(), is(1));
		assertThat(thesaurusConceptView.getChildConcepts().get(0), sameInstance(hierarchicalRelationshipView1));
		assertThat(thesaurusConceptView.getConceptsPath(), hasSize(1));
		assertThat(thesaurusConceptView.getConceptsPath().get(0), is("/bin/bash"));
		assertThat(thesaurusConceptView.getCreated(), is("hello"));
		assertThat(thesaurusConceptView.getIdentifier(), is("data"));
		assertThat(thesaurusConceptView.getModified(), is("hello"));
		assertThat(thesaurusConceptView.getNotation(), is("DE"));
		assertThat(thesaurusConceptView.getParentConcepts().size(), is(1));
		assertThat(thesaurusConceptView.getParentConcepts().get(0), sameInstance(hierarchicalRelationshipView2));
		assertThat(thesaurusConceptView.getRootConcepts(), hasSize(1));
		assertThat(thesaurusConceptView.getRootConcepts().get(0), is("hello"));
		assertThat(thesaurusConceptView.getStatus(), is(1));
		assertThat(thesaurusConceptView.getTerms().size(), is(1));
		assertThat(thesaurusConceptView.getTerms().get(0), sameInstance(thesaurusTermView));
		assertThat(thesaurusConceptView.getThesaurusId(), is("1234"));
		assertThat(thesaurusConceptView.getTopconcept(), is(false));
		assertThat(thesaurusConceptView.getTopistopterm(), is(false));
	}
}
