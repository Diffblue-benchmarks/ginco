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
package fr.mcc.ginco.imports.ginco;

import fr.mcc.ginco.beans.NodeLabel;
import fr.mcc.ginco.beans.ThesaurusArray;
import fr.mcc.ginco.dao.INodeLabelDAO;
import fr.mcc.ginco.dao.IThesaurusArrayDAO;
import fr.mcc.ginco.exports.result.bean.GincoExportedThesaurus;
import fr.mcc.ginco.exports.result.bean.JaxbList;
import org.springframework.stereotype.Component;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * This class gives methods to import arrays and array labels
 */
@Component("gincoArrayImporter")
public class GincoArrayImporter {

	@Inject
	private INodeLabelDAO nodeLabelDAO;

	@Inject
	private IThesaurusArrayDAO thesaurusArrayDAO;


	/**
	 * This method stores all the array of the thesaurus included in the {@link GincoExportedThesaurus} object given in parameter
	 *
	 * @param exportedThesaurus
	 * @return The list of stored arrays
	 */
	public List<ThesaurusArray> storeArrays(GincoExportedThesaurus exportedThesaurus) {
		List<ThesaurusArray> updatedArrays = new ArrayList<ThesaurusArray>();
		for (ThesaurusArray array : exportedThesaurus.getConceptArrays()) {
			array.setThesaurus(exportedThesaurus.getThesaurus());
			updatedArrays.add(thesaurusArrayDAO.update(array));
		}
		return updatedArrays;
	}

	/**
	 * This method stores all the array labels of the thesaurus included in the {@link GincoExportedThesaurus} object given in parameter
	 *
	 * @param exportedThesaurus
	 * @return The list of stored labels
	 */
	public List<NodeLabel> storeArrayLabels(GincoExportedThesaurus exportedThesaurus) {
		Map<String, JaxbList<NodeLabel>> labels = exportedThesaurus.getConceptArrayLabels();
		List<NodeLabel> updatedLabels = new ArrayList<NodeLabel>();

		if (labels != null && !labels.isEmpty()) {
			Iterator<Map.Entry<String, JaxbList<NodeLabel>>> entries = labels.entrySet().iterator();
			String arrayId = null;
			List<NodeLabel> nodeLabel = null;
			while (entries.hasNext()) {
				Map.Entry<String, JaxbList<NodeLabel>> entry = entries.next();
				//Getting the id of the array
				arrayId = entry.getKey();

				//Getting the NodeLabels for this array
				if (entry.getValue() != null && !entry.getValue().isEmpty()) {
					nodeLabel = entry.getValue().getList();
				}

				for (NodeLabel label : nodeLabel) {
					label.setThesaurusArray(thesaurusArrayDAO.getById(arrayId));
					updatedLabels.add(nodeLabelDAO.update(label));
				}
			}
		}
		return updatedLabels;
	}

}
