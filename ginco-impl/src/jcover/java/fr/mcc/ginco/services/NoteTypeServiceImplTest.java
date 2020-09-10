package fr.mcc.ginco.services;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import fr.mcc.ginco.beans.NoteType;
import fr.mcc.ginco.dao.INoteTypeDAO;

import java.util.ArrayList;

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
	public void getConceptNoteTypeListReturnsEmpty() {
		when(noteTypeDAO.findConceptNoteTypes())
			.thenReturn(new ArrayList<NoteType>());
		assertTrue((service.getConceptNoteTypeList()).isEmpty());
	}

	@Test
	public void getTermNoteTypeListReturnsEmpty() {
		when(noteTypeDAO.findTermNoteTypes())
			.thenReturn(new ArrayList<NoteType>());
		assertTrue((service.getTermNoteTypeList()).isEmpty());
	}
}
