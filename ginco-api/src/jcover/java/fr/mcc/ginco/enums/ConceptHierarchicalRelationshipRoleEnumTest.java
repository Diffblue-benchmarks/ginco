package fr.mcc.ginco.enums;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.nullValue;
import static org.hamcrest.core.Is.is;

import org.junit.jupiter.api.Test;

/**
 * Unit tests for fr.mcc.ginco.enums.ConceptHierarchicalRelationshipRoleEnum
 *
 * @author Diffblue Cover
 */

class ConceptHierarchicalRelationshipRoleEnumTest {

	@Test
	void getStatusByCode() {
		assertThat(ConceptHierarchicalRelationshipRoleEnum.getStatusByCode(-1), is(nullValue()));
		assertThat(ConceptHierarchicalRelationshipRoleEnum.getStatusByCode(1), is(ConceptHierarchicalRelationshipRoleEnum.TGGTSG));
	}

	@Test
	void getStatusByParentSKOSLabel() {
		assertThat(ConceptHierarchicalRelationshipRoleEnum.getStatusByParentSKOSLabel(""), is(ConceptHierarchicalRelationshipRoleEnum.TGTS));
		assertThat(ConceptHierarchicalRelationshipRoleEnum.getStatusByParentSKOSLabel("label"), is(nullValue()));
	}
}
