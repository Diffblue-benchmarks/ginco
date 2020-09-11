package fr.mcc.ginco.services;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.when;

import fr.mcc.ginco.beans.Language;
import fr.mcc.ginco.beans.NodeLabel;
import fr.mcc.ginco.beans.ThesaurusArray;
import fr.mcc.ginco.dao.INodeLabelDAO;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

/**
 * Unit tests for fr.mcc.ginco.services.NodeLabelServiceImpl
 *
 * @author Diffblue Cover
 */

public class NodeLabelServiceImplTest {

	@Mock(name = "nodeLabelDAO")
	private INodeLabelDAO nodeLabelDAO;

	@InjectMocks
	private NodeLabelServiceImpl service;

	@Before public void initMocks() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void getByThesaurusArrayAndLanguageThesaurusArrayIdIsBar() throws java.text.ParseException {

		// arrange
		NodeLabel nodeLabel = new NodeLabel();
		Date created1 =
			 new java.text.SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31");
		nodeLabel.setCreated(created1);
		nodeLabel.setIdentifier(1);
		Language language = new Language();
		nodeLabel.setLanguage(language);
		nodeLabel.setLexicalValue("value");
		Date modified1 =
			 new java.text.SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31");
		nodeLabel.setModified(modified1);
		ThesaurusArray thesaurusArray = new ThesaurusArray();
		nodeLabel.setThesaurusArray(thesaurusArray);
		when(nodeLabelDAO.getByThesaurusArray(Mockito.<String>any()))
			.thenReturn(nodeLabel);

		// act
		NodeLabel result = service.getByThesaurusArrayAndLanguage("bar");

		// assert
		assertSame(created1, result.getCreated());
		assertEquals(1, (int) result.getIdentifier());
		assertSame(language, result.getLanguage());
		assertEquals("value", result.getLexicalValue());
		assertSame(modified1, result.getModified());
		assertSame(thesaurusArray, result.getThesaurusArray());
	}

	@Test
	public void getByThesaurusArrayThesaurusArrayIdIsBar() throws java.text.ParseException {

		// arrange
		NodeLabel nodeLabel = new NodeLabel();
		Date created1 =
			 new java.text.SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31");
		nodeLabel.setCreated(created1);
		nodeLabel.setIdentifier(1);
		Language language = new Language();
		nodeLabel.setLanguage(language);
		nodeLabel.setLexicalValue("value");
		Date modified1 =
			 new java.text.SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31");
		nodeLabel.setModified(modified1);
		ThesaurusArray thesaurusArray = new ThesaurusArray();
		nodeLabel.setThesaurusArray(thesaurusArray);
		when(nodeLabelDAO.getByThesaurusArray(Mockito.<String>any()))
			.thenReturn(nodeLabel);

		// act
		NodeLabel result = service.getByThesaurusArray("bar");

		// assert
		assertSame(created1, result.getCreated());
		assertEquals(1, (int) result.getIdentifier());
		assertSame(language, result.getLanguage());
		assertEquals("value", result.getLexicalValue());
		assertSame(modified1, result.getModified());
		assertSame(thesaurusArray, result.getThesaurusArray());
	}
}
