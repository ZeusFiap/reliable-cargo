package br.com.zeus.reliablecargo.config;

import br.com.zeus.reliablecargo.GoAssistenceApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

public class ServletInitializer extends SpringBootServletInitializer {
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(GoAssistenceApplication.class);
    }
}
