package fr.mcc.ginco.beans;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsSame.sameInstance;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;

import org.junit.jupiter.api.Test;

/**
 * Unit tests for fr.mcc.ginco.beans.NodeLabel
 *
 * @author Diffblue Cover
 */

class NodeLabelTest {

	@Test
	void factory() throws java.text.ParseException {
		NodeLabel nodeLabel = new NodeLabel();
		Date created1 = new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31");
		nodeLabel.setCreated(created1);
		nodeLabel.setIdentifier(1);
		Language language = new Language();
		language.setId("1234");
		language.setPart1("foo");
		language.setPrincipalLanguage(false);
		language.setRefname("root");
		language.setTopLanguage(false);
		nodeLabel.setLanguage(language);
		nodeLabel.setLexicalValue("value");
		Date modified1 = new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31");
		nodeLabel.setModified(modified1);
		ThesaurusArray thesaurusArray = new ThesaurusArray();
		thesaurusArray.setConcepts(new HashSet<ThesaurusArrayConcept>());
		thesaurusArray.setIdentifier("data");
		thesaurusArray.setNotation("DE");
		thesaurusArray.setOrdered(false);
		ThesaurusArray parent1 = new ThesaurusArray();
		parent1.setConcepts(new HashSet<ThesaurusArrayConcept>());
		parent1.setIdentifier("data");
		parent1.setNotation("DE");
		parent1.setOrdered(false);
		ThesaurusArray parent2 = new ThesaurusArray();
		parent2.setConcepts(new HashSet<ThesaurusArrayConcept>());
		parent2.setIdentifier("data");
		parent2.setNotation("DE");
		parent2.setOrdered(false);
		parent2.setParent(new ThesaurusArray());
		parent2.setSuperOrdinateConcept(new ThesaurusConcept());
		parent2.setThesaurus(new Thesaurus());
		parent1.setParent(parent2);
		ThesaurusConcept superOrdinateConcept2 = new ThesaurusConcept();
		superOrdinateConcept2.setAssociativeRelationshipLeft(new HashSet<AssociativeRelationship>());
		superOrdinateConcept2.setAssociativeRelationshipRight(new HashSet<AssociativeRelationship>());
		superOrdinateConcept2.setConceptArrays(new HashSet<ThesaurusArray>());
		superOrdinateConcept2.setCreated(new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31"));
		superOrdinateConcept2.setIdentifier("data");
		superOrdinateConcept2.setModified(new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31"));
		superOrdinateConcept2.setNotation("DE");
		superOrdinateConcept2.setParentConcepts(new HashSet<ThesaurusConcept>());
		superOrdinateConcept2.setRootConcepts(new HashSet<ThesaurusConcept>());
		superOrdinateConcept2.setStatus(1);
		superOrdinateConcept2.setThesaurus(new Thesaurus());
		superOrdinateConcept2.setTopConcept(false);
		parent1.setSuperOrdinateConcept(superOrdinateConcept2);
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
		thesaurusArray.setParent(parent1);
		ThesaurusConcept superOrdinateConcept3 = new ThesaurusConcept();
		superOrdinateConcept3.setAssociativeRelationshipLeft(new HashSet<AssociativeRelationship>());
		superOrdinateConcept3.setAssociativeRelationshipRight(new HashSet<AssociativeRelationship>());
		superOrdinateConcept3.setConceptArrays(new HashSet<ThesaurusArray>());
		superOrdinateConcept3.setCreated(new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31"));
		superOrdinateConcept3.setIdentifier("data");
		superOrdinateConcept3.setModified(new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31"));
		superOrdinateConcept3.setNotation("DE");
		superOrdinateConcept3.setParentConcepts(new HashSet<ThesaurusConcept>());
		superOrdinateConcept3.setRootConcepts(new HashSet<ThesaurusConcept>());
		superOrdinateConcept3.setStatus(1);
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
		superOrdinateConcept3.setThesaurus(thesaurus4);
		superOrdinateConcept3.setTopConcept(false);
		thesaurusArray.setSuperOrdinateConcept(superOrdinateConcept3);
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
		thesaurusArray.setThesaurus(thesaurus5);
		nodeLabel.setThesaurusArray(thesaurusArray);
		assertThat(nodeLabel.getCreated(), sameInstance(created1));
		assertThat(nodeLabel.getIdentifier(), is(1));
		assertThat(nodeLabel.getLanguage(), sameInstance(language));
		assertThat(nodeLabel.getLexicalValue(), is("value"));
		assertThat(nodeLabel.getModified(), sameInstance(modified1));
		assertThat(nodeLabel.getThesaurusArray(), sameInstance(thesaurusArray));
	}
}
