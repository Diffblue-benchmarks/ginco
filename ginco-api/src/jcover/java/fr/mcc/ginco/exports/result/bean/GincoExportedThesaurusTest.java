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
import fr.mcc.ginco.beans.Language;
import fr.mcc.ginco.beans.NodeLabel;
import fr.mcc.ginco.beans.Note;
import fr.mcc.ginco.beans.SplitNonPreferredTerm;
import fr.mcc.ginco.beans.Thesaurus;
import fr.mcc.ginco.beans.ThesaurusArray;
import fr.mcc.ginco.beans.ThesaurusConcept;
import fr.mcc.ginco.beans.ThesaurusConceptGroup;
import fr.mcc.ginco.beans.ThesaurusConceptGroupLabel;
import fr.mcc.ginco.beans.ThesaurusFormat;
import fr.mcc.ginco.beans.ThesaurusOrganization;
import fr.mcc.ginco.beans.ThesaurusTerm;
import fr.mcc.ginco.beans.ThesaurusType;
import fr.mcc.ginco.beans.ThesaurusVersionHistory;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

import org.junit.jupiter.api.Test;

/**
 * Unit tests for fr.mcc.ginco.exports.result.bean.GincoExportedThesaurus
 *
 * @author Diffblue Cover
 */

class GincoExportedThesaurusTest {

