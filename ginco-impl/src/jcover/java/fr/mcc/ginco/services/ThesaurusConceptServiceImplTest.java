package fr.mcc.ginco.services;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import fr.mcc.ginco.ark.IIDGeneratorService;
import fr.mcc.ginco.beans.Language;
import fr.mcc.ginco.beans.Thesaurus;
import fr.mcc.ginco.beans.ThesaurusConcept;
import fr.mcc.ginco.beans.ThesaurusTerm;
import fr.mcc.ginco.beans.ThesaurusTermRole;
import fr.mcc.ginco.dao.IAlignmentDAO;
import fr.mcc.ginco.dao.IAssociativeRelationshipDAO;
import fr.mcc.ginco.dao.IAssociativeRelationshipRoleDAO;
import fr.mcc.ginco.dao.IThesaurusArrayDAO;
import fr.mcc.ginco.dao.IThesaurusConceptDAO;
import fr.mcc.ginco.dao.IThesaurusConceptGroupDAO;
import fr.mcc.ginco.dao.IThesaurusDAO;
import fr.mcc.ginco.dao.IThesaurusTermDAO;
import fr.mcc.ginco.utils.ThesaurusTermUtils;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

/**
 * Unit tests for fr.mcc.ginco.services.ThesaurusConceptServiceImpl
 *
 * @author Diffblue Cover
 */

public class ThesaurusConceptServiceImplTest {

	@Mock(name = "alignmentDAO")
	private IAlignmentDAO alignmentDAO;

	@Mock(name = "alignmentService")
	private IAlignmentService alignmentService;

	@Mock(name = "associativeRelationshipDAO")
	private IAssociativeRelationshipDAO associativeRelationshipDAO;

	@Mock(name = "associativeRelationshipRoleDAO")
	private IAssociativeRelationshipRoleDAO associativeRelationshipRoleDAO;

	@Mock(name = "conceptHierarchicalRelationshipServiceUtil")
	private IConceptHierarchicalRelationshipServiceUtil conceptHierarchicalRelationshipServiceUtil;

	@Mock(name = "generatorService")
	private IIDGeneratorService generatorService;

	@Mock(name = "thesaurusArrayDAO")
	private IThesaurusArrayDAO thesaurusArrayDAO;

	@Mock(name = "thesaurusConceptDAO")
	private IThesaurusConceptDAO thesaurusConceptDAO;

	@Mock(name = "thesaurusConceptGroupDAO")
	private IThesaurusConceptGroupDAO thesaurusConceptGroupDAO;

	@Mock(name = "thesaurusDAO")
	private IThesaurusDAO thesaurusDAO;

	@Mock(name = "thesaurusTermDAO")
	private IThesaurusTermDAO thesaurusTermDAO;

	@Mock(name = "thesaurusTermUtils")
	private ThesaurusTermUtils thesaurusTermUtils;

	@InjectMocks
	private ThesaurusConceptServiceImpl service;

