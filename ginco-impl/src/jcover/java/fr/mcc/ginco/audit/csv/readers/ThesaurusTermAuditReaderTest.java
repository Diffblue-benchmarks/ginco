package fr.mcc.ginco.audit.csv.readers;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import fr.mcc.ginco.audit.csv.JournalLineBuilder;
import fr.mcc.ginco.audit.utils.AuditQueryBuilder;
import fr.mcc.ginco.audit.utils.AuditReaderService;
import fr.mcc.ginco.beans.Thesaurus;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

import org.hibernate.envers.query.AuditQuery;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

/**
 * Unit tests for fr.mcc.ginco.audit.csv.readers.ThesaurusTermAuditReader
 *
 * @author Diffblue Cover
 */

public class ThesaurusTermAuditReaderTest {

	@Mock(name = "auditQueryBuilder")
	private AuditQueryBuilder auditQueryBuilder;

	@Mock(name = "auditReaderService")
	private AuditReaderService auditReaderService;

	@Mock(name = "journalLineBuilder")
	private JournalLineBuilder journalLineBuilder;

	@InjectMocks
	private ThesaurusTermAuditReader service;

	@Before public void initMocks() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void getTermAttachmentChangedReturnsEmpty() throws org.hibernate.envers.exception.AuditException, javax.persistence.NonUniqueResultException, javax.persistence.NoResultException, java.text.ParseException {
		AuditQuery auditQuery = mock(AuditQuery.class);
		when(auditQuery.getResultList())
			.thenReturn(new ArrayList());
		when(auditQueryBuilder.getPropertyChangedQueryOnUpdate(Mockito.<Thesaurus>any(), Mockito.<java.util.Date>any(), Mockito.<Class<?>>any(), Mockito.<String>any()))
			.thenReturn(auditQuery);
		assertTrue((service.getTermAttachmentChanged(new Thesaurus(), new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31"))).isEmpty());
	}
}
