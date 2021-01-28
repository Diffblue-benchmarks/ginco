package fr.mcc.ginco.exports.result.bean;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.anEmptyMap;
import static org.hamcrest.Matchers.hasSize;
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
import fr.mcc.ginco.beans.ThesaurusArrayConcept;
import fr.mcc.ginco.beans.ThesaurusConcept;
import fr.mcc.ginco.beans.ThesaurusConceptGroup;
import fr.mcc.ginco.beans.ThesaurusConceptGroupLabel;
import fr.mcc.ginco.beans.ThesaurusConceptGroupType;
import fr.mcc.ginco.beans.ThesaurusFormat;
import fr.mcc.ginco.beans.ThesaurusOrganization;
import fr.mcc.ginco.beans.ThesaurusTerm;
import fr.mcc.ginco.beans.ThesaurusTermRole;
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
		gincoExportedThesaurus.setAlignments(new HashMap<String, JaxbList<Alignment>>());
		gincoExportedThesaurus.setAssociativeRelationship(new HashMap<String, JaxbList<AssociativeRelationship>>());
		ArrayList<SplitNonPreferredTerm> complexConcepts =
			 new ArrayList<SplitNonPreferredTerm>();
		SplitNonPreferredTerm splitNonPreferredTerm = new SplitNonPreferredTerm();
		splitNonPreferredTerm.setCreated(new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31"));
		splitNonPreferredTerm.setIdentifier("data");
		Language language1 = new Language();
		language1.setId("1234");
		language1.setPart1("foo");
		language1.setPrincipalLanguage(false);
		language1.setRefname("root");
		language1.setTopLanguage(false);
		splitNonPreferredTerm.setLanguage(language1);
		splitNonPreferredTerm.setLexicalValue("value");
		splitNonPreferredTerm.setModified(new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31"));
		splitNonPreferredTerm.setPreferredTerms(new HashSet<ThesaurusTerm>());
		splitNonPreferredTerm.setSource("foo");
		splitNonPreferredTerm.setStatus(1);
		Thesaurus thesaurus1 = new Thesaurus();
		thesaurus1.setArchived(false);
		thesaurus1.setContributor("foo");
		thesaurus1.setCoverage("foo");
		thesaurus1.setCreated(new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31"));
		thesaurus1.setCreator(new ThesaurusOrganization());
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
		thesaurus1.setType(new ThesaurusType());
		thesaurus1.setVersions(new HashSet<ThesaurusVersionHistory>());
		splitNonPreferredTerm.setThesaurus(thesaurus1);
		complexConcepts.add(splitNonPreferredTerm);
		gincoExportedThesaurus.setComplexConcepts(complexConcepts);
		gincoExportedThesaurus.setConceptArrayLabels(new HashMap<String, JaxbList<NodeLabel>>());
		ArrayList<ThesaurusArray> conceptArrays1 = new ArrayList<ThesaurusArray>();
		ThesaurusArray thesaurusArray = new ThesaurusArray();
		thesaurusArray.setConcepts(new HashSet<ThesaurusArrayConcept>());
		thesaurusArray.setIdentifier("data");
		thesaurusArray.setNotation("DE");
		thesaurusArray.setOrdered(false);
		ThesaurusArray parent1 = new ThesaurusArray();
		parent1.setConcepts(new HashSet<ThesaurusArrayConcept>());
		parent1.setIdentifier("data");
		parent1.setNotation("DE");
		parent1.setOrdered(false);
		parent1.setParent(new ThesaurusArray());
		parent1.setSuperOrdinateConcept(new ThesaurusConcept());
		parent1.setThesaurus(new Thesaurus());
		thesaurusArray.setParent(parent1);
		ThesaurusConcept superOrdinateConcept2 = new ThesaurusConcept();
		superOrdinateConcept2.setAssociativeRelationshipLeft(new HashSet<AssociativeRelationship>());
		superOrdinateConcept2.setAssociativeRelationshipRight(new HashSet<AssociativeRelationship>());
		superOrdinateConcept2.setConceptArrays(new HashSet<ThesaurusArray>());
		superOrdinateConcept2.setCreated(new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31"));
		superOrdinateConcept2.setIdentifier("data");
		superOrdinateConcept2.setModified(new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31"));
		superOrdinateConcept2.setNotation("DE");
		superOrdinateConcept2.setParentConcepts(new HashSet<ThesaurusConcept>());
		superOrdinateConcept2.setRootConcepts(new HashSet<ThesaurusConcept>());
		superOrdinateConcept2.setStatus(1);
		superOrdinateConcept2.setThesaurus(new Thesaurus());
		superOrdinateConcept2.setTopConcept(false);
		thesaurusArray.setSuperOrdinateConcept(superOrdinateConcept2);
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
		thesaurus4.setIdentifier("data");
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
		thesaurusArray.setThesaurus(thesaurus4);
		conceptArrays1.add(thesaurusArray);
		gincoExportedThesaurus.setConceptArrays(conceptArrays1);
		gincoExportedThesaurus.setConceptGroupLabels(new HashMap<String, JaxbList<ThesaurusConceptGroupLabel>>());
		ArrayList<ThesaurusConceptGroup> conceptGroups =
			 new ArrayList<ThesaurusConceptGroup>();
		ThesaurusConceptGroup thesaurusConceptGroup = new ThesaurusConceptGroup();
		ThesaurusConceptGroupType conceptGroupType1 =
			 new ThesaurusConceptGroupType();
		conceptGroupType1.setCode("DE");
		conceptGroupType1.setLabel("label");
		conceptGroupType1.setSkosLabel("label");
		thesaurusConceptGroup.setConceptGroupType(conceptGroupType1);
		thesaurusConceptGroup.setConcepts(new HashSet<ThesaurusConcept>());
		thesaurusConceptGroup.setIdentifier("data");
		thesaurusConceptGroup.setIsDynamic(false);
		thesaurusConceptGroup.setNotation("DE");
		ThesaurusConceptGroup parent3 = new ThesaurusConceptGroup();
		parent3.setConceptGroupType(new ThesaurusConceptGroupType());
		parent3.setConcepts(new HashSet<ThesaurusConcept>());
		parent3.setIdentifier("data");
		parent3.setIsDynamic(false);
		parent3.setNotation("DE");
		parent3.setParent(new ThesaurusConceptGroup());
		parent3.setParentConcept(new ThesaurusConcept());
		parent3.setThesaurus(new Thesaurus());
		thesaurusConceptGroup.setParent(parent3);
		ThesaurusConcept parentConcept2 = new ThesaurusConcept();
		parentConcept2.setAssociativeRelationshipLeft(new HashSet<AssociativeRelationship>());
		parentConcept2.setAssociativeRelationshipRight(new HashSet<AssociativeRelationship>());
		parentConcept2.setConceptArrays(new HashSet<ThesaurusArray>());
		parentConcept2.setCreated(new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31"));
		parentConcept2.setIdentifier("data");
		parentConcept2.setModified(new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31"));
		parentConcept2.setNotation("DE");
		parentConcept2.setParentConcepts(new HashSet<ThesaurusConcept>());
		parentConcept2.setRootConcepts(new HashSet<ThesaurusConcept>());
		parentConcept2.setStatus(1);
		parentConcept2.setThesaurus(new Thesaurus());
		parentConcept2.setTopConcept(false);
		thesaurusConceptGroup.setParentConcept(parentConcept2);
		Thesaurus thesaurus7 = new Thesaurus();
		thesaurus7.setArchived(false);
		thesaurus7.setContributor("foo");
		thesaurus7.setCoverage("foo");
		thesaurus7.setCreated(new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31"));
		thesaurus7.setCreator(new ThesaurusOrganization());
		thesaurus7.setDate(new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31"));
		thesaurus7.setDefaultTopConcept(false);
		thesaurus7.setDescription("some text");
		thesaurus7.setFormat(new HashSet<ThesaurusFormat>());
		thesaurus7.setIdentifier("data");
		thesaurus7.setLang(new HashSet<Language>());
		thesaurus7.setPolyHierarchical(false);
		thesaurus7.setPublisher("foo");
		thesaurus7.setRelation("DE");
		thesaurus7.setRights("foo");
		thesaurus7.setSource("foo");
		thesaurus7.setSubject("foo");
		thesaurus7.setTitle("Mr");
		thesaurus7.setType(new ThesaurusType());
		thesaurus7.setVersions(new HashSet<ThesaurusVersionHistory>());
		thesaurusConceptGroup.setThesaurus(thesaurus7);
		conceptGroups.add(thesaurusConceptGroup);
		gincoExportedThesaurus.setConceptGroups(conceptGroups);
		gincoExportedThesaurus.setConceptNotes(new HashMap<String, JaxbList<Note>>());
		gincoExportedThesaurus.setHierarchicalRelationship(new HashMap<String, JaxbList<ConceptHierarchicalRelationship>>());
		gincoExportedThesaurus.setTermNotes(new HashMap<String, JaxbList<Note>>());
		Thesaurus thesaurus8 = new Thesaurus();
		thesaurus8.setArchived(false);
		thesaurus8.setContributor("foo");
		thesaurus8.setCoverage("foo");
		thesaurus8.setCreated(new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31"));
		ThesaurusOrganization creator4 = new ThesaurusOrganization();
		creator4.setEmail("info@diffblue.com");
		creator4.setHomepage("foo");
		creator4.setIdentifier(1);
		creator4.setName("Acme");
		thesaurus8.setCreator(creator4);
		thesaurus8.setDate(new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31"));
		thesaurus8.setDefaultTopConcept(false);
		thesaurus8.setDescription("some text");
		thesaurus8.setFormat(new HashSet<ThesaurusFormat>());
		thesaurus8.setIdentifier("data");
		thesaurus8.setLang(new HashSet<Language>());
		thesaurus8.setPolyHierarchical(false);
		thesaurus8.setPublisher("foo");
		thesaurus8.setRelation("DE");
		thesaurus8.setRights("foo");
		thesaurus8.setSource("foo");
		thesaurus8.setSubject("foo");
		thesaurus8.setTitle("Mr");
		ThesaurusType type4 = new ThesaurusType();
		type4.setIdentifier(1);
		type4.setLabel("label");
		thesaurus8.setType(type4);
		thesaurus8.setVersions(new HashSet<ThesaurusVersionHistory>());
		gincoExportedThesaurus.setThesaurus(thesaurus8);
		ArrayList<ThesaurusVersionHistory> versions5 =
			 new ArrayList<ThesaurusVersionHistory>();
		ThesaurusVersionHistory thesaurusVersionHistory =
			 new ThesaurusVersionHistory();
		thesaurusVersionHistory.setDate(new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31"));
		thesaurusVersionHistory.setIdentifier("data");
		thesaurusVersionHistory.setStatus(1);
		Thesaurus thesaurus9 = new Thesaurus();
		thesaurus9.setArchived(false);
		thesaurus9.setContributor("foo");
		thesaurus9.setCoverage("foo");
		thesaurus9.setCreated(new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31"));
		thesaurus9.setCreator(new ThesaurusOrganization());
		thesaurus9.setDate(new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31"));
		thesaurus9.setDefaultTopConcept(false);
		thesaurus9.setDescription("some text");
		thesaurus9.setFormat(new HashSet<ThesaurusFormat>());
		thesaurus9.setIdentifier("data");
		thesaurus9.setLang(new HashSet<Language>());
		thesaurus9.setPolyHierarchical(false);
		thesaurus9.setPublisher("foo");
		thesaurus9.setRelation("DE");
		thesaurus9.setRights("foo");
		thesaurus9.setSource("foo");
		thesaurus9.setSubject("foo");
		thesaurus9.setTitle("Mr");
		thesaurus9.setType(new ThesaurusType());
		thesaurus9.setVersions(new HashSet<ThesaurusVersionHistory>());
		thesaurusVersionHistory.setThesaurus(thesaurus9);
		thesaurusVersionHistory.setThisVersion(false);
		thesaurusVersionHistory.setUserId("root");
		thesaurusVersionHistory.setVersionNote("1.0");
		versions5.add(thesaurusVersionHistory);
		gincoExportedThesaurus.setThesaurusVersions(versions5);
		ArrayList<CustomConceptAttributeType> conceptAttributeTypes =
			 new ArrayList<CustomConceptAttributeType>();
		CustomConceptAttributeType customConceptAttributeType =
			 new CustomConceptAttributeType();
		customConceptAttributeType.setExportable(false);
		customConceptAttributeType.setCode("DE");
		customConceptAttributeType.setIdentifier(1);
		Thesaurus thesaurus10 = new Thesaurus();
		thesaurus10.setArchived(false);
		thesaurus10.setContributor("foo");
		thesaurus10.setCoverage("foo");
		thesaurus10.setCreated(new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31"));
		thesaurus10.setCreator(new ThesaurusOrganization());
		thesaurus10.setDate(new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31"));
		thesaurus10.setDefaultTopConcept(false);
		thesaurus10.setDescription("some text");
		thesaurus10.setFormat(new HashSet<ThesaurusFormat>());
		thesaurus10.setIdentifier("data");
		thesaurus10.setLang(new HashSet<Language>());
		thesaurus10.setPolyHierarchical(false);
		thesaurus10.setPublisher("foo");
		thesaurus10.setRelation("DE");
		thesaurus10.setRights("foo");
		thesaurus10.setSource("foo");
		thesaurus10.setSubject("foo");
		thesaurus10.setTitle("Mr");
		thesaurus10.setType(new ThesaurusType());
		thesaurus10.setVersions(new HashSet<ThesaurusVersionHistory>());
		customConceptAttributeType.setThesaurus(thesaurus10);
		customConceptAttributeType.setValue("value");
		conceptAttributeTypes.add(customConceptAttributeType);
		gincoExportedThesaurus.setConceptAttributeTypes(conceptAttributeTypes);
		gincoExportedThesaurus.setConceptAttributes(new HashMap<String, JaxbList<CustomConceptAttribute>>());
		ArrayList<ThesaurusConcept> concepts5 = new ArrayList<ThesaurusConcept>();
		ThesaurusConcept thesaurusConcept = new ThesaurusConcept();
		thesaurusConcept.setAssociativeRelationshipLeft(new HashSet<AssociativeRelationship>());
		thesaurusConcept.setAssociativeRelationshipRight(new HashSet<AssociativeRelationship>());
		thesaurusConcept.setConceptArrays(new HashSet<ThesaurusArray>());
		thesaurusConcept.setCreated(new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31"));
		thesaurusConcept.setIdentifier("data");
		thesaurusConcept.setModified(new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31"));
		thesaurusConcept.setNotation("DE");
		thesaurusConcept.setParentConcepts(new HashSet<ThesaurusConcept>());
		thesaurusConcept.setRootConcepts(new HashSet<ThesaurusConcept>());
		thesaurusConcept.setStatus(1);
		Thesaurus thesaurus11 = new Thesaurus();
		thesaurus11.setArchived(false);
		thesaurus11.setContributor("foo");
		thesaurus11.setCoverage("foo");
		thesaurus11.setCreated(new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31"));
		thesaurus11.setCreator(new ThesaurusOrganization());
		thesaurus11.setDate(new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31"));
		thesaurus11.setDefaultTopConcept(false);
		thesaurus11.setDescription("some text");
		thesaurus11.setFormat(new HashSet<ThesaurusFormat>());
		thesaurus11.setIdentifier("data");
		thesaurus11.setLang(new HashSet<Language>());
		thesaurus11.setPolyHierarchical(false);
		thesaurus11.setPublisher("foo");
		thesaurus11.setRelation("DE");
		thesaurus11.setRights("foo");
		thesaurus11.setSource("foo");
		thesaurus11.setSubject("foo");
		thesaurus11.setTitle("Mr");
		thesaurus11.setType(new ThesaurusType());
		thesaurus11.setVersions(new HashSet<ThesaurusVersionHistory>());
		thesaurusConcept.setThesaurus(thesaurus11);
		thesaurusConcept.setTopConcept(false);
		concepts5.add(thesaurusConcept);
		gincoExportedThesaurus.setConcepts(concepts5);
		ArrayList<CustomTermAttributeType> termAttributeTypes =
			 new ArrayList<CustomTermAttributeType>();
		CustomTermAttributeType customTermAttributeType =
			 new CustomTermAttributeType();
		customTermAttributeType.setCode("DE");
		customTermAttributeType.setIdentifier(1);
		Thesaurus thesaurus12 = new Thesaurus();
		thesaurus12.setArchived(false);
		thesaurus12.setContributor("foo");
		thesaurus12.setCoverage("foo");
		thesaurus12.setCreated(new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31"));
		thesaurus12.setCreator(new ThesaurusOrganization());
		thesaurus12.setDate(new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31"));
		thesaurus12.setDefaultTopConcept(false);
		thesaurus12.setDescription("some text");
		thesaurus12.setFormat(new HashSet<ThesaurusFormat>());
		thesaurus12.setIdentifier("data");
		thesaurus12.setLang(new HashSet<Language>());
		thesaurus12.setPolyHierarchical(false);
		thesaurus12.setPublisher("foo");
		thesaurus12.setRelation("DE");
		thesaurus12.setRights("foo");
		thesaurus12.setSource("foo");
		thesaurus12.setSubject("foo");
		thesaurus12.setTitle("Mr");
		thesaurus12.setType(new ThesaurusType());
		thesaurus12.setVersions(new HashSet<ThesaurusVersionHistory>());
		customTermAttributeType.setThesaurus(thesaurus12);
		customTermAttributeType.setValue("value");
		termAttributeTypes.add(customTermAttributeType);
		gincoExportedThesaurus.setTermAttributeTypes(termAttributeTypes);
		gincoExportedThesaurus.setTermAttributes(new HashMap<String, JaxbList<CustomTermAttribute>>());
		ArrayList<ThesaurusTerm> terms = new ArrayList<ThesaurusTerm>();
		ThesaurusTerm thesaurusTerm = new ThesaurusTerm();
		ThesaurusConcept concept = new ThesaurusConcept();
		concept.setAssociativeRelationshipLeft(new HashSet<AssociativeRelationship>());
		concept.setAssociativeRelationshipRight(new HashSet<AssociativeRelationship>());
		concept.setConceptArrays(new HashSet<ThesaurusArray>());
		concept.setCreated(new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31"));
		concept.setIdentifier("data");
		concept.setModified(new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31"));
		concept.setNotation("DE");
		concept.setParentConcepts(new HashSet<ThesaurusConcept>());
		concept.setRootConcepts(new HashSet<ThesaurusConcept>());
		concept.setStatus(1);
		concept.setThesaurus(new Thesaurus());
		concept.setTopConcept(false);
		thesaurusTerm.setConcept(concept);
		thesaurusTerm.setCreated(new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31"));
		thesaurusTerm.setHidden(false);
		thesaurusTerm.setIdentifier("data");
		Language language2 = new Language();
		language2.setId("1234");
		language2.setPart1("foo");
		language2.setPrincipalLanguage(false);
		language2.setRefname("root");
		language2.setTopLanguage(false);
		thesaurusTerm.setLanguage(language2);
		thesaurusTerm.setLexicalValue("value");
		thesaurusTerm.setModified(new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31"));
		thesaurusTerm.setPrefered(false);
		ThesaurusTermRole role = new ThesaurusTermRole();
		role.setCode("DE");
		role.setDefaultRole(false);
		role.setLabel("label");
		thesaurusTerm.setRole(role);
		thesaurusTerm.setSource("foo");
		thesaurusTerm.setStatus(1);
		Thesaurus thesaurus14 = new Thesaurus();
		thesaurus14.setArchived(false);
		thesaurus14.setContributor("foo");
		thesaurus14.setCoverage("foo");
		thesaurus14.setCreated(new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31"));
		thesaurus14.setCreator(new ThesaurusOrganization());
		thesaurus14.setDate(new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31"));
		thesaurus14.setDefaultTopConcept(false);
		thesaurus14.setDescription("some text");
		thesaurus14.setFormat(new HashSet<ThesaurusFormat>());
		thesaurus14.setIdentifier("data");
		thesaurus14.setLang(new HashSet<Language>());
		thesaurus14.setPolyHierarchical(false);
		thesaurus14.setPublisher("foo");
		thesaurus14.setRelation("DE");
		thesaurus14.setRights("foo");
		thesaurus14.setSource("foo");
		thesaurus14.setSubject("foo");
		thesaurus14.setTitle("Mr");
		thesaurus14.setType(new ThesaurusType());
		thesaurus14.setVersions(new HashSet<ThesaurusVersionHistory>());
		thesaurusTerm.setThesaurus(thesaurus14);
		terms.add(thesaurusTerm);
		gincoExportedThesaurus.setTerms(terms);
		assertThat(gincoExportedThesaurus.getAlignments(), anEmptyMap());
		assertThat(gincoExportedThesaurus.getAssociativeRelationship(), anEmptyMap());
		assertThat(gincoExportedThesaurus.getComplexConcepts(), hasSize(1));
		assertThat(gincoExportedThesaurus.getComplexConcepts().get(0), sameInstance(splitNonPreferredTerm));
		assertThat(gincoExportedThesaurus.getConceptArrayLabels(), anEmptyMap());
		assertThat(gincoExportedThesaurus.getConceptArrays(), hasSize(1));
		assertThat(gincoExportedThesaurus.getConceptArrays().get(0), sameInstance(thesaurusArray));
		assertThat(gincoExportedThesaurus.getConceptGroupLabels(), anEmptyMap());
		assertThat(gincoExportedThesaurus.getConceptGroups(), hasSize(1));
		assertThat(gincoExportedThesaurus.getConceptGroups().get(0), sameInstance(thesaurusConceptGroup));
		assertThat(gincoExportedThesaurus.getConceptNotes(), anEmptyMap());
		assertThat(gincoExportedThesaurus.getHierarchicalRelationship(), anEmptyMap());
		assertThat(gincoExportedThesaurus.getTermNotes(), anEmptyMap());
		assertThat(gincoExportedThesaurus.getThesaurus(), sameInstance(thesaurus8));
		assertThat(gincoExportedThesaurus.getThesaurusVersions(), hasSize(1));
		assertThat(gincoExportedThesaurus.getThesaurusVersions().get(0), sameInstance(thesaurusVersionHistory));
		assertThat(gincoExportedThesaurus.getConceptAttributeTypes(), hasSize(1));
		assertThat(gincoExportedThesaurus.getConceptAttributeTypes().get(0), sameInstance(customConceptAttributeType));
		assertThat(gincoExportedThesaurus.getConceptAttributes(), anEmptyMap());
		assertThat(gincoExportedThesaurus.getConcepts(), hasSize(1));
		assertThat(gincoExportedThesaurus.getConcepts().get(0), sameInstance(thesaurusConcept));
		assertThat(gincoExportedThesaurus.getTermAttributeTypes(), hasSize(1));
		assertThat(gincoExportedThesaurus.getTermAttributeTypes().get(0), sameInstance(customTermAttributeType));
		assertThat(gincoExportedThesaurus.getTermAttributes(), anEmptyMap());
		assertThat(gincoExportedThesaurus.getTerms(), hasSize(1));
		assertThat(gincoExportedThesaurus.getTerms().get(0), sameInstance(thesaurusTerm));
	}
}
