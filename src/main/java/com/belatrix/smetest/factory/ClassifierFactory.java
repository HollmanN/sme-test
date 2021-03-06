package com.belatrix.smetest.factory;

import com.belatrix.smetest.domain.StanfordWordClassifier;
import edu.stanford.nlp.ie.AbstractSequenceClassifier;
import edu.stanford.nlp.ie.crf.CRFClassifier;
import edu.stanford.nlp.ling.CoreLabel;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.core.io.ClassPathResource;

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.util.zip.GZIPInputStream;

public class ClassifierFactory implements FactoryBean<StanfordWordClassifier> {
    private String classifierResourcePath;

    @Override
    public StanfordWordClassifier getObject() throws Exception {
        InputStream inputStream = new ClassPathResource(classifierResourcePath).getInputStream();
        BufferedInputStream classifierStream = new BufferedInputStream(new GZIPInputStream(inputStream));
        AbstractSequenceClassifier<CoreLabel> classifier = CRFClassifier.getClassifier(classifierStream);
        return new StanfordWordClassifier(classifier);
    }

    @Override
    public Class<?> getObjectType() {
        return StanfordWordClassifier.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }

    public void setClassifierResourcePath(String classifierResourcePath) {
        this.classifierResourcePath = classifierResourcePath;
    }
}
