package fr.mcc.ginco.enums;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.nullValue;
import static org.hamcrest.core.Is.is;

import org.junit.jupiter.api.Test;

/**
 * Unit tests for fr.mcc.ginco.enums.ReportTypeEnum
 *
 * @author Diffblue Cover
 */

class ReportTypeEnumTest {

	@Test
	void getTypeByCode() {
		assertThat(ReportTypeEnum.getTypeByCode(-1), is(nullValue()));
		assertThat(ReportTypeEnum.getTypeByCode(1), is(ReportTypeEnum.TERMSWONOTES));
	}
}
