package fr.mcc.ginco.beans;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsSame.sameInstance;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;

import org.junit.jupiter.api.Test;

/**
 * Unit tests for fr.mcc.ginco.beans.ThesaurusTerm
 *
 * @author Diffblue Cover
 */

class ThesaurusTermTest {

	@Test
	void factory() throws java.text.ParseException {
		ThesaurusTerm thesaurusTerm = new ThesaurusTerm();
		ThesaurusConcept concept = new ThesaurusConcept();
		concept.setAssociativeRelationshipLeft(new HashSet<AssociativeRelationship>());
		concept.setAssociativeRelationshipRight(new HashSet<AssociativeRelationship>());
		concept.setConceptArrays(new HashSet<ThesaurusArray>());
		concept.setCreated(new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31"));
		concept.setIdentifier("data");
		concept.setModified(new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31"));
		concept.setNotation("DE");
		concept.setParentConcepts(new HashSet<ThesaurusConcept>());
		concept.setRootConcepts(new HashSet<ThesaurusConcept>());
		concept.setStatus(1);
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
		concept.setThesaurus(thesaurus1);
		concept.setTopConcept(false);
		thesaurusTerm.setConcept(concept);
		Date created3 = new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31");
		thesaurusTerm.setCreated(created3);
		thesaurusTerm.setHidden(false);
		thesaurusTerm.setIdentifier("data");
		Language language = new Language();
		language.setId("1234");
		language.setPart1("foo");
		language.setPrincipalLanguage(false);
		language.setRefname("foo");
		language.setTopLanguage(false);
		thesaurusTerm.setLanguage(language);
		thesaurusTerm.setLexicalValue("value");
		Date modified2 = new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31");
		thesaurusTerm.setModified(modified2);
		thesaurusTerm.setPrefered(false);
		ThesaurusTermRole role = new ThesaurusTermRole();
		role.setCode("DE");
		role.setDefaultRole(false);
		role.setLabel("label");
		thesaurusTerm.setRole(role);
		thesaurusTerm.setSource("foo");
		thesaurusTerm.setStatus(1);
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
		thesaurusTerm.setThesaurus(thesaurus2);
		assertThat(thesaurusTerm.getConcept(), sameInstance(concept));
		assertThat(thesaurusTerm.getCreated(), sameInstance(created3));
		assertThat(thesaurusTerm.getHidden(), is(false));
		assertThat(thesaurusTerm.getIdentifier(), is("data"));
		assertThat(thesaurusTerm.getLanguage(), sameInstance(language));
		assertThat(thesaurusTerm.getLexicalValue(), is("value"));
		assertThat(thesaurusTerm.getModified(), sameInstance(modified2));
		assertThat(thesaurusTerm.getPrefered(), is(false));
		assertThat(thesaurusTerm.getRole(), sameInstance(role));
		assertThat(thesaurusTerm.getSource(), is("foo"));
		assertThat(thesaurusTerm.getStatus(), is(1));
		assertThat(thesaurusTerm.getThesaurus(), sameInstance(thesaurus2));
	}

	@Test
	void getThesaurusIdReturnsData() {
		ThesaurusTerm thesaurusTerm = new ThesaurusTerm();
		Thesaurus thesaurus2 = new Thesaurus();
		thesaurus2.setIdentifier("data");
		thesaurusTerm.setThesaurus(thesaurus2);
		assertThat(thesaurusTerm.getThesaurusId(), is("data"));
	}
}
