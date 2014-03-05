package org.musiclibfixer.config;

import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import org.mongodb.morphia.Morphia;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import java.net.UnknownHostException;

import static java.util.Arrays.asList;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"org.musiclibfixer"})
public class SpringApplicationConfig extends WebMvcConfigurerAdapter {

    public @Bean Morphia createMorphia() {
        return new Morphia().mapPackage("org.musiclibfixer");
    }

    public @Bean MongoClient createMongo() throws UnknownHostException {
        MongoCredential credential = MongoCredential.createMongoCRCredential("admin", "music-db", "admin".toCharArray());
        return new MongoClient(new ServerAddress("ds057877.mongolab.com", 57877), asList(credential));
    }

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

    @Bean
    public InternalResourceViewResolver getInternalResourceViewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/");
        resolver.setSuffix(".jsp");
        return resolver;
    }

}
