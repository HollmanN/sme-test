package com.belatrix.smetest.factory;

import com.gargoylesoftware.htmlunit.WebClient;
import org.springframework.beans.factory.FactoryBean;

public class WebClientFactory implements FactoryBean<WebClient> {

    @Override
    public WebClient getObject() throws Exception {
        return new WebClient();
    }

    @Override
    public Class<?> getObjectType() {
        return WebClient.class;
    }

    @Override
    public boolean isSingleton() {
        return false;
    }
}