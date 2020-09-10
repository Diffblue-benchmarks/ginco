package fr.mcc.ginco.services;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.when;

import fr.mcc.ginco.beans.ThesaurusConcept;
import fr.mcc.ginco.beans.ThesaurusTerm;
import fr.mcc.ginco.dao.IThesaurusConceptDAO;
import fr.mcc.ginco.dao.IThesaurusTermDAO;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

/**
 * Unit tests for fr.mcc.ginco.services.ThesaurusReportServiceImpl
 *
 * @author Diffblue Cover
 */

public class ThesaurusReportServiceImplTest {

	@Mock(name = "conceptDAO")
	private IThesaurusConceptDAO conceptDAO;

	@Mock(name = "termDAO")
	private IThesaurusTermDAO termDAO;

	@Mock(name = "thesaurusConceptService")
	private IThesaurusConceptService thesaurusConceptService;

	@InjectMocks
	private ThesaurusReportServiceImpl service;

	@Before public void initMocks() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void getConceptsAlignedToMyThesLimitIsOneAndStartIndexIsOneReturnsEmpty() {
		when(conceptDAO.countConceptsAlignedToMyThes(Mockito.<String>any()))
			.thenReturn(1L);
		when(conceptDAO.getConceptsAlignedToMyThes(Mockito.<String>any(), anyInt(), anyInt()))
			.thenReturn(new ArrayList<ThesaurusConcept>());
		assertTrue((service.getConceptsAlignedToMyThes("/some/path.html", 1, 1)).isEmpty());
	}

	@Test
	public void getConceptsWithoutNotesLimitIsOneAndStartIndexIsOneReturnsEmpty() {
		when(conceptDAO.countConceptsWoNotes(Mockito.<String>any()))
			.thenReturn(1L);
		when(conceptDAO.getConceptsWoNotes(Mockito.<String>any(), anyInt(), anyInt()))
			.thenReturn(new ArrayList<ThesaurusConcept>());
		assertTrue((service.getConceptsWithoutNotes("/some/path.html", 1, 1)).isEmpty());
	}

	@Test
	public void getTermsWithoutNotesLimitIsOneAndStartIndexIsOneReturnsEmpty() {
		when(termDAO.countTermsWoNotes(Mockito.<String>any()))
			.thenReturn(1L);
		when(termDAO.getTermsWoNotes(Mockito.<String>any(), anyInt(), anyInt()))
			.thenReturn(new ArrayList<ThesaurusTerm>());
		assertTrue((service.getTermsWithoutNotes("/some/path.html", 1, 1)).isEmpty());
	}
}
