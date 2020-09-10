package fr.mcc.ginco.extjs.view.node;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.empty;
import static org.hamcrest.core.Is.is;

import fr.mcc.ginco.extjs.view.enums.ThesaurusListNodeType;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

/**
 * Unit tests for fr.mcc.ginco.extjs.view.node.WarningNode
 *
 * @author Diffblue Cover
 */

class WarningNodeTest {

	@Test
	void factory() {
		WarningNode warningNode = new WarningNode(1);
		warningNode.setChildren(new ArrayList<IThesaurusListNode>());
		warningNode.setDisplayable(false);
		warningNode.setExpanded(false);
		warningNode.setIconCls("DE");
		warningNode.setId("1234");
		warningNode.setLeaf(false);
		warningNode.setOrganizationName("Acme");
		warningNode.setThesaurusId("1234");
		warningNode.setTitle("Mr");
		warningNode.setType(ThesaurusListNodeType.THESAURUS);
		assertThat(warningNode.getChildren(), empty());
		assertThat(warningNode.getIconCls(), is("DE"));
		assertThat(warningNode.getId(), is("1234"));
		assertThat(warningNode.getOrganizationName(), is("Acme"));
		assertThat(warningNode.getThesaurusId(), is("1234"));
		assertThat(warningNode.getTitle(), is("Mr"));
		assertThat(warningNode.getType(), is(ThesaurusListNodeType.THESAURUS));
		assertThat(warningNode.isDisplayable(), is(false));
		assertThat(warningNode.isExpanded(), is(false));
		assertThat(warningNode.isLeaf(), is(false));
	}
}
