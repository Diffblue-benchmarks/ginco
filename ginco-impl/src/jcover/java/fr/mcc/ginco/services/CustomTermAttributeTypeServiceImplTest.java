package fr.mcc.ginco.services;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import fr.mcc.ginco.beans.CustomTermAttributeType;
import fr.mcc.ginco.beans.Thesaurus;
import fr.mcc.ginco.dao.ICustomTermAttributeTypeDAO;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

/**
 * Unit tests for fr.mcc.ginco.services.CustomTermAttributeTypeServiceImpl
 *
 * @author Diffblue Cover
 */

public class CustomTermAttributeTypeServiceImplTest {

	@Mock(name = "customTermAttributeTypeDAO")
	private ICustomTermAttributeTypeDAO customTermAttributeTypeDAO;

	@InjectMocks
	private CustomTermAttributeTypeServiceImpl service;

	@Before public void initMocks() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void deleteAttribute() {
		service.deleteAttribute(new CustomTermAttributeType());
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
		assertNull(service.saveOrUpdate(new CustomTermAttributeType()));
	}
}
