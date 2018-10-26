package com.belatrix.smetest.service;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.google.common.base.Splitter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WebScraperService {

    private final WebClient webClient;
    private static final Splitter SPLITTER = Splitter.fixedLength(200).omitEmptyStrings();

    @Autowired
    public WebScraperService(WebClient webClient) {
        this.webClient = webClient;
    }

    public HtmlPage getPage(String url) {
        HtmlPage page = null;
        webClient.getOptions().setCssEnabled(false);
        webClient.getOptions().setJavaScriptEnabled(false);
        try {
            page = webClient.getPage(url);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return page;
    }

    public Iterable<String> dividePage(HtmlPage page) {
        String pageAsText = page.asText();
        Iterable<String> chunks = null;
        try {
            chunks = SPLITTER.split(pageAsText);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return chunks;
    }
}