	@Before
	public void initMocks() throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		MockitoAnnotations.initMocks(this);
		ThesaurusConceptServiceImpl bean = service;
		java.lang.reflect.Field field =
			 ThesaurusConceptServiceImpl.class.getDeclaredField("defaultLang");
		field.setAccessible(true);
		field.set(bean, "${ginco.default.language}");
	}

	@Test
	public void getThesaurusConceptList() {

		// arrange
		ArrayList<ThesaurusConcept> thesaurusConceptList =
			 new ArrayList<ThesaurusConcept>();
		ThesaurusConcept thesaurusConcept = new ThesaurusConcept();
		thesaurusConceptList.add(thesaurusConcept);
		when(thesaurusConceptDAO.findAll())
			.thenReturn(thesaurusConceptList);

		// act
		List<ThesaurusConcept> result = service.getThesaurusConceptList();

		// assert
		assertEquals(1, result.size());
		assertSame(thesaurusConcept, result.get(0));
	}

	@Test
	public void getThesaurusConceptListIdsIsHello() {

		// arrange
		ThesaurusConcept thesaurusConcept = new ThesaurusConcept();
		when(thesaurusConceptDAO.getById(Mockito.<String>any()))
			.thenReturn(thesaurusConcept);
		ArrayList<String> ids = new ArrayList<String>();
		ids.add("hello");

		// act
		Set<ThesaurusConcept> result = service.getThesaurusConceptList(ids);

		// assert
		assertEquals(1, result.size());
		assertTrue(result.contains(thesaurusConcept));
	}

	@Test
	public void getOrphanThesaurusConcepts() {

		// arrange
		when(thesaurusDAO.getById(Mockito.<String>any()))
			.thenReturn(new Thesaurus());
		ArrayList<ThesaurusConcept> thesaurusConceptList =
			 new ArrayList<ThesaurusConcept>();
		ThesaurusConcept thesaurusConcept = new ThesaurusConcept();
		thesaurusConceptList.add(thesaurusConcept);
		when(thesaurusConceptDAO.getOrphansThesaurusConcept(Mockito.<Thesaurus>any(), anyInt()))
			.thenReturn(thesaurusConceptList);

		// act
		List<ThesaurusConcept> result = service.getOrphanThesaurusConcepts("1234");

		// assert
		assertEquals(1, result.size());
		assertSame(thesaurusConcept, result.get(0));
	}

	@Test
	public void getOrphanThesaurusConceptsCountReturnsOne() {
		when(thesaurusDAO.getById(Mockito.<String>any()))
			.thenReturn(new Thesaurus());
		when(thesaurusConceptDAO.getOrphansThesaurusConceptCount(Mockito.<Thesaurus>any()))
			.thenReturn(1L);
		assertEquals(1L, service.getOrphanThesaurusConceptsCount("1234"));
	}

	@Test
	public void getTopTermThesaurusConcepts() {

		// arrange
		when(thesaurusDAO.getById(Mockito.<String>any()))
			.thenReturn(new Thesaurus());
		ArrayList<ThesaurusConcept> thesaurusConceptList =
			 new ArrayList<ThesaurusConcept>();
		ThesaurusConcept thesaurusConcept = new ThesaurusConcept();
		thesaurusConceptList.add(thesaurusConcept);
		when(thesaurusConceptDAO.getTopTermThesaurusConcept(Mockito.<Thesaurus>any(), anyInt(), Mockito.<String>any(), Mockito.<fr.mcc.ginco.enums.ConceptStatusEnum>any()))
			.thenReturn(thesaurusConceptList);

		// act
		List<ThesaurusConcept> result = service.getTopTermThesaurusConcepts("1234");

		// assert
		assertEquals(1, result.size());
		assertSame(thesaurusConcept, result.get(0));
	}

	@Test
	public void getTopTermThesaurusConceptsCountReturnsOne() {
		when(thesaurusDAO.getById(Mockito.<String>any()))
			.thenReturn(new Thesaurus());
		when(thesaurusConceptDAO.getTopTermThesaurusConceptCount(Mockito.<Thesaurus>any()))
			.thenReturn(1L);
		assertEquals(1L, service.getTopTermThesaurusConceptsCount("1234"));
	}

	@Test
	public void getChildrenByConceptId() {

		// arrange
		ArrayList<ThesaurusConcept> thesaurusConceptList =
			 new ArrayList<ThesaurusConcept>();
		ThesaurusConcept thesaurusConcept = new ThesaurusConcept();
		thesaurusConceptList.add(thesaurusConcept);
		when(thesaurusConceptDAO.getChildrenConcepts(Mockito.<String>any(), anyInt(), Mockito.<String>any(), Mockito.<fr.mcc.ginco.enums.ConceptStatusEnum>any()))
			.thenReturn(thesaurusConceptList);

		// act
		List<ThesaurusConcept> result =
			 service.getChildrenByConceptId("1234", "1234");

		// assert
		assertEquals(1, result.size());
		assertSame(thesaurusConcept, result.get(0));
	}

	@Test
	public void getConceptsByThesaurusIdOnlyValidatedConceptsIsFalseAndSearchOrphansIsFalse() {

		// arrange
		ArrayList<ThesaurusConcept> thesaurusConceptList =
			 new ArrayList<ThesaurusConcept>();
		ThesaurusConcept thesaurusConcept = new ThesaurusConcept();
		thesaurusConceptList.add(thesaurusConcept);
		when(thesaurusConceptDAO.getConceptsByThesaurusId(Mockito.<String>any(), Mockito.<String>any(), Mockito.<Boolean>any(), Mockito.<Boolean>any()))
			.thenReturn(thesaurusConceptList);

		// act
		List<ThesaurusConcept> result =
			 service.getConceptsByThesaurusId("1234", "1234", false, false);

		// assert
		assertEquals(1, result.size());
		assertSame(thesaurusConcept, result.get(0));
	}

	@Test
	public void getPaginatedConceptsByThesaurusIdLimitIsOneAndOnlyValidatedConceptsIsFalseAndSearchOrphansIsFalseAndStartIndexIsOne() {

		// arrange
		ArrayList<ThesaurusConcept> thesaurusConceptList =
			 new ArrayList<ThesaurusConcept>();
		ThesaurusConcept thesaurusConcept = new ThesaurusConcept();
		thesaurusConceptList.add(thesaurusConcept);
		when(thesaurusConceptDAO.getPaginatedConceptsByThesaurusId(Mockito.<Integer>any(), Mockito.<Integer>any(), Mockito.<String>any(), Mockito.<String>any(), Mockito.<Boolean>any(), Mockito.<Boolean>any(), Mockito.<String>any()))
			.thenReturn(thesaurusConceptList);

		// act
		List<ThesaurusConcept> result =
			 service.getPaginatedConceptsByThesaurusId(1, 1, "1234", "1234", false, false, "1234");

		// assert
		assertEquals(1, result.size());
		assertSame(thesaurusConcept, result.get(0));
	}

	@Test
	public void getConceptsByThesaurusIdCountOnlyValidatedConceptsIsFalseAndSearchOrphansIsFalseReturnsOne() {
		when(thesaurusConceptDAO.getConceptsByThesaurusIdCount(Mockito.<String>any(), Mockito.<String>any(), Mockito.<Boolean>any(), Mockito.<Boolean>any(), Mockito.<String>any()))
			.thenReturn(1L);
		assertEquals(1L, (long) service.getConceptsByThesaurusIdCount("1234", "1234", false, false, "1234"));
	}

	@Test
	public void hasChildrenReturnsFalse() {
		when(thesaurusConceptDAO.getChildrenConcepts(Mockito.<String>any(), anyInt(), Mockito.<String>any()))
			.thenReturn(new ArrayList<ThesaurusConcept>());
		assertFalse(service.hasChildren("1234"));
	}

	@Test
	public void hasChildrenReturnsTrue() {
		ArrayList<ThesaurusConcept> thesaurusConceptList =
			 new ArrayList<ThesaurusConcept>();
		ThesaurusConcept thesaurusConcept = mock(ThesaurusConcept.class);
		thesaurusConceptList.add(thesaurusConcept);
		when(thesaurusConceptDAO.getChildrenConcepts(Mockito.<String>any(), anyInt(), Mockito.<String>any()))
			.thenReturn(thesaurusConceptList);
		assertTrue(service.hasChildren("1234"));
	}

	@Test
	public void getConceptWithChildrenIdentifersReturnsHello() {

		// arrange
		ArrayList<String> stringList = new ArrayList<String>();
		stringList.add("hello");
		when(thesaurusConceptDAO.getIdentifiersOfConceptsWithChildren(Mockito.<String>any()))
			.thenReturn(stringList);

		// act
		Set<String> result = service.getConceptWithChildrenIdentifers("1234");

		// assert
		assertEquals(1, result.size());
		assertTrue(result.contains("hello"));
	}

	@Test
	public void getConceptPreferredTerm1() throws java.text.ParseException {

		// arrange
		ThesaurusTerm thesaurusTerm = new ThesaurusTerm();
		ThesaurusConcept concept = mock(ThesaurusConcept.class);
		thesaurusTerm.setConcept(concept);
		Date created1 = new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31");
		thesaurusTerm.setCreated(created1);
		thesaurusTerm.setHidden(false);
		thesaurusTerm.setIdentifier("data");
		Language language = new Language();
		thesaurusTerm.setLanguage(language);
		thesaurusTerm.setLexicalValue("value");
		Date modified = new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31");
		thesaurusTerm.setModified(modified);
		thesaurusTerm.setPrefered(false);
		ThesaurusTermRole role = new ThesaurusTermRole();
		thesaurusTerm.setRole(role);
		thesaurusTerm.setSource("foo");
		thesaurusTerm.setStatus(1);
		Thesaurus thesaurus = new Thesaurus();
		thesaurusTerm.setThesaurus(thesaurus);
		when(thesaurusTermDAO.getConceptPreferredTerm(Mockito.<String>any()))
			.thenReturn(thesaurusTerm);

		// act
		ThesaurusTerm result = service.getConceptPreferredTerm("hello");

		// assert
		assertSame(concept, result.getConcept());
		assertSame(created1, result.getCreated());
		assertFalse(result.getHidden());
		assertEquals("data", result.getIdentifier());
		assertSame(language, result.getLanguage());
		assertEquals("value", result.getLexicalValue());
		assertSame(modified, result.getModified());
		assertFalse(result.getPrefered());
		assertSame(role, result.getRole());
		assertEquals("foo", result.getSource());
		assertEquals(1, (int) result.getStatus());
		assertSame(thesaurus, result.getThesaurus());
	}

	@Test
	public void getConceptPreferredTerm2() throws java.text.ParseException {

		// arrange
		ThesaurusTerm thesaurusTerm = new ThesaurusTerm();
		ThesaurusConcept concept = new ThesaurusConcept();
		thesaurusTerm.setConcept(concept);
		Date created3 = new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31");
		thesaurusTerm.setCreated(created3);
		thesaurusTerm.setHidden(false);
		thesaurusTerm.setIdentifier("data");
		Language language = new Language();
		thesaurusTerm.setLanguage(language);
		thesaurusTerm.setLexicalValue("value");
		Date modified2 = new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31");
		thesaurusTerm.setModified(modified2);
		thesaurusTerm.setPrefered(false);
		ThesaurusTermRole role = new ThesaurusTermRole();
		thesaurusTerm.setRole(role);
		thesaurusTerm.setSource("foo");
		thesaurusTerm.setStatus(1);
		Thesaurus thesaurus2 = new Thesaurus();
		thesaurusTerm.setThesaurus(thesaurus2);
		when(thesaurusTermDAO.getConceptPreferredTerm(Mockito.<String>any(), Mockito.<String>any()))
			.thenReturn(thesaurusTerm);

		// act
		ThesaurusTerm result = service.getConceptPreferredTerm("hello", "1234");

		// assert
		assertSame(concept, result.getConcept());
		assertSame(created3, result.getCreated());
		assertFalse(result.getHidden());
		assertEquals("data", result.getIdentifier());
		assertSame(language, result.getLanguage());
		assertEquals("value", result.getLexicalValue());
		assertSame(modified2, result.getModified());
		assertFalse(result.getPrefered());
		assertSame(role, result.getRole());
		assertEquals("foo", result.getSource());
		assertEquals(1, (int) result.getStatus());
		assertSame(thesaurus2, result.getThesaurus());
	}

	@Test
	public void getConceptLabelConceptIdIsHello() {
		ThesaurusTerm thesaurusTerm = new ThesaurusTerm();
		Language language = new Language();
		language.setId("1234");
		thesaurusTerm.setLanguage(language);
		thesaurusTerm.setLexicalValue("value");
		when(thesaurusTermDAO.getConceptPreferredTerm(Mockito.<String>any()))
			.thenReturn(thesaurusTerm);
		when(thesaurusConceptDAO.getById(Mockito.<String>any()))
			.thenReturn(new ThesaurusConcept());
		assertEquals("value@1234", service.getConceptLabel("hello"));
	}
}
