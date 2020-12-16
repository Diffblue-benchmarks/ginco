package fr.mcc.ginco.dao.hibernate;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import fr.mcc.ginco.beans.Language;
import fr.mcc.ginco.beans.Thesaurus;
import fr.mcc.ginco.beans.ThesaurusConcept;
import fr.mcc.ginco.beans.ThesaurusTerm;
import fr.mcc.ginco.beans.ThesaurusTermRole;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.FlushMode;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;
import org.mockito.Mockito;

/**
 * Unit tests for fr.mcc.ginco.dao.hibernate.ThesaurusTermDAO
 *
 * @author Diffblue Cover
 */

public class ThesaurusTermDAOTest {

	@Test
	public void factory() {
		ThesaurusTermDAO thesaurusTermDAO = new ThesaurusTermDAO();
		SessionFactory sessionFactory = mock(SessionFactory.class);
		thesaurusTermDAO.setSessionFactory(sessionFactory);
		assertSame(sessionFactory, thesaurusTermDAO.getSessionFactory());
	}

	@Test
	public void findPaginatedSandboxedItemsLimitIsOneAndStartIsOne() throws org.hibernate.HibernateException {

		// arrange
		ThesaurusTermDAO thesaurusTermDAO = new ThesaurusTermDAO();
		ArrayList<String> arrayList = new ArrayList<String>();
		arrayList.add("Smith");
		Criteria criteria1 = mock(Criteria.class);
		Criteria criteria2 = mock(Criteria.class);
		when(criteria2.addOrder(Mockito.<org.hibernate.criterion.Order>any()))
			.thenReturn(criteria1);
		Criteria criteria3 = mock(Criteria.class);
		when(criteria3.setFirstResult(anyInt()))
			.thenReturn(criteria2);
		Criteria criteria4 = mock(Criteria.class);
		when(criteria4.add(Mockito.<org.hibernate.criterion.Criterion>any()))
			.thenReturn(criteria3);
		Criteria criteria5 = mock(Criteria.class);
		when(criteria5.add(Mockito.<org.hibernate.criterion.Criterion>any()))
			.thenReturn(criteria4);
		Criteria criteria6 = mock(Criteria.class);
		when(criteria6.list())
			.thenReturn(arrayList);
		when(criteria6.setMaxResults(anyInt()))
			.thenReturn(criteria5);
		Session session = mock(Session.class);
		when(session.createCriteria(Mockito.<Class>any()))
			.thenReturn(criteria6);
		SessionFactory sessionFactory = mock(SessionFactory.class);
		when(sessionFactory.getCurrentSession())
			.thenReturn(session);
		thesaurusTermDAO.setSessionFactory(sessionFactory);

		// act
		List<ThesaurusTerm> result =
			 thesaurusTermDAO.findPaginatedSandboxedItems(1, 1, "1234");

		// assert
		assertEquals(1, result.size());
		// pojo String (String) result.get(0)
	}

	@Test
	public void findPaginatedSandboxedValidatedItemsLimitIsOneAndStartIndexIsOne() throws org.hibernate.HibernateException {

		// arrange
		ThesaurusTermDAO thesaurusTermDAO = new ThesaurusTermDAO();
		ArrayList<String> arrayList = new ArrayList<String>();
		arrayList.add("Smith");
		Criteria criteria1 = mock(Criteria.class);
		Criteria criteria2 = mock(Criteria.class);
		Criteria criteria3 = mock(Criteria.class);
		when(criteria3.addOrder(Mockito.<org.hibernate.criterion.Order>any()))
			.thenReturn(criteria2);
		Criteria criteria4 = mock(Criteria.class);
		when(criteria4.setFirstResult(anyInt()))
			.thenReturn(criteria3);
		Criteria criteria5 = mock(Criteria.class);
		when(criteria5.add(Mockito.<org.hibernate.criterion.Criterion>any()))
			.thenReturn(criteria4);
		Criteria criteria6 = mock(Criteria.class);
		when(criteria6.add(Mockito.<org.hibernate.criterion.Criterion>any()))
			.thenReturn(criteria5);
		Criteria criteria7 = mock(Criteria.class);
		when(criteria7.add(Mockito.<org.hibernate.criterion.Criterion>any()))
			.thenReturn(criteria1);
		when(criteria7.list())
			.thenReturn(arrayList);
		when(criteria7.setMaxResults(anyInt()))
			.thenReturn(criteria6);
		Session session = mock(Session.class);
		when(session.createCriteria(Mockito.<Class>any()))
			.thenReturn(criteria7);
		SessionFactory sessionFactory = mock(SessionFactory.class);
		when(sessionFactory.getCurrentSession())
			.thenReturn(session);
		thesaurusTermDAO.setSessionFactory(sessionFactory);

		// act
		List<ThesaurusTerm> result =
			 thesaurusTermDAO.findPaginatedSandboxedValidatedItems(1, 1, "1234");

		// assert
		assertEquals(1, result.size());
		// pojo String (String) result.get(0)
	}

