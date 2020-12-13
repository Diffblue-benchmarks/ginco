package fr.mcc.ginco.exports.skos;

import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.hp.hpl.jena.ontology.OntClass;
import com.hp.hpl.jena.ontology.OntModel;
import com.hp.hpl.jena.rdf.model.Model;

import fr.mcc.ginco.beans.Thesaurus;
import fr.mcc.ginco.beans.ThesaurusConceptGroup;
import fr.mcc.ginco.beans.ThesaurusConceptGroupType;
import fr.mcc.ginco.services.IThesaurusConceptGroupService;
import fr.mcc.ginco.services.IThesaurusConceptGroupTypeService;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

/**
 * Unit tests for fr.mcc.ginco.exports.skos.SKOSGroupsExporter
 *
 * @author Diffblue Cover
 */

public class SKOSGroupsExporterTest {

	@Mock(name = "skosGroupExporter")
	private SKOSGroupExporter skosGroupExporter;

	@Mock(name = "skosGroupOntologyExporter")
	private SKOSGroupOntologyExporter skosGroupOntologyExporter;

	@Mock(name = "thesaurusConceptGroupService")
	private IThesaurusConceptGroupService thesaurusConceptGroupService;

	@Mock(name = "thesaurusConceptGroupTypeService")
	private IThesaurusConceptGroupTypeService thesaurusConceptGroupTypeService;

	@InjectMocks
	private SKOSGroupsExporter service;

	@Before public void initMocks() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void exportGroups1() {
		when(thesaurusConceptGroupService.getAllThesaurusConceptGroupsByThesaurusId(Mockito.<String>any(), Mockito.<String>any()))
			.thenReturn(new ArrayList<ThesaurusConceptGroup>());
		OntClass ontClass = mock(OntClass.class);
		OntModel ontModel1 = mock(OntModel.class);
		Model model = mock(Model.class);
		OntModel ontModel2 = mock(OntModel.class);
		assertSame(model, service.exportGroups(new Thesaurus(), model, ontModel2));
	}

	@Test
	public void exportGroups2() {
		ArrayList<ThesaurusConceptGroupType> arrayList1 =
			 new ArrayList<ThesaurusConceptGroupType>();
		arrayList1.add(new ThesaurusConceptGroupType());
		when(thesaurusConceptGroupTypeService.getConceptGroupTypeList())
			.thenReturn(arrayList1);
		ArrayList<ThesaurusConceptGroup> arrayList2 =
			 new ArrayList<ThesaurusConceptGroup>();
		ThesaurusConceptGroup thesaurusConceptGroup =
			 mock(ThesaurusConceptGroup.class);
		arrayList2.add(thesaurusConceptGroup);
		when(thesaurusConceptGroupService.getAllThesaurusConceptGroupsByThesaurusId(Mockito.<String>any(), Mockito.<String>any()))
			.thenReturn(arrayList2);
		OntClass ontClass = mock(OntClass.class);
		OntModel ontModel1 = mock(OntModel.class);
		when(skosGroupOntologyExporter.addGroupTypeToOntModel(Mockito.<OntModel>any(), Mockito.<String>any()))
			.thenReturn(ontClass);
		when(skosGroupOntologyExporter.buildGroupOntologyModel(Mockito.<OntModel>any()))
			.thenReturn(ontModel1);
		Model model = mock(Model.class);
		OntModel ontModel2 = mock(OntModel.class);
		assertSame(model, service.exportGroups(new Thesaurus(), model, ontModel2));
		Mockito.verify(skosGroupExporter).exportGroup(Mockito.<Thesaurus>any(), Mockito.<ThesaurusConceptGroup>any(), Mockito.<Model>any());
	}
}
