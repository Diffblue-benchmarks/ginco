package fr.mcc.ginco.services;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import fr.mcc.ginco.beans.CustomConceptAttributeType;
import fr.mcc.ginco.beans.Thesaurus;
import fr.mcc.ginco.dao.ICustomConceptAttributeTypeDAO;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

/**
 * Unit tests for fr.mcc.ginco.services.CustomConceptAttributeTypeServiceImpl
 *
 * @author Diffblue Cover
 */

public class CustomConceptAttributeTypeServiceImplTest {

	@Mock(name = "customConceptAttributeTypeDAO")
	private ICustomConceptAttributeTypeDAO customConceptAttributeTypeDAO;

	@InjectMocks
	private CustomConceptAttributeTypeServiceImpl service;

	@Before public void initMocks() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void deleteAttribute() {
		service.deleteAttribute(new CustomConceptAttributeType());
	}

	@Test
	public void getAttributeTypeByIdIdIsOneReturnsNull() {
		assertNull(service.getAttributeTypeById(1));
	}

	@Test
	public void getAttributeTypesByThesaurusReturnsEmpty() {
		assertTrue((service.getAttributeTypesByThesaurus(new Thesaurus())).isEmpty());
	}

	@Test
	public void saveOrUpdateReturnsNull() {
		assertNull(service.saveOrUpdate(new CustomConceptAttributeType()));
	}
}
