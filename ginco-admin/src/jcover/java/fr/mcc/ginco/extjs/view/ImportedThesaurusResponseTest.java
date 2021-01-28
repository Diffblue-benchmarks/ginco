package fr.mcc.ginco.extjs.view;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.Test;

/**
 * Unit tests for fr.mcc.ginco.extjs.view.ImportedThesaurusResponse
 *
 * @author Diffblue Cover
 */

class ImportedThesaurusResponseTest {

	@Test
	void factory() {
		ImportedThesaurusResponse importedThesaurusResponse =
			 new ImportedThesaurusResponse();
		ArrayList<String> conceptsMissingAlignments = new ArrayList<String>();
		conceptsMissingAlignments.add("hello");
		importedThesaurusResponse.setConceptsMissingAlignments(conceptsMissingAlignments);
		ArrayList<String> externalConceptIds = new ArrayList<String>();
		externalConceptIds.add("hello");
		importedThesaurusResponse.setExternalConceptIds(externalConceptIds);
		importedThesaurusResponse.setThesaurusTitle("Mr");
		assertThat(importedThesaurusResponse.getConceptsMissingAlignments(), equalTo(Arrays.asList("hello")));
		assertThat(importedThesaurusResponse.getExternalConceptIds(), equalTo(Arrays.asList("hello")));
		assertThat(importedThesaurusResponse.getThesaurusTitle(), is("Mr"));
	}
}
