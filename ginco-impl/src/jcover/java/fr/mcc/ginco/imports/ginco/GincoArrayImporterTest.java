package fr.mcc.ginco.imports.ginco;

import static org.junit.Assert.assertTrue;

import fr.mcc.ginco.dao.INodeLabelDAO;
import fr.mcc.ginco.dao.IThesaurusArrayDAO;
import fr.mcc.ginco.exports.result.bean.GincoExportedThesaurus;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

/**
 * Unit tests for fr.mcc.ginco.imports.ginco.GincoArrayImporter
 *
 * @author Diffblue Cover
 */

public class GincoArrayImporterTest {

	@Mock(name = "nodeLabelDAO")
	private INodeLabelDAO nodeLabelDAO;

	@Mock(name = "thesaurusArrayDAO")
	private IThesaurusArrayDAO thesaurusArrayDAO;

	@InjectMocks
	private GincoArrayImporter service;

	@Before public void initMocks() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void storeArrayLabelsReturnsEmpty() {
		assertTrue((service.storeArrayLabels(new GincoExportedThesaurus())).isEmpty());
	}
}
