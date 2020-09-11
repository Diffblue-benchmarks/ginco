package fr.mcc.ginco.exports.ginco;

import static org.junit.Assert.assertEquals;

import fr.mcc.ginco.beans.Alignment;
import fr.mcc.ginco.beans.AssociativeRelationship;
import fr.mcc.ginco.beans.ConceptHierarchicalRelationship;
import fr.mcc.ginco.beans.CustomConceptAttribute;
import fr.mcc.ginco.beans.CustomTermAttribute;
import fr.mcc.ginco.beans.NodeLabel;
import fr.mcc.ginco.beans.Note;
import fr.mcc.ginco.beans.Thesaurus;
import fr.mcc.ginco.beans.ThesaurusConcept;
import fr.mcc.ginco.beans.ThesaurusConceptGroupLabel;
import fr.mcc.ginco.beans.ThesaurusOrganization;
import fr.mcc.ginco.beans.ThesaurusType;
import fr.mcc.ginco.exports.result.bean.GincoExportedBranch;
import fr.mcc.ginco.exports.result.bean.GincoExportedThesaurus;
import fr.mcc.ginco.exports.result.bean.JaxbList;

import java.text.SimpleDateFormat;
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
		HashMap<String, JaxbList<CustomConceptAttribute>> conceptAttributes =
			 new HashMap<String, JaxbList<CustomConceptAttribute>>();
		conceptAttributes.put("foo", new JaxbList<CustomConceptAttribute>());
		branchToExport.setConceptAttributes(conceptAttributes);
		HashMap<String, JaxbList<CustomTermAttribute>> termAttributes =
			 new HashMap<String, JaxbList<CustomTermAttribute>>();
		termAttributes.put("foo", new JaxbList<CustomTermAttribute>());
		branchToExport.setTermAttributes(termAttributes);
		assertEquals("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n<gincoExportedBranch>\n    <conceptAttributes>\n        <entry>\n            <key>foo</key>\n            <value/>\n        </entry>\n    </conceptAttributes>\n    <termAttributes>\n        <entry>\n            <key>foo</key>\n            <value/>\n        </entry>\n    </termAttributes>\n    <alignments>\n        <entry>\n            <key>foo</key>\n            <value/>\n        </entry>\n    </alignments>\n    <conceptNotes>\n        <entry>\n            <key>foo</key>\n            <value/>\n        </entry>\n    </conceptNotes>\n    <hierarchicalRelationship>\n        <entry>\n            <key>foo</key>\n            <value/>\n        </entry>\n    </hierarchicalRelationship>\n    <rootConcept>\n        <identifier>data</identifier>\n        <created>2010-12-31T00:00:00Z</created>\n        <modified>2010-12-31T00:00:00Z</modified>\n        <status>1</status>\n        <notation>DE</notation>\n        <topConcept>false</topConcept>\n    </rootConcept>\n    <termNotes>\n        <entry>\n            <key>foo</key>\n            <value/>\n        </entry>\n    </termNotes>\n</gincoExportedBranch>\n", service.serializeBranchToXmlWithJaxb(branchToExport));
	}

	@Test
	public void serializeThesaurusToXmlWithJaxb() throws java.text.ParseException, fr.mcc.ginco.exceptions.TechnicalException {
		GincoExportedThesaurus thesaurusToExport = new GincoExportedThesaurus();
		HashMap<String, JaxbList<Alignment>> alignments =
			 new HashMap<String, JaxbList<Alignment>>();
		alignments.put("foo", new JaxbList<Alignment>());
		thesaurusToExport.setAlignments(alignments);
		HashMap<String, JaxbList<AssociativeRelationship>> associativeRelationship =
			 new HashMap<String, JaxbList<AssociativeRelationship>>();
		associativeRelationship.put("foo", new JaxbList<AssociativeRelationship>());
		thesaurusToExport.setAssociativeRelationship(associativeRelationship);
		HashMap<String, JaxbList<NodeLabel>> conceptArrayLabels =
			 new HashMap<String, JaxbList<NodeLabel>>();
		conceptArrayLabels.put("foo", new JaxbList<NodeLabel>());
		thesaurusToExport.setConceptArrayLabels(conceptArrayLabels);
		HashMap<String, JaxbList<ThesaurusConceptGroupLabel>> conceptGroupLabels =
			 new HashMap<String, JaxbList<ThesaurusConceptGroupLabel>>();
		conceptGroupLabels.put("foo", new JaxbList<ThesaurusConceptGroupLabel>());
		thesaurusToExport.setConceptGroupLabels(conceptGroupLabels);
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
		HashMap<String, JaxbList<CustomConceptAttribute>> conceptAttributes =
			 new HashMap<String, JaxbList<CustomConceptAttribute>>();
		conceptAttributes.put("foo", new JaxbList<CustomConceptAttribute>());
		thesaurusToExport.setConceptAttributes(conceptAttributes);
		HashMap<String, JaxbList<CustomTermAttribute>> termAttributes =
			 new HashMap<String, JaxbList<CustomTermAttribute>>();
		termAttributes.put("foo", new JaxbList<CustomTermAttribute>());
		thesaurusToExport.setTermAttributes(termAttributes);
		assertEquals("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n<gincoExportedThesaurus>\n    <conceptAttributes>\n        <entry>\n            <key>foo</key>\n            <value/>\n        </entry>\n    </conceptAttributes>\n    <termAttributes>\n        <entry>\n            <key>foo</key>\n            <value/>\n        </entry>\n    </termAttributes>\n    <alignments>\n        <entry>\n            <key>foo</key>\n            <value/>\n        </entry>\n    </alignments>\n    <associativeRelationship>\n        <entry>\n            <key>foo</key>\n            <value/>\n        </entry>\n    </associativeRelationship>\n    <conceptArrayLabels>\n        <entry>\n            <key>foo</key>\n            <value/>\n        </entry>\n    </conceptArrayLabels>\n    <conceptGroupLabels>\n        <entry>\n            <key>foo</key>\n            <value/>\n        </entry>\n    </conceptGroupLabels>\n    <conceptNotes>\n        <entry>\n            <key>foo</key>\n            <value/>\n        </entry>\n    </conceptNotes>\n    <hierarchicalRelationship>\n        <entry>\n            <key>foo</key>\n            <value/>\n        </entry>\n    </hierarchicalRelationship>\n    <termNotes>\n        <entry>\n            <key>foo</key>\n            <value/>\n        </entry>\n    </termNotes>\n    <thesaurus>\n        <archived>false</archived>\n        <contributor>foo</contributor>\n        <coverage>foo</coverage>\n        <created>2010-12-31T00:00:00Z</created>\n        <creator>\n            <name>Acme</name>\n            <homepage>foo</homepage>\n            <email>info@diffblue.com</email>\n        </creator>\n        <date>2010-12-31T00:00:00Z</date>\n        <defaultTopConcept>false</defaultTopConcept>\n        <description>some text</description>\n        <identifier>data</identifier>\n        <polyHierarchical>false</polyHierarchical>\n        <publisher>foo</publisher>\n        <relation>DE</relation>\n        <rights>foo</rights>\n        <source>foo</source>\n        <subject>foo</subject>\n        <title>Mr</title>\n        <type>\n            <identifier>1</identifier>\n            <label>label</label>\n        </type>\n    </thesaurus>\n</gincoExportedThesaurus>\n", service.serializeThesaurusToXmlWithJaxb(thesaurusToExport));
	}
}
