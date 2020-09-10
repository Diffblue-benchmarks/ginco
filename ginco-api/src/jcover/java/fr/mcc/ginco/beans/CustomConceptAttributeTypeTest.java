package fr.mcc.ginco.beans;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsSame.sameInstance;

import java.text.SimpleDateFormat;
import java.util.HashSet;

import org.junit.jupiter.api.Test;

/**
 * Unit tests for fr.mcc.ginco.beans.CustomConceptAttributeType
 *
 * @author Diffblue Cover
 */

class CustomConceptAttributeTypeTest {

	@Test
	void factory() throws java.text.ParseException {
		CustomConceptAttributeType customConceptAttributeType = new CustomConceptAttributeType();
		customConceptAttributeType.setExportable(false);
		customConceptAttributeType.setCode("DE");
		customConceptAttributeType.setIdentifier(1);
		Thesaurus thesaurus = new Thesaurus();
		thesaurus.setArchived(false);
		thesaurus.setContributor("foo");
		thesaurus.setCoverage("foo");
		thesaurus.setCreated(new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31"));
		thesaurus.setCreator(new ThesaurusOrganization());
		thesaurus.setDate(new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31"));
		thesaurus.setDefaultTopConcept(false);
		thesaurus.setDescription("some text");
		thesaurus.setFormat(new HashSet<ThesaurusFormat>());
		thesaurus.setIdentifier("foo");
		thesaurus.setLang(new HashSet<Language>());
		thesaurus.setPolyHierarchical(false);
		thesaurus.setPublisher("foo");
		thesaurus.setRelation("DE");
		thesaurus.setRights("foo");
		thesaurus.setSource("foo");
		thesaurus.setSubject("foo");
		thesaurus.setTitle("Mr");
		thesaurus.setType(new ThesaurusType());
		thesaurus.setVersions(new HashSet<ThesaurusVersionHistory>());
		customConceptAttributeType.setThesaurus(thesaurus);
		customConceptAttributeType.setValue("value");
		assertThat(customConceptAttributeType.getExportable(), is(false));
		assertThat(customConceptAttributeType.getCode(), is("DE"));
		assertThat(customConceptAttributeType.getIdentifier(), is(1));
		assertThat(customConceptAttributeType.getThesaurus(), sameInstance(thesaurus));
		assertThat(customConceptAttributeType.getValue(), is("value"));
	}
}
