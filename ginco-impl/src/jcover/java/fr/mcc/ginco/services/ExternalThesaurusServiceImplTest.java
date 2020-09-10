package fr.mcc.ginco.services;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import fr.mcc.ginco.beans.ExternalThesaurus;
import fr.mcc.ginco.beans.ExternalThesaurusType;
import fr.mcc.ginco.dao.IExternalThesaurusDAO;

import java.util.ArrayList;

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
	public void getExternalThesaurusByIdIdentifierIsOneReturnsNull() {
		assertNull(service.getExternalThesaurusById(1));
	}

	@Test
	public void getExternalThesaurusListReturnsEmpty() {
		when(externalThesaurusDAO.findAllByExternalIdQuery(Mockito.<String>any()))
			.thenReturn(new ArrayList<ExternalThesaurus>());
		assertTrue((service.getExternalThesaurusList("1234")).isEmpty());
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
}
