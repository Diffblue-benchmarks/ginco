package fr.mcc.ginco.exports.skos;

import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.Resource;

import fr.mcc.ginco.beans.Thesaurus;
import fr.mcc.ginco.beans.ThesaurusOrganization;
import fr.mcc.ginco.beans.ThesaurusType;
import fr.mcc.ginco.beans.ThesaurusVersionHistory;
import fr.mcc.ginco.dao.IThesaurusVersionHistoryDAO;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

/**
 * Unit tests for fr.mcc.ginco.exports.skos.SKOSThesaurusExporter
 *
 * @author Diffblue Cover
 */

public class SKOSThesaurusExporterTest {

	@Mock(name = "thesaurusVersionHistoryDAO")
	private IThesaurusVersionHistoryDAO thesaurusVersionHistoryDAO;

	@InjectMocks
	private SKOSThesaurusExporter service;

	@Before public void initMocks() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void exportThesaurusSKOS1() {
		ThesaurusVersionHistory thesaurusVersionHistory =
			 new ThesaurusVersionHistory();
		thesaurusVersionHistory.setVersionNote("1.0");
		when(thesaurusVersionHistoryDAO.findThisVersionByThesaurusId(Mockito.<String>any()))
			.thenReturn(thesaurusVersionHistory);
		Thesaurus thesaurus2 = new Thesaurus();
		thesaurus2.setContributor("foo");
		thesaurus2.setCoverage("foo");
		ThesaurusOrganization creator2 = new ThesaurusOrganization();
		creator2.setEmail("info@diffblue.com");
		creator2.setHomepage("foo");
		creator2.setName("Acme");
		thesaurus2.setCreator(creator2);
		thesaurus2.setRights("foo");
		thesaurus2.setSubject("foo");
		thesaurus2.setType(new ThesaurusType());
		Model model1 = mock(Model.class);
		Model model2 = mock(Model.class);
		Model model3 = mock(Model.class);
		Model model4 = mock(Model.class);
		Model model5 = mock(Model.class);
		Model model6 = mock(Model.class);
		Model model7 = mock(Model.class);
		Model model8 = mock(Model.class);
		Model model9 = mock(Model.class);
		Model model10 = mock(Model.class);
		Resource resource1 = mock(Resource.class);
		Resource resource2 = mock(Resource.class);
		Resource resource3 = mock(Resource.class);
		Resource resource4 = mock(Resource.class);
		when(resource4.addProperty(Mockito.<com.hp.hpl.jena.rdf.model.Property>any(), Mockito.<String>any()))
			.thenReturn(resource3)
			.thenReturn(resource2)
			.thenReturn(resource1);
		Model model11 = mock(Model.class);
		Model model12 = mock(Model.class);
		Model model13 = mock(Model.class);
		Resource resource5 = mock(Resource.class);
		Resource resource6 = mock(Resource.class);
		when(resource6.addProperty(Mockito.<com.hp.hpl.jena.rdf.model.Property>any(), Mockito.<com.hp.hpl.jena.rdf.model.RDFNode>any()))
			.thenReturn(resource5);
		Model model14 = mock(Model.class);
		when(model14.add(Mockito.<Resource>any(), Mockito.<com.hp.hpl.jena.rdf.model.Property>any(), Mockito.<String>any()))
			.thenReturn(model13)
			.thenReturn(model12)
			.thenReturn(model11)
			.thenReturn(model10)
			.thenReturn(model9)
			.thenReturn(model8)
			.thenReturn(model7)
			.thenReturn(model6)
			.thenReturn(model5)
			.thenReturn(model4)
			.thenReturn(model3)
			.thenReturn(model2)
			.thenReturn(model1);
		when(model14.createResource(Mockito.<Resource>any()))
			.thenReturn(resource4);
		when(model14.createResource(Mockito.<String>any(), Mockito.<Resource>any()))
			.thenReturn(resource6);
		assertSame(model14, service.exportThesaurusSKOS(thesaurus2, model14));
	}

