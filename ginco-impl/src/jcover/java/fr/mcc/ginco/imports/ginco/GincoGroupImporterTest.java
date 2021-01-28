package fr.mcc.ginco.imports.ginco;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import fr.mcc.ginco.beans.ThesaurusConceptGroup;
import fr.mcc.ginco.dao.IThesaurusConceptGroupDAO;
import fr.mcc.ginco.dao.IThesaurusConceptGroupLabelDAO;
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
	public void storeGroups() {

		// arrange
		ThesaurusConceptGroup thesaurusConceptGroup1 = new ThesaurusConceptGroup();
		when(thesaurusConceptGroupDAO.update(Mockito.<ThesaurusConceptGroup>any()))
			.thenReturn(thesaurusConceptGroup1);
		GincoExportedThesaurus exportedThesaurus = new GincoExportedThesaurus();
		ArrayList<ThesaurusConceptGroup> conceptGroups =
			 new ArrayList<ThesaurusConceptGroup>();
		conceptGroups.add(new ThesaurusConceptGroup());
		exportedThesaurus.setConceptGroups(conceptGroups);

		// act
		List<ThesaurusConceptGroup> result = service.storeGroups(exportedThesaurus);

		// assert
		assertEquals(1, result.size());
		assertSame(thesaurusConceptGroup1, result.get(0));
	}

	@Test
	public void storeGroupLabels1() {
		assertTrue(service.storeGroupLabels(new GincoExportedThesaurus()).isEmpty());
	}

	@Test
	public void storeGroupLabels2() {
		assertTrue(service.storeGroupLabels(new GincoExportedThesaurus()).isEmpty());
	}
}
