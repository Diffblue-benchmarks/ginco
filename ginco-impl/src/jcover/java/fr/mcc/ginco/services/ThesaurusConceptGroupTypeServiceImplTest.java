package fr.mcc.ginco.services;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import fr.mcc.ginco.dao.IThesaurusConceptGroupTypeDAO;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

/**
 * Unit tests for fr.mcc.ginco.services.ThesaurusConceptGroupTypeServiceImpl
 *
 * @author Diffblue Cover
 */

public class ThesaurusConceptGroupTypeServiceImplTest {

	@Mock(name = "thesaurusConceptGroupTypeDAO")
	private IThesaurusConceptGroupTypeDAO thesaurusConceptGroupTypeDAO;

	@InjectMocks
	private ThesaurusConceptGroupTypeServiceImpl service;

	@Before public void initMocks() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void getConceptGroupTypeListReturnsEmpty() {
		assertTrue((service.getConceptGroupTypeList()).isEmpty());
	}

	@Test
	public void getTypeByIdReturnsNull() {
		assertNull(service.getTypeById("text/plain"));
	}
}
