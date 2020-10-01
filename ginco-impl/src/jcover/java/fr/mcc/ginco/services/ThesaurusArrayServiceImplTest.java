package fr.mcc.ginco.services;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.when;

import fr.mcc.ginco.beans.ThesaurusArray;
import fr.mcc.ginco.dao.IThesaurusArrayDAO;
import fr.mcc.ginco.dao.IThesaurusConceptDAO;
import fr.mcc.ginco.helpers.ThesaurusArrayHelper;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

/**
 * Unit tests for fr.mcc.ginco.services.ThesaurusArrayServiceImpl
 *
 * @author Diffblue Cover
 */

public class ThesaurusArrayServiceImplTest {

	@Mock(name = "nodeLabelService")
	private INodeLabelService nodeLabelService;

	@Mock(name = "thesaurusArrayDAO")
	private IThesaurusArrayDAO thesaurusArrayDAO;

	@Mock(name = "thesaurusArrayHelper")
	private ThesaurusArrayHelper thesaurusArrayHelper;

	@Mock(name = "thesaurusConceptDAO")
	private IThesaurusConceptDAO thesaurusConceptDAO;

	@InjectMocks
	private ThesaurusArrayServiceImpl service;

	@Before public void initMocks() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void getAllThesaurusArrayByThesaurusIdExcludedConceptArrayIdIsBar() {

		// arrange
		List<ThesaurusArray> list = new ArrayList<ThesaurusArray>();
		ThesaurusArray thesaurusArray = new ThesaurusArray();
		list.add(thesaurusArray);
		when(thesaurusArrayDAO.getThesaurusArrayListByThesaurusId(Mockito.<String>any(), Mockito.<String>any()))
			.thenReturn(list);

		// act
		List<ThesaurusArray> result =
			 service.getAllThesaurusArrayByThesaurusId("bar", "1234");

		// assert
		assertEquals(1, result.size());
		assertSame(thesaurusArray, result.get(0));
	}

	@Test
	public void getSubOrdinatedArrays() {

		// arrange
		List<ThesaurusArray> list = new ArrayList<ThesaurusArray>();
		ThesaurusArray thesaurusArray = new ThesaurusArray();
		list.add(thesaurusArray);
		when(thesaurusArrayDAO.getConceptSuperOrdinateArrays(Mockito.<String>any()))
			.thenReturn(list);

		// act
		List<ThesaurusArray> result = service.getSubOrdinatedArrays("1234");

		// assert
		assertEquals(1, result.size());
		assertSame(thesaurusArray, result.get(0));
	}

	@Test
	public void getArraysWithoutParentConcept() {

		// arrange
		List<ThesaurusArray> list = new ArrayList<ThesaurusArray>();
		ThesaurusArray thesaurusArray = new ThesaurusArray();
		list.add(thesaurusArray);
		when(thesaurusArrayDAO.getArraysWithoutSuperordinatedConcept(Mockito.<String>any()))
			.thenReturn(list);

		// act
		List<ThesaurusArray> result = service.getArraysWithoutParentConcept("1234");

		// assert
		assertEquals(1, result.size());
		assertSame(thesaurusArray, result.get(0));
	}

	@Test
	public void getArraysWithoutParentArray() {

		// arrange
		List<ThesaurusArray> list = new ArrayList<ThesaurusArray>();
		ThesaurusArray thesaurusArray = new ThesaurusArray();
		list.add(thesaurusArray);
		when(thesaurusArrayDAO.getArraysWithoutParentArray(Mockito.<String>any()))
			.thenReturn(list);

		// act
		List<ThesaurusArray> result = service.getArraysWithoutParentArray("1234");

		// assert
		assertEquals(1, result.size());
		assertSame(thesaurusArray, result.get(0));
	}

	@Test
	public void getChildrenArrays() {

		// arrange
		List<ThesaurusArray> list = new ArrayList<ThesaurusArray>();
		ThesaurusArray thesaurusArray = new ThesaurusArray();
		list.add(thesaurusArray);
		when(thesaurusArrayDAO.getChildrenArrays(Mockito.<String>any()))
			.thenReturn(list);

		// act
		List<ThesaurusArray> result = service.getChildrenArrays("1234");

		// assert
		assertEquals(1, result.size());
		assertSame(thesaurusArray, result.get(0));
	}
}
