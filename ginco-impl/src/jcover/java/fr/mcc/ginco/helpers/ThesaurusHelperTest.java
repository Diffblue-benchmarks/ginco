package fr.mcc.ginco.helpers;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import fr.mcc.ginco.ark.IIDGeneratorService;
import fr.mcc.ginco.beans.Language;
import fr.mcc.ginco.beans.Thesaurus;
import fr.mcc.ginco.beans.ThesaurusFormat;
import fr.mcc.ginco.beans.ThesaurusOrganization;
import fr.mcc.ginco.beans.ThesaurusType;
import fr.mcc.ginco.beans.ThesaurusVersionHistory;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;

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
	public void buildDefaultVersion() throws java.text.ParseException {

		// arrange
		when(generatorService.generate(Mockito.<Class>any()))
			.thenReturn("foo");
		Thesaurus thesaurus = new Thesaurus();
		thesaurus.setArchived(true);
		thesaurus.setContributor("foo");
		thesaurus.setCoverage("foo");
		thesaurus.setCreated(new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31"));
		thesaurus.setCreator(new ThesaurusOrganization());
		thesaurus.setDate(new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31"));
		thesaurus.setDefaultTopConcept(false);
		thesaurus.setDescription("some text");
		thesaurus.setFormat(new HashSet<ThesaurusFormat>());
		thesaurus.setIdentifier("foo");
		thesaurus.setLang(new HashSet<Language>());
		thesaurus.setPolyHierarchical(false);
		thesaurus.setPublisher("foo");
		thesaurus.setRelation("DE");
		thesaurus.setRights("foo");
		thesaurus.setSource("foo");
		thesaurus.setSubject("foo");
		thesaurus.setTitle("Mr");
		thesaurus.setType(new ThesaurusType());
		thesaurus.setVersions(new HashSet<ThesaurusVersionHistory>());

		// act
		ThesaurusVersionHistory result = service.buildDefaultVersion(thesaurus);

		// assert
		assertEquals(true, Math.abs(result.getDate().getTime()-new Date().getTime())<=10_000L);
		assertEquals("foo", result.getIdentifier());
		assertEquals(0, (int) result.getStatus());
		assertSame(thesaurus, result.getThesaurus());
		assertTrue(result.getThisVersion());
		assertNull(result.getUserId());
		assertEquals("Nouveau thesaurus", result.getVersionNote());
	}
}
