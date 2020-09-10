package fr.mcc.ginco.security;

import org.junit.jupiter.api.Test;
import org.owasp.csrfguard.log.LogLevel;

/**
 * Unit tests for fr.mcc.ginco.security.CSRFGuardLogger
 *
 * @author Diffblue Cover
 */

class CSRFGuardLoggerTest {

	@Test
	void log2() {
		new CSRFGuardLogger().log("545321456");
	}

	@Test
	void logLevelIsTrace2() {
		new CSRFGuardLogger().log(LogLevel.Trace, "545321456");
	}

	@Test
	void log1() {
		Exception exception = new Exception();
		exception.setStackTrace(new StackTraceElement[] { });
		new CSRFGuardLogger().log(exception);
	}

	@Test
	void logLevelIsTrace1() {
		Exception exception = new Exception();
		exception.setStackTrace(new StackTraceElement[] { });
		new CSRFGuardLogger().log(LogLevel.Trace, exception);
	}
}
