package fr.mcc.ginco.imports.ginco;

import static org.junit.Assert.assertTrue;

import fr.mcc.ginco.beans.CustomTermAttributeType;
import fr.mcc.ginco.beans.Thesaurus;
import fr.mcc.ginco.dao.INoteDAO;
import fr.mcc.ginco.dao.IThesaurusTermDAO;
import fr.mcc.ginco.exports.result.bean.GincoExportedEntity;

import java.util.HashMap;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

/**
 * Unit tests for fr.mcc.ginco.imports.ginco.GincoTermImporter
 *
 * @author Diffblue Cover
 */

public class GincoTermImporterTest {

	@Mock(name = "gincoCustomAttributeImporter")
	private GincoCustomAttributeImporter gincoCustomAttributeImporter;

	@Mock(name = "noteDAO")
	private INoteDAO noteDAO;

	@Mock(name = "thesaurusTermDAO")
	private IThesaurusTermDAO thesaurusTermDAO;

	@InjectMocks
	private GincoTermImporter service;

	@Before public void initMocks() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void storeTermsSavedTypesIsEmptyReturnsEmpty() {
		assertTrue((service.storeTerms(new GincoExportedEntity(), new Thesaurus(), new HashMap<String, CustomTermAttributeType>())).isEmpty());
	}

	@Test
	public void storeTermNotesTermNotesToImportIsNullReturnsEmpty() {
		assertTrue((service.storeTermNotes(null)).isEmpty());
	}
}