	@Test
	public void exportThesaurusSKOS10() {
		ThesaurusVersionHistory thesaurusVersionHistory =
			 new ThesaurusVersionHistory();
		thesaurusVersionHistory.setVersionNote("1.0");
		when(thesaurusVersionHistoryDAO.findThisVersionByThesaurusId(Mockito.<String>any()))
			.thenReturn(thesaurusVersionHistory);
		Thesaurus thesaurus2 = new Thesaurus();
		thesaurus2.setContributor("foo");
		thesaurus2.setCoverage("foo");
		ThesaurusOrganization creator3 = new ThesaurusOrganization();
		creator3.setEmail("info@diffblue.com");
		creator3.setHomepage("foo");
		creator3.setName("Acme");
		thesaurus2.setCreator(creator3);
		thesaurus2.setRights("foo");
		thesaurus2.setSubject("foo");
		Model model1 = mock(Model.class);
		Model model2 = mock(Model.class);
		Model model3 = mock(Model.class);
		Model model4 = mock(Model.class);
		Model model5 = mock(Model.class);
		Model model6 = mock(Model.class);
		Model model7 = mock(Model.class);
		Model model8 = mock(Model.class);
		Model model9 = mock(Model.class);
		Model model10 = mock(Model.class);
		Resource resource1 = mock(Resource.class);
		Resource resource2 = mock(Resource.class);
		Resource resource3 = mock(Resource.class);
		Resource resource4 = mock(Resource.class);
		when(resource4.addProperty(Mockito.<com.hp.hpl.jena.rdf.model.Property>any(), Mockito.<String>any()))
			.thenReturn(resource3)
			.thenReturn(resource2)
			.thenReturn(resource1);
		Model model11 = mock(Model.class);
		Model model12 = mock(Model.class);
		Model model13 = mock(Model.class);
		Resource resource5 = mock(Resource.class);
		Resource resource6 = mock(Resource.class);
		when(resource6.addProperty(Mockito.<com.hp.hpl.jena.rdf.model.Property>any(), Mockito.<com.hp.hpl.jena.rdf.model.RDFNode>any()))
			.thenReturn(resource5);
		Model model14 = mock(Model.class);
		when(model14.add(Mockito.<Resource>any(), Mockito.<com.hp.hpl.jena.rdf.model.Property>any(), Mockito.<String>any()))
			.thenReturn(model13)
			.thenReturn(model12)
			.thenReturn(model11)
			.thenReturn(model10)
			.thenReturn(model9)
			.thenReturn(model8)
			.thenReturn(model7)
			.thenReturn(model6)
			.thenReturn(model5)
			.thenReturn(model4)
			.thenReturn(model3)
			.thenReturn(model2);
		when(model14.createResource(Mockito.<Resource>any()))
			.thenReturn(resource4);
		when(model14.createResource(Mockito.<String>any(), Mockito.<Resource>any()))
			.thenReturn(resource6);
		assertSame(model14, service.exportThesaurusSKOS(thesaurus2, model14));
	}

	@Test
	public void exportThesaurusSKOS2() {
		when(thesaurusVersionHistoryDAO.findThisVersionByThesaurusId(Mockito.<String>any()))
			.thenReturn(new ThesaurusVersionHistory());
		Thesaurus thesaurus2 = new Thesaurus();
		thesaurus2.setContributor("foo");
		thesaurus2.setCoverage("foo");
		ThesaurusOrganization creator3 = new ThesaurusOrganization();
		creator3.setEmail("info@diffblue.com");
		creator3.setHomepage("foo");
		creator3.setName("Acme");
		thesaurus2.setCreator(creator3);
		thesaurus2.setRights("foo");
		thesaurus2.setSubject("foo");
		thesaurus2.setType(new ThesaurusType());
		Model model1 = mock(Model.class);
		Model model2 = mock(Model.class);
		Model model3 = mock(Model.class);
		Model model4 = mock(Model.class);
		Model model5 = mock(Model.class);
		Model model6 = mock(Model.class);
		Model model7 = mock(Model.class);
		Model model8 = mock(Model.class);
		Model model9 = mock(Model.class);
		Model model10 = mock(Model.class);
		Resource resource1 = mock(Resource.class);
		Resource resource2 = mock(Resource.class);
		Resource resource3 = mock(Resource.class);
		Resource resource4 = mock(Resource.class);
		when(resource4.addProperty(Mockito.<com.hp.hpl.jena.rdf.model.Property>any(), Mockito.<String>any()))
			.thenReturn(resource3)
			.thenReturn(resource2)
			.thenReturn(resource1);
		Model model11 = mock(Model.class);
		Model model12 = mock(Model.class);
		Model model13 = mock(Model.class);
		Resource resource5 = mock(Resource.class);
		Resource resource6 = mock(Resource.class);
		when(resource6.addProperty(Mockito.<com.hp.hpl.jena.rdf.model.Property>any(), Mockito.<com.hp.hpl.jena.rdf.model.RDFNode>any()))
			.thenReturn(resource5);
		Model model14 = mock(Model.class);
		when(model14.add(Mockito.<Resource>any(), Mockito.<com.hp.hpl.jena.rdf.model.Property>any(), Mockito.<String>any()))
			.thenReturn(model13)
			.thenReturn(model12)
			.thenReturn(model11)
			.thenReturn(model10)
			.thenReturn(model9)
			.thenReturn(model8)
			.thenReturn(model7)
			.thenReturn(model6)
			.thenReturn(model5)
			.thenReturn(model4)
			.thenReturn(model3)
			.thenReturn(model2);
		when(model14.createResource(Mockito.<Resource>any()))
			.thenReturn(resource4);
		when(model14.createResource(Mockito.<String>any(), Mockito.<Resource>any()))
			.thenReturn(resource6);
		assertSame(model14, service.exportThesaurusSKOS(thesaurus2, model14));
	}

