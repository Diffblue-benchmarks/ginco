package fr.mcc.ginco.services;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.when;

import fr.mcc.ginco.beans.ThesaurusOrganization;
import fr.mcc.ginco.dao.hibernate.ThesaurusOrganizationDAO;

import java.util.ArrayList;
import java.util.List;

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
	public void getOrganizationsWithData() throws fr.mcc.ginco.exceptions.TechnicalException {

		// arrange
		ArrayList<ThesaurusOrganization> arrayList =
			 new ArrayList<ThesaurusOrganization>();
		ThesaurusOrganization thesaurusOrganization = new ThesaurusOrganization();
		arrayList.add(thesaurusOrganization);
		when(thesaurusOrganizationDAO.getFilteredOrganizationNames())
			.thenReturn(arrayList);

		// act
		List<ThesaurusOrganization> result = service.getOrganizationsWithData();

		// assert
		assertEquals(1, result.size());
		assertSame(thesaurusOrganization, result.get(0));
	}
}
