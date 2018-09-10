package org.demoiselle.geo.service;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
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
import br.gov.serpro.sterna.wrapper.pojo.Features;
import java.util.List;
import org.demoiselle.geo.dao.NodesDAO;
import org.demoiselle.jee.rest.annotation.CacheControl;

/**
 *
 * @author PauloGladson
 */
@Api("Nodes")
@Path("nodes")
@Produces(APPLICATION_JSON)
@Consumes(APPLICATION_JSON)
public class NodesREST {

    private static final Logger LOG = getLogger(NodesREST.class.getName());

    @Inject
    private NodesDAO dao;

    /**
     *
     * @return
     */
    @ApiOperation(
            value = "Lista de Categorias",
            notes = "Lista de Strings com as categorias. Cache de request 3600 segundos",
            response = List.class,
            responseContainer = "Object")
    @GET
    @Transactional
    @CacheControl(value = "max-age=3600, must-revalidate, public")
    @Path(value = "/category")
    public Response listCategory() {
        return ok().entity(dao.listCategory()).build();
    }

    /**
     *
     * @param category
     * @param description
     * @return
     */
    @ApiOperation(value = "Lista de POI por categorias e nome",
            notes = "Lista de Nodes. Cache de request 3600 segundos",
            response = Features.class,
            responseContainer = "Object")
    @GET
    @Transactional
    @CacheControl(value = "max-age=3600, must-revalidate, public")
    @Path(value = "/{category}/{description}")
    public Response searchByCategoryDescription(
            @ApiParam(value = "Digite o nome da categoria, ex: amenity", required = true) @PathParam(value = "category") final String category,
            @ApiParam(value = "Digite nome que deseja buscar na categoria, ex: banco ", required = true) @PathParam(value = "description") final String description) {
        return ok().entity(dao.searchByCategoryDescription(category, description)).build();
    }

    /**
     *
     * @param category
     * @param group
     * @param description
     * @return
     */
    @ApiOperation(value = "Lista de POI por categorias, grupo e nome",
            notes = "Lista de Nodes. Cache de request 3600 segundos",
            response = Features.class,
            responseContainer = "Object")
    @GET
    @Transactional
    @CacheControl(value = "max-age=3600, must-revalidate, public")
    @Path(value = "/{category}/{group}/{description}")
    public Response searchByCategoryGroupDescription(
            @ApiParam(value = "Digite o nome da categoria, ex: amenity", required = true) @PathParam(value = "category") final String category,
            @ApiParam(value = "Digite o nome do grupo, ex: atm", required = true) @PathParam(value = "group") final String group,
            @ApiParam(value = "Digite nome que deseja buscar no grupo/categoria, ex: banco ", required = true) @PathParam(value = "description") final String description) {
        return ok().entity(dao.searchByCategoryGroupDescription(category, group, description)).build();
    }

    /**
     *
     * @param category
     * @param lat
     * @param lng
     * @param rad
     * @return
     */
    @ApiOperation(value = "Lista de POIs por categorias e informações geograficas",
            notes = "Lista de Nodes. Cache de request 3600 segundos ",
            response = Features.class,
            responseContainer = "Object")
    @GET
    @Transactional
    @CacheControl(value = "max-age=3600, must-revalidate, public")
    @Path(value = "/{category}/{lat}/{lng}/{rad}")
    public Response searchByCategory(
            @ApiParam(value = "Digite o nome da categoria, ex: amenity", required = true) @PathParam(value = "category") final String category,
            @ApiParam(value = "Latitude, ex: Curitiba:  -25.414826529374", required = true) @PathParam(value = "lat") final Double lat,
            @ApiParam(value = "Longitude, ex: Curitiba: -49.268403053283", required = true) @PathParam(value = "lng") final Double lng,
            @ApiParam(value = "Raio, ex: 14", required = true) @PathParam(value = "rad") final Double rad) {
        return ok().entity(dao.searchByCategory(category, lat, lng, rad)).build();
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
    @ApiOperation(value = "Lista de POIs por categorias, grupo e informações geograficas",
            notes = "Lista de Nodes. Cache de request 3600 segundos ",
            response = Features.class,
            responseContainer = "Object")
    @GET
    @Transactional
    @CacheControl(value = "max-age=3600, must-revalidate, public")
    @Path(value = "/{category}/{group}/{lat}/{lng}/{rad}")
    public Response searchByCategoryGroup(
            @ApiParam(value = "Digite o nome da categoria, ex: amenity", required = true) @PathParam(value = "category") final String category,
            @ApiParam(value = "Digite o nome do grupo, ex: atm", required = true) @PathParam(value = "group") final String group,
            @ApiParam(value = "Latitude, ex: Curitiba:  -25.414826529374", required = true) @PathParam(value = "lat") final Double lat,
            @ApiParam(value = "Longitude, ex: Curitiba: -49.268403053283", required = true) @PathParam(value = "lng") final Double lng,
            @ApiParam(value = "Raio, ex: 14", required = true) @PathParam(value = "rad") final Double rad) {
        return ok().entity(dao.searchByCategoryGroup(category, group, lat, lng, rad)).build();
    }

    /**
     *
     * @param category
     * @return
     */
    @ApiOperation(value = "Lista grupos de uma categoria",
            notes = "Lista de grupos. Cache de request 3600 segundos",
            response = Features.class,
            responseContainer = "Object")
    @GET
    @Transactional
    @CacheControl(value = "max-age=3600, must-revalidate, public")
    @Path(value = "/group/{category}")
    public Response listGroup(
            @ApiParam(value = "Digite o nome da categoria, ex: amenity", required = true) @PathParam(value = "category") final String category) {
        return ok().entity(dao.listGroup(category)).build();
    }

    /**
     *
     * @return
     */
    @ApiOperation(value = "Resumo geral dos POIs Nodes",
            notes = "Lista de Categoria seus grupos com a quantidades de POIs. Cache de request 3600 segundos",
            response = Features.class,
            responseContainer = "Object")
    @GET
    @Transactional
    @CacheControl(value = "max-age=3600, must-revalidate, public")
    @Path(value = "/summary")
    public Response summary() {
        return ok().entity(dao.summary()).build();
    }

    /**
     *
     * @param texto
     * @return
     */
    @ApiOperation(value = "Busca textual(FullTextSerach) na base, use com parcimônia ",
            notes = "Busca em todos os campos de texto da base usando técnicas de FullTextSerach. Cache de request 3600 segundos",
            response = Features.class,
            responseContainer = "Object")
    @GET
    @Transactional
    @CacheControl(value = "max-age=3600, must-revalidate, public")
    @Path(value = "/fts/{texto}")
    public Response fts(
            @ApiParam(value = "Digite o nome, ex: SERPRO", required = true) @PathParam(value = "texto") final String texto) {
        return ok().entity(dao.searchByDescription(texto)).build();
    }

}
