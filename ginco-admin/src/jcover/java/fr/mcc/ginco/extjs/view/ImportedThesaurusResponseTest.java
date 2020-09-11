package fr.mcc.ginco.extjs.view;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
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
		ImportedThesaurusResponse importedThesaurusResponse =
			 new ImportedThesaurusResponse();
		ArrayList<String> conceptsMissingAlignments = new ArrayList<String>();
		conceptsMissingAlignments.add("hello");
		importedThesaurusResponse.setConceptsMissingAlignments(conceptsMissingAlignments);
		ArrayList<String> externalConceptIds = new ArrayList<String>();
		externalConceptIds.add("hello");
		importedThesaurusResponse.setExternalConceptIds(externalConceptIds);
		importedThesaurusResponse.setThesaurusTitle("Mr");
		assertThat(importedThesaurusResponse.getConceptsMissingAlignments(), hasSize(1));
		assertThat(importedThesaurusResponse.getConceptsMissingAlignments().get(0), is("hello"));
		assertThat(importedThesaurusResponse.getExternalConceptIds(), hasSize(1));
		assertThat(importedThesaurusResponse.getExternalConceptIds().get(0), is("hello"));
		assertThat(importedThesaurusResponse.getThesaurusTitle(), is("Mr"));
	}
}
