package fr.mcc.ginco.extjs.view;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

import org.junit.jupiter.api.Test;

/**
 * Unit tests for fr.mcc.ginco.extjs.view.ExtJsonFormLoadData
 *
 * @author Diffblue Cover
 */

class ExtJsonFormLoadDataTest {

	@Test
	void factory1() {
		ExtJsonFormLoadData<String> extJsonFormLoadData = new ExtJsonFormLoadData<String>("bar");
		extJsonFormLoadData.setData("something");
		extJsonFormLoadData.setSuccess(false);
		extJsonFormLoadData.setTotal(1L);
		assertThat(extJsonFormLoadData.getData(), is("something"));
		assertThat(extJsonFormLoadData.getTotal(), is(1L));
		assertThat(extJsonFormLoadData.isSuccess(), is(false));
	}

	@Test
	void factory2() {
		ExtJsonFormLoadData<String> extJsonFormLoadData = new ExtJsonFormLoadData<String>("bar", 0L);
		extJsonFormLoadData.setData("something");
		extJsonFormLoadData.setSuccess(false);
		extJsonFormLoadData.setTotal(1L);
		assertThat(extJsonFormLoadData.getData(), is("something"));
		assertThat(extJsonFormLoadData.getTotal(), is(1L));
		assertThat(extJsonFormLoadData.isSuccess(), is(false));
	}
}
