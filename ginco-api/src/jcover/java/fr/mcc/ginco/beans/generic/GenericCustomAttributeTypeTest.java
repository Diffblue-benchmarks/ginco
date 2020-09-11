package fr.mcc.ginco.beans.generic;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsSame.sameInstance;

import fr.mcc.ginco.beans.Language;
import fr.mcc.ginco.beans.Thesaurus;
import fr.mcc.ginco.beans.ThesaurusFormat;
import fr.mcc.ginco.beans.ThesaurusOrganization;
import fr.mcc.ginco.beans.ThesaurusType;
import fr.mcc.ginco.beans.ThesaurusVersionHistory;

import java.text.SimpleDateFormat;
import java.util.HashSet;

import org.junit.jupiter.api.Test;

/**
 * Unit tests for fr.mcc.ginco.beans.generic.GenericCustomAttributeType
 *
 * @author Diffblue Cover
 */

class GenericCustomAttributeTypeTest {

	@Test
	void factory() throws java.text.ParseException {
		GenericCustomAttributeType genericCustomAttributeType =
			 new GenericCustomAttributeType();
		genericCustomAttributeType.setCode("DE");
		genericCustomAttributeType.setIdentifier(1);
		Thesaurus thesaurus = new Thesaurus();
		thesaurus.setArchived(true);
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
		genericCustomAttributeType.setThesaurus(thesaurus);
		genericCustomAttributeType.setValue("value");
		assertThat(genericCustomAttributeType.getCode(), is("DE"));
		assertThat(genericCustomAttributeType.getIdentifier(), is(1));
		assertThat(genericCustomAttributeType.getThesaurus(), sameInstance(thesaurus));
		assertThat(genericCustomAttributeType.getValue(), is("value"));
	}
}
