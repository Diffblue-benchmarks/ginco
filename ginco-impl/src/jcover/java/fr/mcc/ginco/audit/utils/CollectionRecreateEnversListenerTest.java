package fr.mcc.ginco.audit.utils;

import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.mock;

import org.hibernate.envers.configuration.AuditConfiguration;
import org.junit.Test;
import org.mockito.Mockito;

/**
 * Unit tests for fr.mcc.ginco.audit.utils.CollectionRecreateEnversListener
 *
 * @author Diffblue Cover
 */

public class CollectionRecreateEnversListenerTest {

	@Test
	public void factory() {
		AuditConfiguration enversConfiguration = mock(AuditConfiguration.class);
		assertSame(enversConfiguration, new CollectionRecreateEnversListener(enversConfiguration).getAuditConfiguration());
	}
}
