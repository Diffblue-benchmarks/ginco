package fr.mcc.ginco.beans;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

import org.junit.jupiter.api.Test;

/**
 * Unit tests for fr.mcc.ginco.beans.ThesaurusConceptGroupType
 *
 * @author Diffblue Cover
 */

class ThesaurusConceptGroupTypeTest {

	@Test
	void factory() {
		ThesaurusConceptGroupType thesaurusConceptGroupType = new ThesaurusConceptGroupType();
		thesaurusConceptGroupType.setCode("DE");
		thesaurusConceptGroupType.setLabel("label");
		thesaurusConceptGroupType.setSkosLabel("label");
		assertThat(thesaurusConceptGroupType.getCode(), is("DE"));
		assertThat(thesaurusConceptGroupType.getLabel(), is("label"));
		assertThat(thesaurusConceptGroupType.getSkosLabel(), is("label"));
	}
}
