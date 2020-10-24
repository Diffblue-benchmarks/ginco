package fr.mcc.ginco.services;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import fr.mcc.ginco.beans.Language;
import fr.mcc.ginco.beans.SplitNonPreferredTerm;
import fr.mcc.ginco.beans.Thesaurus;
import fr.mcc.ginco.dao.ISplitNonPreferredTermDAO;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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

	@Before public void initMocks() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void getSplitNonPreferredTermById() throws java.text.ParseException {

		// arrange
		SplitNonPreferredTerm splitNonPreferredTerm = new SplitNonPreferredTerm();
		Date created = new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31");
		splitNonPreferredTerm.setCreated(created);
		splitNonPreferredTerm.setIdentifier("data");
		Language language = new Language();
		splitNonPreferredTerm.setLanguage(language);
		splitNonPreferredTerm.setLexicalValue("value");
		Date modified = new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31");
		splitNonPreferredTerm.setModified(modified);
		splitNonPreferredTerm.setSource("foo");
		splitNonPreferredTerm.setStatus(1);
		Thesaurus thesaurus = mock(Thesaurus.class);
		splitNonPreferredTerm.setThesaurus(thesaurus);
		when(splitNonPreferredTermDAO.getById(Mockito.<String>any()))
			.thenReturn(splitNonPreferredTerm);

		// act
		SplitNonPreferredTerm result = service.getSplitNonPreferredTermById("1234");

		// assert
		assertSame(created, result.getCreated());
		assertEquals("data", result.getIdentifier());
		assertSame(language, result.getLanguage());
		assertEquals("value", result.getLexicalValue());
		assertSame(modified, result.getModified());
		assertTrue((result.getPreferredTerms()).isEmpty());
		assertEquals("foo", result.getSource());
		assertEquals(1, (int) result.getStatus());
		assertSame(thesaurus, result.getThesaurus());
	}

	@Test
	public void getSplitNonPreferredTermListLimitIsOneAndStartIndexIsOne() {

		// arrange
		List<SplitNonPreferredTerm> list = new ArrayList<SplitNonPreferredTerm>();
		SplitNonPreferredTerm splitNonPreferredTerm = new SplitNonPreferredTerm();
		list.add(splitNonPreferredTerm);
		when(splitNonPreferredTermDAO.findItems(Mockito.<Integer>any(), Mockito.<Integer>any(), Mockito.<String>any()))
			.thenReturn(list);

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
		List<SplitNonPreferredTerm> list = new ArrayList<SplitNonPreferredTerm>();
		SplitNonPreferredTerm splitNonPreferredTerm = new SplitNonPreferredTerm();
		list.add(splitNonPreferredTerm);
		when(splitNonPreferredTermDAO.findAll())
			.thenReturn(list);

		// act
		List<SplitNonPreferredTerm> result = service.getAllSplitNonPreferredTerms();

		// assert
		assertEquals(1, result.size());
		assertSame(splitNonPreferredTerm, result.get(0));
	}
}
