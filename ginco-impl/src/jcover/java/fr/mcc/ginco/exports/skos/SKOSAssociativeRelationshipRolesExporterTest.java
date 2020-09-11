package fr.mcc.ginco.exports.skos;

import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.hp.hpl.jena.ontology.OntModel;
import com.hp.hpl.jena.rdf.model.Model;

import fr.mcc.ginco.beans.AssociativeRelationshipRole;
import fr.mcc.ginco.services.IAssociativeRelationshipRoleService;

import java.util.ArrayList;

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
		when(associativeRelationshipRoleService.getAllAssociationTermRole())
			.thenReturn(new ArrayList<AssociativeRelationshipRole>());
		Model model = mock(Model.class);
		OntModel ontModel = mock(OntModel.class);
		assertSame(model, service.exportAssociativeRelationshipRoles(model, ontModel));
	}
}
