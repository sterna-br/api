package org.demoiselle.geo.dao;

import br.gov.serpro.sterna.wrapper.dao.Ways;
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
public class WaysDAO {

    private static final Logger LOG = getLogger(WaysDAO.class.getName());

    @Inject
    private Ways ways;

    /**
     *
     * @return
     */
    public List listCategory() {
        return ways.listCategory();
    }

    /**
     *
     * @return
     */
    public List<Category> summary() {
        return ways.summary();
    }

    /**
     *
     * @param value
     * @return
     */
    public List listGroup(String value) {
        return ways.listGroup(value);
    }

    /**
     *
     * @param lat
     * @param lng
     * @param rad
     * @return
     */
    public Features searchByGeo(Double lat, Double lng, Double rad) {
        return ways.searchByGeo(lat, lng, rad);
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
        return ways.searchByCategory(category, lat, lng, rad);
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
        return ways.searchByCategoryGroup(category, group, lat, lng, rad);
    }

    /**
     *
     * @param category
     * @param description
     * @return
     */
    public Features searchByCategoryDescription(String category, String description) {
        return ways.searchByCategoryDescription(category, description);
    }

    /**
     *
     * @param category
     * @param group
     * @param description
     * @return
     */
    public Features searchByCategoryGroupDescription(String category, String group, String description) {
        return ways.searchByCategoryGroupDescription(category, group, description);
    }

    /**
     *
     * @param description
     * @return
     */
    public Features searchByDescription(String description) {
        return ways.searchByDescription(description);
    }
}
