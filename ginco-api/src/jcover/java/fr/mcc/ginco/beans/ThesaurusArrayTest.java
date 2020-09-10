package fr.mcc.ginco.beans;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.empty;
import static org.hamcrest.Matchers.nullValue;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsSame.sameInstance;

import java.text.SimpleDateFormat;
import java.util.HashSet;

import org.junit.jupiter.api.Test;

/**
 * Unit tests for fr.mcc.ginco.beans.ThesaurusArray
 *
 * @author Diffblue Cover
 */

class ThesaurusArrayTest {

	@Test
	void factory() throws java.text.ParseException {
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
		superOrdinateConcept.setThesaurus(new Thesaurus());
		superOrdinateConcept.setTopConcept(false);
		thesaurusArray.setSuperOrdinateConcept(superOrdinateConcept);
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
		thesaurusArray.setThesaurus(thesaurus2);
		assertThat(thesaurusArray.getConcepts(), empty());
		assertThat(thesaurusArray.getIdentifier(), is("data"));
		assertThat(thesaurusArray.getNotation(), is("DE"));
		assertThat(thesaurusArray.getOrdered(), is(false));
		assertThat(thesaurusArray.getParent(), is(nullValue()));
		assertThat(thesaurusArray.getSuperOrdinateConcept(), sameInstance(superOrdinateConcept));
		assertThat(thesaurusArray.getThesaurus(), sameInstance(thesaurus2));
	}
}
