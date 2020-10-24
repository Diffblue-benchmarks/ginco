package fr.mcc.ginco.exports.ginco;

import static org.junit.Assert.assertEquals;

import fr.mcc.ginco.beans.CustomConceptAttributeType;
import fr.mcc.ginco.beans.CustomTermAttributeType;
import fr.mcc.ginco.beans.Language;
import fr.mcc.ginco.beans.SplitNonPreferredTerm;
import fr.mcc.ginco.beans.Thesaurus;
import fr.mcc.ginco.beans.ThesaurusArray;
import fr.mcc.ginco.beans.ThesaurusConcept;
import fr.mcc.ginco.beans.ThesaurusConceptGroup;
import fr.mcc.ginco.beans.ThesaurusConceptGroupType;
import fr.mcc.ginco.beans.ThesaurusOrganization;
import fr.mcc.ginco.beans.ThesaurusTerm;
import fr.mcc.ginco.beans.ThesaurusTermRole;
import fr.mcc.ginco.beans.ThesaurusType;
import fr.mcc.ginco.beans.ThesaurusVersionHistory;
import fr.mcc.ginco.exports.result.bean.GincoExportedBranch;
import fr.mcc.ginco.exports.result.bean.GincoExportedThesaurus;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

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
		ArrayList<SplitNonPreferredTerm> complexConcepts =
			 new ArrayList<SplitNonPreferredTerm>();
		SplitNonPreferredTerm splitNonPreferredTerm = new SplitNonPreferredTerm();
		splitNonPreferredTerm.setCreated(new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31"));
		splitNonPreferredTerm.setIdentifier("data");
		splitNonPreferredTerm.setLanguage(new Language());
		splitNonPreferredTerm.setLexicalValue("value");
		splitNonPreferredTerm.setModified(new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31"));
		splitNonPreferredTerm.setSource("foo");
		splitNonPreferredTerm.setStatus(1);
		complexConcepts.add(splitNonPreferredTerm);
		thesaurusToExport.setComplexConcepts(complexConcepts);
		ArrayList<ThesaurusArray> conceptArrays1 = new ArrayList<ThesaurusArray>();
		ThesaurusArray thesaurusArray = new ThesaurusArray();
		thesaurusArray.setIdentifier("data");
		thesaurusArray.setNotation("DE");
		thesaurusArray.setOrdered(false);
		thesaurusArray.setParent(new ThesaurusArray());
		thesaurusArray.setSuperOrdinateConcept(new ThesaurusConcept());
		conceptArrays1.add(thesaurusArray);
		thesaurusToExport.setConceptArrays(conceptArrays1);
		ArrayList<ThesaurusConceptGroup> conceptGroups =
			 new ArrayList<ThesaurusConceptGroup>();
		ThesaurusConceptGroup thesaurusConceptGroup = new ThesaurusConceptGroup();
		thesaurusConceptGroup.setConceptGroupType(new ThesaurusConceptGroupType());
		thesaurusConceptGroup.setIdentifier("data");
		thesaurusConceptGroup.setIsDynamic(false);
		thesaurusConceptGroup.setNotation("DE");
		thesaurusConceptGroup.setParentConcept(new ThesaurusConcept());
		conceptGroups.add(thesaurusConceptGroup);
		thesaurusToExport.setConceptGroups(conceptGroups);
		Thesaurus thesaurus4 = new Thesaurus();
		thesaurus4.setArchived(false);
		thesaurus4.setContributor("foo");
		thesaurus4.setCoverage("foo");
		thesaurus4.setCreated(new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31"));
		ThesaurusOrganization creator = new ThesaurusOrganization();
		creator.setEmail("info@diffblue.com");
		creator.setHomepage("foo");
		creator.setName("Acme");
		thesaurus4.setCreator(creator);
		thesaurus4.setDate(new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31"));
		thesaurus4.setDefaultTopConcept(false);
		thesaurus4.setDescription("some text");
		thesaurus4.setIdentifier("data");
		thesaurus4.setPolyHierarchical(false);
		thesaurus4.setPublisher("foo");
		thesaurus4.setRelation("DE");
		thesaurus4.setRights("foo");
		thesaurus4.setSource("foo");
		thesaurus4.setSubject("foo");
		thesaurus4.setTitle("Mr");
		ThesaurusType type = new ThesaurusType();
		type.setIdentifier(1);
		type.setLabel("label");
		thesaurus4.setType(type);
		thesaurusToExport.setThesaurus(thesaurus4);
		ArrayList<ThesaurusVersionHistory> versions2 =
			 new ArrayList<ThesaurusVersionHistory>();
		ThesaurusVersionHistory thesaurusVersionHistory =
			 new ThesaurusVersionHistory();
		thesaurusVersionHistory.setDate(new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31"));
		thesaurusVersionHistory.setIdentifier("data");
		thesaurusVersionHistory.setStatus(1);
		thesaurusVersionHistory.setThisVersion(false);
		thesaurusVersionHistory.setUserId("root");
		thesaurusVersionHistory.setVersionNote("1.0");
		versions2.add(thesaurusVersionHistory);
		thesaurusToExport.setThesaurusVersions(versions2);
		ArrayList<CustomConceptAttributeType> conceptAttributeTypes =
			 new ArrayList<CustomConceptAttributeType>();
		CustomConceptAttributeType customConceptAttributeType =
			 new CustomConceptAttributeType();
		customConceptAttributeType.setExportable(false);
		customConceptAttributeType.setCode("DE");
		customConceptAttributeType.setValue("value");
		conceptAttributeTypes.add(customConceptAttributeType);
		thesaurusToExport.setConceptAttributeTypes(conceptAttributeTypes);
		ArrayList<ThesaurusConcept> concepts3 = new ArrayList<ThesaurusConcept>();
		ThesaurusConcept thesaurusConcept = new ThesaurusConcept();
		thesaurusConcept.setCreated(new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31"));
		thesaurusConcept.setIdentifier("data");
		thesaurusConcept.setModified(new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31"));
		thesaurusConcept.setNotation("DE");
		thesaurusConcept.setStatus(1);
		thesaurusConcept.setTopConcept(false);
		concepts3.add(thesaurusConcept);
		thesaurusToExport.setConcepts(concepts3);
		ArrayList<CustomTermAttributeType> termAttributeTypes =
			 new ArrayList<CustomTermAttributeType>();
		CustomTermAttributeType customTermAttributeType =
			 new CustomTermAttributeType();
		customTermAttributeType.setCode("DE");
		customTermAttributeType.setValue("value");
		termAttributeTypes.add(customTermAttributeType);
		thesaurusToExport.setTermAttributeTypes(termAttributeTypes);
		ArrayList<ThesaurusTerm> terms = new ArrayList<ThesaurusTerm>();
		ThesaurusTerm thesaurusTerm = new ThesaurusTerm();
		thesaurusTerm.setConcept(new ThesaurusConcept());
		thesaurusTerm.setCreated(new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31"));
		thesaurusTerm.setHidden(false);
		thesaurusTerm.setIdentifier("data");
		thesaurusTerm.setLanguage(new Language());
		thesaurusTerm.setLexicalValue("value");
		thesaurusTerm.setModified(new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31"));
		thesaurusTerm.setPrefered(false);
		thesaurusTerm.setRole(new ThesaurusTermRole());
		thesaurusTerm.setSource("foo");
		thesaurusTerm.setStatus(1);
		terms.add(thesaurusTerm);
		thesaurusToExport.setTerms(terms);
		assertEquals("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n<gincoExportedThesaurus>\n    <conceptAttributeTypes>\n        <code>DE</code>\n        <value>value</value>\n        <exportable>false</exportable>\n    </conceptAttributeTypes>\n    <conceptAttributes/>\n    <concepts>\n        <identifier>data</identifier>\n        <created>2010-12-31T00:00:00Z</created>\n        <modified>2010-12-31T00:00:00Z</modified>\n        <status>1</status>\n        <notation>DE</notation>\n        <topConcept>false</topConcept>\n    </concepts>\n    <termAttributeTypes>\n        <code>DE</code>\n        <value>value</value>\n    </termAttributeTypes>\n    <termAttributes/>\n    <terms>\n        <identifier>data</identifier>\n        <lexicalValue>value</lexicalValue>\n        <created>2010-12-31T00:00:00Z</created>\n        <modified>2010-12-31T00:00:00Z</modified>\n        <source>foo</source>\n        <prefered>false</prefered>\n        <hidden>false</hidden>\n        <status>1</status>\n        <role>\n            <defaultRole>false</defaultRole>\n        </role>\n        <concept/>\n        <language>\n            <principalLanguage>false</principalLanguage>\n            <topLanguage>false</topLanguage>\n        </language>\n    </terms>\n    <alignments/>\n    <associativeRelationship/>\n    <complexConcepts>\n        <identifier>data</identifier>\n        <lexicalValue>value</lexicalValue>\n        <created>2010-12-31T00:00:00Z</created>\n        <modified>2010-12-31T00:00:00Z</modified>\n        <source>foo</source>\n        <status>1</status>\n        <language>\n            <principalLanguage>false</principalLanguage>\n            <topLanguage>false</topLanguage>\n        </language>\n    </complexConcepts>\n    <conceptArrayLabels/>\n    <conceptArrays>\n        <identifier>data</identifier>\n        <ordered>false</ordered>\n        <notation>DE</notation>\n        <superOrdinateConcept/>\n        <parent/>\n    </conceptArrays>\n    <conceptGroupLabels/>\n    <conceptGroups>\n        <identifier>data</identifier>\n        <conceptGroupType/>\n        <notation>DE</notation>\n        <isDynamic>false</isDynamic>\n        <parentConcept/>\n    </conceptGroups>\n    <conceptNotes/>\n    <hierarchicalRelationship/>\n    <termNotes/>\n    <thesaurus>\n        <archived>false</archived>\n        <contributor>foo</contributor>\n        <coverage>foo</coverage>\n        <created>2010-12-31T00:00:00Z</created>\n        <creator>\n            <name>Acme</name>\n            <homepage>foo</homepage>\n            <email>info@diffblue.com</email>\n        </creator>\n        <date>2010-12-31T00:00:00Z</date>\n        <defaultTopConcept>false</defaultTopConcept>\n        <description>some text</description>\n        <identifier>data</identifier>\n        <polyHierarchical>false</polyHierarchical>\n        <publisher>foo</publisher>\n        <relation>DE</relation>\n        <rights>foo</rights>\n        <source>foo</source>\n        <subject>foo</subject>\n        <title>Mr</title>\n        <type>\n            <identifier>1</identifier>\n            <label>label</label>\n        </type>\n    </thesaurus>\n    <thesaurusVersions>\n        <identifier>data</identifier>\n        <date>2010-12-31T00:00:00Z</date>\n        <versionNote>1.0</versionNote>\n        <status>1</status>\n        <thisVersion>false</thisVersion>\n        <userId>root</userId>\n    </thesaurusVersions>\n</gincoExportedThesaurus>\n", service.serializeThesaurusToXmlWithJaxb(thesaurusToExport));
	}

	@Test
	public void serializeBranchToXmlWithJaxb() throws java.text.ParseException, fr.mcc.ginco.exceptions.TechnicalException {
		GincoExportedBranch branchToExport = new GincoExportedBranch();
		ThesaurusConcept rootConcept = new ThesaurusConcept();
		rootConcept.setCreated(new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31"));
		rootConcept.setIdentifier("data");
		rootConcept.setModified(new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31"));
		rootConcept.setNotation("DE");
		rootConcept.setStatus(1);
		rootConcept.setTopConcept(false);
		branchToExport.setRootConcept(rootConcept);
		ArrayList<CustomConceptAttributeType> conceptAttributeTypes =
			 new ArrayList<CustomConceptAttributeType>();
		CustomConceptAttributeType customConceptAttributeType =
			 new CustomConceptAttributeType();
		customConceptAttributeType.setExportable(false);
		customConceptAttributeType.setCode("DE");
		customConceptAttributeType.setValue("value");
		conceptAttributeTypes.add(customConceptAttributeType);
		branchToExport.setConceptAttributeTypes(conceptAttributeTypes);
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
		ArrayList<ThesaurusTerm> terms = new ArrayList<ThesaurusTerm>();
		ThesaurusTerm thesaurusTerm = new ThesaurusTerm();
		thesaurusTerm.setConcept(new ThesaurusConcept());
		thesaurusTerm.setCreated(new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31"));
		thesaurusTerm.setHidden(false);
		thesaurusTerm.setIdentifier("data");
		thesaurusTerm.setLanguage(new Language());
		thesaurusTerm.setLexicalValue("value");
		thesaurusTerm.setModified(new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31"));
		thesaurusTerm.setPrefered(false);
		thesaurusTerm.setRole(new ThesaurusTermRole());
		thesaurusTerm.setSource("foo");
		thesaurusTerm.setStatus(1);
		terms.add(thesaurusTerm);
		branchToExport.setTerms(terms);
		assertEquals("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n<gincoExportedBranch>\n    <conceptAttributeTypes>\n        <code>DE</code>\n        <value>value</value>\n        <exportable>false</exportable>\n    </conceptAttributeTypes>\n    <conceptAttributes/>\n    <concepts>\n        <identifier>data</identifier>\n        <created>2010-12-31T00:00:00Z</created>\n        <modified>2010-12-31T00:00:00Z</modified>\n        <status>1</status>\n        <notation>DE</notation>\n        <topConcept>false</topConcept>\n    </concepts>\n    <termAttributeTypes>\n        <code>DE</code>\n        <value>value</value>\n    </termAttributeTypes>\n    <termAttributes/>\n    <terms>\n        <identifier>data</identifier>\n        <lexicalValue>value</lexicalValue>\n        <created>2010-12-31T00:00:00Z</created>\n        <modified>2010-12-31T00:00:00Z</modified>\n        <source>foo</source>\n        <prefered>false</prefered>\n        <hidden>false</hidden>\n        <status>1</status>\n        <role>\n            <defaultRole>false</defaultRole>\n        </role>\n        <concept/>\n        <language>\n            <principalLanguage>false</principalLanguage>\n            <topLanguage>false</topLanguage>\n        </language>\n    </terms>\n    <alignments/>\n    <conceptNotes/>\n    <hierarchicalRelationship/>\n    <rootConcept>\n        <identifier>data</identifier>\n        <created>2010-12-31T00:00:00Z</created>\n        <modified>2010-12-31T00:00:00Z</modified>\n        <status>1</status>\n        <notation>DE</notation>\n        <topConcept>false</topConcept>\n    </rootConcept>\n    <termNotes/>\n</gincoExportedBranch>\n", service.serializeBranchToXmlWithJaxb(branchToExport));
	}
}
