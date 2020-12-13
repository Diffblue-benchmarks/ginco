package fr.mcc.ginco.services;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.when;

import fr.mcc.ginco.beans.Thesaurus;
import fr.mcc.ginco.beans.ThesaurusConcept;
import fr.mcc.ginco.beans.ThesaurusTerm;
import fr.mcc.ginco.dao.IThesaurusConceptDAO;
import fr.mcc.ginco.dao.IThesaurusTermDAO;
import fr.mcc.ginco.solr.SearchResult;
import fr.mcc.ginco.solr.SearchResultList;

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
	public void getConceptsWithoutNotesLimitIsOneAndStartIndexIsOne() {

		// arrange
		ThesaurusTerm thesaurusTerm = new ThesaurusTerm();
		thesaurusTerm.setLexicalValue("value");
		when(thesaurusConceptService.getConceptPreferredTerm(Mockito.<String>any()))
			.thenReturn(thesaurusTerm);
		ArrayList<ThesaurusConcept> arrayList = new ArrayList<ThesaurusConcept>();
		ThesaurusConcept thesaurusConcept = new ThesaurusConcept();
		thesaurusConcept.setIdentifier("data");
		Thesaurus thesaurus3 = new Thesaurus();
		thesaurus3.setIdentifier("data");
		thesaurusConcept.setThesaurus(thesaurus3);
		arrayList.add(thesaurusConcept);
		when(conceptDAO.countConceptsWoNotes(Mockito.<String>any()))
			.thenReturn(1L);
		when(conceptDAO.getConceptsWoNotes(Mockito.<String>any(), anyInt(), anyInt()))
			.thenReturn(arrayList);

		// act
		SearchResultList result =
			 service.getConceptsWithoutNotes("/some/path.html", 1, 1);

		// assert
		assertEquals(1, result.size());
		assertNull(((SearchResult) result.get(0)).getConceptId());
		assertNull(((SearchResult) result.get(0)).getCreated());
		assertEquals("data", ((SearchResult) result.get(0)).getIdentifier());
		assertNull(((SearchResult) result.get(0)).getLanguages());
		assertEquals("value", ((SearchResult) result.get(0)).getLexicalValue());
		assertNull(((SearchResult) result.get(0)).getModified());
		assertNull(((SearchResult) result.get(0)).getStatus());
		assertEquals("data", ((SearchResult) result.get(0)).getThesaurusId());
		assertNull(((SearchResult) result.get(0)).getThesaurusTitle());
		assertEquals("ThesaurusConcept", ((SearchResult) result.get(0)).getType());
		assertNull(((SearchResult) result.get(0)).getTypeExt());
	}

	@Test
	public void getConceptsAlignedToMyThesLimitIsOneAndStartIndexIsOne() {

		// arrange
		ThesaurusTerm thesaurusTerm = new ThesaurusTerm();
		thesaurusTerm.setLexicalValue("value");
		when(thesaurusConceptService.getConceptPreferredTerm(Mockito.<String>any()))
			.thenReturn(thesaurusTerm);
		ArrayList<ThesaurusConcept> arrayList = new ArrayList<ThesaurusConcept>();
		ThesaurusConcept thesaurusConcept = new ThesaurusConcept();
		thesaurusConcept.setIdentifier("data");
		Thesaurus thesaurus3 = new Thesaurus();
		thesaurus3.setIdentifier("data");
		thesaurusConcept.setThesaurus(thesaurus3);
		arrayList.add(thesaurusConcept);
		when(conceptDAO.countConceptsAlignedToMyThes(Mockito.<String>any()))
			.thenReturn(1L);
		when(conceptDAO.getConceptsAlignedToMyThes(Mockito.<String>any(), anyInt(), anyInt()))
			.thenReturn(arrayList);

		// act
		SearchResultList result =
			 service.getConceptsAlignedToMyThes("/some/path.html", 1, 1);

		// assert
		assertEquals(1, result.size());
		assertNull(((SearchResult) result.get(0)).getConceptId());
		assertNull(((SearchResult) result.get(0)).getCreated());
		assertEquals("data", ((SearchResult) result.get(0)).getIdentifier());
		assertNull(((SearchResult) result.get(0)).getLanguages());
		assertEquals("value", ((SearchResult) result.get(0)).getLexicalValue());
		assertNull(((SearchResult) result.get(0)).getModified());
		assertNull(((SearchResult) result.get(0)).getStatus());
		assertEquals("data", ((SearchResult) result.get(0)).getThesaurusId());
		assertNull(((SearchResult) result.get(0)).getThesaurusTitle());
		assertEquals("ThesaurusConcept", ((SearchResult) result.get(0)).getType());
		assertNull(((SearchResult) result.get(0)).getTypeExt());
	}

	@Test
	public void getTermsWithoutNotesLimitIsOneAndStartIndexIsOne() {

		// arrange
		ArrayList<ThesaurusTerm> arrayList = new ArrayList<ThesaurusTerm>();
		ThesaurusTerm thesaurusTerm = new ThesaurusTerm();
		thesaurusTerm.setIdentifier("data");
		thesaurusTerm.setLexicalValue("value");
		arrayList.add(thesaurusTerm);
		when(termDAO.countTermsWoNotes(Mockito.<String>any()))
			.thenReturn(1L);
		when(termDAO.getTermsWoNotes(Mockito.<String>any(), anyInt(), anyInt()))
			.thenReturn(arrayList);

		// act
		SearchResultList result =
			 service.getTermsWithoutNotes("/some/path.html", 1, 1);

		// assert
		assertEquals(1, result.size());
		assertNull(((SearchResult) result.get(0)).getConceptId());
		assertNull(((SearchResult) result.get(0)).getCreated());
		assertEquals("data", ((SearchResult) result.get(0)).getIdentifier());
		assertNull(((SearchResult) result.get(0)).getLanguages());
		assertEquals("value", ((SearchResult) result.get(0)).getLexicalValue());
		assertNull(((SearchResult) result.get(0)).getModified());
		assertNull(((SearchResult) result.get(0)).getStatus());
		assertEquals("/some/path.html", ((SearchResult) result.get(0)).getThesaurusId());
		assertNull(((SearchResult) result.get(0)).getThesaurusTitle());
		assertEquals("ThesaurusTerm", ((SearchResult) result.get(0)).getType());
		assertNull(((SearchResult) result.get(0)).getTypeExt());
	}
}
