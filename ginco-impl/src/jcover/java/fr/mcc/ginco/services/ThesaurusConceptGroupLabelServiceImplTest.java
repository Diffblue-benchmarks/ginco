package fr.mcc.ginco.services;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.when;

import fr.mcc.ginco.beans.Language;
import fr.mcc.ginco.beans.ThesaurusConceptGroup;
import fr.mcc.ginco.beans.ThesaurusConceptGroupLabel;
import fr.mcc.ginco.dao.IThesaurusConceptGroupLabelDAO;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

/**
 * Unit tests for fr.mcc.ginco.services.ThesaurusConceptGroupLabelServiceImpl
 *
 * @author Diffblue Cover
 */

public class ThesaurusConceptGroupLabelServiceImplTest {

	@Mock(name = "thesaurusConceptGroupLabelDAO")
	private IThesaurusConceptGroupLabelDAO thesaurusConceptGroupLabelDAO;

	@InjectMocks
	private ThesaurusConceptGroupLabelServiceImpl service;

	@Before public void initMocks() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void getByIdIdIsOneReturnsNull() {
		assertNull(service.getById(1));
	}

	@Test
	public void getByThesaurusConceptGroupAndLanguageIdentifierIsBar() throws java.text.ParseException {

		// arrange
		ThesaurusConceptGroupLabel thesaurusConceptGroupLabel = new ThesaurusConceptGroupLabel();
		ThesaurusConceptGroup conceptGroup = new ThesaurusConceptGroup();
		thesaurusConceptGroupLabel.setConceptGroup(conceptGroup);
		Date created = new java.text.SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31");
		thesaurusConceptGroupLabel.setCreated(created);
		thesaurusConceptGroupLabel.setIdentifier(1);
		Language language = new Language();
		thesaurusConceptGroupLabel.setLanguage(language);
		thesaurusConceptGroupLabel.setLexicalValue("value");
		Date modified = new java.text.SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31");
		thesaurusConceptGroupLabel.setModified(modified);
		when(thesaurusConceptGroupLabelDAO.findByThesaurusConceptGroupAndLanguage(Mockito.<String>any()))
			.thenReturn(thesaurusConceptGroupLabel);

		// act
		ThesaurusConceptGroupLabel result = service.getByThesaurusConceptGroupAndLanguage("bar");

		// assert
		assertSame(conceptGroup, result.getConceptGroup());
		assertSame(created, result.getCreated());
		assertEquals(1, (int) result.getIdentifier());
		assertSame(language, result.getLanguage());
		assertEquals("value", result.getLexicalValue());
		assertSame(modified, result.getModified());
	}

	@Test
	public void getByThesaurusConceptGroupThesaurusConceptGroupIdIsBar() throws java.text.ParseException {

		// arrange
		ThesaurusConceptGroupLabel thesaurusConceptGroupLabel = new ThesaurusConceptGroupLabel();
		ThesaurusConceptGroup conceptGroup = new ThesaurusConceptGroup();
		thesaurusConceptGroupLabel.setConceptGroup(conceptGroup);
		Date created = new java.text.SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31");
		thesaurusConceptGroupLabel.setCreated(created);
		thesaurusConceptGroupLabel.setIdentifier(1);
		Language language = new Language();
		thesaurusConceptGroupLabel.setLanguage(language);
		thesaurusConceptGroupLabel.setLexicalValue("value");
		Date modified = new java.text.SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31");
		thesaurusConceptGroupLabel.setModified(modified);
		when(thesaurusConceptGroupLabelDAO.findByThesaurusConceptGroup(Mockito.<String>any()))
			.thenReturn(thesaurusConceptGroupLabel);

		// act
		ThesaurusConceptGroupLabel result = service.getByThesaurusConceptGroup("bar");

		// assert
		assertSame(conceptGroup, result.getConceptGroup());
		assertSame(created, result.getCreated());
		assertEquals(1, (int) result.getIdentifier());
		assertSame(language, result.getLanguage());
		assertEquals("value", result.getLexicalValue());
		assertSame(modified, result.getModified());
	}

	@Test
	public void updateOrCreateReturnsNull() {
		assertNull(service.updateOrCreate(new ThesaurusConceptGroupLabel()));
	}
}
