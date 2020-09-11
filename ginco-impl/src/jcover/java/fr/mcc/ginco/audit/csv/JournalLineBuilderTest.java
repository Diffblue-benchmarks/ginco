package fr.mcc.ginco.audit.csv;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import fr.mcc.ginco.beans.GincoRevEntity;
import fr.mcc.ginco.beans.ThesaurusConcept;
import fr.mcc.ginco.beans.ThesaurusTerm;
import fr.mcc.ginco.services.IThesaurusConceptService;

import java.util.HashSet;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

/**
 * Unit tests for fr.mcc.ginco.audit.csv.JournalLineBuilder
 *
 * @author Diffblue Cover
 */

public class JournalLineBuilderTest {

	@Mock(name = "thesaurusConceptService")
	private IThesaurusConceptService thesaurusConceptService;

	@InjectMocks
	private JournalLineBuilder service;

	@Before public void initMocks() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void buildLineBaseEventIsThesaurus_created() {

		// arrange
		GincoRevEntity gincoRevEntity = new GincoRevEntity();
		gincoRevEntity.setUsername("root");
		gincoRevEntity.setId(1);

		// act
		JournalLine result =
			 service.buildLineBase(JournalEventsEnum.THESAURUS_CREATED, gincoRevEntity);

		// assert
		assertEquals("root", result.getAuthorId());
		assertNull(result.getConceptId());
		assertEquals("Thu Jan 01 00:00:00 UTC 1970", result.getEventDate().toString());
		assertTrue(JournalEventsEnum.THESAURUS_CREATED == result.getEventType());
		assertNull(result.getNewGenericTerm());
		assertNull(result.getNewLexicalValue());
		assertNull(result.getOldGenericTerm());
		assertNull(result.getOldLexicalValue());
		assertEquals(1, (int) result.getRevisionNumber());
		assertNull(result.getStatus());
		assertNull(result.getTermId());
		assertNull(result.getTermRole());
	}

	@Test
	public void buildTermAddedLine1() {

		// arrange
		ThesaurusTerm term = new ThesaurusTerm();
		term.setIdentifier("data");
		term.setLexicalValue("value");
		GincoRevEntity revision = new GincoRevEntity();
		revision.setUsername("root");
		revision.setId(1);

		// act
		JournalLine result = service.buildTermAddedLine(term, revision);

		// assert
		assertEquals("root", result.getAuthorId());
		assertNull(result.getConceptId());
		assertEquals("Thu Jan 01 00:00:00 UTC 1970", result.getEventDate().toString());
		assertTrue(JournalEventsEnum.THESAURUSTERM_CREATED == result.getEventType());
		assertNull(result.getNewGenericTerm());
		assertEquals("value", result.getNewLexicalValue());
		assertNull(result.getOldGenericTerm());
		assertNull(result.getOldLexicalValue());
		assertEquals(1, (int) result.getRevisionNumber());
		assertNull(result.getStatus());
		assertEquals("data", result.getTermId());
		assertNull(result.getTermRole());
	}

	@Test
	public void buildTermAddedLine2() {

		// arrange
		ThesaurusTerm term = new ThesaurusTerm();
		ThesaurusConcept concept = new ThesaurusConcept();
		concept.setIdentifier("data");
		term.setConcept(concept);
		term.setIdentifier("data");
		term.setLexicalValue("value");
		GincoRevEntity revision = new GincoRevEntity();
		revision.setUsername("root");
		revision.setId(1);

		// act
		JournalLine result = service.buildTermAddedLine(term, revision);

		// assert
		assertEquals("root", result.getAuthorId());
		assertEquals("data", result.getConceptId());
		assertEquals("Thu Jan 01 00:00:00 UTC 1970", result.getEventDate().toString());
		assertTrue(JournalEventsEnum.THESAURUSTERM_CREATED == result.getEventType());
		assertNull(result.getNewGenericTerm());
		assertEquals("value", result.getNewLexicalValue());
		assertNull(result.getOldGenericTerm());
		assertNull(result.getOldLexicalValue());
		assertEquals(1, (int) result.getRevisionNumber());
		assertNull(result.getStatus());
		assertEquals("data", result.getTermId());
		assertNull(result.getTermRole());
	}

