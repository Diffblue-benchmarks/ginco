package fr.mcc.ginco.imports.ginco;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import fr.mcc.ginco.beans.Alignment;
import fr.mcc.ginco.beans.AlignmentConcept;
import fr.mcc.ginco.beans.AlignmentResource;
import fr.mcc.ginco.beans.AlignmentType;
import fr.mcc.ginco.beans.ExternalThesaurus;
import fr.mcc.ginco.dao.IAlignmentDAO;
import fr.mcc.ginco.dao.IExternalThesaurusDAO;
import fr.mcc.ginco.dao.IGenericDAO;
import fr.mcc.ginco.dao.IThesaurusConceptDAO;
import fr.mcc.ginco.exports.result.bean.JaxbList;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

/**
 * Unit tests for fr.mcc.ginco.imports.ginco.GincoAlignmentImporter
 *
 * @author Diffblue Cover
 */

public class GincoAlignmentImporterTest {

	@Mock(name = "alignmentConceptDAO")
	private IGenericDAO<AlignmentConcept, Integer> alignmentConceptDAO;

	@Mock(name = "alignmentDAO")
	private IAlignmentDAO alignmentDAO;

	@Mock(name = "alignmentResourceDAO")
	private IGenericDAO<AlignmentResource, Integer> alignmentResourceDAO;

	@Mock(name = "externalThesaurusDAO")
	private IExternalThesaurusDAO externalThesaurusDAO;

	@Mock(name = "thesaurusConceptDAO")
	private IThesaurusConceptDAO thesaurusConceptDAO;

	@InjectMocks
	private GincoAlignmentImporter service;

	@Before public void initMocks() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void storeAlignments1() {
		HashMap<String, JaxbList<Alignment>> alignments =
			 new HashMap<String, JaxbList<Alignment>>();
		alignments.put("", new JaxbList<Alignment>());
		assertTrue((service.storeAlignments(alignments)).isEmpty());
	}

	@Test
	public void storeAlignments2() {
		when(alignmentDAO.update(Mockito.<Alignment>any()))
			.thenReturn(new Alignment());
		HashMap<String, JaxbList<Alignment>> alignments =
			 new HashMap<String, JaxbList<Alignment>>();
		ArrayList<Alignment> list = new ArrayList<Alignment>();
		Alignment alignment2 = new Alignment();
		alignment2.setAlignmentType(new AlignmentType());
		list.add(alignment2);
		alignments.put("", new JaxbList<Alignment>(list));
		assertTrue((service.storeAlignments(alignments)).isEmpty());
	}

	@Test
	public void storeAlignmentsAlignmentsIsEmpty() {
		assertTrue((service.storeAlignments(new HashMap<String, JaxbList<Alignment>>())).isEmpty());
	}

	@Test
	public void storeExternalThesauruses1() {
		HashMap<String, JaxbList<Alignment>> alignments =
			 new HashMap<String, JaxbList<Alignment>>();
		alignments.put("", new JaxbList<Alignment>());
		service.storeExternalThesauruses(alignments, new HashSet<Alignment>());
	}

	@Test
	public void storeExternalThesauruses2() {
		when(externalThesaurusDAO.findBySourceExternalId(Mockito.<String>any()))
			.thenReturn(new ExternalThesaurus());
		HashMap<String, JaxbList<Alignment>> alignments =
			 new HashMap<String, JaxbList<Alignment>>();
		ArrayList<Alignment> list = new ArrayList<Alignment>();
		Alignment alignment = new Alignment();
		alignment.setExternalTargetThesaurus(new ExternalThesaurus());
		list.add(alignment);
		alignments.put("", new JaxbList<Alignment>(list));
		service.storeExternalThesauruses(alignments, new HashSet<Alignment>());
	}

	@Test
	public void storeExternalThesauruses3() {
		HashMap<String, JaxbList<Alignment>> alignments =
			 new HashMap<String, JaxbList<Alignment>>();
		ArrayList<Alignment> list = new ArrayList<Alignment>();
		list.add(new Alignment());
		alignments.put("", new JaxbList<Alignment>(list));
		service.storeExternalThesauruses(alignments, new HashSet<Alignment>());
	}

	@Test
	public void storeExternalThesaurusesAlignmentsIsEmpty() {
		service.storeExternalThesauruses(new HashMap<String, JaxbList<Alignment>>(), new HashSet<Alignment>());
	}
}