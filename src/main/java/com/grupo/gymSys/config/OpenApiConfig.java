package com.grupo.gymSys.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;
import io.swagger.v3.oas.models.tags.Tag;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI gymSysOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("GymSys API")
                        .description("API REST voltada para o gerenciamento de uma rede de academias.")
                        .version("v1.0")
                        .contact(new Contact()
                                .name("Rafael Garcia Trigo")
                                .email("rafael_garcia@educadventista.org")
                                .url("https://github.com/rafaGarciaT/gymSys-projeto-api"))
                        .license(new License()
                                .name("MIT License")
                                .url("https://opensource.org/licenses/MIT"))
                )
                .addServersItem(new Server()
                                .url("http://localhost:8080")
                                .description("Servidor local")
                )
                .addServersItem(new Server()
                        .url("https://gymsys-projeto-api.onrender.com/")
                        .description("Servidor do Render (requer deploy)"))
                .tags(List.of(
                    new Tag().name("Usuários").description("Gerenciamento de usuários"),
                    new Tag().name("Funcionários").description("Gerenciamento de funcionários"),
                    new Tag().name("Unidades").description("Gerenciamento de unidades"),
                    new Tag().name("Aparelhos").description("Gerenciamento de aparelhos"),
                    new Tag().name("Unidade-Aparelhos").description("Gerenciamento da associação de um aparelho á uma unidade")
                ));
    }
}
