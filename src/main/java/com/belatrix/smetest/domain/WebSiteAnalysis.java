package com.belatrix.smetest.domain;

import java.util.List;

public class WebSiteAnalysis {
    private WebSite webSite;
    private List<WordClassification> contentClassification;

    public WebSiteAnalysis(WebSite webSite) {
        this.webSite = webSite;
    }

    public WebSiteAnalysis(WebSite webSite, List<WordClassification> contentClassification) {
        this.webSite = webSite;
        this.contentClassification = contentClassification;
    }

    public WebSite getWebSite() {
        return webSite;
    }

    public void setWebSite(WebSite webSite) {
        this.webSite = webSite;
    }

    public List<WordClassification> getContentClassification() {
        return contentClassification;
    }

    public void setContentClassification(List<WordClassification> contentClassification) {
        this.contentClassification = contentClassification;
    }

    @Override
    public String toString() {
        return "WebSiteAnalysis{" +
                "webSite=" + webSite +
                ", contentClassification=" + contentClassification +
                '}';
    }
}
