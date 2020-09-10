package fr.mcc.ginco.services;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.when;

import fr.mcc.ginco.ark.IIDGeneratorService;
import fr.mcc.ginco.beans.ThesaurusConcept;
import fr.mcc.ginco.dao.IAlignmentDAO;
import fr.mcc.ginco.dao.IAssociativeRelationshipDAO;
import fr.mcc.ginco.dao.IAssociativeRelationshipRoleDAO;
import fr.mcc.ginco.dao.IThesaurusArrayDAO;
import fr.mcc.ginco.dao.IThesaurusConceptDAO;
import fr.mcc.ginco.dao.IThesaurusConceptGroupDAO;
import fr.mcc.ginco.dao.IThesaurusDAO;
import fr.mcc.ginco.dao.IThesaurusTermDAO;
import fr.mcc.ginco.utils.ThesaurusTermUtils;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

/**
 * Unit tests for fr.mcc.ginco.services.ThesaurusConceptServiceImpl
 *
 * @author Diffblue Cover
 */

public class ThesaurusConceptServiceImplTest {

	@Mock(name = "alignmentDAO")
	private IAlignmentDAO alignmentDAO;

	@Mock(name = "alignmentService")
	private IAlignmentService alignmentService;

	@Mock(name = "associativeRelationshipDAO")
	private IAssociativeRelationshipDAO associativeRelationshipDAO;

	@Mock(name = "associativeRelationshipRoleDAO")
	private IAssociativeRelationshipRoleDAO associativeRelationshipRoleDAO;

	@Mock(name = "conceptHierarchicalRelationshipServiceUtil")
	private IConceptHierarchicalRelationshipServiceUtil conceptHierarchicalRelationshipServiceUtil;

	@Mock(name = "generatorService")
	private IIDGeneratorService generatorService;

	@Mock(name = "thesaurusArrayDAO")
	private IThesaurusArrayDAO thesaurusArrayDAO;

	@Mock(name = "thesaurusConceptDAO")
	private IThesaurusConceptDAO thesaurusConceptDAO;

	@Mock(name = "thesaurusConceptGroupDAO")
	private IThesaurusConceptGroupDAO thesaurusConceptGroupDAO;

	@Mock(name = "thesaurusDAO")
	private IThesaurusDAO thesaurusDAO;

	@Mock(name = "thesaurusTermDAO")
	private IThesaurusTermDAO thesaurusTermDAO;

	@Mock(name = "thesaurusTermUtils")
	private ThesaurusTermUtils thesaurusTermUtils;

	@InjectMocks
	private ThesaurusConceptServiceImpl service;

	@Before public void initMocks() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void calculateChildrenRoot() {
		service.calculateChildrenRoot("1234");
		Mockito.verify(conceptHierarchicalRelationshipServiceUtil).calculateChildrenRoots("1234", "1234");
	}

	@Test
	public void getAllConceptsReturnsEmpty() {
		assertTrue((service.getAllConcepts()).isEmpty());
	}

	@Test
	public void getAvailableConceptsOfGroupLikeIsHelloReturnsEmpty() {
		when(thesaurusConceptDAO.getPaginatedAvailableConceptsOfGroup(Mockito.<Integer>any(), Mockito.<Integer>any(), Mockito.<String>any(), Mockito.<String>any(), Mockito.<Boolean>any(), Mockito.<String>any()))
			.thenReturn(new ArrayList<ThesaurusConcept>());
		assertTrue((service.getAvailableConceptsOfGroup("1234", "1234", "hello")).isEmpty());
	}

	@Test
	public void getChildrenByConceptIdMaxResultsIsOneReturnsEmpty() {
		when(thesaurusConceptDAO.getChildrenConcepts(Mockito.<String>any(), anyInt(), Mockito.<String>any(), Mockito.<fr.mcc.ginco.enums.ConceptStatusEnum>any()))
			.thenReturn(new ArrayList<ThesaurusConcept>());
		assertTrue((service.getChildrenByConceptId("1234", 1, "1234")).isEmpty());
	}

	@Test
	public void getConceptLabelConceptIdIsHelloReturnsNull() {
		assertNull(service.getConceptLabel("hello"));
	}

	@Test
	public void getRecursiveParentsByConceptIdReturnsEmpty() {
		assertTrue((service.getRecursiveParentsByConceptId("1234")).isEmpty());
	}

	@Test
	public void getThesaurusConceptList() {
		assertTrue((service.getThesaurusConceptList()).isEmpty());
	}

	@Test
	public void getThesaurusConceptListIdsIsEmpty() {
		assertTrue((service.getThesaurusConceptList(new ArrayList<String>())).isEmpty());
	}
}
