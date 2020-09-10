package fr.mcc.ginco.services;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import fr.mcc.ginco.beans.ThesaurusOrganization;
import fr.mcc.ginco.dao.hibernate.ThesaurusOrganizationDAO;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

/**
 * Unit tests for fr.mcc.ginco.services.ThesaurusOrganizationServiceImpl
 *
 * @author Diffblue Cover
 */

public class ThesaurusOrganizationServiceImplTest {

	@Mock(name = "thesaurusOrganizationDAO")
	private ThesaurusOrganizationDAO thesaurusOrganizationDAO;

	@InjectMocks
	private ThesaurusOrganizationServiceImpl service;

	@Before public void initMocks() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void getOrganizationsWithDataReturnsEmpty() throws fr.mcc.ginco.exceptions.TechnicalException {
		when(thesaurusOrganizationDAO.getFilteredOrganizationNames())
			.thenReturn(new ArrayList<ThesaurusOrganization>());
		assertTrue((service.getOrganizationsWithData()).isEmpty());
	}
}
