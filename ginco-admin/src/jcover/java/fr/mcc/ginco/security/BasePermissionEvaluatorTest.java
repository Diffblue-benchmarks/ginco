package fr.mcc.ginco.security;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.mock;

import fr.mcc.ginco.extjs.view.pojo.GenericRoleView;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.security.core.Authentication;

/**
 * Unit tests for fr.mcc.ginco.security.BasePermissionEvaluator
 *
 * @author Diffblue Cover
 */

class BasePermissionEvaluatorTest {

	@Test
	void hasPermission1() throws IllegalArgumentException {
		Authentication authentication = mock(Authentication.class);
		assertThat(new BasePermissionEvaluator().hasPermission(authentication, new Object(), "foo"), is(false));
	}

	@Test
	void hasPermission2() throws IllegalArgumentException {
		Authentication authentication = mock(Authentication.class);
		List list = new ArrayList();
		list.add(new Object());
		assertThat(new BasePermissionEvaluator().hasPermission(authentication, list, new Object()), is(false));
	}

	@Test
	void hasPermissionTargetTypeIsBASIC() throws IllegalArgumentException {
		Authentication authentication = mock(Authentication.class);
		assertThat(new BasePermissionEvaluator().hasPermission(authentication, new GenericRoleView(), "BASIC", "foo"), is(false));
	}
}
