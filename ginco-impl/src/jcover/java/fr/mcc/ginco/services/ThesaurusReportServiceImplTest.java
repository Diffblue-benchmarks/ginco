package fr.mcc.ginco.services;

import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.when;

import fr.mcc.ginco.beans.Thesaurus;
import fr.mcc.ginco.beans.ThesaurusConcept;
import fr.mcc.ginco.beans.ThesaurusTerm;
import fr.mcc.ginco.dao.IThesaurusConceptDAO;
import fr.mcc.ginco.dao.IThesaurusTermDAO;
import fr.mcc.ginco.solr.SearchResultList;

import java.util.ArrayList;
import java.util.List;

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
	public void getConceptsWithoutNotesLimitIsOneAndStartIndexIsOne() {
		when(thesaurusConceptService.getConceptPreferredTerm(Mockito.<String>any()))
			.thenReturn(new ThesaurusTerm());
		List<ThesaurusConcept> list = new ArrayList<ThesaurusConcept>();
		ThesaurusConcept thesaurusConcept = new ThesaurusConcept();
		thesaurusConcept.setThesaurus(new Thesaurus());
		list.add(thesaurusConcept);
		when(conceptDAO.countConceptsWoNotes(Mockito.<String>any()))
			.thenReturn(1L);
		when(conceptDAO.getConceptsWoNotes(Mockito.<String>any(), anyInt(), anyInt()))
			.thenReturn(list);
		SearchResultList result =
			 service.getConceptsWithoutNotes("/some/path.html", 1, 1);
	}

	@Test
	public void getConceptsAlignedToMyThesLimitIsOneAndStartIndexIsOne() {
		when(thesaurusConceptService.getConceptPreferredTerm(Mockito.<String>any()))
			.thenReturn(new ThesaurusTerm());
		List<ThesaurusConcept> list = new ArrayList<ThesaurusConcept>();
		ThesaurusConcept thesaurusConcept = new ThesaurusConcept();
		thesaurusConcept.setThesaurus(new Thesaurus());
		list.add(thesaurusConcept);
		when(conceptDAO.countConceptsAlignedToMyThes(Mockito.<String>any()))
			.thenReturn(1L);
		when(conceptDAO.getConceptsAlignedToMyThes(Mockito.<String>any(), anyInt(), anyInt()))
			.thenReturn(list);
		SearchResultList result =
			 service.getConceptsAlignedToMyThes("/some/path.html", 1, 1);
	}

	@Test
	public void getTermsWithoutNotesLimitIsOneAndStartIndexIsOne() {
		List<ThesaurusTerm> list = new ArrayList<ThesaurusTerm>();
		list.add(new ThesaurusTerm());
		when(termDAO.countTermsWoNotes(Mockito.<String>any()))
			.thenReturn(1L);
		when(termDAO.getTermsWoNotes(Mockito.<String>any(), anyInt(), anyInt()))
			.thenReturn(list);
		SearchResultList result =
			 service.getTermsWithoutNotes("/some/path.html", 1, 1);
	}
}
