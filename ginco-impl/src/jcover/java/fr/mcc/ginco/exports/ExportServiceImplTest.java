package fr.mcc.ginco.exports;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import fr.mcc.ginco.beans.SplitNonPreferredTerm;
import fr.mcc.ginco.beans.Thesaurus;
import fr.mcc.ginco.beans.ThesaurusArray;
import fr.mcc.ginco.beans.ThesaurusConcept;
import fr.mcc.ginco.exports.result.bean.FormattedLine;
import fr.mcc.ginco.helpers.ThesaurusArrayHelper;
import fr.mcc.ginco.services.INodeLabelService;
import fr.mcc.ginco.services.ISplitNonPreferredTermService;
import fr.mcc.ginco.services.IThesaurusArrayService;
import fr.mcc.ginco.services.IThesaurusConceptService;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

/**
 * Unit tests for fr.mcc.ginco.exports.ExportServiceImpl
 *
 * @author Diffblue Cover
 */

public class ExportServiceImplTest {

	@Mock(name = "alphabeticalExportedItemComparator")
	private AlphabeticalExportedItemComparator alphabeticalExportedItemComparator;

	@Mock(name = "alphabeticComplexConceptExporter")
	private AlphabeticComplexConceptExporter alphabeticComplexConceptExporter;

	@Mock(name = "alphabeticConceptExporter")
	private AlphabeticConceptExporter alphabeticConceptExporter;

	@Mock(name = "arrayNaturalComparator")
	private ArrayNaturalComparator arrayNaturalComparator;

	@Mock(name = "nodeLabelComparator")
	private NodeLabelComparator nodeLabelComparator;

	@Mock(name = "nodeLabelService")
	private INodeLabelService nodeLabelService;

	@Mock(name = "splitNonPreferredTermService")
	private ISplitNonPreferredTermService splitNonPreferredTermService;

	@Mock(name = "thesaurusArrayHelper")
	private ThesaurusArrayHelper thesaurusArrayHelper;

	@Mock(name = "thesaurusArrayService")
	private IThesaurusArrayService thesaurusArrayService;

	@Mock(name = "thesaurusConceptComparator")
	private ThesaurusConceptComparator thesaurusConceptComparator;

	@Mock(name = "thesaurusConceptService")
	private IThesaurusConceptService thesaurusConceptService;

	@InjectMocks
	private ExportServiceImpl service;

	@Before public void initMocks() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void getHierarchicalText1() {
		List<ThesaurusConcept> list1 = new ArrayList<ThesaurusConcept>();
		ThesaurusConcept thesaurusConcept1 = new ThesaurusConcept();
		thesaurusConcept1.setIdentifier("data");
		list1.add(thesaurusConcept1);
		when(thesaurusConceptService.getTopTermThesaurusConcepts(Mockito.<String>any()))
			.thenReturn(list1);
		List<ThesaurusArray> list3 = new ArrayList<ThesaurusArray>();
		list3.add(new ThesaurusArray());
		when(thesaurusArrayService.getArraysWithoutParentArray(Mockito.<String>any()))
			.thenReturn(new ArrayList<ThesaurusArray>());
		when(thesaurusArrayService.getArraysWithoutParentConcept(Mockito.<String>any()))
			.thenReturn(list3);
		List<ThesaurusConcept> list4 = new ArrayList<ThesaurusConcept>();
		ThesaurusConcept thesaurusConcept2 = new ThesaurusConcept();
		thesaurusConcept2.setIdentifier("data");
		list4.add(thesaurusConcept2);
		when(thesaurusArrayHelper.getArrayConcepts(Mockito.<String>any()))
			.thenReturn(list4);
		assertTrue((service.getHierarchicalText(new Thesaurus())).isEmpty());
	}

