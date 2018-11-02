package com.belatrix.smetest.domain;

import java.util.List;

public interface WebAnalysisReporter {
    void buildReport(String route, List<WebSiteAnalysis> analyses);
}
