package fr.mcc.ginco.imports;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.Resource;
import com.hp.hpl.jena.rdf.model.StmtIterator;

import fr.mcc.ginco.beans.Thesaurus;
import fr.mcc.ginco.beans.ThesaurusArray;
import fr.mcc.ginco.dao.IThesaurusConceptDAO;

import java.util.HashMap;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

/**
 * Unit tests for fr.mcc.ginco.imports.ThesaurusArrayBuilder
 *
 * @author Diffblue Cover
 */

public class ThesaurusArrayBuilderTest {

	@Mock(name = "thesaurusConceptDAO")
	private IThesaurusConceptDAO thesaurusConceptDAO;

	@InjectMocks
	private ThesaurusArrayBuilder service;

	@Before public void initMocks() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void buildArray() {
		StmtIterator stmtIterator = mock(StmtIterator.class);
		when(stmtIterator.hasNext())
			.thenReturn(false);
		Resource skosCollection = mock(Resource.class);
		when(skosCollection.getURI())
			.thenReturn("/some/path.html")
			.thenReturn("");
		when(skosCollection.listProperties(Mockito.<com.hp.hpl.jena.rdf.model.Property>any()))
			.thenReturn(stmtIterator);
		Model model = mock(Model.class);
		Thesaurus thesaurus = mock(Thesaurus.class);
		ThesaurusArray result =
			 service.buildArray(skosCollection, model, thesaurus, new HashMap<String, ThesaurusArray>());
		assertTrue((result.getConcepts()).isEmpty());
		assertEquals("/some/path.html", result.getIdentifier());
		assertNull(result.getNotation());
		assertTrue(result.getOrdered());
		assertNull(result.getParent());
		assertNull(result.getSuperOrdinateConcept());
		assertSame(thesaurus, result.getThesaurus());
	}

	@Test
	public void getChildrenArraysReturnsEmpty() {
		StmtIterator stmtIterator = mock(StmtIterator.class);
		when(stmtIterator.hasNext())
			.thenReturn(false);
		Resource skosCollection = mock(Resource.class);
		when(skosCollection.listProperties(Mockito.<com.hp.hpl.jena.rdf.model.Property>any()))
			.thenReturn(stmtIterator);
		Thesaurus thesaurus = mock(Thesaurus.class);
		assertTrue((service.getChildrenArrays(skosCollection, thesaurus, new HashMap<String, ThesaurusArray>())).isEmpty());
	}
}
