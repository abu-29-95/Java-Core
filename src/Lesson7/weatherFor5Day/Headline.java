
package Lesson7.weatherFor5Day;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "EffectiveDate",
    "EffectiveEpochDate",
    "Severity",
    "Text",
    "Category",
    "EndDate",
    "EndEpochDate",
    "MobileLink",
    "Link"
})

public class Headline {

    @JsonProperty("EffectiveDate")
    private String effectiveDate;
    @JsonProperty("EffectiveEpochDate")
    private Integer effectiveEpochDate;
    @JsonProperty("Severity")
    private Integer severity;
    @JsonProperty("Text")
    private String text;
    @JsonProperty("Category")
    private String category;
    @JsonProperty("EndDate")
    private String endDate;
    @JsonProperty("EndEpochDate")
    private Integer endEpochDate;
    @JsonProperty("MobileLink")
    private String mobileLink;
    @JsonProperty("Link")
    private String link;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("EffectiveDate")
    public String getEffectiveDate() {
        return effectiveDate;
    }

    @JsonProperty("EffectiveDate")
    public void setEffectiveDate(String effectiveDate) {
        this.effectiveDate = effectiveDate;
    }

    public Headline withEffectiveDate(String effectiveDate) {
        this.effectiveDate = effectiveDate;
        return this;
    }

    @JsonProperty("EffectiveEpochDate")
    public Integer getEffectiveEpochDate() {
        return effectiveEpochDate;
    }

    @JsonProperty("EffectiveEpochDate")
    public void setEffectiveEpochDate(Integer effectiveEpochDate) {
        this.effectiveEpochDate = effectiveEpochDate;
    }

    public Headline withEffectiveEpochDate(Integer effectiveEpochDate) {
        this.effectiveEpochDate = effectiveEpochDate;
        return this;
    }

    @JsonProperty("Severity")
    public Integer getSeverity() {
        return severity;
    }

    @JsonProperty("Severity")
    public void setSeverity(Integer severity) {
        this.severity = severity;
    }

    public Headline withSeverity(Integer severity) {
        this.severity = severity;
        return this;
    }

    @JsonProperty("Text")
    public String getText() {
        return text;
    }

    @JsonProperty("Text")
    public void setText(String text) {
        this.text = text;
    }

    public Headline withText(String text) {
        this.text = text;
        return this;
    }

    @JsonProperty("Category")
    public String getCategory() {
        return category;
    }

    @JsonProperty("Category")
    public void setCategory(String category) {
        this.category = category;
    }

    public Headline withCategory(String category) {
        this.category = category;
        return this;
    }

    @JsonProperty("EndDate")
    public String getEndDate() {
        return endDate;
    }

    @JsonProperty("EndDate")
    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public Headline withEndDate(String endDate) {
        this.endDate = endDate;
        return this;
    }

    @JsonProperty("EndEpochDate")
    public Integer getEndEpochDate() {
        return endEpochDate;
    }

    @JsonProperty("EndEpochDate")
    public void setEndEpochDate(Integer endEpochDate) {
        this.endEpochDate = endEpochDate;
    }

    public Headline withEndEpochDate(Integer endEpochDate) {
        this.endEpochDate = endEpochDate;
        return this;
    }

    @JsonProperty("MobileLink")
    public String getMobileLink() {
        return mobileLink;
    }

    @JsonProperty("MobileLink")
    public void setMobileLink(String mobileLink) {
        this.mobileLink = mobileLink;
    }

    public Headline withMobileLink(String mobileLink) {
        this.mobileLink = mobileLink;
        return this;
    }

    @JsonProperty("Link")
    public String getLink() {
        return link;
    }

    @JsonProperty("Link")
    public void setLink(String link) {
        this.link = link;
    }

    public Headline withLink(String link) {
        this.link = link;
        return this;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    public Headline withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

}
