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
			 new BusinessException("an error has happened", "John Smith");
		assertThat(businessException.getToFormat(), is(nullValue()));
		assertThat(businessException.getUserMessageKey(), is("John Smith"));
		assertThat(businessException.getCause(), is(nullValue()));
		assertThat(businessException.getMessage(), is("an error has happened"));
	}

	@Test
	void factory2() {
		Exception cause = new Exception();
		cause.setStackTrace(new StackTraceElement[] { });
		BusinessException businessException =
			 new BusinessException("an error has happened", "John Smith", cause);
		assertThat(businessException.getToFormat(), is(nullValue()));
		assertThat(businessException.getUserMessageKey(), is("John Smith"));
		assertThat(businessException.getCause().getCause(), is(nullValue()));
		assertThat(businessException.getCause().getMessage(), is(nullValue()));
		assertThat(businessException.getMessage(), is("an error has happened"));
	}

	@Test
	void factory3() {
		Object element = new Object();
		Object[] toFormat = new Object[] { element };
		BusinessException businessException =
			 new BusinessException("an error has happened", "John Smith", toFormat);
		assertThat(businessException.getToFormat()[0], sameInstance(element));
		assertThat(businessException.getUserMessageKey(), is("John Smith"));
		assertThat(businessException.getCause(), is(nullValue()));
		assertThat(businessException.getMessage(), is("an error has happened"));
	}
}
