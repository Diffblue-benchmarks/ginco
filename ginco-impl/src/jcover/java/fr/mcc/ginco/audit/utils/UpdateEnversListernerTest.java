package fr.mcc.ginco.audit.utils;

import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.io.Serializable;

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
	public void onPostUpdate() throws org.hibernate.HibernateException, org.hibernate.MappingException, org.hibernate.UnknownProfileException {
		Serializable id = mock(Serializable.class);
		Object[] state = new Object[] { new Object() };
		Object[] oldState = new Object[] { new Object() };
		int[] dirtyProperties = new int[] { 1 };
		EntityPersister persister = mock(EntityPersister.class);
		when(persister.getEntityName())
			.thenReturn("entity");
		EventSource source = mock(EventSource.class);
		new UpdateEnversListerner(new AuditConfiguration(new org.hibernate.cfg.Configuration())).onPostUpdate(new PostUpdateEvent(new Object(), id, state, oldState, dirtyProperties, persister, source));
	}
}
