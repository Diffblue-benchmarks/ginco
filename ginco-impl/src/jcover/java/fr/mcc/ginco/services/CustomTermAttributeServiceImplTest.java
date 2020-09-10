package fr.mcc.ginco.services;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import fr.mcc.ginco.beans.CustomTermAttribute;
import fr.mcc.ginco.beans.CustomTermAttributeType;
import fr.mcc.ginco.beans.ThesaurusTerm;
import fr.mcc.ginco.dao.ICustomTermAttributeDAO;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

/**
 * Unit tests for fr.mcc.ginco.services.CustomTermAttributeServiceImpl
 *
 * @author Diffblue Cover
 */

public class CustomTermAttributeServiceImplTest {

	@Mock(name = "customTermAttributeDAO")
	private ICustomTermAttributeDAO customTermAttributeDAO;

	@InjectMocks
	private CustomTermAttributeServiceImpl service;

	@Before public void initMocks() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void deleteAttribute() {
		service.deleteAttribute(new CustomTermAttribute());
	}

	@Test
	public void getAttributeByTypeReturnsNull() {
		assertNull(service.getAttributeByType(new ThesaurusTerm(), new CustomTermAttributeType()));
	}

	@Test
	public void getAttributesByEntityReturnsEmpty() {
		assertTrue((service.getAttributesByEntity(new ThesaurusTerm())).isEmpty());
	}

	@Test
	public void saveOrUpdateReturnsNull() {
		assertNull(service.saveOrUpdate(new CustomTermAttribute()));
	}
}
