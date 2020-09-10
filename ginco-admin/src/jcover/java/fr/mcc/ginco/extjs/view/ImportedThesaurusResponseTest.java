package fr.mcc.ginco.extjs.view;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.empty;
import static org.hamcrest.core.Is.is;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

/**
 * Unit tests for fr.mcc.ginco.extjs.view.ImportedThesaurusResponse
 *
 * @author Diffblue Cover
 */

class ImportedThesaurusResponseTest {

	@Test
	void factory() {
		ImportedThesaurusResponse importedThesaurusResponse = new ImportedThesaurusResponse();
		importedThesaurusResponse.setConceptsMissingAlignments(new ArrayList<String>());
		importedThesaurusResponse.setExternalConceptIds(new ArrayList<String>());
		importedThesaurusResponse.setThesaurusTitle("Mr");
		assertThat(importedThesaurusResponse.getConceptsMissingAlignments(), empty());
		assertThat(importedThesaurusResponse.getExternalConceptIds(), empty());
		assertThat(importedThesaurusResponse.getThesaurusTitle(), is("Mr"));
	}
}
