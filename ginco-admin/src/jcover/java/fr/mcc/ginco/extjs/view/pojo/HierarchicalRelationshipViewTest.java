package fr.mcc.ginco.extjs.view.pojo;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

import org.junit.jupiter.api.Test;

/**
 * Unit tests for fr.mcc.ginco.extjs.view.pojo.HierarchicalRelationshipView
 *
 * @author Diffblue Cover
 */

class HierarchicalRelationshipViewTest {

	@Test
	void factory() {
		HierarchicalRelationshipView hierarchicalRelationshipView =
			 new HierarchicalRelationshipView();
		hierarchicalRelationshipView.setIdentifier("data");
		hierarchicalRelationshipView.setLabel("label");
		hierarchicalRelationshipView.setRole(1);
		assertThat(hierarchicalRelationshipView.getIdentifier(), is("data"));
		assertThat(hierarchicalRelationshipView.getLabel(), is("label"));
		assertThat(hierarchicalRelationshipView.getRole(), is(1));
	}
}
