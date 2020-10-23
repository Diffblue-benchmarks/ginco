package fr.mcc.ginco.services;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.when;

import fr.mcc.ginco.ark.IIDGeneratorService;
import fr.mcc.ginco.beans.Alignment;
import fr.mcc.ginco.beans.AlignmentConcept;
import fr.mcc.ginco.beans.AlignmentResource;
import fr.mcc.ginco.beans.AlignmentType;
import fr.mcc.ginco.beans.ExternalThesaurus;
import fr.mcc.ginco.beans.Thesaurus;
import fr.mcc.ginco.beans.ThesaurusConcept;
import fr.mcc.ginco.dao.IAlignmentDAO;
import fr.mcc.ginco.dao.IExternalThesaurusDAO;
import fr.mcc.ginco.dao.IGenericDAO;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
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
	private IGenericDAO<AlignmentConcept, Integer> alignmentConceptDAO;

	@Mock(name = "alignmentDAO")
	private IAlignmentDAO alignmentDAO;

	@Mock(name = "alignmentResourceDAO")
	private IGenericDAO<AlignmentResource, Integer> alignmentResourceDAO;

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
	public void getAlignmentByIdIdentifierIsData() throws java.text.ParseException {

		// arrange
		Alignment alignment = new Alignment();
		AlignmentType alignmentType = new AlignmentType();
		alignment.setAlignmentType(alignmentType);
		alignment.setAuthor("Ernest Hemingway");
		Date created1 = new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31");
		alignment.setCreated(created1);
		ExternalThesaurus externalTargetThesaurus = new ExternalThesaurus();
		alignment.setExternalTargetThesaurus(externalTargetThesaurus);
		alignment.setIdentifier("data");
		Thesaurus internalTargetThesaurus = new Thesaurus();
		alignment.setInternalTargetThesaurus(internalTargetThesaurus);
		Date modified1 = new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31");
		alignment.setModified(modified1);
		ThesaurusConcept sourceConcept = new ThesaurusConcept();
		alignment.setSourceConcept(sourceConcept);
		alignment.setTargetConcepts(new HashSet<AlignmentConcept>());
		alignment.setTargetResources(new HashSet<AlignmentResource>());
		when(alignmentDAO.getById(Mockito.<String>any()))
			.thenReturn(alignment);

		// act
		Alignment result = service.getAlignmentById("data");

		// assert
		assertSame(alignmentType, result.getAlignmentType());
		assertEquals("Ernest Hemingway", result.getAuthor());
		assertSame(created1, result.getCreated());
		assertSame(externalTargetThesaurus, result.getExternalTargetThesaurus());
		assertEquals("data", result.getIdentifier());
		assertSame(internalTargetThesaurus, result.getInternalTargetThesaurus());
		assertSame(modified1, result.getModified());
		assertSame(sourceConcept, result.getSourceConcept());
		assertNotNull(result.getTargetConcepts());
		assertNotNull(result.getTargetResources());
		assertFalse(result.isAndRelation());
	}

	@Test
	public void getAlignmentsBySourceConceptIdConceptIdentifierIsData() {

		// arrange
		List<Alignment> list = new ArrayList<Alignment>();
		Alignment alignment = new Alignment();
		list.add(alignment);
		when(alignmentDAO.findBySourceConceptId(Mockito.<String>any()))
			.thenReturn(list);

		// act
		List<Alignment> result = service.getAlignmentsBySourceConceptId("data");

		// assert
		assertEquals(1, result.size());
		assertSame(alignment, result.get(0));
	}

	@Test
	public void saveAlignments() {
		List<Alignment> list = new ArrayList<Alignment>();
		Alignment alignment2 = new Alignment();
		alignment2.setIdentifier("data");
		list.add(alignment2);
		when(alignmentDAO.findBySourceConceptId(Mockito.<String>any()))
			.thenReturn(list);
		when(alignmentDAO.update(Mockito.<Alignment>any()))
			.thenReturn(new Alignment());
		ThesaurusConcept concept = new ThesaurusConcept();
		ArrayList<Alignment> alignments = new ArrayList<Alignment>();
		Alignment alignment3 = new Alignment();
		alignment3.setIdentifier("data");
		alignments.add(alignment3);
		assertSame(concept, service.saveAlignments(concept, alignments));
		Mockito.verify(alignmentDAO).flush();
	}

	@Test
	public void saveExternalThesauruses1() {
		ArrayList<Alignment> alignments = new ArrayList<Alignment>();
		alignments.add(new Alignment());
		service.saveExternalThesauruses(alignments);
	}

	@Test
	public void saveExternalThesauruses2() {
		when(externalThesaurusDAO.update(Mockito.<ExternalThesaurus>any()))
			.thenReturn(new ExternalThesaurus());
		ArrayList<Alignment> alignments = new ArrayList<Alignment>();
		Alignment alignment = new Alignment();
		alignment.setExternalTargetThesaurus(new ExternalThesaurus());
		alignments.add(alignment);
		service.saveExternalThesauruses(alignments);
	}

	@Test
	public void saveExternalThesaurusesAlignmentsIsEmpty() {
		service.saveExternalThesauruses(new ArrayList<Alignment>());
	}

	@Test
	public void deleteExternalThesauruses() {
		List<ExternalThesaurus> list1 = new ArrayList<ExternalThesaurus>();
		list1.add(new ExternalThesaurus());
		when(externalThesaurusDAO.findAll())
			.thenReturn(list1);
		List<Alignment> list2 = new ArrayList<Alignment>();
		list2.add(new Alignment());
		when(alignmentDAO.findByExternalThesaurus(Mockito.<Integer>any()))
			.thenReturn(list2);
		service.deleteExternalThesauruses();
	}
}
