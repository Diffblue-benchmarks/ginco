package fr.mcc.ginco.services;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import fr.mcc.ginco.beans.Language;
import fr.mcc.ginco.beans.Thesaurus;
import fr.mcc.ginco.beans.ThesaurusFormat;
import fr.mcc.ginco.beans.ThesaurusOrganization;
import fr.mcc.ginco.beans.ThesaurusType;
import fr.mcc.ginco.beans.ThesaurusVersionHistory;
import fr.mcc.ginco.dao.IThesaurusDAO;
import fr.mcc.ginco.dao.IThesaurusVersionHistoryDAO;
import fr.mcc.ginco.exports.IGincoThesaurusExportService;
import fr.mcc.ginco.exports.ISKOSExportService;
import fr.mcc.ginco.helpers.ThesaurusHelper;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

/**
 * Unit tests for fr.mcc.ginco.services.ThesaurusServiceImpl
 *
 * @author Diffblue Cover
 */

public class ThesaurusServiceImplTest {

	@Mock(name = "gincoThesaurusExportService")
	private IGincoThesaurusExportService gincoThesaurusExportService;

	@Mock(name = "skosExportService")
	private ISKOSExportService skosExportService;

	@Mock(name = "thesaurusDAO")
	private IThesaurusDAO thesaurusDAO;

	@Mock(name = "thesaurusHelper")
	private ThesaurusHelper thesaurusHelper;

	@Mock(name = "thesaurusVersionHistoryDAO")
	private IThesaurusVersionHistoryDAO thesaurusVersionHistoryDAO;

	@InjectMocks
	private ThesaurusServiceImpl service;

	@Before public void initMocks() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void getThesaurusById() throws java.text.ParseException {

		// arrange
		Thesaurus thesaurus = new Thesaurus();
		thesaurus.setArchived(false);
		thesaurus.setContributor("foo");
		thesaurus.setCoverage("foo");
		Date created = new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31");
		thesaurus.setCreated(created);
		ThesaurusOrganization creator = new ThesaurusOrganization();
		thesaurus.setCreator(creator);
		Date date = new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31");
		thesaurus.setDate(date);
		thesaurus.setDefaultTopConcept(false);
		thesaurus.setDescription("some text");
		thesaurus.setIdentifier("data");
		thesaurus.setPolyHierarchical(false);
		thesaurus.setPublisher("foo");
		thesaurus.setRelation("DE");
		thesaurus.setRights("foo");
		thesaurus.setSource("foo");
		thesaurus.setSubject("foo");
		thesaurus.setTitle("Mr");
		ThesaurusType type = new ThesaurusType();
		thesaurus.setType(type);
		thesaurus.setVersions(new HashSet<ThesaurusVersionHistory>());
		when(thesaurusDAO.getById(Mockito.<String>any()))
			.thenReturn(thesaurus);

		// act
		Thesaurus result = service.getThesaurusById("1234");

		// assert
		assertEquals("foo", result.getContributor());
		assertEquals("foo", result.getCoverage());
		assertSame(created, result.getCreated());
		assertSame(creator, result.getCreator());
		assertSame(date, result.getDate());
		assertEquals("some text", result.getDescription());
		assertTrue(result.getFormat().isEmpty());
		assertEquals("data", result.getIdentifier());
		assertTrue(result.getLang().isEmpty());
		assertEquals("foo", result.getPublisher());
		assertEquals("DE", result.getRelation());
		assertEquals("foo", result.getRights());
		assertEquals("foo", result.getSource());
		assertEquals("foo", result.getSubject());
		assertEquals("data", result.getThesaurusId());
		assertEquals("Mr", result.getTitle());
		assertSame(type, result.getType());
		assertTrue(result.getVersions().isEmpty());
		assertFalse(result.isArchived());
		assertFalse(result.isDefaultTopConcept());
		assertFalse(result.isPolyHierarchical());
	}

