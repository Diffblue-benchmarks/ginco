package fr.mcc.ginco.services;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import fr.mcc.ginco.beans.Role;
import fr.mcc.ginco.beans.UserRole;
import fr.mcc.ginco.dao.IUserRoleDAO;

import java.util.ArrayList;

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
	public void getThesaurusUsersThesaurusIdIsRootReturnsEmpty() {
		when(userRoleDAO.getUserRolesOnThesaurus(Mockito.<String>any()))
			.thenReturn(new ArrayList<UserRole>());
		assertTrue((service.getThesaurusUsers("root")).isEmpty());
	}

	@Test
	public void getUserRolesReturnsEmpty() {
		when(userRoleDAO.getUserRoles(Mockito.<String>any()))
			.thenReturn(new ArrayList<UserRole>());
		assertTrue((service.getUserRoles("John Smith")).isEmpty());
	}

	@Test
	public void hasRoleReturnsFalse() {
		UserRole userRole = new UserRole();
		userRole.setRole(Role.EXPERT);
		when(userRoleDAO.getUserRoleOnThesaurus(Mockito.<String>any(), Mockito.<String>any()))
			.thenReturn(userRole);
		assertFalse(service.hasRole("admin", "root", Role.MANAGER));
	}

	@Test
	public void hasRoleReturnsTrue() {
		UserRole userRole = new UserRole();
		userRole.setRole(Role.MANAGER);
		when(userRoleDAO.getUserRoleOnThesaurus(Mockito.<String>any(), Mockito.<String>any()))
			.thenReturn(userRole);
		assertTrue(service.hasRole("admin", "root", Role.MANAGER));
	}
}
