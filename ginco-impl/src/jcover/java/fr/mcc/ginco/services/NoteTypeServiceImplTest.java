package fr.mcc.ginco.services;

import static org.junit.Assert.assertEquals;
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

	@Before public void initMocks() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void getConceptNoteTypeList() {

		// arrange
		List<NoteType> list = new ArrayList<NoteType>();
		NoteType noteType = new NoteType();
		list.add(noteType);
		when(noteTypeDAO.findConceptNoteTypes())
			.thenReturn(list);

		// act
		List<NoteType> result = service.getConceptNoteTypeList();

		// assert
		assertEquals(1, result.size());
		assertSame(noteType, result.get(0));
	}

	@Test
	public void getTermNoteTypeList() {

		// arrange
		List<NoteType> list = new ArrayList<NoteType>();
		NoteType noteType = new NoteType();
		list.add(noteType);
		when(noteTypeDAO.findTermNoteTypes())
			.thenReturn(list);

		// act
		List<NoteType> result = service.getTermNoteTypeList();

		// assert
		assertEquals(1, result.size());
		assertSame(noteType, result.get(0));
	}
}
