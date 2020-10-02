package fr.mcc.ginco.exports.ginco;

import static org.junit.Assert.assertEquals;

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
import fr.mcc.ginco.beans.ThesaurusConceptGroupType;
import fr.mcc.ginco.beans.ThesaurusOrganization;
import fr.mcc.ginco.beans.ThesaurusTerm;
import fr.mcc.ginco.beans.ThesaurusTermRole;
import fr.mcc.ginco.beans.ThesaurusType;
import fr.mcc.ginco.beans.ThesaurusVersionHistory;
import fr.mcc.ginco.exports.result.bean.GincoExportedBranch;
import fr.mcc.ginco.exports.result.bean.GincoExportedThesaurus;
import fr.mcc.ginco.exports.result.bean.JaxbList;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

/**
 * Unit tests for fr.mcc.ginco.exports.ginco.GincoExportServiceUtilImpl
 *
 * @author Diffblue Cover
 */

public class GincoExportServiceUtilImplTest {

	@InjectMocks
	private GincoExportServiceUtilImpl service;

	@Before public void initMocks() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void serializeThesaurusToXmlWithJaxb() throws java.text.ParseException, fr.mcc.ginco.exceptions.TechnicalException {
		GincoExportedThesaurus thesaurusToExport = new GincoExportedThesaurus();
		HashMap<String, JaxbList<Alignment>> alignments =
			 new HashMap<String, JaxbList<Alignment>>();
		alignments.put("foo", new JaxbList<Alignment>());
		thesaurusToExport.setAlignments(alignments);
		HashMap<String, JaxbList<AssociativeRelationship>> associativeRelationship1 =
			 new HashMap<String, JaxbList<AssociativeRelationship>>();
		associativeRelationship1.put("foo", new JaxbList<AssociativeRelationship>());
		thesaurusToExport.setAssociativeRelationship(associativeRelationship1);
		ArrayList<SplitNonPreferredTerm> complexConcepts =
			 new ArrayList<SplitNonPreferredTerm>();
		SplitNonPreferredTerm splitNonPreferredTerm = new SplitNonPreferredTerm();
		splitNonPreferredTerm.setCreated(new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31"));
		splitNonPreferredTerm.setIdentifier("data");
		Language language1 = new Language();
		language1.setId("1234");
		language1.setPart1("foo");
		language1.setRefname("root");
		splitNonPreferredTerm.setLanguage(language1);
		splitNonPreferredTerm.setLexicalValue("value");
		splitNonPreferredTerm.setModified(new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31"));
		splitNonPreferredTerm.setSource("foo");
		splitNonPreferredTerm.setStatus(1);
		complexConcepts.add(splitNonPreferredTerm);
		thesaurusToExport.setComplexConcepts(complexConcepts);
		HashMap<String, JaxbList<NodeLabel>> conceptArrayLabels =
			 new HashMap<String, JaxbList<NodeLabel>>();
		conceptArrayLabels.put("foo", new JaxbList<NodeLabel>());
		thesaurusToExport.setConceptArrayLabels(conceptArrayLabels);
		ArrayList<ThesaurusArray> conceptArrays1 = new ArrayList<ThesaurusArray>();
		ThesaurusArray thesaurusArray = new ThesaurusArray();
		thesaurusArray.setIdentifier("data");
		thesaurusArray.setNotation("DE");
		thesaurusArray.setOrdered(false);
		ThesaurusArray parent1 = new ThesaurusArray();
		parent1.setIdentifier("data");
		parent1.setNotation("DE");
		parent1.setOrdered(false);
		parent1.setParent(new ThesaurusArray());
		parent1.setSuperOrdinateConcept(new ThesaurusConcept());
		thesaurusArray.setParent(parent1);
		ThesaurusConcept superOrdinateConcept2 = new ThesaurusConcept();
		superOrdinateConcept2.setCreated(new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31"));
		superOrdinateConcept2.setIdentifier("data");
		superOrdinateConcept2.setModified(new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31"));
		superOrdinateConcept2.setNotation("DE");
		superOrdinateConcept2.setStatus(1);
		superOrdinateConcept2.setTopConcept(false);
		thesaurusArray.setSuperOrdinateConcept(superOrdinateConcept2);
		conceptArrays1.add(thesaurusArray);
		thesaurusToExport.setConceptArrays(conceptArrays1);
		HashMap<String, JaxbList<ThesaurusConceptGroupLabel>> conceptGroupLabels =
			 new HashMap<String, JaxbList<ThesaurusConceptGroupLabel>>();
		conceptGroupLabels.put("foo", new JaxbList<ThesaurusConceptGroupLabel>());
		thesaurusToExport.setConceptGroupLabels(conceptGroupLabels);
		ArrayList<ThesaurusConceptGroup> conceptGroups =
			 new ArrayList<ThesaurusConceptGroup>();
		ThesaurusConceptGroup thesaurusConceptGroup = new ThesaurusConceptGroup();
		ThesaurusConceptGroupType conceptGroupType1 =
			 new ThesaurusConceptGroupType();
		conceptGroupType1.setCode("DE");
		conceptGroupType1.setLabel("label");
		conceptGroupType1.setSkosLabel("label");
		thesaurusConceptGroup.setConceptGroupType(conceptGroupType1);
		thesaurusConceptGroup.setIdentifier("data");
		thesaurusConceptGroup.setIsDynamic(false);
		thesaurusConceptGroup.setNotation("DE");
		ThesaurusConcept parentConcept2 = new ThesaurusConcept();
		parentConcept2.setCreated(new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31"));
		parentConcept2.setIdentifier("data");
		parentConcept2.setModified(new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31"));
		parentConcept2.setNotation("DE");
		parentConcept2.setStatus(1);
		parentConcept2.setTopConcept(false);
		thesaurusConceptGroup.setParentConcept(parentConcept2);
		conceptGroups.add(thesaurusConceptGroup);
		thesaurusToExport.setConceptGroups(conceptGroups);
		HashMap<String, JaxbList<Note>> conceptNotes =
			 new HashMap<String, JaxbList<Note>>();
		conceptNotes.put("foo", new JaxbList<Note>());
		thesaurusToExport.setConceptNotes(conceptNotes);
		HashMap<String, JaxbList<ConceptHierarchicalRelationship>> parentConceptRelationship =
			 new HashMap<String, JaxbList<ConceptHierarchicalRelationship>>();
		parentConceptRelationship.put("foo", new JaxbList<ConceptHierarchicalRelationship>());
		thesaurusToExport.setHierarchicalRelationship(parentConceptRelationship);
		HashMap<String, JaxbList<Note>> termNotes =
			 new HashMap<String, JaxbList<Note>>();
		termNotes.put("foo", new JaxbList<Note>());
		thesaurusToExport.setTermNotes(termNotes);
		Thesaurus thesaurus8 = new Thesaurus();
		thesaurus8.setArchived(false);
		thesaurus8.setContributor("foo");
		thesaurus8.setCoverage("foo");
		thesaurus8.setCreated(new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31"));
		ThesaurusOrganization creator4 = new ThesaurusOrganization();
		creator4.setEmail("info@diffblue.com");
		creator4.setHomepage("foo");
		creator4.setName("Acme");
		thesaurus8.setCreator(creator4);
		thesaurus8.setDate(new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31"));
		thesaurus8.setDefaultTopConcept(false);
		thesaurus8.setDescription("some text");
		thesaurus8.setIdentifier("data");
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
		thesaurusToExport.setThesaurus(thesaurus8);
		ArrayList<ThesaurusVersionHistory> versions5 =
			 new ArrayList<ThesaurusVersionHistory>();
		ThesaurusVersionHistory thesaurusVersionHistory =
			 new ThesaurusVersionHistory();
		thesaurusVersionHistory.setDate(new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31"));
		thesaurusVersionHistory.setIdentifier("data");
		thesaurusVersionHistory.setStatus(1);
		thesaurusVersionHistory.setThisVersion(false);
		thesaurusVersionHistory.setUserId("root");
		thesaurusVersionHistory.setVersionNote("1.0");
		versions5.add(thesaurusVersionHistory);
		thesaurusToExport.setThesaurusVersions(versions5);
		ArrayList<CustomConceptAttributeType> conceptAttributeTypes =
			 new ArrayList<CustomConceptAttributeType>();
		CustomConceptAttributeType customConceptAttributeType =
			 new CustomConceptAttributeType();
		customConceptAttributeType.setExportable(false);
		customConceptAttributeType.setCode("DE");
		customConceptAttributeType.setValue("value");
		conceptAttributeTypes.add(customConceptAttributeType);
		thesaurusToExport.setConceptAttributeTypes(conceptAttributeTypes);
		HashMap<String, JaxbList<CustomConceptAttribute>> conceptAttributes =
			 new HashMap<String, JaxbList<CustomConceptAttribute>>();
		conceptAttributes.put("foo", new JaxbList<CustomConceptAttribute>());
		thesaurusToExport.setConceptAttributes(conceptAttributes);
		ArrayList<ThesaurusConcept> concepts5 = new ArrayList<ThesaurusConcept>();
		ThesaurusConcept thesaurusConcept = new ThesaurusConcept();
		thesaurusConcept.setCreated(new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31"));
		thesaurusConcept.setIdentifier("data");
		thesaurusConcept.setModified(new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31"));
		thesaurusConcept.setNotation("DE");
		thesaurusConcept.setStatus(1);
		thesaurusConcept.setTopConcept(false);
		concepts5.add(thesaurusConcept);
		thesaurusToExport.setConcepts(concepts5);
		ArrayList<CustomTermAttributeType> termAttributeTypes =
			 new ArrayList<CustomTermAttributeType>();
		CustomTermAttributeType customTermAttributeType =
			 new CustomTermAttributeType();
		customTermAttributeType.setCode("DE");
		customTermAttributeType.setValue("value");
		termAttributeTypes.add(customTermAttributeType);
		thesaurusToExport.setTermAttributeTypes(termAttributeTypes);
		HashMap<String, JaxbList<CustomTermAttribute>> termAttributes =
			 new HashMap<String, JaxbList<CustomTermAttribute>>();
		termAttributes.put("foo", new JaxbList<CustomTermAttribute>());
		thesaurusToExport.setTermAttributes(termAttributes);
		ArrayList<ThesaurusTerm> terms = new ArrayList<ThesaurusTerm>();
		ThesaurusTerm thesaurusTerm = new ThesaurusTerm();
		ThesaurusConcept concept = new ThesaurusConcept();
		concept.setCreated(new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31"));
		concept.setIdentifier("data");
		concept.setModified(new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31"));
		concept.setNotation("DE");
		concept.setStatus(1);
		concept.setTopConcept(false);
		thesaurusTerm.setConcept(concept);
		thesaurusTerm.setCreated(new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31"));
		thesaurusTerm.setHidden(false);
		thesaurusTerm.setIdentifier("data");
		Language language2 = new Language();
		language2.setId("1234");
		language2.setPart1("foo");
		language2.setRefname("root");
		thesaurusTerm.setLanguage(language2);
		thesaurusTerm.setLexicalValue("value");
		thesaurusTerm.setModified(new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31"));
		thesaurusTerm.setPrefered(false);
		ThesaurusTermRole role = new ThesaurusTermRole();
		role.setCode("DE");
		role.setLabel("label");
		thesaurusTerm.setRole(role);
		thesaurusTerm.setSource("foo");
		thesaurusTerm.setStatus(1);
		terms.add(thesaurusTerm);
		thesaurusToExport.setTerms(terms);
		assertEquals("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n<gincoExportedThesaurus>\n    <conceptAttributeTypes>\n        <code>DE</code>\n        <value>value</value>\n        <exportable>false</exportable>\n    </conceptAttributeTypes>\n    <conceptAttributes>\n        <entry>\n            <key>foo</key>\n            <value/>\n        </entry>\n    </conceptAttributes>\n    <concepts>\n        <identifier>data</identifier>\n        <created>2010-12-31T00:00:00Z</created>\n        <modified>2010-12-31T00:00:00Z</modified>\n        <status>1</status>\n        <notation>DE</notation>\n        <topConcept>false</topConcept>\n    </concepts>\n    <termAttributeTypes>\n        <code>DE</code>\n        <value>value</value>\n    </termAttributeTypes>\n    <termAttributes>\n        <entry>\n            <key>foo</key>\n            <value/>\n        </entry>\n    </termAttributes>\n    <terms>\n        <identifier>data</identifier>\n        <lexicalValue>value</lexicalValue>\n        <created>2010-12-31T00:00:00Z</created>\n        <modified>2010-12-31T00:00:00Z</modified>\n        <source>foo</source>\n        <prefered>false</prefered>\n        <hidden>false</hidden>\n        <status>1</status>\n        <role>\n            <code>DE</code>\n            <defaultRole>false</defaultRole>\n            <label>label</label>\n        </role>\n        <concept>\n            <identifier>data</identifier>\n            <created>2010-12-31T00:00:00Z</created>\n            <modified>2010-12-31T00:00:00Z</modified>\n            <status>1</status>\n            <notation>DE</notation>\n            <topConcept>false</topConcept>\n        </concept>\n        <language>\n            <id>1234</id>\n            <part1>foo</part1>\n            <principalLanguage>false</principalLanguage>\n            <refname>root</refname>\n            <topLanguage>false</topLanguage>\n        </language>\n    </terms>\n    <alignments>\n        <entry>\n            <key>foo</key>\n            <value/>\n        </entry>\n    </alignments>\n    <associativeRelationship>\n        <entry>\n            <key>foo</key>\n            <value/>\n        </entry>\n    </associativeRelationship>\n    <complexConcepts>\n        <identifier>data</identifier>\n        <lexicalValue>value</lexicalValue>\n        <created>2010-12-31T00:00:00Z</created>\n        <modified>2010-12-31T00:00:00Z</modified>\n        <source>foo</source>\n        <status>1</status>\n        <language>\n            <id>1234</id>\n            <part1>foo</part1>\n            <principalLanguage>false</principalLanguage>\n            <refname>root</refname>\n            <topLanguage>false</topLanguage>\n        </language>\n    </complexConcepts>\n    <conceptArrayLabels>\n        <entry>\n            <key>foo</key>\n            <value/>\n        </entry>\n    </conceptArrayLabels>\n    <conceptArrays>\n        <identifier>data</identifier>\n        <ordered>false</ordered>\n        <notation>DE</notation>\n        <superOrdinateConcept>\n            <identifier>data</identifier>\n            <created>2010-12-31T00:00:00Z</created>\n            <modified>2010-12-31T00:00:00Z</modified>\n            <status>1</status>\n            <notation>DE</notation>\n            <topConcept>false</topConcept>\n        </superOrdinateConcept>\n        <parent>\n            <identifier>data</identifier>\n            <ordered>false</ordered>\n            <notation>DE</notation>\n            <superOrdinateConcept/>\n            <parent/>\n        </parent>\n    </conceptArrays>\n    <conceptGroupLabels>\n        <entry>\n            <key>foo</key>\n            <value/>\n        </entry>\n    </conceptGroupLabels>\n    <conceptGroups>\n        <identifier>data</identifier>\n        <conceptGroupType>\n            <code>DE</code>\n            <label>label</label>\n            <skosLabel>label</skosLabel>\n        </conceptGroupType>\n        <notation>DE</notation>\n        <isDynamic>false</isDynamic>\n        <parentConcept>\n            <identifier>data</identifier>\n            <created>2010-12-31T00:00:00Z</created>\n            <modified>2010-12-31T00:00:00Z</modified>\n            <status>1</status>\n            <notation>DE</notation>\n            <topConcept>false</topConcept>\n        </parentConcept>\n    </conceptGroups>\n    <conceptNotes>\n        <entry>\n            <key>foo</key>\n            <value/>\n        </entry>\n    </conceptNotes>\n    <hierarchicalRelationship>\n        <entry>\n            <key>foo</key>\n            <value/>\n        </entry>\n    </hierarchicalRelationship>\n    <termNotes>\n        <entry>\n            <key>foo</key>\n            <value/>\n        </entry>\n    </termNotes>\n    <thesaurus>\n        <archived>false</archived>\n        <contributor>foo</contributor>\n        <coverage>foo</coverage>\n        <created>2010-12-31T00:00:00Z</created>\n        <creator>\n            <name>Acme</name>\n            <homepage>foo</homepage>\n            <email>info@diffblue.com</email>\n        </creator>\n        <date>2010-12-31T00:00:00Z</date>\n        <defaultTopConcept>false</defaultTopConcept>\n        <description>some text</description>\n        <identifier>data</identifier>\n        <polyHierarchical>false</polyHierarchical>\n        <publisher>foo</publisher>\n        <relation>DE</relation>\n        <rights>foo</rights>\n        <source>foo</source>\n        <subject>foo</subject>\n        <title>Mr</title>\n        <type>\n            <identifier>1</identifier>\n            <label>label</label>\n        </type>\n    </thesaurus>\n    <thesaurusVersions>\n        <identifier>data</identifier>\n        <date>2010-12-31T00:00:00Z</date>\n        <versionNote>1.0</versionNote>\n        <status>1</status>\n        <thisVersion>false</thisVersion>\n        <userId>root</userId>\n    </thesaurusVersions>\n</gincoExportedThesaurus>\n", service.serializeThesaurusToXmlWithJaxb(thesaurusToExport));
	}

	@Test
	public void serializeBranchToXmlWithJaxb() throws java.text.ParseException, fr.mcc.ginco.exceptions.TechnicalException {
		GincoExportedBranch branchToExport = new GincoExportedBranch();
		HashMap<String, JaxbList<Alignment>> alignments =
			 new HashMap<String, JaxbList<Alignment>>();
		alignments.put("foo", new JaxbList<Alignment>());
		branchToExport.setAlignments(alignments);
		HashMap<String, JaxbList<Note>> conceptNotes =
			 new HashMap<String, JaxbList<Note>>();
		conceptNotes.put("foo", new JaxbList<Note>());
		branchToExport.setConceptNotes(conceptNotes);
		HashMap<String, JaxbList<ConceptHierarchicalRelationship>> parentConceptRelationship =
			 new HashMap<String, JaxbList<ConceptHierarchicalRelationship>>();
		parentConceptRelationship.put("foo", new JaxbList<ConceptHierarchicalRelationship>());
		branchToExport.setHierarchicalRelationship(parentConceptRelationship);
		ThesaurusConcept rootConcept = new ThesaurusConcept();
		rootConcept.setCreated(new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31"));
		rootConcept.setIdentifier("data");
		rootConcept.setModified(new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31"));
		rootConcept.setNotation("DE");
		rootConcept.setStatus(1);
		rootConcept.setTopConcept(false);
		branchToExport.setRootConcept(rootConcept);
		HashMap<String, JaxbList<Note>> termNotes =
			 new HashMap<String, JaxbList<Note>>();
		termNotes.put("foo", new JaxbList<Note>());
		branchToExport.setTermNotes(termNotes);
		ArrayList<CustomConceptAttributeType> conceptAttributeTypes =
			 new ArrayList<CustomConceptAttributeType>();
		CustomConceptAttributeType customConceptAttributeType =
			 new CustomConceptAttributeType();
		customConceptAttributeType.setExportable(false);
		customConceptAttributeType.setCode("DE");
		customConceptAttributeType.setValue("value");
		conceptAttributeTypes.add(customConceptAttributeType);
		branchToExport.setConceptAttributeTypes(conceptAttributeTypes);
		HashMap<String, JaxbList<CustomConceptAttribute>> conceptAttributes =
			 new HashMap<String, JaxbList<CustomConceptAttribute>>();
		conceptAttributes.put("foo", new JaxbList<CustomConceptAttribute>());
		branchToExport.setConceptAttributes(conceptAttributes);
		ArrayList<ThesaurusConcept> concepts = new ArrayList<ThesaurusConcept>();
		ThesaurusConcept thesaurusConcept = new ThesaurusConcept();
		thesaurusConcept.setCreated(new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31"));
		thesaurusConcept.setIdentifier("data");
		thesaurusConcept.setModified(new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31"));
		thesaurusConcept.setNotation("DE");
		thesaurusConcept.setStatus(1);
		thesaurusConcept.setTopConcept(false);
		concepts.add(thesaurusConcept);
		branchToExport.setConcepts(concepts);
		ArrayList<CustomTermAttributeType> termAttributeTypes =
			 new ArrayList<CustomTermAttributeType>();
		CustomTermAttributeType customTermAttributeType =
			 new CustomTermAttributeType();
		customTermAttributeType.setCode("DE");
		customTermAttributeType.setValue("value");
		termAttributeTypes.add(customTermAttributeType);
		branchToExport.setTermAttributeTypes(termAttributeTypes);
		HashMap<String, JaxbList<CustomTermAttribute>> termAttributes =
			 new HashMap<String, JaxbList<CustomTermAttribute>>();
		termAttributes.put("foo", new JaxbList<CustomTermAttribute>());
		branchToExport.setTermAttributes(termAttributes);
		ArrayList<ThesaurusTerm> terms = new ArrayList<ThesaurusTerm>();
		ThesaurusTerm thesaurusTerm = new ThesaurusTerm();
		ThesaurusConcept concept = new ThesaurusConcept();
		concept.setCreated(new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31"));
		concept.setIdentifier("data");
		concept.setModified(new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31"));
		concept.setNotation("DE");
		concept.setStatus(1);
		concept.setTopConcept(false);
		thesaurusTerm.setConcept(concept);
		thesaurusTerm.setCreated(new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31"));
		thesaurusTerm.setHidden(false);
		thesaurusTerm.setIdentifier("data");
		Language language = new Language();
		language.setId("1234");
		language.setPart1("foo");
		language.setRefname("root");
		thesaurusTerm.setLanguage(language);
		thesaurusTerm.setLexicalValue("value");
		thesaurusTerm.setModified(new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31"));
		thesaurusTerm.setPrefered(false);
		ThesaurusTermRole role = new ThesaurusTermRole();
		role.setCode("DE");
		role.setLabel("label");
		thesaurusTerm.setRole(role);
		thesaurusTerm.setSource("foo");
		thesaurusTerm.setStatus(1);
		terms.add(thesaurusTerm);
		branchToExport.setTerms(terms);
		assertEquals("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n<gincoExportedBranch>\n    <conceptAttributeTypes>\n        <code>DE</code>\n        <value>value</value>\n        <exportable>false</exportable>\n    </conceptAttributeTypes>\n    <conceptAttributes>\n        <entry>\n            <key>foo</key>\n            <value/>\n        </entry>\n    </conceptAttributes>\n    <concepts>\n        <identifier>data</identifier>\n        <created>2010-12-31T00:00:00Z</created>\n        <modified>2010-12-31T00:00:00Z</modified>\n        <status>1</status>\n        <notation>DE</notation>\n        <topConcept>false</topConcept>\n    </concepts>\n    <termAttributeTypes>\n        <code>DE</code>\n        <value>value</value>\n    </termAttributeTypes>\n    <termAttributes>\n        <entry>\n            <key>foo</key>\n            <value/>\n        </entry>\n    </termAttributes>\n    <terms>\n        <identifier>data</identifier>\n        <lexicalValue>value</lexicalValue>\n        <created>2010-12-31T00:00:00Z</created>\n        <modified>2010-12-31T00:00:00Z</modified>\n        <source>foo</source>\n        <prefered>false</prefered>\n        <hidden>false</hidden>\n        <status>1</status>\n        <role>\n            <code>DE</code>\n            <defaultRole>false</defaultRole>\n            <label>label</label>\n        </role>\n        <concept>\n            <identifier>data</identifier>\n            <created>2010-12-31T00:00:00Z</created>\n            <modified>2010-12-31T00:00:00Z</modified>\n            <status>1</status>\n            <notation>DE</notation>\n            <topConcept>false</topConcept>\n        </concept>\n        <language>\n            <id>1234</id>\n            <part1>foo</part1>\n            <principalLanguage>false</principalLanguage>\n            <refname>root</refname>\n            <topLanguage>false</topLanguage>\n        </language>\n    </terms>\n    <alignments>\n        <entry>\n            <key>foo</key>\n            <value/>\n        </entry>\n    </alignments>\n    <conceptNotes>\n        <entry>\n            <key>foo</key>\n            <value/>\n        </entry>\n    </conceptNotes>\n    <hierarchicalRelationship>\n        <entry>\n            <key>foo</key>\n            <value/>\n        </entry>\n    </hierarchicalRelationship>\n    <rootConcept>\n        <identifier>data</identifier>\n        <created>2010-12-31T00:00:00Z</created>\n        <modified>2010-12-31T00:00:00Z</modified>\n        <status>1</status>\n        <notation>DE</notation>\n        <topConcept>false</topConcept>\n    </rootConcept>\n    <termNotes>\n        <entry>\n            <key>foo</key>\n            <value/>\n        </entry>\n    </termNotes>\n</gincoExportedBranch>\n", service.serializeBranchToXmlWithJaxb(branchToExport));
	}
}
