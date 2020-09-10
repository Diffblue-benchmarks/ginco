package fr.mcc.ginco.beans;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsSame.sameInstance;

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
		Date created = new java.text.SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31");
		nodeLabel.setCreated(created);
		nodeLabel.setIdentifier(1);
		Language language = new Language();
		language.setId("1234");
		language.setPart1("foo");
		language.setPrincipalLanguage(false);
		language.setRefname("foo");
		language.setTopLanguage(false);
		nodeLabel.setLanguage(language);
		nodeLabel.setLexicalValue("value");
		Date modified = new java.text.SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31");
		nodeLabel.setModified(modified);
		ThesaurusArray thesaurusArray = new ThesaurusArray();
		thesaurusArray.setConcepts(new HashSet<ThesaurusArrayConcept>());
		thesaurusArray.setIdentifier("foo");
		thesaurusArray.setNotation("DE");
		thesaurusArray.setOrdered(false);
		thesaurusArray.setSuperOrdinateConcept(new ThesaurusConcept());
		thesaurusArray.setThesaurus(new Thesaurus());
		nodeLabel.setThesaurusArray(thesaurusArray);
		assertThat(nodeLabel.getCreated(), sameInstance(created));
		assertThat(nodeLabel.getIdentifier(), is(1));
		assertThat(nodeLabel.getLanguage(), sameInstance(language));
		assertThat(nodeLabel.getLexicalValue(), is("value"));
		assertThat(nodeLabel.getModified(), sameInstance(modified));
		assertThat(nodeLabel.getThesaurusArray(), sameInstance(thesaurusArray));
	}
}
