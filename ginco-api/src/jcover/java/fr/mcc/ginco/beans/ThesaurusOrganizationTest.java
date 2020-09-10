package fr.mcc.ginco.beans;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

import org.junit.jupiter.api.Test;

/**
 * Unit tests for fr.mcc.ginco.beans.ThesaurusOrganization
 *
 * @author Diffblue Cover
 */

class ThesaurusOrganizationTest {

	@Test
	void factory() {
		ThesaurusOrganization thesaurusOrganization = new ThesaurusOrganization();
		thesaurusOrganization.setEmail("info@diffblue.com");
		thesaurusOrganization.setHomepage("foo");
		thesaurusOrganization.setIdentifier(1);
		thesaurusOrganization.setName("Acme");
		assertThat(thesaurusOrganization.getEmail(), is("info@diffblue.com"));
		assertThat(thesaurusOrganization.getHomepage(), is("foo"));
		assertThat(thesaurusOrganization.getIdentifier(), is(1));
		assertThat(thesaurusOrganization.getName(), is("Acme"));
	}
}
