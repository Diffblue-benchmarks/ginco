package fr.mcc.ginco.exports.result.bean;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.empty;
import static org.hamcrest.core.Is.is;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

/**
 * Unit tests for fr.mcc.ginco.exports.result.bean.JaxbList
 *
 * @author Diffblue Cover
 */

class JaxbListTest {

	@Test
	void factory() {
		assertThat(new JaxbList<String>().getList(), empty());
	}

	@Test
	void isEmpty() {
		assertThat(new JaxbList<String>().isEmpty(), is(true));
		assertThat(new JaxbList<String>(new ArrayList<String>()).isEmpty(), is(true));
	}

	@Test
	void isEmptyReturnsFalse() {
		ArrayList<String> list = new ArrayList<String>();
		list.add("foo");
		assertThat(new JaxbList<String>(list).isEmpty(), is(false));
	}
}
