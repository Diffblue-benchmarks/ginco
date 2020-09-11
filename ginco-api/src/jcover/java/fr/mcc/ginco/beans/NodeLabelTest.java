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
		language.setRefname("foo");
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
		ThesaurusConcept superOrdinateConcept = new ThesaurusConcept();
		superOrdinateConcept.setAssociativeRelationshipLeft(new HashSet<AssociativeRelationship>());
		superOrdinateConcept.setAssociativeRelationshipRight(new HashSet<AssociativeRelationship>());
		superOrdinateConcept.setConceptArrays(new HashSet<ThesaurusArray>());
		superOrdinateConcept.setCreated(new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31"));
		superOrdinateConcept.setIdentifier("data");
		superOrdinateConcept.setModified(new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31"));
		superOrdinateConcept.setNotation("DE");
		superOrdinateConcept.setParentConcepts(new HashSet<ThesaurusConcept>());
		superOrdinateConcept.setRootConcepts(new HashSet<ThesaurusConcept>());
		superOrdinateConcept.setStatus(1);
		Thesaurus thesaurus1 = new Thesaurus();
		thesaurus1.setArchived(false);
		thesaurus1.setContributor("foo");
		thesaurus1.setCoverage("foo");
		thesaurus1.setCreated(new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31"));
		thesaurus1.setCreator(new ThesaurusOrganization());
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
		thesaurus1.setType(new ThesaurusType());
		thesaurus1.setVersions(new HashSet<ThesaurusVersionHistory>());
		superOrdinateConcept.setThesaurus(thesaurus1);
		superOrdinateConcept.setTopConcept(false);
		thesaurusArray.setSuperOrdinateConcept(superOrdinateConcept);
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
		thesaurusArray.setThesaurus(thesaurus2);
		nodeLabel.setThesaurusArray(thesaurusArray);
		assertThat(nodeLabel.getCreated(), sameInstance(created1));
		assertThat(nodeLabel.getIdentifier(), is(1));
		assertThat(nodeLabel.getLanguage(), sameInstance(language));
		assertThat(nodeLabel.getLexicalValue(), is("value"));
		assertThat(nodeLabel.getModified(), sameInstance(modified1));
		assertThat(nodeLabel.getThesaurusArray(), sameInstance(thesaurusArray));
	}
}
