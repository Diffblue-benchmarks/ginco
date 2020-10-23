package fr.mcc.ginco.imports;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.hp.hpl.jena.rdf.model.Resource;
import com.hp.hpl.jena.rdf.model.Statement;
import com.hp.hpl.jena.rdf.model.StmtIterator;

import fr.mcc.ginco.ark.IIDGeneratorService;
import fr.mcc.ginco.beans.Thesaurus;
import fr.mcc.ginco.beans.ThesaurusConcept;
import fr.mcc.ginco.dao.ILanguageDAO;
import fr.mcc.ginco.dao.IThesaurusTermRoleDAO;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

/**
 * Unit tests for fr.mcc.ginco.imports.TermBuilder
 *
 * @author Diffblue Cover
 */

public class TermBuilderTest {

	@Mock(name = "generatorService")
	private IIDGeneratorService generatorService;

	@Mock(name = "languagesDAO")
	private ILanguageDAO languagesDAO;

	@Mock(name = "thesaurusTermRoleDAO")
	private IThesaurusTermRoleDAO thesaurusTermRoleDAO;

	@InjectMocks
	private TermBuilder service;

	@Before public void initMocks() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void buildTermsReturnsEmpty() {
		StmtIterator stmtIterator1 = mock(StmtIterator.class);
		when(stmtIterator1.hasNext())
			.thenReturn(false);
		StmtIterator stmtIterator2 = mock(StmtIterator.class);
		when(stmtIterator2.hasNext())
			.thenReturn(false);
		StmtIterator stmtIterator3 = mock(StmtIterator.class);
		when(stmtIterator3.hasNext())
			.thenReturn(false);
		Statement statement = mock(Statement.class);
		Resource skosConcept = mock(Resource.class);
		when(skosConcept.getProperty(Mockito.<com.hp.hpl.jena.rdf.model.Property>any()))
			.thenReturn(statement);
		when(skosConcept.listProperties(Mockito.<com.hp.hpl.jena.rdf.model.Property>any()))
			.thenReturn(stmtIterator3)
			.thenReturn(stmtIterator2)
			.thenReturn(stmtIterator1);
		Thesaurus thesaurus1 = mock(Thesaurus.class);
		assertTrue((service.buildTerms(skosConcept, thesaurus1, new ThesaurusConcept())).isEmpty());
	}
}
