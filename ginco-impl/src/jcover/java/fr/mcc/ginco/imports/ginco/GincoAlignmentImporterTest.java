package fr.mcc.ginco.imports.ginco;

import static org.junit.Assert.assertTrue;

import fr.mcc.ginco.beans.Alignment;
import fr.mcc.ginco.beans.AlignmentConcept;
import fr.mcc.ginco.beans.AlignmentResource;
import fr.mcc.ginco.dao.IAlignmentDAO;
import fr.mcc.ginco.dao.IExternalThesaurusDAO;
import fr.mcc.ginco.dao.IGenericDAO;
import fr.mcc.ginco.dao.IThesaurusConceptDAO;
import fr.mcc.ginco.exports.result.bean.JaxbList;

import java.util.HashMap;
import java.util.HashSet;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

/**
 * Unit tests for fr.mcc.ginco.imports.ginco.GincoAlignmentImporter
 *
 * @author Diffblue Cover
 */

public class GincoAlignmentImporterTest {

	@Mock(name = "alignmentConceptDAO")
	private IGenericDAO<fr.mcc.ginco.beans.AlignmentConcept, Integer> alignmentConceptDAO;

	@Mock(name = "alignmentDAO")
	private IAlignmentDAO alignmentDAO;

	@Mock(name = "alignmentResourceDAO")
	private IGenericDAO<fr.mcc.ginco.beans.AlignmentResource, Integer> alignmentResourceDAO;

	@Mock(name = "externalThesaurusDAO")
	private IExternalThesaurusDAO externalThesaurusDAO;

	@Mock(name = "thesaurusConceptDAO")
	private IThesaurusConceptDAO thesaurusConceptDAO;

	@InjectMocks
	private GincoAlignmentImporter service;

	@Before public void initMocks() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void storeAlignmentsReturnsEmpty() {
		assertTrue((service.storeAlignments(new HashMap<String, JaxbList<Alignment>>())).isEmpty());
	}

	@Test
	public void storeExternalThesauruses() {
		service.storeExternalThesauruses(new HashMap<String, JaxbList<Alignment>>(), new HashSet<Alignment>());
	}
}
