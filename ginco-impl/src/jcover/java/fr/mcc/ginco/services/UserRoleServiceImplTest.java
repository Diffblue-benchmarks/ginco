package fr.mcc.ginco.services;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import fr.mcc.ginco.beans.Role;
import fr.mcc.ginco.beans.UserRole;
import fr.mcc.ginco.dao.IUserRoleDAO;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

/**
 * Unit tests for fr.mcc.ginco.services.UserRoleServiceImpl
 *
 * @author Diffblue Cover
 */

public class UserRoleServiceImplTest {

	@Mock(name = "userRoleDAO")
	private IUserRoleDAO userRoleDAO;

	@InjectMocks
	private UserRoleServiceImpl service;

	@Before public void initMocks() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void hasRoleRoleIsManagerAndThesaurusIdIsRootAndUsernameIsRootReturnsTrue() {
		UserRole userRole = new UserRole();
		userRole.setRole(Role.MANAGER);
		when(userRoleDAO.getUserRoleOnThesaurus(Mockito.<String>any(), Mockito.<String>any()))
			.thenReturn(userRole);
		assertTrue(service.hasRole("root", "root", Role.MANAGER));
	}

	@Test
	public void getThesaurusUsersThesaurusIdIsRoot() {

		// arrange
		List<UserRole> list = new ArrayList<UserRole>();
		UserRole userRole = new UserRole();
		list.add(userRole);
		when(userRoleDAO.getUserRolesOnThesaurus(Mockito.<String>any()))
			.thenReturn(list);

		// act
		List<UserRole> result = service.getThesaurusUsers("root");

		// assert
		assertEquals(1, result.size());
		assertSame(userRole, result.get(0));
	}

	@Test
	public void getUserRolesUsernameIsRoot() {

		// arrange
		List<UserRole> list = new ArrayList<UserRole>();
		UserRole userRole = new UserRole();
		list.add(userRole);
		when(userRoleDAO.getUserRoles(Mockito.<String>any()))
			.thenReturn(list);

		// act
		List<UserRole> result = service.getUserRoles("root");

		// assert
		assertEquals(1, result.size());
		assertSame(userRole, result.get(0));
	}
}
