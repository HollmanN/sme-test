package com.belatrix.smetest.service;

import com.belatrix.smetest.domain.StanfordWordClassifier;
import com.belatrix.smetest.domain.WordClassification;
import edu.stanford.nlp.ling.CoreAnnotations;
import edu.stanford.nlp.ling.CoreLabel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClassificationService {
    private final StanfordWordClassifier stanfordWordClassifier;

    public ClassificationService(@Autowired StanfordWordClassifier stanfordWordClassifier) {
        this.stanfordWordClassifier = stanfordWordClassifier;
    }

    public List<WordClassification> classifyText(String text) {
        List<WordClassification> wordCategories = new ArrayList<>();
        try {
            List<List<CoreLabel>> out = stanfordWordClassifier.getClassifier().classify(text);
            for (List<CoreLabel> sentence : out) {
                for (CoreLabel word : sentence) {
                    String classification = word.get(CoreAnnotations.AnswerAnnotation.class);
                    if (!classification.equals("O")) {
                        wordCategories.add(new WordClassification(word.word(), word.get(CoreAnnotations.AnswerAnnotation.class)));
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return wordCategories;
    }
}
