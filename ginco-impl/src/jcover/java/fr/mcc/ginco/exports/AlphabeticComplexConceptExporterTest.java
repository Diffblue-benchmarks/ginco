package fr.mcc.ginco.exports;

import static org.junit.Assert.assertEquals;

import fr.mcc.ginco.beans.SplitNonPreferredTerm;
import fr.mcc.ginco.exports.result.bean.FormattedLine;
import fr.mcc.ginco.utils.ThesaurusTermUtils;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

/**
 * Unit tests for fr.mcc.ginco.exports.AlphabeticComplexConceptExporter
 *
 * @author Diffblue Cover
 */

public class AlphabeticComplexConceptExporterTest {

	@Mock(name = "alphabeticalExportedItemComparator")
	private AlphabeticalExportedItemComparator alphabeticalExportedItemComparator;

	@Mock(name = "thesaurusTermUtils")
	private ThesaurusTermUtils thesaurusTermUtils;

	@InjectMocks
	private AlphabeticComplexConceptExporter service;

	@Before
	public void initMocks() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void addComplexConceptTitleBaseIsOne() {

		// arrange
		ArrayList<FormattedLine> result = new ArrayList<FormattedLine>();
		result.add(new FormattedLine(1, "hello"));
		SplitNonPreferredTerm complexConcept = new SplitNonPreferredTerm();
		complexConcept.setLexicalValue("value");

		// act
		service.addComplexConceptTitle(1, result, complexConcept);

		// assert
		assertEquals(2, result.size());
		assertEquals(1, (int) result.get(1).getTabs());
		assertEquals("value", result.get(1).getText());
	}

	@Test
	public void addComplexConceptInfoBaseIsOne() {

		// arrange
		ArrayList<FormattedLine> result = new ArrayList<FormattedLine>();
		result.add(new FormattedLine(1, "hello"));

		// act
		service.addComplexConceptInfo(1, result, new SplitNonPreferredTerm());

		// assert
		assertEquals(2, result.size());
		assertEquals(1, (int) result.get(1).getTabs());
		assertEquals("E", result.get(1).getText());
	}
}
