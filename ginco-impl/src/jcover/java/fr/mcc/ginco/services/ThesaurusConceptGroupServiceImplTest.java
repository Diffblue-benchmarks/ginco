package fr.mcc.ginco.services;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.when;

import fr.mcc.ginco.beans.ThesaurusConceptGroup;
import fr.mcc.ginco.beans.ThesaurusConceptGroupLabel;
import fr.mcc.ginco.dao.IThesaurusConceptGroupDAO;
import fr.mcc.ginco.dao.IThesaurusConceptGroupLabelDAO;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

/**
 * Unit tests for fr.mcc.ginco.services.ThesaurusConceptGroupServiceImpl
 *
 * @author Diffblue Cover
 */

public class ThesaurusConceptGroupServiceImplTest {

	@Mock(name = "thesaurusConceptGroupDAO")
	private IThesaurusConceptGroupDAO thesaurusConceptGroupDAO;

	@Mock(name = "thesaurusConceptGroupLabelDAO")
	private IThesaurusConceptGroupLabelDAO thesaurusConceptGroupLabelDAO;

	@InjectMocks
	private ThesaurusConceptGroupServiceImpl service;

	@Before public void initMocks() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void updateThesaurusConceptGroupConceptGroupIsNull() {
		ThesaurusConceptGroup result =
			 service.updateThesaurusConceptGroup(null, new ThesaurusConceptGroupLabel());
		assertNull(result.getConceptGroupType());
		assertNull(result.getConcepts());
		assertNull(result.getIdentifier());
		assertNull(result.getIsDynamic());
		assertNull(result.getNotation());
		assertNull(result.getParent());
		assertNull(result.getParentConcept());
		assertNull(result.getThesaurus());
	}

	@Test
	public void updateThesaurusConceptGroupConceptGroupLabelIsNull() {
		ThesaurusConceptGroup result =
			 service.updateThesaurusConceptGroup(new ThesaurusConceptGroup(), null);
		assertNull(result.getConceptGroupType());
		assertNull(result.getConcepts());
		assertNull(result.getIdentifier());
		assertNull(result.getIsDynamic());
		assertNull(result.getNotation());
		assertNull(result.getParent());
		assertNull(result.getParentConcept());
		assertNull(result.getThesaurus());
	}

	@Test
	public void getAllThesaurusConceptGroupsByThesaurusIdExcludedConceptGroupIdIsBar() {

		// arrange
		List<ThesaurusConceptGroup> list = new ArrayList<ThesaurusConceptGroup>();
		ThesaurusConceptGroup thesaurusConceptGroup = new ThesaurusConceptGroup();
		list.add(thesaurusConceptGroup);
		when(thesaurusConceptGroupDAO.findThesaurusConceptGroupsByThesaurusId(Mockito.<String>any(), Mockito.<String>any()))
			.thenReturn(list);

		// act
		List<ThesaurusConceptGroup> result =
			 service.getAllThesaurusConceptGroupsByThesaurusId("bar", "1234");

		// assert
		assertEquals(1, result.size());
		assertSame(thesaurusConceptGroup, result.get(0));
	}

	@Test
	public void getChildGroups() {

		// arrange
		List<ThesaurusConceptGroup> list = new ArrayList<ThesaurusConceptGroup>();
		ThesaurusConceptGroup thesaurusConceptGroup = new ThesaurusConceptGroup();
		list.add(thesaurusConceptGroup);
		when(thesaurusConceptGroupDAO.getChildGroups(Mockito.<String>any()))
			.thenReturn(list);

		// act
		List<ThesaurusConceptGroup> result = service.getChildGroups("1234");

		// assert
		assertEquals(1, result.size());
		assertSame(thesaurusConceptGroup, result.get(0));
	}
}
