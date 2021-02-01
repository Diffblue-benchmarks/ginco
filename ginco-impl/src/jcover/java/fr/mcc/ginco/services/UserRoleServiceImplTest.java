package fr.mcc.ginco.services;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import fr.mcc.ginco.beans.Role;
import fr.mcc.ginco.beans.Thesaurus;
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

	@Before
	public void initMocks() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void hasRoleReturnsFalse() {
		UserRole userRole = new UserRole();
		userRole.setRole(Role.EXPERT);
		when(userRoleDAO.getUserRoleOnThesaurus(Mockito.<String>any(), Mockito.<String>any()))
			.thenReturn(userRole);
		assertFalse(service.hasRole("admin", "admin", Role.MANAGER));
	}

	@Test
	public void hasRoleReturnsTrue() {
		UserRole userRole = new UserRole();
		userRole.setRole(Role.MANAGER);
		when(userRoleDAO.getUserRoleOnThesaurus(Mockito.<String>any(), Mockito.<String>any()))
			.thenReturn(userRole);
		assertTrue(service.hasRole("admin", "admin", Role.MANAGER));
	}

	@Test
	public void getThesaurusUsersThesaurusIdIsRoot() {

		// arrange
		ArrayList<UserRole> userRoleList = new ArrayList<UserRole>();
		UserRole userRole = new UserRole();
		userRoleList.add(userRole);
		when(userRoleDAO.getUserRolesOnThesaurus(Mockito.<String>any()))
			.thenReturn(userRoleList);

		// act
		List<UserRole> result = service.getThesaurusUsers("root");

		// assert
		assertEquals(1, result.size());
		assertSame(userRole, result.get(0));
	}

	@Test
	public void getUserRoleIdentifierIsOne() {

		// arrange
		UserRole userRole = new UserRole();
		userRole.setIdentifier(1);
		userRole.setRole(Role.MANAGER);
		Thesaurus thesaurus = new Thesaurus();
		userRole.setThesaurus(thesaurus);
		userRole.setUsername("root");
		when(userRoleDAO.getById(Mockito.<Integer>any()))
			.thenReturn(userRole);

		// act
		UserRole result = service.getUserRole(1);

		// assert
		assertEquals(1, (int) result.getIdentifier());
		assertTrue(Role.MANAGER == result.getRole());
		assertSame(thesaurus, result.getThesaurus());
		assertEquals("root", result.getUsername());
	}

	@Test
	public void getUserRolesUsernameIsRoot() {

		// arrange
		ArrayList<UserRole> userRoleList = new ArrayList<UserRole>();
		UserRole userRole = new UserRole();
		userRoleList.add(userRole);
		when(userRoleDAO.getUserRoles(Mockito.<String>any()))
			.thenReturn(userRoleList);

		// act
		List<UserRole> result = service.getUserRoles("root");

		// assert
		assertEquals(1, result.size());
		assertSame(userRole, result.get(0));
	}
}