	@Test
	public void exportThesaurusSKOS3() {
		ThesaurusVersionHistory thesaurusVersionHistory =
			 new ThesaurusVersionHistory();
		thesaurusVersionHistory.setVersionNote("1.0");
		when(thesaurusVersionHistoryDAO.findThisVersionByThesaurusId(Mockito.<String>any()))
			.thenReturn(thesaurusVersionHistory);
		Thesaurus thesaurus2 = new Thesaurus();
		thesaurus2.setContributor("foo");
		thesaurus2.setCoverage("foo");
		thesaurus2.setRights("foo");
		thesaurus2.setSubject("foo");
		thesaurus2.setType(new ThesaurusType());
		Model model1 = mock(Model.class);
		Model model2 = mock(Model.class);
		Model model3 = mock(Model.class);
		Model model4 = mock(Model.class);
		Model model5 = mock(Model.class);
		Model model6 = mock(Model.class);
		Model model7 = mock(Model.class);
		Model model8 = mock(Model.class);
		Model model9 = mock(Model.class);
		Model model10 = mock(Model.class);
		Resource resource1 = mock(Resource.class);
		Resource resource2 = mock(Resource.class);
		Resource resource3 = mock(Resource.class);
		Resource resource4 = mock(Resource.class);
		Model model11 = mock(Model.class);
		Model model12 = mock(Model.class);
		Model model13 = mock(Model.class);
		Resource resource5 = mock(Resource.class);
		Resource resource6 = mock(Resource.class);
		Model model14 = mock(Model.class);
		when(model14.add(Mockito.<Resource>any(), Mockito.<com.hp.hpl.jena.rdf.model.Property>any(), Mockito.<String>any()))
			.thenReturn(model13)
			.thenReturn(model12)
			.thenReturn(model11)
			.thenReturn(model10)
			.thenReturn(model9)
			.thenReturn(model8)
			.thenReturn(model7)
			.thenReturn(model6)
			.thenReturn(model5)
			.thenReturn(model4)
			.thenReturn(model3)
			.thenReturn(model2)
			.thenReturn(model1);
		when(model14.createResource(Mockito.<String>any(), Mockito.<Resource>any()))
			.thenReturn(resource6);
		assertSame(model14, service.exportThesaurusSKOS(thesaurus2, model14));
	}

