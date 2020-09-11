package fr.mcc.ginco.security;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

import fr.mcc.ginco.extjs.view.pojo.GenericRoleView;

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
	void hasPermission1() {
		List list = new ArrayList();
		list.add(new Object());
		assertThat(new BasePermissionEvaluator().hasPermission(new TestingAuthenticationToken("admin", "admin"), list, new Object()), is(false));
	}

	@Test
	void hasPermission2() {
		assertThat(new BasePermissionEvaluator().hasPermission(new TestingAuthenticationToken("bar", "admin"), new Object(), new Object()), is(false));
		assertThat(new BasePermissionEvaluator().hasPermission(new TestingAuthenticationToken("bar", "foo"), new GenericRoleView(), "BASIC", new Object()), is(false));
	}
}
