package fr.mcc.ginco.extjs.view.enums;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

import org.junit.jupiter.api.Test;

/**
 * Unit tests for fr.mcc.ginco.extjs.view.enums.ClassificationFolderType
 *
 * @author Diffblue Cover
 */

class ClassificationFolderTypeTest {

	@Test
	void valuesReturnsROOTCONCEPTSSANDBOXCOMPLEXCONCEPTSORPHANSGROUPSARRAYS() {
		ClassificationFolderType[] result = ClassificationFolderType.values();
		assertThat(result[0], is(ClassificationFolderType.ROOT));
		assertThat(result[1], is(ClassificationFolderType.CONCEPTS));
		assertThat(result[2], is(ClassificationFolderType.SANDBOX));
		assertThat(result[3], is(ClassificationFolderType.COMPLEXCONCEPTS));
		assertThat(result[4], is(ClassificationFolderType.ORPHANS));
		assertThat(result[5], is(ClassificationFolderType.GROUPS));
		assertThat(result[6], is(ClassificationFolderType.ARRAYS));
	}
}
