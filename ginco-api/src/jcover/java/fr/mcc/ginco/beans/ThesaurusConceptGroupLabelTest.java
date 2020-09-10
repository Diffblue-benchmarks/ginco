package fr.mcc.ginco.beans;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsSame.sameInstance;

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
		ThesaurusConceptGroupLabel thesaurusConceptGroupLabel = new ThesaurusConceptGroupLabel();
		ThesaurusConceptGroup conceptGroup = new ThesaurusConceptGroup();
		conceptGroup.setConceptGroupType(new ThesaurusConceptGroupType());
		conceptGroup.setConcepts(new HashSet<ThesaurusConcept>());
		conceptGroup.setIdentifier("hello");
		conceptGroup.setIsDynamic(false);
		conceptGroup.setNotation("DE");
		conceptGroup.setParentConcept(new ThesaurusConcept());
		conceptGroup.setThesaurus(new Thesaurus());
		thesaurusConceptGroupLabel.setConceptGroup(conceptGroup);
		Date created = new java.text.SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31");
		thesaurusConceptGroupLabel.setCreated(created);
		thesaurusConceptGroupLabel.setIdentifier(1);
		Language language = new Language();
		language.setId("1234");
		language.setPart1("foo");
		language.setPrincipalLanguage(false);
		language.setRefname("foo");
		language.setTopLanguage(false);
		thesaurusConceptGroupLabel.setLanguage(language);
		thesaurusConceptGroupLabel.setLexicalValue("value");
		Date modified = new java.text.SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31");
		thesaurusConceptGroupLabel.setModified(modified);
		assertThat(thesaurusConceptGroupLabel.getConceptGroup(), sameInstance(conceptGroup));
		assertThat(thesaurusConceptGroupLabel.getCreated(), sameInstance(created));
		assertThat(thesaurusConceptGroupLabel.getIdentifier(), is(1));
		assertThat(thesaurusConceptGroupLabel.getLanguage(), sameInstance(language));
		assertThat(thesaurusConceptGroupLabel.getLexicalValue(), is("value"));
		assertThat(thesaurusConceptGroupLabel.getModified(), sameInstance(modified));
	}
}
