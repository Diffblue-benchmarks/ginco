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
		ThesaurusConceptGroupType conceptGroupType = new ThesaurusConceptGroupType();
		conceptGroupType.setCode("DE");
		conceptGroupType.setLabel("label");
		conceptGroupType.setSkosLabel("label");
		conceptGroup.setConceptGroupType(conceptGroupType);
		conceptGroup.setConcepts(new HashSet<ThesaurusConcept>());
		conceptGroup.setIdentifier("data");
		conceptGroup.setIsDynamic(false);
		conceptGroup.setNotation("DE");
		ThesaurusConcept parentConcept = new ThesaurusConcept();
		parentConcept.setAssociativeRelationshipLeft(new HashSet<AssociativeRelationship>());
		parentConcept.setAssociativeRelationshipRight(new HashSet<AssociativeRelationship>());
		parentConcept.setConceptArrays(new HashSet<ThesaurusArray>());
		parentConcept.setCreated(new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31"));
		parentConcept.setIdentifier("data");
		parentConcept.setModified(new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31"));
		parentConcept.setNotation("DE");
		parentConcept.setParentConcepts(new HashSet<ThesaurusConcept>());
		parentConcept.setRootConcepts(new HashSet<ThesaurusConcept>());
		parentConcept.setStatus(1);
		Thesaurus thesaurus1 = new Thesaurus();
		thesaurus1.setArchived(false);
		thesaurus1.setContributor("foo");
		thesaurus1.setCoverage("foo");
		thesaurus1.setCreated(new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31"));
		thesaurus1.setDate(new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31"));
		thesaurus1.setDefaultTopConcept(false);
		thesaurus1.setDescription("some text");
		thesaurus1.setIdentifier("data");
		thesaurus1.setPolyHierarchical(false);
		thesaurus1.setPublisher("foo");
		thesaurus1.setRelation("DE");
		thesaurus1.setRights("foo");
		thesaurus1.setSource("foo");
		thesaurus1.setSubject("foo");
		thesaurus1.setTitle("Mr");
		parentConcept.setThesaurus(thesaurus1);
		parentConcept.setTopConcept(false);
		conceptGroup.setParentConcept(parentConcept);
		Thesaurus thesaurus2 = new Thesaurus();
		thesaurus2.setArchived(false);
		thesaurus2.setContributor("foo");
		thesaurus2.setCoverage("foo");
		thesaurus2.setCreated(new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31"));
		ThesaurusOrganization creator = new ThesaurusOrganization();
		creator.setEmail("info@diffblue.com");
		creator.setHomepage("foo");
		creator.setIdentifier(1);
		creator.setName("Acme");
		thesaurus2.setCreator(creator);
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
		ThesaurusType type = new ThesaurusType();
		type.setIdentifier(1);
		type.setLabel("label");
		thesaurus2.setType(type);
		thesaurus2.setVersions(new HashSet<ThesaurusVersionHistory>());
		conceptGroup.setThesaurus(thesaurus2);
		thesaurusConceptGroupLabel.setConceptGroup(conceptGroup);
		Date created4 = new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31");
		thesaurusConceptGroupLabel.setCreated(created4);
		thesaurusConceptGroupLabel.setIdentifier(1);
		Language language = new Language();
		language.setId("1234");
		language.setPart1("foo");
		language.setPrincipalLanguage(false);
		language.setRefname("foo");
		language.setTopLanguage(false);
		thesaurusConceptGroupLabel.setLanguage(language);
		thesaurusConceptGroupLabel.setLexicalValue("value");
		Date modified2 = new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31");
		thesaurusConceptGroupLabel.setModified(modified2);
		assertThat(thesaurusConceptGroupLabel.getConceptGroup(), sameInstance(conceptGroup));
		assertThat(thesaurusConceptGroupLabel.getCreated(), sameInstance(created4));
		assertThat(thesaurusConceptGroupLabel.getIdentifier(), is(1));
		assertThat(thesaurusConceptGroupLabel.getLanguage(), sameInstance(language));
		assertThat(thesaurusConceptGroupLabel.getLexicalValue(), is("value"));
		assertThat(thesaurusConceptGroupLabel.getModified(), sameInstance(modified2));
	}
}
