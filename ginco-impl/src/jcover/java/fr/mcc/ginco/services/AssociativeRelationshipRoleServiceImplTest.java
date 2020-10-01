package fr.mcc.ginco.services;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.when;

import fr.mcc.ginco.beans.AssociativeRelationshipRole;
import fr.mcc.ginco.dao.IAssociativeRelationshipRoleDAO;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

/**
 * Unit tests for fr.mcc.ginco.services.AssociativeRelationshipRoleServiceImpl
 *
 * @author Diffblue Cover
 */

public class AssociativeRelationshipRoleServiceImplTest {

	@Mock(name = "associativeRelationshipRoleDAO")
	private IAssociativeRelationshipRoleDAO associativeRelationshipRoleDAO;

	@InjectMocks
	private AssociativeRelationshipRoleServiceImpl service;

	@Before public void initMocks() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void getAllAssociationTermRole() {

		// arrange
		List<AssociativeRelationshipRole> list =
			 new ArrayList<AssociativeRelationshipRole>();
		AssociativeRelationshipRole associativeRelationshipRole =
			 new AssociativeRelationshipRole();
		list.add(associativeRelationshipRole);
		when(associativeRelationshipRoleDAO.findAll())
			.thenReturn(list);

		// act
		List<AssociativeRelationshipRole> result =
			 service.getAllAssociationTermRole();

		// assert
		assertEquals(1, result.size());
		assertSame(associativeRelationshipRole, result.get(0));
	}

	@Test
	public void getRoleById() {

		// arrange
		AssociativeRelationshipRole associativeRelationshipRole =
			 new AssociativeRelationshipRole();
		associativeRelationshipRole.setCode("DE");
		associativeRelationshipRole.setLabel("label");
		associativeRelationshipRole.setSkosLabel("label");
		when(associativeRelationshipRoleDAO.getById(Mockito.<String>any()))
			.thenReturn(associativeRelationshipRole);

		// act
		AssociativeRelationshipRole result = service.getRoleById("1234");

		// assert
		assertEquals("DE", result.getCode());
		assertFalse(result.getDefaultRole());
		assertEquals("label", result.getLabel());
		assertEquals("label", result.getSkosLabel());
	}

	@Test
	public void getDefaultAssociativeRelationshipRoleRole() {

		// arrange
		AssociativeRelationshipRole associativeRelationshipRole =
			 new AssociativeRelationshipRole();
		associativeRelationshipRole.setCode("DE");
		associativeRelationshipRole.setLabel("label");
		associativeRelationshipRole.setSkosLabel("label");
		when(associativeRelationshipRoleDAO.getDefaultAssociativeRelationshipRole())
			.thenReturn(associativeRelationshipRole);

		// act
		AssociativeRelationshipRole result =
			 service.getDefaultAssociativeRelationshipRoleRole();

		// assert
		assertEquals("DE", result.getCode());
		assertFalse(result.getDefaultRole());
		assertEquals("label", result.getLabel());
		assertEquals("label", result.getSkosLabel());
	}

	@Test
	public void getRoleBySkosLabelSkosLabelIsBar() {

		// arrange
		AssociativeRelationshipRole associativeRelationshipRole =
			 new AssociativeRelationshipRole();
		associativeRelationshipRole.setCode("DE");
		associativeRelationshipRole.setLabel("label");
		associativeRelationshipRole.setSkosLabel("label");
		when(associativeRelationshipRoleDAO.getBySkosLabel(Mockito.<String>any()))
			.thenReturn(associativeRelationshipRole);

		// act
		AssociativeRelationshipRole result = service.getRoleBySkosLabel("bar");

		// assert
		assertEquals("DE", result.getCode());
		assertFalse(result.getDefaultRole());
		assertEquals("label", result.getLabel());
		assertEquals("label", result.getSkosLabel());
	}
}
