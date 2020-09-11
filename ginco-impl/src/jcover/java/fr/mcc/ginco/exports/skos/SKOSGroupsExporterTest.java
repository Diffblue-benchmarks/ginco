package fr.mcc.ginco.exports.skos;

import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.hp.hpl.jena.ontology.OntModel;
import com.hp.hpl.jena.rdf.model.Model;

import fr.mcc.ginco.beans.Thesaurus;
import fr.mcc.ginco.beans.ThesaurusConceptGroup;
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
	public void exportGroups() {
		when(thesaurusConceptGroupService.getAllThesaurusConceptGroupsByThesaurusId(Mockito.<String>any(), Mockito.<String>any()))
			.thenReturn(new ArrayList<ThesaurusConceptGroup>());
		Model model = mock(Model.class);
		OntModel ontModel = mock(OntModel.class);
		assertSame(model, service.exportGroups(new Thesaurus(), model, ontModel));
	}
}
