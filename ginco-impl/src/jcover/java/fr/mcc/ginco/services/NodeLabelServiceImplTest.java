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
	public void getByIdIdIsOne() throws java.text.ParseException {

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
		when(nodeLabelDAO.getById(Mockito.<Integer>any()))
			.thenReturn(nodeLabel);

		// act
		NodeLabel result = service.getById(1);

		// assert
		assertSame(created1, result.getCreated());
		assertEquals(1, (int) result.getIdentifier());
		assertSame(language, result.getLanguage());
		assertEquals("value", result.getLexicalValue());
		assertSame(modified1, result.getModified());
		assertSame(thesaurusArray, result.getThesaurusArray());
	}

	@Test
	public void getByThesaurusArrayAndLanguage() throws java.text.ParseException {

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
		NodeLabel result = service.getByThesaurusArrayAndLanguage("1234");

		// assert
		assertSame(created1, result.getCreated());
		assertEquals(1, (int) result.getIdentifier());
		assertSame(language, result.getLanguage());
		assertEquals("value", result.getLexicalValue());
		assertSame(modified1, result.getModified());
		assertSame(thesaurusArray, result.getThesaurusArray());
	}

	@Test
	public void getByThesaurusArray() throws java.text.ParseException {

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
		NodeLabel result = service.getByThesaurusArray("1234");

		// assert
		assertSame(created1, result.getCreated());
		assertEquals(1, (int) result.getIdentifier());
		assertSame(language, result.getLanguage());
		assertEquals("value", result.getLexicalValue());
		assertSame(modified1, result.getModified());
		assertSame(thesaurusArray, result.getThesaurusArray());
	}

	@Test
	public void updateOrCreate() throws java.text.ParseException {

		// arrange
		NodeLabel nodeLabel1 = new NodeLabel();
		Date created1 =
			 new java.text.SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31");
		nodeLabel1.setCreated(created1);
		nodeLabel1.setIdentifier(1);
		Language language1 = new Language();
		nodeLabel1.setLanguage(language1);
		nodeLabel1.setLexicalValue("value");
		Date modified1 =
			 new java.text.SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31");
		nodeLabel1.setModified(modified1);
		ThesaurusArray thesaurusArray1 = new ThesaurusArray();
		nodeLabel1.setThesaurusArray(thesaurusArray1);
		when(nodeLabelDAO.update(Mockito.<NodeLabel>any()))
			.thenReturn(nodeLabel1);

		// act
		NodeLabel result = service.updateOrCreate(new NodeLabel());

		// assert
		assertSame(created1, result.getCreated());
		assertEquals(1, (int) result.getIdentifier());
		assertSame(language1, result.getLanguage());
		assertEquals("value", result.getLexicalValue());
		assertSame(modified1, result.getModified());
		assertSame(thesaurusArray1, result.getThesaurusArray());
	}
}
