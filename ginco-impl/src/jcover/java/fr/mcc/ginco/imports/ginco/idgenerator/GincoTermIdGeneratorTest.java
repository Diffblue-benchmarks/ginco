package fr.mcc.ginco.imports.ginco.idgenerator;

import static org.junit.Assert.assertEquals;

import fr.mcc.ginco.ark.IIDGeneratorService;
import fr.mcc.ginco.dao.IThesaurusTermDAO;

import java.util.HashMap;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
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

	@Before public void initMocks() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void getIdForTermIdMappingIsEmpty() {
		assertEquals("1234", service.getIdForTerm("1234", new HashMap<String, String>()));
	}
}
