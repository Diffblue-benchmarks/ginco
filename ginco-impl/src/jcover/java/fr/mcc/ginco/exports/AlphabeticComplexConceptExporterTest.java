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

	@Before public void initMocks() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void addComplexConceptInfoBaseIsOneAndResultIsEmpty() {

		// arrange
		ArrayList<FormattedLine> result = new ArrayList<FormattedLine>();

		// act
		service.addComplexConceptInfo(1, result, new SplitNonPreferredTerm());

		// assert
		assertEquals(1, result.size());
		assertEquals(1, (int) result.get(0).getTabs());
		assertEquals("E", result.get(0).getText());
	}

	@Test
	public void addComplexConceptTitleBaseIsOneAndResultIsEmpty() {

		// arrange
		ArrayList<FormattedLine> result = new ArrayList<FormattedLine>();
		SplitNonPreferredTerm complexConcept = new SplitNonPreferredTerm();
		complexConcept.setLexicalValue("value");

		// act
		service.addComplexConceptTitle(1, result, complexConcept);

		// assert
		assertEquals(1, result.size());
		assertEquals(1, (int) result.get(0).getTabs());
		assertEquals("value", result.get(0).getText());
	}
}
