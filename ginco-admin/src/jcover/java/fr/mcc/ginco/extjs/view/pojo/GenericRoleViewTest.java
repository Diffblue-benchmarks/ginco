package fr.mcc.ginco.extjs.view.pojo;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

import org.junit.jupiter.api.Test;

/**
 * Unit tests for fr.mcc.ginco.extjs.view.pojo.GenericRoleView
 *
 * @author Diffblue Cover
 */

class GenericRoleViewTest {

	@Test
	void factory() {
		GenericRoleView genericRoleView = new GenericRoleView();
		genericRoleView.setRole(1);
		genericRoleView.setRoleLabel("admin");
		assertThat(genericRoleView.getRole(), is(1));
		assertThat(genericRoleView.getRoleLabel(), is("admin"));
	}
}
