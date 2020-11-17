package fr.mcc.ginco.rest.services.exceptions;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.nullValue;
import static org.hamcrest.core.Is.is;

import javax.ws.rs.core.Response;

import org.junit.jupiter.api.Test;

/**
 * Unit tests for fr.mcc.ginco.rest.services.exceptions.AccessDeniedExceptionMapper
 *
 * @author Diffblue Cover
 */

class AccessDeniedExceptionMapperTest {

	@Test
	void toResponse() {

		// arrange
		Exception exception = new Exception();
		exception.setStackTrace(new StackTraceElement[] { });

		// act
		Response result = new AccessDeniedExceptionMapper().toResponse(exception);

		// assert
		assertThat(result.getCookies().isEmpty(), is(true));
		assertThat(result.getMediaType(), is(nullValue()));
		assertThat(result.getStatus(), is(200));
	}
}