package fr.mcc.ginco.solr;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import fr.mcc.ginco.beans.Note;
import fr.mcc.ginco.beans.ThesaurusConcept;
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
	public void addNote1() throws org.apache.solr.client.solrj.SolrServerException, java.io.IOException, fr.mcc.ginco.exceptions.TechnicalException {
		when(solrServer.add(Mockito.<SolrInputDocument>any()))
			.thenReturn(new UpdateResponse());
		when(solrServer.commit())
			.thenReturn(new UpdateResponse());
		when(noteSolrConverter.convertSolrNote(Mockito.<Note>any()))
			.thenReturn(new SolrInputDocument());
		Note note = new Note();
		note.setConcept(new ThesaurusConcept());
		service.addNote(note);
	}

	@Test
	public void addNote2() throws org.apache.solr.client.solrj.SolrServerException, java.io.IOException, fr.mcc.ginco.exceptions.TechnicalException {
		when(solrServer.add(Mockito.<SolrInputDocument>any()))
			.thenReturn(new UpdateResponse());
		when(solrServer.commit())
			.thenReturn(new UpdateResponse());
		when(noteSolrConverter.convertSolrNote(Mockito.<Note>any()))
			.thenReturn(new SolrInputDocument());
		Note note = new Note();
		ThesaurusTerm termId = mock(ThesaurusTerm.class);
		note.setTerm(termId);
		service.addNote(note);
	}

	@Test
	public void addNotesNotesIsEmpty() throws org.apache.solr.client.solrj.SolrServerException, java.io.IOException {
		when(solrServer.commit())
			.thenReturn(new UpdateResponse());
		service.addNotes(new ArrayList<Note>());
	}

	@Test
	public void removeNote() throws org.apache.solr.client.solrj.SolrServerException, java.io.IOException, fr.mcc.ginco.exceptions.TechnicalException {
		when(solrServer.commit())
			.thenReturn(new UpdateResponse());
		when(solrServer.deleteById(Mockito.<String>any()))
			.thenReturn(new UpdateResponse());
		service.removeNote(new Note());
	}
}
