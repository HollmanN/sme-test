package com.belatrix.smetest.controller;

import com.belatrix.smetest.domain.WebSite;
import com.belatrix.smetest.domain.WebSiteAnalysis;
import com.belatrix.smetest.service.WebAnalysisService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/analyze")
public class WebAnalysisController {
    private final WebAnalysisService webAnalysisService;

    public WebAnalysisController(WebAnalysisService webAnalysisService) {
        this.webAnalysisService = webAnalysisService;
    }

    @PostMapping
    public List<WebSiteAnalysis> analyze(@RequestBody List<WebSite> webSites) {
        return webAnalysisService.analyzeWeb(webSites);
    }
}
