package com.belatrix.smetest.controller;

import com.belatrix.smetest.domain.WebAnalysisReporter;
import com.belatrix.smetest.domain.WebSite;
import com.belatrix.smetest.domain.WebSiteAnalysis;
import com.belatrix.smetest.domain.WebSiteAnalysisFileInput;
import com.belatrix.smetest.service.WebAnalysisService;
import com.belatrix.smetest.util.WebSiteFileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/analyze")
public class WebAnalysisController {
    private final WebAnalysisService webAnalysisService;
    private final WebAnalysisReporter webAnalysisReporter;

    @Autowired
    public WebAnalysisController(WebAnalysisService webAnalysisService, @Qualifier("file-reporter") WebAnalysisReporter webAnalysisReporter) {
        this.webAnalysisService = webAnalysisService;
        this.webAnalysisReporter = webAnalysisReporter;
    }

    @PostMapping
    public List<WebSiteAnalysis> analyze(@RequestBody List<WebSite> webSites) {
        List<WebSiteAnalysis> results = webAnalysisService.analyzeWeb(webSites);
        return results;
    }

    @PostMapping("/file")
    public List<WebSiteAnalysis> analyze(@RequestBody WebSiteAnalysisFileInput input) {
        List<WebSiteAnalysis> results = webAnalysisService.analyzeWeb(WebSiteFileUtil.getWebsitesFromFile(input.getFullPath()));
        webAnalysisReporter.buildReport(input.getInputPath(), results);
        return results;
    }
}
