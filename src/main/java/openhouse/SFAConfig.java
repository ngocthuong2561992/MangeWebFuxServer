package openhouse;

import openhouse.handlers.UsersHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.reactive.config.CorsRegistry;
import org.springframework.web.reactive.config.EnableWebFlux;
import org.springframework.web.reactive.config.WebFluxConfigurer;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
@EnableWebFlux
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class SFAConfig implements WebFluxConfigurer {
    /**
     * Routes for matching show requests
     */

    @Bean
    public RouterFunction<ServerResponse> routeShow(UsersHandler usersHandler) {
        return RouterFunctions
                .route(RequestPredicates.GET("/user"), usersHandler::allUser)
                .andRoute(RequestPredicates.GET("/user/{id}"), usersHandler::byUserId)
                .andRoute(RequestPredicates.POST("/user"), usersHandler::insertUser)
                .andRoute(RequestPredicates.PUT("/user/{id}"), usersHandler::updateUser)
                .andRoute(RequestPredicates.DELETE("/user/{id}"), usersHandler::deleteUser);
    }

//    @Override
//    public void addCorsMappings(CorsRegistry registry) {
//        registry.addMapping("/user/**")
//                .allowedMethods("*")
//                .allowedMethods("PUT", "DELETE")
//                .allowCredentials(true).maxAge(3600);
//    }
}