	@Test
	public void exportThesaurusSKOS4() {
		ThesaurusVersionHistory thesaurusVersionHistory =
			 new ThesaurusVersionHistory();
		thesaurusVersionHistory.setVersionNote("1.0");
		when(thesaurusVersionHistoryDAO.findThisVersionByThesaurusId(Mockito.<String>any()))
			.thenReturn(thesaurusVersionHistory);
		Thesaurus thesaurus2 = new Thesaurus();
		thesaurus2.setContributor("foo");
		thesaurus2.setCoverage("foo");
		ThesaurusOrganization creator3 = new ThesaurusOrganization();
		creator3.setHomepage("foo");
		creator3.setName("Acme");
		thesaurus2.setCreator(creator3);
		thesaurus2.setRights("foo");
		thesaurus2.setSubject("foo");
		thesaurus2.setType(new ThesaurusType());
		Model model1 = mock(Model.class);
		Model model2 = mock(Model.class);
		Model model3 = mock(Model.class);
		Model model4 = mock(Model.class);
		Model model5 = mock(Model.class);
		Model model6 = mock(Model.class);
		Model model7 = mock(Model.class);
		Model model8 = mock(Model.class);
		Model model9 = mock(Model.class);
		Model model10 = mock(Model.class);
		Resource resource1 = mock(Resource.class);
		Resource resource2 = mock(Resource.class);
		Resource resource3 = mock(Resource.class);
		Resource resource4 = mock(Resource.class);
		when(resource4.addProperty(Mockito.<com.hp.hpl.jena.rdf.model.Property>any(), Mockito.<String>any()))
			.thenReturn(resource3)
			.thenReturn(resource2);
		Model model11 = mock(Model.class);
		Model model12 = mock(Model.class);
		Model model13 = mock(Model.class);
		Resource resource5 = mock(Resource.class);
		Resource resource6 = mock(Resource.class);
		when(resource6.addProperty(Mockito.<com.hp.hpl.jena.rdf.model.Property>any(), Mockito.<com.hp.hpl.jena.rdf.model.RDFNode>any()))
			.thenReturn(resource5);
		Model model14 = mock(Model.class);
		when(model14.add(Mockito.<Resource>any(), Mockito.<com.hp.hpl.jena.rdf.model.Property>any(), Mockito.<String>any()))
			.thenReturn(model13)
			.thenReturn(model12)
			.thenReturn(model11)
			.thenReturn(model10)
			.thenReturn(model9)
			.thenReturn(model8)
			.thenReturn(model7)
			.thenReturn(model6)
			.thenReturn(model5)
			.thenReturn(model4)
			.thenReturn(model3)
			.thenReturn(model2)
			.thenReturn(model1);
		when(model14.createResource(Mockito.<Resource>any()))
			.thenReturn(resource4);
		when(model14.createResource(Mockito.<String>any(), Mockito.<Resource>any()))
			.thenReturn(resource6);
		assertSame(model14, service.exportThesaurusSKOS(thesaurus2, model14));
	}

	@Test
	public void exportThesaurusSKOS5() {
		ThesaurusVersionHistory thesaurusVersionHistory =
			 new ThesaurusVersionHistory();
		thesaurusVersionHistory.setVersionNote("1.0");
		when(thesaurusVersionHistoryDAO.findThisVersionByThesaurusId(Mockito.<String>any()))
			.thenReturn(thesaurusVersionHistory);
		Thesaurus thesaurus2 = new Thesaurus();
		thesaurus2.setContributor("foo");
		thesaurus2.setCoverage("foo");
		ThesaurusOrganization creator3 = new ThesaurusOrganization();
		creator3.setEmail("");
		creator3.setHomepage("foo");
		creator3.setName("Acme");
		thesaurus2.setCreator(creator3);
		thesaurus2.setRights("foo");
		thesaurus2.setSubject("foo");
		thesaurus2.setType(new ThesaurusType());
		Model model1 = mock(Model.class);
		Model model2 = mock(Model.class);
		Model model3 = mock(Model.class);
		Model model4 = mock(Model.class);
		Model model5 = mock(Model.class);
		Model model6 = mock(Model.class);
		Model model7 = mock(Model.class);
		Model model8 = mock(Model.class);
		Model model9 = mock(Model.class);
		Model model10 = mock(Model.class);
		Resource resource1 = mock(Resource.class);
		Resource resource2 = mock(Resource.class);
		Resource resource3 = mock(Resource.class);
		Resource resource4 = mock(Resource.class);
		when(resource4.addProperty(Mockito.<com.hp.hpl.jena.rdf.model.Property>any(), Mockito.<String>any()))
			.thenReturn(resource3)
			.thenReturn(resource2);
		Model model11 = mock(Model.class);
		Model model12 = mock(Model.class);
		Model model13 = mock(Model.class);
		Resource resource5 = mock(Resource.class);
		Resource resource6 = mock(Resource.class);
		when(resource6.addProperty(Mockito.<com.hp.hpl.jena.rdf.model.Property>any(), Mockito.<com.hp.hpl.jena.rdf.model.RDFNode>any()))
			.thenReturn(resource5);
		Model model14 = mock(Model.class);
		when(model14.add(Mockito.<Resource>any(), Mockito.<com.hp.hpl.jena.rdf.model.Property>any(), Mockito.<String>any()))
			.thenReturn(model13)
			.thenReturn(model12)
			.thenReturn(model11)
			.thenReturn(model10)
			.thenReturn(model9)
			.thenReturn(model8)
			.thenReturn(model7)
			.thenReturn(model6)
			.thenReturn(model5)
			.thenReturn(model4)
			.thenReturn(model3)
			.thenReturn(model2)
			.thenReturn(model1);
		when(model14.createResource(Mockito.<Resource>any()))
			.thenReturn(resource4);
		when(model14.createResource(Mockito.<String>any(), Mockito.<Resource>any()))
			.thenReturn(resource6);
		assertSame(model14, service.exportThesaurusSKOS(thesaurus2, model14));
	}

