package fr.mcc.ginco.services;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import fr.mcc.ginco.beans.ExternalThesaurusType;
import fr.mcc.ginco.dao.IGenericDAO;

import java.util.ArrayList;

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
	public void getExternalThesaurusTypeListReturnsEmpty() {
		when(externalThesaurusTypeDAO.findAll())
			.thenReturn(new ArrayList<ExternalThesaurusType>());
		assertTrue((service.getExternalThesaurusTypeList()).isEmpty());
	}
}
