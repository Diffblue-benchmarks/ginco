package fr.mcc.ginco.services;

import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.when;

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
