package fr.mcc.ginco.audit.csv;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Unit tests for fr.mcc.ginco.audit.csv.JournalEventsEnum
 *
 * @author Diffblue Cover
 */

public class JournalEventsEnumTest {

	@Test
	public void valuesReturnsTHESAURUS_CREATEDTHESAURUSTERM_CREATEDTHESAURUSTERM_DELETEDTHESAURUSCONCEPT_CREATEDTHESAURUSTERM_ROLE_UPDATETHESAURUSTERM_LEXICAL_VALUE_UPDATETHESAURUSTERM_LINKED_TO_CONCEPTTHESAURUSCONCEPT_HIERARCHY_UPDATETHESAURUSCONCEPT_STATUS_UPDATE() {
		JournalEventsEnum[] result = JournalEventsEnum.values();
		assertTrue(JournalEventsEnum.THESAURUS_CREATED == result[0]);
		assertTrue(JournalEventsEnum.THESAURUSTERM_CREATED == result[1]);
		assertTrue(JournalEventsEnum.THESAURUSTERM_DELETED == result[2]);
		assertTrue(JournalEventsEnum.THESAURUSCONCEPT_CREATED == result[3]);
		assertTrue(JournalEventsEnum.THESAURUSTERM_ROLE_UPDATE == result[4]);
		assertTrue(JournalEventsEnum.THESAURUSTERM_LEXICAL_VALUE_UPDATE == result[5]);
		assertTrue(JournalEventsEnum.THESAURUSTERM_LINKED_TO_CONCEPT == result[6]);
		assertTrue(JournalEventsEnum.THESAURUSCONCEPT_HIERARCHY_UPDATE == result[7]);
		assertTrue(JournalEventsEnum.THESAURUSCONCEPT_STATUS_UPDATE == result[8]);
	}
}
