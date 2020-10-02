package fr.mcc.ginco.imports.ginco.idgenerator;

import static org.junit.Assert.assertSame;
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

	@Before public void initMocks() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void getIdsForHierarchicalRelations1() {
		when(gincoIdMapParser.getNewId(Mockito.<String>any(), Mockito.<java.util.Map<String, String>>any()))
			.thenReturn("1234");
		HashMap<String, JaxbList<ConceptHierarchicalRelationship>> relations =
			 new HashMap<String, JaxbList<ConceptHierarchicalRelationship>>();
		JaxbList<ConceptHierarchicalRelationship> jaxbList1 =
			 new JaxbList<ConceptHierarchicalRelationship>();
		relations.put("bar", jaxbList1);
		assertSame(jaxbList1, service.getIdsForHierarchicalRelations(relations, new HashMap<String, String>()).get("1234"));
	}

	@Test
	public void getIdsForHierarchicalRelations2() {
		when(gincoIdMapParser.getNewId(Mockito.<String>any(), Mockito.<java.util.Map<String, String>>any()))
			.thenReturn("1234")
			.thenReturn("1234")
			.thenReturn("1234");
		HashMap<String, JaxbList<ConceptHierarchicalRelationship>> relations =
			 new HashMap<String, JaxbList<ConceptHierarchicalRelationship>>();
		ArrayList<ConceptHierarchicalRelationship> list1 =
			 new ArrayList<ConceptHierarchicalRelationship>();
		ConceptHierarchicalRelationship conceptHierarchicalRelationship1 =
			 new ConceptHierarchicalRelationship();
		conceptHierarchicalRelationship1.setIdentifier(new ConceptHierarchicalRelationship.Id());
		list1.add(conceptHierarchicalRelationship1);
		JaxbList<ConceptHierarchicalRelationship> jaxbList1 =
			 new JaxbList<ConceptHierarchicalRelationship>(list1);
		relations.put("foo", jaxbList1);
		assertSame(jaxbList1, service.getIdsForHierarchicalRelations(relations, new HashMap<String, String>()).get("1234"));
	}
}
