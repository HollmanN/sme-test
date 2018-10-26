package com.belatrix.smetest.config;

import com.belatrix.smetest.domain.StanfordWordClassifier;
import com.belatrix.smetest.factory.ClassifierFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    private final static String CLASSIFIER_PATH = "/static/stanford-corpus-eng-classifier.gz";

    @Configuration
    public class FactoryBeanAppConfig {

        @Bean(name = "classifier")
        public ClassifierFactory classifierFactory() {
            ClassifierFactory factory = new ClassifierFactory();
            factory.setClassifierResourcePath(CLASSIFIER_PATH);
            return factory;
        }
    }

}
