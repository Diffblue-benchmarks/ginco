package fr.mcc.ginco.utils;

import static org.junit.Assert.assertEquals;

import fr.mcc.ginco.beans.ThesaurusConcept;

import java.util.ArrayList;

import org.junit.Test;

/**
 * Unit tests for fr.mcc.ginco.utils.ThesaurusConceptUtils
 *
 * @author Diffblue Cover
 */

public class ThesaurusConceptUtilsTest {

	@Test
	public void getIdsFromConceptListReturnsData() {
		ArrayList<ThesaurusConcept> list = new ArrayList<ThesaurusConcept>();
		ThesaurusConcept thesaurusConcept = new ThesaurusConcept();
		thesaurusConcept.setIdentifier("data");
		list.add(thesaurusConcept);
		assertEquals(1, ThesaurusConceptUtils.getIdsFromConceptList(list).size());
		assertEquals("data", ThesaurusConceptUtils.getIdsFromConceptList(list).get(0));
	}
}
