package fr.mcc.ginco.services;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.when;

import fr.mcc.ginco.beans.ExternalThesaurusType;
import fr.mcc.ginco.dao.IGenericDAO;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

/**
 * Unit tests for fr.mcc.ginco.services.ExternalThesaurusTypeServiceImpl
 *
 * @author Diffblue Cover
 */

public class ExternalThesaurusTypeServiceImplTest {

	@Mock(name = "externalThesaurusTypeDAO")
	private IGenericDAO<fr.mcc.ginco.beans.ExternalThesaurusType, Integer> externalThesaurusTypeDAO;

	@InjectMocks
	private ExternalThesaurusTypeServiceImpl service;

	@Before public void initMocks() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void getExternalThesaurusTypeByIdIdentifierIsZero() {

		// arrange
		ExternalThesaurusType externalThesaurusType = new ExternalThesaurusType();
		externalThesaurusType.setIdentifier(1);
		externalThesaurusType.setLabel("label");
		when(externalThesaurusTypeDAO.getById(Mockito.<Integer>any()))
			.thenReturn(externalThesaurusType);

		// act
		ExternalThesaurusType result = service.getExternalThesaurusTypeById(0);

		// assert
		assertEquals(1, (int) result.getIdentifier());
		assertEquals("label", result.getLabel());
	}

	@Test
	public void getExternalThesaurusTypeList() {

		// arrange
		List<ExternalThesaurusType> list = new ArrayList<ExternalThesaurusType>();
		ExternalThesaurusType externalThesaurusType = new ExternalThesaurusType();
		list.add(externalThesaurusType);
		when(externalThesaurusTypeDAO.findAll())
			.thenReturn(list);

		// act
		List<ExternalThesaurusType> result = service.getExternalThesaurusTypeList();

		// assert
		assertEquals(1, result.size());
		assertSame(externalThesaurusType, result.get(0));
	}
}
