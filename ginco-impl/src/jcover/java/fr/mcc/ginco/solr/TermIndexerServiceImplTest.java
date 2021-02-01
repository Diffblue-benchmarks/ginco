package fr.mcc.ginco.solr;

import static org.mockito.Mockito.when;

import fr.mcc.ginco.beans.ThesaurusTerm;

import java.util.ArrayList;

import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.response.UpdateResponse;
import org.apache.solr.common.SolrInputDocument;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
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

	@Before
	public void initMocks() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void addTerm() throws org.apache.solr.client.solrj.SolrServerException, java.io.IOException, fr.mcc.ginco.exceptions.TechnicalException {
		when(termSolrConverter.convertSolrTerm(Mockito.<ThesaurusTerm>any()))
			.thenReturn(new SolrInputDocument());
		when(solrServer.add(Mockito.<SolrInputDocument>any()))
			.thenReturn(new UpdateResponse());
		when(solrServer.commit())
			.thenReturn(new UpdateResponse());
		service.addTerm(new ThesaurusTerm());
	}

	@Test
	public void addTerms() throws org.apache.solr.client.solrj.SolrServerException, java.io.IOException {
		when(termSolrConverter.convertSolrTerm(Mockito.<ThesaurusTerm>any()))
			.thenReturn(new SolrInputDocument());
		when(solrServer.add(Mockito.<SolrInputDocument>any()))
			.thenReturn(new UpdateResponse());
		when(solrServer.commit())
			.thenReturn(new UpdateResponse());
		ArrayList<ThesaurusTerm> thesaurusTerms = new ArrayList<ThesaurusTerm>();
		thesaurusTerms.add(new ThesaurusTerm());
		service.addTerms(thesaurusTerms);
	}

	@Test
	public void removeTerm() throws org.apache.solr.client.solrj.SolrServerException, java.io.IOException, fr.mcc.ginco.exceptions.TechnicalException {
		when(solrServer.commit())
			.thenReturn(new UpdateResponse());
		when(solrServer.deleteById(Mockito.<String>any()))
			.thenReturn(new UpdateResponse());
		service.removeTerm(new ThesaurusTerm());
	}
}
