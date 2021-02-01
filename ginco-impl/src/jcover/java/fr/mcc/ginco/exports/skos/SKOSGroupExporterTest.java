package fr.mcc.ginco.exports.skos;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.Resource;

import fr.mcc.ginco.beans.Language;
import fr.mcc.ginco.beans.Thesaurus;
import fr.mcc.ginco.beans.ThesaurusConcept;
import fr.mcc.ginco.beans.ThesaurusConceptGroup;
import fr.mcc.ginco.beans.ThesaurusConceptGroupLabel;
import fr.mcc.ginco.beans.ThesaurusConceptGroupType;
import fr.mcc.ginco.services.IThesaurusConceptGroupLabelService;
import fr.mcc.ginco.services.IThesaurusConceptGroupService;
import fr.mcc.ginco.services.IThesaurusConceptService;

import java.util.ArrayList;
import java.util.HashSet;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

/**
 * Unit tests for fr.mcc.ginco.exports.skos.SKOSGroupExporter
 *
 * @author Diffblue Cover
 */

public class SKOSGroupExporterTest {

	@Mock(name = "thesaurusConceptGroupLabelService")
	private IThesaurusConceptGroupLabelService thesaurusConceptGroupLabelService;

	@Mock(name = "thesaurusConceptGroupService")
	private IThesaurusConceptGroupService thesaurusConceptGroupService;

	@Mock(name = "thesaurusConceptService")
	private IThesaurusConceptService thesaurusConceptService;

	@InjectMocks
	private SKOSGroupExporter service;

	@Before
	public void initMocks() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void exportGroup1() {
		when(thesaurusConceptGroupService.getChildGroups(Mockito.<String>any()))
			.thenReturn(new ArrayList<ThesaurusConceptGroup>());
		ThesaurusConceptGroupLabel thesaurusConceptGroupLabel =
			 new ThesaurusConceptGroupLabel();
		thesaurusConceptGroupLabel.setLanguage(new Language());
		when(thesaurusConceptGroupLabelService.getByThesaurusConceptGroup(Mockito.<String>any()))
			.thenReturn(thesaurusConceptGroupLabel);
		ThesaurusConceptGroup group = new ThesaurusConceptGroup();
		group.setConceptGroupType(new ThesaurusConceptGroupType());
		group.setConcepts(new HashSet<ThesaurusConcept>());
		group.setIsDynamic(false);
		group.setNotation("DE");
		group.setParent(new ThesaurusConceptGroup());
		Model model1 = mock(Model.class);
		Model model2 = mock(Model.class);
		Model model3 = mock(Model.class);
		Model model4 = mock(Model.class);
		Model model5 = mock(Model.class);
		Model model6 = mock(Model.class);
		Model model7 = mock(Model.class);
		Resource resource1 = mock(Resource.class);
		Resource resource2 = mock(Resource.class);
		Model model8 = mock(Model.class);
		when(model8.createResource(Mockito.<String>any()))
			.thenReturn(resource1);
		when(model8.add(Mockito.<Resource>any(), Mockito.<com.hp.hpl.jena.rdf.model.Property>any(), Mockito.<com.hp.hpl.jena.rdf.model.RDFNode>any()))
			.thenReturn(model7)
			.thenReturn(model2);
		when(model8.add(Mockito.<Resource>any(), Mockito.<com.hp.hpl.jena.rdf.model.Property>any(), Mockito.<String>any()))
			.thenReturn(model6)
			.thenReturn(model5)
			.thenReturn(model3);
		when(model8.add(Mockito.<Resource>any(), Mockito.<com.hp.hpl.jena.rdf.model.Property>any(), Mockito.<String>any(), Mockito.<String>any()))
			.thenReturn(model4);
		when(model8.createResource(Mockito.<String>any(), Mockito.<Resource>any()))
			.thenReturn(resource2);
		service.exportGroup(new Thesaurus(), group, model8);
	}

	@Test
	public void exportGroup2() {
		ArrayList<ThesaurusConceptGroup> thesaurusConceptGroupList =
			 new ArrayList<ThesaurusConceptGroup>();
		thesaurusConceptGroupList.add(new ThesaurusConceptGroup());
		when(thesaurusConceptGroupService.getChildGroups(Mockito.<String>any()))
			.thenReturn(thesaurusConceptGroupList);
		ThesaurusConceptGroupLabel thesaurusConceptGroupLabel =
			 new ThesaurusConceptGroupLabel();
		thesaurusConceptGroupLabel.setLanguage(new Language());
		when(thesaurusConceptGroupLabelService.getByThesaurusConceptGroup(Mockito.<String>any()))
			.thenReturn(thesaurusConceptGroupLabel);
		ThesaurusConceptGroup group = new ThesaurusConceptGroup();
		group.setConceptGroupType(new ThesaurusConceptGroupType());
		group.setConcepts(new HashSet<ThesaurusConcept>());
		group.setIsDynamic(false);
		group.setNotation("DE");
		group.setParent(new ThesaurusConceptGroup());
		Model model1 = mock(Model.class);
		Model model2 = mock(Model.class);
		Model model3 = mock(Model.class);
		Model model4 = mock(Model.class);
		Model model5 = mock(Model.class);
		Model model6 = mock(Model.class);
		Model model7 = mock(Model.class);
		Resource resource1 = mock(Resource.class);
		Resource resource2 = mock(Resource.class);
		Model model8 = mock(Model.class);
		when(model8.createResource(Mockito.<String>any()))
			.thenReturn(resource1);
		when(model8.add(Mockito.<Resource>any(), Mockito.<com.hp.hpl.jena.rdf.model.Property>any(), Mockito.<com.hp.hpl.jena.rdf.model.RDFNode>any()))
			.thenReturn(model7)
			.thenReturn(model2)
			.thenReturn(model1);
		when(model8.add(Mockito.<Resource>any(), Mockito.<com.hp.hpl.jena.rdf.model.Property>any(), Mockito.<String>any()))
			.thenReturn(model6)
			.thenReturn(model5)
			.thenReturn(model3);
		when(model8.add(Mockito.<Resource>any(), Mockito.<com.hp.hpl.jena.rdf.model.Property>any(), Mockito.<String>any(), Mockito.<String>any()))
			.thenReturn(model4);
		when(model8.createResource(Mockito.<String>any(), Mockito.<Resource>any()))
			.thenReturn(resource2);
		service.exportGroup(new Thesaurus(), group, model8);
	}
}
