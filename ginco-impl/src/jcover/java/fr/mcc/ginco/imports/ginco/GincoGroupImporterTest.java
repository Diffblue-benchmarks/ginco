package fr.mcc.ginco.imports.ginco;

import static org.junit.Assert.assertTrue;

import fr.mcc.ginco.dao.IThesaurusConceptGroupDAO;
import fr.mcc.ginco.dao.IThesaurusConceptGroupLabelDAO;
import fr.mcc.ginco.exports.result.bean.GincoExportedThesaurus;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

/**
 * Unit tests for fr.mcc.ginco.imports.ginco.GincoGroupImporter
 *
 * @author Diffblue Cover
 */

public class GincoGroupImporterTest {

	@Mock(name = "thesaurusConceptGroupDAO")
	private IThesaurusConceptGroupDAO thesaurusConceptGroupDAO;

	@Mock(name = "thesaurusConceptGroupLabelDAO")
	private IThesaurusConceptGroupLabelDAO thesaurusConceptGroupLabelDAO;

	@InjectMocks
	private GincoGroupImporter service;

	@Before public void initMocks() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void storeGroupLabelsReturnsEmpty() {
		assertTrue((service.storeGroupLabels(new GincoExportedThesaurus())).isEmpty());
	}

	@Test
	public void storeGroupsReturnsEmpty() {
		assertTrue((service.storeGroups(new GincoExportedThesaurus())).isEmpty());
	}
}
