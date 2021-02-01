package fr.mcc.ginco.imports;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.hp.hpl.jena.ontology.ObjectProperty;
import com.hp.hpl.jena.ontology.OntModel;
import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.Resource;
import com.hp.hpl.jena.rdf.model.Statement;
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

	@Before
	public void initMocks() throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		MockitoAnnotations.initMocks(this);
		SKOSImportUtils bean = service;
		java.lang.reflect.Field field =
			 SKOSImportUtils.class.getDeclaredField("skosDefaultDateFormats");
		field.setAccessible(true);
		field.set(bean, new java.util.ArrayList());
	}

	@Test
	public void getSKOSRessources() {
		Resource resource1 = mock(Resource.class);
		Resource resource2 = mock(Resource.class);
		when(resource2.asResource())
			.thenReturn(resource1);
		Statement statement = mock(Statement.class);
		when(statement.getSubject())
			.thenReturn(resource2);
		StmtIterator stmtIterator = mock(StmtIterator.class);
		when(stmtIterator.hasNext())
			.thenReturn(true)
			.thenReturn(false);
		when(stmtIterator.next())
			.thenReturn(statement);
		Model model = mock(Model.class);
		when(model.listStatements(Mockito.<com.hp.hpl.jena.rdf.model.Selector>any()))
			.thenReturn(stmtIterator);
		Resource resource3 = mock(Resource.class);
		List<Resource> result = service.getSKOSRessources(model, resource3);
		assertEquals(1, result.size());
		assertSame(resource1, result.get(0));
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
		assertTrue(service.getSKOSRessources(model, resource).isEmpty());
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
		assertTrue(service.getRelatedTypeProperty(model).isEmpty());
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
		assertTrue(service.getRelatedTypeProperty(model).isEmpty());
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
		assertSame(objectProperty, result.get(0));
	}

	@Test
	public void getSkosDateSkosDateIsEmpty() {
		assertEquals(true, 
			Math.abs(service.getSkosDate("").getTime() - new Date().getTime())
			<= 10_000L);
	}
}
