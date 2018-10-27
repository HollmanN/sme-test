package com.belatrix.smetest.service;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.google.common.base.Splitter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.Instant;

@Service
public class WebScraperService {

    private final WebClient webClient;
    private static final Splitter SPLITTER = Splitter.fixedLength(200).omitEmptyStrings();
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    public WebScraperService(WebClient webClient) {
        this.webClient = webClient;
    }

    public HtmlPage getPage(String url) {
        HtmlPage page = null;
        webClient.getOptions().setCssEnabled(false);
        webClient.getOptions().setJavaScriptEnabled(false);
        try {
            logger.info("Fetching {}", url);
            Instant start = Instant.now();
            page = webClient.getPage(url);
            Instant finish = Instant.now();
            long timeElapsed = Duration.between(start, finish).toMillis();
            logger.info("Total time {}", timeElapsed);
        } catch (Exception e) {
            logger.info("Error fetching page {}", url);
        }
        return page;
    }

    public Iterable<String> dividePage(HtmlPage page) {
        logger.info("Processing content from {}", page.getBaseURL().toString());
        String pageAsText = page.asText();
        Iterable<String> chunks = null;
        try {
            chunks = SPLITTER.split(pageAsText);
        } catch (Exception e) {
            logger.info("Error dividing page {}", page.getBaseURL());
        }
        logger.info("Split process successful");
        return chunks;
    }
}
