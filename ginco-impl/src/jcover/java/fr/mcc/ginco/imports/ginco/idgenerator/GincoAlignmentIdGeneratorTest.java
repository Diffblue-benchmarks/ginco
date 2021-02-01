package fr.mcc.ginco.imports.ginco.idgenerator;

import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import fr.mcc.ginco.beans.Alignment;
import fr.mcc.ginco.beans.ThesaurusConcept;
import fr.mcc.ginco.exports.result.bean.JaxbList;

import java.util.ArrayList;
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

	@Before
	public void initMocks() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void getIdsForAlignments() {
		when(gincoIdMapParser.getNewId(Mockito.<String>any(), Mockito.<java.util.Map<String, String>>any()))
			.thenReturn("1234");
		HashMap<String, JaxbList<Alignment>> alignments =
			 new HashMap<String, JaxbList<Alignment>>();
		JaxbList<Alignment> jaxbList = new JaxbList<Alignment>();
		alignments.put("", jaxbList);
		assertSame(jaxbList, service.getIdsForAlignments(alignments, new HashMap<String, String>()).get("1234"));
	}

	@Test
	public void getIdsForAlignmentsAlignmentsIsEmptyReturnsEmpty() {
		assertTrue(service.getIdsForAlignments(new HashMap<String, JaxbList<Alignment>>(), new HashMap<String, String>()).isEmpty());
	}

	@Test
	public void getIdsForAlignmentsIdMappingIsFoo() {
		when(gincoIdMapParser.getNewId(Mockito.<String>any(), Mockito.<java.util.Map<String, String>>any()))
			.thenReturn("1234");
		HashMap<String, JaxbList<Alignment>> alignments =
			 new HashMap<String, JaxbList<Alignment>>();
		ArrayList<Alignment> list = new ArrayList<Alignment>();
		Alignment alignment = new Alignment();
		alignment.setSourceConcept(new ThesaurusConcept());
		list.add(alignment);
		JaxbList<Alignment> jaxbList = new JaxbList<Alignment>(list);
		alignments.put("", jaxbList);
		HashMap<String, String> idMapping = new HashMap<String, String>();
		idMapping.put("", "foo");
		assertSame(jaxbList, service.getIdsForAlignments(alignments, idMapping).get("1234"));
	}
}
