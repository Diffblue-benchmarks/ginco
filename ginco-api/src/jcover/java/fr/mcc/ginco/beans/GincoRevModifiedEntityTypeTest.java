package fr.mcc.ginco.beans;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

import org.junit.jupiter.api.Test;

/**
 * Unit tests for fr.mcc.ginco.beans.GincoRevModifiedEntityType
 *
 * @author Diffblue Cover
 */

class GincoRevModifiedEntityTypeTest {

	@Test
	void factory() {
		GincoRevModifiedEntityType gincoRevModifiedEntityType =
			 new GincoRevModifiedEntityType();
		gincoRevModifiedEntityType.setEntityClassName("entity");
		gincoRevModifiedEntityType.setId(1);
		gincoRevModifiedEntityType.setRevision(1);
		assertThat(gincoRevModifiedEntityType.getEntityClassName(), is("entity"));
		assertThat(gincoRevModifiedEntityType.getId(), is(1));
		assertThat(gincoRevModifiedEntityType.getRevision(), is(1));
	}
}