	@Test
	public void getConceptPreferredTermConceptIdIsBarReturnsNull() throws org.hibernate.HibernateException {
		ThesaurusTermDAO thesaurusTermDAO = new ThesaurusTermDAO();
		Criteria criteria1 = mock(Criteria.class);
		when(criteria1.list())
			.thenReturn(new ArrayList<String>());
		Criteria criteria2 = mock(Criteria.class);
		when(criteria2.add(Mockito.<org.hibernate.criterion.Criterion>any()))
			.thenReturn(criteria1);
		Criteria criteria3 = mock(Criteria.class);
		when(criteria3.add(Mockito.<org.hibernate.criterion.Criterion>any()))
			.thenReturn(criteria2);
		Criteria criteria4 = mock(Criteria.class);
		when(criteria4.add(Mockito.<org.hibernate.criterion.Criterion>any()))
			.thenReturn(criteria3);
		Session session = mock(Session.class);
		when(session.createCriteria(Mockito.<Class>any()))
			.thenReturn(criteria4);
		SessionFactory sessionFactory = mock(SessionFactory.class);
		when(sessionFactory.getCurrentSession())
			.thenReturn(session);
		thesaurusTermDAO.setSessionFactory(sessionFactory);
		assertNull(thesaurusTermDAO.getConceptPreferredTerm("bar", "1234"));
	}

	@Test
	public void findTermsByConceptId() throws org.hibernate.HibernateException {

		// arrange
		ThesaurusTermDAO thesaurusTermDAO = new ThesaurusTermDAO();
		ArrayList<String> arrayList = new ArrayList<String>();
		arrayList.add("Smith");
		Criteria criteria1 = mock(Criteria.class);
		when(criteria1.list())
			.thenReturn(arrayList);
		Criteria criteria2 = mock(Criteria.class);
		when(criteria2.add(Mockito.<org.hibernate.criterion.Criterion>any()))
			.thenReturn(criteria1);
		Session session = mock(Session.class);
		when(session.createCriteria(Mockito.<Class>any()))
			.thenReturn(criteria2);
		SessionFactory sessionFactory = mock(SessionFactory.class);
		when(sessionFactory.getCurrentSession())
			.thenReturn(session);
		thesaurusTermDAO.setSessionFactory(sessionFactory);

		// act
		List<ThesaurusTerm> result = thesaurusTermDAO.findTermsByConceptId("1234");

		// assert
		assertEquals(1, result.size());
		// pojo String (String) result.get(0)
	}

	@Test
	public void findTermsByThesaurusId() throws org.hibernate.HibernateException {

		// arrange
		ThesaurusTermDAO thesaurusTermDAO = new ThesaurusTermDAO();
		ArrayList<String> arrayList = new ArrayList<String>();
		arrayList.add("Smith");
		Criteria criteria1 = mock(Criteria.class);
		when(criteria1.list())
			.thenReturn(arrayList);
		Criteria criteria2 = mock(Criteria.class);
		when(criteria2.add(Mockito.<org.hibernate.criterion.Criterion>any()))
			.thenReturn(criteria1);
		Session session = mock(Session.class);
		when(session.createCriteria(Mockito.<Class>any()))
			.thenReturn(criteria2);
		SessionFactory sessionFactory = mock(SessionFactory.class);
		when(sessionFactory.getCurrentSession())
			.thenReturn(session);
		thesaurusTermDAO.setSessionFactory(sessionFactory);

		// act
		List<ThesaurusTerm> result = thesaurusTermDAO.findTermsByThesaurusId("1234");

		// assert
		assertEquals(1, result.size());
		// pojo String (String) result.get(0)
	}

