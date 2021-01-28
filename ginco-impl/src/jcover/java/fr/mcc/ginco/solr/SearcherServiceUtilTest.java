package fr.mcc.ginco.solr;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.regex.Pattern;

import org.apache.solr.common.SolrDocumentList;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

/**
 * Unit tests for fr.mcc.ginco.solr.SearcherServiceUtil
 *
 * @author Diffblue Cover
 */

public class SearcherServiceUtilTest {

	@InjectMocks
	private SearcherServiceUtil service;

	@Before public void initMocks() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void addAndQuery() {
		assertTrue(Pattern.matches("\\+data:java\\.lang\\.Object@[0-9a-f]+ ", service.addAndQuery("data", new Object(), null, false)));
		assertTrue(Pattern.matches("\\+data:\\[ java\\.lang\\.Object@[0-9a-f]+Z TO \\* \\] ", service.addAndQuery("data", new Object(), true, false)));
		assertTrue(Pattern.matches("\\+data:\\[ \\* TO java\\.lang\\.Object@[0-9a-f]+Z \\] ", service.addAndQuery("data", new Object(), false, true)));
		assertEquals("+ :[ * TO fooZ ] ", service.addAndQuery(" ", "foo", false, false));
		assertEquals("", service.addAndQuery("data", null, false, false));
	}

	@Test
	public void getExtTypeQuery() {
		assertEquals("", service.getExtTypeQuery(-1));
		assertEquals("", service.getExtTypeQuery(null));
		assertEquals("+ext_type:1", service.getExtTypeQuery(1));
		assertEquals("", service.getExtTypeQuery(0));
	}

	@Test
	public void getSearchResultListListIsEmptyReturnsEmpty() {
		assertTrue(service.getSearchResultList(new SolrDocumentList()).isEmpty());
	}
}
