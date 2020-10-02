package fr.mcc.ginco.imports;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.hp.hpl.jena.ontology.ObjectProperty;
import com.hp.hpl.jena.ontology.OntModel;
import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.Resource;
import com.hp.hpl.jena.rdf.model.StmtIterator;
import com.hp.hpl.jena.util.iterator.ExtendedIterator;

import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

/**
 * Unit tests for fr.mcc.ginco.imports.SKOSImportUtils
 *
 * @author Diffblue Cover
 */

public class SKOSImportUtilsTest {

	@InjectMocks
	private SKOSImportUtils service;

	@Before public void initMocks() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void getSKOSRessourcesReturnsEmpty() {
		StmtIterator stmtIterator = mock(StmtIterator.class);
		when(stmtIterator.hasNext())
			.thenReturn(false);
		Model model = mock(Model.class);
		when(model.listStatements(Mockito.<com.hp.hpl.jena.rdf.model.Selector>any()))
			.thenReturn(stmtIterator);
		Resource resource = mock(Resource.class);
		assertTrue((service.getSKOSRessources(model, resource)).isEmpty());
	}

	@Test
	public void getRelatedTypeProperty1() {
		@SuppressWarnings("unchecked")
		ExtendedIterator<ObjectProperty> extendedIterator =
			 mock(ExtendedIterator.class);
		when(extendedIterator.hasNext())
			.thenReturn(false);
		OntModel model = mock(OntModel.class);
		when(model.listObjectProperties())
			.thenReturn(extendedIterator);
		assertTrue((service.getRelatedTypeProperty(model)).isEmpty());
	}

	@Test
	public void getRelatedTypeProperty2() {
		ObjectProperty objectProperty = mock(ObjectProperty.class);
		when(objectProperty.hasSuperProperty(Mockito.<com.hp.hpl.jena.rdf.model.Property>any(), anyBoolean()))
			.thenReturn(false);
		@SuppressWarnings("unchecked")
		ExtendedIterator<ObjectProperty> extendedIterator =
			 mock(ExtendedIterator.class);
		when(extendedIterator.hasNext())
			.thenReturn(true)
			.thenReturn(false);
		when(extendedIterator.next())
			.thenReturn(objectProperty);
		OntModel model = mock(OntModel.class);
		when(model.listObjectProperties())
			.thenReturn(extendedIterator);
		assertTrue((service.getRelatedTypeProperty(model)).isEmpty());
	}

	@Test
	public void getRelatedTypeProperty3() {
		ObjectProperty objectProperty = mock(ObjectProperty.class);
		when(objectProperty.hasSuperProperty(Mockito.<com.hp.hpl.jena.rdf.model.Property>any(), anyBoolean()))
			.thenReturn(true);
		@SuppressWarnings("unchecked")
		ExtendedIterator<ObjectProperty> extendedIterator =
			 mock(ExtendedIterator.class);
		when(extendedIterator.hasNext())
			.thenReturn(true)
			.thenReturn(false);
		when(extendedIterator.next())
			.thenReturn(objectProperty);
		OntModel model = mock(OntModel.class);
		when(model.listObjectProperties())
			.thenReturn(extendedIterator);
		List<ObjectProperty> result = service.getRelatedTypeProperty(model);
		assertEquals(1, result.size());
		assertNotNull(result.get(0));
	}

	@Test
	public void getSkosDateSkosDateIsEmpty() {
		assertEquals(true, Math.abs(service.getSkosDate("").getTime()-new Date().getTime())<=10_000L);
	}
}
