package fr.mcc.ginco.audit.tracking;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

import fr.mcc.ginco.beans.GincoRevEntity;
import fr.mcc.ginco.beans.GincoRevModifiedEntityType;

import java.io.Serializable;
import java.util.HashSet;

import org.hibernate.envers.RevisionType;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.context.ApplicationContext;

/**
 * Unit tests for fr.mcc.ginco.audit.tracking.GincoRevListener
 *
 * @author Diffblue Cover
 */

public class GincoRevListenerTest {

	@InjectMocks
	private GincoRevListener service;

	@Before public void initMocks() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void entityChangedEntityClassIsStringAndEntityNameIsEntityAndRevisionTypeIsAdd() {

		// arrange
		Serializable entityId = mock(Serializable.class);
		GincoRevEntity gincoRevEntity = new GincoRevEntity();
		gincoRevEntity.setModifiedEntityTypes(new HashSet<GincoRevModifiedEntityType>());
		gincoRevEntity.setThesaurusId("1234");
		gincoRevEntity.setUsername("root");
		gincoRevEntity.setId(1);
		gincoRevEntity.setTimestamp(1L);
		Object revisionEntity = gincoRevEntity;

		// act
		service.entityChanged(String.class, "entity", entityId, RevisionType.ADD, revisionEntity);

		// assert
		assertEquals(1, ((GincoRevEntity) revisionEntity).getModifiedEntityTypes().size());
	}

	@Test
	public void newRevision() {
		service.newRevision(new GincoRevEntity());
	}

	@Test
	public void setApplicationContext() throws IllegalStateException, org.springframework.beans.BeansException, org.springframework.beans.factory.NoSuchBeanDefinitionException, org.springframework.context.NoSuchMessageException, java.io.IOException {
		ApplicationContext applicationContext = mock(ApplicationContext.class);
		service.setApplicationContext(applicationContext);
	}
}
