package org.demoiselle.geo.service;

import io.swagger.annotations.Api;
import java.util.concurrent.ExecutorService;
import static java.util.concurrent.Executors.newCachedThreadPool;
import java.util.logging.Logger;
import static java.util.logging.Logger.getLogger;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.container.AsyncResponse;
import javax.ws.rs.container.Suspended;
import static javax.ws.rs.core.MediaType.APPLICATION_JSON;
import javax.ws.rs.core.Response;
import static javax.ws.rs.core.Response.ok;

/**
 *
 * @author PauloGladson
 */
@Api("Auth")
@Path("auth")
@Produces(APPLICATION_JSON)
@Consumes(APPLICATION_JSON)
public class AuthREST {

    private static final Logger LOG = getLogger(AuthREST.class.getName());

    private final ExecutorService executorService = newCachedThreadPool();

    /**
     *
     * @param asyncResponse
     */
    @GET
    @Path(value = "check")
    @Transactional
    public void check(@Suspended final AsyncResponse asyncResponse) {
        executorService.submit(() -> {
            asyncResponse.resume(doCheck());
        });
    }

    private Response doCheck() {
        return ok().entity("{\"status\":\"OK\"}").build();
    }

}