	@Test
	public void getHierarchicalText2() {
		List<ThesaurusConcept> list1 = new ArrayList<ThesaurusConcept>();
		ThesaurusConcept thesaurusConcept1 = new ThesaurusConcept();
		thesaurusConcept1.setIdentifier("data");
		list1.add(thesaurusConcept1);
		when(thesaurusConceptService.getTopTermThesaurusConcepts(Mockito.<String>any()))
			.thenReturn(list1);
		List<ThesaurusArray> list2 = new ArrayList<ThesaurusArray>();
		ThesaurusArray thesaurusArray1 = mock(ThesaurusArray.class);
		list2.add(thesaurusArray1);
		List<ThesaurusArray> list3 = new ArrayList<ThesaurusArray>();
		list3.add(new ThesaurusArray());
		when(thesaurusArrayService.getArraysWithoutParentArray(Mockito.<String>any()))
			.thenReturn(list2);
		when(thesaurusArrayService.getArraysWithoutParentConcept(Mockito.<String>any()))
			.thenReturn(list3);
		List<ThesaurusConcept> list4 = new ArrayList<ThesaurusConcept>();
		ThesaurusConcept thesaurusConcept2 = new ThesaurusConcept();
		thesaurusConcept2.setIdentifier("data");
		list4.add(thesaurusConcept2);
		when(thesaurusArrayHelper.getArrayConcepts(Mockito.<String>any()))
			.thenReturn(list4);
		assertTrue((service.getHierarchicalText(new Thesaurus())).isEmpty());
	}

	@Test
	public void getAlphabeticalText1() {
		when(thesaurusConceptService.getConceptsByThesaurusId(Mockito.<String>any(), Mockito.<String>any(), Mockito.<Boolean>any(), Mockito.<Boolean>any()))
			.thenReturn(new ArrayList<ThesaurusConcept>());
		List<SplitNonPreferredTerm> list2 = new ArrayList<SplitNonPreferredTerm>();
		list2.add(new SplitNonPreferredTerm());
		when(splitNonPreferredTermService.getSplitNonPreferredTermCount(Mockito.<String>any()))
			.thenReturn(1L);
		when(splitNonPreferredTermService.getSplitNonPreferredTermList(Mockito.<Integer>any(), Mockito.<Integer>any(), Mockito.<String>any()))
			.thenReturn(list2);
		assertTrue((service.getAlphabeticalText(new Thesaurus())).isEmpty());
		Mockito.verify(alphabeticComplexConceptExporter).addComplexConceptInfo(Mockito.eq((Integer) 1), Mockito.<List<FormattedLine>>any(), Mockito.<SplitNonPreferredTerm>any());
		Mockito.verify(alphabeticComplexConceptExporter).addComplexConceptTitle(Mockito.eq((Integer) 0), Mockito.<List<FormattedLine>>any(), Mockito.<SplitNonPreferredTerm>any());
	}

	@Test
	public void getAlphabeticalText2() {

		// arrange
		List<ThesaurusConcept> list1 = new ArrayList<ThesaurusConcept>();
		list1.add(new ThesaurusConcept());
		when(thesaurusConceptService.getConceptTitle(Mockito.<ThesaurusConcept>any()))
			.thenReturn("foo=bar")
			.thenReturn("foo=bar");
		when(thesaurusConceptService.getConceptsByThesaurusId(Mockito.<String>any(), Mockito.<String>any(), Mockito.<Boolean>any(), Mockito.<Boolean>any()))
			.thenReturn(list1);
		List<SplitNonPreferredTerm> list2 = new ArrayList<SplitNonPreferredTerm>();
		list2.add(new SplitNonPreferredTerm());
		when(splitNonPreferredTermService.getSplitNonPreferredTermCount(Mockito.<String>any()))
			.thenReturn(1L);
		when(splitNonPreferredTermService.getSplitNonPreferredTermList(Mockito.<Integer>any(), Mockito.<Integer>any(), Mockito.<String>any()))
			.thenReturn(list2);
		when(alphabeticalExportedItemComparator.compare(Mockito.<fr.mcc.ginco.exports.result.bean.AlphabeticalExportedItem>any(), Mockito.<fr.mcc.ginco.exports.result.bean.AlphabeticalExportedItem>any()))
			.thenReturn(1);

		// act
		List<FormattedLine> result = service.getAlphabeticalText(new Thesaurus());

		// assert
		assertEquals(1, result.size());
		assertEquals(0, (int) result.get(0).getTabs());
		assertEquals("foo=bar", result.get(0).getText());
		Mockito.verify(alphabeticConceptExporter).addConceptInfo(Mockito.eq((Integer) 1), Mockito.<List<FormattedLine>>any(), Mockito.<ThesaurusConcept>any());
		Mockito.verify(alphabeticComplexConceptExporter).addComplexConceptInfo(Mockito.eq((Integer) 1), Mockito.<List<FormattedLine>>any(), Mockito.<SplitNonPreferredTerm>any());
		Mockito.verify(alphabeticComplexConceptExporter).addComplexConceptTitle(Mockito.eq((Integer) 0), Mockito.<List<FormattedLine>>any(), Mockito.<SplitNonPreferredTerm>any());
	}
}