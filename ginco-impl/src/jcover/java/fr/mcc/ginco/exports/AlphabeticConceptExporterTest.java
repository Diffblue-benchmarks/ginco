package fr.mcc.ginco.exports;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import fr.mcc.ginco.beans.Note;
import fr.mcc.ginco.beans.NoteType;
import fr.mcc.ginco.beans.ThesaurusConcept;
import fr.mcc.ginco.beans.ThesaurusTerm;
import fr.mcc.ginco.beans.ThesaurusTermRole;
import fr.mcc.ginco.exports.result.bean.FormattedLine;
import fr.mcc.ginco.services.IAssociativeRelationshipService;
import fr.mcc.ginco.services.INoteService;
import fr.mcc.ginco.services.IThesaurusConceptService;
import fr.mcc.ginco.services.IThesaurusTermRoleService;
import fr.mcc.ginco.services.IThesaurusTermService;
import fr.mcc.ginco.utils.ThesaurusTermUtils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

/**
 * Unit tests for fr.mcc.ginco.exports.AlphabeticConceptExporter
 *
 * @author Diffblue Cover
 */

public class AlphabeticConceptExporterTest {

	@Mock(name = "associativeRelationshipService")
	private IAssociativeRelationshipService associativeRelationshipService;

	@Mock(name = "noteService")
	private INoteService noteService;

	@Mock(name = "thesaurusConceptService")
	private IThesaurusConceptService thesaurusConceptService;

	@Mock(name = "thesaurusTermRoleService")
	private IThesaurusTermRoleService thesaurusTermRoleService;

	@Mock(name = "thesaurusTermService")
	private IThesaurusTermService thesaurusTermService;

	@Mock(name = "thesaurusTermUtils")
	private ThesaurusTermUtils thesaurusTermUtils;

	@InjectMocks
	private AlphabeticConceptExporter service;

	@Before public void initMocks() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void addConceptInfoBaseIsOne() {

		// arrange
		when(thesaurusTermUtils.generatePrefTermText(Mockito.<ThesaurusTerm>any()))
			.thenReturn("foo")
			.thenReturn("foo")
			.thenReturn("foo");
		when(thesaurusTermUtils.generatePrefTermsText(Mockito.<List<ThesaurusTerm>>any()))
			.thenReturn("foo");
		List<ThesaurusTerm> list1 = new ArrayList<ThesaurusTerm>();
		ThesaurusTerm thesaurusTerm1 = new ThesaurusTerm();
		thesaurusTerm1.setPrefered(false);
		list1.add(thesaurusTerm1);
		when(thesaurusTermService.getTermsByConceptId(Mockito.<String>any()))
			.thenReturn(list1);
		List<ThesaurusTerm> list2 = new ArrayList<ThesaurusTerm>();
		ThesaurusTerm thesaurusTerm2 = new ThesaurusTerm();
		ThesaurusTermRole role2 = new ThesaurusTermRole();
		role2.setCode("DE");
		thesaurusTerm2.setRole(role2);
		list2.add(thesaurusTerm2);
		List<ThesaurusConcept> list3 = new ArrayList<ThesaurusConcept>();
		list3.add(new ThesaurusConcept());
		List<ThesaurusTerm> list4 = new ArrayList<ThesaurusTerm>();
		list4.add(new ThesaurusTerm());
		when(thesaurusConceptService.getChildrenByConceptId(Mockito.<String>any(), Mockito.<String>any()))
			.thenReturn(list3);
		when(thesaurusConceptService.getConceptNotPreferredTerms(Mockito.<String>any()))
			.thenReturn(list2);
		when(thesaurusConceptService.getConceptPreferredTerm(Mockito.<String>any()))
			.thenReturn(new ThesaurusTerm());
		when(thesaurusConceptService.getConceptPreferredTerms(Mockito.<String>any()))
			.thenReturn(list4);
		when(thesaurusConceptService.getThesaurusConceptList(Mockito.<List<String>>any()))
			.thenReturn(new HashSet<ThesaurusConcept>());
		List<Note> list5 = new ArrayList<Note>();
		Note note1 = new Note();
		note1.setNoteType(new NoteType());
		list5.add(note1);
		List<Note> list6 = new ArrayList<Note>();
		Note note2 = new Note();
		note2.setNoteType(new NoteType());
		list6.add(note2);
		List<Note> list7 = new ArrayList<Note>();
		Note note3 = new Note();
		note3.setNoteType(new NoteType());
		note3.setTerm(new ThesaurusTerm());
		list7.add(note3);
		when(noteService.getConceptNotePaginatedList(Mockito.<String>any(), Mockito.<Integer>any(), Mockito.<Integer>any()))
			.thenReturn(list7);
		when(noteService.getTermNotePaginatedList(Mockito.<String>any(), Mockito.<Integer>any(), Mockito.<Integer>any()))
			.thenReturn(list6)
			.thenReturn(list5);
		when(associativeRelationshipService.getAssociatedConceptsId(Mockito.<ThesaurusConcept>any()))
			.thenReturn(new ArrayList<String>());
		ArrayList<FormattedLine> result = new ArrayList<FormattedLine>();
		result.add(new FormattedLine(1, "hello"));
		ThesaurusConcept concept11 = new ThesaurusConcept();
		concept11.setNotation("DE");

		// act
		service.addConceptInfo(1, result, concept11);

		// assert
		assertEquals(6, result.size());
		assertEquals(1, (int) result.get(1).getTabs());
		assertEquals("CC: DE", result.get(1).getText());
		assertEquals(1, (int) result.get(2).getTabs());
		assertEquals("EP: foo", result.get(2).getText());
		assertEquals(1, (int) result.get(3).getTabs());
		assertEquals("TS: foo", result.get(3).getText());
		assertEquals(0, (int) result.get(4).getTabs());
		assertEquals("foo", result.get(4).getText());
		assertEquals(1, (int) result.get(5).getTabs());
		assertEquals("DE: foo", result.get(5).getText());
	}
}