	@Test
	public void update() throws org.hibernate.HibernateException {
		ThesaurusTermDAO thesaurusTermDAO = new ThesaurusTermDAO();
		Session session1 = mock(Session.class);
		Session session2 = mock(Session.class);
		SessionFactory sessionFactory = mock(SessionFactory.class);
		when(sessionFactory.getCurrentSession())
			.thenReturn(session2)
			.thenReturn(session1);
		thesaurusTermDAO.setSessionFactory(sessionFactory);
		ThesaurusTerm termToUpdate = new ThesaurusTerm();
		termToUpdate.setHidden(false);
		assertSame(termToUpdate, thesaurusTermDAO.update(termToUpdate, false));
		Mockito.verify(session1).saveOrUpdate(Mockito.<Object>any());
		Mockito.verify(session2).setFlushMode(Mockito.<FlushMode>any());
	}

	@Test
	public void getTermByLexicalValueThesaurusIdLanguageIdLexicalValueIsValue() throws java.text.ParseException, org.hibernate.HibernateException {

		// arrange
		ThesaurusTermDAO thesaurusTermDAO = new ThesaurusTermDAO();
		ThesaurusTerm thesaurusTerm = new ThesaurusTerm();
		ThesaurusConcept concept = new ThesaurusConcept();
		thesaurusTerm.setConcept(concept);
		Date created3 = new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31");
		thesaurusTerm.setCreated(created3);
		thesaurusTerm.setHidden(false);
		thesaurusTerm.setIdentifier("data");
		Language language = new Language();
		thesaurusTerm.setLanguage(language);
		thesaurusTerm.setLexicalValue("value");
		Date modified2 = new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31");
		thesaurusTerm.setModified(modified2);
		thesaurusTerm.setPrefered(false);
		ThesaurusTermRole role = new ThesaurusTermRole();
		thesaurusTerm.setRole(role);
		thesaurusTerm.setSource("foo");
		thesaurusTerm.setStatus(1);
		Thesaurus thesaurus2 = new Thesaurus();
		thesaurusTerm.setThesaurus(thesaurus2);
		Criteria criteria1 = mock(Criteria.class);
		when(criteria1.uniqueResult())
			.thenReturn(thesaurusTerm);
		Criteria criteria2 = mock(Criteria.class);
		when(criteria2.add(Mockito.<org.hibernate.criterion.Criterion>any()))
			.thenReturn(criteria1);
		Criteria criteria3 = mock(Criteria.class);
		when(criteria3.add(Mockito.<org.hibernate.criterion.Criterion>any()))
			.thenReturn(criteria2);
		Criteria criteria4 = mock(Criteria.class);
		when(criteria4.add(Mockito.<org.hibernate.criterion.Criterion>any()))
			.thenReturn(criteria3);
		Session session = mock(Session.class);
		when(session.createCriteria(Mockito.<Class>any()))
			.thenReturn(criteria4);
		SessionFactory sessionFactory = mock(SessionFactory.class);
		when(sessionFactory.getCurrentSession())
			.thenReturn(session);
		thesaurusTermDAO.setSessionFactory(sessionFactory);

		// act
		ThesaurusTerm result =
			 thesaurusTermDAO.getTermByLexicalValueThesaurusIdLanguageId("value", "1234", "1234");

		// assert
		assertSame(concept, result.getConcept());
		assertSame(created3, result.getCreated());
		assertFalse(result.getHidden());
		assertEquals("data", result.getIdentifier());
		assertSame(language, result.getLanguage());
		assertEquals("value", result.getLexicalValue());
		assertSame(modified2, result.getModified());
		assertFalse(result.getPrefered());
		assertSame(role, result.getRole());
		assertEquals("foo", result.getSource());
		assertEquals(1, (int) result.getStatus());
		assertSame(thesaurus2, result.getThesaurus());
	}

