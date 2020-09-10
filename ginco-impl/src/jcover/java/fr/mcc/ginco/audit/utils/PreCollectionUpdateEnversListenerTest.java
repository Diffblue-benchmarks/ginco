package fr.mcc.ginco.audit.utils;

import static org.junit.Assert.assertSame;

import org.hibernate.cfg.Configuration;
import org.hibernate.envers.configuration.AuditConfiguration;
import org.junit.Test;

/**
 * Unit tests for fr.mcc.ginco.audit.utils.PreCollectionUpdateEnversListener
 *
 * @author Diffblue Cover
 */

public class PreCollectionUpdateEnversListenerTest {

	@Test
	public void factory() {
		AuditConfiguration enversConfiguration = AuditConfiguration.getFor(new Configuration());
		assertSame(enversConfiguration, new PreCollectionUpdateEnversListener(enversConfiguration).getAuditConfiguration());
	}
}
