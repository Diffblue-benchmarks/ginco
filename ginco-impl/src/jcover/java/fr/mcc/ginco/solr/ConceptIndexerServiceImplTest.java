package fr.mcc.ginco.solr;

import static org.mockito.Mockito.when;

import fr.mcc.ginco.beans.ThesaurusConcept;

import java.util.ArrayList;

import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.response.UpdateResponse;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

/**
 * Unit tests for fr.mcc.ginco.solr.ConceptIndexerServiceImpl
 *
 * @author Diffblue Cover
 */

public class ConceptIndexerServiceImplTest {

	@Mock(name = "conceptSolrConverter")
	private ConceptSolrConverter conceptSolrConverter;

	@Mock(name = "solrServer")
	private SolrServer solrServer;

	@InjectMocks
	private ConceptIndexerServiceImpl service;

	@Before public void initMocks() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void addConceptsThesaurusConceptsIsEmpty() throws org.apache.solr.client.solrj.SolrServerException, java.io.IOException, fr.mcc.ginco.exceptions.TechnicalException {
		when(solrServer.commit())
			.thenReturn(new UpdateResponse());
		service.addConcepts(new ArrayList<ThesaurusConcept>());
	}

	@Test
	public void removeConcept() throws org.apache.solr.client.solrj.SolrServerException, java.io.IOException, fr.mcc.ginco.exceptions.TechnicalException {
		when(solrServer.commit())
			.thenReturn(new UpdateResponse());
		when(solrServer.deleteById(Mockito.<String>any()))
			.thenReturn(new UpdateResponse());
		service.removeConcept(new ThesaurusConcept());
	}
}
