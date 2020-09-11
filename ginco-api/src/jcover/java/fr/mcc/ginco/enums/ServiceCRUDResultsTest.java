package fr.mcc.ginco.enums;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

import org.junit.jupiter.api.Test;

/**
 * Unit tests for fr.mcc.ginco.enums.ServiceCRUDResults
 *
 * @author Diffblue Cover
 */

class ServiceCRUDResultsTest {

	@Test
	void valuesReturnsSuccessFailure() {
		ServiceCRUDResults[] result = ServiceCRUDResults.values();
		assertThat(result[0], is(ServiceCRUDResults.SUCCESS));
		assertThat(result[1], is(ServiceCRUDResults.FAILURE));
	}
}
