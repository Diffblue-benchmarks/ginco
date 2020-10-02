package fr.mcc.ginco.services;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.when;

import fr.mcc.ginco.beans.ThesaurusType;
import fr.mcc.ginco.dao.IThesaurusTypeDAO;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

/**
 * Unit tests for fr.mcc.ginco.services.ThesaurusTypeServiceImpl
 *
 * @author Diffblue Cover
 */

public class ThesaurusTypeServiceImplTest {

	@Mock(name = "thesaurusTypeDAO")
	private IThesaurusTypeDAO thesaurusTypeDAO;

	@InjectMocks
	private ThesaurusTypeServiceImpl service;

	@Before public void initMocks() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void getThesaurusTypeList() {

		// arrange
		List<ThesaurusType> list = new ArrayList<ThesaurusType>();
		ThesaurusType thesaurusType = new ThesaurusType();
		list.add(thesaurusType);
		when(thesaurusTypeDAO.findAll(Mockito.<String>any(), Mockito.<fr.mcc.ginco.dao.IGenericDAO.SortingTypes>any()))
			.thenReturn(list);

		// act
		List<ThesaurusType> result = service.getThesaurusTypeList();

		// assert
		assertEquals(1, result.size());
		assertSame(thesaurusType, result.get(0));
	}

	@Test
	public void getThesaurusTypeByIdIdIsOne() {

		// arrange
		ThesaurusType thesaurusType = new ThesaurusType();
		thesaurusType.setIdentifier(1);
		thesaurusType.setLabel("label");
		when(thesaurusTypeDAO.getById(Mockito.<Integer>any()))
			.thenReturn(thesaurusType);

		// act
		ThesaurusType result = service.getThesaurusTypeById(1);

		// assert
		assertEquals(1, (int) result.getIdentifier());
		assertEquals("label", result.getLabel());
	}
}
