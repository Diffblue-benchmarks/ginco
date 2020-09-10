package fr.mcc.ginco.beans;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

import org.junit.jupiter.api.Test;

/**
 * Unit tests for fr.mcc.ginco.beans.AssociativeRelationshipRole
 *
 * @author Diffblue Cover
 */

class AssociativeRelationshipRoleTest {

	@Test
	void factory() {
		AssociativeRelationshipRole associativeRelationshipRole =
			 new AssociativeRelationshipRole();
		associativeRelationshipRole.setCode("DE");
		associativeRelationshipRole.setDefaultRole(false);
		associativeRelationshipRole.setLabel("bar");
		associativeRelationshipRole.setSkosLabel("label");
		assertThat(associativeRelationshipRole.getCode(), is("DE"));
		assertThat(associativeRelationshipRole.getDefaultRole(), is(false));
		assertThat(associativeRelationshipRole.getLabel(), is("bar"));
		assertThat(associativeRelationshipRole.getSkosLabel(), is("label"));
	}
}
