package fr.mcc.ginco.audit.utils;

import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.hibernate.cfg.Configuration;
import org.hibernate.envers.configuration.AuditConfiguration;
import org.hibernate.event.spi.EventSource;
import org.hibernate.event.spi.PostUpdateEvent;
import org.hibernate.persister.entity.EntityPersister;
import org.junit.Test;
import org.mockito.Mockito;

/**
 * Unit tests for fr.mcc.ginco.audit.utils.UpdateEnversListerner
 *
 * @author Diffblue Cover
 */

public class UpdateEnversListernerTest {

	@Test
	public void factory() {
		AuditConfiguration enversConfiguration = mock(AuditConfiguration.class);
		assertSame(enversConfiguration, new UpdateEnversListerner(enversConfiguration).getAuditConfiguration());
	}

	@Test
	public void onPostUpdate() {
		Object[] state = new Object[] { new Object() };
		Object[] oldState = new Object[] { new Object() };
		int[] dirtyProperties = new int[] { 1 };
		EntityPersister persister = mock(EntityPersister.class);
		when(persister.getEntityName())
			.thenReturn("entity");
		EventSource source = mock(EventSource.class);
		new UpdateEnversListerner(new AuditConfiguration(new Configuration())).onPostUpdate(new PostUpdateEvent(new Object(), "OX13QD", state, oldState, dirtyProperties, persister, source));
	}
}
