package fr.mcc.ginco.exports.result.bean;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
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
import fr.mcc.ginco.beans.ThesaurusTermRole;
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
		JaxbList<Alignment> jaxbList1 = new JaxbList<Alignment>();
		alignments.put("foo", jaxbList1);
		gincoExportedBranch.setAlignments(alignments);
		HashMap<String, JaxbList<Note>> conceptNotes =
			 new HashMap<String, JaxbList<Note>>();
		JaxbList<Note> jaxbList3 = new JaxbList<Note>();
		conceptNotes.put("foo", jaxbList3);
		gincoExportedBranch.setConceptNotes(conceptNotes);
		HashMap<String, JaxbList<ConceptHierarchicalRelationship>> parentConceptRelationship =
			 new HashMap<String, JaxbList<ConceptHierarchicalRelationship>>();
		JaxbList<ConceptHierarchicalRelationship> jaxbList5 =
			 new JaxbList<ConceptHierarchicalRelationship>();
		parentConceptRelationship.put("foo", jaxbList5);
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
		JaxbList<Note> jaxbList7 = new JaxbList<Note>();
		termNotes.put("foo", jaxbList7);
		gincoExportedBranch.setTermNotes(termNotes);
		ArrayList<CustomConceptAttributeType> conceptAttributeTypes =
			 new ArrayList<CustomConceptAttributeType>();
		CustomConceptAttributeType customConceptAttributeType =
			 new CustomConceptAttributeType();
		customConceptAttributeType.setExportable(false);
		customConceptAttributeType.setCode("DE");
		customConceptAttributeType.setIdentifier(1);
		Thesaurus thesaurus2 = new Thesaurus();
		thesaurus2.setArchived(false);
		thesaurus2.setContributor("foo");
		thesaurus2.setCoverage("foo");
		thesaurus2.setCreated(new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31"));
		ThesaurusOrganization creator2 = new ThesaurusOrganization();
		creator2.setEmail("info@diffblue.com");
		creator2.setHomepage("foo");
		creator2.setIdentifier(1);
		creator2.setName("Acme");
		thesaurus2.setCreator(creator2);
		thesaurus2.setDate(new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31"));
		thesaurus2.setDefaultTopConcept(false);
		thesaurus2.setDescription("some text");
		thesaurus2.setFormat(new HashSet<ThesaurusFormat>());
		thesaurus2.setIdentifier("data");
		thesaurus2.setLang(new HashSet<Language>());
		thesaurus2.setPolyHierarchical(false);
		thesaurus2.setPublisher("foo");
		thesaurus2.setRelation("DE");
		thesaurus2.setRights("foo");
		thesaurus2.setSource("foo");
		thesaurus2.setSubject("foo");
		thesaurus2.setTitle("Mr");
		ThesaurusType type2 = new ThesaurusType();
		type2.setIdentifier(1);
		type2.setLabel("label");
		thesaurus2.setType(type2);
		thesaurus2.setVersions(new HashSet<ThesaurusVersionHistory>());
		customConceptAttributeType.setThesaurus(thesaurus2);
		customConceptAttributeType.setValue("value");
		conceptAttributeTypes.add(customConceptAttributeType);
		gincoExportedBranch.setConceptAttributeTypes(conceptAttributeTypes);
		HashMap<String, JaxbList<CustomConceptAttribute>> conceptAttributes =
			 new HashMap<String, JaxbList<CustomConceptAttribute>>();
		JaxbList<CustomConceptAttribute> jaxbList9 =
			 new JaxbList<CustomConceptAttribute>();
		conceptAttributes.put("foo", jaxbList9);
		gincoExportedBranch.setConceptAttributes(conceptAttributes);
		ArrayList<ThesaurusConcept> concepts = new ArrayList<ThesaurusConcept>();
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
		Thesaurus thesaurus3 = new Thesaurus();
		thesaurus3.setArchived(false);
		thesaurus3.setContributor("foo");
		thesaurus3.setCoverage("foo");
		thesaurus3.setCreated(new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31"));
		ThesaurusOrganization creator3 = new ThesaurusOrganization();
		creator3.setEmail("info@diffblue.com");
		creator3.setHomepage("foo");
		creator3.setIdentifier(1);
		creator3.setName("Acme");
		thesaurus3.setCreator(creator3);
		thesaurus3.setDate(new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31"));
		thesaurus3.setDefaultTopConcept(false);
		thesaurus3.setDescription("some text");
		thesaurus3.setFormat(new HashSet<ThesaurusFormat>());
		thesaurus3.setIdentifier("data");
		thesaurus3.setLang(new HashSet<Language>());
		thesaurus3.setPolyHierarchical(false);
		thesaurus3.setPublisher("foo");
		thesaurus3.setRelation("DE");
		thesaurus3.setRights("foo");
		thesaurus3.setSource("foo");
		thesaurus3.setSubject("foo");
		thesaurus3.setTitle("Mr");
		ThesaurusType type5 = new ThesaurusType();
		type5.setIdentifier(1);
		type5.setLabel("label");
		thesaurus3.setType(type5);
		thesaurus3.setVersions(new HashSet<ThesaurusVersionHistory>());
		thesaurusConcept.setThesaurus(thesaurus3);
		thesaurusConcept.setTopConcept(false);
		concepts.add(thesaurusConcept);
		gincoExportedBranch.setConcepts(concepts);
		ArrayList<CustomTermAttributeType> termAttributeTypes =
			 new ArrayList<CustomTermAttributeType>();
		CustomTermAttributeType customTermAttributeType =
			 new CustomTermAttributeType();
		customTermAttributeType.setCode("DE");
		customTermAttributeType.setIdentifier(1);
		Thesaurus thesaurus4 = new Thesaurus();
		thesaurus4.setArchived(false);
		thesaurus4.setContributor("foo");
		thesaurus4.setCoverage("foo");
		thesaurus4.setCreated(new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31"));
		ThesaurusOrganization creator4 = new ThesaurusOrganization();
		creator4.setEmail("info@diffblue.com");
		creator4.setHomepage("foo");
		creator4.setIdentifier(1);
		creator4.setName("Acme");
		thesaurus4.setCreator(creator4);
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
		ThesaurusType type6 = new ThesaurusType();
		type6.setIdentifier(1);
		type6.setLabel("label");
		thesaurus4.setType(type6);
		thesaurus4.setVersions(new HashSet<ThesaurusVersionHistory>());
		customTermAttributeType.setThesaurus(thesaurus4);
		customTermAttributeType.setValue("value");
		termAttributeTypes.add(customTermAttributeType);
		gincoExportedBranch.setTermAttributeTypes(termAttributeTypes);
		HashMap<String, JaxbList<CustomTermAttribute>> termAttributes =
			 new HashMap<String, JaxbList<CustomTermAttribute>>();
		JaxbList<CustomTermAttribute> jaxbList11 =
			 new JaxbList<CustomTermAttribute>();
		termAttributes.put("foo", jaxbList11);
		gincoExportedBranch.setTermAttributes(termAttributes);
		ArrayList<ThesaurusTerm> terms = new ArrayList<ThesaurusTerm>();
		ThesaurusTerm thesaurusTerm = new ThesaurusTerm();
		ThesaurusConcept concept5 = new ThesaurusConcept();
		concept5.setAssociativeRelationshipLeft(new HashSet<AssociativeRelationship>());
		concept5.setAssociativeRelationshipRight(new HashSet<AssociativeRelationship>());
		concept5.setConceptArrays(new HashSet<ThesaurusArray>());
		concept5.setCreated(new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31"));
		concept5.setIdentifier("data");
		concept5.setModified(new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31"));
		concept5.setNotation("DE");
		concept5.setParentConcepts(new HashSet<ThesaurusConcept>());
		concept5.setRootConcepts(new HashSet<ThesaurusConcept>());
		concept5.setStatus(1);
		Thesaurus thesaurus5 = new Thesaurus();
		thesaurus5.setArchived(false);
		thesaurus5.setContributor("foo");
		thesaurus5.setCoverage("foo");
		thesaurus5.setCreated(new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31"));
		thesaurus5.setCreator(new ThesaurusOrganization());
		thesaurus5.setDate(new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31"));
		thesaurus5.setDefaultTopConcept(false);
		thesaurus5.setDescription("some text");
		thesaurus5.setFormat(new HashSet<ThesaurusFormat>());
		thesaurus5.setIdentifier("data");
		thesaurus5.setLang(new HashSet<Language>());
		thesaurus5.setPolyHierarchical(false);
		thesaurus5.setPublisher("foo");
		thesaurus5.setRelation("DE");
		thesaurus5.setRights("foo");
		thesaurus5.setSource("foo");
		thesaurus5.setSubject("foo");
		thesaurus5.setTitle("Mr");
		thesaurus5.setType(new ThesaurusType());
		thesaurus5.setVersions(new HashSet<ThesaurusVersionHistory>());
		concept5.setThesaurus(thesaurus5);
		concept5.setTopConcept(false);
		thesaurusTerm.setConcept(concept5);
		thesaurusTerm.setCreated(new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31"));
		thesaurusTerm.setHidden(false);
		thesaurusTerm.setIdentifier("data");
		Language language5 = new Language();
		language5.setId("1234");
		language5.setPart1("foo");
		language5.setPrincipalLanguage(false);
		language5.setRefname("root");
		language5.setTopLanguage(false);
		thesaurusTerm.setLanguage(language5);
		thesaurusTerm.setLexicalValue("value");
		thesaurusTerm.setModified(new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31"));
		thesaurusTerm.setPrefered(false);
		ThesaurusTermRole role3 = new ThesaurusTermRole();
		role3.setCode("DE");
		role3.setDefaultRole(false);
		role3.setLabel("label");
		thesaurusTerm.setRole(role3);
		thesaurusTerm.setSource("foo");
		thesaurusTerm.setStatus(1);
		Thesaurus thesaurus6 = new Thesaurus();
		thesaurus6.setArchived(false);
		thesaurus6.setContributor("foo");
		thesaurus6.setCoverage("foo");
		thesaurus6.setCreated(new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31"));
		ThesaurusOrganization creator6 = new ThesaurusOrganization();
		creator6.setEmail("info@diffblue.com");
		creator6.setHomepage("foo");
		creator6.setIdentifier(1);
		creator6.setName("Acme");
		thesaurus6.setCreator(creator6);
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
		ThesaurusType type10 = new ThesaurusType();
		type10.setIdentifier(1);
		type10.setLabel("label");
		thesaurus6.setType(type10);
		thesaurus6.setVersions(new HashSet<ThesaurusVersionHistory>());
		thesaurusTerm.setThesaurus(thesaurus6);
		terms.add(thesaurusTerm);
		gincoExportedBranch.setTerms(terms);
		assertThat(gincoExportedBranch.getAlignments().get("foo"), sameInstance(jaxbList1));
		assertThat(gincoExportedBranch.getConceptNotes().get("foo"), sameInstance(jaxbList3));
		assertThat(gincoExportedBranch.getHierarchicalRelationship().get("foo"), sameInstance(jaxbList5));
		assertThat(gincoExportedBranch.getRootConcept(), sameInstance(rootConcept));
		assertThat(gincoExportedBranch.getTermNotes().get("foo"), sameInstance(jaxbList7));
		assertThat(gincoExportedBranch.getConceptAttributeTypes().size(), is(1));
		assertThat(gincoExportedBranch.getConceptAttributeTypes().get(0), sameInstance(customConceptAttributeType));
		assertThat(gincoExportedBranch.getConceptAttributes().get("foo"), sameInstance(jaxbList9));
		assertThat(gincoExportedBranch.getConcepts().size(), is(1));
		assertThat(gincoExportedBranch.getConcepts().get(0), sameInstance(thesaurusConcept));
		assertThat(gincoExportedBranch.getTermAttributeTypes().size(), is(1));
		assertThat(gincoExportedBranch.getTermAttributeTypes().get(0), sameInstance(customTermAttributeType));
		assertThat(gincoExportedBranch.getTermAttributes().get("foo"), sameInstance(jaxbList11));
		assertThat(gincoExportedBranch.getTerms().size(), is(1));
		assertThat(gincoExportedBranch.getTerms().get(0), sameInstance(thesaurusTerm));
	}
}
