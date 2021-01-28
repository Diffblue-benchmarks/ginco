package fr.mcc.ginco.audit.commands;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import fr.mcc.ginco.audit.utils.AuditHelper;
import fr.mcc.ginco.beans.AssociativeRelationship;
import fr.mcc.ginco.beans.Language;
import fr.mcc.ginco.beans.Thesaurus;
import fr.mcc.ginco.beans.ThesaurusArray;
import fr.mcc.ginco.beans.ThesaurusConcept;
import fr.mcc.ginco.beans.ThesaurusFormat;
import fr.mcc.ginco.beans.ThesaurusOrganization;
import fr.mcc.ginco.beans.ThesaurusTerm;
import fr.mcc.ginco.beans.ThesaurusTermRole;
import fr.mcc.ginco.beans.ThesaurusType;
import fr.mcc.ginco.beans.ThesaurusVersionHistory;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

/**
 * Unit tests for fr.mcc.ginco.audit.commands.MistralStructuresBuilder
 *
 * @author Diffblue Cover
 */

public class MistralStructuresBuilderTest {

	@Mock(name = "auditHelper")
	private AuditHelper auditHelper;

	@InjectMocks
	private MistralStructuresBuilder service;

	@Before public void initMocks() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void buildHierarchyStructureLangIsMpegAndRevisionIsOneReturnsValue() throws java.text.ParseException {
		ThesaurusTerm thesaurusTerm1 = new ThesaurusTerm();
		ThesaurusConcept concept1 = mock(ThesaurusConcept.class);
		thesaurusTerm1.setConcept(concept1);
		thesaurusTerm1.setCreated(new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31"));
		thesaurusTerm1.setHidden(false);
		thesaurusTerm1.setIdentifier("data");
		Language language1 = new Language();
		language1.setId("1234");
		language1.setPart1("foo");
		language1.setPrincipalLanguage(false);
		language1.setRefname("root");
		language1.setTopLanguage(false);
		thesaurusTerm1.setLanguage(language1);
		thesaurusTerm1.setLexicalValue("value");
		thesaurusTerm1.setModified(new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31"));
		thesaurusTerm1.setPrefered(false);
		ThesaurusTermRole role1 = new ThesaurusTermRole();
		role1.setCode("DE");
		role1.setDefaultRole(false);
		role1.setLabel("label");
		thesaurusTerm1.setRole(role1);
		thesaurusTerm1.setSource("foo");
		thesaurusTerm1.setStatus(1);
		Thesaurus thesaurus1 = new Thesaurus();
		thesaurus1.setArchived(false);
		thesaurus1.setContributor("foo");
		thesaurus1.setCoverage("foo");
		thesaurus1.setCreated(new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31"));
		ThesaurusOrganization creator1 = new ThesaurusOrganization();
		creator1.setEmail("info@diffblue.com");
		creator1.setHomepage("foo");
		creator1.setIdentifier(1);
		creator1.setName("Acme");
		thesaurus1.setCreator(creator1);
		thesaurus1.setDate(new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31"));
		thesaurus1.setDefaultTopConcept(false);
		thesaurus1.setDescription("some text");
		thesaurus1.setFormat(new HashSet<ThesaurusFormat>());
		thesaurus1.setIdentifier("data");
		thesaurus1.setLang(new HashSet<Language>());
		thesaurus1.setPolyHierarchical(false);
		thesaurus1.setPublisher("foo");
		thesaurus1.setRelation("DE");
		thesaurus1.setRights("foo");
		thesaurus1.setSource("foo");
		thesaurus1.setSubject("foo");
		thesaurus1.setTitle("Mr");
		ThesaurusType type1 = new ThesaurusType();
		type1.setIdentifier(1);
		type1.setLabel("label");
		thesaurus1.setType(type1);
		thesaurus1.setVersions(new HashSet<ThesaurusVersionHistory>());
		thesaurusTerm1.setThesaurus(thesaurus1);
		ArrayList<ThesaurusConcept> thesaurusConceptList =
			 new ArrayList<ThesaurusConcept>();
		ThesaurusConcept thesaurusConcept1 = new ThesaurusConcept();
		thesaurusConcept1.setAssociativeRelationshipLeft(new HashSet<AssociativeRelationship>());
		thesaurusConcept1.setAssociativeRelationshipRight(new HashSet<AssociativeRelationship>());
		thesaurusConcept1.setConceptArrays(new HashSet<ThesaurusArray>());
		thesaurusConcept1.setCreated(new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31"));
		thesaurusConcept1.setIdentifier("data");
		thesaurusConcept1.setModified(new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31"));
		thesaurusConcept1.setNotation("DE");
		thesaurusConcept1.setParentConcepts(new HashSet<ThesaurusConcept>());
		thesaurusConcept1.setRootConcepts(new HashSet<ThesaurusConcept>());
		thesaurusConcept1.setStatus(1);
		Thesaurus thesaurus2 = new Thesaurus();
		thesaurus2.setArchived(false);
		thesaurus2.setContributor("foo");
		thesaurus2.setCoverage("foo");
		thesaurus2.setCreated(new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31"));
		ThesaurusOrganization creator2 = new ThesaurusOrganization();
		creator2.setEmail("info@diffblue.com");
		creator2.setHomepage("foo");
		creator2.setIdentifier(1);
		creator2.setName("Acme");
		thesaurus2.setCreator(creator2);
		thesaurus2.setDate(new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31"));
		thesaurus2.setDefaultTopConcept(false);
		thesaurus2.setDescription("some text");
		thesaurus2.setFormat(new HashSet<ThesaurusFormat>());
		thesaurus2.setIdentifier("data");
		thesaurus2.setLang(new HashSet<Language>());
		thesaurus2.setPolyHierarchical(false);
		thesaurus2.setPublisher("foo");
		thesaurus2.setRelation("DE");
		thesaurus2.setRights("foo");
		thesaurus2.setSource("foo");
		thesaurus2.setSubject("foo");
		thesaurus2.setTitle("Mr");
		ThesaurusType type2 = new ThesaurusType();
		type2.setIdentifier(1);
		type2.setLabel("label");
		thesaurus2.setType(type2);
		thesaurus2.setVersions(new HashSet<ThesaurusVersionHistory>());
		thesaurusConcept1.setThesaurus(thesaurus2);
		thesaurusConcept1.setTopConcept(false);
		thesaurusConceptList.add(thesaurusConcept1);
		ThesaurusTerm thesaurusTerm2 = new ThesaurusTerm();
		ThesaurusConcept concept2 = new ThesaurusConcept();
		concept2.setAssociativeRelationshipLeft(new HashSet<AssociativeRelationship>());
		concept2.setAssociativeRelationshipRight(new HashSet<AssociativeRelationship>());
		concept2.setConceptArrays(new HashSet<ThesaurusArray>());
		concept2.setCreated(new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31"));
		concept2.setIdentifier("data");
		concept2.setModified(new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31"));
		concept2.setNotation("DE");
		concept2.setParentConcepts(new HashSet<ThesaurusConcept>());
		concept2.setRootConcepts(new HashSet<ThesaurusConcept>());
		concept2.setStatus(1);
		Thesaurus thesaurus3 = new Thesaurus();
		thesaurus3.setArchived(false);
		thesaurus3.setContributor("foo");
		thesaurus3.setCoverage("foo");
		thesaurus3.setCreated(new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31"));
		ThesaurusOrganization creator3 = new ThesaurusOrganization();
		creator3.setEmail("info@diffblue.com");
		creator3.setHomepage("foo");
		creator3.setIdentifier(1);
		creator3.setName("Acme");
		thesaurus3.setCreator(creator3);
		thesaurus3.setDate(new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31"));
		thesaurus3.setDefaultTopConcept(false);
		thesaurus3.setDescription("some text");
		thesaurus3.setFormat(new HashSet<ThesaurusFormat>());
		thesaurus3.setIdentifier("data");
		thesaurus3.setLang(new HashSet<Language>());
		thesaurus3.setPolyHierarchical(false);
		thesaurus3.setPublisher("foo");
		thesaurus3.setRelation("DE");
		thesaurus3.setRights("foo");
		thesaurus3.setSource("foo");
		thesaurus3.setSubject("foo");
		thesaurus3.setTitle("Mr");
		ThesaurusType type3 = new ThesaurusType();
		type3.setIdentifier(1);
		type3.setLabel("label");
		thesaurus3.setType(type3);
		thesaurus3.setVersions(new HashSet<ThesaurusVersionHistory>());
		concept2.setThesaurus(thesaurus3);
		concept2.setTopConcept(false);
		thesaurusTerm2.setConcept(concept2);
		thesaurusTerm2.setCreated(new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31"));
		thesaurusTerm2.setHidden(false);
		thesaurusTerm2.setIdentifier("data");
		Language language2 = new Language();
		language2.setId("1234");
		language2.setPart1("foo");
		language2.setPrincipalLanguage(false);
		language2.setRefname("root");
		language2.setTopLanguage(false);
		thesaurusTerm2.setLanguage(language2);
		thesaurusTerm2.setLexicalValue("value");
		thesaurusTerm2.setModified(new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31"));
		thesaurusTerm2.setPrefered(false);
		ThesaurusTermRole role2 = new ThesaurusTermRole();
		role2.setCode("DE");
		role2.setDefaultRole(false);
		role2.setLabel("label");
		thesaurusTerm2.setRole(role2);
		thesaurusTerm2.setSource("foo");
		thesaurusTerm2.setStatus(1);
		Thesaurus thesaurus4 = new Thesaurus();
		thesaurus4.setArchived(false);
		thesaurus4.setContributor("foo");
		thesaurus4.setCoverage("foo");
		thesaurus4.setCreated(new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31"));
		ThesaurusOrganization creator4 = new ThesaurusOrganization();
		creator4.setEmail("info@diffblue.com");
		creator4.setHomepage("foo");
		creator4.setIdentifier(1);
		creator4.setName("Acme");
		thesaurus4.setCreator(creator4);
		thesaurus4.setDate(new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31"));
		thesaurus4.setDefaultTopConcept(false);
		thesaurus4.setDescription("some text");
		thesaurus4.setFormat(new HashSet<ThesaurusFormat>());
		thesaurus4.setIdentifier("data");
		thesaurus4.setLang(new HashSet<Language>());
		thesaurus4.setPolyHierarchical(false);
		thesaurus4.setPublisher("foo");
		thesaurus4.setRelation("DE");
		thesaurus4.setRights("foo");
		thesaurus4.setSource("foo");
		thesaurus4.setSubject("foo");
		thesaurus4.setTitle("Mr");
		ThesaurusType type4 = new ThesaurusType();
		type4.setIdentifier(1);
		type4.setLabel("label");
		thesaurus4.setType(type4);
		thesaurus4.setVersions(new HashSet<ThesaurusVersionHistory>());
		thesaurusTerm2.setThesaurus(thesaurus4);
		when(auditHelper.getConceptChildrenAtRevision(Mockito.<Number>any(), Mockito.<ThesaurusConcept>any(), Mockito.<java.util.List<ThesaurusConcept>>any()))
			.thenReturn(thesaurusConceptList);
		when(auditHelper.getPreferredTermAtRevision(Mockito.<Number>any(), Mockito.<String>any(), Mockito.<String>any()))
			.thenReturn(thesaurusTerm2)
			.thenReturn(thesaurusTerm1);
		ArrayList<ThesaurusConcept> conceptsAtRevision =
			 new ArrayList<ThesaurusConcept>();
		ThesaurusConcept thesaurusConcept2 = new ThesaurusConcept();
		thesaurusConcept2.setAssociativeRelationshipLeft(new HashSet<AssociativeRelationship>());
		thesaurusConcept2.setAssociativeRelationshipRight(new HashSet<AssociativeRelationship>());
		thesaurusConcept2.setConceptArrays(new HashSet<ThesaurusArray>());
		thesaurusConcept2.setCreated(new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31"));
		thesaurusConcept2.setIdentifier("data");
		thesaurusConcept2.setModified(new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31"));
		thesaurusConcept2.setNotation("DE");
		thesaurusConcept2.setParentConcepts(new HashSet<ThesaurusConcept>());
		thesaurusConcept2.setRootConcepts(new HashSet<ThesaurusConcept>());
		thesaurusConcept2.setStatus(1);
		Thesaurus thesaurus5 = new Thesaurus();
		thesaurus5.setArchived(false);
		thesaurus5.setContributor("foo");
		thesaurus5.setCoverage("foo");
		thesaurus5.setCreated(new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31"));
		thesaurus5.setCreator(new ThesaurusOrganization());
		thesaurus5.setDate(new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31"));
		thesaurus5.setDefaultTopConcept(false);
		thesaurus5.setDescription("some text");
		thesaurus5.setFormat(new HashSet<ThesaurusFormat>());
		thesaurus5.setIdentifier("data");
		thesaurus5.setLang(new HashSet<Language>());
		thesaurus5.setPolyHierarchical(false);
		thesaurus5.setPublisher("foo");
		thesaurus5.setRelation("DE");
		thesaurus5.setRights("foo");
		thesaurus5.setSource("foo");
		thesaurus5.setSubject("foo");
		thesaurus5.setTitle("Mr");
		thesaurus5.setType(new ThesaurusType());
		thesaurus5.setVersions(new HashSet<ThesaurusVersionHistory>());
		thesaurusConcept2.setThesaurus(thesaurus5);
		thesaurusConcept2.setTopConcept(false);
		conceptsAtRevision.add(thesaurusConcept2);
		assertEquals(Arrays.asList("value"), service.buildHierarchyStructure(conceptsAtRevision, 1, "mpeg").get("value"));
	}

	@Test
	public void buildSynonymsStructure1() {
		ThesaurusTerm thesaurusTerm = new ThesaurusTerm();
		thesaurusTerm.setLexicalValue("value");
		when(auditHelper.getConceptTermsAtRevision(Mockito.<ThesaurusConcept>any(), Mockito.<Number>any(), Mockito.<String>any()))
			.thenReturn(new ArrayList<ThesaurusTerm>());
		when(auditHelper.getPreferredTermAtRevision(Mockito.<Number>any(), Mockito.<String>any(), Mockito.<String>any()))
			.thenReturn(thesaurusTerm);
		ArrayList<ThesaurusConcept> conceptsAtRevision =
			 new ArrayList<ThesaurusConcept>();
		conceptsAtRevision.add(new ThesaurusConcept());
		assertTrue(service.buildSynonymsStructure(conceptsAtRevision, 1, "mpeg").get("value").isEmpty());
	}

	@Test
	public void buildSynonymsStructure2() {
		ArrayList<ThesaurusTerm> thesaurusTermList = new ArrayList<ThesaurusTerm>();
		ThesaurusTerm thesaurusTerm1 = new ThesaurusTerm();
		thesaurusTerm1.setLexicalValue("value");
		thesaurusTermList.add(thesaurusTerm1);
		ThesaurusTerm thesaurusTerm2 = new ThesaurusTerm();
		thesaurusTerm2.setLexicalValue("value");
		when(auditHelper.getConceptTermsAtRevision(Mockito.<ThesaurusConcept>any(), Mockito.<Number>any(), Mockito.<String>any()))
			.thenReturn(thesaurusTermList);
		when(auditHelper.getPreferredTermAtRevision(Mockito.<Number>any(), Mockito.<String>any(), Mockito.<String>any()))
			.thenReturn(thesaurusTerm2);
		ArrayList<ThesaurusConcept> conceptsAtRevision =
			 new ArrayList<ThesaurusConcept>();
		conceptsAtRevision.add(new ThesaurusConcept());
		assertTrue(service.buildSynonymsStructure(conceptsAtRevision, 1, "mpeg").get("value").isEmpty());
	}

	@Test
	public void getTermVersionsView() {
		ArrayList<ThesaurusTerm> currentTerms = new ArrayList<ThesaurusTerm>();
		ThesaurusTerm thesaurusTerm = new ThesaurusTerm();
		thesaurusTerm.setLexicalValue("value");
		currentTerms.add(thesaurusTerm);
		assertSame(thesaurusTerm, service.getTermVersionsView(currentTerms).get("value"));
	}

	@Test
	public void getNotPreferredTermsByTerm1() {
		ArrayList<ThesaurusTerm> currentTerms = new ArrayList<ThesaurusTerm>();
		ThesaurusTerm thesaurusTerm = mock(ThesaurusTerm.class);
		when(thesaurusTerm.getPrefered())
			.thenReturn(false);
		currentTerms.add(thesaurusTerm);
		assertTrue(service.getNotPreferredTermsByTerm(currentTerms).isEmpty());
	}

	@Test
	public void getNotPreferredTermsByTerm2() {
		ArrayList<ThesaurusTerm> currentTerms = new ArrayList<ThesaurusTerm>();
		ThesaurusTerm thesaurusTerm = new ThesaurusTerm();
		ThesaurusConcept concept = new ThesaurusConcept();
		concept.setIdentifier("data");
		thesaurusTerm.setConcept(concept);
		thesaurusTerm.setLexicalValue("value");
		thesaurusTerm.setPrefered(true);
		currentTerms.add(thesaurusTerm);
		assertTrue(service.getNotPreferredTermsByTerm(currentTerms).get("value").isEmpty());
	}

	@Test
	public void getNotPreferredTermsByTermCurrentTermsIsEmpty() {
		assertTrue(service.getNotPreferredTermsByTerm(new ArrayList<ThesaurusTerm>()).isEmpty());
	}
}
