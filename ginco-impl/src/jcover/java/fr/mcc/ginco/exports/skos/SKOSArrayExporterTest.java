package fr.mcc.ginco.exports.skos;

import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.Resource;

import fr.mcc.ginco.beans.Language;
import fr.mcc.ginco.beans.NodeLabel;
import fr.mcc.ginco.beans.Thesaurus;
import fr.mcc.ginco.beans.ThesaurusArray;
import fr.mcc.ginco.services.INodeLabelService;
import fr.mcc.ginco.services.IThesaurusArrayService;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

/**
 * Unit tests for fr.mcc.ginco.exports.skos.SKOSArrayExporter
 *
 * @author Diffblue Cover
 */

public class SKOSArrayExporterTest {

	@Mock(name = "nodeLabelService")
	private INodeLabelService nodeLabelService;

	@Mock(name = "thesaurusArrayService")
	private IThesaurusArrayService thesaurusArrayService;

	@InjectMocks
	private SKOSArrayExporter service;

	@Before public void initMocks() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void exportCollections1() {
		List<ThesaurusArray> list2 = new ArrayList<ThesaurusArray>();
		list2.add(new ThesaurusArray());
		when(thesaurusArrayService.getAllThesaurusArrayByThesaurusId(Mockito.<String>any(), Mockito.<String>any()))
			.thenReturn(list2);
		when(thesaurusArrayService.getChildrenArrays(Mockito.<String>any()))
			.thenReturn(new ArrayList<ThesaurusArray>());
		NodeLabel nodeLabel = new NodeLabel();
		nodeLabel.setLanguage(new Language());
		when(nodeLabelService.getByThesaurusArray(Mockito.<String>any()))
			.thenReturn(nodeLabel);
		Model model1 = mock(Model.class);
		Model model2 = mock(Model.class);
		Model model3 = mock(Model.class);
		Resource resource1 = mock(Resource.class);
		Model model4 = mock(Model.class);
		Resource resource2 = mock(Resource.class);
		Resource resource3 = mock(Resource.class);
		Resource resource4 = mock(Resource.class);
		when(resource4.addProperty(Mockito.<com.hp.hpl.jena.rdf.model.Property>any(), Mockito.<String>any(), Mockito.<String>any()))
			.thenReturn(resource3);
		Model model5 = mock(Model.class);
		when(model5.createResource(Mockito.<String>any()))
			.thenReturn(resource2);
		when(model5.add(Mockito.<Resource>any(), Mockito.<com.hp.hpl.jena.rdf.model.Property>any(), Mockito.<com.hp.hpl.jena.rdf.model.RDFNode>any()))
			.thenReturn(model4);
		when(model5.add(Mockito.<Resource>any(), Mockito.<com.hp.hpl.jena.rdf.model.Property>any(), Mockito.<String>any()))
			.thenReturn(model2)
			.thenReturn(model1);
		when(model5.createResource(Mockito.<String>any(), Mockito.<Resource>any()))
			.thenReturn(resource4);
		assertSame(model5, service.exportCollections(new Thesaurus(), model5));
	}

	@Test
	public void exportCollections2() {
		List<ThesaurusArray> list1 = new ArrayList<ThesaurusArray>();
		list1.add(new ThesaurusArray());
		List<ThesaurusArray> list2 = new ArrayList<ThesaurusArray>();
		list2.add(new ThesaurusArray());
		when(thesaurusArrayService.getAllThesaurusArrayByThesaurusId(Mockito.<String>any(), Mockito.<String>any()))
			.thenReturn(list2);
		when(thesaurusArrayService.getChildrenArrays(Mockito.<String>any()))
			.thenReturn(list1);
		NodeLabel nodeLabel = new NodeLabel();
		nodeLabel.setLanguage(new Language());
		when(nodeLabelService.getByThesaurusArray(Mockito.<String>any()))
			.thenReturn(nodeLabel);
		Model model1 = mock(Model.class);
		Model model2 = mock(Model.class);
		Model model3 = mock(Model.class);
		Resource resource1 = mock(Resource.class);
		Model model4 = mock(Model.class);
		Resource resource2 = mock(Resource.class);
		Resource resource3 = mock(Resource.class);
		Resource resource4 = mock(Resource.class);
		when(resource4.addProperty(Mockito.<com.hp.hpl.jena.rdf.model.Property>any(), Mockito.<String>any(), Mockito.<String>any()))
			.thenReturn(resource3);
		Model model5 = mock(Model.class);
		when(model5.createResource(Mockito.<String>any()))
			.thenReturn(resource2)
			.thenReturn(resource1);
		when(model5.add(Mockito.<Resource>any(), Mockito.<com.hp.hpl.jena.rdf.model.Property>any(), Mockito.<com.hp.hpl.jena.rdf.model.RDFNode>any()))
			.thenReturn(model4)
			.thenReturn(model3);
		when(model5.add(Mockito.<Resource>any(), Mockito.<com.hp.hpl.jena.rdf.model.Property>any(), Mockito.<String>any()))
			.thenReturn(model2)
			.thenReturn(model1);
		when(model5.createResource(Mockito.<String>any(), Mockito.<Resource>any()))
			.thenReturn(resource4);
		assertSame(model5, service.exportCollections(new Thesaurus(), model5));
	}
}
