package fr.mcc.ginco.services;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import fr.mcc.ginco.beans.CustomConceptAttribute;
import fr.mcc.ginco.beans.CustomConceptAttributeType;
import fr.mcc.ginco.beans.ThesaurusConcept;
import fr.mcc.ginco.dao.ICustomConceptAttributeDAO;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

/**
 * Unit tests for fr.mcc.ginco.services.CustomConceptAttributeServiceImpl
 *
 * @author Diffblue Cover
 */

public class CustomConceptAttributeServiceImplTest {

	@Mock(name = "customConceptAttributeDAO")
	private ICustomConceptAttributeDAO customConceptAttributeDAO;

	@InjectMocks
	private CustomConceptAttributeServiceImpl service;

	@Before public void initMocks() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void deleteAttribute() {
		service.deleteAttribute(new CustomConceptAttribute());
	}

	@Test
	public void getAttributeByTypeReturnsNull() {
		assertNull(service.getAttributeByType(new ThesaurusConcept(), new CustomConceptAttributeType()));
	}

	@Test
	public void getAttributesByEntityReturnsEmpty() {
		assertTrue((service.getAttributesByEntity(new ThesaurusConcept())).isEmpty());
	}

	@Test
	public void saveOrUpdateReturnsNull() {
		assertNull(service.saveOrUpdate(new CustomConceptAttribute()));
	}
}
