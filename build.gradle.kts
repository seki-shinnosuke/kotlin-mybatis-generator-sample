import io.spring.gradle.dependencymanagement.dsl.DependencyManagementExtension
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

object Versions {
    const val jdk = "17"
}

plugins {
    application
    kotlin("jvm") version "1.6.10"
    kotlin("plugin.spring") version "1.6.10"
    id("org.springframework.boot") version "2.6.6"
    id("io.spring.dependency-management") version "1.0.11.RELEASE"
}

allprojects {
    group = "com.example"

    repositories {
        mavenCentral()
        maven("https://plugins.gradle.org/m2/")
    }

    tasks {
        // JSR 305チェックを明示的に有効にする
        withType<KotlinCompile>().configureEach {
            kotlinOptions.freeCompilerArgs = listOf("-Xjsr305=strict", "-java-parameters")
            kotlinOptions.jvmTarget = Versions.jdk
        }
    }
}

apply {
    plugin("kotlin")
    plugin("kotlin-spring")
    plugin("org.springframework.boot")
    plugin("io.spring.dependency-management")
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-stdlib")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin")
    implementation("org.springframework:spring-web")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    // アプリ側でMybatisを利用するためのLibrary
    implementation("org.mybatis.spring.boot:mybatis-spring-boot-starter:2.2.2")
    implementation("org.mybatis.dynamic-sql:mybatis-dynamic-sql:1.4.0")

    runtimeOnly("mysql:mysql-connector-java")

    testImplementation("org.springframework.boot:spring-boot-starter-test") {
        exclude(group = "org.junit.vintage", module = "junit-vintage-engine")
    }
}
// SpringBootBOMを使用して依存関係のバージョン管理
configure<DependencyManagementExtension> {
    imports {
        mavenBom(org.springframework.boot.gradle.plugin.SpringBootPlugin.BOM_COORDINATES)
    }
}

/**
 * MyBatisGenerator設定
 */
val mybatisGenerator: Configuration by configurations.creating
dependencies {
    // mybatis-generator-coreはver1.4.0->1.4.1でファイル名のprefixやDynamicSQLの記述方法に変更があったため選定は注意
    mybatisGenerator("org.mybatis.generator:mybatis-generator-core:1.4.1")
    mybatisGenerator("mysql:mysql-connector-java:8.0.30")
}
task("mybatisGenerator") {
    doLast {
        ant.withGroovyBuilder {
            "taskdef"("name" to "mbgenerator", "classname" to "org.mybatis.generator.ant.GeneratorAntTask", "classpath" to mybatisGenerator.asPath)
        }
        ant.withGroovyBuilder {
            "mbgenerator"("overwrite" to true, "configfile" to "${rootDir}/db/mybatis/generatorConfig.xml", "verbose" to true)
        }
    }
}