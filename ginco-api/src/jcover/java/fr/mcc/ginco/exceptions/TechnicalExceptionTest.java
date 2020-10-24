package fr.mcc.ginco.exceptions;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.nullValue;
import static org.hamcrest.core.Is.is;

import org.junit.jupiter.api.Test;

/**
 * Unit tests for fr.mcc.ginco.exceptions.TechnicalException
 *
 * @author Diffblue Cover
 */

class TechnicalExceptionTest {

	@Test
	void factory() {
		Exception cause = new Exception();
		cause.setStackTrace(new StackTraceElement[] { });
		TechnicalException technicalException =
			 new TechnicalException("an error has happened", cause);
		StackTraceElement[] stackTrace =
			 new StackTraceElement[] { new StackTraceElement("java.lang.Object", "toString", "Object.java", 1) };
		technicalException.setStackTrace(stackTrace);
		assertThat(technicalException.getCause().getCause(), is(nullValue()));
		assertThat(technicalException.getCause().getMessage(), is(nullValue()));
		assertThat(technicalException.getMessage(), is("an error has happened"));
	}
}
