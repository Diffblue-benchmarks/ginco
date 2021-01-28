package fr.mcc.ginco.exports.result.bean;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.Test;

/**
 * Unit tests for fr.mcc.ginco.exports.result.bean.JaxbList
 *
 * @author Diffblue Cover
 */

class JaxbListTest {

	@Test
	void factory() {
		ArrayList<String> list = new ArrayList<String>();
		list.add("Smith");
		assertThat(new JaxbList<String>(list).getList(), equalTo(Arrays.asList("Smith")));
	}

	@Test
	void isEmptyReturnsFalse() {
		ArrayList<String> list = new ArrayList<String>();
		list.add("Smith");
		assertThat(new JaxbList<String>(list).isEmpty(), is(false));
	}

	@Test
	void isEmptyReturnsTrue() {
		assertThat(new JaxbList<String>().isEmpty(), is(true));
	}
}
