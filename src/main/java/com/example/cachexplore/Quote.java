package com.example.cachexplore;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import org.springframework.util.ObjectUtils;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Quote {

    private Long id;

    private String quote;

    @Override
    public boolean equals(Object obj) {

        if (this == obj) {
            return true;
        }

        if (!(obj instanceof Quote)) {
            return false;
        }

        Quote that = (Quote) obj;

        return ObjectUtils.nullSafeEquals(this.getId(), that.getId());
    }

    @Override
    public int hashCode() {

        int hashValue = 17;

        hashValue = 37 * hashValue + ObjectUtils.nullSafeHashCode(getId());

        return hashValue;
    }

    @Override
    public String toString() {
        return getQuote();
    } 

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getQuote() {
        return quote;
    }

    public void setQuote(String quote) {
        this.quote = quote;
    }
}