package fr.mcc.ginco.beans;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

import org.junit.jupiter.api.Test;

/**
 * Unit tests for fr.mcc.ginco.beans.AdminUser
 *
 * @author Diffblue Cover
 */

class AdminUserTest {

	@Test
	void factory() {
		AdminUser adminUser = new AdminUser();
		adminUser.setUserId("root");
		assertThat(adminUser.getUserId(), is("root"));
	}
}
