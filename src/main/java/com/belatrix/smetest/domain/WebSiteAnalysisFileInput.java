package com.belatrix.smetest.domain;

public class WebSiteAnalysisFileInput {
    private String inputPath;
    private String inputFileName;

    public WebSiteAnalysisFileInput() {
    }

    public WebSiteAnalysisFileInput(String inputPath, String inputFileName) {
        this.inputPath = inputPath;
        this.inputFileName = inputFileName;
    }

    public String getFullPath() {
        return inputPath + inputFileName;
    }

    public String getInputPath() {
        return inputPath;
    }

    public void setInputPath(String inputPath) {
        this.inputPath = inputPath;
    }

    public String getInputFileName() {
        return inputFileName;
    }

    public void setInputFileName(String inputFileName) {
        this.inputFileName = inputFileName;
    }
}
