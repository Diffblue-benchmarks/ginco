package fr.mcc.ginco.solr;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.nullValue;
import static org.hamcrest.core.Is.is;

import org.junit.jupiter.api.Test;

/**
 * Unit tests for fr.mcc.ginco.solr.SolrField
 *
 * @author Diffblue Cover
 */

class SolrFieldTest {

	@Test
	void getCheckedValueFieldNameIsDataReturnsNull() {
		assertThat(SolrField.getCheckedValue("data"), is(nullValue()));
	}
}