	@Test
	void factory() throws java.text.ParseException {
		GincoExportedThesaurus gincoExportedThesaurus = new GincoExportedThesaurus();
		HashMap<String, JaxbList<Alignment>> alignments = new HashMap<String, JaxbList<Alignment>>();
		JaxbList<Alignment> x4 = new JaxbList<Alignment>();
		alignments.put("foo", x4);
		gincoExportedThesaurus.setAlignments(alignments);
		HashMap<String, JaxbList<AssociativeRelationship>> associativeRelationship1 = new HashMap<String, JaxbList<AssociativeRelationship>>();
		JaxbList<AssociativeRelationship> x39 = new JaxbList<AssociativeRelationship>();
		associativeRelationship1.put("foo", x39);
		gincoExportedThesaurus.setAssociativeRelationship(associativeRelationship1);
		gincoExportedThesaurus.setComplexConcepts(new ArrayList<SplitNonPreferredTerm>());
		HashMap<String, JaxbList<NodeLabel>> conceptArrayLabels = new HashMap<String, JaxbList<NodeLabel>>();
		JaxbList<NodeLabel> x69 = new JaxbList<NodeLabel>();
		conceptArrayLabels.put("foo", x69);
		gincoExportedThesaurus.setConceptArrayLabels(conceptArrayLabels);
		gincoExportedThesaurus.setConceptArrays(new ArrayList<ThesaurusArray>());
		HashMap<String, JaxbList<ThesaurusConceptGroupLabel>> conceptGroupLabels = new HashMap<String, JaxbList<ThesaurusConceptGroupLabel>>();
		JaxbList<ThesaurusConceptGroupLabel> x103 = new JaxbList<ThesaurusConceptGroupLabel>();
		conceptGroupLabels.put("foo", x103);
		gincoExportedThesaurus.setConceptGroupLabels(conceptGroupLabels);
		gincoExportedThesaurus.setConceptGroups(new ArrayList<ThesaurusConceptGroup>());
		HashMap<String, JaxbList<Note>> conceptNotes = new HashMap<String, JaxbList<Note>>();
		JaxbList<Note> x138 = new JaxbList<Note>();
		conceptNotes.put("foo", x138);
		gincoExportedThesaurus.setConceptNotes(conceptNotes);
		HashMap<String, JaxbList<ConceptHierarchicalRelationship>> parentConceptRelationship = new HashMap<String, JaxbList<ConceptHierarchicalRelationship>>();
		JaxbList<ConceptHierarchicalRelationship> x169 = new JaxbList<ConceptHierarchicalRelationship>();
		parentConceptRelationship.put("foo", x169);
		gincoExportedThesaurus.setHierarchicalRelationship(parentConceptRelationship);
		HashMap<String, JaxbList<Note>> termNotes = new HashMap<String, JaxbList<Note>>();
		JaxbList<Note> x182 = new JaxbList<Note>();
		termNotes.put("foo", x182);
		gincoExportedThesaurus.setTermNotes(termNotes);
		Thesaurus thesaurus4 = new Thesaurus();
		thesaurus4.setArchived(false);
		thesaurus4.setContributor("foo");
		thesaurus4.setCoverage("foo");
		thesaurus4.setCreated(new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31"));
		thesaurus4.setCreator(new ThesaurusOrganization());
		thesaurus4.setDate(new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31"));
		thesaurus4.setDefaultTopConcept(false);
		thesaurus4.setDescription("some text");
		thesaurus4.setFormat(new HashSet<ThesaurusFormat>());
		thesaurus4.setIdentifier("foo");
		thesaurus4.setLang(new HashSet<Language>());
		thesaurus4.setPolyHierarchical(false);
		thesaurus4.setPublisher("foo");
		thesaurus4.setRelation("DE");
		thesaurus4.setRights("foo");
		thesaurus4.setSource("foo");
		thesaurus4.setSubject("foo");
		thesaurus4.setTitle("Mr");
		thesaurus4.setType(new ThesaurusType());
		thesaurus4.setVersions(new HashSet<ThesaurusVersionHistory>());
		gincoExportedThesaurus.setThesaurus(thesaurus4);
		gincoExportedThesaurus.setThesaurusVersions(new ArrayList<ThesaurusVersionHistory>());
		gincoExportedThesaurus.setConceptAttributeTypes(new ArrayList<CustomConceptAttributeType>());
		HashMap<String, JaxbList<CustomConceptAttribute>> conceptAttributes = new HashMap<String, JaxbList<CustomConceptAttribute>>();
		JaxbList<CustomConceptAttribute> x286 = new JaxbList<CustomConceptAttribute>();
		conceptAttributes.put("foo", x286);
		gincoExportedThesaurus.setConceptAttributes(conceptAttributes);
		gincoExportedThesaurus.setConcepts(new ArrayList<ThesaurusConcept>());
		gincoExportedThesaurus.setTermAttributeTypes(new ArrayList<CustomTermAttributeType>());
		HashMap<String, JaxbList<CustomTermAttribute>> termAttributes = new HashMap<String, JaxbList<CustomTermAttribute>>();
		JaxbList<CustomTermAttribute> x327 = new JaxbList<CustomTermAttribute>();
		termAttributes.put("foo", x327);
		gincoExportedThesaurus.setTermAttributes(termAttributes);
		gincoExportedThesaurus.setTerms(new ArrayList<ThesaurusTerm>());
		assertThat(gincoExportedThesaurus.getAlignments().get("foo"), sameInstance(x4));
		assertThat(gincoExportedThesaurus.getAssociativeRelationship().get("foo"), sameInstance(x39));
		assertThat(gincoExportedThesaurus.getComplexConcepts(), empty());
		assertThat(gincoExportedThesaurus.getConceptArrayLabels().get("foo"), sameInstance(x69));
		assertThat(gincoExportedThesaurus.getConceptArrays(), empty());
		assertThat(gincoExportedThesaurus.getConceptGroupLabels().get("foo"), sameInstance(x103));
		assertThat(gincoExportedThesaurus.getConceptGroups(), empty());
		assertThat(gincoExportedThesaurus.getConceptNotes().get("foo"), sameInstance(x138));
		assertThat(gincoExportedThesaurus.getHierarchicalRelationship().get("foo"), sameInstance(x169));
		assertThat(gincoExportedThesaurus.getTermNotes().get("foo"), sameInstance(x182));
		assertThat(gincoExportedThesaurus.getThesaurus(), sameInstance(thesaurus4));
		assertThat(gincoExportedThesaurus.getThesaurusVersions(), empty());
		assertThat(gincoExportedThesaurus.getConceptAttributeTypes(), empty());
		assertThat(gincoExportedThesaurus.getConceptAttributes().get("foo"), sameInstance(x286));
		assertThat(gincoExportedThesaurus.getConcepts(), empty());
		assertThat(gincoExportedThesaurus.getTermAttributeTypes(), empty());
		assertThat(gincoExportedThesaurus.getTermAttributes().get("foo"), sameInstance(x327));
		assertThat(gincoExportedThesaurus.getTerms(), empty());
	}
}