	@Test
	public void exportThesaurusSKOS6() {
		ThesaurusVersionHistory thesaurusVersionHistory =
			 new ThesaurusVersionHistory();
		thesaurusVersionHistory.setVersionNote("1.0");
		when(thesaurusVersionHistoryDAO.findThisVersionByThesaurusId(Mockito.<String>any()))
			.thenReturn(thesaurusVersionHistory);
		Thesaurus thesaurus2 = new Thesaurus();
		thesaurus2.setContributor("foo");
		thesaurus2.setCoverage("foo");
		ThesaurusOrganization creator3 = new ThesaurusOrganization();
		creator3.setEmail("info@diffblue.com");
		creator3.setName("Acme");
		thesaurus2.setCreator(creator3);
		thesaurus2.setRights("foo");
		thesaurus2.setSubject("foo");
		thesaurus2.setType(new ThesaurusType());
		Model model1 = mock(Model.class);
		Model model2 = mock(Model.class);
		Model model3 = mock(Model.class);
		Model model4 = mock(Model.class);
		Model model5 = mock(Model.class);
		Model model6 = mock(Model.class);
		Model model7 = mock(Model.class);
		Model model8 = mock(Model.class);
		Model model9 = mock(Model.class);
		Model model10 = mock(Model.class);
		Resource resource1 = mock(Resource.class);
		Resource resource2 = mock(Resource.class);
		Resource resource3 = mock(Resource.class);
		Resource resource4 = mock(Resource.class);
		when(resource4.addProperty(Mockito.<com.hp.hpl.jena.rdf.model.Property>any(), Mockito.<String>any()))
			.thenReturn(resource3)
			.thenReturn(resource2);
		Model model11 = mock(Model.class);
		Model model12 = mock(Model.class);
		Model model13 = mock(Model.class);
		Resource resource5 = mock(Resource.class);
		Resource resource6 = mock(Resource.class);
		when(resource6.addProperty(Mockito.<com.hp.hpl.jena.rdf.model.Property>any(), Mockito.<com.hp.hpl.jena.rdf.model.RDFNode>any()))
			.thenReturn(resource5);
		Model model14 = mock(Model.class);
		when(model14.add(Mockito.<Resource>any(), Mockito.<com.hp.hpl.jena.rdf.model.Property>any(), Mockito.<String>any()))
			.thenReturn(model13)
			.thenReturn(model12)
			.thenReturn(model11)
			.thenReturn(model10)
			.thenReturn(model9)
			.thenReturn(model8)
			.thenReturn(model7)
			.thenReturn(model6)
			.thenReturn(model5)
			.thenReturn(model4)
			.thenReturn(model3)
			.thenReturn(model2)
			.thenReturn(model1);
		when(model14.createResource(Mockito.<Resource>any()))
			.thenReturn(resource4);
		when(model14.createResource(Mockito.<String>any(), Mockito.<Resource>any()))
			.thenReturn(resource6);
		assertSame(model14, service.exportThesaurusSKOS(thesaurus2, model14));
	}

