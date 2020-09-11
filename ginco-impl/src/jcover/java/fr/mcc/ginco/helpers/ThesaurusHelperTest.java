package fr.mcc.ginco.helpers;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import fr.mcc.ginco.ark.IIDGeneratorService;
import fr.mcc.ginco.beans.Thesaurus;
import fr.mcc.ginco.beans.ThesaurusVersionHistory;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

/**
 * Unit tests for fr.mcc.ginco.helpers.ThesaurusHelper
 *
 * @author Diffblue Cover
 */

public class ThesaurusHelperTest {

	@Mock(name = "generatorService")
	private IIDGeneratorService generatorService;

	@InjectMocks
	private ThesaurusHelper service;

	@Before public void initMocks() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void buildDefaultVersion() {
		when(generatorService.generate(Mockito.<Class>any()))
			.thenReturn("foo");
		Thesaurus thesaurus = mock(Thesaurus.class);
		ThesaurusVersionHistory result = service.buildDefaultVersion(thesaurus);
		assertEquals(true, Math.abs(result.getDate().getTime()-new Date().getTime())<=10_000L);
		assertEquals("foo", result.getIdentifier());
		assertEquals(0, (int) result.getStatus());
		assertSame(thesaurus, result.getThesaurus());
		assertTrue(result.getThisVersion());
		assertNull(result.getUserId());
		assertEquals("Nouveau thesaurus", result.getVersionNote());
	}
}
