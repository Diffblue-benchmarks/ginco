package fr.mcc.ginco.audit.commands;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Unit tests for fr.mcc.ginco.audit.commands.CommandLine
 *
 * @author Diffblue Cover
 */

public class CommandLineTest {

	@Test
	public void factory() {
		CommandLine commandLine = new CommandLine();
		commandLine.setValue("value");
		assertEquals("value", commandLine.getValue());
	}
}
