/**
 * Copyright or © or Copr. Ministère Français chargé de la Culture
 * et de la Communication (2013)
 * <p/>
 * contact.gincoculture_at_gouv.fr
 * <p/>
 * This software is a computer program whose purpose is to provide a thesaurus
 * management solution.
 * <p/>
 * This software is governed by the CeCILL license under French law and
 * abiding by the rules of distribution of free software. You can use,
 * modify and/ or redistribute the software under the terms of the CeCILL
 * license as circulated by CEA, CNRS and INRIA at the following URL
 * "http://www.cecill.info".
 * <p/>
 * As a counterpart to the access to the source code and rights to copy,
 * modify and redistribute granted by the license, users are provided only
 * with a limited warranty and the software's author, the holder of the
 * economic rights, and the successive licensors have only limited liability.
 * <p/>
 * In this respect, the user's attention is drawn to the risks associated
 * with loading, using, modifying and/or developing or reproducing the
 * software by the user in light of its specific status of free software,
 * that may mean that it is complicated to manipulate, and that also
 * therefore means that it is reserved for developers and experienced
 * professionals having in-depth computer knowledge. Users are therefore
 * encouraged to load and test the software's suitability as regards their
 * requirements in conditions enabling the security of their systemsand/or
 * data to be ensured and, more generally, to use and operate it in the
 * same conditions as regards security.
 * <p/>
 * The fact that you are presently reading this means that you have had
 * knowledge of the CeCILL license and that you accept its terms.
 */
package fr.mcc.ginco.tests.daos;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import fr.mcc.ginco.beans.Thesaurus;
import fr.mcc.ginco.beans.ThesaurusConcept;
import fr.mcc.ginco.dao.hibernate.ThesaurusConceptDAO;
import fr.mcc.ginco.exceptions.BusinessException;
import fr.mcc.ginco.tests.BaseDAOTest;
import fr.mcc.ginco.tests.LoggerTestUtil;

public class ThesaurusConceptDAOTest extends BaseDAOTest {	
	
	private ThesaurusConceptDAO thesaurusConceptDAO = new ThesaurusConceptDAO();

	@Before
	public void handleSetUpOperation() throws Exception {
		super.handleSetUpOperation();
		LoggerTestUtil.initLogger(thesaurusConceptDAO);
		thesaurusConceptDAO.setSessionFactory(getSessionFactory());
	}

	@Test
	public void testGetOrphansThesaurusConcept() throws BusinessException {
		String thesaurusId = "http://www.culturecommunication.gouv.fr/th1";
		Thesaurus th = new Thesaurus();
		th.setIdentifier(thesaurusId);
		List<ThesaurusConcept> actualConcepts = thesaurusConceptDAO
				.getOrphansThesaurusConcept(th);
		Assert.assertEquals(2,actualConcepts.size());
	}
	
	@Test
	public void testGetOrphansThesaurusConceptCount() throws BusinessException {
		String thesaurusId = "http://www.culturecommunication.gouv.fr/th1";
		Thesaurus th = new Thesaurus();
		th.setIdentifier(thesaurusId);
		long actualCount = thesaurusConceptDAO
				.getOrphansThesaurusConceptCount(th);
		Assert.assertEquals(2,actualCount);
	}

    @Test
    public void testGetTopTermThesaurusConcept() throws BusinessException {
        String thesaurusId = "http://www.culturecommunication.gouv.fr/th1";
        Thesaurus th = new Thesaurus();
        th.setIdentifier(thesaurusId);
        List<ThesaurusConcept> actualConcepts = thesaurusConceptDAO
                .getTopTermThesaurusConcept(th);
        Assert.assertEquals(1,actualConcepts.size());
    }
    @Test
    public void testGetTopTermThesaurusConceptCount() throws BusinessException {
        String thesaurusId = "http://www.culturecommunication.gouv.fr/th1";
        Thesaurus th = new Thesaurus();
        th.setIdentifier(thesaurusId);
        long actualCount = thesaurusConceptDAO
                .getTopTermThesaurusConceptCount(th);
        Assert.assertEquals(1,actualCount);
    }

    @Test
    public void testGetThesaurusFromConcept() throws BusinessException {
        String thesaurusConceptId = "http://www.culturecommunication.gouv.fr/co1";
        ThesaurusConcept thesaurusConcept = thesaurusConceptDAO.getById(thesaurusConceptId);
        String expectedThesaurusTitle = "test";
        Assert.assertEquals("Parent thesaurus is not as expected !", thesaurusConcept.getThesaurus().getTitle(),
                expectedThesaurusTitle);
    }
    
