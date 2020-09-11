package fr.mcc.ginco.audit.utils;

import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.io.Serializable;

import org.hibernate.envers.configuration.AuditConfiguration;
import org.hibernate.event.spi.EventSource;
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
	public void onPostInsert() throws org.hibernate.HibernateException, org.hibernate.MappingException, org.hibernate.UnknownProfileException {
		Serializable id = mock(Serializable.class);
		Object[] state = new Object[] { new Object() };
		EntityPersister persister = mock(EntityPersister.class);
		when(persister.getEntityName())
			.thenReturn("foo");
		EventSource source = mock(EventSource.class);
		new InsertEnversListener(new AuditConfiguration(new org.hibernate.cfg.Configuration())).onPostInsert(new PostInsertEvent(new Object(), id, state, persister, source));
	}
}
