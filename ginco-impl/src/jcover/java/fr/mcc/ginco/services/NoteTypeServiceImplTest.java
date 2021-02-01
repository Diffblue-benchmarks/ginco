package fr.mcc.ginco.services;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.when;

import fr.mcc.ginco.beans.NoteType;
import fr.mcc.ginco.dao.INoteTypeDAO;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

/**
 * Unit tests for fr.mcc.ginco.services.NoteTypeServiceImpl
 *
 * @author Diffblue Cover
 */

public class NoteTypeServiceImplTest {

	@Mock(name = "noteTypeDAO")
	private INoteTypeDAO noteTypeDAO;

	@InjectMocks
	private NoteTypeServiceImpl service;

	@Before
	public void initMocks() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void getConceptNoteTypeList() {

		// arrange
		ArrayList<NoteType> noteTypeList = new ArrayList<NoteType>();
		NoteType noteType = new NoteType();
		noteTypeList.add(noteType);
		when(noteTypeDAO.findConceptNoteTypes())
			.thenReturn(noteTypeList);

		// act
		List<NoteType> result = service.getConceptNoteTypeList();

		// assert
		assertEquals(1, result.size());
		assertSame(noteType, result.get(0));
	}

	@Test
	public void getTermNoteTypeList() {

		// arrange
		ArrayList<NoteType> noteTypeList = new ArrayList<NoteType>();
		NoteType noteType = new NoteType();
		noteTypeList.add(noteType);
		when(noteTypeDAO.findTermNoteTypes())
			.thenReturn(noteTypeList);

		// act
		List<NoteType> result = service.getTermNoteTypeList();

		// assert
		assertEquals(1, result.size());
		assertSame(noteType, result.get(0));
	}

	@Test
	public void getNoteTypeByIdTypeIdIsBASIC() {

		// arrange
		NoteType noteType = new NoteType();
		noteType.setCode("DE");
		noteType.setLabel("label");
		when(noteTypeDAO.getById(Mockito.<String>any()))
			.thenReturn(noteType);

		// act
		NoteType result = service.getNoteTypeById("BASIC");

		// assert
		assertEquals("DE", result.getCode());
		assertEquals("label", result.getLabel());
		assertFalse(result.isIsConcept());
		assertFalse(result.isIsTerm());
	}
}
