package fr.mcc.ginco.extjs.view;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.empty;

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
		importedTermsResponse.setTermsInError(new ArrayList<String>());
		assertThat(importedTermsResponse.getTermsInError(), empty());
	}
}
