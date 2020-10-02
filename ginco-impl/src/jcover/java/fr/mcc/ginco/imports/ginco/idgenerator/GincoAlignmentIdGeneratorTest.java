package fr.mcc.ginco.imports.ginco.idgenerator;

import static org.junit.Assert.assertSame;
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

	@Before public void initMocks() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void getIdsForAlignments1() {
		when(gincoIdMapParser.getNewId(Mockito.<String>any(), Mockito.<java.util.Map<String, String>>any()))
			.thenReturn("1234");
		HashMap<String, JaxbList<Alignment>> alignments =
			 new HashMap<String, JaxbList<Alignment>>();
		ArrayList<Alignment> list1 = new ArrayList<Alignment>();
		Alignment alignment1 = new Alignment();
		alignment1.setSourceConcept(new ThesaurusConcept());
		list1.add(alignment1);
		JaxbList<Alignment> x5 = new JaxbList<Alignment>(list1);
		alignments.put("HmacMD5", x5);
		assertSame(x5, service.getIdsForAlignments(alignments, new HashMap<String, String>()).get("1234"));
	}

	@Test
	public void getIdsForAlignments2() {
		when(gincoIdMapParser.getNewId(Mockito.<String>any(), Mockito.<java.util.Map<String, String>>any()))
			.thenReturn("1234");
		HashMap<String, JaxbList<Alignment>> alignments =
			 new HashMap<String, JaxbList<Alignment>>();
		JaxbList<Alignment> x5 = new JaxbList<Alignment>();
		alignments.put("HmacMD5", x5);
		assertSame(x5, service.getIdsForAlignments(alignments, new HashMap<String, String>()).get("1234"));
	}
}
