package fr.mcc.ginco.rest.services.exceptions;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.nullValue;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
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
		GincoOutFaultInterceptor gincoOutFaultInterceptor =
			 new GincoOutFaultInterceptor();
		LinkedList<String> i1 = new LinkedList<String>();
		i1.add("an error has happened");
		gincoOutFaultInterceptor.setAfter(i1);
		LinkedList<String> i2 = new LinkedList<String>();
		i2.add("an error has happened");
		gincoOutFaultInterceptor.setBefore(i2);
		assertThat(gincoOutFaultInterceptor.getAdditionalInterceptors(), is(nullValue()));
		assertThat(gincoOutFaultInterceptor.getAfter(), hasSize(1));
		assertThat(gincoOutFaultInterceptor.getAfter(), hasItem("an error has happened"));
		assertThat(gincoOutFaultInterceptor.getBefore(), hasSize(1));
		assertThat(gincoOutFaultInterceptor.getBefore(), hasItem("an error has happened"));
		assertThat(gincoOutFaultInterceptor.getId(), is("fr.mcc.ginco.rest.services.exceptions.GincoOutFaultInterceptor"));
		assertThat(gincoOutFaultInterceptor.getPhase(), is("marshal"));
	}

	@Test
	void handleMessageCalledReturnsFalse() {
		assertThat(new GincoOutFaultInterceptor().handleMessageCalled(), is(false));
	}
}
