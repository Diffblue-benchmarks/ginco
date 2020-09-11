package fr.mcc.ginco.security;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.mock;

import java.io.Serializable;
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
		assertThat(new BasePermissionEvaluator().hasPermission(new TestingAuthenticationToken("bar", "admin"), list, new Object()), is(false));
	}

	@Test
	void hasPermission2() {
		assertThat(new BasePermissionEvaluator().hasPermission(new TestingAuthenticationToken("bar", "admin"), new Object(), "foo"), is(false));
	}

	@Test
	void hasPermissionTargetTypeIsBASIC() {
		Serializable targetId = mock(Serializable.class);
		assertThat(new BasePermissionEvaluator().hasPermission(new TestingAuthenticationToken("bar", "admin"), targetId, "BASIC", "foo"), is(false));
	}
}
