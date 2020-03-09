package com.sorting.sortingpayload.model;

import com.sorting.sortingpayload.validator.KeysValueMatch;

import java.util.List;
import java.util.Map;
import java.util.Objects;

@KeysValueMatch
public class SortRequest {
    private List<String> sortKeys;
    private Map<String, List<?>> payload;

    public List<String> getSortKeys() {
        return sortKeys;
    }

    public void setSortKeys(List<String> sortKeys) {
        this.sortKeys = sortKeys;
    }

    public Map<String, List<?>> getPayload() {
        return payload;
    }

    public void setPayload(Map<String, List<?>> payload) {
        this.payload = payload;
    }

    @Override
    public String toString() {
        return "Sort{" +
                "sortKeys=" + sortKeys +
                ", payload=" + payload +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SortRequest sortRequest = (SortRequest) o;
        return Objects.equals(sortKeys, sortRequest.sortKeys) &&
                Objects.equals(payload, sortRequest.payload);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sortKeys, payload);
    }
}
