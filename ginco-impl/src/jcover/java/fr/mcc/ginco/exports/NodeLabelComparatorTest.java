package fr.mcc.ginco.exports;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import fr.mcc.ginco.beans.NodeLabel;
import fr.mcc.ginco.beans.ThesaurusArray;
import fr.mcc.ginco.services.INodeLabelService;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

/**
 * Unit tests for fr.mcc.ginco.exports.NodeLabelComparator
 *
 * @author Diffblue Cover
 */

public class NodeLabelComparatorTest {

	@Mock(name = "nodeLabelService")
	private INodeLabelService nodeLabelService;

	@InjectMocks
	private NodeLabelComparator service;

	@Before
	public void initMocks() throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		MockitoAnnotations.initMocks(this);
		NodeLabelComparator bean = service;
		java.lang.reflect.Field field =
			 NodeLabelComparator.class.getDeclaredField("defaultLang");
		field.setAccessible(true);
		field.set(bean, "${ginco.default.language}");
	}

	@Test
	public void compareReturnsOne() {
		NodeLabel nodeLabel1 = new NodeLabel();
		nodeLabel1.setLexicalValue("bar");
		NodeLabel nodeLabel2 = new NodeLabel();
		nodeLabel2.setLexicalValue("value");
		when(nodeLabelService.getByThesaurusArray(Mockito.<String>any()))
			.thenReturn(nodeLabel2)
			.thenReturn(nodeLabel1);
		assertEquals(1, service.compare(new ThesaurusArray(), new ThesaurusArray()));
	}

	@Test
	public void compareReturnsZero() {
		NodeLabel nodeLabel1 = new NodeLabel();
		nodeLabel1.setLexicalValue("value");
		NodeLabel nodeLabel2 = new NodeLabel();
		nodeLabel2.setLexicalValue("value");
		when(nodeLabelService.getByThesaurusArray(Mockito.<String>any()))
			.thenReturn(nodeLabel2)
			.thenReturn(nodeLabel1);
		assertEquals(0, service.compare(new ThesaurusArray(), new ThesaurusArray()));
	}
}