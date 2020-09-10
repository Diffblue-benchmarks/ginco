package fr.mcc.ginco.imports;

import static org.mockito.Mockito.when;

import com.hp.hpl.jena.rdf.model.ModelFactory;
import com.hp.hpl.jena.rdf.model.Resource;

import fr.mcc.ginco.beans.Thesaurus;
import fr.mcc.ginco.beans.ThesaurusArray;
import fr.mcc.ginco.dao.INodeLabelDAO;
import fr.mcc.ginco.dao.IThesaurusArrayDAO;

import java.util.ArrayList;
import java.util.HashMap;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

/**
 * Unit tests for fr.mcc.ginco.imports.ThesaurusArraysBuilder
 *
 * @author Diffblue Cover
 */

public class ThesaurusArraysBuilderTest {

	@Mock(name = "nodeLabelDAO")
	private INodeLabelDAO nodeLabelDAO;

	@Mock(name = "skosArrayBuilder")
	private ThesaurusArrayBuilder skosArrayBuilder;

	@Mock(name = "skosImportUtils")
	private SKOSImportUtils skosImportUtils;

	@Mock(name = "skosNodeLabelBuilder")
	private NodeLabelBuilder skosNodeLabelBuilder;

	@Mock(name = "thesaurusArrayDAO")
	private IThesaurusArrayDAO thesaurusArrayDAO;

	@InjectMocks
	private ThesaurusArraysBuilder service;

	@Before public void initMocks() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void buildArraysBuiltArraysIsEmptyAndModelIsEmpty() {
		when(skosImportUtils.getSKOSRessources(Mockito.<com.hp.hpl.jena.rdf.model.Model>any(), Mockito.<Resource>any()))
			.thenReturn(new ArrayList<Resource>());
		service.buildArrays(new Thesaurus(), ModelFactory.createDefaultModel(), new HashMap<String, ThesaurusArray>());
	}

	@Test
	public void buildChildrenArraysBuiltArraysIsEmptyAndModelIsEmpty() {
		when(skosImportUtils.getSKOSRessources(Mockito.<com.hp.hpl.jena.rdf.model.Model>any(), Mockito.<Resource>any()))
			.thenReturn(new ArrayList<Resource>());
		service.buildChildrenArrays(new Thesaurus(), ModelFactory.createDefaultModel(), new HashMap<String, ThesaurusArray>());
	}
}
