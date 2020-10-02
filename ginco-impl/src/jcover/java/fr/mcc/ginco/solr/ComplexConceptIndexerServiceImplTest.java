package fr.mcc.ginco.solr;

import static org.mockito.Mockito.when;

import fr.mcc.ginco.beans.SplitNonPreferredTerm;

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
 * Unit tests for fr.mcc.ginco.solr.ComplexConceptIndexerServiceImpl
 *
 * @author Diffblue Cover
 */

public class ComplexConceptIndexerServiceImplTest {

	@Mock(name = "complexConceptSolrConverter")
	private ComplexConceptSolrConverter complexConceptSolrConverter;

	@Mock(name = "solrServer")
	private SolrServer solrServer;

	@InjectMocks
	private ComplexConceptIndexerServiceImpl service;

	@Before public void initMocks() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void addComplexConcept() throws org.apache.solr.client.solrj.SolrServerException, java.io.IOException, fr.mcc.ginco.exceptions.TechnicalException {
		when(solrServer.add(Mockito.<SolrInputDocument>any()))
			.thenReturn(new UpdateResponse());
		when(solrServer.commit())
			.thenReturn(new UpdateResponse());
		when(complexConceptSolrConverter.convertSolrComplexConcept(Mockito.<SplitNonPreferredTerm>any()))
			.thenReturn(new SolrInputDocument());
		service.addComplexConcept(new SplitNonPreferredTerm());
	}

	@Test
	public void addComplexConceptsComplexConceptsIsEmpty() throws org.apache.solr.client.solrj.SolrServerException, java.io.IOException, fr.mcc.ginco.exceptions.TechnicalException {
		when(solrServer.commit())
			.thenReturn(new UpdateResponse());
		service.addComplexConcepts(new ArrayList<SplitNonPreferredTerm>());
	}

	@Test
	public void removeComplexConcept() throws org.apache.solr.client.solrj.SolrServerException, java.io.IOException, fr.mcc.ginco.exceptions.TechnicalException {
		when(solrServer.commit())
			.thenReturn(new UpdateResponse());
		when(solrServer.deleteById(Mockito.<String>any()))
			.thenReturn(new UpdateResponse());
		service.removeComplexConcept(new SplitNonPreferredTerm());
	}
}