	@Test
	public void exportThesaurusSKOS7() {
		ThesaurusVersionHistory thesaurusVersionHistory =
			 new ThesaurusVersionHistory();
		thesaurusVersionHistory.setVersionNote("1.0");
		when(thesaurusVersionHistoryDAO.findThisVersionByThesaurusId(Mockito.<String>any()))
			.thenReturn(thesaurusVersionHistory);
		Thesaurus thesaurus2 = new Thesaurus();
		thesaurus2.setContributor("foo");
		thesaurus2.setCoverage("foo");
		ThesaurusOrganization creator3 = new ThesaurusOrganization();
		creator3.setEmail("info@diffblue.com");
		creator3.setHomepage("");
		creator3.setName("Acme");
		thesaurus2.setCreator(creator3);
		thesaurus2.setRights("foo");
		thesaurus2.setSubject("foo");
		thesaurus2.setType(new ThesaurusType());
		Model model1 = mock(Model.class);
		Model model2 = mock(Model.class);
		Model model3 = mock(Model.class);
		Model model4 = mock(Model.class);
		Model model5 = mock(Model.class);
		Model model6 = mock(Model.class);
		Model model7 = mock(Model.class);
		Model model8 = mock(Model.class);
		Model model9 = mock(Model.class);
		Model model10 = mock(Model.class);
		Resource resource1 = mock(Resource.class);
		Resource resource2 = mock(Resource.class);
		Resource resource3 = mock(Resource.class);
		Resource resource4 = mock(Resource.class);
		when(resource4.addProperty(Mockito.<com.hp.hpl.jena.rdf.model.Property>any(), Mockito.<String>any()))
			.thenReturn(resource3)
			.thenReturn(resource2);
		Model model11 = mock(Model.class);
		Model model12 = mock(Model.class);
		Model model13 = mock(Model.class);
		Resource resource5 = mock(Resource.class);
		Resource resource6 = mock(Resource.class);
		when(resource6.addProperty(Mockito.<com.hp.hpl.jena.rdf.model.Property>any(), Mockito.<com.hp.hpl.jena.rdf.model.RDFNode>any()))
			.thenReturn(resource5);
		Model model14 = mock(Model.class);
		when(model14.add(Mockito.<Resource>any(), Mockito.<com.hp.hpl.jena.rdf.model.Property>any(), Mockito.<String>any()))
			.thenReturn(model13)
			.thenReturn(model12)
			.thenReturn(model11)
			.thenReturn(model10)
			.thenReturn(model9)
			.thenReturn(model8)
			.thenReturn(model7)
			.thenReturn(model6)
			.thenReturn(model5)
			.thenReturn(model4)
			.thenReturn(model3)
			.thenReturn(model2)
			.thenReturn(model1);
		when(model14.createResource(Mockito.<Resource>any()))
			.thenReturn(resource4);
		when(model14.createResource(Mockito.<String>any(), Mockito.<Resource>any()))
			.thenReturn(resource6);
		assertSame(model14, service.exportThesaurusSKOS(thesaurus2, model14));
	}

	@Test
	public void exportThesaurusSKOS8() {
		ThesaurusVersionHistory thesaurusVersionHistory =
			 new ThesaurusVersionHistory();
		thesaurusVersionHistory.setVersionNote("1.0");
		when(thesaurusVersionHistoryDAO.findThisVersionByThesaurusId(Mockito.<String>any()))
			.thenReturn(thesaurusVersionHistory);
		Thesaurus thesaurus2 = new Thesaurus();
		thesaurus2.setContributor("foo");
		thesaurus2.setCoverage("foo");
		ThesaurusOrganization creator3 = new ThesaurusOrganization();
		creator3.setEmail("info@diffblue.com");
		creator3.setHomepage("foo");
		thesaurus2.setCreator(creator3);
		thesaurus2.setRights("foo");
		thesaurus2.setSubject("foo");
		thesaurus2.setType(new ThesaurusType());
		Model model1 = mock(Model.class);
		Model model2 = mock(Model.class);
		Model model3 = mock(Model.class);
		Model model4 = mock(Model.class);
		Model model5 = mock(Model.class);
		Model model6 = mock(Model.class);
		Model model7 = mock(Model.class);
		Model model8 = mock(Model.class);
		Model model9 = mock(Model.class);
		Model model10 = mock(Model.class);
		Resource resource1 = mock(Resource.class);
		Resource resource2 = mock(Resource.class);
		Resource resource3 = mock(Resource.class);
		Resource resource4 = mock(Resource.class);
		when(resource4.addProperty(Mockito.<com.hp.hpl.jena.rdf.model.Property>any(), Mockito.<String>any()))
			.thenReturn(resource3)
			.thenReturn(resource2);
		Model model11 = mock(Model.class);
		Model model12 = mock(Model.class);
		Model model13 = mock(Model.class);
		Resource resource5 = mock(Resource.class);
		Resource resource6 = mock(Resource.class);
		when(resource6.addProperty(Mockito.<com.hp.hpl.jena.rdf.model.Property>any(), Mockito.<com.hp.hpl.jena.rdf.model.RDFNode>any()))
			.thenReturn(resource5);
		Model model14 = mock(Model.class);
		when(model14.add(Mockito.<Resource>any(), Mockito.<com.hp.hpl.jena.rdf.model.Property>any(), Mockito.<String>any()))
			.thenReturn(model13)
			.thenReturn(model12)
			.thenReturn(model11)
			.thenReturn(model10)
			.thenReturn(model9)
			.thenReturn(model8)
			.thenReturn(model7)
			.thenReturn(model6)
			.thenReturn(model5)
			.thenReturn(model4)
			.thenReturn(model3)
			.thenReturn(model2)
			.thenReturn(model1);
		when(model14.createResource(Mockito.<Resource>any()))
			.thenReturn(resource4);
		when(model14.createResource(Mockito.<String>any(), Mockito.<Resource>any()))
			.thenReturn(resource6);
		assertSame(model14, service.exportThesaurusSKOS(thesaurus2, model14));
	}

