package fr.mcc.ginco.exports;

import static org.junit.Assert.assertEquals;

import fr.mcc.ginco.beans.ThesaurusArrayConcept;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

/**
 * Unit tests for fr.mcc.ginco.exports.ArrayNaturalComparator
 *
 * @author Diffblue Cover
 */

public class ArrayNaturalComparatorTest {

	@InjectMocks
	private ArrayNaturalComparator service;

	@Before
	public void initMocks() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void compareReturnsOne() {
		ThesaurusArrayConcept o1 = new ThesaurusArrayConcept();
		o1.setArrayOrder(1);
		ThesaurusArrayConcept o2 = new ThesaurusArrayConcept();
		o2.setArrayOrder(0);
		assertEquals(1, service.compare(o1, o2));
	}

	@Test
	public void compareReturnsZero() {
		ThesaurusArrayConcept o1 = new ThesaurusArrayConcept();
		o1.setArrayOrder(1);
		ThesaurusArrayConcept o2 = new ThesaurusArrayConcept();
		o2.setArrayOrder(1);
		assertEquals(0, service.compare(o1, o2));
	}
}
