package fr.mcc.ginco.imports.ginco.idgenerator;

import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import fr.mcc.ginco.beans.ConceptHierarchicalRelationship;
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
 * Unit tests for fr.mcc.ginco.imports.ginco.idgenerator.GincoRelationshipIdGenerator
 *
 * @author Diffblue Cover
 */

public class GincoRelationshipIdGeneratorTest {

	@Mock(name = "gincoIdMapParser")
	private GincoIdMapParser gincoIdMapParser;

	@InjectMocks
	private GincoRelationshipIdGenerator service;

	@Before
	public void initMocks() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void getIdsForHierarchicalRelations() {
		when(gincoIdMapParser.getNewId(Mockito.<String>any(), Mockito.<java.util.Map<String, String>>any()))
			.thenReturn("1234");
		HashMap<String, JaxbList<ConceptHierarchicalRelationship>> relations =
			 new HashMap<String, JaxbList<ConceptHierarchicalRelationship>>();
		JaxbList<ConceptHierarchicalRelationship> jaxbList =
			 new JaxbList<ConceptHierarchicalRelationship>();
		relations.put("", jaxbList);
		assertSame(jaxbList, service.getIdsForHierarchicalRelations(relations, new HashMap<String, String>()).get("1234"));
	}

	@Test
	public void getIdsForHierarchicalRelationsIdMappingIsFoo() {
		when(gincoIdMapParser.getNewId(Mockito.<String>any(), Mockito.<java.util.Map<String, String>>any()))
			.thenReturn("1234")
			.thenReturn("1234")
			.thenReturn("1234");
		HashMap<String, JaxbList<ConceptHierarchicalRelationship>> relations =
			 new HashMap<String, JaxbList<ConceptHierarchicalRelationship>>();
		ArrayList<ConceptHierarchicalRelationship> list =
			 new ArrayList<ConceptHierarchicalRelationship>();
		ConceptHierarchicalRelationship conceptHierarchicalRelationship =
			 new ConceptHierarchicalRelationship();
		conceptHierarchicalRelationship.setIdentifier(new ConceptHierarchicalRelationship.Id());
		list.add(conceptHierarchicalRelationship);
		JaxbList<ConceptHierarchicalRelationship> jaxbList =
			 new JaxbList<ConceptHierarchicalRelationship>(list);
		relations.put("", jaxbList);
		HashMap<String, String> idMapping = new HashMap<String, String>();
		idMapping.put("", "foo");
		assertSame(jaxbList, service.getIdsForHierarchicalRelations(relations, idMapping).get("1234"));
	}

	@Test
	public void getIdsForHierarchicalRelationsRelationsIsEmptyReturnsEmpty() {
		assertTrue(service.getIdsForHierarchicalRelations(new HashMap<String, JaxbList<ConceptHierarchicalRelationship>>(), new HashMap<String, String>()).isEmpty());
	}
}
