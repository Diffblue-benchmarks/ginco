package fr.mcc.ginco.services;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.when;

import fr.mcc.ginco.beans.ExternalThesaurus;
import fr.mcc.ginco.beans.ExternalThesaurusType;
import fr.mcc.ginco.dao.IExternalThesaurusDAO;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

/**
 * Unit tests for fr.mcc.ginco.services.ExternalThesaurusServiceImpl
 *
 * @author Diffblue Cover
 */

public class ExternalThesaurusServiceImplTest {

	@Mock(name = "externalThesaurusDAO")
	private IExternalThesaurusDAO externalThesaurusDAO;

	@InjectMocks
	private ExternalThesaurusServiceImpl service;

	@Before public void initMocks() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void getExternalThesaurusByIdIdentifierIsZero() {

		// arrange
		ExternalThesaurus externalThesaurus = new ExternalThesaurus();
		externalThesaurus.setExternalId("1234");
		ExternalThesaurusType externalThesaurusType = new ExternalThesaurusType();
		externalThesaurus.setExternalThesaurusType(externalThesaurusType);
		externalThesaurus.setIdentifier(1);
		when(externalThesaurusDAO.getById(Mockito.<Integer>any()))
			.thenReturn(externalThesaurus);

		// act
		ExternalThesaurus result = service.getExternalThesaurusById(0);

		// assert
		assertEquals("1234", result.getExternalId());
		assertSame(externalThesaurusType, result.getExternalThesaurusType());
		assertEquals(1, (int) result.getIdentifier());
	}

	@Test
	public void getThesaurusByExternalIdExternalIdIsBar() {

		// arrange
		ExternalThesaurus externalThesaurus = new ExternalThesaurus();
		externalThesaurus.setExternalId("1234");
		ExternalThesaurusType externalThesaurusType = new ExternalThesaurusType();
		externalThesaurus.setExternalThesaurusType(externalThesaurusType);
		externalThesaurus.setIdentifier(1);
		when(externalThesaurusDAO.findBySourceExternalId(Mockito.<String>any()))
			.thenReturn(externalThesaurus);

		// act
		ExternalThesaurus result = service.getThesaurusByExternalId("bar");

		// assert
		assertEquals("1234", result.getExternalId());
		assertSame(externalThesaurusType, result.getExternalThesaurusType());
		assertEquals(1, (int) result.getIdentifier());
	}

	@Test
	public void getExternalThesaurusListExternalIdQueryIsBar() {

		// arrange
		List<ExternalThesaurus> list = new ArrayList<ExternalThesaurus>();
		ExternalThesaurus externalThesaurus = new ExternalThesaurus();
		list.add(externalThesaurus);
		when(externalThesaurusDAO.findAllByExternalIdQuery(Mockito.<String>any()))
			.thenReturn(list);

		// act
		List<ExternalThesaurus> result = service.getExternalThesaurusList("bar");

		// assert
		assertEquals(1, result.size());
		assertSame(externalThesaurus, result.get(0));
	}
}
