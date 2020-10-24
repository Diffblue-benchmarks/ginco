package fr.mcc.ginco.rest.services.exceptions;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.nullValue;
import static org.hamcrest.core.Is.is;

import org.junit.jupiter.api.Test;

/**
 * Unit tests for fr.mcc.ginco.rest.services.exceptions.ThesaurusArchivedAccessDeniedException
 *
 * @author Diffblue Cover
 */

class ThesaurusArchivedAccessDeniedExceptionTest {

	@Test
	void factory() {
		ThesaurusArchivedAccessDeniedException thesaurusArchivedAccessDeniedException =
			 new ThesaurusArchivedAccessDeniedException("an error has happened");
		StackTraceElement[] stackTrace =
			 new StackTraceElement[] { new StackTraceElement("java.lang.Object", "toString", "Object.java", 1) };
		thesaurusArchivedAccessDeniedException.setStackTrace(stackTrace);
		assertThat(thesaurusArchivedAccessDeniedException.getCause(), is(nullValue()));
		assertThat(thesaurusArchivedAccessDeniedException.getMessage(), is("an error has happened"));
	}
}
