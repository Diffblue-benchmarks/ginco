package fr.mcc.ginco.helpers;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.when;

import fr.mcc.ginco.beans.ThesaurusArray;
import fr.mcc.ginco.beans.ThesaurusArrayConcept;
import fr.mcc.ginco.dao.IThesaurusArrayConceptDAO;
import fr.mcc.ginco.dao.IThesaurusConceptDAO;

import java.util.ArrayList;
import java.util.List;

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
	public void getArrayConceptRelations() {

		// arrange
		List<ThesaurusArrayConcept> list = new ArrayList<ThesaurusArrayConcept>();
		ThesaurusArrayConcept thesaurusArrayConcept = new ThesaurusArrayConcept();
		list.add(thesaurusArrayConcept);
		when(thesaurusArrayConceptDAO.getThesaurusArrayConceptsByArray(Mockito.<ThesaurusArray>any()))
			.thenReturn(list);

		// act
		List<ThesaurusArrayConcept> result =
			 service.getArrayConceptRelations(new ThesaurusArray());

		// assert
		assertEquals(1, result.size());
		assertSame(thesaurusArrayConcept, result.get(0));
	}

	@Test
	public void saveArrayConcepts() {
		when(thesaurusArrayConceptDAO.getAssociatedConcepts(Mockito.<String>any()))
			.thenReturn(new ArrayList<String>());
		ThesaurusArray array = new ThesaurusArray();
		ArrayList<ThesaurusArrayConcept> concepts2 =
			 new ArrayList<ThesaurusArrayConcept>();
		ThesaurusArrayConcept thesaurusArrayConcept = new ThesaurusArrayConcept();
		thesaurusArrayConcept.setIdentifier(new ThesaurusArrayConcept.Id());
		concepts2.add(thesaurusArrayConcept);
		assertSame(array, service.saveArrayConcepts(array, concepts2));
		assertEquals(1, array.getConcepts().size());
	}
}
