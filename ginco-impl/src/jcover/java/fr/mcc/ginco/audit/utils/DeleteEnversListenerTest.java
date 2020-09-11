package fr.mcc.ginco.audit.utils;

import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.mock;

import org.hibernate.envers.configuration.AuditConfiguration;
import org.hibernate.event.spi.PostDeleteEvent;
import org.junit.Test;

/**
 * Unit tests for fr.mcc.ginco.audit.utils.DeleteEnversListener
 *
 * @author Diffblue Cover
 */

public class DeleteEnversListenerTest {

	@Test
	public void factory() {
		AuditConfiguration enversConfiguration = mock(AuditConfiguration.class);
		assertSame(enversConfiguration, new DeleteEnversListener(enversConfiguration).getAuditConfiguration());
	}

	@Test
	public void onPostDelete() {
		AuditConfiguration enversConfiguration = mock(AuditConfiguration.class);
		PostDeleteEvent event = mock(PostDeleteEvent.class);
		new DeleteEnversListener(enversConfiguration).onPostDelete(event);
	}
}
