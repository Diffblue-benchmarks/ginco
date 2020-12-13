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
	public void getExternalThesaurusByIdIdentifierIsOne() {

		// arrange
		ExternalThesaurus externalThesaurus = new ExternalThesaurus();
		externalThesaurus.setExternalId("1234");
		ExternalThesaurusType externalThesaurusType = new ExternalThesaurusType();
		externalThesaurus.setExternalThesaurusType(externalThesaurusType);
		externalThesaurus.setIdentifier(1);
		when(externalThesaurusDAO.getById(Mockito.<Integer>any()))
			.thenReturn(externalThesaurus);

		// act
		ExternalThesaurus result = service.getExternalThesaurusById(1);

		// assert
		assertEquals("1234", result.getExternalId());
		assertSame(externalThesaurusType, result.getExternalThesaurusType());
		assertEquals(1, (int) result.getIdentifier());
	}

	@Test
	public void getThesaurusByExternalId() {

		// arrange
		ExternalThesaurus externalThesaurus = new ExternalThesaurus();
		externalThesaurus.setExternalId("1234");
		ExternalThesaurusType externalThesaurusType = new ExternalThesaurusType();
		externalThesaurus.setExternalThesaurusType(externalThesaurusType);
		externalThesaurus.setIdentifier(1);
		when(externalThesaurusDAO.findBySourceExternalId(Mockito.<String>any()))
			.thenReturn(externalThesaurus);

		// act
		ExternalThesaurus result = service.getThesaurusByExternalId("1234");

		// assert
		assertEquals("1234", result.getExternalId());
		assertSame(externalThesaurusType, result.getExternalThesaurusType());
		assertEquals(1, (int) result.getIdentifier());
	}

	@Test
	public void getExternalThesaurusList() {

		// arrange
		ArrayList<ExternalThesaurus> arrayList = new ArrayList<ExternalThesaurus>();
		ExternalThesaurus externalThesaurus = new ExternalThesaurus();
		arrayList.add(externalThesaurus);
		when(externalThesaurusDAO.findAllByExternalIdQuery(Mockito.<String>any()))
			.thenReturn(arrayList);

		// act
		List<ExternalThesaurus> result = service.getExternalThesaurusList("1234");

		// assert
		assertEquals(1, result.size());
		assertSame(externalThesaurus, result.get(0));
	}
}
