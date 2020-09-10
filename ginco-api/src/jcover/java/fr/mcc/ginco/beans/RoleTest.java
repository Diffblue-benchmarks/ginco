package fr.mcc.ginco.beans;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

import org.junit.jupiter.api.Test;

/**
 * Unit tests for fr.mcc.ginco.beans.Role
 *
 * @author Diffblue Cover
 */

class RoleTest {

	@Test
	void valuesReturnsMANAGEREXPERT() {
		Role[] result = Role.values();
		assertThat(result[0], is(Role.MANAGER));
		assertThat(result[1], is(Role.EXPERT));
	}
}
