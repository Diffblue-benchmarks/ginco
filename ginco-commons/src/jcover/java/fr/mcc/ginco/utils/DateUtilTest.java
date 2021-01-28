package fr.mcc.ginco.utils;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.matchesPattern;
import static org.hamcrest.Matchers.nullValue;
import static org.hamcrest.core.Is.is;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;

import org.junit.jupiter.api.Test;

/**
 * Unit tests for fr.mcc.ginco.utils.DateUtil
 *
 * @author Diffblue Cover
 */

class DateUtilTest {

	@Test
	void testToString() throws java.text.ParseException {
		assertThat(DateUtil.toString(new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31")), matchesPattern("\\d{4}-\\d{1,2}-\\d{1,2} \\d{1,2}:\\d{2}:\\d{2}"));
		assertThat(DateUtil.toString(null), is(nullValue()));
	}

	@Test
	void toISO8601String() throws java.text.ParseException {
		assertThat(DateUtil.toISO8601String(new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31")), matchesPattern("\\d{4}-\\d{1,2}-\\d{1,2}T\\d{1,2}:\\d{2}:\\d{2}Z"));
		assertThat(DateUtil.toISO8601String(null), is(nullValue()));
	}

	@Test
	void dateFromStringReturnsNull() {
		assertThat(DateUtil.dateFromString("1999-12-31"), is(nullValue()));
	}

	@Test
	void nowDate() {
		assertThat(
			Math.abs(DateUtil.nowDate().getTime() - new Date().getTime())
			<= 10_000L, is(true));
	}
}
