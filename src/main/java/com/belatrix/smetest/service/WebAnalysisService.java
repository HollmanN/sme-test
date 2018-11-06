package com.belatrix.smetest.service;

import com.belatrix.smetest.domain.WebAnalysisReporter;
import com.belatrix.smetest.domain.WebSite;
import com.belatrix.smetest.domain.WebSiteAnalysis;
import com.belatrix.smetest.domain.WordClassification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

@Service
public class WebAnalysisService {
    private final ClassificationService classificationService;
    private final WebScraperService webScraperService;
    private final WebAnalysisReporter webAnalysisReporter;

    @Autowired
    public WebAnalysisService(ClassificationService classificationService, WebScraperService webScraperService,
                              @Qualifier("file-reporter") WebAnalysisReporter webAnalysisReporter) {
        this.classificationService = classificationService;
        this.webScraperService = webScraperService;
        this.webAnalysisReporter = webAnalysisReporter;
    }

    public List<WebSiteAnalysis> analyzeWeb(List<WebSite> webSites){
        List<WebSiteAnalysis> result = new ArrayList<>(webSites.size());

        for(WebSite webSite : webSites){
            result.add(new WebSiteAnalysis(webSite, analyzeWeb(webSite.getUrl())));
        }

        return result;
    }


    private List<WordClassification> analyzeWeb(URL url){
        List<WordClassification> classifications = new ArrayList<>();
        Iterable<String> chunks = webScraperService.dividePage(webScraperService.getPage(url.toString()));
        for (String chunk: chunks) {
            classifications.addAll(classificationService.classifyText(chunk));
        }

        return classifications;
    }
}
