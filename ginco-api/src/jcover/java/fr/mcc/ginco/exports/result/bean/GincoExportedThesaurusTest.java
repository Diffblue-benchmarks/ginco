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
		HashMap<String, JaxbList<Alignment>> alignments =
			 new HashMap<String, JaxbList<Alignment>>();
		JaxbList<Alignment> x739 = new JaxbList<Alignment>();
		alignments.put("foo", x739);
		gincoExportedThesaurus.setAlignments(alignments);
		HashMap<String, JaxbList<AssociativeRelationship>> associativeRelationship1 =
			 new HashMap<String, JaxbList<AssociativeRelationship>>();
		JaxbList<AssociativeRelationship> x774 =
			 new JaxbList<AssociativeRelationship>();
		associativeRelationship1.put("foo", x774);
		gincoExportedThesaurus.setAssociativeRelationship(associativeRelationship1);
		gincoExportedThesaurus.setComplexConcepts(new ArrayList<SplitNonPreferredTerm>());
		HashMap<String, JaxbList<NodeLabel>> conceptArrayLabels =
			 new HashMap<String, JaxbList<NodeLabel>>();
		JaxbList<NodeLabel> x839 = new JaxbList<NodeLabel>();
		conceptArrayLabels.put("foo", x839);
		gincoExportedThesaurus.setConceptArrayLabels(conceptArrayLabels);
		gincoExportedThesaurus.setConceptArrays(new ArrayList<ThesaurusArray>());
		HashMap<String, JaxbList<ThesaurusConceptGroupLabel>> conceptGroupLabels =
			 new HashMap<String, JaxbList<ThesaurusConceptGroupLabel>>();
		JaxbList<ThesaurusConceptGroupLabel> x939 =
			 new JaxbList<ThesaurusConceptGroupLabel>();
		conceptGroupLabels.put("foo", x939);
		gincoExportedThesaurus.setConceptGroupLabels(conceptGroupLabels);
		gincoExportedThesaurus.setConceptGroups(new ArrayList<ThesaurusConceptGroup>());
		HashMap<String, JaxbList<Note>> conceptNotes =
			 new HashMap<String, JaxbList<Note>>();
		JaxbList<Note> x1043 = new JaxbList<Note>();
		conceptNotes.put("foo", x1043);
		gincoExportedThesaurus.setConceptNotes(conceptNotes);
		HashMap<String, JaxbList<ConceptHierarchicalRelationship>> parentConceptRelationship =
			 new HashMap<String, JaxbList<ConceptHierarchicalRelationship>>();
		JaxbList<ConceptHierarchicalRelationship> x1074 =
			 new JaxbList<ConceptHierarchicalRelationship>();
		parentConceptRelationship.put("foo", x1074);
		gincoExportedThesaurus.setHierarchicalRelationship(parentConceptRelationship);
		HashMap<String, JaxbList<Note>> termNotes =
			 new HashMap<String, JaxbList<Note>>();
		JaxbList<Note> x1087 = new JaxbList<Note>();
		termNotes.put("foo", x1087);
		gincoExportedThesaurus.setTermNotes(termNotes);
		Thesaurus thesaurus6 = new Thesaurus();
		thesaurus6.setArchived(false);
		thesaurus6.setContributor("foo");
		thesaurus6.setCoverage("foo");
		thesaurus6.setCreated(new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31"));
		ThesaurusOrganization creator4 = new ThesaurusOrganization();
		creator4.setEmail("info@diffblue.com");
		creator4.setHomepage("foo");
		creator4.setIdentifier(1);
		creator4.setName("Acme");
		thesaurus6.setCreator(creator4);
		thesaurus6.setDate(new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31"));
		thesaurus6.setDefaultTopConcept(false);
		thesaurus6.setDescription("some text");
		thesaurus6.setFormat(new HashSet<ThesaurusFormat>());
		thesaurus6.setIdentifier("data");
		thesaurus6.setLang(new HashSet<Language>());
		thesaurus6.setPolyHierarchical(false);
		thesaurus6.setPublisher("foo");
		thesaurus6.setRelation("DE");
		thesaurus6.setRights("foo");
		thesaurus6.setSource("foo");
		thesaurus6.setSubject("foo");
		thesaurus6.setTitle("Mr");
		ThesaurusType type4 = new ThesaurusType();
		type4.setIdentifier(1);
		type4.setLabel("label");
		thesaurus6.setType(type4);
		thesaurus6.setVersions(new HashSet<ThesaurusVersionHistory>());
		gincoExportedThesaurus.setThesaurus(thesaurus6);
		gincoExportedThesaurus.setThesaurusVersions(new ArrayList<ThesaurusVersionHistory>());
		gincoExportedThesaurus.setConceptAttributeTypes(new ArrayList<CustomConceptAttributeType>());
		HashMap<String, JaxbList<CustomConceptAttribute>> conceptAttributes =
			 new HashMap<String, JaxbList<CustomConceptAttribute>>();
		JaxbList<CustomConceptAttribute> x1263 =
			 new JaxbList<CustomConceptAttribute>();
		conceptAttributes.put("foo", x1263);
		gincoExportedThesaurus.setConceptAttributes(conceptAttributes);
		gincoExportedThesaurus.setConcepts(new ArrayList<ThesaurusConcept>());
		gincoExportedThesaurus.setTermAttributeTypes(new ArrayList<CustomTermAttributeType>());
		HashMap<String, JaxbList<CustomTermAttribute>> termAttributes =
			 new HashMap<String, JaxbList<CustomTermAttribute>>();
		JaxbList<CustomTermAttribute> x1364 = new JaxbList<CustomTermAttribute>();
		termAttributes.put("foo", x1364);
		gincoExportedThesaurus.setTermAttributes(termAttributes);
		gincoExportedThesaurus.setTerms(new ArrayList<ThesaurusTerm>());
		assertThat(gincoExportedThesaurus.getAlignments().get("foo"), sameInstance(x739));
		assertThat(gincoExportedThesaurus.getAssociativeRelationship().get("foo"), sameInstance(x774));
		assertThat(gincoExportedThesaurus.getComplexConcepts(), empty());
		assertThat(gincoExportedThesaurus.getConceptArrayLabels().get("foo"), sameInstance(x839));
		assertThat(gincoExportedThesaurus.getConceptArrays(), empty());
		assertThat(gincoExportedThesaurus.getConceptGroupLabels().get("foo"), sameInstance(x939));
		assertThat(gincoExportedThesaurus.getConceptGroups(), empty());
		assertThat(gincoExportedThesaurus.getConceptNotes().get("foo"), sameInstance(x1043));
		assertThat(gincoExportedThesaurus.getHierarchicalRelationship().get("foo"), sameInstance(x1074));
		assertThat(gincoExportedThesaurus.getTermNotes().get("foo"), sameInstance(x1087));
		assertThat(gincoExportedThesaurus.getThesaurus(), sameInstance(thesaurus6));
		assertThat(gincoExportedThesaurus.getThesaurusVersions(), empty());
		assertThat(gincoExportedThesaurus.getConceptAttributeTypes(), empty());
		assertThat(gincoExportedThesaurus.getConceptAttributes().get("foo"), sameInstance(x1263));
		assertThat(gincoExportedThesaurus.getConcepts(), empty());
		assertThat(gincoExportedThesaurus.getTermAttributeTypes(), empty());
		assertThat(gincoExportedThesaurus.getTermAttributes().get("foo"), sameInstance(x1364));
		assertThat(gincoExportedThesaurus.getTerms(), empty());
	}
}