	@Test
	public void buildTermRoleChangedLine() {

		// arrange
		ThesaurusTerm term = new ThesaurusTerm();
		ThesaurusConcept concept = new ThesaurusConcept();
		concept.setIdentifier("data");
		term.setConcept(concept);
		term.setIdentifier("data");
		term.setPrefered(false);
		GincoRevEntity revision = new GincoRevEntity();
		revision.setUsername("root");
		revision.setId(1);

		// act
		JournalLine result = service.buildTermRoleChangedLine(term, revision);

		// assert
		assertEquals("root", result.getAuthorId());
		assertEquals("data", result.getConceptId());
		assertEquals("Thu Jan 01 00:00:00 UTC 1970", result.getEventDate().toString());
		assertTrue(JournalEventsEnum.THESAURUSTERM_ROLE_UPDATE == result.getEventType());
		assertNull(result.getNewGenericTerm());
		assertNull(result.getNewLexicalValue());
		assertNull(result.getOldGenericTerm());
		assertNull(result.getOldLexicalValue());
		assertEquals(1, (int) result.getRevisionNumber());
		assertNull(result.getStatus());
		assertEquals("data", result.getTermId());
		assertEquals("TNP", result.getTermRole());
	}

	@Test
	public void buildTermLexicalValueChangedLineOldLexicalValueIsValue() {

		// arrange
		ThesaurusTerm term = new ThesaurusTerm();
		ThesaurusConcept concept = new ThesaurusConcept();
		concept.setIdentifier("data");
		term.setConcept(concept);
		term.setIdentifier("data");
		term.setLexicalValue("value");
		GincoRevEntity revision = new GincoRevEntity();
		revision.setUsername("root");
		revision.setId(1);

		// act
		JournalLine result =
			 service.buildTermLexicalValueChangedLine(term, revision, "value");

		// assert
		assertEquals("root", result.getAuthorId());
		assertEquals("data", result.getConceptId());
		assertEquals("Thu Jan 01 00:00:00 UTC 1970", result.getEventDate().toString());
		assertTrue(JournalEventsEnum.THESAURUSTERM_LEXICAL_VALUE_UPDATE == result.getEventType());
		assertNull(result.getNewGenericTerm());
		assertEquals("value", result.getNewLexicalValue());
		assertNull(result.getOldGenericTerm());
		assertEquals("value", result.getOldLexicalValue());
		assertEquals(1, (int) result.getRevisionNumber());
		assertNull(result.getStatus());
		assertEquals("data", result.getTermId());
		assertNull(result.getTermRole());
	}

	@Test
	public void buildTermAttachmentChangedLine() {

		// arrange
		ThesaurusTerm term = new ThesaurusTerm();
		ThesaurusConcept concept1 = new ThesaurusConcept();
		concept1.setIdentifier("data");
		term.setConcept(concept1);
		term.setIdentifier("data");
		term.setLexicalValue("value");
		GincoRevEntity revision = new GincoRevEntity();
		revision.setUsername("root");
		revision.setId(1);

		// act
		JournalLine result =
			 service.buildTermAttachmentChangedLine(term, revision, new ThesaurusTerm());

		// assert
		assertEquals("root", result.getAuthorId());
		assertEquals("data", result.getConceptId());
		assertEquals("Thu Jan 01 00:00:00 UTC 1970", result.getEventDate().toString());
		assertTrue(JournalEventsEnum.THESAURUSTERM_LINKED_TO_CONCEPT == result.getEventType());
		assertNull(result.getNewGenericTerm());
		assertEquals("value", result.getNewLexicalValue());
		assertNull(result.getOldGenericTerm());
		assertEquals("value", result.getOldLexicalValue());
		assertEquals(1, (int) result.getRevisionNumber());
		assertNull(result.getStatus());
		assertEquals("data", result.getTermId());
		assertNull(result.getTermRole());
	}

	@Test
	public void buildConceptHierarchyChangedCurrentGenericConceptIsEmptyAndOldGenericConceptIsEmpty() {

		// arrange
		ThesaurusConcept conceptAtRevision = new ThesaurusConcept();
		conceptAtRevision.setIdentifier("data");
		GincoRevEntity revision = new GincoRevEntity();
		revision.setUsername("root");
		revision.setId(1);

		// act
		JournalLine result =
			 service.buildConceptHierarchyChanged(conceptAtRevision, revision, new HashSet<ThesaurusConcept>(), new HashSet<ThesaurusConcept>());

		// assert
		assertEquals("root", result.getAuthorId());
		assertEquals("data", result.getConceptId());
		assertEquals("Thu Jan 01 00:00:00 UTC 1970", result.getEventDate().toString());
		assertTrue(JournalEventsEnum.THESAURUSCONCEPT_HIERARCHY_UPDATE == result.getEventType());
		assertTrue((result.getNewGenericTerm()).isEmpty());
		assertNull(result.getNewLexicalValue());
		assertTrue((result.getOldGenericTerm()).isEmpty());
		assertNull(result.getOldLexicalValue());
		assertEquals(1, (int) result.getRevisionNumber());
		assertNull(result.getStatus());
		assertNull(result.getTermId());
		assertNull(result.getTermRole());
	}
}
