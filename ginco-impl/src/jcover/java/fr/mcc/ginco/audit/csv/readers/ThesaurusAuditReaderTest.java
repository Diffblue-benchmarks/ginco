package fr.mcc.ginco.audit.csv.readers;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import fr.mcc.ginco.audit.csv.JournalLineBuilder;
import fr.mcc.ginco.audit.utils.AuditQueryBuilder;
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
 * Unit tests for fr.mcc.ginco.audit.csv.readers.ThesaurusAuditReader
 *
 * @author Diffblue Cover
 */

public class ThesaurusAuditReaderTest {

	@Mock(name = "auditQueryBuilder")
	private AuditQueryBuilder auditQueryBuilder;

	@Mock(name = "journalLineBuilder")
	private JournalLineBuilder journalLineBuilder;

	@InjectMocks
	private ThesaurusAuditReader service;

	@Before public void initMocks() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void getThesaurusAddedReturnsEmpty() throws org.hibernate.envers.exception.AuditException, javax.persistence.NonUniqueResultException, javax.persistence.NoResultException, java.text.ParseException {
		AuditQuery auditQuery = mock(AuditQuery.class);
		when(auditQuery.getResultList())
			.thenReturn(new ArrayList());
		when(auditQueryBuilder.getEntityAddedQuery(Mockito.<Thesaurus>any(), Mockito.<java.util.Date>any(), Mockito.<Class<?>>any()))
			.thenReturn(auditQuery);
		Thesaurus thesaurus = mock(Thesaurus.class);
		assertTrue((service.getThesaurusAdded(thesaurus, new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31"))).isEmpty());
	}
}
