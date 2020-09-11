package fr.mcc.ginco.audit.utils;

import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.mock;

import org.hibernate.SessionFactoryObserver;
import org.hibernate.cfg.Configuration;
import org.hibernate.context.spi.CurrentTenantIdentifierResolver;
import org.hibernate.envers.configuration.AuditConfiguration;
import org.hibernate.proxy.EntityNotFoundDelegate;
import org.junit.Test;
import org.mockito.Mockito;
import org.xml.sax.EntityResolver;

/**
 * Unit tests for fr.mcc.ginco.audit.utils.CollectionRecreateEnversListener
 *
 * @author Diffblue Cover
 */

public class CollectionRecreateEnversListenerTest {

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
		assertSame(enversConfiguration, new CollectionRecreateEnversListener(enversConfiguration).getAuditConfiguration());
	}
}
