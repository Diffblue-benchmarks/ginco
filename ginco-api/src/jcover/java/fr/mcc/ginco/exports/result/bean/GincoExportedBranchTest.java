package fr.mcc.ginco.exports.result.bean;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.empty;
import static org.hamcrest.core.IsSame.sameInstance;

import fr.mcc.ginco.beans.Alignment;
import fr.mcc.ginco.beans.AssociativeRelationship;
import fr.mcc.ginco.beans.ConceptHierarchicalRelationship;
import fr.mcc.ginco.beans.CustomConceptAttribute;
import fr.mcc.ginco.beans.CustomConceptAttributeType;
import fr.mcc.ginco.beans.CustomTermAttribute;
import fr.mcc.ginco.beans.CustomTermAttributeType;
import fr.mcc.ginco.beans.Note;
import fr.mcc.ginco.beans.Thesaurus;
import fr.mcc.ginco.beans.ThesaurusArray;
import fr.mcc.ginco.beans.ThesaurusConcept;
import fr.mcc.ginco.beans.ThesaurusTerm;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

import org.junit.jupiter.api.Test;

/**
 * Unit tests for fr.mcc.ginco.exports.result.bean.GincoExportedBranch
 *
 * @author Diffblue Cover
 */

class GincoExportedBranchTest {

	@Test
	void factory() throws java.text.ParseException {
		GincoExportedBranch gincoExportedBranch = new GincoExportedBranch();
		HashMap<String, JaxbList<Alignment>> alignments = new HashMap<String, JaxbList<Alignment>>();
		JaxbList<Alignment> x4 = new JaxbList<Alignment>();
		alignments.put("foo", x4);
		gincoExportedBranch.setAlignments(alignments);
		HashMap<String, JaxbList<Note>> conceptNotes = new HashMap<String, JaxbList<Note>>();
		JaxbList<Note> x39 = new JaxbList<Note>();
		conceptNotes.put("foo", x39);
		gincoExportedBranch.setConceptNotes(conceptNotes);
		HashMap<String, JaxbList<ConceptHierarchicalRelationship>> parentConceptRelationship = new HashMap<String, JaxbList<ConceptHierarchicalRelationship>>();
		JaxbList<ConceptHierarchicalRelationship> x70 = new JaxbList<ConceptHierarchicalRelationship>();
		parentConceptRelationship.put("foo", x70);
		gincoExportedBranch.setHierarchicalRelationship(parentConceptRelationship);
		ThesaurusConcept rootConcept = new ThesaurusConcept();
		rootConcept.setAssociativeRelationshipLeft(new HashSet<AssociativeRelationship>());
		rootConcept.setAssociativeRelationshipRight(new HashSet<AssociativeRelationship>());
		rootConcept.setConceptArrays(new HashSet<ThesaurusArray>());
		rootConcept.setCreated(new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31"));
		rootConcept.setIdentifier("hello");
		rootConcept.setModified(new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31"));
		rootConcept.setNotation("DE");
		rootConcept.setParentConcepts(new HashSet<ThesaurusConcept>());
		rootConcept.setRootConcepts(new HashSet<ThesaurusConcept>());
		rootConcept.setStatus(1);
		rootConcept.setThesaurus(new Thesaurus());
		rootConcept.setTopConcept(false);
		gincoExportedBranch.setRootConcept(rootConcept);
		HashMap<String, JaxbList<Note>> termNotes = new HashMap<String, JaxbList<Note>>();
		JaxbList<Note> x98 = new JaxbList<Note>();
		termNotes.put("foo", x98);
		gincoExportedBranch.setTermNotes(termNotes);
		gincoExportedBranch.setConceptAttributeTypes(new ArrayList<CustomConceptAttributeType>());
		HashMap<String, JaxbList<CustomConceptAttribute>> conceptAttributes = new HashMap<String, JaxbList<CustomConceptAttribute>>();
		JaxbList<CustomConceptAttribute> x136 = new JaxbList<CustomConceptAttribute>();
		conceptAttributes.put("foo", x136);
		gincoExportedBranch.setConceptAttributes(conceptAttributes);
		gincoExportedBranch.setConcepts(new ArrayList<ThesaurusConcept>());
		gincoExportedBranch.setTermAttributeTypes(new ArrayList<CustomTermAttributeType>());
		HashMap<String, JaxbList<CustomTermAttribute>> termAttributes = new HashMap<String, JaxbList<CustomTermAttribute>>();
		JaxbList<CustomTermAttribute> x177 = new JaxbList<CustomTermAttribute>();
		termAttributes.put("foo", x177);
		gincoExportedBranch.setTermAttributes(termAttributes);
		gincoExportedBranch.setTerms(new ArrayList<ThesaurusTerm>());
		assertThat(gincoExportedBranch.getAlignments().get("foo"), sameInstance(x4));
		assertThat(gincoExportedBranch.getConceptNotes().get("foo"), sameInstance(x39));
		assertThat(gincoExportedBranch.getHierarchicalRelationship().get("foo"), sameInstance(x70));
		assertThat(gincoExportedBranch.getRootConcept(), sameInstance(rootConcept));
		assertThat(gincoExportedBranch.getTermNotes().get("foo"), sameInstance(x98));
		assertThat(gincoExportedBranch.getConceptAttributeTypes(), empty());
		assertThat(gincoExportedBranch.getConceptAttributes().get("foo"), sameInstance(x136));
		assertThat(gincoExportedBranch.getConcepts(), empty());
		assertThat(gincoExportedBranch.getTermAttributeTypes(), empty());
		assertThat(gincoExportedBranch.getTermAttributes().get("foo"), sameInstance(x177));
		assertThat(gincoExportedBranch.getTerms(), empty());
	}
}
