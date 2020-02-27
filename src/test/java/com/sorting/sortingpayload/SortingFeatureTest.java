package com.sorting.sortingpayload;

import com.sorting.sortingpayload.service.SortingService;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;

public class SortingFeatureTest {
    private static final List<String> EMPTY_SORT_KEYS = List.of();
    private static final Map<String, List<?>> EMPTY_PAYLOAD = Map.of();

    private SortingService underTest;

    @BeforeEach
    void setup() {
        underTest = new SortingService();
    }

    @Test
    void test_WhenIInitializeSortingService_ThenSuccessfullyInitialized() {
        assertThat(underTest, notNullValue());
    }

    @Test
    void test_WhenIWantToSort_ThenReturnsSomethingNonNull() {
        // given is in setup method
        // when
        Object result = underTest.sortPayload(EMPTY_SORT_KEYS, EMPTY_PAYLOAD);
        // then
        assertThat(result, notNullValue());
    }

    @Test
    void test_WhenIPassEmptySortKeysAndPayload_ThenReturnsOriginalPayload() {
        // given is in setup method
        // when
        Map<String, List<?>> result = underTest.sortPayload(EMPTY_SORT_KEYS, EMPTY_PAYLOAD);
        // then
        assertThat(result, Matchers.is(EMPTY_PAYLOAD));
    }

    @Test
    void test_WhenIPassSortKeys_ThenReturnsTheSortedPayload() {
        // GIVEN is in the setup method
        List<String> sortKeys = List.of("fruits");
        Map<String, List<?>> originalPayload = Map.of("fruits",
                List.of("watermelon", "apple", "pineapple"));
        Map<String, List<?>> expectedPayload = Map.of("fruits",
                List.of("apple", "pineapple", "watermelon"));
        // WHEN
        Map<String, List<?>> result = underTest
                .sortPayload(sortKeys, originalPayload);
        // THEN
        assertThat(result, is(expectedPayload));
    }

    @Test
    void test_WhenIPassSortKeysWhichAreNotInThePayload_ThenReturnsTheOriginalPayload() {
        // GIVEN is in the setup method
        List<String> sortKeys = List.of("colors");
        Map<String, List<?>> originalPayload = Map.of("fruits",
                List.of("watermelon", "apple", "pineapple"));
        // WHEN
        Map<String, List<?>> result = underTest
                .sortPayload(sortKeys, originalPayload);
        // THEN
        assertThat(result, is(originalPayload));
    }

    @Test
    void test_WhenIPassSortKeysWhichArePartiallyAvailableInPayload_ThenReturnThePartiallySortedPayload(){
        // GIVEN
        List<String> sortKeys = List.of("fruits");
        Map<String, List<?>> originalPayload = Map.of("fruits",
                List.of("watermelon", "apple", "pineapple"), "numbers", List.of(1333, 4, 2431, 7));
        Map<String, List<?>> expectedPayload = Map.of("fruits",
                List.of("apple", "pineapple", "watermelon"), "numbers", List.of(1333, 4, 2431, 7));
        // WHEN
        Map<String, List<?>> result = underTest
                .sortPayload(sortKeys, originalPayload);
        // THEN
        assertThat(result, is(expectedPayload));
    }
}
