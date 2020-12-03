package fr.mcc.ginco.audit.utils;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Unit tests for fr.mcc.ginco.audit.utils.AuditContext
 *
 * @author Diffblue Cover
 */

public class AuditContextTest {

	@Test
	public void enableAudit() {
		AuditContext.enableAudit();
	}

	@Test
	public void disableAudit() {
		AuditContext.disableAudit();
	}

	@Test
	public void getAuditStatusReturnsTrue() {
		assertTrue(AuditContext.getAuditStatus());
	}
}
