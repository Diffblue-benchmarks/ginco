package fr.mcc.ginco.solr;

import static org.mockito.Mockito.when;

import fr.mcc.ginco.beans.Note;

import java.util.ArrayList;

import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.response.UpdateResponse;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

/**
 * Unit tests for fr.mcc.ginco.solr.NoteIndexerServiceImpl
 *
 * @author Diffblue Cover
 */

public class NoteIndexerServiceImplTest {

	@Mock(name = "noteSolrConverter")
	private NoteSolrConverter noteSolrConverter;

	@Mock(name = "solrServer")
	private SolrServer solrServer;

	@InjectMocks
	private NoteIndexerServiceImpl service;

	@Before public void initMocks() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void addNotesNotesIsEmpty() throws org.apache.solr.client.solrj.SolrServerException, java.io.IOException {
		when(solrServer.commit())
			.thenReturn(new UpdateResponse());
		service.addNotes(new ArrayList<Note>());
	}
}