	@Test
	public void exportThesaurusSKOS9() {
		ThesaurusVersionHistory thesaurusVersionHistory =
			 new ThesaurusVersionHistory();
		thesaurusVersionHistory.setVersionNote("1.0");
		when(thesaurusVersionHistoryDAO.findThisVersionByThesaurusId(Mockito.<String>any()))
			.thenReturn(thesaurusVersionHistory);
		Thesaurus thesaurus2 = new Thesaurus();
		thesaurus2.setContributor("foo");
		thesaurus2.setCoverage("foo");
		ThesaurusOrganization creator3 = new ThesaurusOrganization();
		creator3.setEmail("info@diffblue.com");
		creator3.setHomepage("foo");
		creator3.setName("");
		thesaurus2.setCreator(creator3);
		thesaurus2.setRights("foo");
		thesaurus2.setSubject("foo");
		thesaurus2.setType(new ThesaurusType());
		Model model1 = mock(Model.class);
		Model model2 = mock(Model.class);
		Model model3 = mock(Model.class);
		Model model4 = mock(Model.class);
		Model model5 = mock(Model.class);
		Model model6 = mock(Model.class);
		Model model7 = mock(Model.class);
		Model model8 = mock(Model.class);
		Model model9 = mock(Model.class);
		Model model10 = mock(Model.class);
		Resource resource1 = mock(Resource.class);
		Resource resource2 = mock(Resource.class);
		Resource resource3 = mock(Resource.class);
		Resource resource4 = mock(Resource.class);
		when(resource4.addProperty(Mockito.<com.hp.hpl.jena.rdf.model.Property>any(), Mockito.<String>any()))
			.thenReturn(resource3)
			.thenReturn(resource2);
		Model model11 = mock(Model.class);
		Model model12 = mock(Model.class);
		Model model13 = mock(Model.class);
		Resource resource5 = mock(Resource.class);
		Resource resource6 = mock(Resource.class);
		when(resource6.addProperty(Mockito.<com.hp.hpl.jena.rdf.model.Property>any(), Mockito.<com.hp.hpl.jena.rdf.model.RDFNode>any()))
			.thenReturn(resource5);
		Model model14 = mock(Model.class);
		when(model14.add(Mockito.<Resource>any(), Mockito.<com.hp.hpl.jena.rdf.model.Property>any(), Mockito.<String>any()))
			.thenReturn(model13)
			.thenReturn(model12)
			.thenReturn(model11)
			.thenReturn(model10)
			.thenReturn(model9)
			.thenReturn(model8)
			.thenReturn(model7)
			.thenReturn(model6)
			.thenReturn(model5)
			.thenReturn(model4)
			.thenReturn(model3)
			.thenReturn(model2)
			.thenReturn(model1);
		when(model14.createResource(Mockito.<Resource>any()))
			.thenReturn(resource4);
		when(model14.createResource(Mockito.<String>any(), Mockito.<Resource>any()))
			.thenReturn(resource6);
		assertSame(model14, service.exportThesaurusSKOS(thesaurus2, model14));
	}
}
