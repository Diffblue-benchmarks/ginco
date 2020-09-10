package fr.mcc.ginco.imports;

import static org.junit.Assert.assertTrue;

import com.hp.hpl.jena.ontology.ObjectProperty;
import com.hp.hpl.jena.rdf.model.Resource;

import fr.mcc.ginco.beans.AlignmentConcept;
import fr.mcc.ginco.beans.AlignmentResource;
import fr.mcc.ginco.beans.Thesaurus;
import fr.mcc.ginco.dao.IAlignmentDAO;
import fr.mcc.ginco.dao.IAssociativeRelationshipDAO;
import fr.mcc.ginco.dao.IConceptHierarchicalRelationshipDAO;
import fr.mcc.ginco.dao.IExternalThesaurusDAO;
import fr.mcc.ginco.dao.IGenericDAO;
import fr.mcc.ginco.dao.INoteDAO;
import fr.mcc.ginco.dao.IThesaurusConceptDAO;
import fr.mcc.ginco.dao.IThesaurusTermDAO;
import fr.mcc.ginco.services.IConceptHierarchicalRelationshipServiceUtil;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

/**
 * Unit tests for fr.mcc.ginco.imports.ConceptsBuilder
 *
 * @author Diffblue Cover
 */

public class ConceptsBuilderTest {

	@Mock(name = "alignmentConceptDAO")
	private IGenericDAO<fr.mcc.ginco.beans.AlignmentConcept, Integer> alignmentConceptDAO;

	@Mock(name = "alignmentDAO")
	private IAlignmentDAO alignmentDAO;

	@Mock(name = "alignmentResourceDAO")
	private IGenericDAO<fr.mcc.ginco.beans.AlignmentResource, Integer> alignmentResourceDAO;

	@Mock(name = "associativeRelationshipDAO")
	private IAssociativeRelationshipDAO associativeRelationshipDAO;

	@Mock(name = "conceptHierarchicalRelationshipDAO")
	private IConceptHierarchicalRelationshipDAO conceptHierarchicalRelationshipDAO;

	@Mock(name = "conceptHierarchicalRelationshipServiceUtil")
	private IConceptHierarchicalRelationshipServiceUtil conceptHierarchicalRelationshipServiceUtil;

	@Mock(name = "externalThesaurusDAO")
	private IExternalThesaurusDAO externalThesaurusDAO;

	@Mock(name = "noteDAO")
	private INoteDAO noteDAO;

	@Mock(name = "skosAlignmentsBuilder")
	private AlignmentsBuilder skosAlignmentsBuilder;

	@Mock(name = "skosConceptBuilder")
	private ConceptBuilder skosConceptBuilder;

	@Mock(name = "skosConceptNoteBuilder")
	private ConceptNoteBuilder skosConceptNoteBuilder;

	@Mock(name = "skosTermBuilder")
	private TermBuilder skosTermBuilder;

	@Mock(name = "thesaurusConceptDAO")
	private IThesaurusConceptDAO thesaurusConceptDAO;

	@Mock(name = "thesaurusTermDAO")
	private IThesaurusTermDAO thesaurusTermDAO;

	@InjectMocks
	private ConceptsBuilder service;

	@Before public void initMocks() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void buildConceptsAssociations() {
		service.buildConceptsAssociations(new Thesaurus(), new ArrayList<Resource>(), new ArrayList<ObjectProperty>(), new ArrayList<ObjectProperty>());
		Mockito.verify(thesaurusConceptDAO).flush();
	}

	@Test
	public void buildConceptsRootSkosConceptsIsEmpty() {
		service.buildConceptsRoot(new Thesaurus(), new ArrayList<Resource>());
	}

	@Test
	public void buildConceptsSkosConceptsIsEmptyReturnsEmpty() {
		assertTrue((service.buildConcepts(new Thesaurus(), new ArrayList<Resource>())).isEmpty());
	}
}
