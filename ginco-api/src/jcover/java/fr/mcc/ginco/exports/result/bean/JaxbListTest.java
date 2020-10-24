package fr.mcc.ginco.exports.result.bean;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
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
		ArrayList<String> list = new ArrayList<String>();
		list.add("Smith");
		assertThat(new JaxbList<String>(list).getList(), hasSize(1));
		assertThat(new JaxbList<String>(list).getList().get(0), is("Smith"));
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
