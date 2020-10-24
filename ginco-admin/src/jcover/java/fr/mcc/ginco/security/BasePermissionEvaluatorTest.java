package fr.mcc.ginco.security;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.security.authentication.TestingAuthenticationToken;

/**
 * Unit tests for fr.mcc.ginco.security.BasePermissionEvaluator
 *
 * @author Diffblue Cover
 */

class BasePermissionEvaluatorTest {

	@Test
	void hasPermission() {
		assertThat(new BasePermissionEvaluator().hasPermission(new TestingAuthenticationToken("bar", "admin"), new Object(), "foo"), is(false));
		assertThat(new BasePermissionEvaluator().hasPermission(new TestingAuthenticationToken("bar", "admin"), "1234", "BASIC", "foo"), is(false));
	}

	@Test
	void hasPermissionTargetDomainObjectIsFoo() {
		List list = new ArrayList<String>();
		list.add("foo");
		assertThat(new BasePermissionEvaluator().hasPermission(new TestingAuthenticationToken("bar", "admin"), list, new Object()), is(false));
	}
}
