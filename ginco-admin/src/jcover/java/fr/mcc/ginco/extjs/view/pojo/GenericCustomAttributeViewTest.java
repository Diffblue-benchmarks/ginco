package fr.mcc.ginco.extjs.view.pojo;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

import org.junit.jupiter.api.Test;

/**
 * Unit tests for fr.mcc.ginco.extjs.view.pojo.GenericCustomAttributeView
 *
 * @author Diffblue Cover
 */

class GenericCustomAttributeViewTest {

	@Test
	void factory() {
		GenericCustomAttributeView genericCustomAttributeView = new GenericCustomAttributeView();
		genericCustomAttributeView.setEntityid("entity");
		genericCustomAttributeView.setLang("name");
		genericCustomAttributeView.setLexicalValue("value");
		genericCustomAttributeView.setTypeid(1);
		assertThat(genericCustomAttributeView.getEntityid(), is("entity"));
		assertThat(genericCustomAttributeView.getLang(), is("name"));
		assertThat(genericCustomAttributeView.getLexicalValue(), is("value"));
		assertThat(genericCustomAttributeView.getTypeid(), is(1));
	}
}
