/*
 * Auto-generated file. Created by MyBatis Generator
 */
package com.example.db.mapper

import java.sql.JDBCType
import java.time.LocalDateTime
import org.mybatis.dynamic.sql.AliasableSqlTable
import org.mybatis.dynamic.sql.util.kotlin.elements.column

object SampleTestDynamicSqlSupport {
    val sampleTest = SampleTest()

    val sampleTestId = sampleTest.sampleTestId

    val personName = sampleTest.personName

    val sampleStatus = sampleTest.sampleStatus

    val registerDatetime = sampleTest.registerDatetime

    val updateDatetime = sampleTest.updateDatetime

    class SampleTest : AliasableSqlTable<SampleTest>("sample_test", ::SampleTest) {
        val sampleTestId = column<Int>(name = "sample_test_id", jdbcType = JDBCType.INTEGER)

        val personName = column<String>(name = "person_name", jdbcType = JDBCType.VARCHAR)

        val sampleStatus = column<String>(name = "sample_status", jdbcType = JDBCType.CHAR)

        val registerDatetime = column<LocalDateTime>(name = "register_datetime", jdbcType = JDBCType.TIMESTAMP)

        val updateDatetime = column<LocalDateTime>(name = "update_datetime", jdbcType = JDBCType.TIMESTAMP)
    }
}