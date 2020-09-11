package fr.mcc.ginco.extjs.view.pojo;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.empty;
import static org.hamcrest.core.Is.is;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

/**
 * Unit tests for fr.mcc.ginco.extjs.view.pojo.UserInfo
 *
 * @author Diffblue Cover
 */

class UserInfoTest {

	@Test
	void factory() {
		UserInfo userInfo = new UserInfo();
		userInfo.setAdmin(false);
		userInfo.setUserThesaurusRoles(new ArrayList<UserThesaurusRole>());
		userInfo.setUsername("root");
		assertThat(userInfo.getUserThesaurusRoles(), empty());
		assertThat(userInfo.getUsername(), is("root"));
		assertThat(userInfo.isAdmin(), is(false));
	}
}
