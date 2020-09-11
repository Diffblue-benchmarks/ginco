package fr.mcc.ginco.extjs.view.node;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsSame.sameInstance;

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
		ArrayList<IThesaurusListNode> children = new ArrayList<IThesaurusListNode>();
		IThesaurusListNode obj1 = new WarningNode(1);
		ArrayList<IThesaurusListNode> x93 = new ArrayList<IThesaurusListNode>();
		IThesaurusListNode obj2 = new WarningNode(1);
		ArrayList<IThesaurusListNode> x96 = new ArrayList<IThesaurusListNode>();
		IThesaurusListNode obj3 = new WarningNode(1);
		obj3.setChildren(new ArrayList<IThesaurusListNode>());
		obj3.setDisplayable(false);
		obj3.setExpanded(false);
		obj3.setIconCls("DE");
		obj3.setId("DE");
		obj3.setLeaf(false);
		obj3.setOrganizationName("DE");
		obj3.setThesaurusId("DE");
		obj3.setTitle("DE");
		obj3.setType(ThesaurusListNodeType.THESAURUS);
		x96.add(obj3);
		obj2.setChildren(x96);
		obj2.setDisplayable(false);
		obj2.setExpanded(false);
		obj2.setIconCls("DE");
		obj2.setId("DE");
		obj2.setLeaf(false);
		obj2.setOrganizationName("DE");
		obj2.setThesaurusId("DE");
		obj2.setTitle("DE");
		obj2.setType(ThesaurusListNodeType.THESAURUS);
		x93.add(obj2);
		obj1.setChildren(x93);
		obj1.setDisplayable(false);
		obj1.setExpanded(false);
		obj1.setIconCls("DE");
		obj1.setId("DE");
		obj1.setLeaf(false);
		obj1.setOrganizationName("DE");
		obj1.setThesaurusId("DE");
		obj1.setTitle("DE");
		obj1.setType(ThesaurusListNodeType.THESAURUS);
		children.add(obj1);
		warningNode.setChildren(children);
		warningNode.setDisplayable(false);
		warningNode.setExpanded(false);
		warningNode.setIconCls("DE");
		warningNode.setId("1234");
		warningNode.setLeaf(false);
		warningNode.setOrganizationName("Acme");
		warningNode.setThesaurusId("1234");
		warningNode.setTitle("Mr");
		warningNode.setType(ThesaurusListNodeType.THESAURUS);
		assertThat(warningNode.getChildren().size(), is(1));
		assertThat(warningNode.getChildren().get(0), sameInstance(obj1));
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
