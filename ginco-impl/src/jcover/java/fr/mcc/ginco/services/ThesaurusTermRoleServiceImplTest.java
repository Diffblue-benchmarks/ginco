package fr.mcc.ginco.services;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import fr.mcc.ginco.beans.ThesaurusTermRole;
import fr.mcc.ginco.dao.IThesaurusTermRoleDAO;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

/**
 * Unit tests for fr.mcc.ginco.services.ThesaurusTermRoleServiceImpl
 *
 * @author Diffblue Cover
 */

public class ThesaurusTermRoleServiceImplTest {

	@Mock(name = "thesaurusTermRoleDAO")
	private IThesaurusTermRoleDAO thesaurusTermRoleDAO;

	@InjectMocks
	private ThesaurusTermRoleServiceImpl service;

	@Before public void initMocks() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void getAllThesaurusTermRoleReturnsEmpty() {
		assertTrue((service.getAllThesaurusTermRole()).isEmpty());
	}

	@Test
	public void getDefaultThesaurusTermRole() {

		// arrange
		ThesaurusTermRole thesaurusTermRole = new ThesaurusTermRole();
		thesaurusTermRole.setCode("DE");
		thesaurusTermRole.setLabel("label");
		when(thesaurusTermRoleDAO.getDefaultThesaurusTermRole())
			.thenReturn(thesaurusTermRole);

		// act
		ThesaurusTermRole result = service.getDefaultThesaurusTermRole();

		// assert
		assertEquals("DE", result.getCode());
		assertFalse(result.getDefaultRole());
		assertEquals("label", result.getLabel());
	}

	@Test
	public void getTermRoleCodeIsDEReturnsNull() {
		assertNull(service.getTermRole("DE"));
	}
}