    @Test
    public void testGetAssociatedConcepts(){  
    	ThesaurusConcept concept1 = thesaurusConceptDAO.getById("http://www.culturecommunication.gouv.fr/co1");
        List<ThesaurusConcept> thesaurusConcepts = thesaurusConceptDAO.getAssociatedConcepts(concept1);
        Assert.assertEquals(2, thesaurusConcepts.size());      
    }

    @Test
    public void testGetTopTermByThesaurus() throws BusinessException {
        String thesaurusId = "http://www.culturecommunication.gouv.fr/th1";
        Thesaurus th = new Thesaurus();
        th.setIdentifier(thesaurusId);

        List<ThesaurusConcept> list = thesaurusConceptDAO.getTopTermThesaurusConcept(th);
        Assert.assertEquals(list.size(),1);
        Assert.assertEquals("http://www.culturecommunication.gouv.fr/co2", list.get(0).getIdentifier());
    }

    @Test
    public void testGetChildrenByConcept() throws BusinessException {
        String thesaurusId = "http://www.culturecommunication.gouv.fr/th1";
        Thesaurus th = new Thesaurus();
        th.setIdentifier(thesaurusId);

        List<ThesaurusConcept> list = thesaurusConceptDAO.getChildrenConcepts("http://www.culturecommunication.gouv.fr/co2");
        Assert.assertEquals(list.size(),2);
        Assert.assertEquals("http://www.culturecommunication.gouv.fr/co2_1", list.get(0).getIdentifier());
        Assert.assertEquals("http://www.culturecommunication.gouv.fr/co2_2", list.get(1).getIdentifier());
    }

    @Test
    public void testGetRootByThesaurusId() throws BusinessException {
        String thesaurusId = "http://www.culturecommunication.gouv.fr/th1";
        Thesaurus th = new Thesaurus();
        th.setIdentifier(thesaurusId);

        List<ThesaurusConcept> list = thesaurusConceptDAO.getRootConcepts(th.getIdentifier(), false);
        Assert.assertEquals(1, list.size());
        Assert.assertEquals("http://www.culturecommunication.gouv.fr/co2", list.get(0).getIdentifier());

        List<ThesaurusConcept> list_with_orphans = thesaurusConceptDAO.getRootConcepts(th.getIdentifier(), null);
        Assert.assertEquals(3, list_with_orphans.size());
        Assert.assertEquals("http://www.culturecommunication.gouv.fr/co1", list_with_orphans.get(0).getIdentifier());
        Assert.assertEquals("http://www.culturecommunication.gouv.fr/co2", list_with_orphans.get(1).getIdentifier());
        Assert.assertEquals("http://www.culturecommunication.gouv.fr/co3", list_with_orphans.get(2).getIdentifier());

        List<ThesaurusConcept> list_only_orphans = thesaurusConceptDAO.getRootConcepts(th.getIdentifier(), true);
        Assert.assertEquals(2, list_only_orphans.size());
        Assert.assertEquals("http://www.culturecommunication.gouv.fr/co1", list_only_orphans.get(0).getIdentifier());
        Assert.assertEquals("http://www.culturecommunication.gouv.fr/co3", list_only_orphans.get(1).getIdentifier());
    }

    @Test
    public void testGetAllConceptsByThesaurusId() throws BusinessException {
        String thesaurusId = "http://www.culturecommunication.gouv.fr/th1";
        Thesaurus th = new Thesaurus();
        th.setIdentifier(thesaurusId);

        List<ThesaurusConcept> list = thesaurusConceptDAO.getAllConceptsByThesaurusId(null,thesaurusId,null);
        Assert.assertEquals(5, list.size());

        List<ThesaurusConcept> list_exclude = thesaurusConceptDAO.getAllConceptsByThesaurusId("http://www.culturecommunication.gouv.fr/co1",thesaurusId,null);
        Assert.assertEquals(4, list_exclude.size());

        List<ThesaurusConcept> list_exclude_top_term = thesaurusConceptDAO.getAllConceptsByThesaurusId("http://www.culturecommunication.gouv.fr/co1",thesaurusId,false);
        Assert.assertEquals(1, list_exclude_top_term.size());
    }

	@Override
	public String getXmlDataFileInit() {
		return "/thesaurusconcept_init.xml";
	}
}
