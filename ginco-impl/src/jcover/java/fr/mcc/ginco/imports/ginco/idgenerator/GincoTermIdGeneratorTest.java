package fr.mcc.ginco.imports.ginco.idgenerator;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import fr.mcc.ginco.ark.IIDGeneratorService;
import fr.mcc.ginco.beans.ThesaurusTerm;
import fr.mcc.ginco.dao.IThesaurusTermDAO;

import java.util.HashMap;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

/**
 * Unit tests for fr.mcc.ginco.imports.ginco.idgenerator.GincoTermIdGenerator
 *
 * @author Diffblue Cover
 */

public class GincoTermIdGeneratorTest {

	@Mock(name = "generatorService")
	private IIDGeneratorService generatorService;

	@Mock(name = "thesaurusTermDAO")
	private IThesaurusTermDAO thesaurusTermDAO;

	@InjectMocks
	private GincoTermIdGenerator service;

	@Before
	public void initMocks() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void getIdForTermIdMappingIsFooReturnsFoo() {
		ThesaurusTerm thesaurusTerm = mock(ThesaurusTerm.class);
		when(thesaurusTermDAO.getById(Mockito.<String>any()))
			.thenReturn(thesaurusTerm);
		when(generatorService.generate(Mockito.<Class>any()))
			.thenReturn("foo");
		HashMap<String, String> idMapping = new HashMap<String, String>();
		idMapping.put("", "foo");
		assertEquals("foo", service.getIdForTerm("1234", idMapping));
	}
}
