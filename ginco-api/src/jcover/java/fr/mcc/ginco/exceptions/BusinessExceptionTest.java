package fr.mcc.ginco.exceptions;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.nullValue;
import static org.hamcrest.core.Is.is;

import org.junit.jupiter.api.Test;

/**
 * Unit tests for fr.mcc.ginco.exceptions.BusinessException
 *
 * @author Diffblue Cover
 */

class BusinessExceptionTest {

	@Test
	void factory() {
		BusinessException businessException = new BusinessException("jpg", "John Smith");
		assertThat(businessException.getToFormat(), is(nullValue()));
		assertThat(businessException.getUserMessageKey(), is("John Smith"));
		assertThat(businessException.getCause(), is(nullValue()));
		assertThat(businessException.getMessage(), is("jpg"));
	}
}
