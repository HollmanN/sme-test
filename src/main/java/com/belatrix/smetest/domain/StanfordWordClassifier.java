package com.belatrix.smetest.domain;

import edu.stanford.nlp.ie.AbstractSequenceClassifier;
import edu.stanford.nlp.ling.CoreLabel;
import org.springframework.beans.factory.annotation.Autowired;

public class StanfordWordClassifier {
    private final AbstractSequenceClassifier<CoreLabel> classifier;

    @Autowired
    public StanfordWordClassifier(final AbstractSequenceClassifier<CoreLabel> classifier) {
        this.classifier = classifier;
    }

    public AbstractSequenceClassifier<CoreLabel> getClassifier() {
        return classifier;
    }
}
