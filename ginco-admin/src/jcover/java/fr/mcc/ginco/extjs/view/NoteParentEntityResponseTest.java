package fr.mcc.ginco.extjs.view;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

import org.junit.jupiter.api.Test;

/**
 * Unit tests for fr.mcc.ginco.extjs.view.NoteParentEntityResponse
 *
 * @author Diffblue Cover
 */

class NoteParentEntityResponseTest {

	@Test
	void factory() {
		NoteParentEntityResponse noteParentEntityResponse =
			 new NoteParentEntityResponse();
		noteParentEntityResponse.setIsConcept(false);
		noteParentEntityResponse.setParentEntityId("entity");
		assertThat(noteParentEntityResponse.getIsConcept(), is(false));
		assertThat(noteParentEntityResponse.getParentEntityId(), is("entity"));
	}
}
