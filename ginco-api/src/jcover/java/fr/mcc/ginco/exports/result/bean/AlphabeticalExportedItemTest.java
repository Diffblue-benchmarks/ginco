package fr.mcc.ginco.exports.result.bean;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsSame.sameInstance;

import org.junit.jupiter.api.Test;

/**
 * Unit tests for fr.mcc.ginco.exports.result.bean.AlphabeticalExportedItem
 *
 * @author Diffblue Cover
 */

class AlphabeticalExportedItemTest {

	@Test
	void factory() {
		AlphabeticalExportedItem alphabeticalExportedItem =
			 new AlphabeticalExportedItem();
		alphabeticalExportedItem.setLexicalValue("value");
		Object objectToExport = new Object();
		alphabeticalExportedItem.setObjectToExport(objectToExport);
		assertThat(alphabeticalExportedItem.getLexicalValue(), is("value"));
		assertThat(alphabeticalExportedItem.getObjectToExport(), sameInstance(objectToExport));
	}
}
