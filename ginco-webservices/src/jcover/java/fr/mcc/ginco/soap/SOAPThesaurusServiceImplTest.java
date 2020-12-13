package fr.mcc.ginco.soap;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.empty;
import static org.hamcrest.Matchers.nullValue;
import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import fr.mcc.ginco.beans.Thesaurus;
import fr.mcc.ginco.beans.ThesaurusOrganization;
import fr.mcc.ginco.beans.ThesaurusType;
import fr.mcc.ginco.data.FullThesaurus;
import fr.mcc.ginco.data.ReducedThesaurus;
import fr.mcc.ginco.services.IThesaurusService;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

/**
 * Unit tests for fr.mcc.ginco.soap.SOAPThesaurusServiceImpl
 *
 * @author Diffblue Cover
 */

class SOAPThesaurusServiceImplTest {

	@Test
	void getAllThesaurus() {

		// arrange
		SOAPThesaurusServiceImpl obj = new SOAPThesaurusServiceImpl();
		ArrayList<Thesaurus> arrayList = new ArrayList<Thesaurus>();
		Thesaurus thesaurus = new Thesaurus();
		thesaurus.setIdentifier("data");
		thesaurus.setTitle("Mr");
		arrayList.add(thesaurus);
		IThesaurusService thesaurusService = mock(IThesaurusService.class);
		when(thesaurusService.getThesaurusList())
			.thenReturn(arrayList);
		obj.setThesaurusService(thesaurusService);

		// act
		List<ReducedThesaurus> result = obj.getAllThesaurus();

		// assert
		assertThat(result.size(), is(1));
		assertThat(result.get(0).getIdentifier(), is("data"));
		assertThat(result.get(0).getTitle(), is("Mr"));
	}

