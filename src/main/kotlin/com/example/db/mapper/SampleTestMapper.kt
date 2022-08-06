/*
 * Auto-generated file. Created by MyBatis Generator
 */
package com.example.db.mapper

import com.example.db.mapper.SampleTestDynamicSqlSupport.personName
import com.example.db.mapper.SampleTestDynamicSqlSupport.registerDatetime
import com.example.db.mapper.SampleTestDynamicSqlSupport.sampleStatus
import com.example.db.mapper.SampleTestDynamicSqlSupport.sampleTest
import com.example.db.mapper.SampleTestDynamicSqlSupport.sampleTestId
import com.example.db.mapper.SampleTestDynamicSqlSupport.updateDatetime
import com.example.db.model.SampleTest
import org.apache.ibatis.annotations.InsertProvider
import org.apache.ibatis.annotations.Mapper
import org.apache.ibatis.annotations.Result
import org.apache.ibatis.annotations.ResultMap
import org.apache.ibatis.annotations.Results
import org.apache.ibatis.annotations.SelectKey
import org.apache.ibatis.annotations.SelectProvider
import org.apache.ibatis.type.JdbcType
import org.mybatis.dynamic.sql.insert.render.InsertStatementProvider
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider
import org.mybatis.dynamic.sql.util.SqlProviderAdapter
import org.mybatis.dynamic.sql.util.kotlin.CountCompleter
import org.mybatis.dynamic.sql.util.kotlin.DeleteCompleter
import org.mybatis.dynamic.sql.util.kotlin.KotlinUpdateBuilder
import org.mybatis.dynamic.sql.util.kotlin.SelectCompleter
import org.mybatis.dynamic.sql.util.kotlin.UpdateCompleter
import org.mybatis.dynamic.sql.util.kotlin.mybatis3.countFrom
import org.mybatis.dynamic.sql.util.kotlin.mybatis3.deleteFrom
import org.mybatis.dynamic.sql.util.kotlin.mybatis3.insert
import org.mybatis.dynamic.sql.util.kotlin.mybatis3.selectDistinct
import org.mybatis.dynamic.sql.util.kotlin.mybatis3.selectList
import org.mybatis.dynamic.sql.util.kotlin.mybatis3.selectOne
import org.mybatis.dynamic.sql.util.kotlin.mybatis3.update
import org.mybatis.dynamic.sql.util.mybatis3.CommonCountMapper
import org.mybatis.dynamic.sql.util.mybatis3.CommonDeleteMapper
import org.mybatis.dynamic.sql.util.mybatis3.CommonUpdateMapper

@Mapper
interface SampleTestMapper : CommonCountMapper, CommonDeleteMapper, CommonUpdateMapper {
    @InsertProvider(type=SqlProviderAdapter::class, method="insert")
    @SelectKey(statement=["SELECT LAST_INSERT_ID()"], keyProperty="row.sampleTestId", before=false, resultType=Int::class)
    fun insert(insertStatement: InsertStatementProvider<SampleTest>): Int

    @SelectProvider(type=SqlProviderAdapter::class, method="select")
    @Results(id="SampleTestResult", value = [
        Result(column="sample_test_id", property="sampleTestId", jdbcType=JdbcType.INTEGER, id=true),
        Result(column="person_name", property="personName", jdbcType=JdbcType.VARCHAR),
        Result(column="sample_status", property="sampleStatus", jdbcType=JdbcType.CHAR),
        Result(column="register_datetime", property="registerDatetime", jdbcType=JdbcType.TIMESTAMP),
        Result(column="update_datetime", property="updateDatetime", jdbcType=JdbcType.TIMESTAMP)
    ])
    fun selectMany(selectStatement: SelectStatementProvider): List<SampleTest>

    @SelectProvider(type=SqlProviderAdapter::class, method="select")
    @ResultMap("SampleTestResult")
    fun selectOne(selectStatement: SelectStatementProvider): SampleTest?
}

fun SampleTestMapper.count(completer: CountCompleter) =
    countFrom(this::count, sampleTest, completer)

fun SampleTestMapper.delete(completer: DeleteCompleter) =
    deleteFrom(this::delete, sampleTest, completer)

fun SampleTestMapper.deleteByPrimaryKey(sampleTestId_: Int) =
    delete {
        where { sampleTestId isEqualTo sampleTestId_ }
    }

fun SampleTestMapper.insert(row: SampleTest) =
    insert(this::insert, row, sampleTest) {
        map(personName) toProperty "personName"
        map(sampleStatus) toProperty "sampleStatus"
        map(registerDatetime) toProperty "registerDatetime"
        map(updateDatetime) toProperty "updateDatetime"
    }

fun SampleTestMapper.insertSelective(row: SampleTest) =
    insert(this::insert, row, sampleTest) {
        map(personName).toPropertyWhenPresent("personName", row::personName)
        map(sampleStatus).toPropertyWhenPresent("sampleStatus", row::sampleStatus)
        map(registerDatetime).toPropertyWhenPresent("registerDatetime", row::registerDatetime)
        map(updateDatetime).toPropertyWhenPresent("updateDatetime", row::updateDatetime)
    }

private val columnList = listOf(sampleTestId, personName, sampleStatus, registerDatetime, updateDatetime)

fun SampleTestMapper.selectOne(completer: SelectCompleter) =
    selectOne(this::selectOne, columnList, sampleTest, completer)

fun SampleTestMapper.select(completer: SelectCompleter) =
    selectList(this::selectMany, columnList, sampleTest, completer)

fun SampleTestMapper.selectDistinct(completer: SelectCompleter) =
    selectDistinct(this::selectMany, columnList, sampleTest, completer)

fun SampleTestMapper.selectByPrimaryKey(sampleTestId_: Int) =
    selectOne {
        where { sampleTestId isEqualTo sampleTestId_ }
    }

fun SampleTestMapper.update(completer: UpdateCompleter) =
    update(this::update, sampleTest, completer)

fun KotlinUpdateBuilder.updateAllColumns(row: SampleTest) =
    apply {
        set(personName) equalToOrNull row::personName
        set(sampleStatus) equalToOrNull row::sampleStatus
        set(registerDatetime) equalToOrNull row::registerDatetime
        set(updateDatetime) equalToOrNull row::updateDatetime
    }

fun KotlinUpdateBuilder.updateSelectiveColumns(row: SampleTest) =
    apply {
        set(personName) equalToWhenPresent row::personName
        set(sampleStatus) equalToWhenPresent row::sampleStatus
        set(registerDatetime) equalToWhenPresent row::registerDatetime
        set(updateDatetime) equalToWhenPresent row::updateDatetime
    }

fun SampleTestMapper.updateByPrimaryKey(row: SampleTest) =
    update {
        set(personName) equalToOrNull row::personName
        set(sampleStatus) equalToOrNull row::sampleStatus
        set(registerDatetime) equalToOrNull row::registerDatetime
        set(updateDatetime) equalToOrNull row::updateDatetime
        where { sampleTestId isEqualTo row.sampleTestId!! }
    }

fun SampleTestMapper.updateByPrimaryKeySelective(row: SampleTest) =
    update {
        set(personName) equalToWhenPresent row::personName
        set(sampleStatus) equalToWhenPresent row::sampleStatus
        set(registerDatetime) equalToWhenPresent row::registerDatetime
        set(updateDatetime) equalToWhenPresent row::updateDatetime
        where { sampleTestId isEqualTo row.sampleTestId!! }
    }