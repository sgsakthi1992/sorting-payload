package com.sorting.sortingpayload.it;

import com.sorting.sortingpayload.SortingServiceApplication;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.skyscreamer.jsonassert.JSONCompareMode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

import static java.nio.charset.StandardCharsets.UTF_8;
import static org.skyscreamer.jsonassert.JSONAssert.assertEquals;

@SpringBootTest(classes = SortingServiceApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SortingFeatureIT {

    @Autowired
    TestRestTemplate testRestTemplate;

    @Value("classpath:request.json")
    private Resource request;

    @Value("classpath:response.json")
    private Resource expectedResponse;

    @Test
    void testSortingPayload() throws IOException, JSONException {
        // GIVEN
        String expectedResponseJson = new String(expectedResponse.getInputStream().readAllBytes(), UTF_8);
        // WHEN
        String actualResponseJson = testRestTemplate.postForObject("/sort", request, String.class);
        // THEN
        assertEquals(expectedResponseJson, actualResponseJson, JSONCompareMode.STRICT);
    }
}
