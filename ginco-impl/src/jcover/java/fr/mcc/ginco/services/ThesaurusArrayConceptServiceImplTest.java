package fr.mcc.ginco.services;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.when;

import fr.mcc.ginco.beans.ThesaurusArrayConcept;
import fr.mcc.ginco.beans.ThesaurusConcept;
import fr.mcc.ginco.dao.IGenericDAO;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

/**
 * Unit tests for fr.mcc.ginco.services.ThesaurusArrayConceptServiceImpl
 *
 * @author Diffblue Cover
 */

public class ThesaurusArrayConceptServiceImplTest {

	@Mock(name = "thesaurusArrayConceptDAO")
	private IGenericDAO<fr.mcc.ginco.beans.ThesaurusArrayConcept, fr.mcc.ginco.beans.ThesaurusArrayConcept.Id> thesaurusArrayConceptDAO;

	@InjectMocks
	private ThesaurusArrayConceptServiceImpl service;

	@Before public void initMocks() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void geThesaurusArrayConceptConceptIdIsFooAndThesaurusArrayIdIsBar() {

		// arrange
		ThesaurusArrayConcept thesaurusArrayConcept = new ThesaurusArrayConcept();
		thesaurusArrayConcept.setArrayOrder(1);
		ThesaurusConcept concept = new ThesaurusConcept();
		thesaurusArrayConcept.setConcepts(concept);
		ThesaurusArrayConcept.Id identifier2 = new ThesaurusArrayConcept.Id();
		thesaurusArrayConcept.setIdentifier(identifier2);
		when(thesaurusArrayConceptDAO.getById(Mockito.<ThesaurusArrayConcept.Id>any()))
			.thenReturn(thesaurusArrayConcept);

		// act
		ThesaurusArrayConcept result = service.geThesaurusArrayConcept("bar", "foo");

		// assert
		assertEquals(1, (int) result.getArrayOrder());
		assertSame(concept, result.getConcepts());
		assertSame(identifier2, result.getIdentifier());
	}
}
