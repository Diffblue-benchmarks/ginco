package fr.mcc.ginco.audit.utils;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;

import fr.mcc.ginco.beans.ThesaurusConcept;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

/**
 * Unit tests for fr.mcc.ginco.audit.utils.AuditHelper
 *
 * @author Diffblue Cover
 */

public class AuditHelperTest {

	@Mock(name = "auditQueryBuilder")
	private AuditQueryBuilder auditQueryBuilder;

	@Mock(name = "auditReaderService")
	private AuditReaderService auditReaderService;

	@InjectMocks
	private AuditHelper service;

	@Before public void initMocks() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void getConceptChildrenAtRevisionRevisionNumberIsOneReturnsEmpty() {
		ThesaurusConcept concept = mock(ThesaurusConcept.class);
		ArrayList<ThesaurusConcept> allThesaurusConcepts =
			 new ArrayList<ThesaurusConcept>();
		allThesaurusConcepts.add(new ThesaurusConcept());
		assertTrue((service.getConceptChildrenAtRevision(1, concept, allThesaurusConcepts)).isEmpty());
	}
}
