package fr.mcc.ginco.extjs.view;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsSame.sameInstance;

import fr.mcc.ginco.extjs.view.pojo.ThesaurusConceptReducedView;

import org.junit.jupiter.api.Test;

/**
 * Unit tests for fr.mcc.ginco.extjs.view.ImportedBranchResponse
 *
 * @author Diffblue Cover
 */

class ImportedBranchResponseTest {

	@Test
	void factory() {
		ImportedBranchResponse importedBranchResponse = new ImportedBranchResponse();
		ThesaurusConceptReducedView conceptView = new ThesaurusConceptReducedView();
		conceptView.setIdentifier("data");
		conceptView.setLabel("label");
		conceptView.setLang("hello");
		importedBranchResponse.setConceptView(conceptView);
		importedBranchResponse.setTargetInternalConceptsMissing(false);
		importedBranchResponse.setTitle("Mr");
		assertThat(importedBranchResponse.getConceptView(), sameInstance(conceptView));
		assertThat(importedBranchResponse.getTitle(), is("Mr"));
		assertThat(importedBranchResponse.isTargetInternalConceptsMissing(), is(false));
	}
}
