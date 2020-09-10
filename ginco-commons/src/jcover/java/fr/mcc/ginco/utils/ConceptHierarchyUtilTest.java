package fr.mcc.ginco.utils;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.nullValue;
import static org.hamcrest.core.Is.is;

import fr.mcc.ginco.beans.ThesaurusConcept;

import java.util.HashSet;

import org.junit.jupiter.api.Test;

/**
 * Unit tests for fr.mcc.ginco.utils.ConceptHierarchyUtil
 *
 * @author Diffblue Cover
 */

class ConceptHierarchyUtilTest {

	@Test
	void getSuperOrdinateMembersConceptsIsEmptyReturnsNull() {
		assertThat(ConceptHierarchyUtil.getSuperOrdinate(new HashSet<ThesaurusConcept>()), is(nullValue()));
	}
}
