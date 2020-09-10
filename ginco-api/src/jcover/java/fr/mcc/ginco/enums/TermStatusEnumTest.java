package fr.mcc.ginco.enums;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.nullValue;
import static org.hamcrest.core.Is.is;

import org.junit.jupiter.api.Test;

/**
 * Unit tests for fr.mcc.ginco.enums.TermStatusEnum
 *
 * @author Diffblue Cover
 */

class TermStatusEnumTest {

	@Test
	void getStatusByCode() {
		assertThat(TermStatusEnum.getStatusByCode(-1), is(nullValue()));
		assertThat(TermStatusEnum.getStatusByCode(1), is(TermStatusEnum.VALIDATED));
	}
}
