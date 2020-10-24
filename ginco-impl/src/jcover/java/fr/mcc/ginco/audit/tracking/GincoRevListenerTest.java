package fr.mcc.ginco.audit.tracking;

import static org.mockito.Mockito.mock;

import fr.mcc.ginco.beans.GincoRevEntity;

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
	public void entityChangedEntityClassIsStringAndEntityIdIsEntityAndEntityNameIsBarAndRevisionTypeIsAdd() {
		service.entityChanged(String.class, "bar", "entity", RevisionType.ADD, new GincoRevEntity());
	}

	@Test
	public void newRevision() {
		service.newRevision(new GincoRevEntity());
	}

	@Test
	public void setApplicationContext() throws org.springframework.beans.BeansException {
		ApplicationContext applicationContext = mock(ApplicationContext.class);
		service.setApplicationContext(applicationContext);
	}
}
