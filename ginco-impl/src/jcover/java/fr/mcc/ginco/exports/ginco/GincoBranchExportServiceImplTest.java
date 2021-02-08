package fr.mcc.ginco.exports.ginco;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import fr.mcc.ginco.beans.Alignment;
import fr.mcc.ginco.beans.ConceptHierarchicalRelationship;
import fr.mcc.ginco.beans.CustomConceptAttribute;
import fr.mcc.ginco.beans.CustomConceptAttributeType;
import fr.mcc.ginco.beans.CustomTermAttributeType;
import fr.mcc.ginco.beans.Note;
import fr.mcc.ginco.beans.ThesaurusConcept;
import fr.mcc.ginco.beans.ThesaurusTerm;
import fr.mcc.ginco.exports.IGincoExportServiceUtil;
import fr.mcc.ginco.exports.result.bean.GincoExportedEntity;
import fr.mcc.ginco.exports.result.bean.JaxbList;
import fr.mcc.ginco.services.ICustomConceptAttributeTypeService;
import fr.mcc.ginco.services.ICustomTermAttributeTypeService;
import fr.mcc.ginco.services.IThesaurusConceptService;
import fr.mcc.ginco.services.IThesaurusTermService;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

/**
 * Unit tests for fr.mcc.ginco.exports.ginco.GincoBranchExportServiceImpl
 *
 * @author Diffblue Cover
 */

public class GincoBranchExportServiceImplTest {

	@Mock(name = "customConceptAttributeTypeService")
	private ICustomConceptAttributeTypeService customConceptAttributeTypeService;

	@Mock(name = "customTermAttributeTypeService")
	private ICustomTermAttributeTypeService customTermAttributeTypeService;

	@Mock(name = "gincoAttributesExporter")
	private GincoAttributesExporter gincoAttributesExporter;

	@Mock(name = "gincoConceptExporter")
	private GincoConceptExporter gincoConceptExporter;

	@Mock(name = "gincoExportServiceUtil")
	private IGincoExportServiceUtil gincoExportServiceUtil;

	@Mock(name = "gincoTermExporter")
	private GincoTermExporter gincoTermExporter;

	@Mock(name = "thesaurusConceptService")
	private IThesaurusConceptService thesaurusConceptService;

	@Mock(name = "thesaurusTermService")
	private IThesaurusTermService thesaurusTermService;

	@InjectMocks
	private GincoBranchExportServiceImpl service;

	@Before
	public void initMocks() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void getBranchExportReturnsAcme() throws fr.mcc.ginco.exceptions.TechnicalException {
		ArrayList<ThesaurusTerm> thesaurusTermList2 = new ArrayList<ThesaurusTerm>();
		thesaurusTermList2.add(new ThesaurusTerm());
		when(thesaurusTermService.getTermsByConceptId(Mockito.<String>any()))
			.thenReturn(thesaurusTermList2)
			.thenReturn(new ArrayList<ThesaurusTerm>());
		ArrayList<ThesaurusConcept> thesaurusConceptList =
			 new ArrayList<ThesaurusConcept>();
		ThesaurusConcept thesaurusConcept1 = new ThesaurusConcept();
		thesaurusConcept1.setIdentifier("data");
		thesaurusConceptList.add(thesaurusConcept1);
		when(thesaurusConceptService.getRecursiveChildrenByConceptId(Mockito.<String>any()))
			.thenReturn(thesaurusConceptList);
		when(gincoTermExporter.addExportedTerms(Mockito.<GincoExportedEntity>any(), Mockito.<ThesaurusTerm>any()))
			.thenReturn(new GincoExportedEntity());
		when(gincoExportServiceUtil.serializeBranchToXmlWithJaxb(Mockito.<fr.mcc.ginco.exports.result.bean.GincoExportedBranch>any()))
			.thenReturn("Acme");
		when(gincoConceptExporter.getExportAlignments(Mockito.<ThesaurusConcept>any()))
			.thenReturn(new JaxbList<Alignment>());
		when(gincoConceptExporter.getExportConceptNotes(Mockito.<ThesaurusConcept>any()))
			.thenReturn(new JaxbList<Note>())
			.thenReturn(new JaxbList<Note>());
		when(gincoConceptExporter.getExportHierarchicalConcepts(Mockito.<ThesaurusConcept>any()))
			.thenReturn(new JaxbList<ConceptHierarchicalRelationship>());
		when(gincoAttributesExporter.getExportedConceptAttributes(Mockito.<ThesaurusConcept>any()))
			.thenReturn(new JaxbList<CustomConceptAttribute>())
			.thenReturn(new JaxbList<CustomConceptAttribute>());
		when(customTermAttributeTypeService.getAttributeTypesByThesaurus(Mockito.<fr.mcc.ginco.beans.Thesaurus>any()))
			.thenReturn(new ArrayList<CustomTermAttributeType>());
		when(customConceptAttributeTypeService.getAttributeTypesByThesaurus(Mockito.<fr.mcc.ginco.beans.Thesaurus>any()))
			.thenReturn(new ArrayList<CustomConceptAttributeType>());
		ThesaurusConcept conceptBranchToExport = new ThesaurusConcept();
		conceptBranchToExport.setIdentifier("data");
		assertEquals("Acme", service.getBranchExport(conceptBranchToExport));
	}
}
