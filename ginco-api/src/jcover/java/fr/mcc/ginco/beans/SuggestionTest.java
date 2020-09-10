package fr.mcc.ginco.beans;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsSame.sameInstance;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;

import org.junit.jupiter.api.Test;

/**
 * Unit tests for fr.mcc.ginco.beans.Suggestion
 *
 * @author Diffblue Cover
 */

class SuggestionTest {

	@Test
	void factory() throws java.text.ParseException {
		Suggestion suggestion = new Suggestion();
		ThesaurusConcept concept1 = new ThesaurusConcept();
		concept1.setAssociativeRelationshipLeft(new HashSet<AssociativeRelationship>());
		concept1.setAssociativeRelationshipRight(new HashSet<AssociativeRelationship>());
		concept1.setConceptArrays(new HashSet<ThesaurusArray>());
		concept1.setCreated(new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31"));
		concept1.setIdentifier("data");
		concept1.setModified(new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31"));
		concept1.setNotation("DE");
		concept1.setParentConcepts(new HashSet<ThesaurusConcept>());
		concept1.setRootConcepts(new HashSet<ThesaurusConcept>());
		concept1.setStatus(1);
		concept1.setThesaurus(new Thesaurus());
		concept1.setTopConcept(false);
		suggestion.setConcept(concept1);
		suggestion.setContent("hello");
		Date created2 = new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31");
		suggestion.setCreated(created2);
		suggestion.setCreator("+");
		suggestion.setIdentifier(1);
		suggestion.setRecipient("1234");
		ThesaurusTerm term = new ThesaurusTerm();
		term.setConcept(new ThesaurusConcept());
		term.setCreated(new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31"));
		term.setHidden(false);
		term.setIdentifier("data");
		term.setLanguage(new Language());
		term.setLexicalValue("value");
		term.setModified(new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31"));
		term.setPrefered(false);
		term.setRole(new ThesaurusTermRole());
		term.setSource("foo");
		term.setStatus(1);
		term.setThesaurus(new Thesaurus());
		suggestion.setTerm(term);
		assertThat(suggestion.getConcept(), sameInstance(concept1));
		assertThat(suggestion.getContent(), is("hello"));
		assertThat(suggestion.getCreated(), sameInstance(created2));
		assertThat(suggestion.getCreator(), is("+"));
		assertThat(suggestion.getIdentifier(), is(1));
		assertThat(suggestion.getRecipient(), is("1234"));
		assertThat(suggestion.getTerm(), sameInstance(term));
	}
}
