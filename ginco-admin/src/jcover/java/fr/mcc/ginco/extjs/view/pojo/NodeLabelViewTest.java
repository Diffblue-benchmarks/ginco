package fr.mcc.ginco.extjs.view.pojo;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

import org.junit.jupiter.api.Test;

/**
 * Unit tests for fr.mcc.ginco.extjs.view.pojo.NodeLabelView
 *
 * @author Diffblue Cover
 */

class NodeLabelViewTest {

	@Test
	void factory() {
		NodeLabelView nodeLabelView = new NodeLabelView();
		nodeLabelView.setCreated("someone");
		nodeLabelView.setIdentifier(1);
		nodeLabelView.setLanguage("label");
		nodeLabelView.setLexicalValue("value");
		nodeLabelView.setModified("label");
		nodeLabelView.setThesaurusArrayId("1234");
		assertThat(nodeLabelView.getCreated(), is("someone"));
		assertThat(nodeLabelView.getIdentifier(), is(1));
		assertThat(nodeLabelView.getLanguage(), is("label"));
		assertThat(nodeLabelView.getLexicalValue(), is("value"));
		assertThat(nodeLabelView.getModified(), is("label"));
		assertThat(nodeLabelView.getThesaurusArrayId(), is("1234"));
	}
}
