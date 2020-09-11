package fr.mcc.ginco.beans;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.empty;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsSame.sameInstance;

import java.text.SimpleDateFormat;
import java.util.HashSet;

import org.junit.jupiter.api.Test;

/**
 * Unit tests for fr.mcc.ginco.beans.ThesaurusConceptGroup
 *
 * @author Diffblue Cover
 */

class ThesaurusConceptGroupTest {

	@Test
	void factory() throws java.text.ParseException {
		ThesaurusConceptGroup thesaurusConceptGroup = new ThesaurusConceptGroup();
		ThesaurusConceptGroupType conceptGroupType1 =
			 new ThesaurusConceptGroupType();
		conceptGroupType1.setCode("DE");
		conceptGroupType1.setLabel("label");
		conceptGroupType1.setSkosLabel("label");
		thesaurusConceptGroup.setConceptGroupType(conceptGroupType1);
		thesaurusConceptGroup.setConcepts(new HashSet<ThesaurusConcept>());
		thesaurusConceptGroup.setIdentifier("data");
		thesaurusConceptGroup.setIsDynamic(false);
		thesaurusConceptGroup.setNotation("DE");
		ThesaurusConceptGroup parent = new ThesaurusConceptGroup();
		ThesaurusConceptGroupType conceptGroupType2 =
			 new ThesaurusConceptGroupType();
		conceptGroupType2.setCode("DE");
		conceptGroupType2.setLabel("label");
		conceptGroupType2.setSkosLabel("label");
		parent.setConceptGroupType(conceptGroupType2);
		parent.setConcepts(new HashSet<ThesaurusConcept>());
		parent.setIdentifier("data");
		parent.setIsDynamic(false);
		parent.setNotation("DE");
		ThesaurusConcept parentConcept1 = new ThesaurusConcept();
		parentConcept1.setAssociativeRelationshipLeft(new HashSet<AssociativeRelationship>());
		parentConcept1.setAssociativeRelationshipRight(new HashSet<AssociativeRelationship>());
		parentConcept1.setConceptArrays(new HashSet<ThesaurusArray>());
		parentConcept1.setCreated(new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31"));
		parentConcept1.setIdentifier("data");
		parentConcept1.setModified(new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31"));
		parentConcept1.setNotation("DE");
		parentConcept1.setParentConcepts(new HashSet<ThesaurusConcept>());
		parentConcept1.setRootConcepts(new HashSet<ThesaurusConcept>());
		parentConcept1.setStatus(1);
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
		parentConcept1.setThesaurus(thesaurus1);
		parentConcept1.setTopConcept(false);
		parent.setParentConcept(parentConcept1);
		Thesaurus thesaurus2 = new Thesaurus();
		thesaurus2.setArchived(false);
		thesaurus2.setContributor("foo");
		thesaurus2.setCoverage("foo");
		thesaurus2.setCreated(new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31"));
		ThesaurusOrganization creator1 = new ThesaurusOrganization();
		creator1.setEmail("info@diffblue.com");
		creator1.setHomepage("foo");
		creator1.setIdentifier(1);
		creator1.setName("Acme");
		thesaurus2.setCreator(creator1);
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
		ThesaurusType type1 = new ThesaurusType();
		type1.setIdentifier(1);
		type1.setLabel("label");
		thesaurus2.setType(type1);
		thesaurus2.setVersions(new HashSet<ThesaurusVersionHistory>());
		parent.setThesaurus(thesaurus2);
		thesaurusConceptGroup.setParent(parent);
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
		Thesaurus thesaurus3 = new Thesaurus();
		thesaurus3.setArchived(false);
		thesaurus3.setContributor("foo");
		thesaurus3.setCoverage("foo");
		thesaurus3.setCreated(new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31"));
		ThesaurusOrganization creator2 = new ThesaurusOrganization();
		creator2.setEmail("info@diffblue.com");
		creator2.setHomepage("foo");
		creator2.setIdentifier(1);
		creator2.setName("Acme");
		thesaurus3.setCreator(creator2);
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
		ThesaurusType type2 = new ThesaurusType();
		type2.setIdentifier(1);
		type2.setLabel("label");
		thesaurus3.setType(type2);
		thesaurus3.setVersions(new HashSet<ThesaurusVersionHistory>());
		parentConcept2.setThesaurus(thesaurus3);
		parentConcept2.setTopConcept(false);
		thesaurusConceptGroup.setParentConcept(parentConcept2);
		Thesaurus thesaurus4 = new Thesaurus();
		thesaurus4.setArchived(false);
		thesaurus4.setContributor("foo");
		thesaurus4.setCoverage("foo");
		thesaurus4.setCreated(new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31"));
		ThesaurusOrganization creator3 = new ThesaurusOrganization();
		creator3.setEmail("info@diffblue.com");
		creator3.setHomepage("foo");
		creator3.setIdentifier(1);
		creator3.setName("Acme");
		thesaurus4.setCreator(creator3);
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
		ThesaurusType type3 = new ThesaurusType();
		type3.setIdentifier(1);
		type3.setLabel("label");
		thesaurus4.setType(type3);
		thesaurus4.setVersions(new HashSet<ThesaurusVersionHistory>());
		thesaurusConceptGroup.setThesaurus(thesaurus4);
		assertThat(thesaurusConceptGroup.getConceptGroupType(), sameInstance(conceptGroupType1));
		assertThat(thesaurusConceptGroup.getConcepts(), empty());
		assertThat(thesaurusConceptGroup.getIdentifier(), is("data"));
		assertThat(thesaurusConceptGroup.getIsDynamic(), is(false));
		assertThat(thesaurusConceptGroup.getNotation(), is("DE"));
		assertThat(thesaurusConceptGroup.getParent(), sameInstance(parent));
		assertThat(thesaurusConceptGroup.getParentConcept(), sameInstance(parentConcept2));
		assertThat(thesaurusConceptGroup.getThesaurus(), sameInstance(thesaurus4));
	}
}
