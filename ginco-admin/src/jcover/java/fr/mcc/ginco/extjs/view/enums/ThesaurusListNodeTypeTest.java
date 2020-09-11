package fr.mcc.ginco.extjs.view.enums;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

import org.junit.jupiter.api.Test;

/**
 * Unit tests for fr.mcc.ginco.extjs.view.enums.ThesaurusListNodeType
 *
 * @author Diffblue Cover
 */

class ThesaurusListNodeTypeTest {

	@Test
	void valuesReturnsThesaurusFolderConceptArraysGroupsWarning() {
		ThesaurusListNodeType[] result = ThesaurusListNodeType.values();
		assertThat(result[0], is(ThesaurusListNodeType.THESAURUS));
		assertThat(result[1], is(ThesaurusListNodeType.FOLDER));
		assertThat(result[2], is(ThesaurusListNodeType.CONCEPT));
		assertThat(result[3], is(ThesaurusListNodeType.ARRAYS));
		assertThat(result[4], is(ThesaurusListNodeType.GROUPS));
		assertThat(result[5], is(ThesaurusListNodeType.WARNING));
	}
}
