package fr.mcc.ginco.exports.result.bean;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.empty;
import static org.hamcrest.core.IsSame.sameInstance;

import fr.mcc.ginco.beans.CustomConceptAttribute;
import fr.mcc.ginco.beans.CustomConceptAttributeType;
import fr.mcc.ginco.beans.CustomTermAttribute;
import fr.mcc.ginco.beans.CustomTermAttributeType;
import fr.mcc.ginco.beans.ThesaurusConcept;
import fr.mcc.ginco.beans.ThesaurusTerm;

import java.util.ArrayList;
import java.util.HashMap;

import org.junit.jupiter.api.Test;

/**
 * Unit tests for fr.mcc.ginco.exports.result.bean.GincoExportedEntity
 *
 * @author Diffblue Cover
 */

class GincoExportedEntityTest {

	@Test
	void factory() {
		GincoExportedEntity gincoExportedEntity = new GincoExportedBranch();
		gincoExportedEntity.setConceptAttributeTypes(new ArrayList<CustomConceptAttributeType>());
		HashMap<String, JaxbList<CustomConceptAttribute>> conceptAttributes = new HashMap<String, JaxbList<CustomConceptAttribute>>();
		JaxbList<CustomConceptAttribute> x11 = new JaxbList<CustomConceptAttribute>();
		conceptAttributes.put("foo", x11);
		gincoExportedEntity.setConceptAttributes(conceptAttributes);
		gincoExportedEntity.setConcepts(new ArrayList<ThesaurusConcept>());
		gincoExportedEntity.setTermAttributeTypes(new ArrayList<CustomTermAttributeType>());
		HashMap<String, JaxbList<CustomTermAttribute>> termAttributes = new HashMap<String, JaxbList<CustomTermAttribute>>();
		JaxbList<CustomTermAttribute> x52 = new JaxbList<CustomTermAttribute>();
		termAttributes.put("foo", x52);
		gincoExportedEntity.setTermAttributes(termAttributes);
		gincoExportedEntity.setTerms(new ArrayList<ThesaurusTerm>());
		assertThat(gincoExportedEntity.getConceptAttributeTypes(), empty());
		assertThat(gincoExportedEntity.getConceptAttributes().get("foo"), sameInstance(x11));
		assertThat(gincoExportedEntity.getConcepts(), empty());
		assertThat(gincoExportedEntity.getTermAttributeTypes(), empty());
		assertThat(gincoExportedEntity.getTermAttributes().get("foo"), sameInstance(x52));
		assertThat(gincoExportedEntity.getTerms(), empty());
	}
}
