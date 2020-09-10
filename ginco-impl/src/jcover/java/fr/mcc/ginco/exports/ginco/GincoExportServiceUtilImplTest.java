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
import fr.mcc.ginco.beans.ThesaurusConceptGroupLabel;
import fr.mcc.ginco.exports.result.bean.GincoExportedBranch;
import fr.mcc.ginco.exports.result.bean.GincoExportedThesaurus;
import fr.mcc.ginco.exports.result.bean.JaxbList;

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
	public void serializeBranchToXmlWithJaxb() throws fr.mcc.ginco.exceptions.TechnicalException {
		GincoExportedBranch branchToExport = new GincoExportedBranch();
		HashMap<String, JaxbList<Alignment>> alignments = new HashMap<String, JaxbList<Alignment>>();
		alignments.put("foo", new JaxbList<Alignment>());
		branchToExport.setAlignments(alignments);
		HashMap<String, JaxbList<Note>> conceptNotes = new HashMap<String, JaxbList<Note>>();
		conceptNotes.put("foo", new JaxbList<Note>());
		branchToExport.setConceptNotes(conceptNotes);
		HashMap<String, JaxbList<ConceptHierarchicalRelationship>> parentConceptRelationship = new HashMap<String, JaxbList<ConceptHierarchicalRelationship>>();
		parentConceptRelationship.put("foo", new JaxbList<ConceptHierarchicalRelationship>());
		branchToExport.setHierarchicalRelationship(parentConceptRelationship);
		HashMap<String, JaxbList<Note>> termNotes = new HashMap<String, JaxbList<Note>>();
		termNotes.put("foo", new JaxbList<Note>());
		branchToExport.setTermNotes(termNotes);
		HashMap<String, JaxbList<CustomConceptAttribute>> conceptAttributes = new HashMap<String, JaxbList<CustomConceptAttribute>>();
		conceptAttributes.put("foo", new JaxbList<CustomConceptAttribute>());
		branchToExport.setConceptAttributes(conceptAttributes);
		HashMap<String, JaxbList<CustomTermAttribute>> termAttributes = new HashMap<String, JaxbList<CustomTermAttribute>>();
		termAttributes.put("foo", new JaxbList<CustomTermAttribute>());
		branchToExport.setTermAttributes(termAttributes);
		assertEquals("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n<gincoExportedBranch>\n    <conceptAttributes>\n        <entry>\n            <key>foo</key>\n            <value/>\n        </entry>\n    </conceptAttributes>\n    <termAttributes>\n        <entry>\n            <key>foo</key>\n            <value/>\n        </entry>\n    </termAttributes>\n    <alignments>\n        <entry>\n            <key>foo</key>\n            <value/>\n        </entry>\n    </alignments>\n    <conceptNotes>\n        <entry>\n            <key>foo</key>\n            <value/>\n        </entry>\n    </conceptNotes>\n    <hierarchicalRelationship>\n        <entry>\n            <key>foo</key>\n            <value/>\n        </entry>\n    </hierarchicalRelationship>\n    <rootConcept/>\n    <termNotes>\n        <entry>\n            <key>foo</key>\n            <value/>\n        </entry>\n    </termNotes>\n</gincoExportedBranch>\n", service.serializeBranchToXmlWithJaxb(branchToExport));
	}

	@Test
	public void serializeThesaurusToXmlWithJaxb() throws fr.mcc.ginco.exceptions.TechnicalException {
		GincoExportedThesaurus thesaurusToExport = new GincoExportedThesaurus();
		HashMap<String, JaxbList<Alignment>> alignments = new HashMap<String, JaxbList<Alignment>>();
		alignments.put("foo", new JaxbList<Alignment>());
		thesaurusToExport.setAlignments(alignments);
		HashMap<String, JaxbList<AssociativeRelationship>> associativeRelationship1 = new HashMap<String, JaxbList<AssociativeRelationship>>();
		associativeRelationship1.put("foo", new JaxbList<AssociativeRelationship>());
		thesaurusToExport.setAssociativeRelationship(associativeRelationship1);
		HashMap<String, JaxbList<NodeLabel>> conceptArrayLabels = new HashMap<String, JaxbList<NodeLabel>>();
		conceptArrayLabels.put("foo", new JaxbList<NodeLabel>());
		thesaurusToExport.setConceptArrayLabels(conceptArrayLabels);
		HashMap<String, JaxbList<ThesaurusConceptGroupLabel>> conceptGroupLabels = new HashMap<String, JaxbList<ThesaurusConceptGroupLabel>>();
		conceptGroupLabels.put("foo", new JaxbList<ThesaurusConceptGroupLabel>());
		thesaurusToExport.setConceptGroupLabels(conceptGroupLabels);
		HashMap<String, JaxbList<Note>> conceptNotes = new HashMap<String, JaxbList<Note>>();
		conceptNotes.put("foo", new JaxbList<Note>());
		thesaurusToExport.setConceptNotes(conceptNotes);
		HashMap<String, JaxbList<ConceptHierarchicalRelationship>> parentConceptRelationship = new HashMap<String, JaxbList<ConceptHierarchicalRelationship>>();
		parentConceptRelationship.put("foo", new JaxbList<ConceptHierarchicalRelationship>());
		thesaurusToExport.setHierarchicalRelationship(parentConceptRelationship);
		HashMap<String, JaxbList<Note>> termNotes = new HashMap<String, JaxbList<Note>>();
		termNotes.put("foo", new JaxbList<Note>());
		thesaurusToExport.setTermNotes(termNotes);
		thesaurusToExport.setThesaurus(new Thesaurus());
		HashMap<String, JaxbList<CustomConceptAttribute>> conceptAttributes = new HashMap<String, JaxbList<CustomConceptAttribute>>();
		conceptAttributes.put("foo", new JaxbList<CustomConceptAttribute>());
		thesaurusToExport.setConceptAttributes(conceptAttributes);
		HashMap<String, JaxbList<CustomTermAttribute>> termAttributes = new HashMap<String, JaxbList<CustomTermAttribute>>();
		termAttributes.put("foo", new JaxbList<CustomTermAttribute>());
		thesaurusToExport.setTermAttributes(termAttributes);
		assertEquals("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n<gincoExportedThesaurus>\n    <conceptAttributes>\n        <entry>\n            <key>foo</key>\n            <value/>\n        </entry>\n    </conceptAttributes>\n    <termAttributes>\n        <entry>\n            <key>foo</key>\n            <value/>\n        </entry>\n    </termAttributes>\n    <alignments>\n        <entry>\n            <key>foo</key>\n            <value/>\n        </entry>\n    </alignments>\n    <associativeRelationship>\n        <entry>\n            <key>foo</key>\n            <value/>\n        </entry>\n    </associativeRelationship>\n    <conceptArrayLabels>\n        <entry>\n            <key>foo</key>\n            <value/>\n        </entry>\n    </conceptArrayLabels>\n    <conceptGroupLabels>\n        <entry>\n            <key>foo</key>\n            <value/>\n        </entry>\n    </conceptGroupLabels>\n    <conceptNotes>\n        <entry>\n            <key>foo</key>\n            <value/>\n        </entry>\n    </conceptNotes>\n    <hierarchicalRelationship>\n        <entry>\n            <key>foo</key>\n            <value/>\n        </entry>\n    </hierarchicalRelationship>\n    <termNotes>\n        <entry>\n            <key>foo</key>\n            <value/>\n        </entry>\n    </termNotes>\n    <thesaurus>\n        <source></source>\n    </thesaurus>\n</gincoExportedThesaurus>\n", service.serializeThesaurusToXmlWithJaxb(thesaurusToExport));
	}
}
