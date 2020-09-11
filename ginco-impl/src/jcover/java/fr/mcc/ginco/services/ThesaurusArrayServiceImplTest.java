package fr.mcc.ginco.services;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import fr.mcc.ginco.beans.ThesaurusArray;
import fr.mcc.ginco.dao.IThesaurusArrayDAO;
import fr.mcc.ginco.dao.IThesaurusConceptDAO;
import fr.mcc.ginco.helpers.ThesaurusArrayHelper;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

/**
 * Unit tests for fr.mcc.ginco.services.ThesaurusArrayServiceImpl
 *
 * @author Diffblue Cover
 */

public class ThesaurusArrayServiceImplTest {

	@Mock(name = "nodeLabelService")
	private INodeLabelService nodeLabelService;

	@Mock(name = "thesaurusArrayDAO")
	private IThesaurusArrayDAO thesaurusArrayDAO;

	@Mock(name = "thesaurusArrayHelper")
	private ThesaurusArrayHelper thesaurusArrayHelper;

	@Mock(name = "thesaurusConceptDAO")
	private IThesaurusConceptDAO thesaurusConceptDAO;

	@InjectMocks
	private ThesaurusArrayServiceImpl service;

	@Before public void initMocks() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void getAllThesaurusArrayByThesaurusIdReturnsEmpty() {
		when(thesaurusArrayDAO.getThesaurusArrayListByThesaurusId(Mockito.<String>any(), Mockito.<String>any()))
			.thenReturn(new ArrayList<ThesaurusArray>());
		assertTrue((service.getAllThesaurusArrayByThesaurusId("1234", "1234")).isEmpty());
	}
}
