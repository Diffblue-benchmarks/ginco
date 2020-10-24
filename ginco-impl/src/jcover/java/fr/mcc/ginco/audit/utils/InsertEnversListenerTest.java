package fr.mcc.ginco.audit.utils;

import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.hibernate.cfg.Configuration;
import org.hibernate.envers.configuration.AuditConfiguration;
import org.hibernate.event.spi.EventSource;
import org.hibernate.event.spi.PostInsertEvent;
import org.hibernate.persister.entity.EntityPersister;
import org.junit.Test;
import org.mockito.Mockito;

/**
 * Unit tests for fr.mcc.ginco.audit.utils.InsertEnversListener
 *
 * @author Diffblue Cover
 */

public class InsertEnversListenerTest {

	@Test
	public void factory() {
		AuditConfiguration enversConfiguration = mock(AuditConfiguration.class);
		assertSame(enversConfiguration, new InsertEnversListener(enversConfiguration).getAuditConfiguration());
	}

	@Test
	public void onPostInsert() {
		Object[] state = new Object[] { new Object() };
		EntityPersister persister = mock(EntityPersister.class);
		when(persister.getEntityName())
			.thenReturn("entity");
		EventSource source = mock(EventSource.class);
		new InsertEnversListener(new AuditConfiguration(new Configuration())).onPostInsert(new PostInsertEvent("foo", "OX13QD", state, persister, source));
	}
}
