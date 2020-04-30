package com.example.cachexplore;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class QuoteResponse {

  @JsonProperty("value")
  private Quote quote;

  @JsonProperty("type")
  private String status;

  @Override
  public String toString() {
    return String.format("{ @type = %1$s, quote = '%2$s', status = %3$s }",
      getClass().getName(), getQuote(), getStatus());
  }

  public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Quote getQuote() {
        return quote;
    }

    public void setQuote(Quote quote) {
        this.quote = quote;
    }
}