package fr.mcc.ginco.services;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import fr.mcc.ginco.dao.IThesaurusTypeDAO;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
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
	public void getThesaurusTypeByIdIdIsOneReturnsNull() {
		assertNull(service.getThesaurusTypeById(1));
	}

	@Test
	public void getThesaurusTypeListReturnsEmpty() {
		assertTrue((service.getThesaurusTypeList()).isEmpty());
	}
}
