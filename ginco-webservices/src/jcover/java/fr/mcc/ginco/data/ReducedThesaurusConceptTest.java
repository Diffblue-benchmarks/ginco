package fr.mcc.ginco.data;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.empty;
import static org.hamcrest.Matchers.nullValue;
import static org.hamcrest.core.Is.is;

import fr.mcc.ginco.beans.Note;
import fr.mcc.ginco.beans.ThesaurusConcept;
import fr.mcc.ginco.enums.ConceptStatusEnum;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

/**
 * Unit tests for fr.mcc.ginco.data.ReducedThesaurusConcept
 *
 * @author Diffblue Cover
 */

class ReducedThesaurusConceptTest {

	@Test
	void factory() {
		ReducedThesaurusConcept reducedThesaurusConcept = new ReducedThesaurusConcept();
		reducedThesaurusConcept.setAssociates(new ArrayList<ReducedThesaurusConcept>());
		reducedThesaurusConcept.setIdentifier("something");
		reducedThesaurusConcept.setNotes(new ArrayList<Note>());
		reducedThesaurusConcept.setParents(new ArrayList<ReducedThesaurusConcept>());
		reducedThesaurusConcept.setStatus(ConceptStatusEnum.CANDIDATE);
		assertThat(reducedThesaurusConcept.getAssociates(), empty());
		assertThat(reducedThesaurusConcept.getIdentifier(), is("something"));
		assertThat(reducedThesaurusConcept.getNotes(), empty());
		assertThat(reducedThesaurusConcept.getParents(), empty());
		assertThat(reducedThesaurusConcept.getStatus(), is(ConceptStatusEnum.CANDIDATE));
	}

	@Test
	void getReducedThesaurusConcept() {

		// arrange
		ThesaurusConcept concept = new ThesaurusConcept();
		concept.setIdentifier("hello");
		concept.setStatus(1);

		// act
		ReducedThesaurusConcept result = ReducedThesaurusConcept.getReducedThesaurusConcept(concept);

		// assert
		assertThat(result.getAssociates(), is(nullValue()));
		assertThat(result.getIdentifier(), is("hello"));
		assertThat(result.getNotes(), is(nullValue()));
		assertThat(result.getParents(), is(nullValue()));
		assertThat(result.getStatus(), is(ConceptStatusEnum.VALIDATED));
	}
}
