package fr.mcc.ginco.imports;

import static org.junit.Assert.assertNull;

import com.hp.hpl.jena.rdf.model.ModelFactory;

import fr.mcc.ginco.skos.namespaces.GINCO;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

/**
 * Unit tests for fr.mcc.ginco.imports.ThesaurusOrganizationBuilder
 *
 * @author Diffblue Cover
 */

public class ThesaurusOrganizationBuilderTest {

	@InjectMocks
	private ThesaurusOrganizationBuilder service;

	@Before public void initMocks() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void getCreatorModelIsEmptyReturnsNull() {
		assertNull(service.getCreator(GINCO.getResource("BASIC"), ModelFactory.createDefaultModel()));
	}
}
