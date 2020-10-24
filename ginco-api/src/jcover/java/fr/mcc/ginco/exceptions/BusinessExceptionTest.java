package fr.mcc.ginco.exceptions;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.nullValue;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsSame.sameInstance;

import org.junit.jupiter.api.Test;

/**
 * Unit tests for fr.mcc.ginco.exceptions.BusinessException
 *
 * @author Diffblue Cover
 */

class BusinessExceptionTest {

	@Test
	void factory1() {
		BusinessException businessException =
			 new BusinessException("an error has happened", "an error has happened");
		StackTraceElement[] stackTrace =
			 new StackTraceElement[] { new StackTraceElement("java.lang.Object", "toString", "Object.java", 1) };
		businessException.setStackTrace(stackTrace);
		assertThat(businessException.getToFormat(), is(nullValue()));
		assertThat(businessException.getUserMessageKey(), is("an error has happened"));
		assertThat(businessException.getCause(), is(nullValue()));
		assertThat(businessException.getMessage(), is("an error has happened"));
	}

	@Test
	void factory2() {
		Exception cause = new Exception();
		cause.setStackTrace(new StackTraceElement[] { });
		BusinessException businessException =
			 new BusinessException("an error has happened", "an error has happened", cause);
		StackTraceElement[] stackTrace =
			 new StackTraceElement[] { new StackTraceElement("java.lang.Object", "toString", "Object.java", 1) };
		businessException.setStackTrace(stackTrace);
		assertThat(businessException.getToFormat(), is(nullValue()));
		assertThat(businessException.getUserMessageKey(), is("an error has happened"));
		assertThat(businessException.getCause().getCause(), is(nullValue()));
		assertThat(businessException.getCause().getMessage(), is(nullValue()));
		assertThat(businessException.getMessage(), is("an error has happened"));
	}

	@Test
	void factory3() {
		Object object = new Object();
		Object[] toFormat = new Object[] { object };
		BusinessException businessException =
			 new BusinessException("an error has happened", "an error has happened", toFormat);
		StackTraceElement[] stackTrace =
			 new StackTraceElement[] { new StackTraceElement("java.lang.Object", "toString", "Object.java", 1) };
		businessException.setStackTrace(stackTrace);
		assertThat(businessException.getToFormat()[0], sameInstance(object));
		assertThat(businessException.getUserMessageKey(), is("an error has happened"));
		assertThat(businessException.getCause(), is(nullValue()));
		assertThat(businessException.getMessage(), is("an error has happened"));
	}
}
