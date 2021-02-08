package fr.mcc.ginco.services;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import fr.mcc.ginco.beans.SplitNonPreferredTerm;
import fr.mcc.ginco.dao.ISplitNonPreferredTermDAO;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

/**
 * Unit tests for fr.mcc.ginco.services.SplitNonPreferredTermServiceImpl
 *
 * @author Diffblue Cover
 */

public class SplitNonPreferredTermServiceImplTest {

	@Mock(name = "splitNonPreferredTermDAO")
	private ISplitNonPreferredTermDAO splitNonPreferredTermDAO;

	@InjectMocks
	private SplitNonPreferredTermServiceImpl service;

	@Before
	public void initMocks() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void getSplitNonPreferredTermById() {
		SplitNonPreferredTerm splitNonPreferredTerm =
			 mock(SplitNonPreferredTerm.class);
		when(splitNonPreferredTermDAO.getById(Mockito.<String>any()))
			.thenReturn(splitNonPreferredTerm);
		assertNotNull(service.getSplitNonPreferredTermById("1234"));
	}

	@Test
	public void getSplitNonPreferredTermListLimitIsOneAndStartIndexIsOne() {

		// arrange
		ArrayList<SplitNonPreferredTerm> splitNonPreferredTermList =
			 new ArrayList<SplitNonPreferredTerm>();
		SplitNonPreferredTerm splitNonPreferredTerm = new SplitNonPreferredTerm();
		splitNonPreferredTermList.add(splitNonPreferredTerm);
		when(splitNonPreferredTermDAO.findItems(Mockito.<Integer>any(), Mockito.<Integer>any(), Mockito.<String>any()))
			.thenReturn(splitNonPreferredTermList);

		// act
		List<SplitNonPreferredTerm> result =
			 service.getSplitNonPreferredTermList(1, 1, "1234");

		// assert
		assertEquals(1, result.size());
		assertSame(splitNonPreferredTerm, result.get(0));
	}

	@Test
	public void getSplitNonPreferredTermCountReturnsOne() {
		when(splitNonPreferredTermDAO.countItems(Mockito.<String>any()))
			.thenReturn(1L);
		assertEquals(1L, (long) service.getSplitNonPreferredTermCount("1234"));
	}

	@Test
	public void getAllSplitNonPreferredTerms() {

		// arrange
		ArrayList<SplitNonPreferredTerm> splitNonPreferredTermList =
			 new ArrayList<SplitNonPreferredTerm>();
		SplitNonPreferredTerm splitNonPreferredTerm = new SplitNonPreferredTerm();
		splitNonPreferredTermList.add(splitNonPreferredTerm);
		when(splitNonPreferredTermDAO.findAll())
			.thenReturn(splitNonPreferredTermList);

		// act
		List<SplitNonPreferredTerm> result = service.getAllSplitNonPreferredTerms();

		// assert
		assertEquals(1, result.size());
		assertSame(splitNonPreferredTerm, result.get(0));
	}
}
