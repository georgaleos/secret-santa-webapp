package com.elefth.secretsanta.config;

import com.elefth.secretsanta.validation.PersonValidator;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.rest.core.event.ValidatingRepositoryEventListener;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurerAdapter;
import org.springframework.data.rest.webmvc.config.RepositoryRestMvcConfiguration;

/**
 * @author <a href="mailto:george@elefth.com">Eleftheriadis Georgios</a>
 */
//@Configuration
//@Import(RepositoryRestMvcConfiguration.class)
//public class RestRepositoryConfig extends RepositoryRestConfigurerAdapter {
public class RestRepositoryConfig {

//    @Override
//    public void configureValidatingRepositoryEventListener(ValidatingRepositoryEventListener validatingListener) {
//        validatingListener.addValidator("beforeCreate", new PersonValidator());
//    }

}
