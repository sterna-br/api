package org.demoiselle.geo.dao;

import java.util.logging.Logger;
import static java.util.logging.Logger.getLogger;

/**
 *
 * @author PauloGladson
 */
public class TileDAO {

    private static final Logger LOG = getLogger(TileDAO.class.getName());

    /**
     *
     * @param type
     * @param zoom
     * @param coluna
     * @param linha
     * @return
     */
    public byte[] getTile(String type, Integer zoom, Integer coluna, Integer linha) {
        return null;
    }

    /**
     *
     * @param lat
     * @param lon
     * @param zoom
     * @return
     */
    public String parserToXYZ(final double lat, final double lon, final int zoom) {

        return null;
    }

}
