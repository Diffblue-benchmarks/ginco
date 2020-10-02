package fr.mcc.ginco.imports.ginco;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.when;

import fr.mcc.ginco.beans.ThesaurusVersionHistory;
import fr.mcc.ginco.dao.IThesaurusDAO;
import fr.mcc.ginco.dao.IThesaurusVersionHistoryDAO;
import fr.mcc.ginco.exports.result.bean.GincoExportedThesaurus;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

/**
 * Unit tests for fr.mcc.ginco.imports.ginco.GincoThesaurusBuilder
 *
 * @author Diffblue Cover
 */

public class GincoThesaurusBuilderTest {

	@Mock(name = "gincoAlignmentImporter")
	private GincoAlignmentImporter gincoAlignmentImporter;

	@Mock(name = "gincoArrayImporter")
	private GincoArrayImporter gincoArrayImporter;

	@Mock(name = "gincoConceptImporter")
	private GincoConceptImporter gincoConceptImporter;

	@Mock(name = "gincoCustomAttributeImporter")
	private GincoCustomAttributeImporter gincoCustomAttributeImporter;

	@Mock(name = "gincoGroupImporter")
	private GincoGroupImporter gincoGroupImporter;

	@Mock(name = "gincoRelationshipImporter")
	private GincoRelationshipImporter gincoRelationshipImporter;

	@Mock(name = "gincoTermImporter")
	private GincoTermImporter gincoTermImporter;

	@Mock(name = "thesaurusDAO")
	private IThesaurusDAO thesaurusDAO;

	@Mock(name = "thesaurusVersionHistoryDAO")
	private IThesaurusVersionHistoryDAO thesaurusVersionHistoryDAO;

	@InjectMocks
	private GincoThesaurusBuilder service;

	@Before public void initMocks() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void storeVersions() {

		// arrange
		ThesaurusVersionHistory thesaurusVersionHistory1 =
			 new ThesaurusVersionHistory();
		when(thesaurusVersionHistoryDAO.update(Mockito.<ThesaurusVersionHistory>any()))
			.thenReturn(thesaurusVersionHistory1);
		GincoExportedThesaurus exportedThesaurus = new GincoExportedThesaurus();
		ArrayList<ThesaurusVersionHistory> versions7 =
			 new ArrayList<ThesaurusVersionHistory>();
		versions7.add(new ThesaurusVersionHistory());
		exportedThesaurus.setThesaurusVersions(versions7);

		// act
		List<ThesaurusVersionHistory> result =
			 service.storeVersions(exportedThesaurus);

		// assert
		assertEquals(1, result.size());
		assertSame(thesaurusVersionHistory1, result.get(0));
	}
}
