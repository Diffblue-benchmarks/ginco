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
		ThesaurusArchivedAccessDeniedException thesaurusArchivedAccessDeniedException = new ThesaurusArchivedAccessDeniedException("jpg");
		assertThat(thesaurusArchivedAccessDeniedException.getCause(), is(nullValue()));
		assertThat(thesaurusArchivedAccessDeniedException.getMessage(), is("jpg"));
	}
}
