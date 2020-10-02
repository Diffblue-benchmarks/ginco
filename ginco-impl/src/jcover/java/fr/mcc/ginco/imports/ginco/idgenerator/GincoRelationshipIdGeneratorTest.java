package fr.mcc.ginco.imports.ginco.idgenerator;

import static org.junit.Assert.assertTrue;

import fr.mcc.ginco.beans.ConceptHierarchicalRelationship;
import fr.mcc.ginco.exports.result.bean.JaxbList;

import java.util.HashMap;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
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
	public void getIdsForHierarchicalRelationsReturnsEmpty() throws java.io.IOException, CloneNotSupportedException {
		assertTrue(service.getIdsForHierarchicalRelations(new HashMap<String, JaxbList<ConceptHierarchicalRelationship>>(), new HashMap<String, String>()).isEmpty());
	}
}
