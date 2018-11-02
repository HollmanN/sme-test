package com.belatrix.smetest.service;

import com.belatrix.smetest.domain.WebAnalysisReporter;
import com.belatrix.smetest.domain.WebSiteAnalysis;
import com.belatrix.smetest.util.WebSiteFileUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Qualifier("file-reporter")
public class WebAnalysisFileReporter implements WebAnalysisReporter {
    private final Logger logger = LoggerFactory.getLogger(WebAnalysisReporter.class);

    @Override
    public void buildReport(String route, List<WebSiteAnalysis> analyses) {
        for (WebSiteAnalysis analysis : analyses) {
            try {
                logger.info("Writing CSV report for {}", analysis.getWebSite().getName());
                WebSiteFileUtil.write(analysis, route + analysis.getWebSite().getName() + ".csv");
                logger.info("Finalized CSV report for {}", analysis.getWebSite().getName());
            } catch (Exception e) {
                logger.error("Error generating file report for {}", analysis.getWebSite().getName());
            }
        }
    }
}
