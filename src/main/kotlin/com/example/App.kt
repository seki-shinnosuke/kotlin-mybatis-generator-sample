package com.example

import org.mybatis.spring.annotation.MapperScan
import org.mybatis.spring.annotation.MapperScans
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.boot.runApplication

@SpringBootApplication(scanBasePackages=["com.example"])
@MapperScans(MapperScan("com.example.db"))
@ConfigurationPropertiesScan(basePackages = ["com.example"])
class App {
    companion object {
        @JvmStatic fun main(args: Array<String>) {
            runApplication<App>(*args)
        }
    }
}