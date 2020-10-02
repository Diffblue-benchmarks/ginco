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
	public void getCreator2() throws java.util.NoSuchElementException {
		Resource resource1 = mock(Resource.class);
		RDFNode obj = mock(RDFNode.class);
		when(obj.asResource())
			.thenReturn(resource1);
		when(obj.isResource())
			.thenReturn(true);
		Statement statement1 = mock(Statement.class);
		when(statement1.getObject())
			.thenReturn(obj);
		Resource skosThesaurus = mock(Resource.class);
		when(skosThesaurus.getProperty(Mockito.<com.hp.hpl.jena.rdf.model.Property>any()))
			.thenReturn(statement1);
		Statement statement2 = mock(Statement.class);
		when(statement2.getString())
			.thenReturn("bar");
		Statement statement3 = mock(Statement.class);
		when(statement3.getString())
			.thenReturn("foo");
		Statement statement4 = mock(Statement.class);
		when(statement4.getString())
			.thenReturn("foo");
		Resource resource2 = mock(Resource.class);
		when(resource2.getProperty(Mockito.<com.hp.hpl.jena.rdf.model.Property>any()))
			.thenReturn(statement4)
			.thenReturn(statement3)
			.thenReturn(statement2);
		Resource resource3 = mock(Resource.class);
		when(resource3.asResource())
			.thenReturn(resource2);
		Statement statement5 = mock(Statement.class);
		when(statement5.getSubject())
			.thenReturn(resource3);
		StmtIterator stmtIterator = mock(StmtIterator.class);
		when(stmtIterator.hasNext())
			.thenReturn(true);
		when(stmtIterator.next())
			.thenReturn(statement5);
		Model model = mock(Model.class);
		when(model.listStatements(Mockito.<com.hp.hpl.jena.rdf.model.Selector>any()))
			.thenReturn(stmtIterator);
		ThesaurusOrganization result = service.getCreator(skosThesaurus, model);
		assertEquals("bar", result.getEmail());
		assertEquals("foo", result.getHomepage());
		assertNull(result.getIdentifier());
		assertEquals("foo", result.getName());
	}

	@Test
	public void getCreatorReturnsNull1() {
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
	public void getCreatorReturnsNull2() throws java.util.NoSuchElementException {
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
