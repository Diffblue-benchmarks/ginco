package fr.mcc.ginco.extjs.view.pojo;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

import org.junit.jupiter.api.Test;

/**
 * Unit tests for fr.mcc.ginco.extjs.view.pojo.RoleView
 *
 * @author Diffblue Cover
 */

class RoleViewTest {

	@Test
	void factory() {
		RoleView roleView = new RoleView();
		roleView.setRole(1);
		roleView.setRoleLabel("admin");
		assertThat(roleView.getRole(), is(1));
		assertThat(roleView.getRoleLabel(), is("admin"));
	}

	@Test
	void testEquals() {
		assertThat(new RoleView().equals("foo"), is(false));
		assertThat(new RoleView().equals(null), is(false));
	}
}
