package fr.mcc.ginco.services;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import fr.mcc.ginco.audit.csv.AuditCSVWriter;
import fr.mcc.ginco.audit.csv.JournalEventsEnum;
import fr.mcc.ginco.audit.csv.JournalLine;
import fr.mcc.ginco.audit.csv.readers.ThesaurusAuditReader;
import fr.mcc.ginco.audit.csv.readers.ThesaurusConceptAuditReader;
import fr.mcc.ginco.audit.csv.readers.ThesaurusTermAuditReader;
import fr.mcc.ginco.beans.Language;
import fr.mcc.ginco.beans.Thesaurus;
import fr.mcc.ginco.beans.ThesaurusFormat;
import fr.mcc.ginco.beans.ThesaurusOrganization;
import fr.mcc.ginco.beans.ThesaurusType;
import fr.mcc.ginco.beans.ThesaurusVersionHistory;
import fr.mcc.ginco.dao.IThesaurusVersionHistoryDAO;

import java.io.BufferedWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashSet;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

/**
 * Unit tests for fr.mcc.ginco.services.GincoRevServiceImpl
 *
 * @author Diffblue Cover
 */

public class GincoRevServiceImplTest {

	@Mock(name = "auditCSVWriter")
	private AuditCSVWriter auditCSVWriter;

	@Mock(name = "thesaurusAuditReader")
	private ThesaurusAuditReader thesaurusAuditReader;

	@Mock(name = "thesaurusConceptAuditReader")
	private ThesaurusConceptAuditReader thesaurusConceptAuditReader;

	@Mock(name = "thesaurusTermAuditReader")
	private ThesaurusTermAuditReader thesaurusTermAuditReader;

	@Mock(name = "thesaurusVersionHistoryDAO")
	private IThesaurusVersionHistoryDAO thesaurusVersionHistoryDAO;

	@InjectMocks
	private GincoRevServiceImpl service;

