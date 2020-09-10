package fr.mcc.ginco.beans;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

import org.junit.jupiter.api.Test;

/**
 * Unit tests for fr.mcc.ginco.beans.ThesaurusStatistics
 *
 * @author Diffblue Cover
 */

class ThesaurusStatisticsTest {

	@Test
	void factory() {
		ThesaurusStatistics thesaurusStatistics = new ThesaurusStatistics("1234");
		thesaurusStatistics.setNbOfComplexConcepts(1);
		thesaurusStatistics.setNbOfConcepts(1);
		thesaurusStatistics.setNbOfConceptsAlignedToExtThes(1);
		thesaurusStatistics.setNbOfConceptsAlignedToIntThes(1);
		thesaurusStatistics.setNbOfConceptsAlignedToMyThes(1);
		thesaurusStatistics.setNbOfConceptsWoNotes(1);
		thesaurusStatistics.setNbOfNonPreferredTerms(1);
		thesaurusStatistics.setNbOfTerms(1);
		thesaurusStatistics.setNbOfTermsWoNotes(1);
		thesaurusStatistics.setNbOfThesaurusArrays(1);
		thesaurusStatistics.setNbOfThesaurusGroups(1);
		thesaurusStatistics.setThesaurusId("1234");
		assertThat((Integer) thesaurusStatistics.getNbOfComplexConcepts(), is(1));
		assertThat((Integer) thesaurusStatistics.getNbOfConcepts(), is(1));
		assertThat((Integer) thesaurusStatistics.getNbOfConceptsAlignedToExtThes(), is(1));
		assertThat((Integer) thesaurusStatistics.getNbOfConceptsAlignedToIntThes(), is(1));
		assertThat((Integer) thesaurusStatistics.getNbOfConceptsAlignedToMyThes(), is(1));
		assertThat((Integer) thesaurusStatistics.getNbOfConceptsWoNotes(), is(1));
		assertThat((Integer) thesaurusStatistics.getNbOfNonPreferredTerms(), is(1));
		assertThat((Integer) thesaurusStatistics.getNbOfTerms(), is(1));
		assertThat((Integer) thesaurusStatistics.getNbOfTermsWoNotes(), is(1));
		assertThat((Integer) thesaurusStatistics.getNbOfThesaurusArrays(), is(1));
		assertThat((Integer) thesaurusStatistics.getNbOfThesaurusGroups(), is(1));
		assertThat(thesaurusStatistics.getThesaurusId(), is("1234"));
	}
}
