package fr.mcc.ginco.imports;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.hp.hpl.jena.rdf.model.Literal;
import com.hp.hpl.jena.rdf.model.RDFNode;
import com.hp.hpl.jena.rdf.model.Resource;
import com.hp.hpl.jena.rdf.model.Statement;

import fr.mcc.ginco.beans.Language;
import fr.mcc.ginco.beans.NodeLabel;
import fr.mcc.ginco.beans.Thesaurus;
import fr.mcc.ginco.beans.ThesaurusArray;
import fr.mcc.ginco.dao.ILanguageDAO;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

/**
 * Unit tests for fr.mcc.ginco.imports.NodeLabelBuilder
 *
 * @author Diffblue Cover
 */

public class NodeLabelBuilderTest {

	@Mock(name = "languagesDAO")
	private ILanguageDAO languagesDAO;

	@Mock(name = "skosImportUtils")
	private SKOSImportUtils skosImportUtils;

	@InjectMocks
	private NodeLabelBuilder service;

	@Before public void initMocks() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void buildNodeLabel() throws java.text.ParseException {

		// arrange
		Date date1 =
			 new java.text.SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31");
		Date date2 =
			 new java.text.SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31");
		when(skosImportUtils.getSkosDate(Mockito.<String>any()))
			.thenReturn(date2)
			.thenReturn(date1);
		Language language = new Language();
		when(languagesDAO.getByPart1(Mockito.<String>any()))
			.thenReturn(language);
		Literal literal = mock(Literal.class);
		when(literal.getLanguage())
			.thenReturn("foo");
		RDFNode obj = mock(RDFNode.class);
		when(obj.asLiteral())
			.thenReturn(literal);
		Statement statement1 = mock(Statement.class);
		when(statement1.getObject())
			.thenReturn(obj);
		when(statement1.getString())
			.thenReturn("foo");
		Statement statement2 = mock(Statement.class);
		when(statement2.getString())
			.thenReturn("foo");
		Statement statement3 = mock(Statement.class);
		when(statement3.getString())
			.thenReturn("foo");
		Resource skosCollection = mock(Resource.class);
		when(skosCollection.getProperty(Mockito.<com.hp.hpl.jena.rdf.model.Property>any()))
			.thenReturn(statement3)
			.thenReturn(statement2)
			.thenReturn(statement1);
		Thesaurus thesaurus1 = mock(Thesaurus.class);
		ThesaurusArray array = new ThesaurusArray();

		// act
		NodeLabel result = service.buildNodeLabel(skosCollection, thesaurus1, array);

		// assert
		assertSame(date2, result.getCreated());
		assertNull(result.getIdentifier());
		assertSame(language, result.getLanguage());
		assertEquals("foo", result.getLexicalValue());
		assertSame(date1, result.getModified());
		assertSame(array, result.getThesaurusArray());
	}
}
