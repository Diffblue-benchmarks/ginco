package fr.mcc.ginco.audit.utils;

import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.hibernate.envers.configuration.AuditConfiguration;
import org.hibernate.event.spi.PostInsertEvent;
import org.hibernate.persister.entity.EntityPersister;
import org.junit.Test;

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
	public void onPostInsert() throws org.hibernate.HibernateException, org.hibernate.MappingException {
		EntityPersister entityPersister = mock(EntityPersister.class);
		when(entityPersister.getEntityName())
			.thenReturn("foo");
		PostInsertEvent event = mock(PostInsertEvent.class);
		when(event.getPersister())
			.thenReturn(entityPersister);
		new InsertEnversListener(new AuditConfiguration(new org.hibernate.cfg.Configuration())).onPostInsert(event);
	}
}
