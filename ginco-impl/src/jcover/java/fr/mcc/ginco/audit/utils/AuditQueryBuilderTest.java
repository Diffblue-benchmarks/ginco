package fr.mcc.ginco.audit.utils;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import fr.mcc.ginco.beans.Thesaurus;

import java.text.SimpleDateFormat;

import org.hibernate.cfg.Configuration;
import org.hibernate.envers.AuditReader;
import org.hibernate.envers.configuration.AuditConfiguration;
import org.hibernate.envers.query.AuditQuery;
import org.hibernate.envers.query.AuditQueryCreator;
import org.hibernate.envers.reader.AuditReaderImplementor;
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

	@Before
	public void initMocks() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void getEntityAddedQuery() throws java.text.ParseException {
		AuditReaderImplementor auditReaderImplementor =
			 mock(AuditReaderImplementor.class);
		AuditReader auditReader = mock(AuditReader.class);
		when(auditReader.createQuery())
			.thenReturn(new AuditQueryCreator(new AuditConfiguration(new Configuration()), auditReaderImplementor));
		when(auditReaderService.getAuditReader())
			.thenReturn(auditReader);
		// pojo AuditQuery service.getEntityAddedQuery(new Thesaurus(), new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31"), String.class)
	}

	@Test
	public void getPropertyChangedQueryOnUpdateClazzIsStringAndPropertyNameIsAcme() throws java.text.ParseException {
		AuditReaderImplementor auditReaderImplementor =
			 mock(AuditReaderImplementor.class);
		AuditReader auditReader = mock(AuditReader.class);
		when(auditReader.createQuery())
			.thenReturn(new AuditQueryCreator(new AuditConfiguration(new Configuration()), auditReaderImplementor));
		when(auditReaderService.getAuditReader())
			.thenReturn(auditReader);
		// pojo AuditQuery service.getPropertyChangedQueryOnUpdate(new Thesaurus(), new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31"), String.class, "Acme")
	}

	@Test
	public void getPreviousVersionQueryClazzIsStringAndCurrentRevisionIsOneAndIdentifierIsData() {
		AuditReaderImplementor auditReaderImplementor =
			 mock(AuditReaderImplementor.class);
		AuditReader auditReader = mock(AuditReader.class);
		when(auditReader.createQuery())
			.thenReturn(new AuditQueryCreator(new AuditConfiguration(new Configuration()), auditReaderImplementor));
		when(auditReaderService.getAuditReader())
			.thenReturn(auditReader);
		// pojo AuditQuery service.getPreviousVersionQuery(String.class, "data", 1)
	}

	@Test
	public void getPreviousPreferredTermQueryCurrentRevisionIsOne() {
		AuditReaderImplementor auditReaderImplementor =
			 mock(AuditReaderImplementor.class);
		AuditReader auditReader = mock(AuditReader.class);
		when(auditReader.createQuery())
			.thenReturn(new AuditQueryCreator(new AuditConfiguration(new Configuration()), auditReaderImplementor));
		when(auditReaderService.getAuditReader())
			.thenReturn(auditReader);
		// pojo AuditQuery service.getPreviousPreferredTermQuery(1, "1234")
	}

	@Test
	public void getEntityAddedQueryIdentifierIsData() {
		AuditReaderImplementor auditReaderImplementor =
			 mock(AuditReaderImplementor.class);
		AuditReader reader = mock(AuditReader.class);
		when(reader.createQuery())
			.thenReturn(new AuditQueryCreator(new AuditConfiguration(new Configuration()), auditReaderImplementor));
		// pojo AuditQuery service.getEntityAddedQuery(reader, String.class, "data")
	}

	@Test
	public void addFilterOnLanguage() {
		AuditQuery auditQuery = mock(AuditQuery.class);
		AuditQuery query = mock(AuditQuery.class);
		when(query.add(Mockito.<org.hibernate.envers.query.criteria.AuditCriterion>any()))
			.thenReturn(auditQuery);
		service.addFilterOnLanguage(query, "1234");
	}

	@Test
	public void getEntityAtRevisionClazzIsStringAndRevisionIsOne() {
		AuditReaderImplementor auditReaderImplementor =
			 mock(AuditReaderImplementor.class);
		AuditReader auditReader = mock(AuditReader.class);
		when(auditReader.createQuery())
			.thenReturn(new AuditQueryCreator(new AuditConfiguration(new Configuration()), auditReaderImplementor));
		when(auditReaderService.getAuditReader())
			.thenReturn(auditReader);
		// pojo AuditQuery service.getEntityAtRevision(String.class, 1, "1234")
	}

	@Test
	public void getFilterOnStatusStatusIsOne() {
		AuditQuery auditQuery = mock(AuditQuery.class);
		AuditQuery query = mock(AuditQuery.class);
		when(query.add(Mockito.<org.hibernate.envers.query.criteria.AuditCriterion>any()))
			.thenReturn(auditQuery);
		service.getFilterOnStatus(query, 1);
	}
}
