package indi.axikuazei.pigletter.config;

import org.springframework.boot.web.server.ConfigurableWebServerFactory;
import org.springframework.boot.web.server.ErrorPage;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;

@Configuration
public class ServletConfig {
    @Bean
    public WebServerFactoryCustomizer<ConfigurableWebServerFactory> webServerFactoryCustomizer() {
        return new WebServerFactoryCustomizer<>() {
            @Override
            public void customize(ConfigurableWebServerFactory factory) {
                // factory.setPort(8081);
                ErrorPage errorPage = new ErrorPage(HttpStatus.NOT_FOUND, "/index.html");
                factory.addErrorPages(errorPage);
            }
        };
    }
}