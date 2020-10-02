package fr.mcc.ginco.imports.ginco;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.when;

import fr.mcc.ginco.beans.ThesaurusArray;
import fr.mcc.ginco.dao.INodeLabelDAO;
import fr.mcc.ginco.dao.IThesaurusArrayDAO;
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
	public void storeArrays() {

		// arrange
		ThesaurusArray thesaurusArray1 = new ThesaurusArray();
		when(thesaurusArrayDAO.update(Mockito.<ThesaurusArray>any()))
			.thenReturn(thesaurusArray1);
		GincoExportedThesaurus exportedThesaurus = new GincoExportedThesaurus();
		ArrayList<ThesaurusArray> conceptArrays4 = new ArrayList<ThesaurusArray>();
		conceptArrays4.add(new ThesaurusArray());
		exportedThesaurus.setConceptArrays(conceptArrays4);

		// act
		List<ThesaurusArray> result = service.storeArrays(exportedThesaurus);

		// assert
		assertEquals(1, result.size());
		assertSame(thesaurusArray1, result.get(0));
	}
}
