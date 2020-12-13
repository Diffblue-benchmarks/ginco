package fr.mcc.ginco.services;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.when;

import fr.mcc.ginco.beans.ThesaurusFormat;
import fr.mcc.ginco.dao.IGenericDAO;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

/**
 * Unit tests for fr.mcc.ginco.services.ThesaurusFormatServiceImpl
 *
 * @author Diffblue Cover
 */

public class ThesaurusFormatServiceImplTest {

	@Mock(name = "thesaurusFormatDAO")
	private IGenericDAO<ThesaurusFormat, Integer> thesaurusFormatDAO;

	@InjectMocks
	private ThesaurusFormatServiceImpl service;

	@Before public void initMocks() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void getThesaurusFormatList() {

		// arrange
		ArrayList<ThesaurusFormat> arrayList = new ArrayList<ThesaurusFormat>();
		ThesaurusFormat thesaurusFormat = new ThesaurusFormat();
		arrayList.add(thesaurusFormat);
		when(thesaurusFormatDAO.findAll())
			.thenReturn(arrayList);

		// act
		List<ThesaurusFormat> result = service.getThesaurusFormatList();

		// assert
		assertEquals(1, result.size());
		assertSame(thesaurusFormat, result.get(0));
	}

	@Test
	public void getThesaurusFormatByIdIdIsOne() {

		// arrange
		ThesaurusFormat thesaurusFormat = new ThesaurusFormat();
		thesaurusFormat.setIdentifier(1);
		thesaurusFormat.setLabel("label");
		when(thesaurusFormatDAO.getById(Mockito.<Integer>any()))
			.thenReturn(thesaurusFormat);

		// act
		ThesaurusFormat result = service.getThesaurusFormatById(1);

		// assert
		assertEquals(1, (int) result.getIdentifier());
		assertEquals("label", result.getLabel());
	}
}
