package com.sorting.sortingpayload.service;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toMap;

@Service
public class SortingService {
    public Map<String, List<?>> sortPayload(
            List<String> sortKeys, Map<String, List<?>> originalPayload) {
        return originalPayload
                .entrySet()
                .stream()
                .collect(toMap(Map.Entry::getKey,
                        e -> sortPayloadValue(sortKeys.contains(e.getKey()), e.getValue())));
    }

    private List<?> sortPayloadValue(boolean isSortable, List<?> unSortedPayloadValue) {
        return isSortable
                ? unSortedPayloadValue.stream()
                .sorted()
                .collect(Collectors.toList())
                : unSortedPayloadValue;
    }
}