	@Before public void initMocks() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void getLogJournal() throws java.text.ParseException, java.io.IOException {
		ThesaurusVersionHistory thesaurusVersionHistory =
			 new ThesaurusVersionHistory();
		thesaurusVersionHistory.setDate(new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31"));
		thesaurusVersionHistory.setIdentifier("data");
		thesaurusVersionHistory.setStatus(1);
		Thesaurus thesaurus1 = mock(Thesaurus.class);
		thesaurusVersionHistory.setThesaurus(thesaurus1);
		thesaurusVersionHistory.setThisVersion(false);
		thesaurusVersionHistory.setUserId("root");
		thesaurusVersionHistory.setVersionNote("1.0");
		when(thesaurusVersionHistoryDAO.getLastPublishedVersionByThesaurusId(Mockito.<String>any()))
			.thenReturn(thesaurusVersionHistory);
		ArrayList<JournalLine> journalLineList1 = new ArrayList<JournalLine>();
		JournalLine journalLine1 = new JournalLine();
		journalLine1.setAuthorId("1234");
		journalLine1.setConceptId("1234");
		journalLine1.setEventDate(new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31"));
		journalLine1.setEventType(JournalEventsEnum.THESAURUS_CREATED);
		journalLine1.setNewGenericTerm(new HashSet<String>());
		journalLine1.setNewLexicalValue("value");
		journalLine1.setOldGenericTerm(new HashSet<String>());
		journalLine1.setOldLexicalValue("value");
		journalLine1.setRevisionNumber(1);
		journalLine1.setStatus(1);
		journalLine1.setTermId("1234");
		journalLine1.setTermRole("admin");
		journalLineList1.add(journalLine1);
		ArrayList<JournalLine> journalLineList2 = new ArrayList<JournalLine>();
		JournalLine journalLine2 = new JournalLine();
		journalLine2.setAuthorId("1234");
		journalLine2.setConceptId("1234");
		journalLine2.setEventDate(new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31"));
		journalLine2.setEventType(JournalEventsEnum.THESAURUS_CREATED);
		journalLine2.setNewGenericTerm(new HashSet<String>());
		journalLine2.setNewLexicalValue("value");
		journalLine2.setOldGenericTerm(new HashSet<String>());
		journalLine2.setOldLexicalValue("value");
		journalLine2.setRevisionNumber(1);
		journalLine2.setStatus(1);
		journalLine2.setTermId("1234");
		journalLine2.setTermRole("admin");
		journalLineList2.add(journalLine2);
		ArrayList<JournalLine> journalLineList3 = new ArrayList<JournalLine>();
		JournalLine journalLine3 = new JournalLine();
		journalLine3.setAuthorId("1234");
		journalLine3.setConceptId("1234");
		journalLine3.setEventDate(new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31"));
		journalLine3.setEventType(JournalEventsEnum.THESAURUS_CREATED);
		journalLine3.setNewGenericTerm(new HashSet<String>());
		journalLine3.setNewLexicalValue("value");
		journalLine3.setOldGenericTerm(new HashSet<String>());
		journalLine3.setOldLexicalValue("value");
		journalLine3.setRevisionNumber(1);
		journalLine3.setStatus(1);
		journalLine3.setTermId("1234");
		journalLine3.setTermRole("admin");
		journalLineList3.add(journalLine3);
		ArrayList<JournalLine> journalLineList4 = new ArrayList<JournalLine>();
		JournalLine journalLine4 = new JournalLine();
		journalLine4.setAuthorId("1234");
		journalLine4.setConceptId("1234");
		journalLine4.setEventDate(new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31"));
		journalLine4.setEventType(JournalEventsEnum.THESAURUS_CREATED);
		journalLine4.setNewGenericTerm(new HashSet<String>());
		journalLine4.setNewLexicalValue("value");
		journalLine4.setOldGenericTerm(new HashSet<String>());
		journalLine4.setOldLexicalValue("value");
		journalLine4.setRevisionNumber(1);
		journalLine4.setStatus(1);
		journalLine4.setTermId("1234");
		journalLine4.setTermRole("admin");
		journalLineList4.add(journalLine4);
		when(thesaurusTermAuditReader.getTermAdded(Mockito.<Thesaurus>any(), Mockito.<java.util.Date>any()))
			.thenReturn(journalLineList4);
		when(thesaurusTermAuditReader.getTermAttachmentChanged(Mockito.<Thesaurus>any(), Mockito.<java.util.Date>any()))
			.thenReturn(journalLineList1);
		when(thesaurusTermAuditReader.getTermLexicalValueChanged(Mockito.<Thesaurus>any(), Mockito.<java.util.Date>any()))
			.thenReturn(journalLineList2);
		when(thesaurusTermAuditReader.getTermRoleChanged(Mockito.<Thesaurus>any(), Mockito.<java.util.Date>any()))
			.thenReturn(journalLineList3);
		ArrayList<JournalLine> journalLineList5 = new ArrayList<JournalLine>();
		JournalLine journalLine5 = new JournalLine();
		journalLine5.setAuthorId("1234");
		journalLine5.setConceptId("1234");
		journalLine5.setEventDate(new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31"));
		journalLine5.setEventType(JournalEventsEnum.THESAURUS_CREATED);
		journalLine5.setNewGenericTerm(new HashSet<String>());
		journalLine5.setNewLexicalValue("value");
		journalLine5.setOldGenericTerm(new HashSet<String>());
		journalLine5.setOldLexicalValue("value");
		journalLine5.setRevisionNumber(1);
		journalLine5.setStatus(1);
		journalLine5.setTermId("1234");
		journalLine5.setTermRole("admin");
		journalLineList5.add(journalLine5);
		ArrayList<JournalLine> journalLineList6 = new ArrayList<JournalLine>();
		JournalLine journalLine6 = new JournalLine();
		journalLine6.setAuthorId("1234");
		journalLine6.setConceptId("1234");
		journalLine6.setEventDate(new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31"));
		journalLine6.setEventType(JournalEventsEnum.THESAURUS_CREATED);
		journalLine6.setNewGenericTerm(new HashSet<String>());
		journalLine6.setNewLexicalValue("value");
		journalLine6.setOldGenericTerm(new HashSet<String>());
		journalLine6.setOldLexicalValue("value");
		journalLine6.setRevisionNumber(1);
		journalLine6.setStatus(1);
		journalLine6.setTermId("1234");
		journalLine6.setTermRole("admin");
		journalLineList6.add(journalLine6);
		ArrayList<JournalLine> journalLineList7 = new ArrayList<JournalLine>();
		JournalLine journalLine7 = new JournalLine();
		journalLine7.setAuthorId("1234");
		journalLine7.setConceptId("1234");
		journalLine7.setEventDate(new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31"));
		journalLine7.setEventType(JournalEventsEnum.THESAURUS_CREATED);
		journalLine7.setNewGenericTerm(new HashSet<String>());
		journalLine7.setNewLexicalValue("value");
		journalLine7.setOldGenericTerm(new HashSet<String>());
		journalLine7.setOldLexicalValue("value");
		journalLine7.setRevisionNumber(1);
		journalLine7.setStatus(1);
		journalLine7.setTermId("1234");
		journalLine7.setTermRole("admin");
		journalLineList7.add(journalLine7);
		when(thesaurusConceptAuditReader.getConceptAdded(Mockito.<Thesaurus>any(), Mockito.<java.util.Date>any()))
			.thenReturn(journalLineList7);
		when(thesaurusConceptAuditReader.getConceptHierarchyChanged(Mockito.<Thesaurus>any(), Mockito.<java.util.Date>any()))
			.thenReturn(journalLineList6);
		when(thesaurusConceptAuditReader.getConceptStatusChanged(Mockito.<Thesaurus>any(), Mockito.<java.util.Date>any()))
			.thenReturn(journalLineList5);
		ArrayList<JournalLine> journalLineList8 = new ArrayList<JournalLine>();
		JournalLine journalLine8 = new JournalLine();
		journalLine8.setAuthorId("1234");
		journalLine8.setConceptId("1234");
		journalLine8.setEventDate(new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31"));
		journalLine8.setEventType(JournalEventsEnum.THESAURUS_CREATED);
		journalLine8.setNewGenericTerm(new HashSet<String>());
		journalLine8.setNewLexicalValue("value");
		journalLine8.setOldGenericTerm(new HashSet<String>());
		journalLine8.setOldLexicalValue("value");
		journalLine8.setRevisionNumber(1);
		journalLine8.setStatus(1);
		journalLine8.setTermId("1234");
		journalLine8.setTermRole("admin");
		journalLineList8.add(journalLine8);
		when(thesaurusAuditReader.getThesaurusAdded(Mockito.<Thesaurus>any(), Mockito.<java.util.Date>any()))
			.thenReturn(journalLineList8);
		Thesaurus thesaurus2 = new Thesaurus();
		thesaurus2.setArchived(false);
		thesaurus2.setContributor("foo");
		thesaurus2.setCoverage("foo");
		thesaurus2.setCreated(new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31"));
		ThesaurusOrganization creator2 = new ThesaurusOrganization();
		creator2.setEmail("info@diffblue.com");
		creator2.setHomepage("foo");
		creator2.setIdentifier(1);
		creator2.setName("Acme");
		thesaurus2.setCreator(creator2);
		thesaurus2.setDate(new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31"));
		thesaurus2.setDefaultTopConcept(false);
		thesaurus2.setDescription("some text");
		thesaurus2.setFormat(new HashSet<ThesaurusFormat>());
		thesaurus2.setIdentifier("data");
		thesaurus2.setLang(new HashSet<Language>());
		thesaurus2.setPolyHierarchical(false);
		thesaurus2.setPublisher("foo");
		thesaurus2.setRelation("DE");
		thesaurus2.setRights("foo");
		thesaurus2.setSource("foo");
		thesaurus2.setSubject("foo");
		thesaurus2.setTitle("Mr");
		ThesaurusType type2 = new ThesaurusType();
		type2.setIdentifier(1);
		type2.setLabel("label");
		thesaurus2.setType(type2);
		thesaurus2.setVersions(new HashSet<ThesaurusVersionHistory>());
		assertTrue(service.getLogJournal(thesaurus2).getPath().startsWith(System.getProperty("java.io.tmpdir")));
		Mockito.verify(auditCSVWriter).writeHeader(Mockito.<BufferedWriter>any());
		InOrder inOrder = Mockito.inOrder(auditCSVWriter);
		inOrder.verify(auditCSVWriter, Mockito.calls(1)).writeJournalLine(Mockito.<JournalLine>any(), Mockito.<BufferedWriter>any());
		inOrder.verify(auditCSVWriter, Mockito.calls(1)).writeJournalLine(Mockito.<JournalLine>any(), Mockito.<BufferedWriter>any());
		inOrder.verify(auditCSVWriter, Mockito.calls(1)).writeJournalLine(Mockito.<JournalLine>any(), Mockito.<BufferedWriter>any());
		inOrder.verify(auditCSVWriter, Mockito.calls(1)).writeJournalLine(Mockito.<JournalLine>any(), Mockito.<BufferedWriter>any());
		inOrder.verify(auditCSVWriter, Mockito.calls(1)).writeJournalLine(Mockito.<JournalLine>any(), Mockito.<BufferedWriter>any());
		inOrder.verify(auditCSVWriter, Mockito.calls(1)).writeJournalLine(Mockito.<JournalLine>any(), Mockito.<BufferedWriter>any());
		inOrder.verify(auditCSVWriter, Mockito.calls(1)).writeJournalLine(Mockito.<JournalLine>any(), Mockito.<BufferedWriter>any());
		inOrder.verify(auditCSVWriter, Mockito.calls(1)).writeJournalLine(Mockito.<JournalLine>any(), Mockito.<BufferedWriter>any());
	}
}
