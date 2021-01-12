package fr.mcc.ginco.beans;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsSame.sameInstance;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;

import org.junit.jupiter.api.Test;

/**
 * Unit tests for fr.mcc.ginco.beans.Suggestion
 *
 * @author Diffblue Cover
 */

class SuggestionTest {

	@Test
	void factory() throws java.text.ParseException {
		Suggestion suggestion = new Suggestion();
		ThesaurusConcept concept1 = new ThesaurusConcept();
		concept1.setAssociativeRelationshipLeft(new HashSet<AssociativeRelationship>());
		concept1.setAssociativeRelationshipRight(new HashSet<AssociativeRelationship>());
		concept1.setConceptArrays(new HashSet<ThesaurusArray>());
		concept1.setCreated(new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31"));
		concept1.setIdentifier("data");
		concept1.setModified(new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31"));
		concept1.setNotation("DE");
		concept1.setParentConcepts(new HashSet<ThesaurusConcept>());
		concept1.setRootConcepts(new HashSet<ThesaurusConcept>());
		concept1.setStatus(1);
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
		concept1.setThesaurus(thesaurus1);
		concept1.setTopConcept(false);
		suggestion.setConcept(concept1);
		suggestion.setContent("hello");
		Date created3 = new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31");
		suggestion.setCreated(created3);
		suggestion.setCreator("someone");
		suggestion.setIdentifier(1);
		suggestion.setRecipient("1234");
		ThesaurusTerm term = new ThesaurusTerm();
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
		Thesaurus thesaurus2 = new Thesaurus();
		thesaurus2.setArchived(false);
		thesaurus2.setContributor("foo");
		thesaurus2.setCoverage("foo");
		thesaurus2.setCreated(new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31"));
		thesaurus2.setCreator(new ThesaurusOrganization());
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
		thesaurus2.setType(new ThesaurusType());
		thesaurus2.setVersions(new HashSet<ThesaurusVersionHistory>());
		concept2.setThesaurus(thesaurus2);
		concept2.setTopConcept(false);
		term.setConcept(concept2);
		term.setCreated(new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31"));
		term.setHidden(false);
		term.setIdentifier("data");
		Language language = new Language();
		language.setId("1234");
		language.setPart1("foo");
		language.setPrincipalLanguage(false);
		language.setRefname("root");
		language.setTopLanguage(false);
		term.setLanguage(language);
		term.setLexicalValue("value");
		term.setModified(new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31"));
		term.setPrefered(false);
		ThesaurusTermRole role = new ThesaurusTermRole();
		role.setCode("DE");
		role.setDefaultRole(false);
		role.setLabel("label");
		term.setRole(role);
		term.setSource("foo");
		term.setStatus(1);
		Thesaurus thesaurus3 = new Thesaurus();
		thesaurus3.setArchived(false);
		thesaurus3.setContributor("foo");
		thesaurus3.setCoverage("foo");
		thesaurus3.setCreated(new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31"));
		ThesaurusOrganization creator4 = new ThesaurusOrganization();
		creator4.setEmail("info@diffblue.com");
		creator4.setHomepage("foo");
		creator4.setIdentifier(1);
		creator4.setName("Acme");
		thesaurus3.setCreator(creator4);
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
		term.setThesaurus(thesaurus3);
		suggestion.setTerm(term);
		assertThat(suggestion.getConcept(), sameInstance(concept1));
		assertThat(suggestion.getContent(), is("hello"));
		assertThat(suggestion.getCreated(), sameInstance(created3));
		assertThat(suggestion.getCreator(), is("someone"));
		assertThat(suggestion.getIdentifier(), is(1));
		assertThat(suggestion.getRecipient(), is("1234"));
		assertThat(suggestion.getTerm(), sameInstance(term));
	}
}
