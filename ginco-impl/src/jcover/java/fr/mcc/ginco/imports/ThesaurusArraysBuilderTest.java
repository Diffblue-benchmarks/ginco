package fr.mcc.ginco.imports;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.Resource;

import fr.mcc.ginco.beans.NodeLabel;
import fr.mcc.ginco.beans.Thesaurus;
import fr.mcc.ginco.beans.ThesaurusArray;
import fr.mcc.ginco.beans.ThesaurusConcept;
import fr.mcc.ginco.dao.INodeLabelDAO;
import fr.mcc.ginco.dao.IThesaurusArrayDAO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

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
	public void buildArrays() {
		when(thesaurusArrayDAO.update(Mockito.<ThesaurusArray>any()))
			.thenReturn(new ThesaurusArray());
		when(skosNodeLabelBuilder.buildNodeLabel(Mockito.<Resource>any(), Mockito.<Thesaurus>any(), Mockito.<ThesaurusArray>any()))
			.thenReturn(new NodeLabel());
		List<Resource> list = new ArrayList<Resource>();
		Resource resource = mock(Resource.class);
		list.add(resource);
		when(skosImportUtils.getSKOSRessources(Mockito.<Model>any(), Mockito.<Resource>any()))
			.thenReturn(list);
		when(skosArrayBuilder.buildArray(Mockito.<Resource>any(), Mockito.<Model>any(), Mockito.<Thesaurus>any(), Mockito.<java.util.Map<String, ThesaurusArray>>any()))
			.thenReturn(new ThesaurusArray());
		when(nodeLabelDAO.update(Mockito.<NodeLabel>any()))
			.thenReturn(new NodeLabel());
		Model model = mock(Model.class);
		service.buildArrays(new Thesaurus(), model, new HashMap<String, ThesaurusArray>());
	}

	@Test
	public void buildChildrenArrays() {
		when(thesaurusArrayDAO.getById(Mockito.<String>any()))
			.thenReturn(new ThesaurusArray());
		when(thesaurusArrayDAO.update(Mockito.<ThesaurusArray>any()))
			.thenReturn(new ThesaurusArray());
		List<Resource> list1 = new ArrayList<Resource>();
		Resource resource = mock(Resource.class);
		when(resource.getURI())
			.thenReturn("/some/path.html");
		list1.add(resource);
		when(skosImportUtils.getSKOSRessources(Mockito.<Model>any(), Mockito.<Resource>any()))
			.thenReturn(list1);
		List<ThesaurusArray> list2 = new ArrayList<ThesaurusArray>();
		ThesaurusArray thesaurusArray3 = new ThesaurusArray();
		thesaurusArray3.setSuperOrdinateConcept(new ThesaurusConcept());
		list2.add(thesaurusArray3);
		when(skosArrayBuilder.getChildrenArrays(Mockito.<Resource>any(), Mockito.<Thesaurus>any(), Mockito.<java.util.Map<String, ThesaurusArray>>any()))
			.thenReturn(list2);
		Model model = mock(Model.class);
		service.buildChildrenArrays(new Thesaurus(), model, new HashMap<String, ThesaurusArray>());
	}
}
