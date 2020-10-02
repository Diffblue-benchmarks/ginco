package fr.mcc.ginco.services;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import fr.mcc.ginco.beans.Thesaurus;
import fr.mcc.ginco.beans.ThesaurusConcept;
import fr.mcc.ginco.beans.ThesaurusConceptGroup;
import fr.mcc.ginco.beans.ThesaurusConceptGroupLabel;
import fr.mcc.ginco.beans.ThesaurusConceptGroupType;
import fr.mcc.ginco.dao.IThesaurusConceptGroupDAO;
import fr.mcc.ginco.dao.IThesaurusConceptGroupLabelDAO;

import java.util.ArrayList;
import java.util.HashSet;
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
	public void getConceptGroupById() {

		// arrange
		ThesaurusConceptGroup thesaurusConceptGroup = new ThesaurusConceptGroup();
		ThesaurusConceptGroupType conceptGroupType1 =
			 new ThesaurusConceptGroupType();
		thesaurusConceptGroup.setConceptGroupType(conceptGroupType1);
		thesaurusConceptGroup.setConcepts(new HashSet<ThesaurusConcept>());
		thesaurusConceptGroup.setIdentifier("data");
		thesaurusConceptGroup.setIsDynamic(false);
		thesaurusConceptGroup.setNotation("DE");
		ThesaurusConceptGroup parent1 = new ThesaurusConceptGroup();
		thesaurusConceptGroup.setParent(parent1);
		ThesaurusConcept parentConcept4 = new ThesaurusConcept();
		thesaurusConceptGroup.setParentConcept(parentConcept4);
		Thesaurus thesaurus7 = new Thesaurus();
		thesaurusConceptGroup.setThesaurus(thesaurus7);
		when(thesaurusConceptGroupDAO.getById(Mockito.<String>any()))
			.thenReturn(thesaurusConceptGroup);

		// act
		ThesaurusConceptGroup result = service.getConceptGroupById("1234");

		// assert
		assertSame(conceptGroupType1, result.getConceptGroupType());
		assertTrue((result.getConcepts()).isEmpty());
		assertEquals("data", result.getIdentifier());
		assertFalse(result.getIsDynamic());
		assertEquals("DE", result.getNotation());
		assertSame(parent1, result.getParent());
		assertSame(parentConcept4, result.getParentConcept());
		assertSame(thesaurus7, result.getThesaurus());
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
	public void getAllThesaurusConceptGroupsByThesaurusId() {

		// arrange
		List<ThesaurusConceptGroup> list = new ArrayList<ThesaurusConceptGroup>();
		ThesaurusConceptGroup thesaurusConceptGroup = new ThesaurusConceptGroup();
		list.add(thesaurusConceptGroup);
		when(thesaurusConceptGroupDAO.findThesaurusConceptGroupsByThesaurusId(Mockito.<String>any(), Mockito.<String>any()))
			.thenReturn(list);

		// act
		List<ThesaurusConceptGroup> result =
			 service.getAllThesaurusConceptGroupsByThesaurusId("1234", "1234");

		// assert
		assertEquals(1, result.size());
		assertSame(thesaurusConceptGroup, result.get(0));
	}

	@Test
	public void destroyThesaurusConceptGroup() {

		// arrange
		ThesaurusConceptGroup thesaurusConceptGroup = new ThesaurusConceptGroup();
		ThesaurusConceptGroupType conceptGroupType1 =
			 new ThesaurusConceptGroupType();
		thesaurusConceptGroup.setConceptGroupType(conceptGroupType1);
		thesaurusConceptGroup.setConcepts(new HashSet<ThesaurusConcept>());
		thesaurusConceptGroup.setIdentifier("data");
		thesaurusConceptGroup.setIsDynamic(false);
		thesaurusConceptGroup.setNotation("DE");
		ThesaurusConceptGroup parent1 = new ThesaurusConceptGroup();
		thesaurusConceptGroup.setParent(parent1);
		ThesaurusConcept parentConcept4 = new ThesaurusConcept();
		thesaurusConceptGroup.setParentConcept(parentConcept4);
		Thesaurus thesaurus7 = new Thesaurus();
		thesaurusConceptGroup.setThesaurus(thesaurus7);
		when(thesaurusConceptGroupDAO.delete(Mockito.<ThesaurusConceptGroup>any()))
			.thenReturn(thesaurusConceptGroup);

		// act
		ThesaurusConceptGroup result =
			 service.destroyThesaurusConceptGroup(new ThesaurusConceptGroup());

		// assert
		assertSame(conceptGroupType1, result.getConceptGroupType());
		assertTrue((result.getConcepts()).isEmpty());
		assertEquals("data", result.getIdentifier());
		assertFalse(result.getIsDynamic());
		assertEquals("DE", result.getNotation());
		assertSame(parent1, result.getParent());
		assertSame(parentConcept4, result.getParentConcept());
		assertSame(thesaurus7, result.getThesaurus());
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
