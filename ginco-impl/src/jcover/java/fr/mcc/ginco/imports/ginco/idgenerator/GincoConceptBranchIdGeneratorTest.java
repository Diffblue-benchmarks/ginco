package fr.mcc.ginco.imports.ginco.idgenerator;

import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.when;

import fr.mcc.ginco.beans.Alignment;
import fr.mcc.ginco.beans.ConceptHierarchicalRelationship;
import fr.mcc.ginco.beans.CustomConceptAttribute;
import fr.mcc.ginco.beans.CustomTermAttribute;
import fr.mcc.ginco.beans.Note;
import fr.mcc.ginco.beans.ThesaurusConcept;
import fr.mcc.ginco.beans.ThesaurusTerm;
import fr.mcc.ginco.exports.result.bean.GincoExportedBranch;
import fr.mcc.ginco.exports.result.bean.JaxbList;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

/**
 * Unit tests for fr.mcc.ginco.imports.ginco.idgenerator.GincoConceptBranchIdGenerator
 *
 * @author Diffblue Cover
 */

public class GincoConceptBranchIdGeneratorTest {

	@Mock(name = "gincoAlignmentIdGenerator")
	private GincoAlignmentIdGenerator gincoAlignmentIdGenerator;

	@Mock(name = "gincoConceptIdGenerator")
	private GincoConceptIdGenerator gincoConceptIdGenerator;

	@Mock(name = "gincoCustomAttrIdGenerator")
	private GincoCustomAttributesIdGenerator gincoCustomAttrIdGenerator;

	@Mock(name = "gincoNoteIdGenerator")
	private GincoNoteIdGenerator gincoNoteIdGenerator;

	@Mock(name = "gincoRelationshipIdGenerator")
	private GincoRelationshipIdGenerator gincoRelationshipIdGenerator;

	@Mock(name = "gincoTermIdGenerator")
	private GincoTermIdGenerator gincoTermIdGenerator;

	@InjectMocks
	private GincoConceptBranchIdGenerator service;

	@Before public void initMocks() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void resetIdsForExportedBranch() {

		// arrange
		when(gincoTermIdGenerator.getIdForTerm(Mockito.<String>any(), Mockito.<Map<String, String>>any()))
			.thenReturn("1234");
		Map<String, JaxbList<ConceptHierarchicalRelationship>> map1 =
			 new HashMap<String, JaxbList<ConceptHierarchicalRelationship>>();
		JaxbList<ConceptHierarchicalRelationship> x505 =
			 new JaxbList<ConceptHierarchicalRelationship>();
		map1.put("HmacMD5", x505);
		when(gincoRelationshipIdGenerator.getIdsForHierarchicalRelations(Mockito.<Map<String, JaxbList<ConceptHierarchicalRelationship>>>any(), Mockito.<Map<String, String>>any()))
			.thenReturn(map1);
		Map<String, JaxbList<Note>> map2 = new HashMap<String, JaxbList<Note>>();
		JaxbList<Note> x391 = new JaxbList<Note>();
		map2.put("HmacMD5", x391);
		Map<String, JaxbList<Note>> map3 = new HashMap<String, JaxbList<Note>>();
		JaxbList<Note> x264 = new JaxbList<Note>();
		map3.put("HmacMD5", x264);
		when(gincoNoteIdGenerator.getNotesWithNewIds(Mockito.<Map<String, JaxbList<Note>>>any(), Mockito.<Map<String, String>>any()))
			.thenReturn(map3)
			.thenReturn(map2);
		Map<String, JaxbList<CustomTermAttribute>> map4 =
			 new HashMap<String, JaxbList<CustomTermAttribute>>();
		JaxbList<CustomTermAttribute> x753 = new JaxbList<CustomTermAttribute>();
		map4.put("HmacMD5", x753);
		Map<String, JaxbList<CustomConceptAttribute>> map5 =
			 new HashMap<String, JaxbList<CustomConceptAttribute>>();
		JaxbList<CustomConceptAttribute> x671 =
			 new JaxbList<CustomConceptAttribute>();
		map5.put("HmacMD5", x671);
		when(gincoCustomAttrIdGenerator.getIdsForCustomConceptAttributes(Mockito.<Map<String, JaxbList<CustomConceptAttribute>>>any(), Mockito.<Map<String, String>>any()))
			.thenReturn(map5);
		when(gincoCustomAttrIdGenerator.getIdsForCustomTermAttributes(Mockito.<Map<String, JaxbList<CustomTermAttribute>>>any(), Mockito.<Map<String, String>>any()))
			.thenReturn(map4);
		when(gincoConceptIdGenerator.getIdForConcept(Mockito.<String>any(), Mockito.<Map<String, String>>any()))
			.thenReturn("1234")
			.thenReturn("1234")
			.thenReturn("1234");
		Map<String, JaxbList<Alignment>> map6 =
			 new HashMap<String, JaxbList<Alignment>>();
		JaxbList<Alignment> x533 = new JaxbList<Alignment>();
		map6.put("HmacMD5", x533);
		when(gincoAlignmentIdGenerator.getIdsForAlignments(Mockito.<Map<String, JaxbList<Alignment>>>any(), Mockito.<Map<String, String>>any()))
			.thenReturn(map6);
		GincoExportedBranch branchToUpdate = new GincoExportedBranch();
		ArrayList<ThesaurusConcept> concepts = new ArrayList<ThesaurusConcept>();
		concepts.add(new ThesaurusConcept());
		branchToUpdate.setConcepts(concepts);
		ArrayList<ThesaurusTerm> terms = new ArrayList<ThesaurusTerm>();
		ThesaurusTerm thesaurusTerm = new ThesaurusTerm();
		thesaurusTerm.setConcept(new ThesaurusConcept());
		terms.add(thesaurusTerm);
		branchToUpdate.setTerms(terms);

		// act
		service.resetIdsForExportedBranch(branchToUpdate);

		// assert
		assertSame(x533, branchToUpdate.getAlignments().get("HmacMD5"));
		assertSame(x264, branchToUpdate.getConceptNotes().get("HmacMD5"));
		assertSame(x505, branchToUpdate.getHierarchicalRelationship().get("HmacMD5"));
		assertSame(x391, branchToUpdate.getTermNotes().get("HmacMD5"));
		assertSame(x671, branchToUpdate.getConceptAttributes().get("HmacMD5"));
		assertSame(x753, branchToUpdate.getTermAttributes().get("HmacMD5"));
	}
}
