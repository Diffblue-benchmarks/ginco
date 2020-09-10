package fr.mcc.ginco.services;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import fr.mcc.ginco.ark.IIDGeneratorService;
import fr.mcc.ginco.beans.Alignment;
import fr.mcc.ginco.beans.AlignmentConcept;
import fr.mcc.ginco.beans.AlignmentResource;
import fr.mcc.ginco.beans.ExternalThesaurus;
import fr.mcc.ginco.beans.ThesaurusConcept;
import fr.mcc.ginco.dao.IAlignmentDAO;
import fr.mcc.ginco.dao.IExternalThesaurusDAO;
import fr.mcc.ginco.dao.IGenericDAO;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

/**
 * Unit tests for fr.mcc.ginco.services.AlignmentServiceImpl
 *
 * @author Diffblue Cover
 */

public class AlignmentServiceImplTest {

	@Mock(name = "alignmentConceptDAO")
	private IGenericDAO<fr.mcc.ginco.beans.AlignmentConcept, Integer> alignmentConceptDAO;

	@Mock(name = "alignmentDAO")
	private IAlignmentDAO alignmentDAO;

	@Mock(name = "alignmentResourceDAO")
	private IGenericDAO<fr.mcc.ginco.beans.AlignmentResource, Integer> alignmentResourceDAO;

	@Mock(name = "externalThesaurusDAO")
	private IExternalThesaurusDAO externalThesaurusDAO;

	@Mock(name = "generatorService")
	private IIDGeneratorService generatorService;

	@InjectMocks
	private AlignmentServiceImpl service;

	@Before public void initMocks() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void deleteExternalThesauruses() {
		service.deleteExternalThesauruses();
	}

	@Test
	public void getAlignmentByIdReturnsNull() {
		assertNull(service.getAlignmentById("1234"));
	}

	@Test
	public void getAlignmentsBySourceConceptIdConceptIdentifierIsHelloReturnsEmpty() {
		when(alignmentDAO.findBySourceConceptId(Mockito.<String>any()))
			.thenReturn(new ArrayList<Alignment>());
		assertTrue((service.getAlignmentsBySourceConceptId("hello")).isEmpty());
	}

	@Test
	public void saveAlignments1() {
		when(alignmentDAO.findBySourceConceptId(Mockito.<String>any()))
			.thenReturn(new ArrayList<Alignment>());
		ThesaurusConcept concept = new ThesaurusConcept();
		assertSame(concept, service.saveAlignments(concept, new ArrayList<Alignment>()));
	}

	@Test
	public void saveAlignments2() {
		when(alignmentDAO.findBySourceConceptId(Mockito.<String>any()))
			.thenReturn(new ArrayList<Alignment>());
		ThesaurusConcept concept = new ThesaurusConcept();
		ArrayList<Alignment> alignments = new ArrayList<Alignment>();
		Alignment alignment2 = new Alignment();
		alignment2.setIdentifier("foo");
		alignments.add(alignment2);
		assertSame(concept, service.saveAlignments(concept, alignments));
	}

	@Test
	public void saveAlignments3() {
		List<Alignment> list = new ArrayList<Alignment>();
		list.add(new Alignment());
		when(alignmentDAO.findBySourceConceptId(Mockito.<String>any()))
			.thenReturn(list);
		ThesaurusConcept concept = new ThesaurusConcept();
		assertSame(concept, service.saveAlignments(concept, new ArrayList<Alignment>()));
	}

	@Test
	public void saveExternalThesauruses1() {
		ArrayList<Alignment> alignments = new ArrayList<Alignment>();
		Alignment alignment = new Alignment();
		alignment.setExternalTargetThesaurus(new ExternalThesaurus());
		alignments.add(alignment);
		service.saveExternalThesauruses(alignments);
	}

	@Test
	public void saveExternalThesauruses2() {
		ArrayList<Alignment> alignments = new ArrayList<Alignment>();
		alignments.add(new Alignment());
		service.saveExternalThesauruses(alignments);
	}

	@Test
	public void saveExternalThesaurusesAlignmentsIsEmpty() {
		service.saveExternalThesauruses(new ArrayList<Alignment>());
	}
}
