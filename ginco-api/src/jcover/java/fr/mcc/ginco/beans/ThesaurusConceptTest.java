package fr.mcc.ginco.beans;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.empty;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsSame.sameInstance;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;

import org.junit.jupiter.api.Test;

/**
 * Unit tests for fr.mcc.ginco.beans.ThesaurusConcept
 *
 * @author Diffblue Cover
 */

class ThesaurusConceptTest {

	@Test
	void factory() throws java.text.ParseException {
		ThesaurusConcept thesaurusConcept = new ThesaurusConcept();
		thesaurusConcept.setAssociativeRelationshipLeft(new HashSet<AssociativeRelationship>());
		thesaurusConcept.setAssociativeRelationshipRight(new HashSet<AssociativeRelationship>());
		thesaurusConcept.setConceptArrays(new HashSet<ThesaurusArray>());
		Date created1 = new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31");
		thesaurusConcept.setCreated(created1);
		thesaurusConcept.setIdentifier("data");
		Date modified = new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31");
		thesaurusConcept.setModified(modified);
		thesaurusConcept.setNotation("DE");
		thesaurusConcept.setParentConcepts(new HashSet<ThesaurusConcept>());
		thesaurusConcept.setRootConcepts(new HashSet<ThesaurusConcept>());
		thesaurusConcept.setStatus(1);
		Thesaurus thesaurus = new Thesaurus();
		thesaurus.setArchived(false);
		thesaurus.setContributor("foo");
		thesaurus.setCoverage("foo");
		thesaurus.setCreated(new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31"));
		ThesaurusOrganization creator = new ThesaurusOrganization();
		creator.setEmail("info@diffblue.com");
		creator.setHomepage("foo");
		creator.setIdentifier(1);
		creator.setName("Acme");
		thesaurus.setCreator(creator);
		thesaurus.setDate(new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31"));
		thesaurus.setDefaultTopConcept(false);
		thesaurus.setDescription("some text");
		thesaurus.setFormat(new HashSet<ThesaurusFormat>());
		thesaurus.setIdentifier("data");
		thesaurus.setLang(new HashSet<Language>());
		thesaurus.setPolyHierarchical(false);
		thesaurus.setPublisher("foo");
		thesaurus.setRelation("DE");
		thesaurus.setRights("foo");
		thesaurus.setSource("foo");
		thesaurus.setSubject("foo");
		thesaurus.setTitle("Mr");
		ThesaurusType type = new ThesaurusType();
		type.setIdentifier(1);
		type.setLabel("label");
		thesaurus.setType(type);
		thesaurus.setVersions(new HashSet<ThesaurusVersionHistory>());
		thesaurusConcept.setThesaurus(thesaurus);
		thesaurusConcept.setTopConcept(false);
		assertThat(thesaurusConcept.getAssociativeRelationshipLeft(), empty());
		assertThat(thesaurusConcept.getAssociativeRelationshipRight(), empty());
		assertThat(thesaurusConcept.getConceptArrays(), empty());
		assertThat(thesaurusConcept.getCreated(), sameInstance(created1));
		assertThat(thesaurusConcept.getIdentifier(), is("data"));
		assertThat(thesaurusConcept.getModified(), sameInstance(modified));
		assertThat(thesaurusConcept.getNotation(), is("DE"));
		assertThat(thesaurusConcept.getParentConcepts(), empty());
		assertThat(thesaurusConcept.getRootConcepts(), empty());
		assertThat(thesaurusConcept.getStatus(), is(1));
		assertThat(thesaurusConcept.getThesaurus(), sameInstance(thesaurus));
		assertThat(thesaurusConcept.getTopConcept(), is(false));
	}

	@Test
	void getThesaurusIdReturnsData() {
		ThesaurusConcept thesaurusConcept = new ThesaurusConcept();
		Thesaurus thesaurus = new Thesaurus();
		thesaurus.setIdentifier("data");
		thesaurusConcept.setThesaurus(thesaurus);
		assertThat(thesaurusConcept.getThesaurusId(), is("data"));
	}

	@Test
	void testEquals() {
		assertThat(new ThesaurusConcept().equals(new Object()), is(false));
		assertThat(new ThesaurusConcept().equals(null), is(false));
	}
}
