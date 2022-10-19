
package Lesson7.weatherNow;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import javax.annotation.processing.Generated;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "Metric",
    "Imperial"
})
@Generated("jsonschema2pojo")
public class Temperature {

    @JsonProperty("Metric")
    private Metric metric;
    @JsonProperty("Imperial")
    private Imperial imperial;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("Metric")
    public Metric getMetric() {
        return metric;
    }

    @JsonProperty("Metric")
    public void setMetric(Metric metric) {
        this.metric = metric;
    }

    public Temperature withMetric(Metric metric) {
        this.metric = metric;
        return this;
    }

    @JsonProperty("Imperial")
    public Imperial getImperial() {
        return imperial;
    }

    @JsonProperty("Imperial")
    public void setImperial(Imperial imperial) {
        this.imperial = imperial;
    }

    public Temperature withImperial(Imperial imperial) {
        this.imperial = imperial;
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

    public Temperature withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

}
