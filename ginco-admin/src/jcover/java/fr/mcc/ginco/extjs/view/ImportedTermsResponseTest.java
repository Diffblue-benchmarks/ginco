package fr.mcc.ginco.extjs.view;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.hamcrest.core.Is.is;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

/**
 * Unit tests for fr.mcc.ginco.extjs.view.ImportedTermsResponse
 *
 * @author Diffblue Cover
 */

class ImportedTermsResponseTest {

	@Test
	void factory() {
		ImportedTermsResponse importedTermsResponse = new ImportedTermsResponse();
		ArrayList<String> termsInError = new ArrayList<String>();
		termsInError.add("foo");
		importedTermsResponse.setTermsInError(termsInError);
		assertThat(importedTermsResponse.getTermsInError(), hasSize(1));
		assertThat(importedTermsResponse.getTermsInError().get(0), is("foo"));
	}
}
