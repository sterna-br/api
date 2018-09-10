package org.demoiselle.geo.service;

import io.swagger.annotations.Contact;
import io.swagger.annotations.ExternalDocs;
import io.swagger.annotations.Info;
import io.swagger.annotations.License;
import io.swagger.annotations.SwaggerDefinition;
import static io.swagger.annotations.SwaggerDefinition.Scheme.HTTPS;
import io.swagger.jaxrs.config.BeanConfig;
import java.util.logging.Logger;
import static java.util.logging.Logger.getLogger;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

/**
 *
 * @author PauloGladson
 */
@SwaggerDefinition(
        info = @Info(
                description = "Serviço de Informações Geoespaciais de Governo. Potencialize o seu negócio com o uso de mapas, sem ser necessário arcar com os altos custos de infraestrutura e pessoal especializado. Padrão Geojson (http://geojson.org) ",
                version = "V1.0.0",
                title = "API do Projeto Sterna",
                termsOfService = "https://sterna.estaleiro.serpro.gov.br",
                contact = @Contact(name = "Equipe Sterna", email = "sterna@serpro.gov.br", url = "https://sterna.estaleiro.serpro.gov.br"),
                license = @License(name = "LGPL v2", url = "https://opensource.org/licenses/LGPL-2.0")),
        consumes = {"application/json"},
        produces = {"application/json"},
        schemes = {HTTPS},
        externalDocs = @ExternalDocs(value = "Sobre o Projeto Sterna", url = "https://sterna.estaleiro.serpro.gov.br")
)
@ApplicationPath("api")
public class ApplicationConfig extends Application {

    private static final Logger LOG = getLogger(ApplicationConfig.class.getName());

    /**
     *
     */
    public ApplicationConfig() {
        BeanConfig beanConfig = new BeanConfig();
        beanConfig.setBasePath("/geo/api");
        beanConfig.setResourcePackage("org.demoiselle.geo.service");
        beanConfig.setScan(true);
    }
}
