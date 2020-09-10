package fr.mcc.ginco.solr;

import static org.mockito.Mockito.when;

import fr.mcc.ginco.beans.SplitNonPreferredTerm;

import java.util.ArrayList;

import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.response.UpdateResponse;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
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
	public void addComplexConceptsComplexConceptsIsEmpty() throws org.apache.solr.client.solrj.SolrServerException, java.io.IOException, fr.mcc.ginco.exceptions.TechnicalException {
		when(solrServer.commit())
			.thenReturn(new UpdateResponse());
		service.addComplexConcepts(new ArrayList<SplitNonPreferredTerm>());
	}
}