	@Test
	public void getDefaultThesaurus() {
		Thesaurus result = service.getDefaultThesaurus();
		assertEquals("default.thesaurus.creator.contributor", result.getContributor());
		assertEquals("default.thesaurus.coverage", result.getCoverage());
		assertNull(result.getCreated());
		assertEquals("default.thesaurus.creator.email", result.getCreator().getEmail());
		assertEquals("default.thesaurus.creator.homepage", result.getCreator().getHomepage());
		assertNull(result.getCreator().getIdentifier());
		assertEquals("default.thesaurus.creator.name", result.getCreator().getName());
		assertNull(result.getDate());
		assertEquals("default.thesaurus.description", result.getDescription());
		assertTrue(result.getFormat().isEmpty());
		assertNull(result.getIdentifier());
		assertTrue(result.getLang().isEmpty());
		assertEquals("default.thesaurus.publisher", result.getPublisher());
		assertNull(result.getRelation());
		assertEquals("default.thesaurus.rights", result.getRights());
		assertEquals("", result.getSource());
		assertEquals("default.thesaurus.subject", result.getSubject());
		assertNull(result.getThesaurusId());
		assertEquals("default.thesaurus.title", result.getTitle());
		assertNull(result.getType());
		assertNull(result.getVersions());
		assertNull(result.isArchived());
		assertNull(result.isDefaultTopConcept());
		assertNull(result.isPolyHierarchical());
	}

	@Test
	public void getThesaurusList() {

		// arrange
		ArrayList<Thesaurus> thesaurusList = new ArrayList<Thesaurus>();
		Thesaurus thesaurus = new Thesaurus();
		thesaurusList.add(thesaurus);
		when(thesaurusDAO.findAll(Mockito.<String>any(), Mockito.<fr.mcc.ginco.dao.IGenericDAO.SortingTypes>any()))
			.thenReturn(thesaurusList);

		// act
		List<Thesaurus> result = service.getThesaurusList();

		// assert
		assertEquals(1, result.size());
		assertSame(thesaurus, result.get(0));
	}

	@Test
	public void updateThesaurus() {
		ArrayList<ThesaurusVersionHistory> thesaurusVersionHistoryList =
			 new ArrayList<ThesaurusVersionHistory>();
		ThesaurusVersionHistory thesaurusVersionHistory =
			 mock(ThesaurusVersionHistory.class);
		thesaurusVersionHistoryList.add(thesaurusVersionHistory);
		when(thesaurusVersionHistoryDAO.findVersionsByThesaurusId(Mockito.<String>any()))
			.thenReturn(thesaurusVersionHistoryList);
		when(thesaurusDAO.update(Mockito.<Thesaurus>any()))
			.thenReturn(new Thesaurus());
		Thesaurus object = new Thesaurus();
		assertSame(object, service.updateThesaurus(object));
	}

