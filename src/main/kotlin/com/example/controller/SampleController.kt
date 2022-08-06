package com.example.controller

import com.example.model.response.SampleTestResponse
import com.example.service.SampleService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class SampleController(
    private val sampleService: SampleService
) {

    @GetMapping("/api/v1/sample-test")
    fun selectSampleTest(): SampleTestResponse {
        return sampleService.selectSample()
    }

    @PostMapping("/api/v1/sample-test")
    fun registerSample(): Int {
        return sampleService.registerSample()
    }
}