package fr.mcc.ginco.exports.result.bean;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

import org.junit.jupiter.api.Test;

/**
 * Unit tests for fr.mcc.ginco.exports.result.bean.FormattedLine
 *
 * @author Diffblue Cover
 */

class FormattedLineTest {

	@Test
	void factory() {
		FormattedLine formattedLine = new FormattedLine(1, "hello");
		formattedLine.setTabs(1);
		formattedLine.setText("hello");
		assertThat(formattedLine.getTabs(), is(1));
		assertThat(formattedLine.getText(), is("hello"));
	}
}
