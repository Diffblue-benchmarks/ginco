package fr.mcc.ginco.extjs.view.pojo;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

import org.junit.jupiter.api.Test;

/**
 * Unit tests for fr.mcc.ginco.extjs.view.pojo.GenericCustomAttributeTypeView
 *
 * @author Diffblue Cover
 */

class GenericCustomAttributeTypeViewTest {

	@Test
	void factory() {
		GenericCustomAttributeTypeView genericCustomAttributeTypeView =
			 new GenericCustomAttributeTypeView();
		genericCustomAttributeTypeView.setCode("DE");
		genericCustomAttributeTypeView.setExportable(false);
		genericCustomAttributeTypeView.setIdentifier(1);
		genericCustomAttributeTypeView.setThesaurusId("1234");
		genericCustomAttributeTypeView.setValue("value");
		assertThat(genericCustomAttributeTypeView.getCode(), is("DE"));
		assertThat(genericCustomAttributeTypeView.getExportable(), is(false));
		assertThat(genericCustomAttributeTypeView.getIdentifier(), is(1));
		assertThat(genericCustomAttributeTypeView.getThesaurusId(), is("1234"));
		assertThat(genericCustomAttributeTypeView.getValue(), is("value"));
	}
}
