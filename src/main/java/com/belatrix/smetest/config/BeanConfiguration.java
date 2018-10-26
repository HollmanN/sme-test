package com.belatrix.smetest.config;

import com.belatrix.smetest.factory.ClassifierFactory;
import com.belatrix.smetest.factory.WebClientFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    private final static String CLASSIFIER_PATH = "/static/stanford-corpus-eng-classifier.gz";

    @Bean(name = "classifierFactory")
    public ClassifierFactory classifierFactory() {
        ClassifierFactory factory = new ClassifierFactory();
        factory.setClassifierResourcePath(CLASSIFIER_PATH);
        return factory;
    }

    @Bean(name = "webClientFactory")
    public WebClientFactory webClientFactory() {
        WebClientFactory factory = new WebClientFactory();
        return factory;
    }
}
