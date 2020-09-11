package fr.mcc.ginco.audit.utils;

import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.io.Serializable;

import org.hibernate.SessionFactoryObserver;
import org.hibernate.cfg.Configuration;
import org.hibernate.context.spi.CurrentTenantIdentifierResolver;
import org.hibernate.envers.configuration.AuditConfiguration;
import org.hibernate.event.spi.EventSource;
import org.hibernate.event.spi.PostUpdateEvent;
import org.hibernate.persister.entity.EntityPersister;
import org.hibernate.proxy.EntityNotFoundDelegate;
import org.junit.Test;
import org.xml.sax.EntityResolver;

/**
 * Unit tests for fr.mcc.ginco.audit.utils.UpdateEnversListerner
 *
 * @author Diffblue Cover
 */

public class UpdateEnversListernerTest {

	@Test
	public void factory() throws org.xml.sax.SAXException, java.io.IOException {
		Configuration cfg1 = new Configuration();
		CurrentTenantIdentifierResolver currentTenantIdentifierResolver1 =
			 mock(CurrentTenantIdentifierResolver.class);
		cfg1.setCurrentTenantIdentifierResolver(currentTenantIdentifierResolver1);
		EntityNotFoundDelegate entityNotFoundDelegate1 =
			 mock(EntityNotFoundDelegate.class);
		cfg1.setEntityNotFoundDelegate(entityNotFoundDelegate1);
		EntityResolver entityResolver1 = mock(EntityResolver.class);
		cfg1.setEntityResolver(entityResolver1);
		cfg1.setPrecedence("");
		SessionFactoryObserver sessionFactoryObserver1 =
			 mock(SessionFactoryObserver.class);
		cfg1.setSessionFactoryObserver(sessionFactoryObserver1);
		AuditConfiguration enversConfiguration = new AuditConfiguration(cfg1);
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
			.thenReturn("foo");
		EventSource source = mock(EventSource.class);
		new UpdateEnversListerner(new AuditConfiguration(new Configuration())).onPostUpdate(new PostUpdateEvent(new Object(), id, state, oldState, dirtyProperties, persister, source));
	}
}
