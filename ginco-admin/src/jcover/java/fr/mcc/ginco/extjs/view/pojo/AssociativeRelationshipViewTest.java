package fr.mcc.ginco.extjs.view.pojo;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

import org.junit.jupiter.api.Test;

/**
 * Unit tests for fr.mcc.ginco.extjs.view.pojo.AssociativeRelationshipView
 *
 * @author Diffblue Cover
 */

class AssociativeRelationshipViewTest {

	@Test
	void factory() {
		AssociativeRelationshipView associativeRelationshipView =
			 new AssociativeRelationshipView();
		associativeRelationshipView.setIdentifier("data");
		associativeRelationshipView.setLabel("label");
		associativeRelationshipView.setRoleCode("DE");
		assertThat(associativeRelationshipView.getIdentifier(), is("data"));
		assertThat(associativeRelationshipView.getLabel(), is("label"));
		assertThat(associativeRelationshipView.getRoleCode(), is("DE"));
	}
}
