package fr.mcc.ginco.services;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.when;

import fr.mcc.ginco.beans.ThesaurusConceptGroupType;
import fr.mcc.ginco.dao.IThesaurusConceptGroupTypeDAO;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

/**
 * Unit tests for fr.mcc.ginco.services.ThesaurusConceptGroupTypeServiceImpl
 *
 * @author Diffblue Cover
 */

public class ThesaurusConceptGroupTypeServiceImplTest {

	@Mock(name = "thesaurusConceptGroupTypeDAO")
	private IThesaurusConceptGroupTypeDAO thesaurusConceptGroupTypeDAO;

	@InjectMocks
	private ThesaurusConceptGroupTypeServiceImpl service;

	@Before public void initMocks() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void getConceptGroupTypeList() {

		// arrange
		ArrayList<ThesaurusConceptGroupType> arrayList =
			 new ArrayList<ThesaurusConceptGroupType>();
		ThesaurusConceptGroupType thesaurusConceptGroupType =
			 new ThesaurusConceptGroupType();
		arrayList.add(thesaurusConceptGroupType);
		when(thesaurusConceptGroupTypeDAO.findAll())
			.thenReturn(arrayList);

		// act
		List<ThesaurusConceptGroupType> result = service.getConceptGroupTypeList();

		// assert
		assertEquals(1, result.size());
		assertSame(thesaurusConceptGroupType, result.get(0));
	}

	@Test
	public void getTypeById() {

		// arrange
		ThesaurusConceptGroupType thesaurusConceptGroupType =
			 new ThesaurusConceptGroupType();
		thesaurusConceptGroupType.setCode("DE");
		thesaurusConceptGroupType.setLabel("label");
		thesaurusConceptGroupType.setSkosLabel("label");
		when(thesaurusConceptGroupTypeDAO.getById(Mockito.<String>any()))
			.thenReturn(thesaurusConceptGroupType);

		// act
		ThesaurusConceptGroupType result = service.getTypeById("text/plain");

		// assert
		assertEquals("DE", result.getCode());
		assertEquals("label", result.getLabel());
		assertEquals("label", result.getSkosLabel());
	}
}
