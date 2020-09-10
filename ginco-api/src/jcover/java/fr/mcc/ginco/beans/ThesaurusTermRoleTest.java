package fr.mcc.ginco.beans;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

import org.junit.jupiter.api.Test;

/**
 * Unit tests for fr.mcc.ginco.beans.ThesaurusTermRole
 *
 * @author Diffblue Cover
 */

class ThesaurusTermRoleTest {

	@Test
	void factory() {
		ThesaurusTermRole thesaurusTermRole = new ThesaurusTermRole();
		thesaurusTermRole.setCode("DE");
		thesaurusTermRole.setDefaultRole(false);
		thesaurusTermRole.setLabel("label");
		assertThat(thesaurusTermRole.getCode(), is("DE"));
		assertThat(thesaurusTermRole.getDefaultRole(), is(false));
		assertThat(thesaurusTermRole.getLabel(), is("label"));
	}
}
