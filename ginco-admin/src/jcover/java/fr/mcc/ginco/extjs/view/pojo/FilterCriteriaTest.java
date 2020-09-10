package fr.mcc.ginco.extjs.view.pojo;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

import org.junit.jupiter.api.Test;

/**
 * Unit tests for fr.mcc.ginco.extjs.view.pojo.FilterCriteria
 *
 * @author Diffblue Cover
 */

class FilterCriteriaTest {

	@Test
	void factory() {
		FilterCriteria filterCriteria = new FilterCriteria();
		filterCriteria.setCreationdate("bar");
		filterCriteria.setLanguage("foo");
		filterCriteria.setLimit(1);
		filterCriteria.setModificationdate("/bin/bash");
		filterCriteria.setQuery("foo=bar");
		filterCriteria.setSortdir("/bin/bash");
		filterCriteria.setSortfield("/bin/bash");
		filterCriteria.setStart(1);
		filterCriteria.setStatus(1);
		filterCriteria.setThesaurus("/bin/bash");
		filterCriteria.setType(1);
		assertThat(filterCriteria.getCreationdate(), is("bar"));
		assertThat(filterCriteria.getLanguage(), is("foo"));
		assertThat(filterCriteria.getLimit(), is(1));
		assertThat(filterCriteria.getModificationdate(), is("/bin/bash"));
		assertThat(filterCriteria.getQuery(), is("foo=bar"));
		assertThat(filterCriteria.getSortdir(), is("/bin/bash"));
		assertThat(filterCriteria.getSortfield(), is("/bin/bash"));
		assertThat(filterCriteria.getStart(), is(1));
		assertThat(filterCriteria.getStatus(), is(1));
		assertThat(filterCriteria.getThesaurus(), is("/bin/bash"));
		assertThat(filterCriteria.getType(), is(1));
	}
}
