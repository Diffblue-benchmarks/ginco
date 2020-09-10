package fr.mcc.ginco.enums;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

import org.junit.jupiter.api.Test;

/**
 * Unit tests for fr.mcc.ginco.enums.ThesaurusVersionStatusEnum
 *
 * @author Diffblue Cover
 */

class ThesaurusVersionStatusEnumTest {

	@Test
	void valuesReturnsPROJECTVALIDATEDPUBLISHEDDEPRECATEDPROHIBITED() {
		ThesaurusVersionStatusEnum[] result = ThesaurusVersionStatusEnum.values();
		assertThat(result[0], is(ThesaurusVersionStatusEnum.PROJECT));
		assertThat(result[1], is(ThesaurusVersionStatusEnum.VALIDATED));
		assertThat(result[2], is(ThesaurusVersionStatusEnum.PUBLISHED));
		assertThat(result[3], is(ThesaurusVersionStatusEnum.DEPRECATED));
		assertThat(result[4], is(ThesaurusVersionStatusEnum.PROHIBITED));
	}
}
