package fr.mcc.ginco.beans;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsSame.sameInstance;

import java.text.SimpleDateFormat;
import java.util.HashSet;

import org.junit.jupiter.api.Test;

/**
 * Unit tests for fr.mcc.ginco.beans.AssociativeRelationship
 *
 * @author Diffblue Cover
 */

class AssociativeRelationshipTest {

	@Test
	void factory() throws java.text.ParseException {
		AssociativeRelationship associativeRelationship = new AssociativeRelationship();
		ThesaurusConcept conceptLeft = new ThesaurusConcept();
		conceptLeft.setAssociativeRelationshipLeft(new HashSet<AssociativeRelationship>());
		conceptLeft.setAssociativeRelationshipRight(new HashSet<AssociativeRelationship>());
		conceptLeft.setConceptArrays(new HashSet<ThesaurusArray>());
		conceptLeft.setCreated(new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31"));
		conceptLeft.setIdentifier("hello");
		conceptLeft.setModified(new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31"));
		conceptLeft.setNotation("DE");
		conceptLeft.setParentConcepts(new HashSet<ThesaurusConcept>());
		conceptLeft.setRootConcepts(new HashSet<ThesaurusConcept>());
		conceptLeft.setStatus(1);
		conceptLeft.setThesaurus(new Thesaurus());
		conceptLeft.setTopConcept(false);
		associativeRelationship.setConceptLeft(conceptLeft);
		ThesaurusConcept conceptRight = new ThesaurusConcept();
		conceptRight.setAssociativeRelationshipLeft(new HashSet<AssociativeRelationship>());
		conceptRight.setAssociativeRelationshipRight(new HashSet<AssociativeRelationship>());
		conceptRight.setConceptArrays(new HashSet<ThesaurusArray>());
		conceptRight.setCreated(new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31"));
		conceptRight.setIdentifier("hello");
		conceptRight.setModified(new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-31"));
		conceptRight.setNotation("DE");
		conceptRight.setParentConcepts(new HashSet<ThesaurusConcept>());
		conceptRight.setRootConcepts(new HashSet<ThesaurusConcept>());
		conceptRight.setStatus(1);
		conceptRight.setThesaurus(new Thesaurus());
		conceptRight.setTopConcept(false);
		associativeRelationship.setConceptRight(conceptRight);
		AssociativeRelationship.Id identifier3 = new AssociativeRelationship.Id();
		identifier3.setConcept1("hello");
		identifier3.setConcept2("hello");
		associativeRelationship.setIdentifier(identifier3);
		AssociativeRelationshipRole relationshipRole = new AssociativeRelationshipRole();
		relationshipRole.setCode("DE");
		relationshipRole.setDefaultRole(false);
		relationshipRole.setLabel("label");
		relationshipRole.setSkosLabel("label");
		associativeRelationship.setRelationshipRole(relationshipRole);
		assertThat(associativeRelationship.getConceptLeft(), sameInstance(conceptLeft));
		assertThat(associativeRelationship.getConceptRight(), sameInstance(conceptRight));
		assertThat(associativeRelationship.getIdentifier(), sameInstance(identifier3));
		assertThat(associativeRelationship.getRelationshipRole(), sameInstance(relationshipRole));
	}
}
