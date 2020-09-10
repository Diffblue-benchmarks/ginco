package fr.mcc.ginco.enums;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

import org.junit.jupiter.api.Test;

/**
 * Unit tests for fr.mcc.ginco.enums.ConceptHierarchicalRelationsEnum
 *
 * @author Diffblue Cover
 */

class ConceptHierarchicalRelationsEnumTest {

	@Test
	void valuesReturnsNORELATIONSPARENTCHILD() {
		ConceptHierarchicalRelationsEnum[] result =
			 ConceptHierarchicalRelationsEnum.values();
		assertThat(result[0], is(ConceptHierarchicalRelationsEnum.NORELATIONS));
		assertThat(result[1], is(ConceptHierarchicalRelationsEnum.PARENT));
		assertThat(result[2], is(ConceptHierarchicalRelationsEnum.CHILD));
	}
}
