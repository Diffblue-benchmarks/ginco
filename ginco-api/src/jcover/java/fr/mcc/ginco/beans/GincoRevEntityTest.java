package fr.mcc.ginco.beans;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.empty;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.hamcrest.core.Is.is;

import java.util.HashSet;

import org.junit.jupiter.api.Test;

/**
 * Unit tests for fr.mcc.ginco.beans.GincoRevEntity
 *
 * @author Diffblue Cover
 */

class GincoRevEntityTest {

	@Test
	void factory() {
		GincoRevEntity gincoRevEntity = new GincoRevEntity();
		gincoRevEntity.setModifiedEntityTypes(new HashSet<GincoRevModifiedEntityType>());
		gincoRevEntity.setThesaurusId("1234");
		gincoRevEntity.setUsername("root");
		gincoRevEntity.setId(1);
		gincoRevEntity.setTimestamp(1L);
		assertThat(gincoRevEntity.getModifiedEntityTypes(), empty());
		assertThat(gincoRevEntity.getThesaurusId(), is("1234"));
		assertThat(gincoRevEntity.getUsername(), is("root"));
		assertThat(gincoRevEntity.getTimestamp(), is(1L));
	}

	@Test
	void addModifiedEntityType() {

		// arrange
		GincoRevEntity gincoRevEntity = new GincoRevEntity();
		GincoRevModifiedEntityType revEntity = new GincoRevModifiedEntityType();

		// act
		gincoRevEntity.addModifiedEntityType(revEntity);

		// assert
		assertThat(gincoRevEntity.getModifiedEntityTypes(), hasSize(1));
	}
}
