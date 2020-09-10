package fr.mcc.ginco.beans;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

import org.junit.jupiter.api.Test;

/**
 * Unit tests for fr.mcc.ginco.beans.AlignmentType
 *
 * @author Diffblue Cover
 */

class AlignmentTypeTest {

	@Test
	void factory() {
		AlignmentType alignmentType = new AlignmentType();
		alignmentType.setDefaultType(true);
		alignmentType.setIdentifier(1);
		alignmentType.setIsoCode("DE");
		alignmentType.setLabel("label");
		alignmentType.setMultiConcept(false);
		alignmentType.setResource(false);
		assertThat(alignmentType.getIdentifier(), is(1));
		assertThat(alignmentType.getIsoCode(), is("DE"));
		assertThat(alignmentType.getLabel(), is("label"));
		assertThat(alignmentType.isDefaultType(), is(true));
		assertThat(alignmentType.isMultiConcept(), is(false));
		assertThat(alignmentType.isResource(), is(false));
	}
}
