package com.sorting.sortingpayload.controller;

import com.sorting.sortingpayload.model.SortRequest;
import com.sorting.sortingpayload.service.SortingService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@RestController
public class SortingController {
    private final SortingService sortingService;

    public SortingController(SortingService sortingService) {
        this.sortingService = sortingService;
    }

    @PostMapping("/sort")
    public ResponseEntity<Map<String, List<?>>> sortPayload(@RequestBody @Valid SortRequest sortRequest) {
        return ResponseEntity
                .ok(sortingService
                        .sortPayload(sortRequest.getSortKeys(), sortRequest.getPayload()));
    }
}
