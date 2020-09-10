package fr.mcc.ginco.beans;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsSame.sameInstance;

import java.text.SimpleDateFormat;
import java.util.HashSet;

import org.junit.jupiter.api.Test;

/**
 * Unit tests for fr.mcc.ginco.beans.ThesaurusArrayConcept
 *
 * @author Diffblue Cover
 */

class ThesaurusArrayConceptTest {

	@Test
	void factory() throws java.text.ParseException {
		ThesaurusArrayConcept thesaurusArrayConcept = new ThesaurusArrayConcept();
		thesaurusArrayConcept.setArrayOrder(1);
		ThesaurusConcept concept = new ThesaurusConcept();
		concept.setAssociativeRelationshipLeft(new HashSet<AssociativeRelationship>());
		concept.setAssociativeRelationshipRight(new HashSet<AssociativeRelationship>());
		concept.setConceptArrays(new HashSet<ThesaurusArray>());
		concept.setCreated(new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31"));
		concept.setIdentifier("hello");
		concept.setModified(new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31"));
		concept.setNotation("DE");
		concept.setParentConcepts(new HashSet<ThesaurusConcept>());
		concept.setRootConcepts(new HashSet<ThesaurusConcept>());
		concept.setStatus(1);
		concept.setThesaurus(new Thesaurus());
		concept.setTopConcept(false);
		thesaurusArrayConcept.setConcepts(concept);
		ThesaurusArrayConcept.Id identifier2 = new ThesaurusArrayConcept.Id();
		identifier2.setConceptId("1234");
		identifier2.setThesaurusArrayId("1234");
		thesaurusArrayConcept.setIdentifier(identifier2);
		assertThat(thesaurusArrayConcept.getArrayOrder(), is(1));
		assertThat(thesaurusArrayConcept.getConcepts(), sameInstance(concept));
		assertThat(thesaurusArrayConcept.getIdentifier(), sameInstance(identifier2));
	}
}
