package fr.mcc.ginco.exports.skos;

import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.hp.hpl.jena.ontology.ObjectProperty;
import com.hp.hpl.jena.ontology.OntModel;
import com.hp.hpl.jena.rdf.model.Literal;
import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.Resource;

import fr.mcc.ginco.beans.AssociativeRelationshipRole;
import fr.mcc.ginco.services.IAssociativeRelationshipRoleService;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

/**
 * Unit tests for fr.mcc.ginco.exports.skos.SKOSAssociativeRelationshipRolesExporter
 *
 * @author Diffblue Cover
 */

public class SKOSAssociativeRelationshipRolesExporterTest {

	@Mock(name = "associativeRelationshipRoleService")
	private IAssociativeRelationshipRoleService associativeRelationshipRoleService;

	@InjectMocks
	private SKOSAssociativeRelationshipRolesExporter service;

	@Before public void initMocks() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void exportAssociativeRelationshipRoles() {
		List<AssociativeRelationshipRole> list =
			 new ArrayList<AssociativeRelationshipRole>();
		list.add(new AssociativeRelationshipRole());
		when(associativeRelationshipRoleService.getAllAssociationTermRole())
			.thenReturn(list);
		Model model = mock(Model.class);
		Literal literal = mock(Literal.class);
		Resource resource = mock(Resource.class);
		ObjectProperty objectProperty = mock(ObjectProperty.class);
		when(objectProperty.addProperty(Mockito.<com.hp.hpl.jena.rdf.model.Property>any(), Mockito.<com.hp.hpl.jena.rdf.model.RDFNode>any()))
			.thenReturn(resource);
		OntModel ontModel = mock(OntModel.class);
		when(ontModel.createObjectProperty(Mockito.<String>any()))
			.thenReturn(objectProperty);
		when(ontModel.createLiteral(Mockito.<String>any()))
			.thenReturn(literal);
		assertSame(model, service.exportAssociativeRelationshipRoles(model, ontModel));
		Mockito.verify(objectProperty).addLabel(Mockito.<Literal>any());
	}
}
