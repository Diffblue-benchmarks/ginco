package fr.mcc.ginco.audit.utils;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import fr.mcc.ginco.beans.Thesaurus;

import java.io.Serializable;
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

	@Before public void initMocks() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void getEntityAddedQuery2() throws IllegalArgumentException, org.hibernate.envers.exception.NotAuditedException, IllegalStateException, org.hibernate.envers.exception.RevisionDoesNotExistException, org.hibernate.envers.exception.AuditException, org.hibernate.HibernateException, java.text.ParseException {
		AuditReaderImplementor auditReaderImplementor =
			 mock(AuditReaderImplementor.class);
		AuditReader auditReader = mock(AuditReader.class);
		when(auditReader.createQuery())
			.thenReturn(new AuditQueryCreator(new AuditConfiguration(new Configuration()), auditReaderImplementor));
		when(auditReaderService.getAuditReader())
			.thenReturn(auditReader);
		// pojo AuditQuery
	}

	@Test
	public void getPropertyChangedQueryOnUpdateClazzIsStringAndPropertyNameIsAcme() throws IllegalArgumentException, org.hibernate.envers.exception.NotAuditedException, IllegalStateException, org.hibernate.envers.exception.RevisionDoesNotExistException, org.hibernate.envers.exception.AuditException, org.hibernate.HibernateException, java.text.ParseException {
		AuditReaderImplementor auditReaderImplementor =
			 mock(AuditReaderImplementor.class);
		AuditReader auditReader = mock(AuditReader.class);
		when(auditReader.createQuery())
			.thenReturn(new AuditQueryCreator(new AuditConfiguration(new Configuration()), auditReaderImplementor));
		when(auditReaderService.getAuditReader())
			.thenReturn(auditReader);
		// pojo AuditQuery
	}

	@Test
	public void getPreviousVersionQueryClazzIsStringAndCurrentRevisionIsOne() throws IllegalArgumentException, org.hibernate.envers.exception.NotAuditedException, IllegalStateException, org.hibernate.envers.exception.RevisionDoesNotExistException, org.hibernate.envers.exception.AuditException, org.hibernate.HibernateException {
		AuditReaderImplementor auditReaderImplementor =
			 mock(AuditReaderImplementor.class);
		AuditReader auditReader = mock(AuditReader.class);
		when(auditReader.createQuery())
			.thenReturn(new AuditQueryCreator(new AuditConfiguration(new Configuration()), auditReaderImplementor));
		when(auditReaderService.getAuditReader())
			.thenReturn(auditReader);
		Serializable identifier = mock(Serializable.class);
		// pojo AuditQuery
	}

	@Test
	public void getPreviousPreferredTermQueryCurrentRevisionIsOne() throws IllegalArgumentException, org.hibernate.envers.exception.NotAuditedException, IllegalStateException, org.hibernate.envers.exception.RevisionDoesNotExistException, org.hibernate.envers.exception.AuditException, org.hibernate.HibernateException {
		AuditReaderImplementor auditReaderImplementor =
			 mock(AuditReaderImplementor.class);
		AuditReader auditReader = mock(AuditReader.class);
		when(auditReader.createQuery())
			.thenReturn(new AuditQueryCreator(new AuditConfiguration(new Configuration()), auditReaderImplementor));
		when(auditReaderService.getAuditReader())
			.thenReturn(auditReader);
		// pojo AuditQuery
	}

	@Test
	public void getEntityAddedQuery1() throws IllegalArgumentException, org.hibernate.envers.exception.NotAuditedException, IllegalStateException, org.hibernate.envers.exception.RevisionDoesNotExistException, org.hibernate.envers.exception.AuditException, org.hibernate.HibernateException {
		AuditReaderImplementor auditReaderImplementor =
			 mock(AuditReaderImplementor.class);
		AuditReader reader = mock(AuditReader.class);
		when(reader.createQuery())
			.thenReturn(new AuditQueryCreator(new AuditConfiguration(new Configuration()), auditReaderImplementor));
		Serializable identifier = mock(Serializable.class);
		// pojo AuditQuery
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
	public void getEntityAtRevisionClazzIsStringAndRevisionIsOne() throws IllegalArgumentException, org.hibernate.envers.exception.NotAuditedException, IllegalStateException, org.hibernate.envers.exception.RevisionDoesNotExistException, org.hibernate.envers.exception.AuditException, org.hibernate.HibernateException {
		AuditReaderImplementor auditReaderImplementor =
			 mock(AuditReaderImplementor.class);
		AuditReader auditReader = mock(AuditReader.class);
		when(auditReader.createQuery())
			.thenReturn(new AuditQueryCreator(new AuditConfiguration(new Configuration()), auditReaderImplementor));
		when(auditReaderService.getAuditReader())
			.thenReturn(auditReader);
		// pojo AuditQuery
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
