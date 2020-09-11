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
import fr.mcc.ginco.beans.Note;
import fr.mcc.ginco.beans.Thesaurus;
import fr.mcc.ginco.beans.ThesaurusArray;
import fr.mcc.ginco.beans.ThesaurusConcept;
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
 * Unit tests for fr.mcc.ginco.exports.result.bean.GincoExportedBranch
 *
 * @author Diffblue Cover
 */

class GincoExportedBranchTest {

	@Test
	void factory() throws java.text.ParseException {
		GincoExportedBranch gincoExportedBranch = new GincoExportedBranch();
		HashMap<String, JaxbList<Alignment>> alignments =
			 new HashMap<String, JaxbList<Alignment>>();
		JaxbList<Alignment> x407 = new JaxbList<Alignment>();
		alignments.put("foo", x407);
		gincoExportedBranch.setAlignments(alignments);
		HashMap<String, JaxbList<Note>> conceptNotes =
			 new HashMap<String, JaxbList<Note>>();
		JaxbList<Note> x442 = new JaxbList<Note>();
		conceptNotes.put("foo", x442);
		gincoExportedBranch.setConceptNotes(conceptNotes);
		HashMap<String, JaxbList<ConceptHierarchicalRelationship>> parentConceptRelationship =
			 new HashMap<String, JaxbList<ConceptHierarchicalRelationship>>();
		JaxbList<ConceptHierarchicalRelationship> x473 =
			 new JaxbList<ConceptHierarchicalRelationship>();
		parentConceptRelationship.put("foo", x473);
		gincoExportedBranch.setHierarchicalRelationship(parentConceptRelationship);
		ThesaurusConcept rootConcept = new ThesaurusConcept();
		rootConcept.setAssociativeRelationshipLeft(new HashSet<AssociativeRelationship>());
		rootConcept.setAssociativeRelationshipRight(new HashSet<AssociativeRelationship>());
		rootConcept.setConceptArrays(new HashSet<ThesaurusArray>());
		rootConcept.setCreated(new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31"));
		rootConcept.setIdentifier("data");
		rootConcept.setModified(new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31"));
		rootConcept.setNotation("DE");
		rootConcept.setParentConcepts(new HashSet<ThesaurusConcept>());
		rootConcept.setRootConcepts(new HashSet<ThesaurusConcept>());
		rootConcept.setStatus(1);
		Thesaurus thesaurus1 = new Thesaurus();
		thesaurus1.setArchived(false);
		thesaurus1.setContributor("foo");
		thesaurus1.setCoverage("foo");
		thesaurus1.setCreated(new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31"));
		ThesaurusOrganization creator1 = new ThesaurusOrganization();
		creator1.setEmail("info@diffblue.com");
		creator1.setHomepage("foo");
		creator1.setIdentifier(1);
		creator1.setName("Acme");
		thesaurus1.setCreator(creator1);
		thesaurus1.setDate(new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31"));
		thesaurus1.setDefaultTopConcept(false);
		thesaurus1.setDescription("some text");
		thesaurus1.setFormat(new HashSet<ThesaurusFormat>());
		thesaurus1.setIdentifier("data");
		thesaurus1.setLang(new HashSet<Language>());
		thesaurus1.setPolyHierarchical(false);
		thesaurus1.setPublisher("foo");
		thesaurus1.setRelation("DE");
		thesaurus1.setRights("foo");
		thesaurus1.setSource("foo");
		thesaurus1.setSubject("foo");
		thesaurus1.setTitle("Mr");
		ThesaurusType type1 = new ThesaurusType();
		type1.setIdentifier(1);
		type1.setLabel("label");
		thesaurus1.setType(type1);
		thesaurus1.setVersions(new HashSet<ThesaurusVersionHistory>());
		rootConcept.setThesaurus(thesaurus1);
		rootConcept.setTopConcept(false);
		gincoExportedBranch.setRootConcept(rootConcept);
		HashMap<String, JaxbList<Note>> termNotes =
			 new HashMap<String, JaxbList<Note>>();
		JaxbList<Note> x531 = new JaxbList<Note>();
		termNotes.put("foo", x531);
		gincoExportedBranch.setTermNotes(termNotes);
		gincoExportedBranch.setConceptAttributeTypes(new ArrayList<CustomConceptAttributeType>());
		HashMap<String, JaxbList<CustomConceptAttribute>> conceptAttributes =
			 new HashMap<String, JaxbList<CustomConceptAttribute>>();
		JaxbList<CustomConceptAttribute> x599 =
			 new JaxbList<CustomConceptAttribute>();
		conceptAttributes.put("foo", x599);
		gincoExportedBranch.setConceptAttributes(conceptAttributes);
		gincoExportedBranch.setConcepts(new ArrayList<ThesaurusConcept>());
		gincoExportedBranch.setTermAttributeTypes(new ArrayList<CustomTermAttributeType>());
		HashMap<String, JaxbList<CustomTermAttribute>> termAttributes =
			 new HashMap<String, JaxbList<CustomTermAttribute>>();
		JaxbList<CustomTermAttribute> x700 = new JaxbList<CustomTermAttribute>();
		termAttributes.put("foo", x700);
		gincoExportedBranch.setTermAttributes(termAttributes);
		gincoExportedBranch.setTerms(new ArrayList<ThesaurusTerm>());
		assertThat(gincoExportedBranch.getAlignments().get("foo"), sameInstance(x407));
		assertThat(gincoExportedBranch.getConceptNotes().get("foo"), sameInstance(x442));
		assertThat(gincoExportedBranch.getHierarchicalRelationship().get("foo"), sameInstance(x473));
		assertThat(gincoExportedBranch.getRootConcept(), sameInstance(rootConcept));
		assertThat(gincoExportedBranch.getTermNotes().get("foo"), sameInstance(x531));
		assertThat(gincoExportedBranch.getConceptAttributeTypes(), empty());
		assertThat(gincoExportedBranch.getConceptAttributes().get("foo"), sameInstance(x599));
		assertThat(gincoExportedBranch.getConcepts(), empty());
		assertThat(gincoExportedBranch.getTermAttributeTypes(), empty());
		assertThat(gincoExportedBranch.getTermAttributes().get("foo"), sameInstance(x700));
		assertThat(gincoExportedBranch.getTerms(), empty());
	}
}
