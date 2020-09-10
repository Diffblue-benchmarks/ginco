package fr.mcc.ginco.services;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import fr.mcc.ginco.beans.AlignmentType;
import fr.mcc.ginco.dao.IGenericDAO;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

/**
 * Unit tests for fr.mcc.ginco.services.AlignmentTypeServiceImpl
 *
 * @author Diffblue Cover
 */

public class AlignmentTypeServiceImplTest {

	@Mock(name = "alignmentTypeDAO")
	private IGenericDAO<fr.mcc.ginco.beans.AlignmentType, Integer> alignmentTypeDAO;

	@InjectMocks
	private AlignmentTypeServiceImpl service;

	@Before public void initMocks() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void getAlignmentTypeByIdIdentifierIsZero() {

		// arrange
		AlignmentType alignmentType = new AlignmentType();
		alignmentType.setIdentifier(1);
		alignmentType.setIsoCode("DE");
		alignmentType.setLabel("label");
		when(alignmentTypeDAO.getById(Mockito.<Integer>any()))
			.thenReturn(alignmentType);

		// act
		AlignmentType result = service.getAlignmentTypeById(0);

		// assert
		assertEquals(1, (int) result.getIdentifier());
		assertEquals("DE", result.getIsoCode());
		assertEquals("label", result.getLabel());
		assertFalse(result.isDefaultType());
		assertFalse(result.isMultiConcept());
		assertFalse(result.isResource());
	}

	@Test
	public void getAlignmentTypeListReturnsEmpty() {
		when(alignmentTypeDAO.findAll())
			.thenReturn(new ArrayList<AlignmentType>());
		assertTrue((service.getAlignmentTypeList()).isEmpty());
	}
}
