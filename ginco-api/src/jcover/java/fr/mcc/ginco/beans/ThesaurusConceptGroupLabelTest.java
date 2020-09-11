package fr.mcc.ginco.beans;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsSame.sameInstance;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;

import org.junit.jupiter.api.Test;

/**
 * Unit tests for fr.mcc.ginco.beans.ThesaurusConceptGroupLabel
 *
 * @author Diffblue Cover
 */

class ThesaurusConceptGroupLabelTest {

	@Test
	void factory() throws java.text.ParseException {
		ThesaurusConceptGroupLabel thesaurusConceptGroupLabel =
			 new ThesaurusConceptGroupLabel();
		ThesaurusConceptGroup conceptGroup = new ThesaurusConceptGroup();
		ThesaurusConceptGroupType conceptGroupType1 =
			 new ThesaurusConceptGroupType();
		conceptGroupType1.setCode("DE");
		conceptGroupType1.setLabel("label");
		conceptGroupType1.setSkosLabel("label");
		conceptGroup.setConceptGroupType(conceptGroupType1);
		conceptGroup.setConcepts(new HashSet<ThesaurusConcept>());
		conceptGroup.setIdentifier("data");
		conceptGroup.setIsDynamic(false);
		conceptGroup.setNotation("DE");
		ThesaurusConceptGroup parent1 = new ThesaurusConceptGroup();
		ThesaurusConceptGroupType conceptGroupType2 =
			 new ThesaurusConceptGroupType();
		conceptGroupType2.setCode("DE");
		conceptGroupType2.setLabel("label");
		conceptGroupType2.setSkosLabel("label");
		parent1.setConceptGroupType(conceptGroupType2);
		parent1.setConcepts(new HashSet<ThesaurusConcept>());
		parent1.setIdentifier("data");
		parent1.setIsDynamic(false);
		parent1.setNotation("DE");
		ThesaurusConceptGroup parent2 = new ThesaurusConceptGroup();
		parent2.setConceptGroupType(new ThesaurusConceptGroupType());
		parent2.setConcepts(new HashSet<ThesaurusConcept>());
		parent2.setIdentifier("data");
		parent2.setIsDynamic(false);
		parent2.setNotation("DE");
		parent2.setParent(new ThesaurusConceptGroup());
		parent2.setParentConcept(new ThesaurusConcept());
		parent2.setThesaurus(new Thesaurus());
		parent1.setParent(parent2);
		ThesaurusConcept parentConcept2 = new ThesaurusConcept();
		parentConcept2.setAssociativeRelationshipLeft(new HashSet<AssociativeRelationship>());
		parentConcept2.setAssociativeRelationshipRight(new HashSet<AssociativeRelationship>());
		parentConcept2.setConceptArrays(new HashSet<ThesaurusArray>());
		parentConcept2.setCreated(new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31"));
		parentConcept2.setIdentifier("data");
		parentConcept2.setModified(new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31"));
		parentConcept2.setNotation("DE");
		parentConcept2.setParentConcepts(new HashSet<ThesaurusConcept>());
		parentConcept2.setRootConcepts(new HashSet<ThesaurusConcept>());
		parentConcept2.setStatus(1);
		parentConcept2.setThesaurus(new Thesaurus());
		parentConcept2.setTopConcept(false);
		parent1.setParentConcept(parentConcept2);
		Thesaurus thesaurus3 = new Thesaurus();
		thesaurus3.setArchived(false);
		thesaurus3.setContributor("foo");
		thesaurus3.setCoverage("foo");
		thesaurus3.setCreated(new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31"));
		thesaurus3.setCreator(new ThesaurusOrganization());
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
		thesaurus3.setType(new ThesaurusType());
		thesaurus3.setVersions(new HashSet<ThesaurusVersionHistory>());
		parent1.setThesaurus(thesaurus3);
		conceptGroup.setParent(parent1);
		ThesaurusConcept parentConcept3 = new ThesaurusConcept();
		parentConcept3.setAssociativeRelationshipLeft(new HashSet<AssociativeRelationship>());
		parentConcept3.setAssociativeRelationshipRight(new HashSet<AssociativeRelationship>());
		parentConcept3.setConceptArrays(new HashSet<ThesaurusArray>());
		parentConcept3.setCreated(new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31"));
		parentConcept3.setIdentifier("data");
		parentConcept3.setModified(new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31"));
		parentConcept3.setNotation("DE");
		parentConcept3.setParentConcepts(new HashSet<ThesaurusConcept>());
		parentConcept3.setRootConcepts(new HashSet<ThesaurusConcept>());
		parentConcept3.setStatus(1);
		Thesaurus thesaurus4 = new Thesaurus();
		thesaurus4.setArchived(false);
		thesaurus4.setContributor("foo");
		thesaurus4.setCoverage("foo");
		thesaurus4.setCreated(new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31"));
		thesaurus4.setCreator(new ThesaurusOrganization());
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
		thesaurus4.setType(new ThesaurusType());
		thesaurus4.setVersions(new HashSet<ThesaurusVersionHistory>());
		parentConcept3.setThesaurus(thesaurus4);
		parentConcept3.setTopConcept(false);
		conceptGroup.setParentConcept(parentConcept3);
		Thesaurus thesaurus5 = new Thesaurus();
		thesaurus5.setArchived(false);
		thesaurus5.setContributor("foo");
		thesaurus5.setCoverage("foo");
		thesaurus5.setCreated(new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31"));
		ThesaurusOrganization creator3 = new ThesaurusOrganization();
		creator3.setEmail("info@diffblue.com");
		creator3.setHomepage("foo");
		creator3.setIdentifier(1);
		creator3.setName("Acme");
		thesaurus5.setCreator(creator3);
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
		ThesaurusType type3 = new ThesaurusType();
		type3.setIdentifier(1);
		type3.setLabel("label");
		thesaurus5.setType(type3);
		thesaurus5.setVersions(new HashSet<ThesaurusVersionHistory>());
		conceptGroup.setThesaurus(thesaurus5);
		thesaurusConceptGroupLabel.setConceptGroup(conceptGroup);
		Date created6 = new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31");
		thesaurusConceptGroupLabel.setCreated(created6);
		thesaurusConceptGroupLabel.setIdentifier(1);
		Language language = new Language();
		language.setId("1234");
		language.setPart1("foo");
		language.setPrincipalLanguage(false);
		language.setRefname("root");
		language.setTopLanguage(false);
		thesaurusConceptGroupLabel.setLanguage(language);
		thesaurusConceptGroupLabel.setLexicalValue("value");
		Date modified3 = new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31");
		thesaurusConceptGroupLabel.setModified(modified3);
		assertThat(thesaurusConceptGroupLabel.getConceptGroup(), sameInstance(conceptGroup));
		assertThat(thesaurusConceptGroupLabel.getCreated(), sameInstance(created6));
		assertThat(thesaurusConceptGroupLabel.getIdentifier(), is(1));
		assertThat(thesaurusConceptGroupLabel.getLanguage(), sameInstance(language));
		assertThat(thesaurusConceptGroupLabel.getLexicalValue(), is("value"));
		assertThat(thesaurusConceptGroupLabel.getModified(), sameInstance(modified3));
	}
}
