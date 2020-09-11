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
		ReducedThesaurusConcept reducedThesaurusConcept1 =
			 new ReducedThesaurusConcept();
		reducedThesaurusConcept1.setAssociates(new ArrayList<ReducedThesaurusConcept>());
		reducedThesaurusConcept1.setIdentifier("data");
		reducedThesaurusConcept1.setNotes(new ArrayList<Note>());
		reducedThesaurusConcept1.setParents(new ArrayList<ReducedThesaurusConcept>());
		reducedThesaurusConcept1.setStatus(ConceptStatusEnum.CANDIDATE);
		assertThat(reducedThesaurusConcept1.getAssociates(), empty());
		assertThat(reducedThesaurusConcept1.getIdentifier(), is("data"));
		assertThat(reducedThesaurusConcept1.getNotes(), empty());
		assertThat(reducedThesaurusConcept1.getParents(), empty());
		assertThat(reducedThesaurusConcept1.getStatus(), is(ConceptStatusEnum.CANDIDATE));
	}

	@Test
	void getReducedThesaurusConcept() {

		// arrange
		ThesaurusConcept concept = new ThesaurusConcept();
		concept.setIdentifier("data");
		concept.setStatus(1);

		// act
		ReducedThesaurusConcept result =
			 ReducedThesaurusConcept.getReducedThesaurusConcept(concept);

		// assert
		assertThat(result.getAssociates(), is(nullValue()));
		assertThat(result.getIdentifier(), is("data"));
		assertThat(result.getNotes(), is(nullValue()));
		assertThat(result.getParents(), is(nullValue()));
		assertThat(result.getStatus(), is(ConceptStatusEnum.VALIDATED));
	}
}
