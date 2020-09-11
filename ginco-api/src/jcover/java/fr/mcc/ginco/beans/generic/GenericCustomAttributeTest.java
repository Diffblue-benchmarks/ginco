package fr.mcc.ginco.beans.generic;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsSame.sameInstance;

import fr.mcc.ginco.beans.CustomConceptAttributeType;
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
 * Unit tests for fr.mcc.ginco.beans.generic.GenericCustomAttribute
 *
 * @author Diffblue Cover
 */

class GenericCustomAttributeTest {

	@Test
	void factory() throws java.text.ParseException {
		GenericCustomAttribute<CustomConceptAttributeType, String> genericCustomAttribute =
			 new GenericCustomAttribute<CustomConceptAttributeType, String>();
		genericCustomAttribute.setEntity("entity");
		genericCustomAttribute.setIdentifier("data");
		Language language = new Language();
		language.setId("1234");
		language.setPart1("foo");
		language.setPrincipalLanguage(false);
		language.setRefname("root");
		language.setTopLanguage(false);
		genericCustomAttribute.setLanguage(language);
		genericCustomAttribute.setLexicalValue("value");
		CustomConceptAttributeType type1 = new CustomConceptAttributeType();
		type1.setExportable(false);
		type1.setCode("DE");
		type1.setIdentifier(1);
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
		ThesaurusType type2 = new ThesaurusType();
		type2.setIdentifier(1);
		type2.setLabel("label");
		thesaurus.setType(type2);
		thesaurus.setVersions(new HashSet<ThesaurusVersionHistory>());
		type1.setThesaurus(thesaurus);
		type1.setValue("value");
		genericCustomAttribute.setType(type1);
		assertThat(genericCustomAttribute.getEntity(), is("entity"));
		assertThat(genericCustomAttribute.getIdentifier(), is("data"));
		assertThat(genericCustomAttribute.getLanguage(), sameInstance(language));
		assertThat(genericCustomAttribute.getLexicalValue(), is("value"));
		assertThat(genericCustomAttribute.getType(), sameInstance(type1));
	}
}
