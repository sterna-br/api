package org.demoiselle.geo.service;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import static java.lang.Integer.valueOf;
import java.util.logging.Logger;
import static java.util.logging.Logger.getLogger;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import static javax.ws.rs.core.MediaType.APPLICATION_JSON;
import javax.ws.rs.core.Response;
import static javax.ws.rs.core.Response.ok;
import org.demoiselle.geo.dao.TileDAO;
import org.demoiselle.jee.rest.annotation.CacheControl;

/**
 *
 * @author PauloGladson
 */
@Api("Tiles")
@Path("tiles")
@Produces(APPLICATION_JSON)
@Consumes(APPLICATION_JSON)
public class TileREST {

    private static final Logger LOG = getLogger(TileREST.class.getName());

    @Inject
    private TileDAO dao;

//    /**
//     *
//     * @param type
//     * @param zoom
//     * @param coluna
//     * @param linha
//     * @return
//     */
//    @ApiOperation(value = "Cache dos Tiles",
//            notes = "Cache semanal dos Tiles do projeto OpenStreetMap/OpenTopoMap no padrão xyz. Sempre use imagens png. Cache de request 33 segundos. Tipos OSM (OpenStreetMap) ou OTM (OpenTopoMap) ",
//            response = Tile.class,
//            responseContainer = "Object")
//    @ApiResponses(value = {
//        @ApiResponse(code = 412, message = "Tipo não reconhecido, veja documentação, https://dev-sterna.estaleiro.serpro.gov.br/geo/tiles/index.html")})
//    @GET
//    @Path(value = "{type}/{z}/{x}/{y}")
//    @Transactional
//    @Produces(value = "image/png")
//    @CacheControl(value = "max-age=33, must-revalidate, public")
//    public Response download(
//            @ApiParam(value = "Digite o tipo (OSM ou OTM), ex: OSM ", required = true) @PathParam(value = "type") final String type,
//            @ApiParam(value = "Digite o zoom, ex: 14 ", required = true) @PathParam(value = "z") final Integer zoom,
//            @ApiParam(value = "Digite a linha, ex: 5951 ", required = true) @PathParam(value = "x") Integer coluna,
//            @ApiParam(value = "Digite a caluna, ex: 9390.png ", required = true) @PathParam(value = "y") String linha) {
//
//        return ok(dao.getTile(type, zoom, coluna, valueOf(linha.replace(".png", "")))).build();
//    }

    /**
     *
     * @param lat
     * @param lng
     * @param rad
     * @return
     */
    @ApiOperation(value = "Converte as coordenadas topográficas x UTM",
            notes = "Converte as coordenadas Latitude, Longitude e Zoom, no padrão XYZ. Cache de request 33 segundos ",
            response = String.class,
            responseContainer = "Object")
    @GET
    @Transactional
    @CacheControl(value = "max-age=3600, must-revalidate, public")
    @Path(value = "/{lat}/{lng}/{rad}")
    public Response parserToXYZ(
            @ApiParam(value = "Latitude, ex: Curitiba:  -25.414826529374", required = true) @PathParam(value = "lat") final Double lat,
            @ApiParam(value = "Longitude, ex: Curitiba: -49.268403053283", required = true) @PathParam(value = "lng") final Double lng,
            @ApiParam(value = "Raio, ex: 14", required = true) @PathParam(value = "rad") final Double rad) {
        return ok().entity(dao.parserToXYZ(lat, lng, rad.intValue())).build();
    }

}
