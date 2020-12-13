package fr.mcc.ginco.services;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import fr.mcc.ginco.beans.Thesaurus;
import fr.mcc.ginco.beans.ThesaurusArray;
import fr.mcc.ginco.beans.ThesaurusConcept;
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
	public void getThesaurusArrayById() {

		// arrange
		ThesaurusArray thesaurusArray = new ThesaurusArray();
		thesaurusArray.setIdentifier("data");
		thesaurusArray.setNotation("DE");
		thesaurusArray.setOrdered(false);
		ThesaurusArray parent1 = new ThesaurusArray();
		thesaurusArray.setParent(parent1);
		ThesaurusConcept superOrdinateConcept4 = new ThesaurusConcept();
		thesaurusArray.setSuperOrdinateConcept(superOrdinateConcept4);
		Thesaurus thesaurus7 = new Thesaurus();
		thesaurusArray.setThesaurus(thesaurus7);
		when(thesaurusArrayDAO.getById(Mockito.<String>any()))
			.thenReturn(thesaurusArray);

		// act
		ThesaurusArray result = service.getThesaurusArrayById("1234");

		// assert
		assertTrue((result.getConcepts()).isEmpty());
		assertEquals("data", result.getIdentifier());
		assertEquals("DE", result.getNotation());
		assertFalse(result.getOrdered());
		assertSame(parent1, result.getParent());
		assertSame(superOrdinateConcept4, result.getSuperOrdinateConcept());
		assertSame(thesaurus7, result.getThesaurus());
	}

	@Test
	public void getAllThesaurusArrayByThesaurusId() {

		// arrange
		ArrayList<ThesaurusArray> arrayList = new ArrayList<ThesaurusArray>();
		ThesaurusArray thesaurusArray = new ThesaurusArray();
		arrayList.add(thesaurusArray);
		when(thesaurusArrayDAO.getThesaurusArrayListByThesaurusId(Mockito.<String>any(), Mockito.<String>any()))
			.thenReturn(arrayList);

		// act
		List<ThesaurusArray> result =
			 service.getAllThesaurusArrayByThesaurusId("1234", "1234");

		// assert
		assertEquals(1, result.size());
		assertSame(thesaurusArray, result.get(0));
	}

	@Test
	public void updateOnlyThesaurusArray() {

		// arrange
		ThesaurusArray thesaurusArray1 = new ThesaurusArray();
		thesaurusArray1.setIdentifier("data");
		thesaurusArray1.setNotation("DE");
		thesaurusArray1.setOrdered(false);
		ThesaurusArray parent1 = new ThesaurusArray();
		thesaurusArray1.setParent(parent1);
		ThesaurusConcept superOrdinateConcept4 = new ThesaurusConcept();
		thesaurusArray1.setSuperOrdinateConcept(superOrdinateConcept4);
		Thesaurus thesaurus7 = new Thesaurus();
		thesaurusArray1.setThesaurus(thesaurus7);
		when(thesaurusArrayDAO.update(Mockito.<ThesaurusArray>any()))
			.thenReturn(thesaurusArray1);

		// act
		ThesaurusArray result =
			 service.updateOnlyThesaurusArray(new ThesaurusArray());

		// assert
		assertTrue((result.getConcepts()).isEmpty());
		assertEquals("data", result.getIdentifier());
		assertEquals("DE", result.getNotation());
		assertFalse(result.getOrdered());
		assertSame(parent1, result.getParent());
		assertSame(superOrdinateConcept4, result.getSuperOrdinateConcept());
		assertSame(thesaurus7, result.getThesaurus());
	}

	@Test
	public void destroyThesaurusArray() {

		// arrange
		ThesaurusArray thesaurusArray1 = new ThesaurusArray();
		thesaurusArray1.setIdentifier("data");
		thesaurusArray1.setNotation("DE");
		thesaurusArray1.setOrdered(false);
		ThesaurusArray parent1 = new ThesaurusArray();
		thesaurusArray1.setParent(parent1);
		ThesaurusConcept superOrdinateConcept4 = new ThesaurusConcept();
		thesaurusArray1.setSuperOrdinateConcept(superOrdinateConcept4);
		Thesaurus thesaurus7 = new Thesaurus();
		thesaurusArray1.setThesaurus(thesaurus7);
		when(thesaurusArrayDAO.delete(Mockito.<ThesaurusArray>any()))
			.thenReturn(thesaurusArray1);

		// act
		ThesaurusArray result = service.destroyThesaurusArray(new ThesaurusArray());

		// assert
		assertTrue((result.getConcepts()).isEmpty());
		assertEquals("data", result.getIdentifier());
		assertEquals("DE", result.getNotation());
		assertFalse(result.getOrdered());
		assertSame(parent1, result.getParent());
		assertSame(superOrdinateConcept4, result.getSuperOrdinateConcept());
		assertSame(thesaurus7, result.getThesaurus());
	}

	@Test
	public void getSubOrdinatedArrays() {

		// arrange
		ArrayList<ThesaurusArray> arrayList = new ArrayList<ThesaurusArray>();
		ThesaurusArray thesaurusArray = new ThesaurusArray();
		arrayList.add(thesaurusArray);
		when(thesaurusArrayDAO.getConceptSuperOrdinateArrays(Mockito.<String>any()))
			.thenReturn(arrayList);

		// act
		List<ThesaurusArray> result = service.getSubOrdinatedArrays("1234");

		// assert
		assertEquals(1, result.size());
		assertSame(thesaurusArray, result.get(0));
	}

	@Test
	public void getArraysWithoutParentConcept() {

		// arrange
		ArrayList<ThesaurusArray> arrayList = new ArrayList<ThesaurusArray>();
		ThesaurusArray thesaurusArray = new ThesaurusArray();
		arrayList.add(thesaurusArray);
		when(thesaurusArrayDAO.getArraysWithoutSuperordinatedConcept(Mockito.<String>any()))
			.thenReturn(arrayList);

		// act
		List<ThesaurusArray> result = service.getArraysWithoutParentConcept("1234");

		// assert
		assertEquals(1, result.size());
		assertSame(thesaurusArray, result.get(0));
	}

	@Test
	public void getArraysWithoutParentArray() {

		// arrange
		ArrayList<ThesaurusArray> arrayList = new ArrayList<ThesaurusArray>();
		ThesaurusArray thesaurusArray = new ThesaurusArray();
		arrayList.add(thesaurusArray);
		when(thesaurusArrayDAO.getArraysWithoutParentArray(Mockito.<String>any()))
			.thenReturn(arrayList);

		// act
		List<ThesaurusArray> result = service.getArraysWithoutParentArray("1234");

		// assert
		assertEquals(1, result.size());
		assertSame(thesaurusArray, result.get(0));
	}

	@Test
	public void getChildrenArrays() {

		// arrange
		ArrayList<ThesaurusArray> arrayList = new ArrayList<ThesaurusArray>();
		ThesaurusArray thesaurusArray = new ThesaurusArray();
		arrayList.add(thesaurusArray);
		when(thesaurusArrayDAO.getChildrenArrays(Mockito.<String>any()))
			.thenReturn(arrayList);

		// act
		List<ThesaurusArray> result = service.getChildrenArrays("1234");

		// assert
		assertEquals(1, result.size());
		assertSame(thesaurusArray, result.get(0));
	}
}
