package fr.mcc.ginco.extjs.view;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

import java.util.ArrayList;
import java.util.Arrays;

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
		assertThat(importedTermsResponse.getTermsInError(), equalTo(Arrays.asList("foo")));
	}
}
