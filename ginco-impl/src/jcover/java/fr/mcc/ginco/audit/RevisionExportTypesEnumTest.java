package fr.mcc.ginco.audit;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Unit tests for fr.mcc.ginco.audit.RevisionExportTypesEnum
 *
 * @author Diffblue Cover
 */

public class RevisionExportTypesEnumTest {

	@Test
	public void valuesReturnsCsvCommands() {
		RevisionExportTypesEnum[] result = RevisionExportTypesEnum.values();
		assertTrue(RevisionExportTypesEnum.CSV == result[0]);
		assertTrue(RevisionExportTypesEnum.COMMANDS == result[1]);
	}
}
