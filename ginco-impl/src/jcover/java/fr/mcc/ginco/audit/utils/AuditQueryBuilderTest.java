package fr.mcc.ginco.audit.utils;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.hibernate.envers.query.AuditQuery;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

/**
 * Unit tests for fr.mcc.ginco.audit.utils.AuditQueryBuilder
 *
 * @author Diffblue Cover
 */

public class AuditQueryBuilderTest {

	@Mock(name = "auditReaderService")
	private AuditReaderService auditReaderService;

	@InjectMocks
	private AuditQueryBuilder service;

	@Before public void initMocks() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void addFilterOnLanguage() throws org.hibernate.envers.exception.AuditException, javax.persistence.NonUniqueResultException, javax.persistence.NoResultException {
		AuditQuery auditQuery = mock(AuditQuery.class);
		AuditQuery query = mock(AuditQuery.class);
		when(query.add(Mockito.<org.hibernate.envers.query.criteria.AuditCriterion>any()))
			.thenReturn(auditQuery);
		service.addFilterOnLanguage(query, "1234");
	}

	@Test
	public void getFilterOnStatusStatusIsOne() throws org.hibernate.envers.exception.AuditException, javax.persistence.NonUniqueResultException, javax.persistence.NoResultException {
		AuditQuery auditQuery = mock(AuditQuery.class);
		AuditQuery query = mock(AuditQuery.class);
		when(query.add(Mockito.<org.hibernate.envers.query.criteria.AuditCriterion>any()))
			.thenReturn(auditQuery);
		service.getFilterOnStatus(query, 1);
	}
}
