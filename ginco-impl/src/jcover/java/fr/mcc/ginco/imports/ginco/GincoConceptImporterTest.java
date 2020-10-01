package fr.mcc.ginco.imports.ginco;

import static org.junit.Assert.assertTrue;

import fr.mcc.ginco.beans.CustomConceptAttributeType;
import fr.mcc.ginco.beans.SplitNonPreferredTerm;
import fr.mcc.ginco.beans.Thesaurus;
import fr.mcc.ginco.dao.INoteDAO;
import fr.mcc.ginco.dao.ISplitNonPreferredTermDAO;
import fr.mcc.ginco.dao.IThesaurusConceptDAO;
import fr.mcc.ginco.exports.result.bean.GincoExportedEntity;

import java.util.ArrayList;
import java.util.HashMap;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

/**
 * Unit tests for fr.mcc.ginco.imports.ginco.GincoConceptImporter
 *
 * @author Diffblue Cover
 */

public class GincoConceptImporterTest {

	@Mock(name = "gincoCustomAttributeImporter")
	private GincoCustomAttributeImporter gincoCustomAttributeImporter;

	@Mock(name = "noteDAO")
	private INoteDAO noteDAO;

	@Mock(name = "splitNonPreferredTermDAO")
	private ISplitNonPreferredTermDAO splitNonPreferredTermDAO;

	@Mock(name = "thesaurusConceptDAO")
	private IThesaurusConceptDAO thesaurusConceptDAO;

	@InjectMocks
	private GincoConceptImporter service;

	@Before public void initMocks() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void storeConcepts1() {
		assertTrue((service.storeConcepts(new GincoExportedEntity(), new Thesaurus(), new HashMap<String, CustomConceptAttributeType>())).isEmpty());
		Mockito.verify(thesaurusConceptDAO).flush();
	}

	@Test
	public void storeConcepts2() {
		assertTrue((service.storeConcepts(new GincoExportedEntity(), new Thesaurus(), new HashMap<String, CustomConceptAttributeType>())).isEmpty());
		Mockito.verify(thesaurusConceptDAO).flush();
	}

	@Test
	public void storeComplexConceptsComplexConceptsToImportIsEmpty() {
		assertTrue((service.storeComplexConcepts(new ArrayList<SplitNonPreferredTerm>(), new Thesaurus())).isEmpty());
	}

	@Test
	public void storeComplexConceptsComplexConceptsToImportIsNull() {
		assertTrue((service.storeComplexConcepts(null, new Thesaurus())).isEmpty());
	}

	@Test
	public void storeConceptNotesConceptNotesToImportIsNullReturnsEmpty() {
		assertTrue((service.storeConceptNotes(null)).isEmpty());
	}
}
