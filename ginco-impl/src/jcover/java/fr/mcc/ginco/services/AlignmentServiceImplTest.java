package fr.mcc.ginco.services;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.when;

import fr.mcc.ginco.ark.IIDGeneratorService;
import fr.mcc.ginco.beans.Alignment;
import fr.mcc.ginco.beans.AlignmentConcept;
import fr.mcc.ginco.beans.AlignmentResource;
import fr.mcc.ginco.dao.IAlignmentDAO;
import fr.mcc.ginco.dao.IExternalThesaurusDAO;
import fr.mcc.ginco.dao.IGenericDAO;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

/**
 * Unit tests for fr.mcc.ginco.services.AlignmentServiceImpl
 *
 * @author Diffblue Cover
 */

public class AlignmentServiceImplTest {

	@Mock(name = "alignmentConceptDAO")
	private IGenericDAO<fr.mcc.ginco.beans.AlignmentConcept, Integer> alignmentConceptDAO;

	@Mock(name = "alignmentDAO")
	private IAlignmentDAO alignmentDAO;

	@Mock(name = "alignmentResourceDAO")
	private IGenericDAO<fr.mcc.ginco.beans.AlignmentResource, Integer> alignmentResourceDAO;

	@Mock(name = "externalThesaurusDAO")
	private IExternalThesaurusDAO externalThesaurusDAO;

	@Mock(name = "generatorService")
	private IIDGeneratorService generatorService;

	@InjectMocks
	private AlignmentServiceImpl service;

	@Before public void initMocks() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void getAlignmentsBySourceConceptIdConceptIdentifierIsData() {

		// arrange
		List<Alignment> list = new ArrayList<Alignment>();
		Alignment alignment = new Alignment();
		list.add(alignment);
		when(alignmentDAO.findBySourceConceptId(Mockito.<String>any()))
			.thenReturn(list);

		// act
		List<Alignment> result = service.getAlignmentsBySourceConceptId("data");

		// assert
		assertEquals(1, result.size());
		assertSame(alignment, result.get(0));
	}
}