	@Test
	public void updateThesaurusDate() throws java.text.ParseException {
		ArrayList<ThesaurusVersionHistory> thesaurusVersionHistoryList =
			 new ArrayList<ThesaurusVersionHistory>();
		ThesaurusVersionHistory thesaurusVersionHistory =
			 mock(ThesaurusVersionHistory.class);
		thesaurusVersionHistoryList.add(thesaurusVersionHistory);
		when(thesaurusVersionHistoryDAO.findVersionsByThesaurusId(Mockito.<String>any()))
			.thenReturn(thesaurusVersionHistoryList);
		Thesaurus thesaurus = new Thesaurus();
		thesaurus.setArchived(false);
		thesaurus.setContributor("foo");
		thesaurus.setCoverage("foo");
		thesaurus.setCreated(new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31"));
		ThesaurusOrganization creator1 = new ThesaurusOrganization();
		creator1.setEmail("info@diffblue.com");
		creator1.setHomepage("foo");
		creator1.setIdentifier(1);
		creator1.setName("Acme");
		thesaurus.setCreator(creator1);
		thesaurus.setDate(new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31"));
		thesaurus.setDefaultTopConcept(false);
		thesaurus.setDescription("some text");
		thesaurus.setFormat(new HashSet<ThesaurusFormat>());
		thesaurus.setIdentifier("data");
		thesaurus.setLang(new HashSet<Language>());
		thesaurus.setPolyHierarchical(false);
		thesaurus.setPublisher("foo");
		thesaurus.setRelation("DE");
		thesaurus.setRights("foo");
		thesaurus.setSource("foo");
		thesaurus.setSubject("foo");
		thesaurus.setTitle("Mr");
		ThesaurusType type1 = new ThesaurusType();
		type1.setIdentifier(1);
		type1.setLabel("label");
		thesaurus.setType(type1);
		thesaurus.setVersions(new HashSet<ThesaurusVersionHistory>());
		when(thesaurusDAO.update(Mockito.<Thesaurus>any()))
			.thenReturn(thesaurus);
		Thesaurus object = new Thesaurus();
		object.setArchived(false);
		object.setContributor("foo");
		object.setCoverage("foo");
		object.setCreated(new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31"));
		ThesaurusOrganization creator2 = new ThesaurusOrganization();
		creator2.setEmail("info@diffblue.com");
		creator2.setHomepage("foo");
		creator2.setIdentifier(1);
		creator2.setName("Acme");
		object.setCreator(creator2);
		object.setDate(new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31"));
		object.setDefaultTopConcept(false);
		object.setDescription("some text");
		object.setFormat(new HashSet<ThesaurusFormat>());
		object.setIdentifier("data");
		object.setLang(new HashSet<Language>());
		object.setPolyHierarchical(false);
		object.setPublisher("foo");
		object.setRelation("DE");
		object.setRights("foo");
		object.setSource("foo");
		object.setSubject("foo");
		object.setTitle("Mr");
		ThesaurusType type2 = new ThesaurusType();
		type2.setIdentifier(1);
		type2.setLabel("label");
		object.setType(type2);
		object.setVersions(new HashSet<ThesaurusVersionHistory>());
		assertSame(object, service.updateThesaurusDate(object));
		assertEquals(true, 
			Math.abs(object.getDate().getTime() - new Date().getTime())
			<= 10_000L);
	}

	@Test
	public void getThesaurusLanguagesReturnsEmpty() {
		when(thesaurusDAO.getById(Mockito.<String>any()))
			.thenReturn(new Thesaurus());
		assertTrue(service.getThesaurusLanguages("1234").isEmpty());
	}

	@Test
	public void destroyThesaurus() throws java.text.ParseException {

		// arrange
		Thesaurus thesaurus = new Thesaurus();
		thesaurus.setArchived(false);
		thesaurus.setContributor("foo");
		thesaurus.setCoverage("foo");
		Date created1 = new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31");
		thesaurus.setCreated(created1);
		ThesaurusOrganization creator1 = new ThesaurusOrganization();
		thesaurus.setCreator(creator1);
		Date date1 = new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31");
		thesaurus.setDate(date1);
		thesaurus.setDefaultTopConcept(false);
		thesaurus.setDescription("some text");
		thesaurus.setIdentifier("data");
		thesaurus.setPolyHierarchical(false);
		thesaurus.setPublisher("foo");
		thesaurus.setRelation("DE");
		thesaurus.setRights("foo");
		thesaurus.setSource("foo");
		thesaurus.setSubject("foo");
		thesaurus.setTitle("Mr");
		ThesaurusType type1 = new ThesaurusType();
		thesaurus.setType(type1);
		thesaurus.setVersions(new HashSet<ThesaurusVersionHistory>());
		when(thesaurusDAO.delete(Mockito.<Thesaurus>any()))
			.thenReturn(thesaurus);

		// act
		Thesaurus result = service.destroyThesaurus(new Thesaurus());

		// assert
		assertEquals("foo", result.getContributor());
		assertEquals("foo", result.getCoverage());
		assertSame(created1, result.getCreated());
		assertSame(creator1, result.getCreator());
		assertSame(date1, result.getDate());
		assertEquals("some text", result.getDescription());
		assertTrue(result.getFormat().isEmpty());
		assertEquals("data", result.getIdentifier());
		assertTrue(result.getLang().isEmpty());
		assertEquals("foo", result.getPublisher());
		assertEquals("DE", result.getRelation());
		assertEquals("foo", result.getRights());
		assertEquals("foo", result.getSource());
		assertEquals("foo", result.getSubject());
		assertEquals("data", result.getThesaurusId());
		assertEquals("Mr", result.getTitle());
		assertSame(type1, result.getType());
		assertTrue(result.getVersions().isEmpty());
		assertFalse(result.isArchived());
		assertFalse(result.isDefaultTopConcept());
		assertFalse(result.isPolyHierarchical());
	}
}
