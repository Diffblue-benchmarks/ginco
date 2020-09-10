package fr.mcc.ginco.extjs.view.pojo;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

import org.junit.jupiter.api.Test;

/**
 * Unit tests for fr.mcc.ginco.extjs.view.pojo.UserThesaurusRole
 *
 * @author Diffblue Cover
 */

class UserThesaurusRoleTest {

	@Test
	void factory() {
		UserThesaurusRole userThesaurusRole = new UserThesaurusRole();
		userThesaurusRole.setRole(1);
		userThesaurusRole.setThesaurusId("root");
		assertThat(userThesaurusRole.getRole(), is(1));
		assertThat(userThesaurusRole.getThesaurusId(), is("root"));
	}

	@Test
	void testEquals() {
		assertThat(new UserThesaurusRole().equals("foo"), is(false));
		assertThat(new UserThesaurusRole().equals(null), is(false));
	}
}
