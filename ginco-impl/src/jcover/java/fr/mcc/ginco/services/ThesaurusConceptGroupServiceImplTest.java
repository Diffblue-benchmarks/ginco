package fr.mcc.ginco.services;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import fr.mcc.ginco.beans.ThesaurusConceptGroup;
import fr.mcc.ginco.beans.ThesaurusConceptGroupLabel;
import fr.mcc.ginco.dao.IThesaurusConceptGroupDAO;
import fr.mcc.ginco.dao.IThesaurusConceptGroupLabelDAO;

import java.util.ArrayList;

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
	public void destroyThesaurusConceptGroupReturnsNull() {
		assertNull(service.destroyThesaurusConceptGroup(new ThesaurusConceptGroup()));
	}

	@Test
	public void getAllThesaurusConceptGroupsByThesaurusIdExcludedConceptGroupIdIsBarReturnsEmpty() {
		when(thesaurusConceptGroupDAO.findThesaurusConceptGroupsByThesaurusId(Mockito.<String>any(), Mockito.<String>any()))
			.thenReturn(new ArrayList<ThesaurusConceptGroup>());
		assertTrue((service.getAllThesaurusConceptGroupsByThesaurusId("bar", "1234")).isEmpty());
	}

	@Test
	public void getChildGroupsReturnsEmpty() {
		when(thesaurusConceptGroupDAO.getChildGroups(Mockito.<String>any()))
			.thenReturn(new ArrayList<ThesaurusConceptGroup>());
		assertTrue((service.getChildGroups("1234")).isEmpty());
	}

	@Test
	public void getConceptGroupByIdReturnsNull() {
		assertNull(service.getConceptGroupById("1234"));
	}

	@Test
	public void updateThesaurusConceptGroupConceptGroupIsNull() {
		ThesaurusConceptGroup result = service.updateThesaurusConceptGroup(null, new ThesaurusConceptGroupLabel());
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
		ThesaurusConceptGroup result = service.updateThesaurusConceptGroup(new ThesaurusConceptGroup(), null);
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
	public void updateThesaurusConceptGroupReturnsNull() {
		ThesaurusConceptGroupLabel conceptGroupLabel = new ThesaurusConceptGroupLabel();
		assertNull(service.updateThesaurusConceptGroup(new ThesaurusConceptGroup(), conceptGroupLabel));
		assertNull(conceptGroupLabel.getConceptGroup());
	}
}
