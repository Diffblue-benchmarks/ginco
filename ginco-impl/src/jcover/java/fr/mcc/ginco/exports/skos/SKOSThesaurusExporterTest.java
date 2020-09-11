package fr.mcc.ginco.exports.skos;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.when;

import com.hp.hpl.jena.rdf.model.Model;

import fr.mcc.ginco.beans.Thesaurus;
import fr.mcc.ginco.beans.ThesaurusOrganization;
import fr.mcc.ginco.beans.ThesaurusType;
import fr.mcc.ginco.beans.ThesaurusVersionHistory;
import fr.mcc.ginco.dao.IThesaurusVersionHistoryDAO;

import java.text.SimpleDateFormat;

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
	public void exportThesaurusSKOSModelIsEmpty() throws java.text.ParseException {
		ThesaurusVersionHistory thesaurusVersionHistory =
			 new ThesaurusVersionHistory();
		thesaurusVersionHistory.setVersionNote("1.0");
		when(thesaurusVersionHistoryDAO.findThisVersionByThesaurusId(Mockito.<String>any()))
			.thenReturn(thesaurusVersionHistory);
		Thesaurus thesaurus2 = new Thesaurus();
		thesaurus2.setContributor("foo");
		thesaurus2.setCoverage("foo");
		thesaurus2.setCreated(new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31"));
		ThesaurusOrganization creator3 = new ThesaurusOrganization();
		creator3.setEmail("info@diffblue.com");
		creator3.setHomepage("foo");
		creator3.setName("Acme");
		thesaurus2.setCreator(creator3);
		thesaurus2.setDate(new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31"));
		thesaurus2.setDescription("some text");
		thesaurus2.setPublisher("foo");
		thesaurus2.setRelation("DE");
		thesaurus2.setRights("foo");
		thesaurus2.setSubject("foo");
		thesaurus2.setTitle("Mr");
		ThesaurusType type3 = new ThesaurusType();
		type3.setLabel("label");
		thesaurus2.setType(type3);
		Model model = com.hp.hpl.jena.rdf.model.ModelFactory.createDefaultModel();
		assertSame(model, service.exportThesaurusSKOS(thesaurus2, model));
		assertFalse(model.isEmpty());
	}
}
