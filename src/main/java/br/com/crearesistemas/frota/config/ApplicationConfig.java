package br.com.crearesistemas.frota.config;

import br.com.crearesistemas.frota.entity.Vehicle;
import br.com.crearesistemas.frota.repository.VehicleRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.h2.server.web.WebServlet;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import java.util.Locale;

@Configuration

public class ApplicationConfig implements WebMvcConfigurer {

    private static final Logger log = LoggerFactory.getLogger(ApplicationConfig.class);

    /*Initialization database (mock-data) via bean configuration option example*/
    @Bean
    CommandLineRunner initDatabase(VehicleRepository repository) {
        return args -> {
            log.info("Preloading " + repository.save(new Vehicle("IVZ9453", "29437897859","vw-Gol-1.0")));
            log.info("Preloading " + repository.save(new Vehicle("IVZ9965", "29437897898","fiat-Palio-1.5")));
        };
    }
    /*H2-Console servlet registration via bean configuration option*/
    /*@Bean
    ServletRegistrationBean h2servletRegistration(){
        ServletRegistrationBean registrationBean = new ServletRegistrationBean( new WebServlet());
        registrationBean.addUrlMappings("/console/*");
        return registrationBean;
    }*/

    @Bean
    public LocaleResolver localeResolver() {
        SessionLocaleResolver slr = new SessionLocaleResolver();
        slr.setDefaultLocale(Locale.ENGLISH);
        return slr;
    }

    @Bean
    public LocaleChangeInterceptor localeChangeInterceptor() {
        LocaleChangeInterceptor lci = new LocaleChangeInterceptor();
        lci.setParamName("lang");
        return lci;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(localeChangeInterceptor());
    }


}

