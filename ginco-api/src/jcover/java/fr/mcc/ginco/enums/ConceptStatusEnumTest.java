package fr.mcc.ginco.enums;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.nullValue;
import static org.hamcrest.core.Is.is;

import org.junit.jupiter.api.Test;

/**
 * Unit tests for fr.mcc.ginco.enums.ConceptStatusEnum
 *
 * @author Diffblue Cover
 */

class ConceptStatusEnumTest {

	@Test
	void getStatusByCode() {
		assertThat(ConceptStatusEnum.getStatusByCode(-1), is(nullValue()));
		assertThat(ConceptStatusEnum.getStatusByCode(1), is(ConceptStatusEnum.VALIDATED));
	}
}
