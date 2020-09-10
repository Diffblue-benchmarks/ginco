package fr.mcc.ginco.beans;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsSame.sameInstance;

import org.junit.jupiter.api.Test;

/**
 * Unit tests for fr.mcc.ginco.beans.ConceptHierarchicalRelationship
 *
 * @author Diffblue Cover
 */

class ConceptHierarchicalRelationshipTest {

	@Test
	void factory() {
		ConceptHierarchicalRelationship conceptHierarchicalRelationship =
			 new ConceptHierarchicalRelationship();
		ConceptHierarchicalRelationship.Id identifier =
			 new ConceptHierarchicalRelationship.Id();
		identifier.setChildconceptid("1234");
		identifier.setParentconceptid("1234");
		conceptHierarchicalRelationship.setIdentifier(identifier);
		conceptHierarchicalRelationship.setRole(1);
		assertThat(conceptHierarchicalRelationship.getIdentifier(), sameInstance(identifier));
		assertThat(conceptHierarchicalRelationship.getRole(), is(1));
	}
}
