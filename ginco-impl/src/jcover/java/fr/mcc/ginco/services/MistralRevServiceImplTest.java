package fr.mcc.ginco.services;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import fr.mcc.ginco.audit.commands.HierarchyCommandBuilder;
import fr.mcc.ginco.audit.commands.SynonymsCommandBuilder;
import fr.mcc.ginco.audit.commands.TermCommandBuilder;
import fr.mcc.ginco.audit.utils.AuditQueryBuilder;
import fr.mcc.ginco.audit.utils.AuditReaderService;
import fr.mcc.ginco.beans.Language;
import fr.mcc.ginco.beans.Thesaurus;

import java.util.ArrayList;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

/**
 * Unit tests for fr.mcc.ginco.services.MistralRevServiceImpl
 *
 * @author Diffblue Cover
 */

public class MistralRevServiceImplTest {

	@Mock(name = "auditQueryBuilder")
	private AuditQueryBuilder auditQueryBuilder;

	@Mock(name = "auditReaderService")
	private AuditReaderService auditReaderService;

	@Mock(name = "gincoSessionFactory")
	private SessionFactory gincoSessionFactory;

	@Mock(name = "hierarchyCommandBuilder")
	private HierarchyCommandBuilder hierarchyCommandBuilder;

	@Mock(name = "synonymsCommandBuilder")
	private SynonymsCommandBuilder synonymsCommandBuilder;

	@Mock(name = "termCommandBuilder")
	private TermCommandBuilder termCommandBuilder;

	@Mock(name = "thesaurusService")
	private IThesaurusService thesaurusService;

	@InjectMocks
	private MistralRevServiceImpl service;

	@Before
	public void initMocks() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void getAllRevisionsTimestampIsOne() throws org.hibernate.HibernateException, java.io.IOException {
		when(thesaurusService.getThesaurusById(Mockito.<String>any()))
			.thenReturn(new Thesaurus());
		when(thesaurusService.getThesaurusList())
			.thenReturn(new ArrayList<Thesaurus>());
		ArrayList<String> stringList = new ArrayList<String>();
		stringList.add("Smith");
		Query query = mock(Query.class);
		SQLQuery obj = mock(SQLQuery.class);
		when(obj.list())
			.thenReturn(stringList);
		when(obj.setLong(Mockito.<String>any(), anyLong()))
			.thenReturn(query);
		Session session = mock(Session.class);
		when(session.createSQLQuery(Mockito.<String>any()))
			.thenReturn(obj);
		when(gincoSessionFactory.getCurrentSession())
			.thenReturn(session);
		assertTrue(service.getAllRevisions(1L, new Language()).getPath().startsWith(System.getProperty("java.io.tmpdir")));
	}
}
