package fr.mcc.ginco.services;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.when;

import fr.mcc.ginco.beans.ThesaurusTermRole;
import fr.mcc.ginco.dao.IThesaurusTermRoleDAO;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
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
	public void getAllThesaurusTermRole() {

		// arrange
		List<ThesaurusTermRole> list = new ArrayList<ThesaurusTermRole>();
		ThesaurusTermRole thesaurusTermRole = new ThesaurusTermRole();
		list.add(thesaurusTermRole);
		when(thesaurusTermRoleDAO.findAll())
			.thenReturn(list);

		// act
		List<ThesaurusTermRole> result = service.getAllThesaurusTermRole();

		// assert
		assertEquals(1, result.size());
		assertSame(thesaurusTermRole, result.get(0));
	}

	@Test
	public void getTermRoleCodeIsDE() {

		// arrange
		ThesaurusTermRole thesaurusTermRole = new ThesaurusTermRole();
		thesaurusTermRole.setCode("DE");
		thesaurusTermRole.setLabel("label");
		when(thesaurusTermRoleDAO.getById(Mockito.<String>any()))
			.thenReturn(thesaurusTermRole);

		// act
		ThesaurusTermRole result = service.getTermRole("DE");

		// assert
		assertEquals("DE", result.getCode());
		assertFalse(result.getDefaultRole());
		assertEquals("label", result.getLabel());
	}
}