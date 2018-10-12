package com.exa.tool.types;

import com.fasterxml.jackson.annotation.JsonProperty;

public class JSonData {

    @JsonProperty("_id")
    private JsonDataId id;

    @JsonProperty("STD_TEXT_ID")
    private String stdTextId;

    @JsonProperty("STD_UNIV_CRAWL_ID")
    private String stdUnivCrawId;

    @JsonProperty("UNITID")
    private String unitid;

    @JsonProperty("NAME")
    private String name;

    @JsonProperty("COURSE_URL")
    private String courseUrl;

    @JsonProperty("TITLE")
    private String title;

    @JsonProperty("TITLE_MODIF")
    private String titleModif;

    @JsonProperty("DESCRIPTION")
    private String description;

    @JsonProperty("COURSE_TYPE")
    private String courseType;

    @JsonProperty("DEGREE_TYPE")
    private String degreeType;

    @JsonProperty("CIPCODE")
    private String cipcode;

    @JsonProperty("RATING")
    private String rating;

    @JsonProperty("URL_EXT_TEXT")
    private String urlExtText;

    @JsonProperty("TEXT_SUMMARY")
    private String textSummary;

    @JsonProperty("TEXT_MODIF")
    private String textModif;

    @JsonProperty("TEXT_SUMMARY_MODIF")
    private String textSummaryModif;

    @JsonProperty("KEYWORD")
    private String keyword;

    @JsonProperty("ACTIVE")
    private String active;

    @JsonProperty("UPDATED_DATE")
    private String updateDate;

    public JSonData(){

    }

    public JSonData(JsonDataId id, String stdTextId, String stdUnivCrawId, String unitid, String name, String courseUrl, String title, String titleModif, String description, String courseType, String degreeType, String cipcode, String rating, String urlExtText, String textSummary, String textModif, String textSummaryModif, String keyword, String active, String updateDate) {
        this.id = id;
        this.stdTextId = stdTextId;
        this.stdUnivCrawId = stdUnivCrawId;
        this.unitid = unitid;
        this.name = name;
        this.courseUrl = courseUrl;
        this.title = title;
        this.titleModif = titleModif;
        this.description = description;
        this.courseType = courseType;
        this.degreeType = degreeType;
        this.cipcode = cipcode;
        this.rating = rating;
        this.urlExtText = urlExtText;
        this.textSummary = textSummary;
        this.textModif = textModif;
        this.textSummaryModif = textSummaryModif;
        this.keyword = keyword;
        this.active = active;
        this.updateDate = updateDate;
    }

    public JsonDataId getId() {
        return id;
    }

    public void setId(JsonDataId id) {
        this.id = id;
    }

    public String getStdTextId() {
        return stdTextId;
    }

    public void setStdTextId(String stdTextId) {
        this.stdTextId = stdTextId;
    }

    public String getStdUnivCrawId() {
        return stdUnivCrawId;
    }

    public void setStdUnivCrawId(String stdUnivCrawId) {
        this.stdUnivCrawId = stdUnivCrawId;
    }

    public String getUnitid() {
        return unitid;
    }

    public void setUnitid(String unitid) {
        this.unitid = unitid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCourseUrl() {
        return courseUrl;
    }

    public void setCourseUrl(String courseUrl) {
        this.courseUrl = courseUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitleModif() {
        return titleModif;
    }

    public void setTitleModif(String titleModif) {
        this.titleModif = titleModif;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCourseType() {
        return courseType;
    }

    public void setCourseType(String courseType) {
        this.courseType = courseType;
    }

    public String getDegreeType() {
        return degreeType;
    }

    public void setDegreeType(String degreeType) {
        this.degreeType = degreeType;
    }

    public String getCipcode() {
        return cipcode;
    }

    public void setCipcode(String cipcode) {
        this.cipcode = cipcode;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getUrlExtText() {
        return urlExtText;
    }

    public void setUrlExtText(String urlExtText) {
        this.urlExtText = urlExtText;
    }

    public String getTextSummary() {
        return textSummary;
    }

    public void setTextSummary(String textSummary) {
        this.textSummary = textSummary;
    }

    public String getTextModif() {
        return textModif;
    }

    public void setTextModif(String textModif) {
        this.textModif = textModif;
    }

    public String getTextSummaryModif() {
        return textSummaryModif;
    }

    public void setTextSummaryModif(String textSummaryModif) {
        this.textSummaryModif = textSummaryModif;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }

    public String getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(String updateDate) {
        this.updateDate = updateDate;
    }
}