	@Test
	public void findPaginatedPreferredItemsOnlyNotOrphanConceptsIsFalseAndStartIndexIsZero() throws org.hibernate.HibernateException {

		// arrange
		ThesaurusTermDAO thesaurusTermDAO = new ThesaurusTermDAO();
		ArrayList<String> arrayList = new ArrayList<String>();
		arrayList.add("Smith");
		Criteria criteria1 = mock(Criteria.class);
		when(criteria1.list())
			.thenReturn(arrayList);
		Criteria criteria2 = mock(Criteria.class);
		Criteria criteria3 = mock(Criteria.class);
		when(criteria3.addOrder(Mockito.<org.hibernate.criterion.Order>any()))
			.thenReturn(criteria2);
		Criteria criteria4 = mock(Criteria.class);
		when(criteria4.setFirstResult(anyInt()))
			.thenReturn(criteria3);
		Criteria criteria5 = mock(Criteria.class);
		when(criteria5.add(Mockito.<org.hibernate.criterion.Criterion>any()))
			.thenReturn(criteria4);
		Criteria criteria6 = mock(Criteria.class);
		Criteria criteria7 = mock(Criteria.class);
		when(criteria7.add(Mockito.<org.hibernate.criterion.Criterion>any()))
			.thenReturn(criteria6)
			.thenReturn(criteria5);
		when(criteria7.setMaxResults(anyInt()))
			.thenReturn(criteria1);
		Session session = mock(Session.class);
		when(session.createCriteria(Mockito.<Class>any(), Mockito.<String>any()))
			.thenReturn(criteria7);
		SessionFactory sessionFactory = mock(SessionFactory.class);
		when(sessionFactory.getCurrentSession())
			.thenReturn(session);
		thesaurusTermDAO.setSessionFactory(sessionFactory);

		// act
		List<ThesaurusTerm> result =
			 thesaurusTermDAO.findPaginatedPreferredItems(0, 1, "1234", false);

		// assert
		assertEquals(1, result.size());
		// pojo String (String) result.get(0)
	}

	@Test
	public void findPaginatedPreferredItemsOnlyNotOrphanConceptsIsNullAndStartIndexIsOne() throws org.hibernate.HibernateException {

		// arrange
		ThesaurusTermDAO thesaurusTermDAO = new ThesaurusTermDAO();
		ArrayList<String> arrayList = new ArrayList<String>();
		arrayList.add("Smith");
		Criteria criteria1 = mock(Criteria.class);
		when(criteria1.list())
			.thenReturn(arrayList);
		Criteria criteria2 = mock(Criteria.class);
		Criteria criteria3 = mock(Criteria.class);
		when(criteria3.addOrder(Mockito.<org.hibernate.criterion.Order>any()))
			.thenReturn(criteria2);
		Criteria criteria4 = mock(Criteria.class);
		when(criteria4.setFirstResult(anyInt()))
			.thenReturn(criteria3);
		Criteria criteria5 = mock(Criteria.class);
		when(criteria5.add(Mockito.<org.hibernate.criterion.Criterion>any()))
			.thenReturn(criteria4);
		Criteria criteria6 = mock(Criteria.class);
		Criteria criteria7 = mock(Criteria.class);
		when(criteria7.add(Mockito.<org.hibernate.criterion.Criterion>any()))
			.thenReturn(criteria6)
			.thenReturn(criteria5);
		when(criteria7.setMaxResults(anyInt()))
			.thenReturn(criteria1);
		Session session = mock(Session.class);
		when(session.createCriteria(Mockito.<Class>any(), Mockito.<String>any()))
			.thenReturn(criteria7);
		SessionFactory sessionFactory = mock(SessionFactory.class);
		when(sessionFactory.getCurrentSession())
			.thenReturn(session);
		thesaurusTermDAO.setSessionFactory(sessionFactory);

		// act
		List<ThesaurusTerm> result =
			 thesaurusTermDAO.findPaginatedPreferredItems(1, 1, "1234", null);

		// assert
		assertEquals(1, result.size());
		// pojo String (String) result.get(0)
	}

