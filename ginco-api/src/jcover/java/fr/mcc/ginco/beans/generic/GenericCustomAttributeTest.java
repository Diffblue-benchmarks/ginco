package fr.mcc.ginco.beans.generic;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsSame.sameInstance;

import fr.mcc.ginco.beans.CustomConceptAttributeType;
import fr.mcc.ginco.beans.Language;
import fr.mcc.ginco.beans.Thesaurus;

import org.junit.jupiter.api.Test;

/**
 * Unit tests for fr.mcc.ginco.beans.generic.GenericCustomAttribute
 *
 * @author Diffblue Cover
 */

class GenericCustomAttributeTest {

	@Test
	void factory() {
		GenericCustomAttribute<CustomConceptAttributeType, String> genericCustomAttribute =
			 new GenericCustomAttribute<CustomConceptAttributeType, String>();
		genericCustomAttribute.setEntity("entity");
		genericCustomAttribute.setIdentifier("data");
		Language language = new Language();
		language.setId("1234");
		language.setPart1("foo");
		language.setPrincipalLanguage(false);
		language.setRefname("foo");
		language.setTopLanguage(false);
		genericCustomAttribute.setLanguage(language);
		genericCustomAttribute.setLexicalValue("value");
		CustomConceptAttributeType type = new CustomConceptAttributeType();
		type.setExportable(false);
		type.setCode("DE");
		type.setIdentifier(1);
		type.setThesaurus(new Thesaurus());
		type.setValue("value");
		genericCustomAttribute.setType(type);
		assertThat(genericCustomAttribute.getEntity(), is("entity"));
		assertThat(genericCustomAttribute.getIdentifier(), is("data"));
		assertThat(genericCustomAttribute.getLanguage(), sameInstance(language));
		assertThat(genericCustomAttribute.getLexicalValue(), is("value"));
		assertThat(genericCustomAttribute.getType(), sameInstance(type));
	}
}
