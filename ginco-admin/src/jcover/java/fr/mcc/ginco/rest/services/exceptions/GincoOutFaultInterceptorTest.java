package fr.mcc.ginco.rest.services.exceptions;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.empty;
import static org.hamcrest.Matchers.nullValue;
import static org.hamcrest.core.Is.is;

import java.util.LinkedList;

import org.junit.jupiter.api.Test;

/**
 * Unit tests for fr.mcc.ginco.rest.services.exceptions.GincoOutFaultInterceptor
 *
 * @author Diffblue Cover
 */

class GincoOutFaultInterceptorTest {

	@Test
	void factory() {
		GincoOutFaultInterceptor gincoOutFaultInterceptor = new GincoOutFaultInterceptor();
		gincoOutFaultInterceptor.setAfter(new LinkedList<String>());
		gincoOutFaultInterceptor.setBefore(new LinkedList<String>());
		assertThat(gincoOutFaultInterceptor.getAdditionalInterceptors(), is(nullValue()));
		assertThat(gincoOutFaultInterceptor.getAfter(), empty());
		assertThat(gincoOutFaultInterceptor.getBefore(), empty());
		assertThat(gincoOutFaultInterceptor.getId(), is("fr.mcc.ginco.rest.services.exceptions.GincoOutFaultInterceptor"));
		assertThat(gincoOutFaultInterceptor.getPhase(), is("marshal"));
	}

	@Test
	void handleMessageCalledReturnsFalse() {
		assertThat(new GincoOutFaultInterceptor().handleMessageCalled(), is(false));
	}
}
