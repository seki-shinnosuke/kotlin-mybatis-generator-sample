package com.example.model.response

import com.fasterxml.jackson.annotation.JsonFormat
import java.time.LocalDateTime

data class SampleTestResponse(
    val sampleTests: List<SampleTestRecord>
)

data class SampleTestRecord(
    val sampleTestId: Int,
    var personName: String,
    var sampleStatus: String,
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    var registerDatetime: LocalDateTime,
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    var updateDatetime: LocalDateTime
)