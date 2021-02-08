package fr.mcc.ginco.services;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import fr.mcc.ginco.beans.Thesaurus;
import fr.mcc.ginco.beans.ThesaurusStatistics;
import fr.mcc.ginco.dao.ISplitNonPreferredTermDAO;
import fr.mcc.ginco.dao.IThesaurusArrayDAO;
import fr.mcc.ginco.dao.IThesaurusConceptDAO;
import fr.mcc.ginco.dao.IThesaurusConceptGroupDAO;
import fr.mcc.ginco.dao.IThesaurusDAO;
import fr.mcc.ginco.dao.IThesaurusTermDAO;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

/**
 * Unit tests for fr.mcc.ginco.services.ThesaurusStatisticsServiceImpl
 *
 * @author Diffblue Cover
 */

public class ThesaurusStatisticsServiceImplTest {

	@Mock(name = "conceptDAO")
	private IThesaurusConceptDAO conceptDAO;

	@Mock(name = "splitNonPreferredTermDAO")
	private ISplitNonPreferredTermDAO splitNonPreferredTermDAO;

	@Mock(name = "termDAO")
	private IThesaurusTermDAO termDAO;

	@Mock(name = "thesaurusArrayDAO")
	private IThesaurusArrayDAO thesaurusArrayDAO;

	@Mock(name = "thesaurusConceptGroupDAO")
	private IThesaurusConceptGroupDAO thesaurusConceptGroupDAO;

	@Mock(name = "thesaurusDAO")
	private IThesaurusDAO thesaurusDAO;

	@InjectMocks
	private ThesaurusStatisticsServiceImpl service;

	@Before
	public void initMocks() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void getStatistics() {
		Thesaurus thesaurus = mock(Thesaurus.class);
		when(thesaurusDAO.getById(Mockito.<String>any()))
			.thenReturn(thesaurus);
		when(thesaurusConceptGroupDAO.countItems(Mockito.<String>any()))
			.thenReturn(1L);
		when(thesaurusArrayDAO.countItems(Mockito.<String>any()))
			.thenReturn(1L);
		when(termDAO.countNonPreferredTerms(Mockito.<String>any()))
			.thenReturn(1L);
		when(termDAO.countTerms(Mockito.<String>any()))
			.thenReturn(1L);
		when(termDAO.countTermsWoNotes(Mockito.<String>any()))
			.thenReturn(1L);
		when(splitNonPreferredTermDAO.countItems(Mockito.<String>any()))
			.thenReturn(1L);
		when(conceptDAO.countConcepts(Mockito.<String>any()))
			.thenReturn(1L);
		when(conceptDAO.countConceptsAlignedToExtThes(Mockito.<String>any()))
			.thenReturn(1L);
		when(conceptDAO.countConceptsAlignedToIntThes(Mockito.<String>any()))
			.thenReturn(1L);
		when(conceptDAO.countConceptsAlignedToMyThes(Mockito.<String>any()))
			.thenReturn(1L);
		when(conceptDAO.countConceptsWoNotes(Mockito.<String>any()))
			.thenReturn(1L);
		ThesaurusStatistics result = service.getStatistics("1234");
		assertEquals(1L, (long) (Long) result.getNbOfComplexConcepts());
		assertEquals(1L, (long) (Long) result.getNbOfConcepts());
		assertEquals(1L, (long) (Long) result.getNbOfConceptsAlignedToExtThes());
		assertEquals(1L, (long) (Long) result.getNbOfConceptsAlignedToIntThes());
		assertEquals(1L, (long) (Long) result.getNbOfConceptsAlignedToMyThes());
		assertEquals(1L, (long) (Long) result.getNbOfConceptsWoNotes());
		assertEquals(1L, (long) (Long) result.getNbOfNonPreferredTerms());
		assertEquals(1L, (long) (Long) result.getNbOfTerms());
		assertEquals(1L, (long) (Long) result.getNbOfTermsWoNotes());
		assertEquals(1L, (long) (Long) result.getNbOfThesaurusArrays());
		assertEquals(1L, (long) (Long) result.getNbOfThesaurusGroups());
		assertEquals("1234", result.getThesaurusId());
	}
}
