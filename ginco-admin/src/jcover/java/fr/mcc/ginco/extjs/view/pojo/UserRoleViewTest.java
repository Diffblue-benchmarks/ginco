package fr.mcc.ginco.extjs.view.pojo;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

import org.junit.jupiter.api.Test;

/**
 * Unit tests for fr.mcc.ginco.extjs.view.pojo.UserRoleView
 *
 * @author Diffblue Cover
 */

class UserRoleViewTest {

	@Test
	void factory() {
		UserRoleView userRoleView = new UserRoleView();
		userRoleView.setIdentifier(1);
		userRoleView.setRole(1);
		userRoleView.setThesaurusId("root");
		userRoleView.setUsername("root");
		assertThat(userRoleView.getIdentifier(), is(1));
		assertThat(userRoleView.getRole(), is(1));
		assertThat(userRoleView.getThesaurusId(), is("root"));
		assertThat(userRoleView.getUsername(), is("root"));
	}
}
