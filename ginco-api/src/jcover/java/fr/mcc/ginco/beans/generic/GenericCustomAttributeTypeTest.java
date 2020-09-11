package fr.mcc.ginco.beans.generic;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsSame.sameInstance;
import static org.mockito.Mockito.mock;

import fr.mcc.ginco.beans.Thesaurus;

import org.junit.jupiter.api.Test;

/**
 * Unit tests for fr.mcc.ginco.beans.generic.GenericCustomAttributeType
 *
 * @author Diffblue Cover
 */

class GenericCustomAttributeTypeTest {

	@Test
	void factory() {
		GenericCustomAttributeType genericCustomAttributeType =
			 new GenericCustomAttributeType();
		genericCustomAttributeType.setCode("DE");
		genericCustomAttributeType.setIdentifier(1);
		Thesaurus thesaurus = mock(Thesaurus.class);
		genericCustomAttributeType.setThesaurus(thesaurus);
		genericCustomAttributeType.setValue("value");
		assertThat(genericCustomAttributeType.getCode(), is("DE"));
		assertThat(genericCustomAttributeType.getIdentifier(), is(1));
		assertThat(genericCustomAttributeType.getThesaurus(), sameInstance(thesaurus));
		assertThat(genericCustomAttributeType.getValue(), is("value"));
	}
}
