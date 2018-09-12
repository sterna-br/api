package org.demoiselle.geo.dao;

import br.gov.serpro.sterna.wrapper.dao.Nodes;
import java.util.List;
import java.util.logging.Logger;
import static java.util.logging.Logger.getLogger;
import br.gov.serpro.sterna.wrapper.pojo.Category;
import br.gov.serpro.sterna.wrapper.pojo.Features;
import javax.inject.Inject;

/**
 *
 * @author PauloGladson
 */
public class NodesDAO {
    
    private static final Logger LOG = getLogger(NodesDAO.class.getName());
    
    @Inject
    private Nodes nodes;

    /**
     *
     * @return
     */
    public List listCategory() {
        return nodes.listCategory();
    }

    /**
     *
     * @return
     */
    public List<Category> summary() {
        return nodes.summary();
    }

    /**
     *
     * @param value
     * @return
     */
    public List listGroup(String value) {
        return nodes.listGroup(value);
    }

    /**
     *
     * @param lat
     * @param lng
     * @param rad
     * @return
     */
    public Features searchByGeo(Double lat, Double lng, Double rad) {
        return nodes.searchByGeo(lat, lng, rad);
    }

    /**
     *
     * @param category
     * @param lat
     * @param lng
     * @param rad
     * @return
     */
    public Features searchByCategory(String category, Double lat, Double lng, Double rad) {
        return nodes.searchByCategory(category, lat, lng, rad);
    }

    /**
     *
     * @param category
     * @param group
     * @param lat
     * @param lng
     * @param rad
     * @return
     */
    public Features searchByCategoryGroup(String category, String group, Double lat, Double lng, Double rad) {
        return nodes.searchByCategoryGroup(category, group, lat, lng, rad);
    }

    /**
     *
     * @param category
     * @param description
     * @return
     */
    public Features searchByCategoryDescription(String category, String description) {
        return nodes.searchByCategoryDescription(category, description);
    }

    /**
     *
     * @param category
     * @param group
     * @param description
     * @return
     */
    public Features searchByCategoryGroupDescription(String category, String group, String description) {
        return nodes.searchByCategoryGroupDescription(category, group, description);
    }

    /**
     *
     * @param description
     * @return
     */
    public Features searchByDescription(String description) {
        return nodes.searchByDescription(description);
    }
    
}
