package fr.mcc.ginco.imports.ginco.idgenerator;

import static org.junit.Assert.assertTrue;

import fr.mcc.ginco.beans.Alignment;
import fr.mcc.ginco.exports.result.bean.JaxbList;

import java.util.HashMap;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

/**
 * Unit tests for fr.mcc.ginco.imports.ginco.idgenerator.GincoAlignmentIdGenerator
 *
 * @author Diffblue Cover
 */

public class GincoAlignmentIdGeneratorTest {

	@Mock(name = "gincoIdMapParser")
	private GincoIdMapParser gincoIdMapParser;

	@InjectMocks
	private GincoAlignmentIdGenerator service;

	@Before public void initMocks() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void getIdsForAlignmentsReturnsEmpty() {
		assertTrue(service.getIdsForAlignments(new HashMap<String, JaxbList<Alignment>>(), new HashMap<String, String>()).isEmpty());
	}
}
