package fr.mcc.ginco.services;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import fr.mcc.ginco.beans.SplitNonPreferredTerm;
import fr.mcc.ginco.dao.ISplitNonPreferredTermDAO;

import java.util.ArrayList;

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

	@Before public void initMocks() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void destroySplitNonPreferredTermReturnsNull() {
		SplitNonPreferredTerm splitNonPreferredTerm = new SplitNonPreferredTerm();
		splitNonPreferredTerm.setStatus(0);
		assertNull(service.destroySplitNonPreferredTerm(splitNonPreferredTerm));
	}

	@Test
	public void getAllSplitNonPreferredTermsReturnsEmpty() {
		assertTrue((service.getAllSplitNonPreferredTerms()).isEmpty());
	}

	@Test
	public void getSplitNonPreferredTermCountReturnsOne() {
		when(splitNonPreferredTermDAO.countItems(Mockito.<String>any()))
			.thenReturn(1L);
		assertEquals(1L, (long) service.getSplitNonPreferredTermCount("1234"));
	}

	@Test
	public void getSplitNonPreferredTermListLimitIsOneAndStartIndexIsOneReturnsEmpty() {
		when(splitNonPreferredTermDAO.findItems(Mockito.<Integer>any(), Mockito.<Integer>any(), Mockito.<String>any()))
			.thenReturn(new ArrayList<SplitNonPreferredTerm>());
		assertTrue((service.getSplitNonPreferredTermList(1, 1, "1234")).isEmpty());
	}
}
