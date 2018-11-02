package com.belatrix.smetest.util;

import com.belatrix.smetest.domain.WebSite;
import com.belatrix.smetest.domain.WebSiteAnalysis;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class WebSiteFileUtil {
    private final static Logger logger = LoggerFactory.getLogger(WebSiteFileUtil.class);

    public static List<WebSite> getWebsitesFromFile(String route) {
        List<WebSite> result = new ArrayList<>();

        try (CSVReader reader = new CSVReader(new FileReader(route))) {
            String[] line;
            while ((line = reader.readNext()) != null) {
                result.add(new WebSite(line[0], new URL(line[1])));
            }
        } catch (IOException e) {
            logger.error("Error reading websites from file {}", route);
            e.printStackTrace();
        }

        return result;
    }

    public static void write(WebSiteAnalysis analysis, String route) {
        try (CSVWriter writer = new CSVWriter(new FileWriter(route))) {
            writer.writeAll(analysis.asCSV());
        } catch (Exception e) {
            logger.error("Error writing report");
        }
    }
}
