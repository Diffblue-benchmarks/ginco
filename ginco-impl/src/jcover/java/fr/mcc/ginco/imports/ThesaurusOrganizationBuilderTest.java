package fr.mcc.ginco.imports;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.RDFNode;
import com.hp.hpl.jena.rdf.model.Resource;
import com.hp.hpl.jena.rdf.model.Statement;
import com.hp.hpl.jena.rdf.model.StmtIterator;

import fr.mcc.ginco.beans.ThesaurusOrganization;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
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
	public void getCreator1() {
		RDFNode obj = mock(RDFNode.class);
		when(obj.isLiteral())
			.thenReturn(false);
		when(obj.isResource())
			.thenReturn(false);
		Statement statement = mock(Statement.class);
		when(statement.getObject())
			.thenReturn(obj);
		Resource skosThesaurus = mock(Resource.class);
		when(skosThesaurus.getProperty(Mockito.<com.hp.hpl.jena.rdf.model.Property>any()))
			.thenReturn(statement);
		Model model = mock(Model.class);
		assertNull(service.getCreator(skosThesaurus, model));
	}

	@Test
	public void getCreator2() {
		RDFNode obj = mock(RDFNode.class);
		when(obj.isLiteral())
			.thenReturn(true);
		when(obj.isResource())
			.thenReturn(false);
		Statement statement = mock(Statement.class);
		when(statement.getObject())
			.thenReturn(obj);
		when(statement.getString())
			.thenReturn("foo");
		Resource skosThesaurus = mock(Resource.class);
		when(skosThesaurus.getProperty(Mockito.<com.hp.hpl.jena.rdf.model.Property>any()))
			.thenReturn(statement);
		Model model = mock(Model.class);
		ThesaurusOrganization result = service.getCreator(skosThesaurus, model);
		assertNull(result.getEmail());
		assertNull(result.getHomepage());
		assertNull(result.getIdentifier());
		assertEquals("foo", result.getName());
	}

	@Test
	public void getCreator3() {
		Resource resource = mock(Resource.class);
		RDFNode obj = mock(RDFNode.class);
		when(obj.asResource())
			.thenReturn(resource);
		when(obj.isResource())
			.thenReturn(true);
		Statement statement = mock(Statement.class);
		when(statement.getObject())
			.thenReturn(obj);
		Resource skosThesaurus = mock(Resource.class);
		when(skosThesaurus.getProperty(Mockito.<com.hp.hpl.jena.rdf.model.Property>any()))
			.thenReturn(statement);
		StmtIterator stmtIterator = mock(StmtIterator.class);
		when(stmtIterator.hasNext())
			.thenReturn(false);
		Model model = mock(Model.class);
		when(model.listStatements(Mockito.<com.hp.hpl.jena.rdf.model.Selector>any()))
			.thenReturn(stmtIterator);
		assertNull(service.getCreator(skosThesaurus, model));
	}
}
