package fr.mcc.ginco.helpers;

import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import fr.mcc.ginco.beans.ThesaurusArray;
import fr.mcc.ginco.beans.ThesaurusArrayConcept;
import fr.mcc.ginco.dao.IThesaurusArrayConceptDAO;
import fr.mcc.ginco.dao.IThesaurusConceptDAO;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

/**
 * Unit tests for fr.mcc.ginco.helpers.ThesaurusArrayHelper
 *
 * @author Diffblue Cover
 */

public class ThesaurusArrayHelperTest {

	@Mock(name = "thesaurusArrayConceptDAO")
	private IThesaurusArrayConceptDAO thesaurusArrayConceptDAO;

	@Mock(name = "thesaurusConceptDAO")
	private IThesaurusConceptDAO thesaurusConceptDAO;

	@InjectMocks
	private ThesaurusArrayHelper service;

	@Before public void initMocks() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void getArrayConceptRelationsReturnsEmpty() {
		when(thesaurusArrayConceptDAO.getThesaurusArrayConceptsByArray(Mockito.<ThesaurusArray>any()))
			.thenReturn(new ArrayList<ThesaurusArrayConcept>());
		assertTrue((service.getArrayConceptRelations(new ThesaurusArray())).isEmpty());
	}

	@Test
	public void getArrayConceptsReturnsEmpty() {
		when(thesaurusArrayConceptDAO.getAssociatedConcepts(Mockito.<String>any()))
			.thenReturn(new ArrayList<String>());
		assertTrue((service.getArrayConcepts("1234")).isEmpty());
	}

	@Test
	public void saveArrayConcepts1() {
		ThesaurusArray array = new ThesaurusArray();
		array.setConcepts(null);
		assertSame(array, service.saveArrayConcepts(array, new ArrayList<ThesaurusArrayConcept>()));
		assertTrue((array.getConcepts()).isEmpty());
	}

	@Test
	public void saveArrayConcepts2() {
		ThesaurusArray array = new ThesaurusArray();
		assertSame(array, service.saveArrayConcepts(array, new ArrayList<ThesaurusArrayConcept>()));
	}
}
