package fr.mcc.ginco.services;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import fr.mcc.ginco.beans.AdminUser;
import fr.mcc.ginco.dao.IGenericDAO;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

/**
 * Unit tests for fr.mcc.ginco.services.AdminUserServiceImpl
 *
 * @author Diffblue Cover
 */

public class AdminUserServiceImplTest {

	@Mock(name = "adminUserDAO")
	private IGenericDAO<fr.mcc.ginco.beans.AdminUser, String> adminUserDAO;

	@InjectMocks
	private AdminUserServiceImpl service;

	@Before public void initMocks() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void getAllAdminReturnsEmpty() {
		when(adminUserDAO.findAll())
			.thenReturn(new ArrayList<AdminUser>());
		assertTrue((service.getAllAdmin()).isEmpty());
	}

	@Test
	public void isUserAdminUserIdIsRootReturnsTrue() {
		when(adminUserDAO.getById(Mockito.<String>any()))
			.thenReturn(new AdminUser());
		assertTrue(service.isUserAdmin("root"));
	}
}
