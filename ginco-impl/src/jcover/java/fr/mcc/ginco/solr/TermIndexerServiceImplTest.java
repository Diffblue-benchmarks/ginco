package fr.mcc.ginco.solr;

import static org.mockito.Mockito.when;

import fr.mcc.ginco.beans.ThesaurusTerm;

import java.util.ArrayList;

import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.response.UpdateResponse;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

/**
 * Unit tests for fr.mcc.ginco.solr.TermIndexerServiceImpl
 *
 * @author Diffblue Cover
 */

public class TermIndexerServiceImplTest {

	@Mock(name = "solrServer")
	private SolrServer solrServer;

	@Mock(name = "termSolrConverter")
	private TermSolrConverter termSolrConverter;

	@InjectMocks
	private TermIndexerServiceImpl service;

	@Before public void initMocks() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void addTermsThesaurusTermsIsEmpty() throws org.apache.solr.client.solrj.SolrServerException, java.io.IOException {
		when(solrServer.commit())
			.thenReturn(new UpdateResponse());
		service.addTerms(new ArrayList<ThesaurusTerm>());
	}
}
