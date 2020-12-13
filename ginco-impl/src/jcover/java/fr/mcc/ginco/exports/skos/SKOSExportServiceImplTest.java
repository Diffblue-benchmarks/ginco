package fr.mcc.ginco.exports.skos;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.hp.hpl.jena.rdf.model.Model;

import fr.mcc.ginco.beans.Thesaurus;
import fr.mcc.ginco.beans.ThesaurusConcept;
import fr.mcc.ginco.beans.ThesaurusConceptGroupType;
import fr.mcc.ginco.services.IThesaurusConceptGroupTypeService;
import fr.mcc.ginco.services.IThesaurusConceptService;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

/**
 * Unit tests for fr.mcc.ginco.exports.skos.SKOSExportServiceImpl
 *
 * @author Diffblue Cover
 */

public class SKOSExportServiceImplTest {

	@Mock(name = "skosArrayExporter")
	private SKOSArrayExporter skosArrayExporter;

	@Mock(name = "skosAssociativeRelationshipRolesExporter")
	private SKOSAssociativeRelationshipRolesExporter skosAssociativeRelationshipRolesExporter;

	@Mock(name = "skosComplexConceptExporter")
	private SKOSComplexConceptExporter skosComplexConceptExporter;

	@Mock(name = "skosConceptExporter")
	private SKOSConceptExporter skosConceptExporter;

	@Mock(name = "skosGroupsExporter")
	private SKOSGroupsExporter skosGroupsExporter;

	@Mock(name = "skosHierarchicalRelationshipRolesExporter")
	private SKOSHierarchicalRelationshipRolesExporter skosHierarchicalRelationshipRolesExporter;

	@Mock(name = "skosThesaurusExporter")
	private SKOSThesaurusExporter skosThesaurusExporter;

	@Mock(name = "thesaurusConceptGroupTypeService")
	private IThesaurusConceptGroupTypeService thesaurusConceptGroupTypeService;

	@Mock(name = "thesaurusConceptService")
	private IThesaurusConceptService thesaurusConceptService;

	@InjectMocks
	private SKOSExportServiceImpl service;

	@Before public void initMocks() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void getSKOSExport() {
		ArrayList<ThesaurusConcept> arrayList1 = new ArrayList<ThesaurusConcept>();
		arrayList1.add(new ThesaurusConcept());
		when(thesaurusConceptService.getTopTermThesaurusConcepts(Mockito.<String>any()))
			.thenReturn(arrayList1);
		ArrayList<ThesaurusConceptGroupType> arrayList2 =
			 new ArrayList<ThesaurusConceptGroupType>();
		arrayList2.add(new ThesaurusConceptGroupType());
		when(thesaurusConceptGroupTypeService.getConceptGroupTypeList())
			.thenReturn(arrayList2);
		Model model1 = mock(Model.class);
		when(skosThesaurusExporter.exportThesaurusSKOS(Mockito.<Thesaurus>any(), Mockito.<Model>any()))
			.thenReturn(model1);
		Model model2 = mock(Model.class);
		when(skosHierarchicalRelationshipRolesExporter.exportHierarchicalRelationshipRoles(Mockito.<Model>any(), Mockito.<com.hp.hpl.jena.ontology.OntModel>any()))
			.thenReturn(model2);
		Model model3 = mock(Model.class);
		when(skosGroupsExporter.exportGroups(Mockito.<Thesaurus>any(), Mockito.<Model>any(), Mockito.<com.hp.hpl.jena.ontology.OntModel>any()))
			.thenReturn(model3);
		Model model4 = mock(Model.class);
		when(skosConceptExporter.exportConceptSKOS(Mockito.<ThesaurusConcept>any(), Mockito.<ThesaurusConcept>any(), Mockito.<Model>any(), Mockito.<com.hp.hpl.jena.ontology.OntModel>any()))
			.thenReturn(model4);
		Model model5 = mock(Model.class);
		when(skosComplexConceptExporter.exportComplexConcept(Mockito.<Thesaurus>any(), Mockito.<Model>any()))
			.thenReturn(model5);
		Model model6 = mock(Model.class);
		when(skosAssociativeRelationshipRolesExporter.exportAssociativeRelationshipRoles(Mockito.<Model>any(), Mockito.<com.hp.hpl.jena.ontology.OntModel>any()))
			.thenReturn(model6);
		Model model7 = mock(Model.class);
		when(skosArrayExporter.exportCollections(Mockito.<Thesaurus>any(), Mockito.<Model>any()))
			.thenReturn(model7);
		assertTrue(service.getSKOSExport(new Thesaurus()).getPath().startsWith(System.getProperty("java.io.tmpdir")));
	}
}