	@Test
	public void getConceptNotPreferredTerms() throws org.hibernate.HibernateException {

		// arrange
		ThesaurusTermDAO thesaurusTermDAO = new ThesaurusTermDAO();
		ArrayList<String> arrayList = new ArrayList<String>();
		arrayList.add("Smith");
		Criteria criteria1 = mock(Criteria.class);
		when(criteria1.list())
			.thenReturn(arrayList);
		Criteria criteria2 = mock(Criteria.class);
		when(criteria2.add(Mockito.<org.hibernate.criterion.Criterion>any()))
			.thenReturn(criteria1);
		Criteria criteria3 = mock(Criteria.class);
		when(criteria3.add(Mockito.<org.hibernate.criterion.Criterion>any()))
			.thenReturn(criteria2);
		Session session = mock(Session.class);
		when(session.createCriteria(Mockito.<Class>any()))
			.thenReturn(criteria3);
		SessionFactory sessionFactory = mock(SessionFactory.class);
		when(sessionFactory.getCurrentSession())
			.thenReturn(session);
		thesaurusTermDAO.setSessionFactory(sessionFactory);

		// act
		List<ThesaurusTerm> result =
			 thesaurusTermDAO.getConceptNotPreferredTerms("1234");

		// assert
		assertEquals(1, result.size());
		// pojo String (String) result.get(0)
	}

	@Test
	public void getConceptPreferredTerms() throws org.hibernate.HibernateException {

		// arrange
		ThesaurusTermDAO thesaurusTermDAO = new ThesaurusTermDAO();
		ArrayList<String> arrayList = new ArrayList<String>();
		arrayList.add("Smith");
		Criteria criteria1 = mock(Criteria.class);
		when(criteria1.list())
			.thenReturn(arrayList);
		Criteria criteria2 = mock(Criteria.class);
		when(criteria2.add(Mockito.<org.hibernate.criterion.Criterion>any()))
			.thenReturn(criteria1);
		Criteria criteria3 = mock(Criteria.class);
		when(criteria3.add(Mockito.<org.hibernate.criterion.Criterion>any()))
			.thenReturn(criteria2);
		Session session = mock(Session.class);
		when(session.createCriteria(Mockito.<Class>any()))
			.thenReturn(criteria3);
		SessionFactory sessionFactory = mock(SessionFactory.class);
		when(sessionFactory.getCurrentSession())
			.thenReturn(session);
		thesaurusTermDAO.setSessionFactory(sessionFactory);

		// act
		List<ThesaurusTerm> result =
			 thesaurusTermDAO.getConceptPreferredTerms("1234");

		// assert
		assertEquals(1, result.size());
		// pojo String (String) result.get(0)
	}

	@Test
	public void getTermsWoNotesLimitIsOneAndStartIndexIsOne() throws org.hibernate.HibernateException {

		// arrange
		ThesaurusTermDAO thesaurusTermDAO = new ThesaurusTermDAO();
		ArrayList<String> arrayList = new ArrayList<String>();
		arrayList.add("Smith");
		Query query1 = mock(Query.class);
		Query query2 = mock(Query.class);
		Query query3 = mock(Query.class);
		Query query4 = mock(Query.class);
		SQLQuery obj1 = mock(SQLQuery.class);
		when(obj1.list())
			.thenReturn(arrayList);
		when(obj1.setFetchSize(anyInt()))
			.thenReturn(query2);
		when(obj1.setFirstResult(anyInt()))
			.thenReturn(query3);
		when(obj1.setMaxResults(anyInt()))
			.thenReturn(query1);
		when(obj1.setParameter(Mockito.<String>any(), Mockito.<Object>any()))
			.thenReturn(query4);
		SQLQuery obj2 = mock(SQLQuery.class);
		when(obj2.addEntity(Mockito.<Class>any()))
			.thenReturn(obj1);
		Session session = mock(Session.class);
		when(session.createSQLQuery(Mockito.<String>any()))
			.thenReturn(obj2);
		SessionFactory sessionFactory = mock(SessionFactory.class);
		when(sessionFactory.getCurrentSession())
			.thenReturn(session);
		thesaurusTermDAO.setSessionFactory(sessionFactory);

		// act
		List<ThesaurusTerm> result = thesaurusTermDAO.getTermsWoNotes("1234", 1, 1);

		// assert
		assertEquals(1, result.size());
		// pojo String (String) result.get(0)
	}
}
