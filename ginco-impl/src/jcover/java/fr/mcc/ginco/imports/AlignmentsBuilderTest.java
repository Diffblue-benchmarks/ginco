package fr.mcc.ginco.imports;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.hp.hpl.jena.rdf.model.Resource;

import fr.mcc.ginco.beans.AlignmentType;
import fr.mcc.ginco.beans.ThesaurusConcept;
import fr.mcc.ginco.services.IAlignmentTypeService;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

/**
 * Unit tests for fr.mcc.ginco.imports.AlignmentsBuilder
 *
 * @author Diffblue Cover
 */

public class AlignmentsBuilderTest {

	@Mock(name = "alignmentTypeService")
	private IAlignmentTypeService alignmentTypeService;

	@Mock(name = "skosAlignmentBuilder")
	private AlignmentBuilder skosAlignmentBuilder;

	@InjectMocks
	private AlignmentsBuilder service;

	@Before public void initMocks() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void buildAlignmentsReturnsEmpty() {
		List<AlignmentType> list = new ArrayList<AlignmentType>();
		list.add(new AlignmentType());
		when(alignmentTypeService.getAlignmentTypeList())
			.thenReturn(list);
		Resource skosConcept = mock(Resource.class);
		when(skosConcept.getURI())
			.thenReturn("foo");
		assertTrue((service.buildAlignments(skosConcept, new ThesaurusConcept())).isEmpty());
	}
}
