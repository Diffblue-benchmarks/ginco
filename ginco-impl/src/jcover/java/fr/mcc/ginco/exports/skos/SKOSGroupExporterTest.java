package fr.mcc.ginco.exports.skos;

import static org.junit.Assert.assertFalse;
import static org.mockito.Mockito.when;

import com.hp.hpl.jena.rdf.model.Model;

import fr.mcc.ginco.beans.Language;
import fr.mcc.ginco.beans.Thesaurus;
import fr.mcc.ginco.beans.ThesaurusConcept;
import fr.mcc.ginco.beans.ThesaurusConceptGroup;
import fr.mcc.ginco.beans.ThesaurusConceptGroupLabel;
import fr.mcc.ginco.beans.ThesaurusConceptGroupType;
import fr.mcc.ginco.services.IThesaurusConceptGroupLabelService;
import fr.mcc.ginco.services.IThesaurusConceptGroupService;
import fr.mcc.ginco.services.IThesaurusConceptService;

import java.text.SimpleDateFormat;
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

	@Before public void initMocks() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void exportGroupModelIsEmpty() throws java.text.ParseException {

		// arrange
		when(thesaurusConceptGroupService.getChildGroups(Mockito.<String>any()))
			.thenReturn(new ArrayList<ThesaurusConceptGroup>());
		ThesaurusConceptGroupLabel thesaurusConceptGroupLabel =
			 new ThesaurusConceptGroupLabel();
		thesaurusConceptGroupLabel.setCreated(new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31"));
		thesaurusConceptGroupLabel.setLanguage(new Language());
		thesaurusConceptGroupLabel.setLexicalValue("value");
		thesaurusConceptGroupLabel.setModified(new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31"));
		when(thesaurusConceptGroupLabelService.getByThesaurusConceptGroup(Mockito.<String>any()))
			.thenReturn(thesaurusConceptGroupLabel);
		ThesaurusConceptGroup group = new ThesaurusConceptGroup();
		group.setConceptGroupType(new ThesaurusConceptGroupType());
		group.setConcepts(new HashSet<ThesaurusConcept>());
		group.setIsDynamic(false);
		group.setNotation("DE");
		Model model = com.hp.hpl.jena.rdf.model.ModelFactory.createDefaultModel();

		// act
		service.exportGroup(new Thesaurus(), group, model);

		// assert
		assertFalse(model.isEmpty());
	}
}
