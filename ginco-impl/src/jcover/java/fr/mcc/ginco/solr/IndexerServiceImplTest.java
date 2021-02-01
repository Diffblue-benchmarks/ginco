package fr.mcc.ginco.solr;

import static org.mockito.Mockito.when;

import fr.mcc.ginco.beans.Note;
import fr.mcc.ginco.beans.SplitNonPreferredTerm;
import fr.mcc.ginco.beans.ThesaurusConcept;
import fr.mcc.ginco.beans.ThesaurusTerm;
import fr.mcc.ginco.services.INoteService;
import fr.mcc.ginco.services.ISplitNonPreferredTermService;
import fr.mcc.ginco.services.IThesaurusConceptService;
import fr.mcc.ginco.services.IThesaurusTermService;

import java.util.ArrayList;
import java.util.List;

import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.response.UpdateResponse;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

/**
 * Unit tests for fr.mcc.ginco.solr.IndexerServiceImpl
 *
 * @author Diffblue Cover
 */

public class IndexerServiceImplTest {

	@Mock(name = "complexConceptIndexerService")
	private IComplexConceptIndexerService complexConceptIndexerService;

	@Mock(name = "conceptIndexerService")
	private IConceptIndexerService conceptIndexerService;

	@Mock(name = "noteIndexerService")
	private INoteIndexerService noteIndexerService;

	@Mock(name = "noteService")
	private INoteService noteService;

	@Mock(name = "solrServer")
	private SolrServer solrServer;

	@Mock(name = "splitNonPreferredTermService")
	private ISplitNonPreferredTermService splitNonPreferredTermService;

	@Mock(name = "termIndexerService")
	private ITermIndexerService termIndexerService;

	@Mock(name = "thesaurusConceptService")
	private IThesaurusConceptService thesaurusConceptService;

	@Mock(name = "thesaurusTermService")
	private IThesaurusTermService thesaurusTermService;

	@InjectMocks
	private IndexerServiceImpl service;

	@Before
	public void initMocks() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void forceIndexing() throws fr.mcc.ginco.exceptions.TechnicalException, org.apache.solr.client.solrj.SolrServerException, java.io.IOException {
		when(thesaurusTermService.getAllTerms())
			.thenReturn(new ArrayList<ThesaurusTerm>());
		when(thesaurusConceptService.getAllConcepts())
			.thenReturn(new ArrayList<ThesaurusConcept>());
		when(splitNonPreferredTermService.getAllSplitNonPreferredTerms())
			.thenReturn(new ArrayList<SplitNonPreferredTerm>());
		when(solrServer.commit())
			.thenReturn(new UpdateResponse());
		when(solrServer.deleteByQuery(Mockito.<String>any()))
			.thenReturn(new UpdateResponse());
		when(solrServer.optimize())
			.thenReturn(new UpdateResponse());
		when(noteService.getAllNotes())
			.thenReturn(new ArrayList<Note>());
		service.forceIndexing();
		Mockito.verify(termIndexerService).addTerms(Mockito.<List<ThesaurusTerm>>any());
		Mockito.verify(noteIndexerService).addNotes(Mockito.<List<Note>>any());
		Mockito.verify(conceptIndexerService).addConcepts(Mockito.<List<ThesaurusConcept>>any());
		Mockito.verify(complexConceptIndexerService).addComplexConcepts(Mockito.<List<SplitNonPreferredTerm>>any());
	}
}
