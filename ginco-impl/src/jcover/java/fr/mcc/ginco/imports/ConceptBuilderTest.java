package fr.mcc.ginco.imports;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.hp.hpl.jena.ontology.ObjectProperty;
import com.hp.hpl.jena.rdf.model.Resource;
import com.hp.hpl.jena.rdf.model.Statement;
import com.hp.hpl.jena.rdf.model.StmtIterator;

import fr.mcc.ginco.beans.Thesaurus;
import fr.mcc.ginco.beans.ThesaurusConcept;
import fr.mcc.ginco.dao.IConceptHierarchicalRelationshipDAO;
import fr.mcc.ginco.services.IAssociativeRelationshipRoleService;
import fr.mcc.ginco.services.IConceptHierarchicalRelationshipServiceUtil;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

/**
 * Unit tests for fr.mcc.ginco.imports.ConceptBuilder
 *
 * @author Diffblue Cover
 */

public class ConceptBuilderTest {

	@Mock(name = "associativeRelationshipRoleService")
	private IAssociativeRelationshipRoleService associativeRelationshipRoleService;

	@Mock(name = "conceptHierarchicalRelationshipDAO")
	private IConceptHierarchicalRelationshipDAO conceptHierarchicalRelationshipDAO;

	@Mock(name = "conceptHierarchicalRelationshipServiceUtil")
	private IConceptHierarchicalRelationshipServiceUtil conceptHierarchicalRelationshipServiceUtil;

	@Mock(name = "skosImportUtils")
	private SKOSImportUtils skosImportUtils;

	@InjectMocks
	private ConceptBuilder service;

	@Before public void initMocks() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void buildConcept() throws java.text.ParseException {

		// arrange
		Date date1 = new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31");
		Date date2 = new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31");
		when(skosImportUtils.getSkosDate(Mockito.<String>any()))
			.thenReturn(date2)
			.thenReturn(date1);
		Statement statement1 = mock(Statement.class);
		when(statement1.getInt())
			.thenReturn(1);
		Statement statement2 = mock(Statement.class);
		when(statement2.getString())
			.thenReturn("foo");
		Statement statement3 = mock(Statement.class);
		when(statement3.getString())
			.thenReturn("foo");
		Statement statement4 = mock(Statement.class);
		when(statement4.getString())
			.thenReturn("foo");
		Resource skosConcept = mock(Resource.class);
		when(skosConcept.getProperty(Mockito.<com.hp.hpl.jena.rdf.model.Property>any()))
			.thenReturn(statement4)
			.thenReturn(statement3)
			.thenReturn(statement2)
			.thenReturn(statement1);
		when(skosConcept.getURI())
			.thenReturn("/some/path.html")
			.thenReturn("/some/path.html")
			.thenReturn("/some/path.html");
		Thesaurus thesaurus = new Thesaurus();
		thesaurus.setDefaultTopConcept(false);

		// act
		ThesaurusConcept result = service.buildConcept(skosConcept, thesaurus);

		// assert
		assertNull(result.getAssociativeRelationshipLeft());
		assertNull(result.getAssociativeRelationshipRight());
		assertNull(result.getConceptArrays());
		assertSame(date2, result.getCreated());
		assertEquals("/some/path.html", result.getIdentifier());
		assertSame(date1, result.getModified());
		assertEquals("foo", result.getNotation());
		assertTrue((result.getParentConcepts()).isEmpty());
		assertTrue((result.getRootConcepts()).isEmpty());
		assertEquals(1, (int) result.getStatus());
		assertSame(thesaurus, result.getThesaurus());
		assertFalse(result.getTopConcept());
	}

	@Test
	public void buildConceptAssociativerelationshipRelatedTypesIsEmptyReturnsEmpty() {
		StmtIterator stmtIterator = mock(StmtIterator.class);
		when(stmtIterator.hasNext())
			.thenReturn(false);
		Resource skosConcept = mock(Resource.class);
		when(skosConcept.getURI())
			.thenReturn("/some/path.html");
		when(skosConcept.listProperties(Mockito.<com.hp.hpl.jena.rdf.model.Property>any()))
			.thenReturn(stmtIterator);
		Thesaurus thesaurus = mock(Thesaurus.class);
		assertTrue((service.buildConceptAssociativerelationship(skosConcept, thesaurus, new ArrayList<ObjectProperty>())).isEmpty());
	}
}
