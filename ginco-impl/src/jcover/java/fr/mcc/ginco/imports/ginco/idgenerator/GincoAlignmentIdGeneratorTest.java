package fr.mcc.ginco.imports.ginco.idgenerator;

import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.when;

import fr.mcc.ginco.beans.Alignment;
import fr.mcc.ginco.exports.result.bean.JaxbList;

import java.util.HashMap;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
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
	public void getIdsForAlignmentsIdMappingIsEmpty() {
		when(gincoIdMapParser.getNewId(Mockito.<String>any(), Mockito.<java.util.Map<String, String>>any()))
			.thenReturn("bar");
		HashMap<String, JaxbList<Alignment>> alignments =
			 new HashMap<String, JaxbList<Alignment>>();
		JaxbList<Alignment> x5 = new JaxbList<Alignment>();
		alignments.put("foo", x5);
		assertSame(x5, service.getIdsForAlignments(alignments, new HashMap<String, String>()).get("bar"));
	}
}
