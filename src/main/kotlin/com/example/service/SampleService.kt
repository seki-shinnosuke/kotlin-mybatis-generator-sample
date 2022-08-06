package com.example.service

import com.example.db.mapper.SampleTestMapper
import com.example.db.mapper.insertSelective
import com.example.db.mapper.select
import com.example.db.model.SampleTest
import com.example.enumeration.SampleStatus
import com.example.model.response.SampleTestRecord
import com.example.model.response.SampleTestResponse
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Propagation
import org.springframework.transaction.annotation.Transactional
import java.time.LocalDateTime

@Service
class SampleService(
    private val sampleTestMapper: SampleTestMapper
) {

    /**
     * MyBatisGeneratorで生成したマッパーを利用してテーブルに登録されているデータを取得
     */
    @Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = true)
    fun selectSample(): SampleTestResponse {
        val records = sampleTestMapper.select {  }
        return SampleTestResponse(records.map {
            SampleTestRecord(
                it.sampleTestId!!,
                it.personName!!,
                it.sampleStatus!!,
                it.registerDatetime!!,
                it.updateDatetime!!
            )
        })
    }

    /**
     * MyBatisGeneratorで生成したモデルとマッパーを利用してテーブルにデータを登録
     * @return Insertで自動採番されたPK
     */
    @Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = [Throwable::class])
    fun registerSample(): Int {
        val record = SampleTest(
            personName = "test",
            sampleStatus = SampleStatus.YET.name,
            registerDatetime = LocalDateTime.now(),
            updateDatetime = LocalDateTime.now()
        )
        sampleTestMapper.insertSelective(record)
        return record.sampleTestId!!
    }
}