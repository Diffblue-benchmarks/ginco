package fr.mcc.ginco.imports;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import com.hp.hpl.jena.rdf.model.ModelFactory;

import fr.mcc.ginco.beans.Thesaurus;
import fr.mcc.ginco.beans.ThesaurusArray;
import fr.mcc.ginco.dao.IThesaurusConceptDAO;
import fr.mcc.ginco.skos.namespaces.GINCO;

import java.util.HashMap;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
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
	public void buildArrayBuiltArraysIsEmptyAndModelIsEmpty() {

		// arrange
		Thesaurus thesaurus1 = new Thesaurus();
		HashMap<String, ThesaurusArray> builtArrays =
			 new HashMap<String, ThesaurusArray>();

		// act
		ThesaurusArray result =
			 service.buildArray(GINCO.getResource("BASIC"), ModelFactory.createDefaultModel(), thesaurus1, builtArrays);

		// assert
		assertTrue((result.getConcepts()).isEmpty());
		assertEquals("http://data.culture.fr/thesaurus/ginco/ns/BASIC", result.getIdentifier());
		assertNull(result.getNotation());
		assertTrue(result.getOrdered());
		assertNull(result.getParent());
		assertNull(result.getSuperOrdinateConcept());
		assertSame(thesaurus1, result.getThesaurus());
		assertSame(result, builtArrays.get("http://data.culture.fr/thesaurus/ginco/ns/BASIC"));
	}

	@Test
	public void getChildrenArraysBuiltArraysIsEmptyReturnsEmpty() {
		assertTrue((service.getChildrenArrays(GINCO.getResource("BASIC"), new Thesaurus(), new HashMap<String, ThesaurusArray>())).isEmpty());
	}
}