	@Test
	void getThesaurusById1() throws java.text.ParseException {

		// arrange
		SOAPThesaurusServiceImpl obj = new SOAPThesaurusServiceImpl();
		Thesaurus thesaurus = new Thesaurus();
		thesaurus.setContributor("foo");
		thesaurus.setCoverage("foo");
		thesaurus.setCreated(new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31"));
		ThesaurusOrganization creator = new ThesaurusOrganization();
		creator.setEmail("info@diffblue.com");
		creator.setHomepage("foo");
		creator.setName("Acme");
		thesaurus.setCreator(creator);
		thesaurus.setDate(new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31"));
		thesaurus.setDescription("some text");
		thesaurus.setIdentifier("data");
		thesaurus.setPublisher("foo");
		thesaurus.setRelation("DE");
		thesaurus.setRights("foo");
		thesaurus.setSource("foo");
		thesaurus.setSubject("foo");
		thesaurus.setTitle("Mr");
		ThesaurusType type = new ThesaurusType();
		type.setLabel("label");
		thesaurus.setType(type);
		IThesaurusService thesaurusService = mock(IThesaurusService.class);
		when(thesaurusService.getThesaurusById(Mockito.<String>any()))
			.thenReturn(thesaurus);
		obj.setThesaurusService(thesaurusService);

		// act
		FullThesaurus result = obj.getThesaurusById("1234");

		// assert
		assertThat(result.getContributor(), is("foo"));
		assertThat(result.getCoverage(), is("foo"));
		assertThat(Pattern.matches("\\d{4}-\\d{1,2}-\\d{1,2} \\d{1,2}:\\d{2}:\\d{2}", result.getCreated()), is(true));
		assertThat(result.getCreatorEmail(), is("info@diffblue.com"));
		assertThat(result.getCreatorHomepage(), is("foo"));
		assertThat(result.getCreatorName(), is("Acme"));
		assertThat(result.getDescription(), is("some text"));
		assertThat(result.getFormats(), empty());
		assertThat(result.getLanguages(), empty());
		assertThat(Pattern.matches("\\d{4}-\\d{1,2}-\\d{1,2} \\d{1,2}:\\d{2}:\\d{2}", result.getModified()), is(true));
		assertThat(result.getPublisher(), is("foo"));
		assertThat(result.getRelation(), is("DE"));
		assertThat(result.getRights(), is("foo"));
		assertThat(result.getSource(), is("foo"));
		assertThat(result.getSubject(), is("foo"));
		assertThat(result.getType(), is("label"));
		assertThat(result.getIdentifier(), is("data"));
		assertThat(result.getTitle(), is("Mr"));
	}

	@Test
	void getThesaurusById2() throws java.text.ParseException {

		// arrange
		SOAPThesaurusServiceImpl obj = new SOAPThesaurusServiceImpl();
		Thesaurus thesaurus = new Thesaurus();
		thesaurus.setContributor("foo");
		thesaurus.setCoverage("foo");
		thesaurus.setCreated(new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31"));
		thesaurus.setDate(new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31"));
		thesaurus.setDescription("some text");
		thesaurus.setIdentifier("data");
		thesaurus.setPublisher("foo");
		thesaurus.setRelation("DE");
		thesaurus.setRights("foo");
		thesaurus.setSource("foo");
		thesaurus.setSubject("foo");
		thesaurus.setTitle("Mr");
		ThesaurusType type = new ThesaurusType();
		type.setLabel("label");
		thesaurus.setType(type);
		IThesaurusService thesaurusService = mock(IThesaurusService.class);
		when(thesaurusService.getThesaurusById(Mockito.<String>any()))
			.thenReturn(thesaurus);
		obj.setThesaurusService(thesaurusService);

		// act
		FullThesaurus result = obj.getThesaurusById("1234");

		// assert
		assertThat(result.getContributor(), is("foo"));
		assertThat(result.getCoverage(), is("foo"));
		assertThat(Pattern.matches("\\d{4}-\\d{1,2}-\\d{1,2} \\d{1,2}:\\d{2}:\\d{2}", result.getCreated()), is(true));
		assertThat(result.getCreatorEmail(), is(nullValue()));
		assertThat(result.getCreatorHomepage(), is(nullValue()));
		assertThat(result.getCreatorName(), is(nullValue()));
		assertThat(result.getDescription(), is("some text"));
		assertThat(result.getFormats(), empty());
		assertThat(result.getLanguages(), empty());
		assertThat(Pattern.matches("\\d{4}-\\d{1,2}-\\d{1,2} \\d{1,2}:\\d{2}:\\d{2}", result.getModified()), is(true));
		assertThat(result.getPublisher(), is("foo"));
		assertThat(result.getRelation(), is("DE"));
		assertThat(result.getRights(), is("foo"));
		assertThat(result.getSource(), is("foo"));
		assertThat(result.getSubject(), is("foo"));
		assertThat(result.getType(), is("label"));
		assertThat(result.getIdentifier(), is("data"));
		assertThat(result.getTitle(), is("Mr"));
	}

	@Test
	void getThesaurusById3() throws java.text.ParseException {

		// arrange
		SOAPThesaurusServiceImpl obj = new SOAPThesaurusServiceImpl();
		Thesaurus thesaurus = new Thesaurus();
		thesaurus.setContributor("foo");
		thesaurus.setCoverage("foo");
		thesaurus.setCreated(new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31"));
		ThesaurusOrganization creator = new ThesaurusOrganization();
		creator.setEmail("info@diffblue.com");
		creator.setHomepage("foo");
		creator.setName("Acme");
		thesaurus.setCreator(creator);
		thesaurus.setDate(new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31"));
		thesaurus.setDescription("some text");
		thesaurus.setIdentifier("data");
		thesaurus.setPublisher("foo");
		thesaurus.setRelation("DE");
		thesaurus.setRights("foo");
		thesaurus.setSource("foo");
		thesaurus.setSubject("foo");
		thesaurus.setTitle("Mr");
		ThesaurusType type = new ThesaurusType();
		type.setLabel("label");
		thesaurus.setType(type);
		IThesaurusService thesaurusService = mock(IThesaurusService.class);
		when(thesaurusService.getThesaurusById(Mockito.<String>any()))
			.thenReturn(thesaurus);
		obj.setThesaurusService(thesaurusService);

		// act
		FullThesaurus result = obj.getThesaurusById("1234");

		// assert
		assertThat(result.getContributor(), is("foo"));
		assertThat(result.getCoverage(), is("foo"));
		assertThat(Pattern.matches("\\d{4}-\\d{1,2}-\\d{1,2} \\d{1,2}:\\d{2}:\\d{2}", result.getCreated()), is(true));
		assertThat(result.getCreatorEmail(), is("info@diffblue.com"));
		assertThat(result.getCreatorHomepage(), is("foo"));
		assertThat(result.getCreatorName(), is("Acme"));
		assertThat(result.getDescription(), is("some text"));
		assertThat(result.getFormats(), empty());
		assertThat(result.getLanguages(), empty());
		assertThat(Pattern.matches("\\d{4}-\\d{1,2}-\\d{1,2} \\d{1,2}:\\d{2}:\\d{2}", result.getModified()), is(true));
		assertThat(result.getPublisher(), is("foo"));
		assertThat(result.getRelation(), is("DE"));
		assertThat(result.getRights(), is("foo"));
		assertThat(result.getSource(), is("foo"));
		assertThat(result.getSubject(), is("foo"));
		assertThat(result.getType(), is("label"));
		assertThat(result.getIdentifier(), is("data"));
		assertThat(result.getTitle(), is("Mr"));
	}

	@Test
	void getThesaurusById4() throws java.text.ParseException {

		// arrange
		SOAPThesaurusServiceImpl obj = new SOAPThesaurusServiceImpl();
		Thesaurus thesaurus = new Thesaurus();
		thesaurus.setContributor("foo");
		thesaurus.setCoverage("foo");
		thesaurus.setCreated(new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31"));
		ThesaurusOrganization creator = new ThesaurusOrganization();
		creator.setEmail("info@diffblue.com");
		creator.setHomepage("foo");
		creator.setName("Acme");
		thesaurus.setCreator(creator);
		thesaurus.setDate(new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31"));
		thesaurus.setDescription("some text");
		thesaurus.setIdentifier("data");
		thesaurus.setPublisher("foo");
		thesaurus.setRelation("DE");
		thesaurus.setRights("foo");
		thesaurus.setSource("foo");
		thesaurus.setSubject("foo");
		thesaurus.setTitle("Mr");
		IThesaurusService thesaurusService = mock(IThesaurusService.class);
		when(thesaurusService.getThesaurusById(Mockito.<String>any()))
			.thenReturn(thesaurus);
		obj.setThesaurusService(thesaurusService);

		// act
		FullThesaurus result = obj.getThesaurusById("1234");

		// assert
		assertThat(result.getContributor(), is("foo"));
		assertThat(result.getCoverage(), is("foo"));
		assertThat(Pattern.matches("\\d{4}-\\d{1,2}-\\d{1,2} \\d{1,2}:\\d{2}:\\d{2}", result.getCreated()), is(true));
		assertThat(result.getCreatorEmail(), is("info@diffblue.com"));
		assertThat(result.getCreatorHomepage(), is("foo"));
		assertThat(result.getCreatorName(), is("Acme"));
		assertThat(result.getDescription(), is("some text"));
		assertThat(result.getFormats(), empty());
		assertThat(result.getLanguages(), empty());
		assertThat(Pattern.matches("\\d{4}-\\d{1,2}-\\d{1,2} \\d{1,2}:\\d{2}:\\d{2}", result.getModified()), is(true));
		assertThat(result.getPublisher(), is("foo"));
		assertThat(result.getRelation(), is("DE"));
		assertThat(result.getRights(), is("foo"));
		assertThat(result.getSource(), is("foo"));
		assertThat(result.getSubject(), is("foo"));
		assertThat(result.getType(), is(nullValue()));
		assertThat(result.getIdentifier(), is("data"));
		assertThat(result.getTitle(), is("Mr"));
	}
}
