package fr.mcc.ginco.services;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.when;

import fr.mcc.ginco.beans.ThesaurusArk;
import fr.mcc.ginco.dao.IGenericDAO;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

/**
 * Unit tests for fr.mcc.ginco.services.ThesaurusArkServiceImpl
 *
 * @author Diffblue Cover
 */

public class ThesaurusArkServiceImplTest {

	@Mock(name = "thesaurusArkDAO")
	private IGenericDAO<fr.mcc.ginco.beans.ThesaurusArk, Integer> thesaurusArkDAO;

	@InjectMocks
	private ThesaurusArkServiceImpl service;

	@Before public void initMocks() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void createThesaurusArk() throws java.text.ParseException {

		// arrange
		ThesaurusArk thesaurusArk1 = new ThesaurusArk();
		Date created1 =
			 new java.text.SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31");
		thesaurusArk1.setCreated(created1);
		thesaurusArk1.setEntity("entity");
		thesaurusArk1.setIdentifier("data");
		when(thesaurusArkDAO.update(Mockito.<ThesaurusArk>any()))
			.thenReturn(thesaurusArk1);

		// act
		ThesaurusArk result = service.createThesaurusArk(new ThesaurusArk());

		// assert
		assertSame(created1, result.getCreated());
		assertEquals("entity", result.getEntity());
		assertEquals("data", result.getIdentifier());
	}
}
