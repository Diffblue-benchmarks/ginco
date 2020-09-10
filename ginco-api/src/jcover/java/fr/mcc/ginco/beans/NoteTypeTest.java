package fr.mcc.ginco.beans;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

import org.junit.jupiter.api.Test;

/**
 * Unit tests for fr.mcc.ginco.beans.NoteType
 *
 * @author Diffblue Cover
 */

class NoteTypeTest {

	@Test
	void factory() {
		NoteType noteType = new NoteType();
		noteType.setCode("DE");
		noteType.setIsConcept(true);
		noteType.setIsTerm(false);
		noteType.setLabel("label");
		assertThat(noteType.getCode(), is("DE"));
		assertThat(noteType.getLabel(), is("label"));
		assertThat(noteType.isIsConcept(), is(true));
		assertThat(noteType.isIsTerm(), is(false));
	}
}
