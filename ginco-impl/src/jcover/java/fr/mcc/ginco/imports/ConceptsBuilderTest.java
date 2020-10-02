package fr.mcc.ginco.imports;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.hp.hpl.jena.ontology.ObjectProperty;
import com.hp.hpl.jena.rdf.model.Resource;

import fr.mcc.ginco.beans.Alignment;
import fr.mcc.ginco.beans.AlignmentConcept;
import fr.mcc.ginco.beans.AlignmentResource;
import fr.mcc.ginco.beans.AssociativeRelationship;
import fr.mcc.ginco.beans.ConceptHierarchicalRelationship;
import fr.mcc.ginco.beans.ExternalThesaurus;
import fr.mcc.ginco.beans.ExternalThesaurusType;
import fr.mcc.ginco.beans.Language;
import fr.mcc.ginco.beans.Note;
import fr.mcc.ginco.beans.Thesaurus;
import fr.mcc.ginco.beans.ThesaurusConcept;
import fr.mcc.ginco.beans.ThesaurusTerm;
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
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

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
	public void buildConceptsRoot() {
		when(thesaurusConceptDAO.update(Mockito.<ThesaurusConcept>any()))
			.thenReturn(new ThesaurusConcept());
		when(skosConceptBuilder.buildConceptRoot(Mockito.<Resource>any(), Mockito.<Thesaurus>any()))
			.thenReturn(new ThesaurusConcept());
		ArrayList<Resource> skosConcepts = new ArrayList<Resource>();
		Resource resource = mock(Resource.class);
		skosConcepts.add(resource);
		service.buildConceptsRoot(new Thesaurus(), skosConcepts);
	}

	@Test
	public void buildConceptsAssociations1() {
		Thesaurus thesaurus = mock(Thesaurus.class);
		service.buildConceptsAssociations(thesaurus, new ArrayList<Resource>(), new ArrayList<ObjectProperty>(), new ArrayList<ObjectProperty>());
		Mockito.verify(thesaurusConceptDAO).flush();
	}

	@Test
	public void buildConceptsAssociations2() {

		// arrange
		when(skosConceptBuilder.buildConceptAssociativerelationship(Mockito.<Resource>any(), Mockito.<Thesaurus>any(), Mockito.<List<ObjectProperty>>any()))
			.thenReturn(new HashSet<AssociativeRelationship>());
		when(skosConceptBuilder.buildConceptHierarchicalRelationships(Mockito.<Resource>any(), Mockito.<Thesaurus>any(), Mockito.<List<ObjectProperty>>any()))
			.thenReturn(new HashMap<ThesaurusConcept, List<ConceptHierarchicalRelationship>>());
		Thesaurus thesaurus = mock(Thesaurus.class);
		ArrayList<Resource> skosConcepts = new ArrayList<Resource>();
		Resource resource = mock(Resource.class);
		skosConcepts.add(resource);

		// act
		service.buildConceptsAssociations(thesaurus, skosConcepts, new ArrayList<ObjectProperty>(), new ArrayList<ObjectProperty>());

		// assert
		Mockito.verify(thesaurusConceptDAO).flush();
	}

	@Test
	public void buildConcepts() {
		when(thesaurusTermDAO.update(Mockito.<ThesaurusTerm>any(), anyBoolean()))
			.thenReturn(new ThesaurusTerm());
		when(thesaurusConceptDAO.update(Mockito.<ThesaurusConcept>any()))
			.thenReturn(new ThesaurusConcept());
		List<ThesaurusTerm> list1 = new ArrayList<ThesaurusTerm>();
		ThesaurusTerm thesaurusTerm2 = new ThesaurusTerm();
		thesaurusTerm2.setLanguage(new Language());
		thesaurusTerm2.setPrefered(false);
		list1.add(thesaurusTerm2);
		when(skosTermBuilder.buildTerms(Mockito.<Resource>any(), Mockito.<Thesaurus>any(), Mockito.<ThesaurusConcept>any()))
			.thenReturn(list1);
		List<Note> list2 = new ArrayList<Note>();
		list2.add(new Note());
		when(skosConceptNoteBuilder.buildConceptNotes(Mockito.<Resource>any(), Mockito.<ThesaurusConcept>any(), Mockito.<ThesaurusTerm>any(), Mockito.<Thesaurus>any()))
			.thenReturn(list2);
		when(skosConceptBuilder.buildConcept(Mockito.<Resource>any(), Mockito.<Thesaurus>any()))
			.thenReturn(new ThesaurusConcept());
		List<Alignment> list3 = new ArrayList<Alignment>();
		Alignment alignment1 = new Alignment();
		alignment1.setExternalTargetThesaurus(new ExternalThesaurus());
		list3.add(alignment1);
		when(skosAlignmentsBuilder.buildAlignments(Mockito.<Resource>any(), Mockito.<ThesaurusConcept>any()))
			.thenReturn(list3);
		when(noteDAO.update(Mockito.<Note>any()))
			.thenReturn(new Note());
		List<ExternalThesaurus> list4 = new ArrayList<ExternalThesaurus>();
		ExternalThesaurus externalThesaurus2 = new ExternalThesaurus();
		externalThesaurus2.setExternalThesaurusType(new ExternalThesaurusType());
		list4.add(externalThesaurus2);
		when(externalThesaurusDAO.getByExternalId(Mockito.<String>any()))
			.thenReturn(list4);
		when(externalThesaurusDAO.update(Mockito.<ExternalThesaurus>any()))
			.thenReturn(new ExternalThesaurus());
		when(alignmentDAO.update(Mockito.<Alignment>any()))
			.thenReturn(new Alignment());
		ArrayList<Resource> skosConcepts = new ArrayList<Resource>();
		Resource resource3 = mock(Resource.class);
		skosConcepts.add(resource3);
		assertTrue((service.buildConcepts(new Thesaurus(), skosConcepts)).isEmpty());
		Mockito.verify(thesaurusTermDAO).flush();
	}
}
